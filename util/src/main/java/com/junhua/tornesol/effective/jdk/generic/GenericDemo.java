package com.junhua.tornesol.effective.jdk.generic;

public class GenericDemo {

    public static void main(String[] args) {

        Request<String> request = new Request<>();
        request.setContent("String request");


        Request<Integer> request2 = new Request<>();
        request2.setContent(123);

        Process process = new Process();
        process.process(request);
        process.process(request2);
    }
}
