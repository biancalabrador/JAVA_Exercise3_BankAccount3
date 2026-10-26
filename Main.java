/**
 * Runs the bank account and account manager test cases.
 */
public class Main {
  /**
   * Runs the sample transactions and verifies account management output.
   */
  public static void main(String[] args) throws InsufficientFundsException {
    try {
      BankAccount acc1 = new SavingsAccount("Test0");
      BankAccountManager accM1 = new BankAccountManager();
      accM1.addAccount(acc1);
      accM1.addAccount(new SavingsAccount("Test1"));
      acc1.deposit(500.0);
      acc1.deposit(-500);
      acc1.freezeAccount();
      acc1.deposit(11500);
      acc1.withdraw(-100);
      acc1.deposit(500.125);
      acc1.withdraw(1500);
      acc1.freezeAccount();
      acc1.withdraw(500);
      acc1.deposit(300);
      acc1.withdraw(150);
      acc1.withdraw(100);
      acc1.deposit(213);
    } catch (InvalidAmountException | InsufficientFundsException | AccountFrozenException e) {
      System.err.println("Error occurred: " + e.getMessage());
    }
  }
}
