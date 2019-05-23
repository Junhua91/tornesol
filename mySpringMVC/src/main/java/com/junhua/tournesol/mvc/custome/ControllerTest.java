package com.junhua.tournesol.mvc.custome;


@ExRequestMapping("/ext")
@ExtController
public class ControllerTest {

    @ExRequestMapping("/test")
    public String test() {
        return "index";
    }
}