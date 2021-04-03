package chap08_ReusingClasses;

class Amphibian{
    private String name;

    protected void swim(){
        System.out.println("All swim");
    }

    protected void walk(){
        System.out.println("All walk");
    }

    protected void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "I am " + name;
    }
}

class Frog extends Amphibian{
    public Frog(String name) {
        super.setName(name);
    }

    void changeName(String name) {
        super.setName(name);
    }

    @Override
    protected void swim() {
        super.swim();
        System.out.println("And a frog");
    }

    @Override
    protected void walk() {
        super.walk();
        System.out.println("And a frog");
    }

    void jump(){
        System.out.println("A frog can jump.");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setName(){

    }
}

public class E17_UpcastingWithOveride {
    public static void main(String[] args) {
        Frog frog = new Frog("SunYujun");
        frog.swim();
        frog.walk();
        frog.jump();
        System.out.println(frog);
        frog.changeName("LiuYihan");
        System.out.println(frog);

    }
}
