// Program demonstrating custom exceptions, multi-catch, and finally
public class Q7_ATMWithdrawalGuard {
    public static void main(String[] args) {
        Account account = new Account(5000);

        attemptWithdrawal(account, 2000);  // valid withdrawal
        attemptWithdrawal(account, 10000); // exceeds balance
        attemptWithdrawal(account, -500);  // invalid (negative) amount
    }

    static void attemptWithdrawal(Account account, double amount) {
        try {
            account.withdraw(amount);
            System.out.println("Withdrawal of Rs." + amount + " successful. "
                    + "New balance: Rs." + account.balance);
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt complete.\n");
        }
    }
}

// Custom checked exception for a domain-specific error condition
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message); // stores the message in the base Exception class
    }
}

class Account {
    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for this withdrawal.");
        }
        balance -= amount;
    }
}
