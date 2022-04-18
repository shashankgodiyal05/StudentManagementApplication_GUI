
package studentmanagementapplication;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class StudentInformation 
{
    
    public static void main(String[] args) 
    {
        
        //AddStudent adstd = new AddStudent();
        //UpdateStudent updtstd = new UpdateStudent();
        DisplayStudent dispstd = new DisplayStudent();
       
    }
    
}



class AddStudent extends JFrame implements ActionListener   //to take input as the information of student
{

    JLabel lHead, l1, l2, l3, l4, l5, popup;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3;
    JTextArea add;
    
    public AddStudent()
    {
        
        lHead = new JLabel("Add New Student");
        lHead.setBounds(200, 20, 700, 50);
        lHead.setFont(new Font("SAN SARIF", Font.BOLD, 24));
        
        l1 = new JLabel("Name:  ");    
        l1.setBounds(100, 105, 100, 30);
        l1.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t1 = new JTextField(10);
        t1.setBounds(250, 105, 250, 30);
        t1.setFont(new Font("Verdana", Font.PLAIN, 17));
        
        l2 = new JLabel("Class:  ");    
        l2.setBounds(100, 170, 100, 30);
        l2.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t2 = new JTextField(10);
        t2.setBounds(250, 170, 250, 30);
        t2.setFont(new Font("Verdana", Font.PLAIN, 17));
        
        l3 = new JLabel("Section:  ");   
        l3.setBounds(100, 245, 100, 30);
        l3.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t3 = new JTextField(10);
        t3.setBounds(250, 245, 250, 30);
        t3.setFont(new Font("Verdana", Font.PLAIN, 17));
        
        l4 = new JLabel("Student ID:  ");
        l4.setBounds(100, 320, 150, 30);
        l4.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t4 = new JTextField(10);
        t4.setBounds(250, 320, 250, 30);
        t4.setFont(new Font("Verdana", Font.PLAIN, 17));
        
        l5 = new JLabel("Address:  ");
        l5.setBounds(100, 395, 150, 30);
        l5.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        add = new JTextArea();
        add.setBounds(250, 395, 250, 100);
        add.setFont(new Font("Verdana", Font.PLAIN, 17));
        add.setLineWrap(true);
        
        popup = new JLabel();
        popup.setBounds(150, 510, 500, 30);
        popup.setFont(new Font("Vernda", Font.BOLD,12));
        add(popup);
        
        b1 = new JButton("Back");
        b1.setBounds(125, 555, 100, 30);
        b1.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b2 = new JButton("Reset");
        b2.setBounds(250, 555, 100, 30);
        b2.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b3 = new JButton("Add");
        b3.setBounds(375, 555, 100, 30);
        b3.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        
        add(lHead);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(add);
        add(b1);
        add(b2);
        add(b3);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setLayout(null);
        setVisible(true);                          
        setSize(650, 660);           
        setTitle("Student Management Application");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource()==b1)
        {
            new menu();
            dispose();
            
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            add.setText("");
            popup.setText("");
        }
        else
        {
                try 
                {
                    //load the driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //create a connection
                    String url = "jdbc:mysql://localhost:3306/test";
                    String username = "root";
                    String password = "root";

                    Connection con = DriverManager.getConnection(url,username,password);
                    //System.out.println("Connection created...");
            
                    //create a query
                    String q1 = "insert into students(stdId, name, class, section, address) values(?,?,?,?,?)";

                    //get PreparedStatement object
                    PreparedStatement pstmt = con.prepareStatement(q1);
		
                    //System.out.println("Enter the Name : ");
                    String name = t1.getText();
		
                    //System.out.println("Enter the Address : ");
                    String address = add.getText();

                    //System.out.println("Enter the section : ");
                    String section = t3.getText();

                    //System.out.println("Enter the Student's Id : ");
                    int stdId = Integer.parseInt(t4.getText());

                    //System.out.println("Enter Class ");
                    int Class = Integer.parseInt(t2.getText());
		
                    //set the values to query
                    pstmt.setInt(1,stdId);
                    pstmt.setString(2,name);
                    pstmt.setInt(3,Class);
                    pstmt.setString(4,section);
                    pstmt.setString(5,address);
		
                    pstmt.executeUpdate();
		
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    add.setText("");
                    
                    popup.setText("New Student added, Press Reset to Add new Student");
                    
                }   
                catch (Exception ee) 
                {
                    
                    popup.setText("                          ! Kindly fill all the Columns");
                }
                                     
        }
    }
}
    


