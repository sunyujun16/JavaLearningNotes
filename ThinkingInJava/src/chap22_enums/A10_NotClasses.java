package chap22_enums;

enum LikeClasses {
    WINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior1");
        }
    },
    BLINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior2");
        }
    },
    NOD {
        @Override
        void behavior() {
            System.out.println("Behavior3");
        }
    };
    abstract void behavior();
}
class NotClasses {
    // void f1(LikeClasses.WINKEN instance) {} // Nope
}

public class A10_NotClasses {
}
