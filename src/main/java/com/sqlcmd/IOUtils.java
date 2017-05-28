package com.sqlcmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtils {

    public static String inputString(){

        String s = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            s = bufferedReader.readLine();
        } catch (IOException e) {
            s = "";
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }

        return s;

    }

    public static void println(String text) {
        System.out.println(text);
    }

}
