package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainController {

    @FXML
    private TextField main_input;
    @FXML
    private TextField runs_input;
    @FXML
    private Button submit_button;

    @FXML
    private TableView out;

    @FXML
    protected void onTextSubmit() {
        out.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        int main = 0;

        try {
            main = Integer.parseInt(main_input.getText());
            main_input.setText(null);
        } catch (NumberFormatException e) {
            main_input.setText(null);
            return;
        }

        int runs = 0;

        try {
            runs = Integer.parseInt(runs_input.getText());
            runs_input.setText(null);
        } catch (NumberFormatException e) {
            runs_input.setText(null);
            return;
        }

        final ObservableList rows = FXCollections.observableArrayList(
                new Row(1, new BigDecimal(main), new BigDecimal(1), main)
        );

        // Hiding Input
        main_input.setVisible(false);
        runs_input.setVisible(false);
        submit_button.setVisible(false);

        main_input.setManaged(false);
        runs_input.setManaged(false);
        submit_button.setManaged(false);

        TableColumn schritt = new TableColumn("Schritt");
        schritt.setCellValueFactory(new PropertyValueFactory<>("schritt"));
        TableColumn seiteA = new TableColumn("Seite a");
        seiteA.setCellValueFactory(new PropertyValueFactory<>("a"));
        TableColumn seiteB = new TableColumn("Seite b");
        seiteB.setCellValueFactory(new PropertyValueFactory<>("b"));
        /*
        TableColumn flächeninhalt = new TableColumn("Flächeninhalt");
        flächeninhalt.setCellValueFactory(new PropertyValueFactory<>("flächeninhalt"));
         */

        out.getColumns().addAll(schritt, seiteA, seiteB);

        // Showing output

        int i = 0;
        BigDecimal a = new BigDecimal(main);
        BigDecimal b = new BigDecimal(1);
        BigDecimal A = new BigDecimal(main);

        while (!(i == runs)) {
            a = a.add(b).divide(new BigDecimal(2));
            b = A.divide(a, i, RoundingMode.HALF_UP);

            rows.add(new Row(i + 2, a, b, main));

            i += 1;
        }

        out.setVisible(true);
        out.setManaged(true);
        out.setItems(rows);

    }

    @FXML
    protected void onCancel() {
        // Showing Input
        runs_input.setText(null);
        main_input.setText(null);
        main_input.setVisible(true);
        runs_input.setVisible(true);
        submit_button.setVisible(true);

        main_input.setManaged(true);
        runs_input.setManaged(true);
        submit_button.setManaged(true);

        // Hiding output
        out.setVisible(false);
        out.setManaged(false);
    }
}