package com.jinze.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PythonProcessFactory {
    private static Logger Log = LoggerFactory.getLogger(PythonProcessFactory.class);


    public static String[] pyProcess(String[] arguments) {
        Log.info("调用python脚本命令："+ Arrays.toString(arguments));
        Process process = null;
        try {
            StringBuffer res = new StringBuffer();
            process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            while ((line = in.readLine()) != null) {
                res.append(line).append(",");
            }
            in.close();
            int re = process.waitFor();
            Log.info("调用python程序状态：" + ((re == 0) ? "success" : "failed"));
            return res.toString().split(",");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            return null;
        }finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    public static String[] pyProcess(StringBuffer arguments) {
        Log.info("调用python脚本命令：" + arguments.toString());
        Process process = null;
        try {
            StringBuffer res = new StringBuffer();
            process = Runtime.getRuntime().exec(String.valueOf(arguments));
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            while ((line = in.readLine()) != null) {
                res.append(line).append(",");
            }
            in.close();
            int re = process.waitFor();
            Log.info("调用python程序状态：" + ((re == 0) ? "success" : "failed"));
            return res.toString().split(",");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            Log.error(e.getMessage());
            return null;
        }finally {
            if (process != null) {
                process.destroy();
            }
        }
    }
}
