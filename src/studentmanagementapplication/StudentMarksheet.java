
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
import javax.swing.JTextField;


public class StudentMarksheet 
{
   
    public static void main(String[] args) 
    {
        CreateMarksheet cms = new CreateMarksheet();
        
    }
    
}

class CreateMarksheet extends JFrame implements ActionListener
{

    JLabel lHead, l1, inst, l2, l3, l4, l5, l6, l7, popup;
    JButton b1, b2, b3;
    JTextField f1, f2, f3, f4, f5, f6, f7;
    
    public CreateMarksheet()
    {
        
        lHead = new JLabel("Prepare Marksheet");
        lHead.setBounds(210, 30, 700, 50);
        lHead.setFont(new Font("SAN SARIF", Font.BOLD, 24));
        add(lHead);
        
        l1 = new JLabel("Student Id:  "); 
        l1.setBounds(50, 120, 200, 30);
        l1.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l1);
        
        f1 = new JTextField(10);
        f1.setBounds(175, 120, 200, 30);
        f1.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f1);
        
        inst = new JLabel("Enter marks of the Student in following Subjects:-  ");
        inst.setBounds(50, 190, 500, 30);
        inst.setFont(new Font("", Font.PLAIN, 20));
        add(inst);
        
        l2 = new JLabel("Hindi : ");
        l2.setBounds(60, 260, 200, 30);
        l2.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l2);
        
        f2 = new JTextField(5);
        f2.setBounds(150, 265, 75, 25);
        f2.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f2);
        
        l3 = new JLabel("English : ");
        l3.setBounds(350, 260, 200, 30);
        l3.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l3);
        
        f3 = new JTextField(5);
        f3.setBounds(460, 265, 75, 25);
        f3.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f3);
        
        l4 = new JLabel("Maths : ");
        l4.setBounds(60, 335, 200, 30);
        l4.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l4);
        
        f4 = new JTextField(5);
        f4.setBounds(150, 340, 75, 25);
        f4.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f4);
        
        l5 = new JLabel("Science : ");
        l5.setBounds(350, 335, 200, 30);
        l5.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l5);
        
        f5 = new JTextField(5);
        f5.setBounds(460, 340, 75, 25);
        f5.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f5);
        
        l6 = new JLabel("SST : ");
        l6.setBounds(60, 405, 200, 30);
        l6.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l6);
        
        f6 = new JTextField(5);
        f6.setBounds(150, 410, 75, 25);
        f6.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f6);
        
        l7 = new JLabel("Sanskrit : ");
        l7.setBounds(350, 405, 200, 30);
        l7.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l7);
        
        f7 = new JTextField(5);
        f7.setBounds(460, 410, 75, 25);
        f7.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f7);
        
        popup = new JLabel();
        popup.setBounds(115, 485, 500, 30);
        popup.setFont(new Font("Vernda", Font.BOLD,12));
        add(popup);
        
        b1 = new JButton("Back");
        b1.setBounds(125, 540, 100, 30);
        b1.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b2 = new JButton("Reset");
        b2.setBounds(250, 540, 100, 30);
        b2.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b3 = new JButton("Prepare");
        b3.setBounds(375, 540, 100, 30);
        b3.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        add(b1);
        add(b2);
        add(b3);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setLayout(null); 
        setVisible(true);    
        setSize(635, 650);    
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
            f1.setText("");
            f2.setText("");
            f3.setText("");
            f4.setText("");
            f5.setText("");
            f6.setText("");
            f7.setText("");
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
                String q5 = "insert into results(stdId, Hindi, English, Maths, Science, SST, Sanskrit) values(?,?,?,?,?,?,?)";

		//get PreparedStatement object
		PreparedStatement pstmt = con.prepareStatement(q5);

		//System.out.println("Enter the Student's Id : ");
		int stdId = Integer.parseInt(f1.getText());

		//System.out.println("Enter marks in Hindi : ");
		int Hindi = Integer.parseInt(f2.getText());
		
		//System.out.println("Enter marks in English : ");
		int English = Integer.parseInt(f3.getText());

		//System.out.println("Enter marks in Maths : ");
		int Maths = Integer.parseInt(f4.getText());

		//System.out.println("Enter marks in Science : ");
		int Science = Integer.parseInt(f5.getText());

		//System.out.println("Enter marks in SST : ");
		int SST = Integer.parseInt(f6.getText());

		//System.out.println("Enter marks in Sanskrit : ");
		int Sanskrit = Integer.parseInt(f7.getText());

					//set the values to query
		pstmt.setInt(1,stdId);
		pstmt.setInt(2,Hindi);
		pstmt.setInt(3,English);
		pstmt.setInt(4,Maths);
		pstmt.setInt(5,Science);
		pstmt.setInt(6,SST);
		pstmt.setInt(7,Sanskrit);
		
		pstmt.executeUpdate();
		
                f1.setText("");
                f2.setText("");
                f3.setText("");
                f4.setText("");
                f5.setText("");
                f6.setText("");
                f7.setText("");
                
                popup.setText("Marksheet Prepared, Press Reset to Prepare another Marksheet");
                    
            }   
            catch (Exception ee) 
            {
                    
                popup.setText("                                      ! Kindly fill all the Columns");
            }
            
            
        }
    }
    
}

