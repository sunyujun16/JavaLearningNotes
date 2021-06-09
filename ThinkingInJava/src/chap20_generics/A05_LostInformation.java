package chap20_generics;

import java.util.*;

class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSITION, MOMENTUM> {
}

class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();

        // 只能找到类型的占位标识符,却不能识别实际类型.
        System.out.println(Arrays.toString(
                list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(
                map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(
                quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(
                p.getClass().getTypeParameters()));
    }
}

public class A05_LostInformation {
}
