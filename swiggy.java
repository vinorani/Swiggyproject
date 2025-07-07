package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class swiggy extends JFrame implements ActionListener{
	
	

	    JCheckBox pizzaBox, burgerBox, biryaniBox, dosaBox;
	    JButton orderButton;
	    JTextArea orderSummary;

	    HashMap<String, Integer> priceMap;

	    public swiggy() {
	        setTitle("Zomato Simple App");
	        setSize(400, 400);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Initialize prices
	        priceMap = new HashMap<>();
	        priceMap.put("Pizza", 200);
	        priceMap.put("Burger", 100);
	        priceMap.put("Biryani", 180);
	        priceMap.put("Dosa", 80);

	        // UI components
	        JLabel title = new JLabel("Select Your Food", JLabel.CENTER);
	        title.setFont(new Font("Arial", Font.BOLD, 18));

	        pizzaBox = new JCheckBox("Pizza - ₹200");
	        burgerBox = new JCheckBox("Burger - ₹100");
	        biryaniBox = new JCheckBox("Biryani - ₹180");
	        dosaBox = new JCheckBox("Dosa - ₹80");

	        orderButton = new JButton("Place Order");
	        orderButton.addActionListener(this);

	        orderSummary = new JTextArea(5, 20);
	        orderSummary.setEditable(false);

	        // Layout
	        setLayout(new BorderLayout());

	        JPanel menuPanel = new JPanel();
	        menuPanel.setLayout(new GridLayout(5, 1));
	        menuPanel.add(title);
	        menuPanel.add(pizzaBox);
	        menuPanel.add(burgerBox);
	        menuPanel.add(biryaniBox);
	        menuPanel.add(dosaBox);

	        add(menuPanel, BorderLayout.NORTH);
	        add(orderButton, BorderLayout.CENTER);
	        add(new JScrollPane(orderSummary), BorderLayout.SOUTH);

	        setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        int total = 0;
	        StringBuilder summary = new StringBuilder("Order Summary:\n");

	        if (pizzaBox.isSelected()) {
	            total += priceMap.get("Pizza");
	            summary.append("Pizza - ₹").append(priceMap.get("Pizza")).append("\n");
	        }
	        if (burgerBox.isSelected()) {
	            total += priceMap.get("Burger");
	            summary.append("Burger - ₹").append(priceMap.get("Burger")).append("\n");
	        }
	        if (biryaniBox.isSelected()) {
	            total += priceMap.get("Biryani");
	            summary.append("Biryani - ₹").append(priceMap.get("Biryani")).append("\n");
	        }
	        if (dosaBox.isSelected()) {
	            total += priceMap.get("Dosa");
	            summary.append("Dosa - ₹").append(priceMap.get("Dosa")).append("\n");
	        }

	        if (total == 0) {
	            JOptionPane.showMessageDialog(this, "Please select at least one item.");
	            orderSummary.setText("");
	        } else {
	            summary.append("Total Amount: ₹").append(total);
	            orderSummary.setText(summary.toString());
	        }
	    }

	    public static void main(String[] args) {
	        new swiggy();
	    }
	}


