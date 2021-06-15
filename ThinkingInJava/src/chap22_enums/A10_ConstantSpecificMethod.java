package chap22_enums;

import java.lang.reflect.Constructor;
import java.util.*;
import java.text.*;

enum ConstantSpecificMethod {
    DATE_TIME (1){
        @Override
        String getInfo() {
            return DateFormat.getDateInstance()
                            .format(new Date());
        }
    },
    CLASSPATH (1){
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION (1) {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    private ConstantSpecificMethod(int n){
        // 没啥用,就是试试构造器语法和抽象方法能不能共存.
    }

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values())
            System.out.println(csm.getInfo());
    }
}

public class A10_ConstantSpecificMethod {
}
