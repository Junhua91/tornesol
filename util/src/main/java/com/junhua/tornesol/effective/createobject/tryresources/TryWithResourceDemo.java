package com.junhua.tornesol.effective.createobject.tryresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourceDemo {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            br.readLine();
        } catch (IOException e) {
        }
    }
}
