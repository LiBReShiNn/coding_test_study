package this_is_java.abstract_keyword;

public class Executor {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sound();
        cat.breathe();
        System.out.println(cat.kind);

        Animal animal = cat;
        animal.sound();

        animalSound(new Cat());
    }

    public static void animalSound(Animal animal) {
        animal.sound();
    }
}
