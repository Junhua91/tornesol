package com.junhua.tornesol.effective.createobject.tryresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchDemo {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        try {
            String s = br.readLine();
        } finally {
            br.close();
        }
    }
}
