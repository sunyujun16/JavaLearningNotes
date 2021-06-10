package chap20_generics;

// Exploring the meaning of wildcards
class Wildcards {
    // Raw argument:
    static void rawArgs(Holder holder, Object arg) {
    //- holder.set(arg);
    // warning: [unchecked] unchecked call to set(T)
    // as a member of the raw type Holder
    // holder.set(arg);
    // ^
    // where T is a type-variable:
    // T extends Object declared in class Holder
    // 1 warning
    // Can't do this; don't have any 'T':
    // T t = holder.get();
    // OK, but type information is lost:
        Object obj = holder.get();
    }

    // Like rawArgs(), but errors instead of warnings:
    static void
    unboundedArg(Holder<?> holder, Object arg) {
    //- holder.set(arg);
    // error: method set in class Holder<T>
    // cannot be applied to given types;
    // holder.set(arg);
    // ^
    // required: CAP#1
    // found: Object
    // reason: argument mismatch;
    // Object cannot be converted to CAP#1
    // where T is a type-variable:
    // T extends Object declared in class Holder
    // where CAP#1 is a fresh type-variable:
    // CAP#1 extends Object from capture of ?
    // 1 error
    // Can't do this; don't have any 'T':
    // T t = holder.get();
        // OK, but type information is lost:
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }

    static <T>
    T wildSubtype(Holder<? extends T> holder, T arg) {
        //- holder.set(arg);
        // error: method set in class Holder<T#2>
        // cannot be applied to given types;
        // holder.set(arg);
        // ^
        // required: CAP#1
        // found: T#1
        // reason: argument mismatch;
        // T#1 cannot be converted to CAP#1
        // where T#1,T#2 are type-variables:
        // T#1 extends Object declared in method
        // <T#1>wildSubtype(Holder<? extends T#1>,T#1)
        // T#2 extends Object declared in class Holder
        // where CAP#1 is a fresh type-variable:
        // CAP#1 extends T#1 from
        // capture of ? extends T#1
        // 1 error
        return holder.get();
    }

