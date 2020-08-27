import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TaxGuiFile extends JFrame {
	
	JLabel lblGrIncome;
	JTextField txtGrossIncome;
	JLabel lblDependents;
	JTextField txtDependents;
	JLabel lblState;
	JComboBox chState;
	JLabel lblTax;
	JTextField txtStateTax;
	JButton bGo;
	JButton bReset;
	
	
	Vector<String> states = new Vector<>(50);
	
	public TaxGuiFile() {
	
		lblGrIncome = new JLabel("Gross income: ");
		txtGrossIncome = new JTextField(15);
		lblDependents = new JLabel("Number of Dependents: ");
		txtDependents = new JTextField(2);
		lblState = new JLabel("State: ");
		chState = new JComboBox(states);
		lblTax = new JLabel("State Tax: ");
		txtStateTax = new JTextField(10);
		bGo = new JButton("Go");
		bReset = new JButton("Reset");
		
		setLayout(new GridLayout(5, 2, 1, 1));
		
		add(lblGrIncome);
		add(txtGrossIncome);
		add(lblDependents);
		add(txtDependents);
		add(lblState);
		add(chState);
		add(lblTax);
		add(txtStateTax);
		add(bGo);
		add(bReset);
		
		populateStates();
		
		chState.setSelectedIndex(0);
		txtStateTax.setEditable(false);
		
		// adds action listeners
		bGo.addActionListener(evt -> {
			try {
			int grIncome = Integer.parseInt(txtGrossIncome.getText());
			int dependents = Integer.parseInt(txtDependents.getText());
			String state = (String)chState.getSelectedItem();
			if (state.equals("Select State")) throw  new StateSelectionException("Please select a state");
			
			Tax tax = new Tax(grIncome, state, dependents);
			txtStateTax.setText(Double.toString(tax.calcTax()));
			}
			catch(NumberFormatException nfe) {
				txtStateTax.setText("Please enter valid values!");
			}
			catch(StateSelectionException e) {
				txtStateTax.setText(e.getMessage());
			}
			catch(Exception e) {
				txtStateTax.setText(e.getMessage());
			}
			
		});
		bReset.addActionListener(evt -> {
			txtGrossIncome.setText("");
			txtDependents.setText("");
			chState.setSelectedIndex(0);
			txtStateTax.setText("");
		});
		// end of action listeners
		
		
		setSize(400, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//
	public void populateStates() {
		
		states.add("Select State");
		
		try(FileInputStream myFile = new FileInputStream("states.txt");
			InputStreamReader isr = new InputStreamReader(myFile, "UTF8");
			BufferedReader buffer = new BufferedReader(isr);	
				) {
			String line;
			while((line = buffer.readLine()) != null) {
				states.add(line);
			}
			
		}
		catch(IOException ioe) {
			txtStateTax.setText("Can't read states.txt: " + ioe.getMessage());
		}
	}

	public static void main(String[] args) {
		new TaxGuiFile();

	}
	

}
