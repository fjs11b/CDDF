import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Contact extends Module
{

	/**
	 * Serializable
	 */
	

	String modulecode;
	
	String firstname, lastname;
	Integer contactType;
	String phone, fax;
	Date creationDate;
	Integer customerId = 0, customerStatus = 0;
	
	
	/**
	 * Constructor
	 */
	Contact(){
		this.setModuleCode("CONTACT");
	}
	
	/**
	 * @see Module::formEdit()
	 */
	void formEdit()
	{
		
		
		//Build a panel
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		
		//Adding Fields to the form
	    JTextField fl1 = new JTextField(this.getFirstname());
	    panel.add(new JLabel(Constants.CONT_FIRSTNAME+":"));
	    panel.add(fl1);
	    
	    JTextField fl2 = new JTextField(this.getLastname());
	    panel.add(new JLabel("Lastname:"));
	    panel.add(fl2);
	    
	    String[] items1 = {"Customer", "Attorney", "Administrator", "Paralegal", "Other"};
	    JComboBox fl3 = new JComboBox(items1);
	    panel.add(new JLabel("Contact Type:"));
		panel.add(fl3);
		
		String[] items2 = { "Inactive", "Active"};
	    JComboBox fl4 = new JComboBox(items2);
	    panel.add(new JLabel("Contact Status:"));
		panel.add(fl4);
	    
		JTextField fl5 = new JTextField(this.getLastname());
	    panel.add(new JLabel("Phone:"));
	    panel.add(fl5);
		
	    JTextField fl6 = new JTextField(this.getLastname());
	    panel.add(new JLabel("Fax:"));
	    panel.add(fl6);

	    
	    int result = JOptionPane.showConfirmDialog(null, panel, Constants.CONT_MOD_TITLE, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    if (result == JOptionPane.OK_OPTION) {
	    	
	    	this.setFirstname(fl1.getText());
	    	this.setLastname(fl2.getText());
	    	if(this.validateRecord())
	    	{
	    		this.setLoaded(true);//setting flag.
	    		this.saveRecord();
	    		OutputBox.display(0, Constants.CONT_MOD_TITLE, Constants.GEN_LBL_THANKYOU);
	    		
	    	}else{
	    		
	    		this.setLoaded(false);//setting flag.
	    		this.formEdit();
	    		
	    	}
	    	
	    } else {
	    	
	    	//Set defaults and close
	    	this.initRecord();
	    	this.setLoaded(false);

	    }

		
		
	}
	
	
	/**
	 * @see Module::searchRecord()
	 */
	void searchRecord(){
		JFrame frame = new JFrame(Constants.CONT_MOD_TITLE);
		
		JPanel panel = new JPanel();
		
		//Read the file into a collection
		//Set sise of the grid base on the size of the collection
		//Display the grid
		panel.setLayout(new GridLayout(5,4,10,10));
		
		panel.add(new JLabel("Sel"));
		panel.add(new JLabel("First Name"));
		panel.add(new JLabel("Last Name"));
		panel.add(new JLabel("Phone"));
		
		//Read all rows an loop for each contact
		panel.add(new JCheckBox("1"));
		panel.add(new JLabel("Peter"));
		panel.add(new JLabel("Wilson"));
		panel.add(new JLabel("230-012-0122"));

		panel.add(new JCheckBox("1"));
		panel.add(new JLabel("Peter"));
		panel.add(new JLabel("Wilson"));
		panel.add(new JLabel("230-012-0122"));

		panel.add(new JCheckBox("1"));
		panel.add(new JLabel("Peter"));
		panel.add(new JLabel("Wilson"));
		panel.add(new JLabel("230-012-0122"));
		
		//panel.add(new JTextField(5));
		
		panel.add(new JButton("Modify"));
		panel.add(new JButton("Delete"));
		panel.add(new JLabel(""));
		panel.add(new JButton("Close"));
		
		frame.add(panel);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
	
	/**
	 * @see Module::validateRecord()
	 */
	boolean validateRecord(){
		
		//Validating first name
		if(this.getFirstname().equals("")){
			//Just a little note
			OutputBox.alert(Constants.CONT_MOD_TITLE, "Invalid Firstname");
			return false;
		}
		
		return true;	
	}
	
	/**
	 * @see Module::initRecord()
	 */
	void initRecord(){
		
	}
	
	/**
	 * @see Module::loadRecord()
	 */
	void loadRecord(){
		//to be implemented read file 
		
	}
	
	/**
	 * @see Module::loadRecord()
	 */
	void saveRecord(){
	
		//Just adding a string with separators. Constants holds the character sep.
		String line = this.getFirstname()
				+Constants.CSV_FIELD_SEPARATOR
				+this.getLastname()
				+Constants.CSV_FIELD_SEPARATOR
				+this.getPhone()
				+Constants.CSV_ROW_SEPARATOR;
		String data_File = Constants.APP_DATA_FOLDER+"/contacts.csv";
		TheFile f = new TheFile(data_File);
		f.appendFile(line);
		
	}
	
	
	/**
	 * @see Module::formView()
	 */
	void formView()
	{
		System.out.println("formView");
	}
	
	/**
	 * @see Module::dump()
	 */
	void dump(){
		super.dump();
		if(this.isLoaded()){
			System.out.println("The contact name is: "+this.getLastname()+", "+this.getFirstname());
		}else{
			System.out.println("Contact not loaded yet.");
		}
	}
	
	//--------------------------------
	//Now Local assessors and setters
	//--------------------------------
	
	
	void setFirstname(String value){
		this.firstname = value;
	}
	
	String getFirstname(){
		return this.firstname;
	}
	
	void setLastname(String value){
		this.lastname = value;
	}
	
	String getLastname(){
		return this.lastname;
	}
	
	String getPhone(){
		return this.phone;
	}
	
	void setPhone(String phone){
		this.phone = phone;
	}
	
}//end class
