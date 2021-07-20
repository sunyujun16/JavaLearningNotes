package chap19_typeinfo.pets;

import onjava.TypeCounter;

// 看到这儿真是不得不赞叹作者的代码之简洁. 太厉害了.
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        Pets.stream()
                .limit(20)
                .peek(counter::count)
                .forEach(p -> System.out.print(
                        p.getClass().getSimpleName() + " "));
        System.out.println("\n" + counter);
    }
}
