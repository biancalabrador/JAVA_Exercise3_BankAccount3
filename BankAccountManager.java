import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/** Manages bank accounts and assigns each account a unique identifier. */
public class BankAccountManager implements Bank {
  /** Max accounts manager can store. */
  private static final int MAX_ACCOUNTS = 100;

  /** Accounts indexed. */
  private final Map<Integer, BankAccount> accounts;
  private int id;

  /** Empty account manager. */
  public BankAccountManager() {
    accounts = new HashMap<>();
    id = 0;
  }

  /** Adds acc unless null or acc limit has been reached. */
  @Override
  public void addAccount(BankAccount account) {
    if (account == null) {
      throw new IllegalArgumentException("Account cannot be null.");
    }
    if (accounts.size() >= MAX_ACCOUNTS) {
      System.out.println("Maximum account limit reached.");
      return;
    }

    accounts.put(id, account);
    System.out.println("Account added successfully with ID: " + id);
    id++;
  }

  /** Returns acc associated with identifier. */
  @Override
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  /** Prints identifier, owner, and balance. */
  public void listAccounts() {
    for (int accountId = 0; accountId < id; accountId++) {
      BankAccount account = accounts.get(accountId);
      String balance = String.format(Locale.ROOT, "%.2f", account.getBalance())
          .replaceAll("0+$", "")
          .replaceAll("\\.$", ".0");
      System.out.println(
          "Account ID: " + accountId
              + ", Account Name: " + account.getOwner()
              + ", Balance: " + balance);
    }
  }
}
