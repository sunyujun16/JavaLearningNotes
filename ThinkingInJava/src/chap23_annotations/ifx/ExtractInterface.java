package chap23_annotations.ifx;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 作用于类型
@Retention(RetentionPolicy.SOURCE) // 只在源码级别有效
public @interface ExtractInterface {
    String interfaceName() default "-!!-";
}
