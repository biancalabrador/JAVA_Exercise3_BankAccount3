/**
 * Signals that an operation cannot be completed because the account is frozen.
 */
public class AccountFrozenException extends Exception {
  /**
   * Creates an exception with a detail message.
   *
   * @param message explanation of why the account operation could not be completed
   */
  public AccountFrozenException(String message) {
    super(message);
  }
}
