import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Currency_Converter {

    //DEFINE STATIC VARIABLES FOR RATES
    private final static Double RATE_USD_TO_JMD = 129.02;
    private final static Double RATE_CAD_TO_JMD = 97.50;
    private final static Double RATE_EUR_TO_JMD = 164.33;


    private final String[] currency = {"USD","CAD","EUR"}; //Declare currency variable array and set its contents
    private final JFrame frame = new JFrame("Converter"); //Declare and Initialize Frame
    private final JTextField amountTextField = new JTextField("0"); //Declare and Initialize text field to 0
    private final JTextField jmdAmount = new JTextField(); //
    private final JLabel jmdAmountLabel = new JLabel("JMD Amount $:");
    private final JButton convertButton = new JButton("Convert"); //Declare and Initialize convertButton
    private final JButton resetButton = new JButton("Reset"); //Declare and Initialize resetButton
    private final JLabel inputAmount = new JLabel("Input Amount $:"); //Declare and Initialize inputAmount
    private final JComboBox currencyComboBox= new JComboBox(currency); //Declare and Initialize a combobox with the currency array
    private final JLabel errorLabel = new JLabel();
    private final JPanel panel = new JPanel();
    private final JTextField infoTextField = new JTextField("Powered By: Shoeb Harris");


    public void createUIComponents() {
        // TODO: place custom component creation code here

        // Properties
        frame.setVisible(true);
        frame.setSize(400,400);
        panel.setLayout(null);
        inputAmount.setBounds(50, 40, 100, 30);
        amountTextField.setBounds(150, 40, 100, 30);
        convertButton.setBounds(50, 150, 100, 30);
        resetButton.setBounds(150, 150, 100, 30);
        currencyComboBox.setBounds(250, 40,50,30);
        jmdAmount.setBounds(150, 70, 150, 30);
        jmdAmountLabel.setBounds(50, 70, 100,30);
        jmdAmount.setEditable(false);
        errorLabel.setBounds(50,260, 350, 30);
        infoTextField.setBounds(100, 300, 150, 30);

        //Add components to frame
        frame.add(panel);
        panel.add(inputAmount);
        panel.add(amountTextField);
        panel.add(convertButton);
        panel.add(resetButton);
        panel.add(currencyComboBox);
        panel.add(jmdAmount);
        panel.add(jmdAmountLabel);
        panel.add(errorLabel);
        panel.add(infoTextField);

        convertButton.addActionListener(new ActionListener() {
            double result = 0.00;
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    result  = currencyCalculator(currencyComboBox.getSelectedItem().toString(), Double.parseDouble(amountTextField.getText()));
                    jmdAmount.setText(String.valueOf(result));
                }catch (Exception ex){
                    errorLabel.setText("Error - Please check input and try again.");
                   
                }

            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amountTextField.setText("0.00");
                jmdAmount.setText("");
            }
        });
    }


    private double currencyCalculator(String opt, double input){

        double result = 0.00;

        switch (opt){
            case "USD":
                        result = RATE_USD_TO_JMD * input;
                        return result;
            case "CAD":
                        result = RATE_CAD_TO_JMD * input;
                        return result;
            case "EUR":
                        result = RATE_EUR_TO_JMD * input;
                        return result;
            default:
                        return result;
        }
    }
}
