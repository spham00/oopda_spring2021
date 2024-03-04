package bagelHouseNonMVC;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



/**
 * The CostPanel class displays a panel with the total cost.
 */

public class CostPanel extends JPanel
{

	private JLabel labSub, labTax, labTotal;
	private JButton calcButton, exitButton;
	
	/**
	 * Constructor
	 */

     public CostPanel()
     {
          
          // Create the labels.
          labSub = new JLabel("Subtotal: ");
          labTax = new JLabel("Tax: ");
          labTotal = new JLabel("Total: ");
          labSub.setAlignmentX(RIGHT_ALIGNMENT);
          labTax.setAlignmentX(RIGHT_ALIGNMENT);
          labTotal.setAlignmentX(RIGHT_ALIGNMENT);
          
    	  // Create box for cost display (labels)
    	  Box totalsBox = Box.createVerticalBox();
    	  totalsBox.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
    	  totalsBox.add(labSub);
    	  totalsBox.add(labTax);
    	  totalsBox.add(labTotal);

          // Create the buttons.
          calcButton = new JButton("Calculate");

          exitButton = new JButton("Exit");
          exitButton.addActionListener(new ExitButtonListener());	
          
          
          // Create box for the buttons.
          Box buttonBox = Box.createHorizontalBox();
          buttonBox.add(calcButton);
          buttonBox.add(Box.createRigidArea(new Dimension(5,0)));
          buttonBox.add(exitButton);
          buttonBox.add(Box.createRigidArea(new Dimension(5,0)));
          
          this.setLayout(new BorderLayout());
          this.add(totalsBox, BorderLayout.WEST);
          this.add(buttonBox, BorderLayout.EAST);
       }

       /**
        *  Private inner class that handles the event when
        *  the user clicks the Exit button. 
        */

       private class ExitButtonListener implements ActionListener
       {
          public void actionPerformed(ActionEvent e)
          {
             // Exit the application.
              System.exit(0);
          }
       }
         
   	// Getters and Setters
   	
   	public JLabel getLabSub() {
   		return labSub;
   	}

   	public void setLabSub(JLabel labSub) {
   		this.labSub = labSub;
   	}

   	public JLabel getLabTax() {
   		return labTax;
   	}

   	public void setLabTax(JLabel labTax) {
   		this.labTax = labTax;
   	}

   	public JLabel getLabTotal() {
   		return labTotal;
   	}

   	public void setLabTotal(JLabel labTotal) {
   		this.labTotal = labTotal;
   	}

   	public JButton getCalcButton() {
   		return calcButton;
   	}

   	public void setCalcButton(JButton calcButton) {
   		this.calcButton = calcButton;
   	}

   	public JButton getExitButton() {
   		return exitButton;
   	}

   	public void setExitButton(JButton exitButton) {
   		this.exitButton = exitButton;
   	}
       
}

