package chap23_annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface UseCase {
    int id();

    String description() default "no description";
}

public class A01_UseCase {
}
