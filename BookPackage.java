
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookPackage extends JFrame implements ActionListener {
    
    Choice cpackage;
    JTextField tfprsn;
    JLabel labelusername ,lblelid,lblelphone,lbelprc, lbelnumber ;
    JButton checkprice,bookpkg,back;
    String username;
    BookPackage(String username){
        this.username= username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
      JLabel text = new JLabel("BOOK PACKAGE");
      text.setBounds(200,20,200,30);
      text.setFont(new Font("Tahoma",Font.BOLD,25));
      add(text);
      
        
      JLabel lblusername = new JLabel("Username");
      lblusername .setFont(new Font("Tahoma",Font.BOLD,16));
      lblusername.setBounds(40,70,100,20);
      add(lblusername);
      
      
      labelusername = new JLabel();
      labelusername.setBounds(250,70,200,20);
      add(labelusername);
      
      
      JLabel slct = new JLabel("Select Package");
      slct.setFont(new Font("Tahoma",Font.BOLD,16));
      slct.setBounds(40,110,150,20);
      add(slct);
      
      
     cpackage= new Choice();
     cpackage.add("Gold Package");
     cpackage.add("Silver Package");
     cpackage.add("Bronze Package");
     cpackage.setBounds(250,110,200,20);
     add(cpackage);
     
      
      JLabel lblpersn = new JLabel("TOTAL PERSON");
      lblpersn .setBounds(40,150,150,20);
      lblpersn.setFont(new Font("Tahoma",Font.BOLD,16));
      add(lblpersn );
      
      
      tfprsn = new JTextField("1");
      tfprsn .setBounds(250,150,200,25);
      add( tfprsn);
      
      JLabel lblid = new JLabel("Id");
      lblid .setBounds(40,190,150,20);
      lblid.setFont(new Font("Tahoma",Font.BOLD,16));
      add( lblid );
      
      
      lblelid= new JLabel();
      lblelid.setBounds(250,190,200,20);
      add(lblelid);
      
      JLabel lblnumber= new JLabel("Number");
      lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
      lblnumber.setBounds(40,230,150,20);
      add(lblnumber);
      
      
      lbelnumber = new JLabel();
      lbelnumber.setBounds(250,230,200,20);
      add(lbelnumber);
      
      JLabel lblphone= new JLabel("Phone");
      lblphone .setBounds(40,270,150,20);
      lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
      add(  lblphone );
      
      
       lblelphone= new JLabel();
       lblelphone.setBounds(250,270,200,20);
       add( lblelphone);
      
      JLabel lblprc= new JLabel("Total Price");
      lblprc.setFont(new Font("Tahoma",Font.BOLD,16));
      lblprc.setBounds(40,310,150,20);
      add( lblprc);
      
      
      lbelprc = new JLabel();
      lbelprc.setBounds(250,310,200,20);
      add(lbelprc);
      
        try{
             Conn conn = new Conn();
             String query = "select * from customer where username = '"+username+"'";
             ResultSet rs = conn.s.executeQuery(query);
             
             while(rs.next()){
                labelusername.setText(rs.getString("username"));
                lblelid .setText(rs.getString("id"));
                lbelnumber .setText(rs.getString("number"));
                lblelphone .setText(rs.getString("phone"));
               
             }
             
         }catch(Exception e){
             e.printStackTrace();
             
         }
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(200,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpkg = new JButton("Book Package");
        bookpkg.setBackground(Color.BLACK);
        bookpkg.setForeground(Color.WHITE);
        bookpkg.setBounds(340,380,120,25);
        bookpkg.addActionListener(this);
        add(bookpkg);
        
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(490,380,120,25);
       back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550,50,500,300);
        add(l12);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==  checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost+=12000;
            
        }else if((pack.equals("Silver Package"))){
            cost+=25000;
        }else
            cost+=32000;
        
        int persons = Integer.parseInt(tfprsn.getText());
            cost*=persons;
             lbelprc .setText("Rs  "+cost+"/");
            
        
    }else if(ae.getSource()==  bookpkg){
        try{
           Conn c= new Conn();
           c.s.executeUpdate("insert into bookpackage values ('"+ labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+ tfprsn.getText()+"','"+ lblelid.getText()+"','"+ lbelnumber.getText()+"','"+lblelphone.getText()+"','"+lbelprc.getText()+"')");
           
           JOptionPane.showMessageDialog(null, "Package Booked Successfully");
           setVisible(false);
        } catch( Exception e){
           e.printStackTrace();
        }
    }else
 
    setVisible(false);
    

    }
    public static void main(String[] args){
        new BookPackage("rohit");
    }
    
}
