
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class FlooringToolAppJava {

	private JFrame frame;
	private JTextField TxtName;
	private JTextField TxtAddress;
	private JTextField TxtLength;
	private JTextField TxtWidth;
	private JTextField TxtArea;
	private JTextField TxtCost;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlooringToolAppJava window = new FlooringToolAppJava();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			 });
	}

	/**
	 * Create the application.
	 */
	public FlooringToolAppJava() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 492, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel FlooringWelcomeScreen = new JPanel();
		tabbedPane.addTab("Welcome", null, FlooringWelcomeScreen, null);
		FlooringWelcomeScreen.setLayout(null);
		
		JTextArea TxtAreaWelcome = new JTextArea();
		TxtAreaWelcome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TxtAreaWelcome.setEditable(false);
		TxtAreaWelcome.setBackground(SystemColor.control);
		TxtAreaWelcome.setText("\r\nThis tool will make it very easy for you to make your flooring purchase. "
				+ "\r\nThe application asks about your basic information and the length & width."
				+ "\r\nThe calculations for Area and the total Cost will be displayed."
				+ "\r\nOnce the submit button is pressed the order will be displayed in "
				+ "\r\n\"Order summary tab\", where you can confirm your order or cancel order."
				+ "\r\nonce you confirm the order your order will be saved in the database."
				+ "\r\nLastly the \"List of Order\" will display all the orders.\r\nThank you for using Flooring Tool APP.");
		TxtAreaWelcome.setBounds(10, 69, 451, 154);
		FlooringWelcomeScreen.add(TxtAreaWelcome);
		
		JLabel lblWelcomeToSyeds = new JLabel("Welcome To Flooring Tools APP");
		lblWelcomeToSyeds.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcomeToSyeds.setBounds(66, 27, 319, 31);
		FlooringWelcomeScreen.add(lblWelcomeToSyeds);
		
		JPanel FlooringInfo = new JPanel();
		tabbedPane.addTab("Flooring", null, FlooringInfo, null);
		FlooringInfo.setLayout(null);
		
		JLabel lblFlooringOrderForm = new JLabel("Flooring order Form");
		lblFlooringOrderForm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFlooringOrderForm.setBounds(107, 11, 188, 22);
		FlooringInfo.add(lblFlooringOrderForm);
		
		JLabel lblEnterYourName = new JLabel("Enter Your Name: ");
		lblEnterYourName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterYourName.setBounds(43, 51, 131, 22);
		FlooringInfo.add(lblEnterYourName);
		
		JLabel lblEnterYourAddress = new JLabel("Enter Your Address: ");
		lblEnterYourAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterYourAddress.setBounds(43, 87, 131, 24);
		FlooringInfo.add(lblEnterYourAddress);
		
		JLabel lblChooseTypeOf = new JLabel("Choose Type of Flooring: ");
		lblChooseTypeOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChooseTypeOf.setBounds(20, 122, 172, 28);
		FlooringInfo.add(lblChooseTypeOf);
		
		JLabel lblEnterTheLength = new JLabel("Enter the Length: ");
		lblEnterTheLength.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterTheLength.setBounds(43, 161, 131, 22);
		FlooringInfo.add(lblEnterTheLength);
		
		JLabel lblEnterTheWidth = new JLabel("Enter the Width: ");
		lblEnterTheWidth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterTheWidth.setBounds(43, 189, 131, 22);
		FlooringInfo.add(lblEnterTheWidth);
		
		JRadioButton rdWood = new JRadioButton("Wood");
		rdWood.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdWood.setBounds(187, 127, 67, 23);
		FlooringInfo.add(rdWood);
		
		TxtName = new JTextField();
		TxtName.setBounds(174, 54, 147, 20);
		FlooringInfo.add(TxtName);
		TxtName.setColumns(10);
		
		TxtAddress = new JTextField();
		TxtAddress.setColumns(10);
		TxtAddress.setBounds(174, 91, 147, 20);
		FlooringInfo.add(TxtAddress);
		
		TxtLength = new JTextField();
		TxtLength.setColumns(10);
		TxtLength.setBounds(174, 161, 147, 20);
		FlooringInfo.add(TxtLength);
		
		TxtWidth = new JTextField();
		TxtWidth.setColumns(10);
		TxtWidth.setBounds(174, 194, 147, 20);
		FlooringInfo.add(TxtWidth);
		
		JRadioButton rdCarpet = new JRadioButton("Carpet");
		rdCarpet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdCarpet.setBounds(267, 125, 67, 23);
		FlooringInfo.add(rdCarpet);
		
		JButton btnSubmitOrder = new JButton("Submit Order");

		btnSubmitOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmitOrder.setBounds(164, 287, 131, 23);
		FlooringInfo.add(btnSubmitOrder);
		
		JLabel lblTotalAreaa = new JLabel("Total Area: ");
		lblTotalAreaa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalAreaa.setBounds(43, 222, 131, 22);
		FlooringInfo.add(lblTotalAreaa);
		
		JLabel lblTotalCostt = new JLabel("Total Cost: ");
		lblTotalCostt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalCostt.setBounds(43, 254, 131, 22);
		FlooringInfo.add(lblTotalCostt);
		
		TxtArea = new JTextField();
		TxtArea.setEditable(false);
		TxtArea.setColumns(10);
		TxtArea.setBounds(174, 222, 147, 20);
		FlooringInfo.add(TxtArea);
		
		TxtCost = new JTextField();
		TxtCost.setEditable(false);
		TxtCost.setColumns(10);
		TxtCost.setBounds(174, 255, 147, 20);
		FlooringInfo.add(TxtCost);
		
		JButton btnCalcArea = new JButton("Calc Area");
		btnCalcArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcArea.setBounds(331, 221, 89, 23);
		FlooringInfo.add(btnCalcArea);
		
		JButton btnCalcTotal = new JButton("Calc Cost");

		btnCalcTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcTotal.setBounds(331, 254, 89, 23);
		FlooringInfo.add(btnCalcTotal);
		
		JPanel FlooringCost = new JPanel();
		tabbedPane.addTab("Order Summary", null, FlooringCost, null);
		FlooringCost.setLayout(null);
		
		JLabel lblHereIsThe = new JLabel("Here is the summary of your order");
		lblHereIsThe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHereIsThe.setBounds(54, 11, 291, 22);
		FlooringCost.add(lblHereIsThe);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(31, 55, 46, 25);
		FlooringCost.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(31, 91, 59, 24);
		FlooringCost.add(lblAddress);
		
		JLabel lblYourFlooringChoose = new JLabel("Your Flooring Choose:");
		lblYourFlooringChoose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYourFlooringChoose.setBounds(31, 126, 140, 22);
		FlooringCost.add(lblYourFlooringChoose);
		
		JLabel lblTotalArea = new JLabel("The Total Area is:");
		lblTotalArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalArea.setBounds(31, 165, 107, 22);
		FlooringCost.add(lblTotalArea);
		
		JLabel lblTotalCost = new JLabel("The Total Cost is:");
		lblTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalCost.setBounds(31, 198, 107, 22);
		FlooringCost.add(lblTotalCost);
		
		JLabel lblSName = new JLabel("");
		lblSName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSName.setBounds(87, 55, 258, 22);
		FlooringCost.add(lblSName);
		
		JLabel lblSAddress = new JLabel("");
		lblSAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSAddress.setBounds(97, 92, 290, 22);
		FlooringCost.add(lblSAddress);
		
		JLabel lblSArea = new JLabel("");
		lblSArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSArea.setBounds(148, 165, 128, 22);
		FlooringCost.add(lblSArea);
		
		JLabel lblSFlooring = new JLabel("");
		lblSFlooring.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSFlooring.setBounds(178, 126, 127, 22);
		FlooringCost.add(lblSFlooring);
		
		JLabel lblSCost = new JLabel("");
		lblSCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSCost.setBounds(148, 198, 140, 22);
		FlooringCost.add(lblSCost);
		
		JButton btnConfrim = new JButton("Confirm Order");
		btnConfrim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfrim.setBounds(196, 241, 122, 23);
		FlooringCost.add(btnConfrim);
		
		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelOrder.setBounds(41, 241, 122, 23);
		FlooringCost.add(btnCancelOrder);
		
		JLabel lblyouCanGo = new JLabel("**To edit your order you can go back to flooring tab and submit changes");
		lblyouCanGo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblyouCanGo.setBounds(28, 275, 359, 14);
		FlooringCost.add(lblyouCanGo);
		
		JPanel Orders = new JPanel();
		tabbedPane.addTab("List of Orders", null, Orders, null);
		Orders.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Here is the list of all orders made");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(94, 11, 280, 22);
		Orders.add(lblNewLabel);
		
		JButton btnDisplayOrders = new JButton("Display orders");
		btnDisplayOrders.setBounds(160, 36, 133, 31);
		Orders.add(btnDisplayOrders);
		
		JTextPane TxtOrderList = new JTextPane();
		TxtOrderList.setBackground(SystemColor.control);
		TxtOrderList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TxtOrderList.setEditable(false);
		TxtOrderList.setBounds(10, 72, 451, 238);
		Orders.add(TxtOrderList);
		
	/***************************************************Submit Order****************************************************/
		
		btnSubmitOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				String name =  "";
				String address = "";
				double length = 0.0;
				double width = 0.0;
				String flooring = "";
				String ErrorString = "ERRORS: ";
				double totalCost = 0.0;
				double totalArea = 0.0;
				
				boolean Error = false;
				
				if(TxtName.getText().isEmpty())
				{
					ErrorString = ErrorString + "\nPlease Enter the Name";
					Error = true;
				}
				else
				{
					name = TxtName.getText();
				}
				
				if(TxtAddress.getText().isEmpty())
				{
					ErrorString = ErrorString + "\nPlease Enter the Address";
					Error = true;
				}
				else
				{
					address = TxtAddress.getText();
				}

				if(rdWood.isSelected() && rdCarpet.isSelected())
				{
					ErrorString = ErrorString + "\nYou cannot select both flooring types";
					Error = true;
				}
				else if((rdWood.isSelected() == false) && (rdCarpet.isSelected() == false))
				{
					ErrorString = ErrorString + "\nPlease select a flooring type";
					Error = true;
				}
				else
				{
					if(rdWood.isSelected())
					{
						flooring = "Wood";
					}
					else
					{
						flooring = "Carpet";
					}
				}

				if(TxtLength.getText().isEmpty())
				{
					ErrorString = ErrorString + "\nPlease Enter the Length";
					Error = true;
				}
				else
				{
					try
					{
						length = Double.parseDouble(TxtLength.getText());
					}
					catch(NumberFormatException nfe)
					{
						ErrorString = ErrorString + "\nLength must be a numeric value";
						Error = true;
					}
				}
				
				if(TxtWidth.getText().isEmpty())
				{
					ErrorString = ErrorString + "\nPlease Enter the Width";
					Error = true;
				}
				else
				{
					
					try
					{
						width = Double.parseDouble(TxtWidth.getText());
					}
					catch(NumberFormatException nfe)
					{
						ErrorString = ErrorString + "\nWidth must be a numeric value";
						Error = true;
					}	
				}
				totalArea = length * width;
				
				if(flooring.equals("Wood"))
				{
					totalCost = totalArea * 20; 
				}
				else 
				{
					totalCost = totalArea * 10;
				}
				
				if(Error)
				{
					JOptionPane.showMessageDialog(null, ErrorString);
				}
				else
				{
					String cost = String.valueOf("$" + totalCost + "0");
					String Area = String.valueOf(totalArea);

					TxtArea.setText(Area + "0");
					TxtCost.setText(cost);
					
					lblSName.setText(name);
					lblSAddress.setText(address);
					lblSFlooring.setText(flooring);
					lblSArea.setText(Area + "0 Sq/Ft");
					lblSCost.setText(cost);
					
					JOptionPane.showMessageDialog(null, "Please confirm your order in 'Order Summary' tab");
				}
			}
		});
		
		/*************************************** Calc Area ***************************************************/
		
		btnCalcArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double length = 0.0;
				double width = 0.0;
				double totalArea = 0.0;
				boolean Error = false;
				TxtArea.setText(null);
				
				String ErrorStringCalcArea = "Errors";
				if(TxtLength.getText().isEmpty())
				{
					ErrorStringCalcArea = ErrorStringCalcArea + "\nPlease Enter the Length";
					Error = true;
				}
				else
				{
					try
					{
						length = Double.parseDouble(TxtLength.getText());
					}
					catch(NumberFormatException nfe)
					{
						ErrorStringCalcArea = ErrorStringCalcArea + "\nLength must be a numeric value";
						Error = true;
					}
				}
				
				if(TxtWidth.getText().isEmpty())
				{
					ErrorStringCalcArea = ErrorStringCalcArea + "\nPlease Enter the Width";
					Error = true;
				}
				else
				{
					
					try
					{
						width = Double.parseDouble(TxtWidth.getText());
					}
					catch(NumberFormatException nfe)
					{
						ErrorStringCalcArea = ErrorStringCalcArea + "\nWidth must be a numeric value";
						Error = true;
					}	
				}
				
				if(Error)
				{
					JOptionPane.showMessageDialog(null, ErrorStringCalcArea);
				}
				else
				{
					totalArea = length * width;
					String Area = String.valueOf(totalArea);
					
					TxtArea.setText(Area + "0");
				}
			}
		});
		
		
		
		/***************************************** CalcTotal *********************************************/
		
		btnCalcTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double length = 0.0;
				double width = 0.0;
				double totalArea = 0.0;
				double totalCost = 0.0;
				boolean Error = false;
				String flooring ="";
				String ErrorStringCalcCost = "Errors";
				TxtCost.setText(null);
				
				if(rdWood.isSelected() && rdCarpet.isSelected())
				{
					ErrorStringCalcCost = ErrorStringCalcCost + "\nYou cannot select both flooring types";
					Error = true;
				}
				else if((rdWood.isSelected() == false) && (rdCarpet.isSelected() == false))
				{
					ErrorStringCalcCost = ErrorStringCalcCost + "\nPlease select a flooring type";
					Error = true;
				}
				else
				{
					if(rdWood.isSelected())
					{
						flooring = "Wood";
					}
					else
					{
						flooring = "Carpet";
					}
				}
				
				
				if(TxtLength.getText().isEmpty())
				{
					ErrorStringCalcCost = ErrorStringCalcCost + "\nPlease Enter the Length";
					Error = true;
				}
				else
				{
					try
					{
						length = Double.parseDouble(TxtLength.getText());
					}
					catch(NumberFormatException nfe)
					{
						ErrorStringCalcCost = ErrorStringCalcCost + "\nLength must be a numeric value";
						Error = true;
					}
				}
				
				if(TxtWidth.getText().isEmpty())
				{
					ErrorStringCalcCost = ErrorStringCalcCost + "\nPlease Enter the Width";
					Error = true;
				}
				else
				{
					
					try
					{
						width = Double.parseDouble(TxtWidth.getText());
					}
					catch(NumberFormatException nfe)
					{
						ErrorStringCalcCost = ErrorStringCalcCost + "\nWidth must be a numeric value";
						Error = true;
					}	
				}
				
				if(Error)
				{
					JOptionPane.showMessageDialog(null, ErrorStringCalcCost);
				}
				else
				{
					totalArea = length * width;
					if(flooring.equals("Wood"))
					{
						totalCost = totalArea * 20;
					}
					else
					{
						totalCost = totalArea * 10;
					}
					
					String cost = String.valueOf("$" + totalCost + "0");
					TxtCost.setText(cost);
				}
			}
		});
		/***********************************************Save the order in to database***************************************/
		
		btnConfrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =  "";
				String address = "";
				double length = 0.0;
				double width = 0.0;
				String flooring = "";
				String ErrorString = "ERROR! Can't Save it: ";
				double totalCost = 0.0;
				double totalArea = 0.0;
				
				boolean Error = false;
				
				if(TxtName.getText().isEmpty())
				{
					ErrorString = ErrorString + "\nPlease Enter the Name";
					Error = true;
				}
				else
				{
					name = TxtName.getText();
				}
				
				if(TxtAddress.getText().isEmpty())
				{
					ErrorString = ErrorString + "\nPlease Enter the Address";
					Error = true;
				}
				else
				{
					address = TxtAddress.getText();
				}
				
				if(rdWood.isSelected() && rdCarpet.isSelected())
				{
					ErrorString = ErrorString + "\nYou cannot select both flooring types";
					Error = true;
				}
				else if((rdWood.isSelected() == false) && (rdCarpet.isSelected() == false))
				{
					ErrorString = ErrorString + "\nPlease select a flooring type";
					Error = true;
				}
				else
				{
					if(rdWood.isSelected())
					{
						flooring = "Wood";
					}
					else
					{
						flooring = "Carpet";
					}
				}

				if(TxtLength.getText().isEmpty())
				{
					ErrorString = ErrorString + "\nPlease Enter the Length";
					Error = true;
				}
				else
				{
					try
					{
						length = Double.parseDouble(TxtLength.getText());
					}
					catch(NumberFormatException nfe)
					{
						ErrorString = ErrorString + "\nLength must be a numeric value";
						Error = true;
					}
				}
				
				if(TxtWidth.getText().isEmpty())
				{
					ErrorString = ErrorString + "\nPlease Enter the Width";
					Error = true;
				}
				else
				{
					
					try
					{
						width = Double.parseDouble(TxtWidth.getText());
					}
					catch(NumberFormatException nfe)
					{
						ErrorString = ErrorString + "\nWidth must be a numeric value";
						Error = true;
					}	
				}
				
				totalArea = length * width;
				if(flooring.equals("Wood"))
				{
					totalCost = totalArea * 20; 
				}
				else 
				{
					totalCost = totalArea * 10;
				}
				
				if(Error)
				{
					JOptionPane.showMessageDialog(null, ErrorString);
				}
				else
				{	
					
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("MySQL JDBC Driver Registered!");
					}
					catch(ClassNotFoundException ue)
					{
						System.out.println("MySQL Driver not found !");
						return;
					}
					
					Connection myConnection = null;
					
					try
					{
						System.out.println("in try... after conection");
						myConnection = DriverManager.getConnection("jdbc:mysql://Devry.edupe.net:4300/CIS355A_(You ID)", "(YOU ID)", "(Password)");
						System.out.println("Connection... string done");
	
						//insert.......
						String insertQuery = " insert into flooring(CustomerName, CustomerAddress, FlooringType, FloorArea, FloorCost) " + " values(?, ?, ?, ?, ?)";
						PreparedStatement myQuery = myConnection.prepareStatement(insertQuery);
						
						//myQuery.setInt(1, cusID);
						myQuery.setString(1, name);
						myQuery.setString(2, address);
						myQuery.setString(3, flooring);
						myQuery.setDouble(4, totalArea);;
						myQuery.setDouble(5, totalCost);
						myQuery.execute();
						
						
						//end insert.....
						JOptionPane.showMessageDialog(null, "Order Saved");
							
					}
					catch (SQLException eee)
					{
						eee.printStackTrace();
						System.out.println("Connection Failed!");
						return;
					}
					finally
					{
						try
						{
							if (myConnection != null)
							{
								myConnection.close();
								System.out.println("Connection closed");
							}
						}
						catch (SQLException er)
						{
							er.printStackTrace();
						}
					}
				}
			}
		});
		
		/********************************************Cancel Order*********************************************************/
		btnCancelOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TxtName.setText(null);
				TxtAddress.setText(null);
				TxtLength.setText(null);
				TxtWidth.setText(null);
				TxtArea.setText(null);
				TxtCost.setText(null);
				
				lblSName.setText(null);
				lblSAddress.setText(null);
				lblSFlooring.setText(null);
				lblSArea.setText(null);
				lblSCost.setText(null);
			
				JOptionPane.showMessageDialog(null, "Order Canceled");
			
			}
		});
		
		/******************************************************* Display Orders **********************************************/
		btnDisplayOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Connection myConnection = null;
				Statement myStatement = null;
				
				try
				{
					myConnection = DriverManager.getConnection("jdbc:mysql://Devry.edupe.net:4300/CIS355A_(You ID)", "(YOU ID)", "(Password)");

					
					myStatement = myConnection.createStatement();
					String mySelect = "Select * from flooring";
					ResultSet myResultSet = myStatement.executeQuery(mySelect);			
					
					String orderlist = "";
					while (myResultSet.next())
					{
						 orderlist = orderlist + ((myResultSet.getString(1) + ": "
											+ myResultSet.getString(2) + ", "
											+ myResultSet.getString(3) + ", "
											+ myResultSet.getString(4) + ", "
											+ myResultSet.getString(5) + " sq/ft, $"
											+ myResultSet.getString(6) + "\n"
											));
					}
					TxtOrderList.setText(orderlist);
				}
				catch (SQLException e)
				{
					e.printStackTrace();
					System.out.println("Connection Failed!");
					return;
				}
				finally
				{
					try
					{
						if (myConnection != null)
						{
							myConnection.close();
							System.out.println("Connection closed");
						}
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			
			}
		});
		
		
	}
}
