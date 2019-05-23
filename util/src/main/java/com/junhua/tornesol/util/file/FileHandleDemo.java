package com.junhua.tornesol.util.file;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileHandleDemo {

    public static void main(String[] args) {
        nlgFileHandle();
    }

    public static void nlgFileHandle() {

        Function<List<String>, String> nlgFunction = (lines) -> {

            List<String> lists = lines.stream().map(line -> {
                String[] elements = line.split("\t");
//                String sql = String.format("(%s,%s,'%s')", elements[0], elements[1], elements[2]);
                String newSql = "update tb_seo_nlg_desc set description = '"+ elements[2]+ "' where hotword_id ="+elements[0]+" and nlp_type_id= "+elements[1]+";";
                return newSql;
            }).collect(Collectors.toList());
            String s = StringUtils.join(lists, "\n");
            return s;

        };

        try {
            FileUtils.handleFile("/Users/nali/Desktop/nlg_text_1.txt", "/Users/nali/Desktop/nlg_text_select.txt", nlgFunction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
