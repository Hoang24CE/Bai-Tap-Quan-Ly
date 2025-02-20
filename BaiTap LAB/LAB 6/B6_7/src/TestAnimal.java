public class TestAnimal {
    public static void main(String[] args) {
        // Using subclasses directly
        Cat cat1 = new Cat();
        cat1.greeting();

        Dog dog1 = new Dog();
        dog1.greeting();

        BigDog bigDog1 = new BigDog();
        bigDog1.greeting();

        // Using polymorphism
        Animal animal1 = new Cat();
        animal1.greeting();

        Animal animal2 = new Dog();
        animal2.greeting();

        Animal animal3 = new BigDog();
        animal3.greeting();

        // Safe downcasting
        if (animal2 instanceof Dog) {
            Dog dog2 = (Dog) animal2;
            dog2.greeting(dog1);
        }

        if (animal3 instanceof BigDog) {
            BigDog bigDog2 = (BigDog) animal3;
            bigDog2.greeting(dog1);
            bigDog2.greeting(bigDog1);
        }

        // Avoid unsafe casting
        if (animal2 instanceof Cat) {
            Cat cat2 = (Cat) animal2; // This block will not run because animal2 is actually a Dog
            cat2.greeting();
        } else {
            System.out.println("Cannot cast Dog to Cat!"); // ✅ This prevents the ClassCastException
        }
    }
}