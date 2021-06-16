package chap23_annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface SimulatingNull {
    int id() default -1;

    String description() default "";
}

public class A02_SimulatingNull {
}
