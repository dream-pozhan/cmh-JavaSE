package cmh.excecise.model;

import cmh.excecise.exception.ApplicationError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    public static final String INCOME = "INCOME";
    public static final String EXPENSE = "EXPENSE";
    public static final String DATE_FORMAT = "yyyyMMdd";
    private String userNumber;
    private String type;
    private double subtotal;
    private String reason;
    private Date createdAt;


    public Transaction(String userNumber, String type, double subtotal, String reason, Date createdAt) {
        this.userNumber = userNumber;
        this.type = type;
        this.subtotal = subtotal;
        this.reason = reason;
        this.createdAt = createdAt;
    }

    public static Transaction fromString(String line) {
        String[] arr = line.split(",");
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        try {
            Date parsedCreatedAt = formatter.parse(arr[4]);
            return new Transaction(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3], parsedCreatedAt);
        } catch (ParseException e) {
            throw new ApplicationError(e);
        }

    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return userNumber + "," + type + "," + subtotal + "," + reason + "," + formatter.format(createdAt) + "\n";
    }
}
