// User-defined exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// BankAccount class
class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive");
            }

            balance += amount;
            System.out.println(Thread.currentThread().getName()
                    + " deposited Rs." + amount
                    + " | Current Balance: Rs." + balance);

        } catch (IllegalArgumentException e) {
            System.out.println(Thread.currentThread().getName()
                    + " Error: " + e.getMessage());
        }
    }

    public synchronized void withdraw(int amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive");
            }

            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance for withdrawal");
            }

            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " withdrew Rs." + amount
                    + " | Current Balance: Rs." + balance);

        } catch (IllegalArgumentException e) {
            System.out.println(Thread.currentThread().getName()
                    + " Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println(Thread.currentThread().getName()
                    + " Error: " + e.getMessage());
        }
    }

    public synchronized void checkBalance() {
        System.out.println(Thread.currentThread().getName()
                + " checked balance | Balance: Rs." + balance);
    }
}

// Thread class to simulate users
class UserThread extends Thread {
    private BankAccount account;

    public UserThread(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    public void run() {
        account.deposit(1000);
        account.withdraw(500);
        account.withdraw(4000);
        account.checkBalance();
    }
}

// Main class
public class OnlineBankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(3000);

        UserThread user1 = new UserThread(account, "User 1");
        UserThread user2 = new UserThread(account, "User 2");
        UserThread user3 = new UserThread(account, "User 3");

        user1.start();
        user2.start();
        user3.start();
    }
}