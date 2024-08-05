
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewPackage extends JFrame implements ActionListener {
       JButton back;
      ViewPackage(String username){
      setBounds(450,200,900,450);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      setVisible(true);
      
      JLabel text = new JLabel("VIEW PACKAGE DETAILS");
      text.setFont(new Font("Tahoma",Font.BOLD,20));
      text.setBounds(60,0,300,30);
      add(text);
      
      
      
      
      JLabel lblusername = new JLabel("username");
      lblusername.setBounds(30,50,150,25);
      add(lblusername);
      
      
      JLabel labelusername = new JLabel();
      labelusername.setBounds(220,50,150,25);
      add(labelusername);
      
      
      JLabel lblpacakge = new JLabel("Package");
      lblpacakge.setBounds(30,90,150,25);
      add(lblpacakge);
      
      
      JLabel labelpackage = new JLabel();
      labelpackage.setBounds(220,90,150,25);
      add(labelpackage);
      
      JLabel lblprsns = new JLabel("Total Persons");
       lblprsns .setBounds(30,130,150,25);
      add( lblprsns );
      
      
      JLabel labelpersons = new JLabel();
      labelpersons.setBounds(220,130,150,25);
      add(labelpersons);
      
      JLabel lblid = new JLabel("Id");
      lblid.setBounds(30,170,150,25);
      add(lblid);
      
      
      JLabel labelid = new JLabel();
      labelid.setBounds(220,170,150,25);
      add(labelid);
      
      JLabel lblnum= new JLabel("Number");
      lblnum.setBounds(30,210,150,25);
      add(lblnum);
      
      
      JLabel labelnumber = new JLabel();
      labelnumber.setBounds(220,210,150,25);
      add(labelnumber);
      
      
      JLabel lblphnum= new JLabel("Phone Number");
      lblphnum.setBounds(30,250,150,25);
      add(lblphnum);
      
      
      JLabel labelphnumber = new JLabel();
     labelphnumber.setBounds(220,250,150,25);
      add(labelphnumber);
      
      JLabel lblprc= new JLabel("Price");
      lblprc.setBounds(30,290,150,25);
      add(lblprc);
      
      
      JLabel labelprice = new JLabel();
      labelprice.setBounds(220,290,150,25);
      add(labelprice );
      
     
      
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.white);
       back.setBounds(130,360,100,25);
       back.addActionListener(this);
       add(back);
       
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
         Image  i2 = i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel (i3);
         image.setBounds(450,20,500,400);
         add(image);
      
         
         
         try{
             Conn conn = new Conn();
             String query = "select * from  bookpackage where username = '"+username+"'";
             ResultSet rs = conn.s.executeQuery(query);
             
             while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid .setText(rs.getString("id"));
                labelnumber .setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                
                labelpersons .setText(rs.getString("persons"));
                labelprice.setText(rs.getString("Price"));
                labelphnumber .setText(rs.getString("phone"));
                
             }
             
         }catch(Exception e){
             
         }
      setVisible(true);
      
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    

  
  public static void main (String args[]){
      new ViewPackage("rohit");

}
}
    

