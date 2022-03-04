import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.util.Date;


public class Menu extends JFrame {
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private int position = 0;
	private String password;
	private Customer customer = null;
	private CustomerAccount acc = new CustomerAccount();
	
	JFrame frame1, frame2;
	
	JLabel label1, firstNameLabel, surnameLabel, ppsLabel, dobLabel, customerIDLabel, passwordLabel;
	
	JTextField firstNameTextField, surnameTextField, ppsTextField, dobTextField, customerIDTextField, passwordTextField;
	
	JPanel panel1, panel2, userTypePanel, continuePanel, 
	deleteCustomerPanel, deleteAccountPanel, bankChargesPanel, interestPanel, editCustomerPanel, navigatePanel, summaryPanel, accountPanel, returnPanel;
	
	JButton add, cancel, continueButton, 
	deleteCustomer, deleteAccount, bankChargesButton, interestButton, editCustomerButton, navigateButton, summaryButton, accountButton, returnButton;
	
	JRadioButton radioButton;
	
	ButtonGroup userType;
	
	String pps, firstName, surname, dob, customerID;
	
	Container content;
	Customer cust;
	
	public static void main(String[] args) {
		
		Menu driver = new Menu();
		driver.menuStart();
		
	}
	
	public void menuStart() {
		
		   /*The menuStart method asks the user if they are a new customer, an existing customer or an administrator. 
		    * It will then start the create customer process if they are a new customer, or will ask them to log in if 
		    * they are an existing customer or administrator.*/
		
			
			frame1 = new JFrame("Choose User Type");
			frame1.setSize(400, 300);
			frame1.setLocation(200, 200);
			
			frame1.addWindowListener(new WindowAdapter() {
				
				public void windowClosing(WindowEvent windowEvent) { 
					System.exit(position); 
				}
			});

			

			JPanel userTypePanel = new JPanel();
			final ButtonGroup userType = new ButtonGroup();
			JRadioButton radioButton;
			
			userTypePanel.add(radioButton = new JRadioButton("Existing Customer"));
			radioButton.setActionCommand("Existing Customer");
			userType.add(radioButton);
			
			userTypePanel.add(radioButton = new JRadioButton("Administrator"));
			radioButton.setActionCommand("Administrator");
		      userType.add(radioButton);
			
			userTypePanel.add(radioButton = new JRadioButton("New Customer"));
			radioButton.setActionCommand("New Customer");
			
			userType.add(radioButton);


			JPanel continuePanel = new JPanel();
			JButton continueButton = new JButton("Continue");
			continuePanel.add(continueButton);

			Container content = frame1.getContentPane();
			content.setLayout(new GridLayout(2, 1));
			content.add(userTypePanel);
			content.add(continuePanel);
			

			continueButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent actionEvent) {
					
					String user = userType.getSelection().getActionCommand();
					
					if(user.equals("New Customer")) {
						
						frame1.dispose();		
						frame2 = new JFrame("Create New Customer");
						frame2.setSize(400, 300);
						frame2.setLocation(200, 200);
						frame2.addWindowListener(new WindowAdapter() {
							
							public void windowClosing(WindowEvent windowEvent) { 
								System.exit(position); 
								}
						});
						
							Container content = frame2.getContentPane();
							content.setLayout(new BorderLayout());
							
							firstNameLabel = new JLabel("First Name: ", SwingConstants.RIGHT);
							surnameLabel = new JLabel("Surname: ", SwingConstants.RIGHT);
							ppsLabel = new JLabel("PPS Number: ", SwingConstants.RIGHT);
							dobLabel = new JLabel("Date of Birth: ", SwingConstants.RIGHT);
							firstNameTextField = new JTextField(20);
							surnameTextField = new JTextField(20);
							ppsTextField = new JTextField(20);
							dobTextField = new JTextField(20);
							
						
							panel1 = new JPanel(new GridLayout(6, 2));
							
							panel1.add(firstNameLabel);
							panel1.add(firstNameTextField);
							panel1.add(surnameLabel);
							panel1.add(surnameTextField);
							panel1.add(ppsLabel);
							panel1.add(ppsTextField);
							panel1.add(dobLabel);
							panel1.add(dobTextField);
								
							panel2 = new JPanel();
							
							add = new JButton("Add");
							
							

					
						   add.addActionListener(new ActionListener() {
							   
							   public void actionPerformed(ActionEvent actionEvent) {
								   
							    pps = ppsTextField.getText();
								firstName = firstNameTextField.getText();
								surname = surnameTextField.getText();
								dob = dobTextField.getText();					
								customerID = "ID"+ ppsTextField.getText();
								   
								frame2.dispose();
								
								boolean loop = true;
								
								while(loop) {
								 password = JOptionPane.showInputDialog(frame1, "Enter a 7 Character Password;");
								
								 if(password.length() != 7) {
								    	JOptionPane.showInternalMessageDialog(null, null, "Password must be 7 Characters Long", JOptionPane.OK_OPTION);
								    } else {
									 loop = false;
								    }
								}
								
								
								
								
							    ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount> ();
								Customer customer = new Customer(pps, surname, firstName, dob, customerID, password, accounts);
											
								customerList.add(customer);
									
								JOptionPane.showMessageDialog(frame1, "CustomerID = " + customerID +"\n Password = " + password  ,"Customer created.",  JOptionPane.INFORMATION_MESSAGE);
								menuStart();
								frame1.dispose();
							}
						});	
						   
								
												
							cancel = new JButton("Cancel");					
							cancel.addActionListener(new ActionListener() {
								
								public void actionPerformed(ActionEvent actionEvent) {
									frame2.dispose();
									menuStart();
								}
							});	
							
							panel2.add(add);
							panel2.add(cancel);
							
							content.add(panel1, BorderLayout.CENTER);
							content.add(panel2, BorderLayout.SOUTH);
					
							frame2.setVisible(true);		
						
					}
					
					
			
					if(user.equals("Administrator")) {
						
						boolean loop = true, loop2 = true;
					
					    while(loop) {
					    	
					    Object adminUsername = JOptionPane.showInputDialog(frame1, "Enter Administrator Username: ");

					    if(!adminUsername.equals("admin")) {
					    	
					    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Username. Try Again?", JOptionPane.YES_NO_OPTION);
					    	
					    	if(reply == JOptionPane.YES_OPTION) {
					    		loop = true;
					    		
					    	} else if(reply == JOptionPane.NO_OPTION) {
					    		frame2.dispose();
					    		loop = false;
					    		loop2 = false;
					    		menuStart();
					    	}
					 } else {
							loop = false;
					 }
					} 				    
					   
					    
					    while(loop2) {
					    	
					    Object adminPassword = JOptionPane.showInputDialog(frame1, "Enter Administrator Password;");
					    	
					    if(!adminPassword.equals("admin11")) {
							int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Password. Try Again?", JOptionPane.YES_NO_OPTION);
							
							if (reply == JOptionPane.YES_OPTION) {
							    		loop2 = true;
							} else if(reply == JOptionPane.NO_OPTION){
							    		frame2.dispose();
							    		loop2 = false;
							    		menuStart();
							}
					 } else {
					    	loop2 = false;
					    	admin();
					 }
					}
					    			    
				}
			
					
					
					if(user.equals("Existing Customer")	)
					{
						boolean loop = true, loop2 = true;
						boolean cont = false;
						boolean found = false;
						
						Customer customer = null;
						
					    while(loop) {
					    	
					    Object customerID = JOptionPane.showInputDialog(frame1, "Enter Customer ID:");
					    
					    for (Customer aCustomer: customerList){
					    	
					    	if(aCustomer.getCustomerID().equals(customerID))//search customer list for matching customer ID
					    	{
					    		found = true;
					    		customer = aCustomer;
					    	}					    	
					    }
					    
					    if(found == false)
					    {
					    	int reply  = JOptionPane.showConfirmDialog(null, null, "User Not Found. Try Again?", JOptionPane.YES_NO_OPTION);
					    	
					    	if (reply == JOptionPane.YES_OPTION) {
					    		loop = true;
					    	}
					    	else if(reply == JOptionPane.NO_OPTION)
					    	{
					    		frame1.dispose();
					    		loop = false;
					    		loop2 = false;
					    		menuStart();
					    	}
					    }
					    else
					    {
					    	loop = false;
					    }
					   
					    }
					    
					    while(loop2)
					    {
					    	Object customerPassword = JOptionPane.showInputDialog(frame1, "Enter Customer Password;");
					    	
					    	   if(!customer.getPassword().equals(customerPassword))
							    {
							    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Password. Try Again?", JOptionPane.YES_NO_OPTION);
							    	if (reply == JOptionPane.YES_OPTION) {
							    		
							    	}
							    	else if(reply == JOptionPane.NO_OPTION){
							    		frame1.dispose();
							    		loop2 = false;
							    		menuStart();
							    	}
							    }
					    	   else
					    	   {
					    		   loop2 = false;
					    		   cont = true;
					    	   }
					    }
					    	
					    if(cont)
					    {
						frame1.dispose();
					    	loop = false;
					    	customer(customer);				    
					    }				    
					}
				}
			});frame1.setVisible(true);	
	}
	

	
	public void admin() {
		
		dispose();
		
		frame1 = new JFrame("Administrator Menu");
		frame1.setSize(400, 400);
		frame1.setLocation(200, 200);
		frame1.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent we) { 
				System.exit(position); 
				}
		}); 
		
		
		frame1.setVisible(true);
		
		label1 = new JLabel("Please Select an Option: ");
		
		deleteCustomerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    deleteCustomer = new JButton("Delete Customer");	
		deleteCustomer.setSize(new Dimension(220, 20));
		deleteCustomerPanel.add(deleteCustomer);
		
		deleteAccountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    deleteAccount = new JButton("Delete Account");
		deleteAccount.setSize(new Dimension(220, 20));	
		deleteAccountPanel.add(deleteAccount);
		
		bankChargesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bankChargesButton = new JButton("Apply Bank Charges");
		bankChargesButton.setSize(new Dimension(220, 20));	
		bankChargesPanel.add(bankChargesButton);
		
		interestPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		interestButton = new JButton("Apply Interest");
		interestPanel.add(interestButton);
		interestButton.setSize(new Dimension(220, 20));
		
		editCustomerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		editCustomerButton = new JButton("Edit Existing Customer");
		editCustomerPanel.add(editCustomerButton);
		editCustomerButton.setSize(new Dimension(220, 20));
		
		navigatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		navigateButton = new JButton("Navigate Customer Collection");
		navigatePanel.add(navigateButton);
		navigateButton.setSize(new Dimension(220, 20));
		
		summaryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		summaryButton = new JButton("Summary Of Accounts");
		summaryPanel.add(summaryButton);
		summaryButton.setSize(new Dimension(220, 20));
		
		accountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		accountButton = new JButton("Add Account to a Customer");
		accountPanel.add(accountButton);
		accountButton.setSize(new Dimension(220, 20));
		
		returnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		returnButton = new JButton("Exit Admin Menu");
		returnPanel.add(returnButton);
		returnButton.setSize(new Dimension(220, 20));

		
		content = frame1.getContentPane();
		content.setLayout(new GridLayout(11, 1));
		content.add(label1);
		content.add(accountPanel);
		content.add(bankChargesPanel);
		content.add(interestPanel);
		content.add(editCustomerPanel);
		content.add(navigatePanel);
		content.add(summaryPanel);	
		content.add(deleteCustomerPanel);
		content.add(deleteAccountPanel);
		content.add(returnPanel);
		
		
		bankChargesButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent actionEvent) {
				
				boolean loop = true;
				boolean found = false;
			
				if(customerList.isEmpty()) {
					
					JOptionPane.showMessageDialog(frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					frame1 .dispose();
					admin();
				}else{
					
			    while(loop) {
			    	
			    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer You Wish to Apply Charges to:");
			    
			    for (Customer aCustomer: customerList){
			    	
			    	if(aCustomer.getCustomerID().equals(customerID))
			    	{
			    		found = true;
			    		customer = aCustomer; 
			    		loop = false;
			    	}					    	
			    }
			    
			    if(found == false)
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		loop = true;
			    	}
			    	else if(reply == JOptionPane.NO_OPTION)
			    	{
			    		frame1.dispose();
			    		loop = false;
			    	
			    		admin();
			    	}
			    }  
			    else
			    {
			    	frame1.dispose();
			    	frame1 = new JFrame("Administrator Menu");
					frame1.setSize(400, 300);
					frame1.setLocation(200, 200);
					frame1.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) { System.exit(0); }
					});          
					frame1.setVisible(true);
				
				
				    JComboBox<String> box = new JComboBox<String>();
				    for (int i =0; i < customer.getAccounts().size(); i++)
				    {
				    	
				    	
				     box.addItem(customer.getAccounts().get(i).getNumber());
				    }
					
				    
				    box.getSelectedItem();
				
				    JPanel boxPanel = new JPanel();
					boxPanel.add(box);
					
					JPanel buttonPanel = new JPanel();
					JButton continueButton = new JButton("Apply Charge");
					JButton returnButton = new JButton("Return");
					buttonPanel.add(continueButton);
					buttonPanel.add(returnButton);
					Container content = frame1.getContentPane();
					content.setLayout(new GridLayout(2, 1));
					
					content.add(boxPanel);
					content.add(buttonPanel);
					
			
						if(customer.getAccounts().isEmpty())
						{
							JOptionPane.showMessageDialog(frame1, "This customer has no accounts! \n The admin must add acounts to this customer."   ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
							frame1.dispose();
							admin();
						}
						else
						{
						
					for(int i = 0; i < customer.getAccounts().size(); i++)
				    {
				    	if(customer.getAccounts().get(i).getNumber() == box.getSelectedItem() )
				    	{
				    		acc = customer.getAccounts().get(i);
				    	}
				    }
										
					continueButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							String euro = "\u20ac";
						 	
							
							if(acc instanceof CustomerDepositAccount)
							{
							
							
							JOptionPane.showMessageDialog(frame1, "25" + euro + " deposit account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
							acc.setBalance(acc.getBalance()-25);
							JOptionPane.showMessageDialog(frame1, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
							}

							if(acc instanceof CustomerCurrentAccount)
							{
							
							
							JOptionPane.showMessageDialog(frame1, "15" + euro + " current account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
							acc.setBalance(acc.getBalance()-25);
							JOptionPane.showMessageDialog(frame1, "New balance = " + acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
							}
							
							
							frame1.dispose();				
						admin();				
						}		
				     });
					
					returnButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							frame1.dispose();		
							menuStart();				
						}
				     });	
					
						}
			    }
			    }
			    }
			    
			    
			    
			}		
	     });
		
		interestButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {

				boolean loop = true;
				
				boolean found = false;
			
				if(customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					frame1.dispose();
					admin();
					
				}
				else
				{
			    while(loop)
			    {
			    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer You Wish to Apply Interest to:");
			    
			    for (Customer aCustomer: customerList){
			    	
			    	if(aCustomer.getCustomerID().equals(customerID))
			    	{
			    		found = true;
			    		customer = aCustomer; 
			    		loop = false;
			    	}					    	
			    }
			    
			    if(found == false)
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		loop = true;
			    	}
			    	else if(reply == JOptionPane.NO_OPTION)
			    	{
			    		frame1.dispose();
			    		loop = false;
			    	
			    		admin();
			    	}
			    }  
			    else
			    {
			    	frame1.dispose();
			    	frame1 = new JFrame("Administrator Menu");
					frame1.setSize(400, 300);
					frame1.setLocation(200, 200);
					frame1.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) { System.exit(0); }
					});          
					frame1.setVisible(true);
				
				
				    JComboBox<String> box = new JComboBox<String>();
				    for (int i =0; i < customer.getAccounts().size(); i++)
				    {
				    	
				    	
				     box.addItem(customer.getAccounts().get(i).getNumber());
				    }
					
				    
				    box.getSelectedItem();
				
				    JPanel boxPanel = new JPanel();
					
					JLabel label = new JLabel("Select an account to apply interest to:");
					boxPanel.add(label);
					boxPanel.add(box);
					JPanel buttonPanel = new JPanel();
					JButton continueButton = new JButton("Apply Interest");
					JButton returnButton = new JButton("Return");
					buttonPanel.add(continueButton);
					buttonPanel.add(returnButton);
					Container content = frame1.getContentPane();
					content.setLayout(new GridLayout(2, 1));
					
					content.add(boxPanel);
					content.add(buttonPanel);
					
			
						if(customer.getAccounts().isEmpty())
						{
							JOptionPane.showMessageDialog(frame1, "This customer has no accounts! \n The admin must add acounts to this customer."   ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
							frame1.dispose();
							admin();
						}
						else
						{
						
					for(int i = 0; i < customer.getAccounts().size(); i++)
				    {
				    	if(customer.getAccounts().get(i).getNumber() == box.getSelectedItem() )
				    	{
				    		acc = customer.getAccounts().get(i);
				    	}
				    }
										
					continueButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							String euro = "\u20ac";
						 	double interest = 0;
						 	boolean loop = true;
						 	
						 	while(loop)
						 	{
							String interestString = JOptionPane.showInputDialog(frame1, "Enter interest percentage you wish to apply: \n NOTE: Please enter a numerical value. (with no percentage sign) \n E.g: If you wish to apply 8% interest, enter '8'");//the isNumeric method tests to see if the string entered was numeric. 
							if(isNumeric(interestString))
							{
								
								interest = Double.parseDouble(interestString);
								loop = false;
								
								acc.setBalance(acc.getBalance() + (acc.getBalance() * (interest/100)));
								
								JOptionPane.showMessageDialog(frame1, interest + "% interest applied. \n new balance = " + acc.getBalance() + euro ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
							}
								
							
							else
							{
								JOptionPane.showMessageDialog(frame1, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
							}
							
							
						 	}
							
							frame1.dispose();				
						admin();				
						}		
				     });
					
					returnButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							frame1.dispose();		
							menuStart();				
						}
				     });	
					
						}
			    }
			    }
			    }
			    
			}	
	     });
		
		editCustomerButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				
				boolean loop = true;
			
				boolean found = false;
			
				if(customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					frame1.dispose();
					admin();
					
				}
				else
				{
				
			    while(loop)
			    {
			    Object customerID = JOptionPane.showInputDialog(frame1,"Enter Customer ID:");
			    
			    for (Customer aCustomer: customerList){
			    	
			    	if(aCustomer.getCustomerID().equals(customerID))
			    	{
			    		found = true;
			    		customer = aCustomer;
			    	}					    	
			    }
			    
			    if(found == false)
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		loop = true;
			    	}
			    	else if(reply == JOptionPane.NO_OPTION)
			    	{
			    		frame1.dispose();
			    		loop = false;
			    	
			    		admin();
			    	}
			    }
			    else
			    {
			    	loop = false;
			    }
			   
			    }
				
				frame1.dispose();
				
				frame1.dispose();
				frame1 = new JFrame("Administrator Menu");
				frame1.setSize(400, 300);
				frame1.setLocation(200, 200);
				frame1.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) { System.exit(0); }
				});       
				
				firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
				surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
				ppsLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
				dobLabel = new JLabel("Date of birth", SwingConstants.LEFT);
				customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
				passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
				firstNameTextField = new JTextField(20);
				surnameTextField = new JTextField(20);
				ppsTextField = new JTextField(20);
				dobTextField = new JTextField(20);
				customerIDTextField = new JTextField(20);
				passwordTextField = new JTextField(20);
				
				JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
				JPanel cancelPanel = new JPanel();
				
				textPanel.add(firstNameLabel);
				textPanel.add(firstNameTextField);
				textPanel.add(surnameLabel);
				textPanel.add(surnameTextField);
				textPanel.add(ppsLabel);
				textPanel.add(ppsTextField);
				textPanel.add(dobLabel);
				textPanel.add(dobTextField);
				textPanel.add(customerIDLabel);
				textPanel.add(customerIDTextField);
				textPanel.add(passwordLabel);
				textPanel.add(passwordTextField);

		
				
				//JLabel label1 = new JLabel("Edit customer details below. The save");
				
			
				JButton saveButton = new JButton("Save");
				JButton cancelButton = new JButton("Exit");
				
				cancelPanel.add(cancelButton, BorderLayout.SOUTH);
				cancelPanel.add(saveButton, BorderLayout.SOUTH);
			   //content.removeAll();
				Container content = frame1.getContentPane();
				content.setLayout(new GridLayout(2, 1));
				content.add(textPanel, BorderLayout.NORTH);
				content.add(cancelPanel, BorderLayout.SOUTH);
				
				frame1.setContentPane(content);
				frame1.setSize(340, 350);
				frame1.setLocation(200, 200);
				frame1.setVisible(true);
				frame1.setResizable(false);
				
				saveButton.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
					
				
						firstNameTextField.setText(customer.getFirstName());
						surnameTextField.setText(customer.getSurname());
						ppsTextField.setText(customer.getPps());
						dobTextField.setText(customer.getDob());
						customerIDTextField.setText(customer.getCustomerID());
						passwordTextField.setText(customer.getPassword());	
						
						JOptionPane.showMessageDialog(null, "Changes Saved.");
							}		
					     });
				
				cancelButton.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
						frame1.dispose();
						
						admin();				
					}		
			     });		
				}}
	     });
		
		summaryButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();
				
				
				frame1 = new JFrame("Summary of Transactions");
				frame1.setSize(400, 700);
				frame1.setLocation(200, 200);
				frame1.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) { System.exit(0); }
				});          
				frame1.setVisible(true);
				
				JLabel label1 = new JLabel("Summary of all transactions: ");
				
				JPanel returnPanel = new JPanel();
				JButton returnButton = new JButton("Return");
				returnPanel.add(returnButton);
				
				JPanel textPanel = new JPanel();
				
				textPanel.setLayout( new BorderLayout() );
				JTextArea textArea = new JTextArea(40, 20);
				textArea.setEditable(false);
				textPanel.add(label1, BorderLayout.NORTH);
				textPanel.add(textArea, BorderLayout.CENTER);
				textPanel.add(returnButton, BorderLayout.SOUTH);
				
				JScrollPane scrollPane = new JScrollPane(textArea);
				textPanel.add(scrollPane);
				
			for (int a = 0; a < customerList.size(); a++)//For each customer, for each account, it displays each transaction.
				{
					for (int b = 0; b < customerList.get(a).getAccounts().size(); b ++ )
					{
						acc = customerList.get(a).getAccounts().get(b);
						for (int c = 0; c < customerList.get(a).getAccounts().get(b).getTransactionList().size(); c++)
						{
							
							textArea.append(acc.getTransactionList().get(c).toString());
							//Int total = acc.getTransactionList().get(c).getAmount(); //I was going to use this to keep a running total but I couldnt get it  working.
							
						}				
					}				
				}
				
				
				
				
				textPanel.add(textArea);
				content.removeAll();
				
				
				Container content = frame1.getContentPane();
				content.setLayout(new GridLayout(1, 1));
			//	content.add(label1);
				content.add(textPanel);
				//content.add(returnPanel);
				
				returnButton.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
						frame1.dispose();			
					admin();				
					}		
			     });	
			}	
	     });
		
		navigateButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();
				
				if(customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
					admin();
				}
				else
				{
		
				JButton first, previous, next, last, cancel;
				JPanel gridPanel, buttonPanel, cancelPanel;			
	
				Container content = getContentPane();
				
				content.setLayout(new BorderLayout());
				
				buttonPanel = new JPanel();
				gridPanel = new JPanel(new GridLayout(8, 2));
				cancelPanel = new JPanel();
								
				firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
				surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
				ppsLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
				dobLabel = new JLabel("Date of birth", SwingConstants.LEFT);
				customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
				passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
				firstNameTextField = new JTextField(20);
				surnameTextField = new JTextField(20);
				ppsTextField = new JTextField(20);
				dobTextField = new JTextField(20);
				customerIDTextField = new JTextField(20);
				passwordTextField = new JTextField(20);
				
				first = new JButton("First");
				previous = new JButton("Previous");
				next = new JButton("Next");
				last = new JButton("Last");
				cancel = new JButton("Cancel");
				
				firstNameTextField.setText(customerList.get(0).getFirstName());
				surnameTextField.setText(customerList.get(0).getSurname());
				ppsTextField.setText(customerList.get(0).getPps());
				dobTextField.setText(customerList.get(0).getDob());
				customerIDTextField.setText(customerList.get(0).getCustomerID());
				passwordTextField.setText(customerList.get(0).getPassword());
				
				firstNameTextField.setEditable(false);
				surnameTextField.setEditable(false);
				ppsTextField.setEditable(false);
				dobTextField.setEditable(false);
				customerIDTextField.setEditable(false);
				passwordTextField.setEditable(false);
				
				gridPanel.add(firstNameLabel);
				gridPanel.add(firstNameTextField);
				gridPanel.add(surnameLabel);
				gridPanel.add(surnameTextField);
				gridPanel.add(ppsLabel);
				gridPanel.add(ppsTextField);
				gridPanel.add(dobLabel);
				gridPanel.add(dobTextField);
				gridPanel.add(customerIDLabel);
				gridPanel.add(customerIDTextField);
				gridPanel.add(passwordLabel);
				gridPanel.add(passwordTextField);
				
				buttonPanel.add(first);
				buttonPanel.add(previous);
				buttonPanel.add(next);
				buttonPanel.add(last);
				
				cancelPanel.add(cancel);
		
				content.add(gridPanel, BorderLayout.NORTH);
				content.add(buttonPanel, BorderLayout.CENTER);
				content.add(cancelPanel, BorderLayout.AFTER_LAST_LINE);
				first.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
						position = 0;
						firstNameTextField.setText(customerList.get(0).getFirstName());
						surnameTextField.setText(customerList.get(0).getSurname());
						ppsTextField.setText(customerList.get(0).getPps());
						dobTextField.setText(customerList.get(0).getDob());
						customerIDTextField.setText(customerList.get(0).getCustomerID());
						passwordTextField.setText(customerList.get(0).getPassword());				
							}		
					     });
				
				previous.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
								
						if(position < 1)
						{
							//don't do anything
						}
						else
						{
							position = position - 1;
							
						firstNameTextField.setText(customerList.get(position).getFirstName());
						surnameTextField.setText(customerList.get(position).getSurname());
						ppsTextField.setText(customerList.get(position).getPps());
						dobTextField.setText(customerList.get(position).getDob());
						customerIDTextField.setText(customerList.get(position).getCustomerID());
						passwordTextField.setText(customerList.get(position).getPassword());
						}			
							}		
					     });
				
				next.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
					
						if(position == customerList.size()-1)
						{
							//don't do anything
						}
						else
						{
							position = position + 1;
							
						firstNameTextField.setText(customerList.get(position).getFirstName());
						surnameTextField.setText(customerList.get(position).getSurname());
						ppsTextField.setText(customerList.get(position).getPps());
						dobTextField.setText(customerList.get(position).getDob());
						customerIDTextField.setText(customerList.get(position).getCustomerID());
						passwordTextField.setText(customerList.get(position).getPassword());
						}		
						
						
												
							}		
					     });
				
				last.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
					
						position = customerList.size() - 1;
				
						firstNameTextField.setText(customerList.get(position).getFirstName());
						surnameTextField.setText(customerList.get(position).getSurname());
						ppsTextField.setText(customerList.get(position).getPps());
						dobTextField.setText(customerList.get(position).getDob());
						customerIDTextField.setText(customerList.get(position).getCustomerID());
						passwordTextField.setText(customerList.get(position).getPassword());								
							}		
					     });
				
				cancel.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {				
						dispose();
						admin();
							}		
					     });			
				setContentPane(content);
				setSize(400, 300);
			       setVisible(true);
					}		
			}
		});
		
		accountButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();
				
				if(customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(frame1, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					frame1.dispose();
					admin();
				}
				else
				{
				boolean loop = true;
				
				boolean found = false;
			
			    while(loop)
			    {
			    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer You Wish to Add an Account to:");
			    
			    for (Customer aCustomer: customerList){
			    	
			    	if(aCustomer.getCustomerID().equals(customerID))
			    	{
			    		found = true;
			    		customer = aCustomer; 	
			    	}					    	
			    }
			    
			    if(found == false)
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		loop = true;
			    	}
			    	else if(reply == JOptionPane.NO_OPTION)
			    	{
			    		frame1.dispose();
			    		loop = false;
			    	
			    		admin();
			    	}
			    }
			    else
			    {
			    	loop = false;
			    	//a combo box in an dialog box that asks the admin what type of account they wish to create (deposit/current)
				    String[] choices = { "Current Account", "Deposit Account" };
				    String account = (String) JOptionPane.showInputDialog(null, "Please choose account type",
				        "Account Type", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]); 
				    
				    if(account.equals("Current Account"))
				    {
				    	//create current account
				    	boolean valid = true;
				    	double balance = 0;
				    	String number = String.valueOf("C" + (customerList.indexOf(customer)+1) * 10 + (customer.getAccounts().size()+1));//this simple algorithm generates the account number
				    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
				    	int randomPIN = (int)(Math.random()*9000)+1000;
				           String pin = String.valueOf(randomPIN);
				    
				           ATMCard atm = new ATMCard(randomPIN, valid);
				    	
				    	CustomerCurrentAccount current = new CustomerCurrentAccount(atm, number, balance, transactionList);
				    	
				    	customer.getAccounts().add(current);
				    	JOptionPane.showMessageDialog(frame1, "Account number = " + number +"\n PIN = " + pin  ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
				    	
				    	frame1.dispose();
				    	admin();
				    }
				    
				    if(account.equals("Deposit Account"))
				    {
				    	//create deposit account
				    	
				    	double balance = 0, interest = 0;
				    	String number = String.valueOf("D" + (customerList.indexOf(customer)+1) * 10 + (customer.getAccounts().size()+1));//this simple algorithm generates the account number
				    	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
				        	
				    	CustomerDepositAccount deposit = new CustomerDepositAccount(interest, number, balance, transactionList);
				    	
				    	customer.getAccounts().add(deposit);
				    	JOptionPane.showMessageDialog(frame1, "Account number = " + number ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
				    	
				    	frame1.dispose();
				    	admin();
				    }
			    
			    }			   
			    }
				}
			}
	     });		

		deleteCustomer.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				boolean found = true, loop = true;
				
				if(customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
					dispose();
					admin();
				}
				else
				{
					 {
						    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer You Wish to Delete:");
						    
						    for (Customer aCustomer: customerList){
						    	
						    	if(aCustomer.getCustomerID().equals(customerID))
						    	{
						    		found = true;
						    		customer = aCustomer; 
						    		loop = false;
						    	}					    	
						    }
						    
						    if(found == false)
						    {
						    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
						    	if (reply == JOptionPane.YES_OPTION) {
						    		loop = true;
						    	}
						    	else if(reply == JOptionPane.NO_OPTION)
						    	{
						    		frame1.dispose();
						    		loop = false;
						    		
						    		admin();
						    	}
						    }  
						    else
						    {
						    	if(customer.getAccounts().size()>0)
						    	{
						    		JOptionPane.showMessageDialog(frame1, "This customer has accounts. \n You must delete a customer's accounts before deleting a customer " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
						    	}
						    	else
						    	{
						    		customerList.remove(customer);
						    		JOptionPane.showMessageDialog(frame1, "Customer Deleted " ,"Success.",  JOptionPane.INFORMATION_MESSAGE);
						    	}
						    }
						    
						    
				}}
			}
	     });		
		
		deleteAccount.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
	boolean found = true, loop = true;
				
				
				
				
					 {
						    Object customerID = JOptionPane.showInputDialog(frame1, "Customer ID of Customer from which you wish to delete an account");
						    
						    for (Customer aCustomer: customerList){
						    	
						    	if(aCustomer.getCustomerID().equals(customerID))
						    	{
						    		found = true;
						    		customer = aCustomer; 
						    		loop = false;
						    	}					    	
						    }
						    
						    if(found == false)
						    {
						    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
						    	if (reply == JOptionPane.YES_OPTION) {
						    		loop = true;
						    	}
						    	else if(reply == JOptionPane.NO_OPTION)
						    	{
						    		frame1.dispose();
						    		loop = false;
						    	
						    		admin();
						    	}
						    }  
						    else
						    {
						    	//Here I would make the user select a an account to delete from a combo box. If the account had a balance of 0 then it would be deleted. (I do not have time to do this)
						    }
						    
						    
				}}
			
	     });		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();
				menuStart();				
			}
	     });		
	}
	
	public void customer(Customer c)
	{	
		frame1 = new JFrame("Customer Menu");
		c = cust;
		frame1.setSize(400, 300);
		frame1.setLocation(200, 200);
		frame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		frame1.setVisible(true);
		
		if(cust.getAccounts().size() == 0)
		{
			JOptionPane.showMessageDialog(frame1, "This customer does not have any accounts yet. \n An admin must create an account for this customer \n for them to be able to use customer functionality. " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			frame1.dispose();				
			menuStart();
		}
		else
		{
		JPanel buttonPanel = new JPanel();
		JPanel boxPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		
		JLabel label = new JLabel("Select Account:");
		labelPanel.add(label);
		
		JButton returnButton = new JButton("Return");
		buttonPanel.add(returnButton);
		JButton continueButton = new JButton("Continue");
		buttonPanel.add(continueButton);
		
		JComboBox<String> box = new JComboBox<String>();
	    for (int i =0; i < cust.getAccounts().size(); i++)
	    {
	     box.addItem(cust.getAccounts().get(i).getNumber());
	    }
		
	    
	   
	    for(int i = 0; i<cust.getAccounts().size(); i++)
	    {
	    	if(cust.getAccounts().get(i).getNumber() == box.getSelectedItem() )
	    	{
	    		acc = cust.getAccounts().get(i);
	    	}
	    }
	    
	    
	    
	
	    
		boxPanel.add(box);
		content = frame1.getContentPane();
		content.setLayout(new GridLayout(3, 1));
		content.add(labelPanel);
		content.add(boxPanel);
		content.add(buttonPanel);
		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			frame1.dispose();				
			menuStart();				
			}		
	     });
		
		continueButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				
		frame1.dispose();
		
		frame1 = new JFrame("Customer Menu");
		frame1.setSize(400, 300);
		frame1.setLocation(200, 200);
		frame1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		frame1.setVisible(true);
		
		JPanel statementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton statementButton = new JButton("Display Bank Statement");
		statementButton.setPreferredSize(new Dimension(250, 20));
		
		statementPanel.add(statementButton);
		
		JPanel lodgementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton lodgementButton = new JButton("Lodge money into account");
		lodgementPanel.add(lodgementButton);
		lodgementButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel withdrawalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton withdrawButton = new JButton("Withdraw money from account");
		withdrawalPanel.add(withdrawButton);
		withdrawButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Customer Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");
		
		content = frame1.getContentPane();
		content.setLayout(new GridLayout(5, 1));
		content.add(label1);
		content.add(statementPanel);
		content.add(lodgementPanel);
		content.add(withdrawalPanel);
		content.add(returnPanel);
		
		statementButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();
				frame1 = new JFrame("Customer Menu");
				frame1.setSize(400, 600);
				frame1.setLocation(200, 200);
				frame1.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) { System.exit(0); }
				});          
				frame1.setVisible(true);
				
				JLabel label1 = new JLabel("Summary of account transactions: ");
				
				JPanel returnPanel = new JPanel();
				JButton returnButton = new JButton("Return");
				returnPanel.add(returnButton);
				
				JPanel textPanel = new JPanel();
				
				textPanel.setLayout( new BorderLayout() );
				JTextArea textArea = new JTextArea(40, 20);
				textArea.setEditable(false);
				textPanel.add(label1, BorderLayout.NORTH);
				textPanel.add(textArea, BorderLayout.CENTER);
				textPanel.add(returnButton, BorderLayout.SOUTH);
				
				JScrollPane scrollPane = new JScrollPane(textArea);
				textPanel.add(scrollPane);
				
				for (int i = 0; i < acc.getTransactionList().size(); i ++)
				{
					textArea.append(acc.getTransactionList().get(i).toString());
					
				}
				
				textPanel.add(textArea);
				content.removeAll();
				
				
				Container content = frame1.getContentPane();
				content.setLayout(new GridLayout(1, 1));
		      	//content.add(label1);
				content.add(textPanel);
				//content.add(returnPanel);
				
				returnButton.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
						frame1.dispose();			
					customer(cust);				
					}		
			     });										
			}	
	     });
		
		lodgementButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			boolean loop = true;
			boolean on = true;
			double balance = 0;

			if(acc instanceof CustomerCurrentAccount)
			{
				int count = 3;
				int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
				loop = true;
				
				while(loop)
				{
					if(count == 0)
					{
						JOptionPane.showMessageDialog(frame1, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
						((CustomerCurrentAccount) acc).getAtm().setValid(false);
						customer(cust); 
						loop = false;
						on = false;
					}
					
					String Pin = JOptionPane.showInputDialog(frame1, "Enter 4 digit PIN;");
					int i = Integer.parseInt(Pin);
					
				   if(on)
				   {
					if(checkPin == i)
					{
						loop = false;
						JOptionPane.showMessageDialog(frame1, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);
						
					}
					else
					{
						count --;
						JOptionPane.showMessageDialog(frame1, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);					
					}
				
				}
				}
		
				
			}		if(on == true)
					{
				String balanceTest = JOptionPane.showInputDialog(frame1, "Enter amount you wish to lodge:");//the isNumeric method tests to see if the string entered was numeric. 
				if(isNumeric(balanceTest))
				{
					
					balance = Double.parseDouble(balanceTest);
					loop = false;
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame1, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
				}
				
			
			String euro = "\u20ac";
			 acc.setBalance(acc.getBalance() + balance);
			// String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			 Date date = new Date();
			 String date2 = date.toString();
			 String type = "Lodgement";
				double amount = balance;
				
				
				
				
				AccountTransaction transaction = new AccountTransaction(date2, type, amount);
				acc.getTransactionList().add(transaction);
				
			 JOptionPane.showMessageDialog(frame1, balance + euro + " added do you account!" ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
			 JOptionPane.showMessageDialog(frame1, "New balance = " + acc.getBalance() + euro ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
			}

			}	
	     });
		
		withdrawButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				boolean loop = true;
				boolean on = true;
				double withdraw = 0;

				if(acc instanceof CustomerCurrentAccount)
				{
					int count = 3;
					int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
					loop = true;
					
					while(loop)
					{
						if(count == 0)
						{
							JOptionPane.showMessageDialog(frame1, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
							((CustomerCurrentAccount) acc).getAtm().setValid(false);
							customer(cust); 
							loop = false;
							on = false;
						}
						
						String Pin = JOptionPane.showInputDialog(frame1, "Enter 4 digit PIN;");
						int i = Integer.parseInt(Pin);
						
					   if(on)
					   {
						if(checkPin == i)
						{
							loop = false;
							JOptionPane.showMessageDialog(frame1, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);
							
						}
						else
						{
							count --;
							JOptionPane.showMessageDialog(frame1, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);		
						
						}
					
					}
					}
		
				    	
				    	
				    
					
					
				}		if(on == true)
						{
					String balanceTest = JOptionPane.showInputDialog(frame1, "Enter amount you wish to withdraw (max 500):");
					if(isNumeric(balanceTest))
					{
						
						withdraw = Double.parseDouble(balanceTest);
						loop = false;
						
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(frame1, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					}
					if(withdraw > 500)
					{
						JOptionPane.showMessageDialog(frame1, "500 is the maximum you can withdraw at a time." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
						withdraw = 0;
					}
					if(withdraw > acc.getBalance())
					{
						JOptionPane.showMessageDialog(frame1, "Insufficient funds." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
						withdraw = 0;					
					}
				
				String euro = "\u20ac";
				 acc.setBalance(acc.getBalance()-withdraw);
				   //recording transaction:
			//		String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				 Date date = new Date();
				 String date2 = date.toString();
				 
				 String type = "Withdraw";
					double amount = withdraw;
					
		
					AccountTransaction transaction = new AccountTransaction(date2, type, amount);
					acc.getTransactionList().add(transaction);
				 
				 
					
				 JOptionPane.showMessageDialog(frame1, withdraw + euro + " withdrawn." ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
				 JOptionPane.showMessageDialog(frame1, "New balance = " + acc.getBalance() + euro ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
				}
				 
					
					
			}	
	     });
		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				frame1.dispose();		
				menuStart();				
			}
	     });		}		
	     });
	}
	}
	
	public static boolean isNumeric(String str)  // a method that tests if a string is numeric
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}

