package main.com.junhua.tournesol.mymvc;


@ExRequestMapping("/ext")
@ExtController
public class ControllerTest {

    @ExRequestMapping("/test")
    public String test() {
        return "index";
    }
}