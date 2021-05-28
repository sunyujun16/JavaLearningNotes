package chap18_strings;

public class A02_WitherStringBuilder {
    public String implicit(String[] fields) {
        String result = "";
        for (String field : fields) {
            result += field;
        }
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (String field : fields) {
            result.append(field);
        }
        return result.toString();
    }
}
/*implicit
public java.lang.String implicit(java.lang.String[]);
0: ldc #2 // String
2: astore_2
3: aload_1
4: astore_3
5: aload_3
6: arraylength
7: istore 4
9: iconst_0
10: istore 5
12: iload 5
14: iload 4
16: if_icmpge 51
19: aload_3
20: iload 5
22: aaload
23: astore 6
25: new #3 // StringBuilder
28: dup
29: invokespecial #4 // StringBuilder.""
32: aload_2
33: invokevirtual #5 // StringBuilder.append:(String)
36: aload 6
38: invokevirtual #5 // StringBuilder.append:(String;)
41: invokevirtual #6 // StringBuilder.toString:()
44: astore_2
45: iinc 5, 1
48: goto 12
51: aload_2
52: areturn
 */

/* explicit
public java.lang.String explicit(java.lang.String[]);
0: new #3 // StringBuilder
3: dup
4: invokespecial #4 // StringBuilder.""
7: astore_2
8: aload_1
9: astore_3
10: aload_3
11: arraylength
12: istore 4
14: iconst_0
15: istore 5
17: iload 5
19: iload 4
21: if_icmpge 43
24: aload_3
25: iload 5
27: aaload
28: astore 6
30: aload_2
31: aload 6
33: invokevirtual #5 // StringBuilder.append:(String)
36: pop
37: iinc 5, 1
40: goto 17
43: aload_2
44: invokevirtual #6 // StringBuilder.toString:()
47: areturn
 */