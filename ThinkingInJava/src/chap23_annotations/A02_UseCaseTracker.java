package chap23_annotations;

import java.util.*;
import java.util.stream.*;
import java.lang.reflect.*;

class UseCaseTracker {
    public static void
    trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case " +
                        uc.id() + "\n " + uc.description());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }

        System.out.println();

        useCases.forEach(i ->
                System.out.println("Missing use case " + i));
    }

    public static void main(String[] args) {
        List<Integer> useCases = IntStream.range(47, 53)
                .boxed().collect(Collectors.toList());

        trackUseCases(useCases, PasswordUtils.class);
    }
}

public class A02_UseCaseTracker {
}
