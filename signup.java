
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class signup extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField t1,t2,t3,t4;
    Choice security; 
    signup(){
        
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lb1 = new JLabel("Username");
        lb1.setFont(new Font("Tahoma" ,Font.BOLD,14));
        lb1.setBounds(50,20,125,25);
        p1.add(lb1);
        
        t1= new JTextField();
        t1.setBounds(190,20,250,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);
        
        JLabel lb2 = new JLabel("Name");
        lb2.setFont(new Font("Tahoma" ,Font.BOLD,14));
        lb2.setBounds(50,60,125,25);
        p1.add(lb2);
        
        t2= new JTextField();
        t2.setBounds(190,60,250,25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);
        
        JLabel lb3 = new JLabel("Password");
        lb3.setFont(new Font("Tahoma" ,Font.BOLD,14));
        lb3.setBounds(50,100,125,25);
        p1.add(lb3);
        
        t3= new JTextField();
        t3.setBounds(190,100,250,25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);
        
        JLabel lb4 = new JLabel("Security ");
        lb4.setFont(new Font("Tahoma" ,Font.BOLD,14));
        lb4.setBounds(50,140,125,25);
        p1.add(lb4);
        
        security = new Choice();
        security.add("Select Option");
        security.add("your Best Friend Name ");
        security.add("Favourite Animal");
        security.add("your Girlfriend ");
        security.add("Boyfriend name ");
        security.setBounds(190,140,250,25);
        p1.add(security);
        
        JLabel lb5 = new JLabel("Security answer");
        lb5.setFont(new Font("Tahoma" ,Font.BOLD,14));
        lb5.setBounds(50,180,125,25);
        p1.add(lb5);
        
        t4= new JTextField();
        t4.setBounds(190,180,250,25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);
        
        b1=new JButton("Create");
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(133,193,233));
        b1.setFont(new Font("Tahoma" ,Font.BOLD,14));
//        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setBounds(80,250,100,30);
        b1.addActionListener(this);
        p1.add(b1);
        
         
        b2=new JButton("Back");
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(133,193,233));
        b2.setFont(new Font("Tahoma" ,Font.BOLD,14));
//        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setBounds(260,250,100,30);
        b2.addActionListener(this);
        p1.add(b2);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
         Image  i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel (i3);
         image.setBounds(580,50,200,200);
         add(image);
         
         
        
        setVisible(true);
    }

    
      public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== b1){
            String Username= t1.getText();
            String name = t2.getText();
            String password= t3.getText();
            String question= security.getSelectedItem();
            String answer= t4.getText();
            
            
            
            try{
                String query=" insert into signup values ('"+Username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                
                setVisible(false);
                new Login();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if  (ae.getSource() == b2){
            
            setVisible(false);
            new Login();
        }
    }
      

    public static void main(String args[]){
        new signup();
        
    }

    
}

    
    
 

