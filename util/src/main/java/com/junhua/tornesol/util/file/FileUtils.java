package com.junhua.tornesol.util.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileUtils {


    public static void handleFile(String pathIn, String pathOut, Function<List<String>, String> fun) throws IOException {

        List<String> lines = readFile(pathIn);

        File outPutFile = new File(pathOut);

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(outPutFile));
            writeToFile(fun.apply(lines), bw);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static List<String> readFile(String path) throws IOException {
        List<String> result = new ArrayList<>();
        File file = new File(path);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {  //读取到的内容给line变量
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

        return result;
    }

    private static void writeToFile(String line, BufferedWriter bw) throws IOException {
        try {
            bw.write(line + "\n");
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
