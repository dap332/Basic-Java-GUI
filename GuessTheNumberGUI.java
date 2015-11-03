/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package guessthenumbergui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Patel
 */
public class GuessTheNumberGUI implements ActionListener{
    //creates frame and panel to make a window
    JFrame frame;
    JPanel panel;
    //creates a guess button and reset button
    JButton guess, reset;
    //creates a label for words and a textfield for input
    JLabel label;
    JTextField input;
    //generates random number
    int random = ((int) (Math.random() * 100));
    //temp number is used for comparison if previous entry
    //used to determine if entry is "warmer" or "cooler"
    int temp = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GuessTheNumberGUI GUI = new GuessTheNumberGUI();
    }
    public GuessTheNumberGUI(){
        //Creates Window with title
        frame = new JFrame("Guess The Number");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //created panel within to hold components
        panel = new JPanel();
        //Layout is gridbagloyout because its flexible and customizable
        panel.setLayout(new GridBagLayout());
        //panel is transparent so the color of the frame can be seen
        //useful so the red or blue background can be seen
        panel.setOpaque(false);
        
        //adds panel and sets a specific non resizable size
        //opens it to the center(relative to null)
        frame.getContentPane().add(panel);
        frame.setSize(300, 100);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //add components
        addWidgets();

        //makes panel visible
        frame.setVisible(true);
    }
    
    public void addWidgets(){
        //text field with text is created
        input = new JTextField("Guess number here");
        //button with "Guess!" written on it is created
        guess = new JButton("Guess!");
        //"Reset" button is created
        reset = new JButton("Reset");
        //reset button is disabled; therefore nonclickable and grayed out
        reset.setEnabled(false);
        //displays "..." on screen; later changes to "Too High" or "Too Low"
        label = new JLabel("...", JLabel.CENTER);
        //font settings for label
        label.setFont(new Font("Comic Sans", Font.PLAIN, 24));
        //makes label visible
        label.setOpaque(true);
        
        //GridBagconstraints allows customizing the sizing and position of each
        //component
        GridBagConstraints c = new GridBagConstraints();
        //places textbox on top left takes up half the row
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        //adds textbox
        panel.add(input,c);
        //place button on the middle of the top row takes up a quarter of the row
        c.gridx = 1;
        c.gridy = 0;
        //adds guss button
        panel.add(guess,c);
        //places reset button at the end of the first row;
        c.gridx = 2;
        c.gridy = 0;
        //adds the reset button
        panel.add(reset,c);
        //places text label underneath the textfield
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        //adds label
        panel.add(label,c);
        
        //adds actionListener when clicking on button
        guess.addActionListener(this);
        //adds ActionListener when clicking on reset button
        reset.addActionListener(this);
        //adds mouse listener that acts when click on inputbox
        //erases text in the input box
        input.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                input.setText("");
            }
        });
    }
    //return 0 if the number matches the random number
    //returns 1 if getting warmer
    //returns -1 if getting cooler
    public int match(int n){
        if(n == random){
            return 0;
        }
        else if(Math.abs(random - n) < Math.abs(random - temp)){
            return 1;
        }
        else{
            return -1;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(guess)){
            //converts input to int
            int  number = Integer.parseInt(input.getText());
            //checks if number matches random number
            //if so then says correct, turns background greem
            //disables and grays out guess button
            //enables reset button
            if(match(number) == 0){
                label.setText("Correct!");
                input.setEditable(false);
                guess.setEnabled(false);
                reset.setEnabled(true);
                frame.getContentPane().setBackground(Color.green);
            }
            //checks to see if getting warmer
            //if so turns background red
            //checks if number is too high or low and labels it aswell
            if(match(number) == 1){
                frame.getContentPane().setBackground(Color.RED);
                if(number > random){
                    label.setText("Too High!");
                }
                else{
                    label.setText("Too Low!");
                }

            }
            //checks to see if getting cooler
            //if so turns blue
            //checks if number is too high or low and labels it aswell
            if(match(number)== -1){
                frame.getContentPane().setBackground(Color.BLUE);
                    if(number > random){
                    label.setText("Too High!");
                }
                else{
                    label.setText("Too Low!");
                }

            }
            //changes temp to guessed number so it can be compared to next entry
            temp = number;
        }
        //resets program, color, buttons, textbox, and label
        if(ae.getSource().equals(reset)){
            input.setText("");
            input.setEditable(true);
            guess.setEnabled(true);
            reset.setEnabled(false);
            label.setText("...");
            temp = 0;
            random = ((int) (Math.random() * 100));
            frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        }
    }
}
