
	import java.awt.Color;
	import java.awt.Container;
	import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
	
		public  class PatientLoginSucess extends JFrame implements ActionListener {
		
			private JTable table;
			private JScrollPane scroll;
			private DefaultTableModel model ;
			
	private String [] columns = {"Name","Age","Phone","Problem"};
	private String [] row = new String [4];
			
		private Container c ;
		private JLabel titleLabel,fnLabel,lnLabel,phoneLabel,gpaLabel;
		private JTextField fnTf,lnTf,phoneTf,gpaTf;
		private JButton addButton,clearButton,deleteButton,saveButton,LogoutButton;
		protected Window frame;
		
		PatientLoginSucess (){
			initComponents ();
			
		}

		public void initComponents() {
			
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.setSize(700,690);
			this.setLocationRelativeTo(null);
			this.setTitle("The Hospital Management");
			
			c = this.getContentPane();
			c.setLayout(null);
			c.setBackground(Color.YELLOW);
			
			
			
			Font font = new Font ("Arial",Font.BOLD,18);
			titleLabel = new JLabel ("The Hospital Management");
			titleLabel.setFont(font);
			titleLabel.setBounds(180,10,250,50);
			c.add(titleLabel);
			
			fnLabel = new JLabel (" Name ");			
			fnLabel.setBounds(10,80,180,30);
			fnLabel.setFont(font);
			c.add(fnLabel);
			
			fnTf = new JTextField();
			fnTf.setBounds(110,80,200,30);
			fnTf.setFont(font);
			c.add(fnTf);
			
			addButton = new JButton("ADD");
			addButton.setBounds(400,80,100,30);
			addButton.setFont(font);
			c.add(addButton);
			
			lnLabel = new JLabel (" Age ");
			lnLabel.setBounds(10,130,150,30);  
			lnLabel.setFont(font);
			c.add(lnLabel);
			
			lnTf = new JTextField ();
			lnTf.setBounds(110,130,150,30);
			lnTf.setFont (font);
			c.add(lnTf);
			
			saveButton = new JButton("Save");
			saveButton.setBounds(400,130,100,30);
			saveButton.setFont(font);
			c.add(saveButton);	
			
			LogoutButton = new JButton ("Log Out");
			LogoutButton.setBounds(500,300,150,30);
			LogoutButton.setFont(font);
			c.add(LogoutButton);
			
			phoneLabel = new JLabel (" Phone ");
			phoneLabel.setBounds(10,180,150,30);
			phoneLabel.setFont(font);
			c.add(phoneLabel);
			
			phoneTf = new JTextField ();
			phoneTf.setBounds(110,180,200,30);
			phoneTf.setFont(font);
			c.add(phoneTf);
			
			
			deleteButton = new JButton ("Delete");
			deleteButton.setBounds(400,180,100,30);
			deleteButton.setFont(font);
			c.add(deleteButton);
			
			
			gpaLabel = new JLabel(" Problem ");
			gpaLabel.setBounds(10,230,150,50);
			gpaLabel.setFont(font);
			c.add(gpaLabel);
			
			
			gpaTf = new JTextField ();
			gpaTf.setBounds(110,230,100,30);
			gpaTf.setFont(font);
			c.add(gpaTf);
			
			clearButton = new JButton("Clear");
			
			clearButton.setBounds(400,230,100,30);
			clearButton.setFont(font);
			c.add(clearButton);
			
			
			
			table = new JTable();
			model = new DefaultTableModel ();
			model.setColumnIdentifiers(columns);
			table.setModel(model);
			table.setFont(font);
			table.setSelectionBackground(Color.MAGENTA);
			table.setBackground(Color.WHITE);
			table.setRowHeight(30);
			
			
			scroll = new JScrollPane(table);
			scroll.setBounds(0,360,740,265);
			c.add(scroll);
			
			addButton.addActionListener(this);
			saveButton.addActionListener(this);
			LogoutButton.addActionListener(this);
			clearButton.addActionListener(this);
		
		} 	

		
			
		@Override
		public void actionPerformed(ActionEvent e) {
		if(e.getSource()== addButton) {
			
			row[0] = fnTf.getText(); 
			row[1] = lnTf.getText();
			row[2] = phoneTf.getText();
			row[3] = gpaTf.getText();
			model.addRow(row);
		}
		else if (e.getSource()== clearButton) {
			
		fnTf.setText("");
		lnTf.setText("");
		phoneTf.setText("");
		gpaTf.setText("");
		
		}
		 else if (e.getSource()==saveButton) {
	    	 try {
	 			Formatter formatter = new Formatter ("E:/java 215/Java Project/DataFile.txt");
	 			
	 			for(int i = 0; i < table.getRowCount(); i++) {
	 				String r1 = (model.getValueAt(i, 0)).toString();
	 				String r2 = (model.getValueAt(i, 1)).toString();
	 				String r3 = (model.getValueAt(i, 2)).toString();
	 				String r4 = (model.getValueAt(i, 3)).toString();
	 				
	 			   formatter.format("%s,%s,%s,%s,\r%n", r1, r2, r3, r4);
	 			}
	 			
	 			formatter.close();
	 		 }
	 		 catch(FileNotFoundException ex ) {
	 	  	  
	 	  	  System.out.println(ex);
	 	  	  
	 		   }}
		else if (e.getSource()==LogoutButton) {
			
			Hospital.main(new String[]{});
			dispose();
		}
		
		}
			
		
	
		

	public static void main(String[] args) {
		PatientLoginSucess frame = new PatientLoginSucess();
		frame.setVisible(true);

	}

		}
	

		
