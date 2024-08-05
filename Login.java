
package travel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1,t2;
    
    Login(){
//        this.username= username;
    
   setSize(900,400); 
   setLocation(350,200);
   setLayout(null);
   getContentPane().setBackground(Color.WHITE);
  
   JPanel p1= new JPanel();
   p1.setBackground(new Color(13,193,233));
   p1.setBounds(0,0, 400, 400);
   p1.setLayout(null);
   add(p1);
   
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
   Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
   ImageIcon i3 = new ImageIcon(i2);
   JLabel image = new JLabel (i3);
   image.setBounds(100,120,200,140);
   p1.add(image);
   
   JPanel p2 = new JPanel();
   p2.setLayout(null);
   p2.setBounds(400,30,450,300);
   add(p2);
   
   JLabel lb1username = new JLabel("Username");
   lb1username.setBounds(60,20,100,25);
   lb1username.setFont(new Font("SAN SERIF",Font.BOLD,20));
   p2.add(lb1username);
   
   t1 = new JTextField();
   t1.setBounds(60,60,300,30);
   t1.setBorder(BorderFactory.createEmptyBorder());
   p2.add(t1);
   
   JLabel password = new JLabel("Password");
   password.setBounds(60,110,100,25);
   password.setFont(new Font("SAN SERIF",Font.BOLD,20));
   p2.add(password);
   
   t2 = new JTextField();
   t2.setBounds(60,150,300,30);
   t2.setBorder(BorderFactory.createEmptyBorder());
   p2.add(t2);
   
//    JLabel confirmpassword = new JLabel("Confirmpassword");
//   confirmpassword.setBounds(60,200,100,25);
//   confirmpassword.setFont(new Font("SAN SERIF",Font.BOLD,20));
//   p2.add(confirmpassword);
//   
//   JTextField t3 = new JTextField();
//   t3.setBounds(60,230,300,30);
//   t3.setBorder(BorderFactory.createEmptyBorder());
//   p2.add(t3);
//   
   b1= new JButton("Login");
   b1.setBounds(60,200,130,30);
   b1.setBackground(new Color(13,193,233));
   b1.setForeground(Color.WHITE);
   b1.setBorder(BorderFactory.createEmptyBorder());
   b1.addActionListener(this);
   p2.add(b1);
   
   b2= new JButton("Signup");
   b2.setBounds(230,200,130,30);
   b2.setBackground(new Color(13,193,233));
   b2.setForeground(Color.WHITE);
   b2.setBorder(BorderFactory.createEmptyBorder());
   b2.addActionListener(this);
   p2.add(b2);
   
   b3= new JButton("Forgot Password");
   b3.setBounds(130,250,130,30);
   b3.setBackground(new Color(13,193,233));
   b3.setForeground(Color.WHITE);
   b3.setBorder(BorderFactory.createEmptyBorder());
   b3.addActionListener(this);
   p2.add(b3);
   
   
    setVisible(true);
   
 }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== b1){
            try{
                String username = t1.getText();
                String password = t2.getText();
                String query = "select * from signup where username ='"+ username +"'AND password = '"+password+"'";
                Conn c = new Conn();
                 ResultSet rs = c.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Loading( username );
                 }else{
                     JOptionPane.showMessageDialog(null,"Incorrect username or Password");
                 }
                
            }catch(Exception e){
                e.printStackTrace();
            }
           
           
        }else if(ae.getSource()== b2){
            setVisible(false);
            new signup();
            
        }else{
            setVisible(false);
            new ForgetPassword();
            
        }
        
    }

public static void main(String args[]){
    new Login();

}
}
