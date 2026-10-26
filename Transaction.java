import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Represents a transaction with its type, amount, and creation time. */
public class Transaction {
  private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  private final String type;
  private final double amount;
  private final LocalDateTime time_stamp;

  /** When was the transaction created */
  public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.time_stamp = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return "\nTransaction [type=" + type + ", amount=" + amount + ", time_stamp=" + time_stamp.format(TIME_FORMAT) + "]";
  }
}