class UpdateStudent extends JFrame implements ActionListener
{

    JLabel lHead,l1, l2, l3, l4, l5, popup;
    JTextField t1, t2, t3, t4;
    JTextArea add;
    JButton b1, b2, b3;
    
    public UpdateStudent()
    {
        lHead = new JLabel("Update New Student");
        lHead.setBounds(200, 20, 700, 50);
        lHead.setFont(new Font("SAN SARIF", Font.BOLD, 24));
        
        l1 = new JLabel("Name:  ");    
        l1.setBounds(100, 105, 100, 30);
        l1.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t1 = new JTextField(10);
        t1.setBounds(250, 105, 250, 30);
        t1.setFont(new Font("Verdana", Font.PLAIN, 17));
        
        l2 = new JLabel("Class:  ");    
        l2.setBounds(100, 170, 100, 30);
        l2.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t2 = new JTextField(10);
        t2.setBounds(250, 170, 250, 30);
        t2.setFont(new Font("Verdana", Font.PLAIN, 17));
        
        l3 = new JLabel("Section:  ");   
        l3.setBounds(100, 245, 100, 30);
        l3.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t3 = new JTextField(10);
        t3.setBounds(250, 245, 250, 30);
        t3.setFont(new Font("Verdana", Font.PLAIN, 17));
        
        l4 = new JLabel("Student ID:  ");
        l4.setBounds(100, 320, 150, 30);
        l4.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t4 = new JTextField(10);
        t4.setBounds(250, 320, 250, 30);
        t4.setFont(new Font("Verdana", Font.PLAIN, 17));
        
        l5 = new JLabel("Address:  ");
        l5.setBounds(100, 395, 150, 30);
        l5.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        add = new JTextArea();
        add.setBounds(250, 395, 250, 100);
        add.setFont(new Font("Verdana", Font.PLAIN, 17));
        add.setLineWrap(true);
        
        popup = new JLabel();
        popup.setBounds(150, 510, 500, 30);
        popup.setFont(new Font("Vernda", Font.BOLD,12));
        add(popup);
        
        b1 = new JButton("Back");
        b1.setBounds(125, 555, 100, 30);
        b1.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b2 = new JButton("Reset");
        b2.setBounds(250, 555, 100, 30);
        b2.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b3 = new JButton("Update");
        b3.setBounds(375, 555, 100, 30);
        b3.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        
        add(lHead);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(add);
        add(b1);
        add(b2);
        add(b3);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setLayout(null);
        setVisible(true);                          
        setSize(650, 660);           
        setTitle("Student Management Application");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {

        if(e.getSource()==b1)
        {
            new menu();
            dispose();
            
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            add.setText("");
            popup.setText("");
        }
        else
        {
            try 
            {
                //load the driver
                Class.forName("com.mysql.jdbc.Driver");

                //create a connection
                String url = "jdbc:mysql://localhost:3306/test";
                String username = "root";
                String password = "root";

                Connection con = DriverManager.getConnection(url,username,password);
            
                //create a query
		String q1 = "update students set name = ?, class = ?, section = ?, address = ? where stdId = ?";

		//get PreparedStatement object
		PreparedStatement pstmt = con.prepareStatement(q1);
		
		//System.out.println("Enter the Name : ");
		String name = t1.getText();
		
		//System.out.println("Enter the Address : ");
		String address = add.getText();

		//System.out.println("Enter the section : ");
		String section = t3.getText();

		//System.out.println("Enter the Student's Id : ");
		int stdId = Integer.parseInt(t4.getText());

		//System.out.println("Enter Class ");
		int Class = Integer.parseInt(t2.getText());
		
		//set the values to query
		pstmt.setInt(5,stdId);
		pstmt.setString(1,name);
		pstmt.setInt(2,Class);
		pstmt.setString(3,section);
		pstmt.setString(4,address);
		
		pstmt.executeUpdate();
		
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                add.setText("");
                
                popup.setText("Updated, Press Reset to Update another Student's information");
		
            } 
        
            catch (Exception ee) 
            {
                //ee.printStackTrace();
                popup.setText("                          ! Kindly fill all the Columns");
            }
       
        }
    
    }  
}



class DisplayStudent extends JFrame implements ActionListener
{
    JLabel lHead,l1, l2, l3, l4, l5, popup;
    JTextField t1, t2, t3, t4;
    JTextArea add;
    JButton b1, b2, b3;
    
