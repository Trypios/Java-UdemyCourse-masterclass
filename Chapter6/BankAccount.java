public class BankAccountChallenge {

    public static void main(String[] args) {
        Account bobsAccount = new Account("12345", 0.00, "Bob Brown", "myemail@bob.com", "(087) 123-4567");
        System.out.println(bobsAccount.getAccountNumber());
        System.out.println(bobsAccount.getBalance());

        bobsAccount.withdrawal(100.0);

        bobsAccount.deposit(50.0);
        bobsAccount.withdrawal(100.0);

        bobsAccount.deposit(51.0);
        bobsAccount.withdrawal(100.0);

        VipCustomer timsAccount = new VipCustomer("Tim", "tim@email.com", 12345);
        System.out.println(timsAccount.getCreditLimit() + " name " + timsAccount.getClientName());
    }
}

class Account {

    private String accountNumber;
    private double balance;
    private String clientName;
    private String clientEmail;
    private String clientPhone;

    public Account(String accountNumber, double balance, String clientName, String clientEmail, String clientPhone) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("You have deposited $" + amount + ".");
    }
    
    public void withdrawal(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal of $" + amount + ". $" + this.balance + " left in your account.");
        } else {
            System.out.println("Insufficient funds. You have " + this.balance + " in your account");
        }
    }

}

class VipCustomer {
    
    String clientName;
    String clientEmail;
    double creditLimit;

    public VipCustomer(String clientName, String clientEmail, double creditLimit) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.creditLimit = creditLimit;
    }

    public String getClientName() {
        return this.clientName;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }

}

