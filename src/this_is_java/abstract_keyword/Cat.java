package this_is_java.abstract_keyword;

public class Cat extends Animal {
    public Cat(){
        this.kind = "포유류";
    }
    @Override
    public void sound(){
        System.out.println("냐옹");
    }
}