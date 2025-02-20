public class TestAnimals {
    public static void main(String[] args) {
        Animal cat = new Cat("Kitty");
        cat.greets();  // Output: Meow

        Dog dog = new Dog("Buddy");
        dog.greets();  // Output: Woof

        BigDog bigDog = new BigDog("Max");
        bigDog.greets();  // Output: Woow

        dog.greets(new Dog("Rocky"));  // Output: Wooof
        bigDog.greets(new Dog("Charlie"));  // Output: Woooow
        bigDog.greets(new BigDog("Bruno"));  // Output: Wooooooooow
    }
}
