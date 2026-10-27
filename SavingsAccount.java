/** Represents a bank account that stores its owner's name. */
public class SavingsAccount extends BankAccount {
  /** Creates a savings account. */
  public SavingsAccount(String ownerName) {
    super(ownerName);
    System.out.println("Account Owner: " + getOwner() + ".");
  }

  /** Returns the account owner's name. */
  public String getOwnerName() {
    return getOwner();
  }
}
