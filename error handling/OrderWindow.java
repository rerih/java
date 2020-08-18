import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderWindow extends JFrame{
	
	private BikeOrder bikeOrder;
	private String model = "";
	private int number;
	
	//Swing components declaration
	private JComboBox models;
	private JLabel txtModels;
	private JLabel txtQuantity;
	private JTextField quantity; 
	private JButton orderBtn;
	private JLabel message;
	
	private JPanel contentWindow;
	
	OrderWindow() {
		
		bikeOrder = new BikeOrder();
		
		txtModels = new JLabel("Model: ");
		String[] bikeModels = {"", "mountain bike", "road bike", "fitness bike"};
		models = new JComboBox(bikeModels);
		
		txtQuantity = new JLabel("Quantity: ");
		quantity = new JTextField();
		
		orderBtn = new JButton("Order");
		message = new JLabel("");
		
		//JPanel
		contentWindow = new JPanel(new GridLayout(3, 2));
		
		contentWindow.add(txtModels);
		contentWindow.add(models);
		contentWindow.add(txtQuantity);
		contentWindow.add(quantity);
		contentWindow.add(orderBtn);
		contentWindow.add(message);
		
		this.setContentPane(contentWindow);
		this.setVisible(true);
		this.setSize(600,200);
		this.setTitle("Bike Shopping");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add action listeners
		models.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model = ((JComboBox)e.getSource()).getSelectedItem().toString();				
			}
			
		});
		orderBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (model.equals("")) message.setText("Select a model of the bike");
				else {
					try {
						number = Integer.parseInt(quantity.getText().toString());	
						bikeOrder.validateOrder(model, number);
						message.setText(bikeOrder.getOrder());
					}
					catch(NumberFormatException ex) {
						message.setText("Please set number of bikes");
					}
					catch(TooManyBikesException ex) {
						message.setText(bikeOrder.getOrder());
					}
				}
				
			}
			
		});
	}
	
	
	
	public static void main(String[] args) {
		new OrderWindow();
	}
}
