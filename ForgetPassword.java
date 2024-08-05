
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements ActionListener{
    JTextField t1,t2,t3 ,t4, t5;
    JButton b1 ,b2,  b3;
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,540,280);
        add(p1);
        
        JLabel lb1username = new JLabel("Username");
        lb1username.setBounds(40,20,100,25);
        lb1username.setFont(new Font("SAN SERIF",Font.BOLD,14));
        p1.add(lb1username);
   
       t1 = new JTextField();
       t1.setBounds(220,20,150,25);
       t1.setBorder(BorderFactory.createEmptyBorder());
       p1.add(t1);
       
       b1= new JButton("Search");
       b1.setBounds(380,20,70,25);
       b1.setBackground(Color.GRAY);
       b1.setForeground(Color.WHITE);
       b1.setBorder(BorderFactory.createEmptyBorder());
       b1.addActionListener(this);
       p1.add(b1);
       
       JLabel lb1name = new JLabel("Name ");
       lb1name.setBounds(40,60,100,25);
       lb1name.setFont(new Font("SAN SERIF",Font.BOLD,14));
       p1.add(lb1name);
   
       t2 = new JTextField();
       t2.setBounds(220,60,150,25);
       t2.setBorder(BorderFactory.createEmptyBorder());
       p1.add(t2);
       
       JLabel lb2question = new JLabel("Security Question");
       lb2question.setBounds(40,100,200,25);
       lb2question.setFont(new Font("SAN SERIF",Font.BOLD,14));
       p1.add(lb2question);
   
       t3 = new JTextField();
       t3.setBounds(220,100,150,25);
       t3.setBorder(BorderFactory.createEmptyBorder());
       p1.add(t3);
       
       JLabel lb2answer = new JLabel("Answer");
       lb2answer.setBounds(40,140,200,25);
       lb2answer.setFont(new Font("SAN SERIF",Font.BOLD,14));
       p1.add(lb2answer);
   
       t4 = new JTextField();
       t4.setBounds(220,140,150,25);
       t4.setBorder(BorderFactory.createEmptyBorder());
       p1.add(t4);
       
       b2= new JButton("retrieve");
       b2.setBounds(380,140,70,25);
       b2.setBackground(Color.GRAY);
       b2.setForeground(Color.WHITE);
       b2.setBorder(BorderFactory.createEmptyBorder());
       b2.addActionListener(this);
       p1.add(b2);
               
       JLabel lb3password = new JLabel("Password");
       lb3password .setBounds(40,180,200,25);
       lb3password .setFont(new Font("SAN SERIF",Font.BOLD,14));
       p1.add(lb3password );
   
       t5 = new JTextField();
       t5.setBounds(220,180,150,25);
       t5.setBorder(BorderFactory.createEmptyBorder());
       p1.add(t5);  
       
       b3= new JButton("Back");
       b3.setBounds(230,230,70,25);
       b3.setBackground(Color.GRAY);
       b3.setForeground(Color.WHITE);
       b3.setBorder(BorderFactory.createEmptyBorder());
       b3.addActionListener(this);
       p1.add(b3);
       
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b1){
            try{
                String query = "select * from signup where userName = '"+t1.getText()+"'";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    t2.setText(rs.getString("Name"));
                    t3.setText(rs.getString("Security"));
                }
                
              
            }catch(Exception e){
               e.printStackTrace();
            }
            
        }else if(ae.getSource() == b2){
         try{
                String query = "select * from signup where answer = '"+t4.getText()+"'And userName = '"+t1.getText()+"'";
                Conn c = new Conn();
                
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    t5.setText(rs.getString("Password"));
                   // t3.setText(rs.getString("security"));
                }
                
              
            }catch(Exception e){
               e.printStackTrace();
            } 
            
        }else {
            
            setVisible(false);
            new Login();
        }
    }
        
    
    public static void main (String []args){
        new ForgetPassword();
    
}  
}
