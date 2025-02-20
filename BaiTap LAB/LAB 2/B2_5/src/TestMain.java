public class TestMain {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "John Doe", 'm');
        System.out.println(customer);

        Account account = new Account(101, customer, 500.0);
        System.out.println(account);

        account.deposit(200.0);
        System.out.println("After deposit: " + account);

        account.withdraw(100.0);
        System.out.println("After withdrawal: " + account);

        account.withdraw(700.0);
        System.out.println("After excessive withdrawal attempt: " + account);
    }
}
