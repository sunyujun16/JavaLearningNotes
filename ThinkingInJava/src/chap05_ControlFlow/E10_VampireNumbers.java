package chap05_ControlFlow;

public class E10_VampireNumbers {
    private static int comp(String s1, String s2) {
        int sim = 0;
        char[] s1Array = new char[4];
        char[] s2Array = new char[4];

        for (int i = 0; i < 4; i++) {
            s1Array[i] = s1.charAt(i);
        }

        for (int i = 0; i < 4; i++) {
            s2Array[i] = s2.charAt(i);
        }

        for (int j = 0; j < 4; j++) {
            char c1 = s1Array[j];

            for (int k = 0; k < 4; k++) {
                char c2 = s2Array[k];
                if (c2 == 'z') continue;
                if (c1 == c2) {
                    sim += 1;
                    s2Array[k] = 'z';
                    break;
                }
            }

        }

        return sim;
    }

    private static void vampire() {

        for (int pre = 10; pre < 99; pre++) {
            for( int suf = 0; suf < 99; suf++){

//                // 调试断点
//                if (pre==21 && suf == 60) {
//                    System.out.println("pause here.");
//                }

                if (pre % 10 == 0 && suf % 10 == 0) continue;

                int i = pre * suf;


                if (!(pre * suf >= 1000 && pre * suf <= 9999)) continue;

                // s1是乘积, s2是组合.
                String s1 = String.valueOf(i);
                String s2 = String.valueOf(pre) + String.valueOf(suf);

                // 将二者进行对比, 如果一致, 则输出.
                int sim = comp(s1, s2);

                if (sim == 4) {
                    System.out.println("Got one: " + i +" --- " + pre + " * " + suf);
                }

            }

        }

    }

    public static void main(String[] args) {
        vampire();
    }
}
