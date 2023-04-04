package cmh.excecise.model;

public class Transaction {

    public static final String INCOME = "INCOME";
    public static final String EXPENSE = "EXPENSE";
    private String userNumber;
    private String type;
    private double subtotal;
    private String reason;

    public Transaction(String userNumber, String type, double subtotal, String reason) {
        this.userNumber = userNumber;
        this.type = type;
        this.subtotal = subtotal;
        this.reason = reason;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return userNumber + "," + type + "," + subtotal + "," + reason+"\n";
    }

    public static Transaction fromString(String line) {
        String[] arr = line.split(",");
        return new Transaction(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]);

    }
}
