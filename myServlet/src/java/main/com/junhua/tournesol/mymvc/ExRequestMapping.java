package main.com.junhua.tournesol.mymvc;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExRequestMapping {
    String value() default "";
}
