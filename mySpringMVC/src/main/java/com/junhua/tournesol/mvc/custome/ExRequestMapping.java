package com.junhua.tournesol.mvc.custome;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExRequestMapping {
    String value() default "";
}
