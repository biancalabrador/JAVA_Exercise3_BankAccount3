/**
 * Signals that an account does not have enough funds to complete a withdrawal.
 */
public class InsufficientFundsException extends Exception {
  /**
   * Creates an exception with a detail message.
   *
   * @param message explanation of why the withdrawal could not be completed
   */
  public InsufficientFundsException(String message) {
    super(message);
  }
}
