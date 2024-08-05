
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateCustomer extends JFrame implements ActionListener {
     JLabel label1username ,labelname ;
    JComboBox  choosed;
    JTextField tfnumber , tfcountry, tfaddress,tfemail, tfphone, tfid, tfgender  ;
    JRadioButton rmale , rfemale;
    JButton update , back;
   UpdateCustomer(String username ){
        
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text= new JLabel("Update Customer Detail");
        text.setBounds(300,0,300,45);
        text.setForeground(Color.BLUE);
        add(text);
        text.setFont(new Font ("Thahoma",Font.PLAIN,22));
        
        tfid = new JTextField();
        tfid .setBounds(220,130,150,25);
        add( tfid );
        
        JLabel lbusername = new JLabel("username");
        lbusername.setBounds(30,50,150,25);
        add(lbusername);
        
        label1username = new JLabel();
        label1username.setBounds(220,50,150,25);
        add(label1username);
        
        JLabel lbid = new JLabel("ID");
        lbid.setBounds(30,90,150,25);
        add(lbid);
        
        tfid = new JTextField();
        tfid .setBounds(220,90,150,25);
        add( tfid );
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        
         JLabel lblname = new JLabel("Name");
         lblname .setBounds(30,170,150,25);
         add( lblname );
        
         labelname = new JLabel();
         labelname.setBounds(220,170,150,25);
         add(labelname);
        
        
        JLabel lblgender = new JLabel("Gender");
        lblgender .setBounds(30,210,150,25);
        add( lblgender );
        
        
       tfgender = new JTextField();
       tfgender.setBounds(220,210,150,25);
       add(  tfgender );
        
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        setVisible(true);
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        
        
        tfaddress = new JTextField();
        tfaddress  .setBounds(220,290,150,25);
        add( tfaddress  );
        
        
        
        JLabel lblphone = new JLabel("Phone No");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail .setBounds(30,370,150,25);
        add(lblemail );
        
        tfemail = new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);
        
       update = new JButton("Update");
       update.setBackground(Color.BLACK);
       update.setForeground(Color.white);
       update.setBounds(70,430,100,30);
       update.addActionListener(this);
       add(update);
       
       back = new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.white);
       back.setBounds(250,430,100,30);
       back.addActionListener(this);
       add(back);
       
//       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
//       Image i2 = i1.getImage().getScaledInstance(400, 500,Image.SCALE_DEFAULT);
//       ImageIcon i3 = new ImageIcon(i2);
//       JLabel img = new JLabel(i3);
//       img.setBounds(400,40,450,420);
//       add(img);
//        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
         Image  i2 = i1.getImage().getScaledInstance(350, 420,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel (i3);
         image.setBounds(400,80,450,420);
         add(image);
         
          try{
             Conn c = new Conn();
                
             ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
             while(rs.next()){
                  label1username.setText(rs.getString("username"));
                  tfid.setText(rs.getString("id"));
                  tfnumber.setText(rs.getString("number"));
                  labelname.setText(rs.getString("name"));
                  tfgender.setText(rs.getString("gender"));
                  tfcountry.setText(rs.getString("country"));
                  tfaddress.setText(rs.getString("address"));
                  tfphone.setText(rs.getString("phone"));
                  tfemail.setText(rs.getString("email"));
             }
             
         }catch  (Exception e) {
            e.printStackTrace();
            
         }
          
            setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== update){
             String username = label1username.getText();
             String id = tfid.getText();
             String number =tfnumber.getText();
             String name =labelname.getText();
             String gender =tfgender.getText();
           
             String country =tfcountry.getText();
             String address =tfaddress.getText();
             String phone =tfphone.getText();
             String email =tfemail.getText();
             
             
             try{
                 Conn c = new Conn();
                 String query = "update customer set username= '"+username+"',id = '"+id+"',number = '"+number+"', name ='"+name+"',gender = '"+gender+"', country ='"+country+"',address = '"+address+"', phone = '"+phone+"',email = '"+email+"'";
                 c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null, "Customer Updated Successfully");
                 setVisible(false);
             }catch(Exception e){
                 e.printStackTrace();
             }
         }else{
             setVisible(false);
         }
     }   
    
    public static void main (String args[]){
         new UpdateCustomer("rohit");
    }
    
    
}
    

