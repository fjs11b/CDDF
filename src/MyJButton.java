import javax.swing.JButton;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
* Class MuJButton
* 
* Legal Case Management System
* Florida State University
* @author Francisco Santana, Chad Wolfe, Daniel Weston, Dean Burgos
* @version 1
* @since 2013-03-01
*/
public class MyJButton extends JButton{
	static final long serialVersionUID = 0;//To prevent warning
	
	Container c;
	MyJFrame f;
	
	
	MyJButton(MyJFrame f){
		this.f = f;
		c = f.getContentPane();
		
	}
	
	
	/**
	 * Adds button to screen
	 */
	void add_buttons(){
		
		//Container set as grid
		Container content = f.getContentPane(); 
		
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		content.setLayout(gbag);
		
	
		//Contacts
		JButton b = new JButton("Create Contact");
		b.addMouseListener(new ButtonAction(1));
		c.add(b);
		
		JButton ContactSearch = new JButton("Search Contact");
		ContactSearch.addMouseListener(new ButtonAction(2));
		c.add(ContactSearch);
		
		//Another
		b = new JButton("Create Case");
		b.addMouseListener(new ButtonAction(2));
		c.add(b);
		
		//Etc
		b = new JButton("Create Activity");
		b.addMouseListener(new ButtonAction(3));
		c.add(b);
		
	}
	
}//end class
