


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *THIS PROGRAM IS BASED FROM EXAMPLE 4 IN GUI LECTURE. YOU WILL     NOTICE A SIMILAR LAYOUT AND SIMILAR CODE BEHIND THE LAYOUT
 * THE LAYOUT IS CHANGED SLIGHTLY TO ENABLE 2 WAY CONVERSIONS AND CODE IS ADDED AND MODIFIED TO MAKE ACCOMADATIONS
 * 
 * Objective: GUI that can convert between celsius and farenheit
 * 
 * Dhruv Patel
 */
public class TemperatureConverter implements ActionListener{

    JFrame frame;
    JPanel panel;
    JTextField temp;
    JButton cButton, fButton, clearButton;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TemperatureConverter converter = new TemperatureConverter();
        
    }
    public TemperatureConverter(){
            //Create frame
            frame =  new JFrame("Temperature Converter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            panel = new JPanel();
            panel.setLayout(new GridLayout(2,2));
            
            frame.getContentPane().add(panel);
            
            frame.pack();
            frame.setVisible(true);
             
            addWidgets();
    }

    public void addWidgets(){
        //creates widgets
        temp = new JTextField();
        cButton = new JButton("Celsius");
        fButton = new JButton("Farenheit");
        clearButton = new JButton("Clear!");
               
        //Listens to events from convert button
        cButton.addActionListener(this);
        fButton.addActionListener(this);
        clearButton.addActionListener(this);
        //adds text box and buttins to panel
        panel.add(temp);
        panel.add(cButton);
        panel.add(fButton);
        panel.add(clearButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //if the button pressed is Farenheit then converts number in box to degrees Farenheit
        //if the button pressed is Celsius then converts number in box to degrees Celsius
        //if button pressed is Clear then clears textbox to 0.
        if(e.getSource().equals(fButton)){
            int tempFahr = (int)((Double.parseDouble(temp.getText())) * 1.8 + 32);
            temp.setText(Integer.toString(tempFahr));
        }
        if(e.getSource().equals(cButton)){
            int tempCels = (int)((Double.parseDouble((temp.getText())) - 32) / 1.8);
            temp.setText(Integer.toString(tempCels));
        }
        if(e.getSource().equals(clearButton)){
            temp.setText(Integer.toString(0));
        }

    }
    
}
