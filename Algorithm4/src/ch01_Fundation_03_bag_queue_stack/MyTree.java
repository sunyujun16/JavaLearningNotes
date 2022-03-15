package ch01_Fundation_03_bag_queue_stack;

/* 练习题没啥意思, 自己出个题吧...
::题目::
实现一个二叉树结构, 基本元素Item泛型处理.
由双分支链表组成, 每个节点包含一个Item变量, 和两个子节点的引用变量.+ item_num.
树对象的成员包括一个根结点的引用, 以及节点总量.
树的特性:
    - 左小右大; (字符串等比较方法还没学, 先用Int类型试验吧)
    - 修改: Item采用自定义类型, 包含三个成员属性: 姓名, 年龄, 性别. 添加时 逐个判断(重构方法), 以定树中位置.
    - 能够随意位置增删改查;
    - 允许重复元素, 但需要统计重复元素数量; (节点内增加一个计数变量)
 */

// 其实方法应该写在接口里面, 而又由于Item应该交给用户自由定义, 所以方法不应该直接操作Item的成员,
// 所以这样的话, 用户自定义Item类型的时候就必须让它实现一个比较大小的接口, 这个接口应该由我来提供. 这样就能在实现
// 代码中做到对Item进行排序.同理如果还想查看Item的详细信息, 同样要用户自己实现接口中的showInfo() (只是举例)
// 但是有些老子还TM没学呢, 先这样吧. 哪个傻逼说没学java就能直接学<<算法4>>的? 草他妈的坑爹. --2021.3.16

// 时隔一年，回头再看，代码简直是搞笑，哈哈。完全是Python式的Java代码。

// 综上, 我要简化一下逻辑, 直接在本文件给出所有代码, 并Xjb定义一个Item类型. 遗憾的是这样实现代码就扩展性不强了.
// 算了, 还是写个接口吧...

import java.lang.reflect.Method;

/* Item要实现的接口
    1 compare方法, 比较两个Item, 返回布尔值.
    2 showInfo方法, 输出指定Item的所有信息.
    3 ...待定
 */
interface Item {
    // 用于比较两个自定义类型, 具体实现由用户按照其喜欢的数据类型来定义, 返回1, 0, 或-1 三个值.
    public int compare(Item item2);

    // 用于显示数据类型包含的具体信息, 实现由用户自行决定.
    public void showInfo(Object i);
}

// 用户"老子"自定义的Item, 且重写了接口, 虽然数据类型定义起来比较自由, 但感觉对用户的要求有点高啊...还得让人家
// 实现我的接口...害, 先这样吧. 目前看来, 自由和简洁, 二者不可兼得啊...
class MyItem implements Item {
    private String name;
    private int age;
    private String gender;

    private MyItem() {
        name = "无名";
        age = 0;
        gender = "未定义";
    }

    @Override
    public int compare(Item item2) {
        MyItem itemB = (MyItem) item2;

        int cm_name = name.compareTo(itemB.name);
        int cm_age = age - itemB.age;
        int cm_gender = gender.compareTo(itemB.gender);

        // 短路比较, name优先.
        if ((cm_name > 0) || (cm_age > 0) || (cm_gender > 0)) return 1;
        if ((0 == cm_name) && (cm_age == cm_name) && (cm_gender == 0)) return 0;
        return -1;
    }

    @Override
    public void showInfo(Object item1) {
        MyItem item = new MyItem();
        item = (MyItem) item1;
        System.out.println("Name: " + item.name + "\nAge: " + item.age + "\nGender" + item.gender);
    }
}


public class MyTree<T extends Item> {
    // 定义成员变量(一些私有变量)
    private int N = 0; // 节点数量(注意不是元素数量)
    private Node root; // 根结点

    // 定义节点类(嵌套类)
    private class Node {
        T item;
        Node daddyNode;
        Node leftNode;
        Node rightNode;

        public Node() {
        }

        public Node(T item, Node leftNode, Node rightNode) {
            this.item = item;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

    }

    /* 确定接口包含哪些方法
        1 添加, 删除 add(tree, item), delete
        2 查找, 修改 search(item), modify(item_target, item_new)
        3 判断是否为空 isEmpty
        4 获取节点数量(保存在树对象中), getSize
        5 显示节点信息, showInfo
        6 重写toString.
        7 构造方法
     */

    private boolean isEmpty() {
        return this.N == 0;
    }

    private int getSize() {
        return N;
    }

    private void showInfo(Item item) {
    }

    // 实现方法
    private void add(MyTree<T> tree, T item) {
        Node node = new Node();
        node.item = item;

        // 操蛋了, 实现里不能调用Item的方法... 妈的泛型的方法不该在底层调用. 咋办呢...fuck
        // 现在面临的情况是: 我要在底层实现中对"泛型"进行比较, 那么连类型都不知道又咋能比较呢.
        // 我想到的是通过用户定义的方法, 可是用户自定义的方法怎么应用到...哈,函数式编程!!! 把函数作为实现的参数
        // 函数的内容还是由用户来定义. 可是我他妈还没学到函数式编程呢...完了, 玩脱了.搁置吧,草.精力还是放在Java上.
        if (tree.isEmpty()) {
            tree.root = node;
        } else {
            Node tree_node = tree.root;
            while (tree_node != null) {
                int compare = item.compare(tree_node.item);
                if (compare >= 1) {
                    tree_node = tree_node.rightNode;
                    if (tree_node == null) tree_node = new Node();
                    // 拉鸡巴倒吧，懒得写了。
                    continue;
                } else if (compare == 0){

                }
            }
        }
        ;
        this.N++;
    }

    // 测试用例
    public static void main(String[] args) {
        MyTree tree = new MyTree();

    }

}













