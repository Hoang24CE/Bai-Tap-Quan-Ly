public class Account {

    private String id;
    private String name;
    private int balance = 0;
//
   public Account(String id, String name) {
       this.id = id;
       this.name = name;
   }
//
    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
//
    public String getID() {
       return id;
    }
//
    public String getName() {
       return name;
    }
//
    public int getBalance() {
       return balance;
    }
//
     //Nạp tiền vào tài khoản
    public int creadit(int amount) {
       balance += amount;
       return balance;
    }
//
     //Rút tiền từ tài khoản
    public int debit(int amount) {
       if(amount <= balance) {
           balance -= amount;
       } else {
           System.out.println("Amount exceeded balance");
       }
       return balance;
    }
//
     //chuyển tiền đến tài khoản
    public int transferTo(Account another, int amount) {
       if(amount <= balance) {
           balance -= amount;
       } else {
           System.out.println("Amount exceeded balance");
       }
        return balance;
    }
//
    public void credit(int i) {

    }
}
