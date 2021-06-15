package chap22_enums;

// The witches in the land of Oz
enum OzWitch {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");
    private String description;

    // Constructor must be package or private access:
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values())
            System.out.println(
                    witch + ": " + witch.getDescription());
    }
}

enum MyTry{
    One(1),
    Two(2),
    Three(3);
    private int realNumb;

    MyTry(int n){
        realNumb = n;
    }

    int getRealNumb(){
        return realNumb;
    }

    public static void main(String[] args) {
        for (MyTry mt:MyTry.values()) {
            System.out.println(mt + ": " + mt.getRealNumb());
        }
    }

}

public class A02_OzWitch {
}
