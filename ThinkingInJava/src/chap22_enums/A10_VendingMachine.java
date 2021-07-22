package chap22_enums;

import java.util.*;
import java.io.IOException;
import java.util.function.*;
import java.nio.file.*;
import java.util.stream.*;

enum Category {
    MONEY(Input.NICKEL, Input.DIME,
            Input.QUARTER, Input.DOLLAR),
    ITEM_SELECTION(Input.TOOTHPASTE, Input.CHIPS,
            Input.SODA, Input.SOAP),
    QUIT_TRANSACTION(Input.ABORT_TRANSACTION),
    SHUT_DOWN(Input.STOP);
    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    private static EnumMap<Input, Category> categories =
            new EnumMap<>(Input.class);

    static { // 首先, 把每个Input作为键, 其对应的类别作为值, 存储到一个EnumMap.
        for (Category c : Category.class.getEnumConstants())
            for (Input type : c.values)
                categories.put(type, c);
    } // categories is initialized now.

    // 然后, 就可以借助这个Map, 用具体的input获取其所属类别.
    public static Category categorize(Input input) {
        return categories.get(input); // 按照键获取对应的category.
    }
}

class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {TRANSIENT} // Tagging enum

    enum State {
        RESTING {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY; // 切状态.
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount())
                            System.out.println(
                                    "Insufficient money for " + selection);
                        else state = DISPENSING; // 钱够了, 切下一个状态.
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE; // 不买了, 找零钱.
                        break;
                    case SHUT_DOWN: // 终止.
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) { // 注意这里传参了
            @Override
            void next() {
                System.out.println("here is your " + selection); // 出货.
                amount -= selection.amount(); // 算零钱.
                state = GIVING_CHANGE; // 找钱.
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) { // 注意这里传参了
            @Override
            void next() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount); // 找钱
                    amount = 0; // 钱池清零.
                }
                state = RESTING; // 任务完成, 休息.
            }
        },
        TERMINAL {
            @Override
            void output() {
                System.out.println("Halted");
            }
        };
        private boolean isTransient = false; // 注意, 默认是false, 非static.

        State() {
        }

        State(StateDuration trans) {
            if (trans == StateDuration.TRANSIENT)
                isTransient = true;
            else System.out.println("Wrong StateDuration!!!!!!!!!!!");
        }

        void next(Input input) {
            throw new RuntimeException("Only call " +
                    "next(Input input) for non-transient state");
        }

        void next() {
            throw new RuntimeException(
                    "Only call next() for " +
                            "StateDuration.TRANSIENT state");
        }

        void output() {
            System.out.println(amount);
        }
    }

    // 这里因为把isTransient当作静态的变量而懵逼了, 实际上每个state都有
    // 不同的isTransient, 每次对state赋值时, 它的行为和isTransient都变了.
    static void run(Supplier<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.get());
            while (state.isTransient) {
                state.next(); // 瞬时状态, 出货和找钱不需要input干预, 自动循环.
            }
            state.output();
        }
    }

//    public static void main(String[] args) {
//        Supplier<Input> gen = new RandomInputSupplier(); // 健全测试
//        if (args.length == 1)
//            gen = new FileInputSupplier(args[0]);
//        run(gen);
//    }
}

// run it somewhere outside.
class RunVM1 {
    public static void main(String[] args) {
        args = new String[]{"ThinkingInJava/src/chap22_enums/" +
                "VendingMachineInput.txt"};

        Supplier<Input> gen = new RandomInputSupplier(); // 健全测试
        if (args.length == 1)
            gen = new FileInputSupplier(args[0]);
        VendingMachine.run(gen); // 当gen是健全测试版本时, 由于run内部的while
        // 循环一直调用gen.get(), 所以会一直运行, 来测试程序的健壮性.
    }
}

// For a basic sanity check:
class RandomInputSupplier implements Supplier<Input> {
    @Override
    public Input get() {
        return Input.randomSelection();
    }
}

// Create Inputs from a file of ';'-separated strings:
// ThinkingInJava/src/chap22_enums/VendingMachineInput.txt
class FileInputSupplier implements Supplier<Input> {
    private Iterator<String> input;

    FileInputSupplier(String fileName) {
        try {
            input = Files.lines(Paths.get(fileName))
                    .skip(0) // Skip the comment line
                    .flatMap(s -> Arrays.stream(s.split(";")))
                    .map(String::trim)
                    .collect(Collectors.toList())
                    .iterator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Input get() {
        if (!input.hasNext())
            return null;
        return Enum.valueOf(Input.class, input.next().trim());
    }
}

public class A10_VendingMachine {
}
