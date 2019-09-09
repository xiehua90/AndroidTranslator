package com.xh.translate;


import com.xh.translate.ui.Demo9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class MainEntry {

    public static void main(String[] args) {
        new Demo9();
    }


    private static void charsetTest() {
        String msg = "恭喜您!中华人民共和国你们好";
        List<String> charsets = Arrays.asList("GBK", "BIG5", "UTF-8");
        try {
            for (String inputCharset : charsets) {
                for (String outCharset : charsets) {
                    String string = new String(msg.getBytes(inputCharset), outCharset);
                    System.out.println(String.format("%s  %s: %s", inputCharset, outCharset, string));
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
