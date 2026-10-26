/**
 * Signals that an account operation was given an invalid monetary amount.
 */
public class InvalidAmountException extends Exception {
  /**
   * Creates an exception with a detail message.
   *
   * @param message explanation of why the amount is invalid
   */
  public InvalidAmountException(String message) {
    super(message);
  }
}
