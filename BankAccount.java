import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account and records its successful transactions.
 */
public class BankAccount {
  private double balance;
  private final String owner;
  private boolean frozen;
  private final List<Transaction> transactionHistory;

  /**
   * Creates an account with an empty owner name.
   */
  public BankAccount() {
    this("");
  }

  /**
   * Creates an account for the specified owner.
   *
   * @param owner the name of the account owner
   */
  public BankAccount(String owner) {
    this.owner = owner;
    this.transactionHistory = new ArrayList<>();
  }

  /**
   * Deposits a positive amount unless the account is frozen.
   *
   * @param amount the amount to deposit
   * @throws InvalidAmountException if the amount is not finite or not positive
   * @throws AccountFrozenException if this account is frozen
   */
  public void deposit(double amount) throws InvalidAmountException, AccountFrozenException {
    try {
      if (frozen) {
        throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
      }
      System.out.printf("Amount deposited: %.2f%n", amount);
      if (!Double.isFinite(amount) || amount <= 0) {
        throw new InvalidAmountException("Invalid amount. Must be greater than 0");
      }
    } catch (InvalidAmountException | AccountFrozenException exception) {
      throw exception;
    }

    balance += amount;
    transactionHistory.add(new Transaction("Deposit", amount));
    System.out.printf("Current balance: %.2f%n", balance);
  }

  /**
   * Withdraws an amount when sufficient funds are available.
   *
   * @param amount the amount to withdraw
   * @throws InvalidAmountException if the amount is not finite or not positive
   * @throws InsufficientFundsException if the balance is less than the amount
   * @throws AccountFrozenException if this account is frozen
   */
  public void withdraw(double amount)
      throws InvalidAmountException, InsufficientFundsException, AccountFrozenException {
    try {
      if (frozen) {
        throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
      }
      System.out.printf("Amount withdrawn: %.2f%n", amount);
      if (!Double.isFinite(amount) || amount <= 0) {
        throw new InvalidAmountException("Invalid amount. Must be greater than 0.");
      }
      if (amount > balance) {
        throw new InsufficientFundsException("Insufficient balance.");
      }
    } catch (InvalidAmountException
        | InsufficientFundsException
        | AccountFrozenException exception) {
      throw exception;
    }

    balance -= amount;
    transactionHistory.add(new Transaction("Withdraw", amount));
    System.out.printf("Current balance: %.2f%n", balance);
  }

  /**
   * Returns the history of successful transactions for this account.
   *
   * @return the transaction history
   */
  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

  /**
   * Returns the current account balance.
   *
   * @return the current balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Returns the account owner's name.
   *
   * @return the owner's name
   */
  public String getOwner() {
    return owner;
  }

  /**
   * Freezes this account, preventing deposits and withdrawals.
   */
  public void freezeAccount() {
    frozen = true;
  }

  /**
   * Unfreezes this account, allowing deposits and withdrawals.
   */
  public void unfreezeAccount() {
    frozen = false;
  }

  /**
   * Returns whether this account is frozen.
   *
   * @return {@code true} if the account is frozen; {@code false} otherwise
   */
  public boolean isFrozen() {
    return frozen;
  }

  /**
   * Rounds an amount to two decimal places.
   *
   * @param amount the amount to round
   * @return the rounded amount, or the original amount if it is not finite
   */
  private double round(double amount) {
    return Double.isFinite(amount) ? Math.round(amount * 100.0) / 100.0 : amount;
  }
}
