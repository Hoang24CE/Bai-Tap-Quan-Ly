import java.util.Date;

public class TestVisit {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        customer.setMember(true);
        customer.setMemberType("gold");

        Visit visit = new Visit(customer.getName(), new Date());
        visit.setServiceExpense(100);
        visit.setProductExpense(50);

        System.out.println(visit);
        System.out.println("Total Expense after discount: " + visit.getTotalExpense());
    }
}

