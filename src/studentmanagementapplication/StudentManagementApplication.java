
package studentmanagementapplication;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StudentManagementApplication //This is main class
{
    public static void main(String[] args) 
    {
        menu m = new menu();
    }
    
}

class menu extends JFrame implements ActionListener     //This class will print the menu at the jframe
{
    
    JLabel l1, l2, l3, l5, l6, l8, lHead;
    JButton b1, b2, b3, b5, b6, b8;
    
    public menu()
    {
        
        lHead = new JLabel("Welcome to the Student Management Application ");
        lHead.setBounds(100, 40, 700, 50);
        lHead.setFont(new Font("SAN SARIF", Font.BOLD, 24));
        
        l1 = new JLabel("to ADD Student Information ");    
        l1.setBounds(285, 150, 500,25);
        l1.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        l2 = new JLabel("to UPDATE the Student Information ");    
        l2.setBounds(285, 220, 500,25);
        l2.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        l3 = new JLabel("to DISPLAY Student Information ");   
        l3.setBounds(285, 290, 500, 25);
        l3.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        l5 = new JLabel("to PREPARE the Marksheet of the Student ");
        l5.setBounds(285, 360, 500, 25);
        l5.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        l6 = new JLabel("to UPDATE Marksheet of the Student ");
        l6.setBounds(285, 430, 500, 25);
        l6.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        l8 = new JLabel("to DISPLAY the Marksheet of Student ");
        l8.setBounds(285, 500, 500, 25);
        l8.setFont(new Font("Verdana", Font.PLAIN, 18));
        
        b1 = new JButton("Press here");
        b1.setBounds(100,  150, 175,30);
        b1.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        b2 = new JButton("Press here");
        b2.setBounds(100, 220, 175, 30);
        b2.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        b3 = new JButton("Press here");
        b3.setBounds(100, 290, 175, 30);
        b3.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        b5 = new JButton("Press here");
        b5.setBounds(100, 360, 175, 30);
        b5.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        b6 = new JButton("Press here");
        b6.setBounds(100, 430, 175, 30);
        b6.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        b8 = new JButton("Press here");
        b8.setBounds(100, 500, 175, 30);
        b8.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        add(lHead);
        add(l1);
        add(l2);
        add(l3);
        add(l5);
        add(l6);
        add(l8);
        
        add(b1);
        add(b2);
        add(b3);
        add(b5);
        add(b6);
        add(b8);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b8.addActionListener(this);
        
        setLayout(null);
        setVisible(true);                           
        setSize(800, 650);                          
        setTitle("Student Management Application");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==b1)
        {
            new AddStudent();
            dispose();            
        }
        
        else if(ae.getSource()==b2)
        {
            new UpdateStudent();
            dispose();            
        }
        
        else if(ae.getSource()==b3)
        {
            new DisplayStudent();
            dispose();            
        }
        
        else if(ae.getSource()==b5)
        {
            new CreateMarksheet();
            dispose();            
        }
        
        else if(ae.getSource()==b6)
        {
            new UpdateMarksheet();
            dispose();            
        }
        
        else if(ae.getSource()==b8)
        {
            new DisplayMarksheet();
            dispose();
        }
        
    }
}