    public DisplayStudent()
    {
        lHead = new JLabel("Student Information");
        lHead.setBounds(200, 20, 700, 50);
        lHead.setFont(new Font("SAN SARIF", Font.BOLD, 24));
        
        l1 = new JLabel("Student Id:  ");    
        l1.setBounds(100, 105, 150, 30);
        l1.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t1 = new JTextField(10);
        t1.setBounds(250, 105, 250, 30);
        t1.setFont(new Font("Verdana", Font.PLAIN, 17));
        
        l2 = new JLabel("Name:  ");    
        l2.setBounds(100, 170, 100, 30);
        l2.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t2 = new JTextField(10);
        t2.setBounds(250, 170, 250, 30);
        t2.setFont(new Font("Verdana", Font.PLAIN, 17));
        t2.setEditable(false);
        
        l3 = new JLabel("Class:  ");   
        l3.setBounds(100, 245, 100, 30);
        l3.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t3 = new JTextField(10);
        t3.setBounds(250, 245, 250, 30);
        t3.setFont(new Font("Verdana", Font.PLAIN, 17));
        t3.setEditable(false);
        
        l4 = new JLabel("Section:  ");
        l4.setBounds(100, 320, 150, 30);
        l4.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        t4 = new JTextField(10);
        t4.setBounds(250, 320, 250, 30);
        t4.setFont(new Font("Verdana", Font.PLAIN, 17));
        t4.setEditable(false);
        
        l5 = new JLabel("Address:  ");
        l5.setBounds(100, 395, 150, 30);
        l5.setFont(new Font("Verdana", Font.PLAIN, 19));
        
        add = new JTextArea();
        add.setBounds(250, 395, 250, 100);
        add.setFont(new Font("Verdana", Font.PLAIN, 17));
        add.setLineWrap(true);
        add.setEditable(false);
        
        popup = new JLabel();
        popup.setBounds(150, 510, 500, 30);
        popup.setFont(new Font("Vernda", Font.BOLD,12));
        add(popup);
        
        b1 = new JButton("Back");
        b1.setBounds(125, 555, 100, 30);
        b1.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b2 = new JButton("Reset");
        b2.setBounds(250, 555, 100, 30);
        b2.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b3 = new JButton("Show");
        b3.setBounds(375, 555, 100, 30);
        b3.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        
        add(lHead);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(add);
        add(b1);
        add(b2);
        add(b3);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setLayout(null);
        setVisible(true);                          
        setSize(650, 660);           
        setTitle("Student Management Application");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {

        if(e.getSource()==b1)
        {
            new menu();
            dispose();
            
        }
        else if(e.getSource()==b2)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            add.setText("");
            popup.setText("");
        }
        else
        {
            try 
            {
                //load the driver
                Class.forName("com.mysql.jdbc.Driver");

                //create a connection
                String url = "jdbc:mysql://localhost:3306/test";
                String username = "root";
                String password = "root";

                Connection con = DriverManager.getConnection(url,username,password);
            
                String q4 = "select * from students where stdId = ?";

		//get PreparedStatement object
		PreparedStatement pstmt = con.prepareStatement(q4);
					
		int stdId = Integer.parseInt(t1.getText());
                
		pstmt.setInt(1, stdId);
					
		ResultSet set = pstmt.executeQuery();
					
		while (set.next()) 
                {
                    stdId = set.getInt("stdId");
                    t1.setText(stdId + "");
                    String Name = set.getString("name");
                    t2.setText(Name + "");
                    int Class = set.getInt("class");
                    t3.setText(Class + "");
                    String Section = set.getString("section");
                    t4.setText(Section + "");
                    String Address = set.getString("address");
                    add.setText(Address + "");
                    
		}
		  
		popup.setText("");
            } 
        
            catch (Exception ee) 
            {
                //ee.printStackTrace();
                popup.setText("                          ! Kindly fill Student Id");
            }
       
        }
    } 
}
