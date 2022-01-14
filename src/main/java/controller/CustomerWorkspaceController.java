package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Address;
import model.Customer;
import model.DB;
import model.State;
import org.controlsfx.control.textfield.TextFields;

public class CustomerWorkspaceController {
    @FXML
    TextField tfFirstName, tfLastName, tfPhone, tfEmail, tfCompany, tfStreet, tfCity, tfState, tfZip;

    @FXML
    public void initialize() {
        TextFields.bindAutoCompletion(tfStreet, DB.get().getUniqueStreets());
        TextFields.bindAutoCompletion(tfCity, DB.get().getUniqueCities());
        TextFields.bindAutoCompletion(tfState, State.list());
        TextFields.bindAutoCompletion(tfZip, DB.get().getUniqueZips());
    }

    public void addCustomer() {
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String company = tfCompany.getText();
        String street = tfStreet.getText();
        String city = tfCity.getText();
        String state = tfState.getText();
        String zip = tfZip.getText();

        Address address = new Address(street, city, state, zip);
        Customer customer = new Customer(firstName, lastName, phone, email, company, address);
        DB.get().addCustomer(customer);
    }
}
