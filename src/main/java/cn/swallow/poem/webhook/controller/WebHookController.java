package cn.swallow.poem.webhook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @author swallow
 * @create 2020/1/4
 * @description
 */
@RestController
@RequestMapping("/doc")
public class WebHookController {
    public static final String SHELL = "sh /data/shell_script/update-docsify.sh";

    @RequestMapping("/update")
    public String ok() throws InterruptedException{
        exec(SHELL);
        return "ok";
    }

    public static String exec(String command) throws InterruptedException {
        String returnString = "";
        Process pro = null;
        Runtime runTime = Runtime.getRuntime();
        if (runTime == null) {
            System.err.println("Create runtime false!");
        }
        try {
            pro = runTime.exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            PrintWriter output = new PrintWriter(new OutputStreamWriter(pro.getOutputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                returnString = returnString + line + "\n";
            }
            input.close();
            output.close();
            pro.destroy();
        } catch (IOException ex) {
        }
        System.out.println("push success!!!");
        return returnString;
    }

}