class UpdateMarksheet extends JFrame implements ActionListener
{

    JLabel lHead, l1, inst, l2, l3, l4, l5, l6, l7, popup;
    JButton b1, b2, b3;
    JTextField f1, f2, f3, f4, f5, f6, f7;
    
    public UpdateMarksheet()
    {
        lHead = new JLabel("Update Marksheet");
        lHead.setBounds(210, 30, 700, 50);
        lHead.setFont(new Font("SAN SARIF", Font.BOLD, 24));
        add(lHead);
        
        l1 = new JLabel("Student Id:  "); 
        l1.setBounds(50, 120, 200, 30);
        l1.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l1);
        
        f1 = new JTextField(10);
        f1.setBounds(175, 120, 200, 30);
        f1.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f1);
        
        inst = new JLabel("Enter marks of the Student in following Subjects:-  ");
        inst.setBounds(50, 190, 500, 30);
        inst.setFont(new Font("", Font.PLAIN, 20));
        add(inst);
        
        l2 = new JLabel("Hindi : ");
        l2.setBounds(60, 260, 200, 30);
        l2.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l2);
        
        f2 = new JTextField(5);
        f2.setBounds(150, 265, 75, 25);
        f2.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f2);
        
        l3 = new JLabel("English : ");
        l3.setBounds(350, 260, 200, 30);
        l3.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l3);
        
        f3 = new JTextField(5);
        f3.setBounds(460, 265, 75, 25);
        f3.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f3);
        
        l4 = new JLabel("Maths : ");
        l4.setBounds(60, 335, 200, 30);
        l4.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l4);
        
        f4 = new JTextField(5);
        f4.setBounds(150, 340, 75, 25);
        f4.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f4);
        
        l5 = new JLabel("Science : ");
        l5.setBounds(350, 335, 200, 30);
        l5.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l5);
        
        f5 = new JTextField(5);
        f5.setBounds(460, 340, 75, 25);
        f5.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f5);
        
        l6 = new JLabel("SST : ");
        l6.setBounds(60, 405, 200, 30);
        l6.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l6);
        
        f6 = new JTextField(5);
        f6.setBounds(150, 410, 75, 25);
        f6.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f6);
        
        l7 = new JLabel("Sanskrit : ");
        l7.setBounds(350, 405, 200, 30);
        l7.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l7);
        
        f7 = new JTextField(5);
        f7.setBounds(460, 410, 75, 25);
        f7.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f7);
        
        popup = new JLabel();
        popup.setBounds(125, 485, 500, 30);
        popup.setFont(new Font("Vernda", Font.BOLD,12));
        add(popup);
        
        b1 = new JButton("Back");
        b1.setBounds(125, 525, 100, 30);
        b1.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b2 = new JButton("Reset");
        b2.setBounds(250, 525, 100, 30);
        b2.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b3 = new JButton("Update");
        b3.setBounds(375, 525, 100, 30);
        b3.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        add(b1);
        add(b2);
        add(b3);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setLayout(null); 
        setVisible(true);    
        setSize(650, 650);    
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
            f1.setText("");
            f2.setText("");
            f3.setText("");
            f4.setText("");
            f5.setText("");
            f6.setText("");
            f7.setText("");
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
            
                String q6 = "update results set Hindi = ?, English = ?, Maths = ?, Science = ?, SST = ?, Sanskrit = ? where stdId = ?";

                //get PreparedStatement object
                PreparedStatement pstmt = con.prepareStatement(q6);
					
                int Hindi = Integer.parseInt(f2.getText());
		
		int English = Integer.parseInt(f3.getText());

		int Maths = Integer.parseInt(f4.getText());

		int Science = Integer.parseInt(f5.getText());

		int SST = Integer.parseInt(f6.getText());

		int Sanskrit = Integer.parseInt(f7.getText());
		
		int stdId = Integer.parseInt(f1.getText());

		//set the values to query
		pstmt.setInt(1,Hindi);
		pstmt.setInt(2,English);
		pstmt.setInt(3,Maths);
		pstmt.setInt(4,Science);
		pstmt.setInt(5,SST);
		pstmt.setInt(6,Sanskrit);
		pstmt.setInt(7,stdId);
		
		pstmt.executeUpdate();
                
                f1.setText("");
                f2.setText("");
                f3.setText("");
                f4.setText("");
                f5.setText("");
                f6.setText("");
                f7.setText("");
		
                popup.setText("Marksheet Updated, Press Reset to Update another Marksheet");
                
            }
            catch (Exception ee)
            {
                  
                popup.setText("                                  ! Kindly fill all the Columns");
            }
        }  
    }
}

