import java.util.*;

public class AutoboxingUnboxingChallenge {

    public static void main(String[] args) {
        Bank bankOfCyprus = new Bank("Bank of Cyprus");
        bankOfCyprus.addBranch("Aglanjia");
        Branch aglanjiaBranch = bankOfCyprus.findBranch("Aglanjia");
        aglanjiaBranch.addCustomer("Stefanos");
        aglanjiaBranch.addCustomer("Phaedra", 1000d);
        aglanjiaBranch.printCustomers();
        Customer stefanos = aglanjiaBranch.findCustomer("Stefanos");
        stefanos.makeTransaction(500);
        stefanos.makeTransaction(-1000);
        stefanos.makeTransaction(143);
        aglanjiaBranch.printCustomers();
    }
    
}

class Bank {

    private ArrayList<Branch> branches;
    private final String name;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public void addBranch(String name) {
        if (hasBranch(name)) {
            System.out.println("Branch already exists");
        } else {
            branches.add(new Branch(name));
            System.out.println("Branch added");
        }
        
    }

    public Branch findBranch(String branchName) {
        for (Branch existingBranch : this.branches) {
            if (branchName.equals(existingBranch.getName())) {
                return existingBranch;
            }
        }
        return null;
    }

    private boolean hasBranch(Branch branch) {
        for (Branch existingBranch : this.branches) {
            return (existingBranch == branch) ? true : false;
        }
        return false;
    }

    private boolean hasBranch(String branchName) {
        for (Branch existingBranch : this.branches) {
            if (branchName.equals(existingBranch.getName())) {
                return true;
            }
        }
        return false;
    }

}

class Branch {

    private ArrayList<Customer> customers;
    private final String name;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public String getName() {
        return this.name;
    }

    public void printCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.getName());
            System.out.println(customer.getTransactions());
        }
    }

    public void addCustomer(String name, double initialTransaction) {
        if (hasCustomer(name)) {
            System.out.println("Customer already exists");
        } else {
            Customer customer = new Customer(name, initialTransaction);
            customers.add(customer);
            System.out.println("Customer added");
        } 
    }

    public void addCustomer(String name) {
        addCustomer(name, 0);
    }

    public boolean hasCustomer(String name) {
        for (Customer existingCustomer : customers) {
            if (name.equals(existingCustomer.getName())) {
                return true;
            }
        }
        return false;
    }

    public Customer findCustomer(String name) {
        for (Customer existingCustomer : customers) {
            if (name.equals(existingCustomer.getName())) {
                return existingCustomer;
            }
        }
        return null;
    }
}

class Customer {

    private ArrayList<Double> transactions;
    private String name;
    private double balance;

    public Customer(String name, double firstTransaction) {
        this.name = name;
        transactions = new ArrayList<Double>();
        transactions.add(firstTransaction);
        this.balance = firstTransaction;
    }

    public Customer(String name) {
        this(name, 0);
    }

    public String getName() {
        return this.name;
    }

    public String getTransactions() {
        String list = "";
        for (Double amount : transactions) {
            list += String.format("%f ", amount);
        }
        return list;
    }

    public void makeTransaction(double amount) {
        // withdrawal
        if (amount < 0) {
            if (this.balance + amount >= 0) {
                System.out.println("Successful withdrawal");
                this.transactions.add(amount);
                this.balance += amount;
            } else {
                System.out.println("Insufficient funds");
            }
        } else {
            // deposit
            System.out.println("Successful deposit");
            this.transactions.add(amount);
            this.balance += amount;
        }

    }
}
