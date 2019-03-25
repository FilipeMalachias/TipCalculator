/**
 * @Author Filipe Malachias Resende
 */

package sample;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TipCalculatorController implements Initializable {

    private static final NumberFormat currency =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent =
            NumberFormat.getPercentInstance();

    private BigDecimal tipPercentage = new BigDecimal(0.15);

    @FXML
    public Button btnCalculate;
    @FXML
    private TextField totalField; // totalTextField
    @FXML
    private Label amount;
    @FXML
    public TextField amountField; //amountTextField
    @FXML
    public Slider percentage; //tipPercentageSlider
    @FXML
    private Label tip;
    @FXML
    private TextField tipField; //tipTextField
    @FXML
    private Label total;
    @FXML
    public Label percentLabel; //tipPercentLabel


    @FXML
    public void buttonClicked(ActionEvent actionEvent) {
        try
        {
            BigDecimal amout = new BigDecimal(amountField.getText());
            BigDecimal tip = amout.multiply(tipPercentage);
            BigDecimal total = amout.add(tip);

            tipField.setText(currency.format(tip));
            totalField.setText(currency.format(total));
        }
        catch (NumberFormatException ex)
        {
            amountField.setText("Enter amount");
            amountField.selectAll();
            amountField.requestFocus();
        }

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipField.setEditable(false);
        tipField.setMouseTransparent(true);
        totalField.setEditable(false);
        totalField.setMouseTransparent(true);

        currency.setRoundingMode(RoundingMode.HALF_UP);
        
        percentage.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                percentLabel.setText(percent.format(tipPercentage));
            }
        });
    }
}
