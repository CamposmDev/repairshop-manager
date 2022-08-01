package model.work_order;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkOrderPayment implements Comparable<WorkOrderPayment> {
    private int id;
    private Payment type;
    private Date date;
    private double amount;

    public WorkOrderPayment(int id, Date date, Payment type, double amount) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public WorkOrderPayment(Date dateOfPayment, Payment type, double amount) {
        this.id = -1;
        this.date = dateOfPayment;
        this.type = type;
        this.amount = amount;
    }

    public boolean isNew() {
        return id <= 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SimpleStringProperty dateProperty() {
        return new SimpleStringProperty(date.toLocalDate().format(DateTimeFormatter.ofPattern("MM/dd/u")));
    }

    public SimpleObjectProperty<Payment> typeProperty() {
        return new SimpleObjectProperty<>(type);
    }

    public SimpleStringProperty amountProperty() {
        return new SimpleStringProperty(String.format("%.2f", amount));
    }

    public Payment getType() {
        return type;
    }

    public void setType(Payment type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(@NotNull WorkOrderPayment o) {
        return Integer.compare(id, o.id);
    }
}