class DisplayMarksheet extends JFrame implements ActionListener
{
    JLabel lHead, l1, name, l2, l3, l4, l5, l6, l7, popup;
    JButton b1, b2, b3;
    JTextField f1, f2, f3, f4, f5, f6, f7, fName;
    
    public DisplayMarksheet()
    {
        lHead = new JLabel("Marksheet Information");
        lHead.setBounds(210, 30, 700, 50);
        lHead.setFont(new Font("SAN SARIF", Font.BOLD, 24));
        add(lHead);
        
        l1 = new JLabel("Student Id:  "); 
        l1.setBounds(50, 120, 200, 30);
        l1.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l1);
        
        f1 = new JTextField(10);
        f1.setBounds(175, 120, 200, 30);
        f1.setFont(new Font("Verdana", Font.PLAIN, 16));
        add(f1);
        
        name = new JLabel("Name:  ");
        name.setBounds(50, 190, 200, 30);
        name.setFont(new Font("", Font.PLAIN, 18));
        add(name);
        
        fName = new JTextField(10);
        fName.setBounds(175, 190, 200, 30);
        fName.setFont(new Font("Verdana", Font.PLAIN, 16));
        fName.setEditable(false);
        add(fName);
        
        l2 = new JLabel("Hindi : ");
        l2.setBounds(60, 260, 200, 30);
        l2.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l2);
        
        f2 = new JTextField(5);
        f2.setBounds(150, 265, 75, 25);
        f2.setFont(new Font("Verdana", Font.PLAIN, 16));
        f2.setEditable(false);
        add(f2);
        
        l3 = new JLabel("English : ");
        l3.setBounds(350, 260, 200, 30);
        l3.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l3);
        
        f3 = new JTextField(5);
        f3.setBounds(460, 265, 75, 25);
        f3.setFont(new Font("Verdana", Font.PLAIN, 16));
        f3.setEditable(false);
        add(f3);
        
        l4 = new JLabel("Maths : ");
        l4.setBounds(60, 335, 200, 30);
        l4.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l4);
        
        f4 = new JTextField(5);
        f4.setBounds(150, 340, 75, 25);
        f4.setFont(new Font("Verdana", Font.PLAIN, 16));
        f4.setEditable(false);
        add(f4);
        
        l5 = new JLabel("Science : ");
        l5.setBounds(350, 335, 200, 30);
        l5.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l5);
        
        f5 = new JTextField(5);
        f5.setBounds(460, 340, 75, 25);
        f5.setFont(new Font("Verdana", Font.PLAIN, 16));
        f5.setEditable(false);
        add(f5);
        
        l6 = new JLabel("SST : ");
        l6.setBounds(60, 405, 200, 30);
        l6.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l6);
        
        f6 = new JTextField(5);
        f6.setBounds(150, 410, 75, 25);
        f6.setFont(new Font("Verdana", Font.PLAIN, 16));
        f6.setEditable(false);
        add(f6);
        
        l7 = new JLabel("Sanskrit : ");
        l7.setBounds(350, 405, 200, 30);
        l7.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l7);
        
        f7 = new JTextField(5);
        f7.setBounds(460, 410, 75, 25);
        f7.setFont(new Font("Verdana", Font.PLAIN, 16));
        f7.setEditable(false);
        add(f7);
        
        popup = new JLabel();
        popup.setBounds(125, 485, 500, 30);
        popup.setFont(new Font("Vernda", Font.BOLD,12));
        add(popup);
        
        b1 = new JButton("Back");
        b1.setBounds(125, 525, 100, 30);
        b1.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b2 = new JButton("Reset");
        b2.setBounds(250, 525, 100, 30);
        b2.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        b3 = new JButton("Show");
        b3.setBounds(375, 525, 100, 30);
        b3.setFont(new Font("Verdana", Font.PLAIN , 16));
        
        add(b1);
        add(b2);
        add(b3);
      
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setLayout(null); 
        setVisible(true);    
        setSize(650, 650);    
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
            f1.setText("");
            fName.setText("");
            f2.setText("");
            f3.setText("");
            f4.setText("");
            f5.setText("");
            f6.setText("");
            f7.setText("");
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
            
                String q7 = "select * from results where stdId = ?";

                String q8 = "select name from students where stdId = ?";
                
		//get PreparedStatement object
		PreparedStatement pstmt, pstmt1;
                        
                pstmt = con.prepareStatement(q7);
                pstmt1 = con.prepareStatement(q8);
					
		int stdId = Integer.parseInt(f1.getText());

		pstmt.setInt(1, stdId);
		pstmt1.setInt(1, stdId);
                
		ResultSet set, set1;
                
                set = pstmt.executeQuery();
                set1 = pstmt1.executeQuery();
					
		while (set.next()) 
                {
                    
                    stdId = set.getInt("stdId");
                    f1.setText(stdId + "");
                    int hindi = set.getInt("Hindi");
                    f2.setText(hindi + "");
                    int english = set.getInt("English");
                    f3.setText(english + "");
                    int maths = set.getInt("Maths");
                    f4.setText(maths + "");
                    int science = set.getInt("Science");
                    f5.setText(science + "");
                    int sst = set.getInt("SST");
                    f6.setText(sst + ""); 
                    int sanskrit = set.getInt("Sanskrit");
                    f7.setText(sanskrit + "");
                    
                }
                
                while(set1.next())
                {
                    String Name = set1.getString("name");
                    fName.setText(Name);
                }
                
                popup.setText("");
                
            }
            catch (Exception ee)
            {
                
                popup.setText("                                  ! Kindly fill Student Id");
                
            }
        }  
    }
}
