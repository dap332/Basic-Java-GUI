/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package primenumbergui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 *Objective: Create a GUI that takes an integer as an input and finds all prime
 * numbers up to the input
 * 
 * Dhruv Patel
 */
public class PrimeNumberGUI implements ActionListener{
    
    JFrame frame;
    JPanel panel;
    JTextField output, input;
    JButton pButton;
    JLabel label;
    JScrollBar scroll;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrimeNumberGUI GUI = new PrimeNumberGUI();

    }
    //method determines if number passed in parameer is a prime
    //returns true if prime
    public static boolean isPrime(int num){
        int tally = 0;
        for(int i = 2; i < num; i++){
                if(num%i == 0){
                    tally++;
                    break;
                }
            }
        if(tally > 0){
            return false;
        }
                if(num == 2){
            return true;
        }
        else{
            return true;
        }
    }
        
        public PrimeNumberGUI(){
        
        //Creates GUI Frame and Panel
            
        frame = new JFrame("Prime Number Finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        //Freeform GridBagLayout gives more flexible design
        panel.setLayout(new GridBagLayout());
        
        frame.getContentPane().add(panel);
        
        //fixed window size at the center
        frame.setSize(500,650);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //adds labels,panels and buttons
        addWidgets();
        frame.setVisible(true);
    }
    
    public void addWidgets(){
        scroll = new JScrollBar(JScrollBar.HORIZONTAL);
        //Creates a Label and centers it at large font.
        label = new JLabel("Primes",JLabel.CENTER);
        label.setOpaque(true);
        label.setFont(new Font("Comic Sans", Font.PLAIN, 64));
        //Input textbox is initialized
        input = new JTextField("Input Number Here");
        //output textbox is initialized
        output = new JTextField("...");
        //output.setEditable(false);
        //The button that finds primes is made
        pButton = new JButton("Find Primes!");
        //Creates columns and row based cells to help organizes panel
        GridBagConstraints c = new GridBagConstraints();       
        //Positioning and size of input box      
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        //adds input box
        panel.add(input,c);
        //positioning and size of button
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        //adds button
        panel.add(pButton,c);
        //Positioning and size of output box
        c.weightx = 0.0;
        c.weighty = 1;
        c.gridwidth = 2;  
        //fill outputbox to the bottom of page
        c.fill = GridBagConstraints.BOTH;
        //c.insets = new Insets(50,0,0,0);
        //c.ipady = 50;
        c.gridx = 0;
        c.gridy = 2;
        //adds outputbox
        panel.add(output,c);
        //Positioning and size of JLabel "Primes"
        //c.weightx = 0;
        c.weighty = 0;
        //c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        //adds JLabel "Primes"
        panel.add(label,c);
        //Finds visibility range for output box.
        BoundedRangeModel range = output.getHorizontalVisibility();
        scroll.setModel(range);
        //positioning and size for scrollbar
        c.weighty = 0;
        c.gridy = 3;
        //add scrollbar
        panel.add(scroll,c);
        
        //adds actionListener when clicking on button
        pButton.addActionListener(this);
        //adds mouse listener that acts when click on inputbox
        //erases text in the input box
        input.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                input.setText("");
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Creates arraylist to store potential prime numbers
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        //parses input text as ints and tests each number below it to check if Prime
        //if a number is prime it is added to the arraylist
        for(int i = 2; i < (Integer.parseInt(input.getText())); i++){
            if(isPrime(i)){
                numbers.add(i);
            }
        }
        String list = "";
        //concatenates a string by adding numbers in the arraylist together
        for(int j = 0; j < numbers.size(); j++){
            list += (" " + numbers.get(j) + ",");
        }
        //displays the arraylist on the screen as numbers
        output.setText(list);
    }
}

