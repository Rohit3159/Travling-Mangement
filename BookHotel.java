
package travel.management.system;

/**
 *
 * @author rohit_RR17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookHotel extends JFrame implements ActionListener {
    
    Choice chotel,cac,cfood;
    JTextField tfprsn, tfdays;
    JLabel labelusername ,lblelid,lblelphone,lbelprc, lbelnumber ;
    JButton checkprice,bookpkg,back;
    String username;
    BookHotel(String username){
        this.username= username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
      JLabel text = new JLabel("BOOK Hotel");
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
      
      
      JLabel slct = new JLabel("Select Hotel");
      slct.setFont(new Font("Tahoma",Font.BOLD,16));
      slct.setBounds(40,110,150,20);
      add(slct);
      
      
     chotel= new Choice();
     chotel.setBounds(250,110,200,20);
     add( chotel);
     
     try{
         Conn c = new Conn();
         ResultSet rs =c.s.executeQuery("select * from hotel");
         while(rs.next()){
                chotel.add(rs.getString("name"));
                
         }
     }catch(Exception e){
         e.printStackTrace();
     }
     
      
      JLabel lblpersn = new JLabel("TOTAL PERSON");
      lblpersn .setBounds(40,150,150,20);
      lblpersn.setFont(new Font("Tahoma",Font.BOLD,16));
      add(lblpersn );
      
      
      tfprsn = new JTextField("1");
      tfprsn .setBounds(250,150,200,25);
      add( tfprsn);
      
      JLabel lbldays = new JLabel("No. Of Days");
      lbldays .setBounds(40,190,150,20);
      lbldays.setFont(new Font("Tahoma",Font.BOLD,16));
      add(lbldays );
      
      
      tfdays = new JTextField("1");
      tfdays .setBounds(250,190,200,25);
      add(  tfdays);
      
      JLabel lblac = new JLabel("AC/Non-AC Room");
      lblac .setBounds(40,230,150,20);
      lblac .setFont(new Font("Tahoma",Font.BOLD,16));
      add(lblac );
      
        
      cac= new Choice();
//      cac.add("select Option");
      cac.add("AC");
      cac.add("Non-AC");
      cac.setBounds(250,230,200,20);
      add( cac);
     
      JLabel lblfood = new JLabel("Food Included");
      lblfood .setBounds(40,270,150,20);
      lblfood.setFont(new Font("Tahoma",Font.BOLD,16));
      add(lblfood );
      
        
      cfood= new Choice();
//      cfood.add("select Option");
      cfood.add("yes");
      cfood.add("No");
      cfood.setBounds(250,270,200,20);
      add( cfood);
      
      JLabel lblid = new JLabel("Id");
      lblid .setBounds(40,310,150,20);
      lblid.setFont(new Font("Tahoma",Font.BOLD,16));
      add( lblid );
      
      
      lblelid= new JLabel();
      lblelid.setBounds(250,310,200,20);
      add(lblelid);
      
      JLabel lblnumber= new JLabel("Number");
      lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
      lblnumber.setBounds(40,350,150,20);
      add(lblnumber);
      
      
      lbelnumber = new JLabel();
      lbelnumber.setBounds(250,350,200,20);
      add(lbelnumber);
      
      JLabel lblphone= new JLabel("Phone");
      lblphone .setBounds(40,390,150,20);
      lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
      add(  lblphone );
      
      
       lblelphone= new JLabel();
       lblelphone.setBounds(250,390,200,20);
       add( lblelphone);
      
      JLabel lblprc= new JLabel("Total Price");
      lblprc.setFont(new Font("Tahoma",Font.BOLD,16));
      lblprc.setBounds(40,430,150,20);
      add( lblprc);
      
      
      lbelprc = new JLabel();
      lbelprc.setBounds(250,3430,200,20);
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
        checkprice.setBounds(200,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpkg = new JButton("Book Hotel");
        bookpkg.setBackground(Color.BLACK);
        bookpkg.setForeground(Color.WHITE);
        bookpkg.setBounds(340,490,120,25);
        bookpkg.addActionListener(this);
        add(bookpkg);
        
         back = new JButton("Back");
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.setBounds(490,490,120,25);
         back.addActionListener(this);
         add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500,50,600,300);
        add(l12);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==  checkprice){
            try{
            Conn c = new Conn();
            ResultSet rm = c.s.executeQuery("select * from hotel where name='"+ chotel.getSelectedItem()+"'");
            while(rm.next()){
                int cost = Integer.parseInt(rm.getString("costperperson"));
                int ac = Integer.parseInt(rm.getString("acroom"));
                int food = Integer.parseInt(rm.getString("foodincluded"));
                
                 int persons = Integer.parseInt(rm.getString(tfprsn.getText()));
                 int days = Integer.parseInt(rm.getString(tfdays.getText()));
                
  
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if (persons * days > 0){
                    int total =0;
                    total +=acselected.equals("AC") ? ac :0;
                    total +=foodselected.equals("yes") ? food :0;
                    total +=cost;
                    total = total * persons * days; 
                    lbelprc.setText("Rs  "+total+"/-");
                }else{
                    JOptionPane.showMessageDialog(null, "Please Enter A Valid Number");
                }
                    
              
                }      
                 }catch(Exception e){
                       e.printStackTrace();
         }
        
    } else if(ae.getSource()==  bookpkg){
        try{
           Conn c= new Conn();
           c.s.executeUpdate("insert into bookhotel values ('"+ labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+ tfprsn.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+ lblelid.getText()+"','"+ lbelnumber.getText()+"','"+lblelphone.getText()+"','"+lbelprc.getText()+"')");
           
           JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
           setVisible(false);
        } catch( Exception e){
           e.printStackTrace();
        }
    }else
 
    setVisible(false);
    

    }
    public static void main(String[] args){
        new BookHotel("rohit");
    }
    
}