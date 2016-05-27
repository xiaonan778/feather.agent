package com.feather.f3.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class RuntimeUtil {

	static final Logger logger = Logger.getLogger(RuntimeUtil.class);

    public static ShellResult execute(String cmd) throws IOException {
        logger.info("Start to execute command: " + cmd);
        // -----------------------------------------------------------------------------------------------------------------------------
        StringWriter sb = new StringWriter();
        boolean success = true;
        // -----------------------------------------------------------------------------------------------------------------------------
        Process process = Runtime.getRuntime().exec(cmd);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        // -----------------------------------------------------------------------------------------------------------------------------
        if (process.exitValue() != 0) success = false;
        BufferedReader input = new BufferedReader(new InputStreamReader(success ? process.getInputStream() : process.getErrorStream()));
        String str = "";
        while ((str = input.readLine()) != null) {
            sb.append(str + "\n");
        }
        logger.info("Command execute status '" + process.exitValue() + "', response: " + sb.toString());
        // -----------------------------------------------------------------------------------------------------------------------------
        input.close();
        process.destroy();
        // -----------------------------------------------------------------------------------------------------------------------------
        return new ShellResult(process.exitValue(), sb.toString());
    }
}
