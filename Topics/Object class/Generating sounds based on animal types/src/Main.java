
import java.util.*;

public class Main {

    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }
    }

    static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        void sound() {
            System.out.println("Bark!");
        }
    }

    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        void sound() {
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String animal = scanner.nextLine();
        String animalName = scanner.nextLine();

        if(animal.equalsIgnoreCase("Dog")) {
            Dog dog = new Dog(animalName);
            dog.sound();
        } else if(animal.equalsIgnoreCase("Cat")) {
            Cat cat = new Cat(animalName);
            cat.sound();
        } else {
            System.out.println("Animal type not recognized");
        }

        scanner.close();
    }
}