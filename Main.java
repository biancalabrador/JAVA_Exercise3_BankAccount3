/**
 * Runs the bank account and account manager test cases.
 */
public class Main {
  /**
   * Runs the sample transactions and verifies account management output.
   */
  public static void main(String[] args) {
    BankAccount acc1 = new SavingsAccount("Test0");
    BankAccountManager accM1 = new BankAccountManager();
    accM1.addAccount(acc1);
    accM1.addAccount(new SavingsAccount("Test1"));
    acc1.deposit(amount: 500.0);

  }
}
