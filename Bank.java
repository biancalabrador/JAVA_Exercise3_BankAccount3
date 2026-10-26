/** Defines operations for managing bank accounts. */
public interface Bank {
  /** Adds an account to the bank. */
  void addAccount(BankAccount account);

  /** Returns the account with the specified identifier. */
  BankAccount getAccount(int id);
}