    static <T>
    void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        //- T t = holder.get();
        // error: incompatible types:
        // CAP#1 cannot be converted to T
        // T t = holder.get();
        // ^
        // where T is a type-variable:
        // T extends Object declared in method
        // <T>wildSupertype(Holder<? super T>,T)
        // where CAP#1 is a fresh type-variable:
        // CAP#1 extends Object super:
        // T from capture of ? super T
        // 1 error
        // OK, but type information is lost:
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>();
        // Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;
        rawArgs(raw, lng); // 第二个参数没用
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);
        unboundedArg(raw, lng); // 第二个参数没用
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);
        //- Object r1 = exact1(raw); // 参数错误
        // warning: [unchecked] unchecked method invocation:
        // method exact1 in class Wildcards is applied
        // to given types
        // Object r1 = exact1(raw);
        // ^
        // required: Holder<T>
        // found: Holder
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>exact1(Holder<T>)
        // warning: [unchecked] unchecked conversion
        // Object r1 = exact1(raw);
        // ^
        // required: Holder<T>
        // found: Holder
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>exact1(Holder<T>)
        // 2 warnings
        Long r2 = exact1(qualified); // 准确的Long类型
        Object r3 = exact1(unbounded); //Must return Object,只有它安全.
        Long r4 = exact1(bounded); // 用Long接收是安全的.
        //- Long r5 = exact2(raw, lng); // raw和lng类型不匹配.
        // warning: [unchecked] unchecked method invocation:
        // method exact2 in class Wildcards is
        // applied to given types
        // Long r5 = exact2(raw, lng);
        // ^
        // required: Holder<T>,T
        // found: Holder,Long
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>exact2(Holder<T>,T)
        // warning: [unchecked] unchecked conversion
        // Long r5 = exact2(raw, lng);
        // ^
        // required: Holder<T>
        // found: Holder
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>exact2(Holder<T>,T)
        // 2 warnings
        Long r6 = exact2(qualified, lng); // qualified和lng匹配
        //- Long r7 = exact2(unbounded, lng); // 还是不匹配, 编译器说:
        // 鬼才知道你给的 <?> 和 Long 能不能匹配上?
        // error: method exact2 in class Wildcards
        // cannot be applied to given types;
        // Long r7 = exact2(unbounded, lng);
        // ^
        // required: Holder<T>,T
        // found: Holder<CAP#1>,Long
        // reason: inference variable T has
        // incompatible bounds
        // equality constraints: CAP#1
        // lower bounds: Long
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>exact2(Holder<T>,T)
        // where CAP#1 is a fresh type-variable:
        // CAP#1 extends Object from capture of ?
        // 1 error
        //- Long r8 = exact2(bounded, lng); // 同上,exact2要求精确匹配.
        // error: method exact2 in class Wildcards
        // cannot be applied to given types;
        // Long r8 = exact2(bounded, lng);
        // ^
        // required: Holder<T>,T
        // found: Holder<CAP#1>,Long
        // reason: inference variable T
        // has incompatible bounds
        // equality constraints: CAP#1
        // lower bounds: Long
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>exact2(Holder<T>,T)
        // where CAP#1 is a fresh type-variable:
        // CAP#1 extends Long from
        // capture of ? extends Long
        // 1 error
        //- Long r9 = wildSubtype(raw, lng); // raw类型错误
        // warning: [unchecked] unchecked method invocation:
        // method wildSubtype in class Wildcards
        // is applied to given types
        // Long r9 = wildSubtype(raw, lng);
        // ^
        // required: Holder<? extends T>,T
        // found: Holder,Long
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>wildSubtype(Holder<? extends T>,T)
        // warning: [unchecked] unchecked conversion
        // Long r9 = wildSubtype(raw, lng);
        // ^
        // required: Holder<? extends T>
        // found: Holder
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>wildSubtype(Holder<? extends T>,T)
        // 2 warnings

        // wildSubtype用不到arg
        Long r10 = wildSubtype(qualified, lng); // 精准匹配, 没问题
        // OK, but can only return Object:
        Object r11 = wildSubtype(unbounded, lng); //不确定返回类型,只能Object
        Long r12 = wildSubtype(bounded, lng); // 这次用Long接收是安全的.
        //- wildSupertype(raw, lng); //raw是一个"全类型",而不是"某类型",注意区分.
        // warning: [unchecked] unchecked method invocation:
        // method wildSupertype in class Wildcards
        // is applied to given types
        // wildSupertype(raw, lng);
        // ^
        // required: Holder<? super T>,T
        // found: Holder,Long
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>wildSupertype(Holder<? super T>,T)
        // warning: [unchecked] unchecked conversion
        // wildSupertype(raw, lng);
        // ^
        // required: Holder<? super T>
        // found: Holder
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>wildSupertype(Holder<? super T>,T)
        // 2 warnings
        wildSupertype(qualified, lng);  // 精准匹配, 没问题
//        wildSupertype(unbounded, lng); //和set无关.参数不匹配
        //- wildSupertype(unbounded, lng); //
        // error: method wildSupertype in class Wildcards
        // cannot be applied to given types;
        // wildSupertype(unbounded, lng);
        // ^
        // required: Holder<? super T>,T
        // found: Holder<CAP#1>,Long
        // reason: cannot infer type-variable(s) T
        // (argument mismatch; Holder<CAP#1>
        // cannot be converted to Holder<? super T>)
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>wildSupertype(Holder<? super T>,T)
        // where CAP#1 is a fresh type-variable:
        // CAP#1 extends Object from capture of ?
        // 1 error
        //- wildSupertype(bounded, lng);
        // error: method wildSupertype in class Wildcards
        // cannot be applied to given types;
        // wildSupertype(bounded, lng);
        // ^
        // required: Holder<? super T>,T
        // found: Holder<CAP#1>,Long
        // reason: cannot infer type-variable(s) T
        // (argument mismatch; Holder<CAP#1>
        // cannot be converted to Holder<? super T>)
        // where T is a type-variable:
        // T extends Object declared in
        // method <T>wildSupertype(Holder<? super T>,T)
        // where CAP#1 is a fresh type-variable:
        // CAP#1 extends Long from capture of
        // ? extends Long
        // 1 error
    }
}

public class A08_Wildcards {
}
