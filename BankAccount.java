import java.util.ArrayList;
import java.util.List;

/** Represents a bank account and records its successful transactions. */
public class BankAccount {
  private double balance;
  private final String owner;
  private boolean frozen;
  private final List<Transaction> transactionHistory;

  /** Creates an account with an empty owner name. */
  public BankAccount() {
    this("");
  }

  /** Creates an account for the specified owner. */
  public BankAccount(String owner) {
    this.owner = owner;
    this.transactionHistory = new ArrayList<>();
  }

  /** Deposit unless the account is frozen. */
  public void deposit(double amount) {
    if (frozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }

    System.out.printf("Amount deposited: %.2f%n", amount);
    if (!Double.isFinite(amount) || amount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }

    balance += amount;
    transactionHistory.add(new Transaction("Deposit", amount));
    System.out.printf("Current balance: %.2f%n", balance);
  }

  /** Withdraws when sufficient funds are available. */
  public void withdraw(double amount) {
    if (frozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }
    System.out.printf("Amount withdrawn: %.2f%n", amount);
    if (!Double.isFinite(amount) || amount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    if (amount > balance) {
      System.out.printf("Insufficient balance. Current balance: %.2f%n", balance);
      return;
    }

    balance -= amount;
    transactionHistory.add(new Transaction("Withdraw", amount));
    System.out.printf("Current balance: %.2f%n", balance);
  }

  /** Returns transaction history. */
  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

  /** Returns current balance. */
  public double getBalance() {
    return balance;
  }

  /** Returns account owner's name. */
  public String getOwner() {
    return owner;
  }

  public void freezeAccount() {
    frozen = true;
  }

  public void unfreezeAccount() {
    frozen = false;
  }

  /** Returns whether the account is frozen. */
  public boolean isFrozen() {
    return frozen;
  }

  /** Rounds a amount to 2 decimal places. */
  private double round(double amount) {
    return Double.isFinite(amount) ? Math.round(amount * 100.0) / 100.0 : amount;
  }
}
