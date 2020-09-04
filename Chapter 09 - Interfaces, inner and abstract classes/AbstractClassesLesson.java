

public class AbstractClassesLesson {
    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Coco");
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Blackie");
        penguin.breathe();
        penguin.fly();

    }
}


abstract class Bird extends Animal implements CanFly {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }
    
    @Override
    public void breathe() {
        System.out.println(getName() + " is breathing");
    }

    public void fly() {
        System.out.println(getName() + " is flapping its wings");
    }
}


interface CanFly {
    void fly();
}


abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
    public abstract void breathe();

    public String getName() {
        return this.name;
    }
}


class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }
    
    @Override
    public void breathe() {
        System.out.println(getName() + " is breathing");
    }
}


class Parrot extends Bird {

    public Parrot(String name) {
        super(name);
    }

}


class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " can't fly");
    }
}
