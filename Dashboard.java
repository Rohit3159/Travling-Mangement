
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
     JButton addPersonalDetails ,viewPersonalDetails, updatePersonalDetails, checkpackages,  bookPackage;
     JButton viewPackage, viewHotels,destination ,  bookHotels,viewBookHotels,calculator,notepaid , payment,about,deletePersonalDetails ;
    Dashboard(String username){
        this.username = username;
//        setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
         
         
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
         Image  i2 = i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel (i3);
         image.setBounds(5,0,70,70);
         p1.add(image);
         
        JLabel lb1 = new JLabel("Dashboard");
        lb1.setFont(new Font("Tahoma" ,Font.BOLD,30));
        lb1.setBounds(80,10,300,40);
        lb1.setForeground(Color.WHITE);
        p1.add(lb1);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonalDetails = new JButton ("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2. add(addPersonalDetails);
        
        updatePersonalDetails = new JButton ("Update Personal Details");
        updatePersonalDetails.setBounds(0,45,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN,20));  
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2. add(updatePersonalDetails);
        
        viewPersonalDetails = new JButton ("View Details");
        viewPersonalDetails .setBounds(0,90,300,50);
        viewPersonalDetails .setBackground(new Color(0,0,102));  
        viewPersonalDetails .setForeground(Color.WHITE);
        viewPersonalDetails .setFont(new Font("Tahoma", Font.PLAIN,20)); 
        viewPersonalDetails .setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.addActionListener(this);
        p2. add(viewPersonalDetails );
        
        deletePersonalDetails = new JButton ("Delete Personal Details");
        deletePersonalDetails .setBounds(0,135,300,50);
        deletePersonalDetails .setBackground(new Color(0,0,102));
        deletePersonalDetails .setForeground(Color.WHITE);
        deletePersonalDetails .setFont(new Font("Tahoma", Font.PLAIN,20));
        deletePersonalDetails .setMargin(new Insets(0,0,0,40));
        deletePersonalDetails.addActionListener(this);
        p2. add(deletePersonalDetails );
        
        checkpackages = new JButton ("Check Package");
        checkpackages .setBounds(0,180,300,50);
        checkpackages .setBackground(new Color(0,0,102));
        checkpackages .setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN,20));
        checkpackages .setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
        p2. add( checkpackages );
        
        
        bookPackage = new JButton ("Book Package");
        bookPackage .setBounds(0,225,300,50);
        bookPackage .setBackground(new Color(0,0,102));
        bookPackage .setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tahoma", Font.PLAIN,20));
        bookPackage .setMargin(new Insets(0,0,0,120));
        bookPackage.addActionListener(this);
        p2. add(bookPackage );
        
        viewPackage = new JButton ("View Package");
        viewPackage.setBounds(0,270,300,50);
        viewPackage .setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewPackage.setMargin(new Insets(0,0,0,120));
        viewPackage.addActionListener(this);
        p2. add( viewPackage );
        
        viewHotels = new JButton ("View Hotels");
        viewHotels.setBounds(0,315,300,50);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewHotels.setMargin(new Insets(0,0,0,140));
        viewHotels.addActionListener(this);
        p2. add(  viewHotels );
        
         
        bookHotels = new JButton ("Book Hotels");
        bookHotels .setBounds(0,360,300,50);
        bookHotels .setBackground(new Color(0,0,102));
        bookHotels .setForeground(Color.WHITE);
        bookHotels .setFont(new Font("Tahoma", Font.PLAIN,20));
        bookHotels .setMargin(new Insets(0,0,0,140));
        bookHotels.addActionListener(this);
        p2. add(  bookHotels  );
        
       viewBookHotels = new JButton (" View Booked Hotels");
       viewBookHotels.setBounds(0,405,300,50);
       viewBookHotels.setBackground(new Color(0,0,102));
       viewBookHotels.setForeground(Color.WHITE);
       viewBookHotels .setFont(new Font("Tahoma", Font.PLAIN,20));
       viewBookHotels.setMargin(new Insets(0,0,0,80));
       viewBookHotels.addActionListener(this);
       p2. add(  viewBookHotels  );
       
       destination = new JButton (" Destination ");
       destination .setBounds(0,450,300,50);
       destination .setBackground(new Color(0,0,102));
       destination .setForeground(Color.WHITE);
       destination  .setFont(new Font("Tahoma", Font.PLAIN,20));
       destination .setMargin(new Insets(0,0,0,150));
       destination .addActionListener(this);
       p2. add(  destination   );
       
       payment= new JButton (" Payments ");
       payment .setBounds(0,495,300,50);
       payment .setBackground(new Color(0,0,102));
       payment .setForeground(Color.WHITE);
       payment  .setFont(new Font("Tahoma", Font.PLAIN,20));
       payment .setMargin(new Insets(0,0,0,165));
       payment.addActionListener(this);
       p2. add(  payment   );
       
       calculator= new JButton (" Calculator ");
       calculator .setBounds(0,540,300,50);
       calculator .setBackground(new Color(0,0,102));
       calculator .setForeground(Color.WHITE);
       calculator  .setFont(new Font("Tahoma", Font.PLAIN,20));
       calculator.setMargin(new Insets(0,0,0,165));
       calculator.addActionListener(this);
       p2. add(  calculator  );
       
       notepaid= new JButton (" Notepaid ");
       notepaid.setBounds(0,585,300,50);
       notepaid.setBackground(new Color(0,0,102));
       notepaid .setForeground(Color.WHITE);
       notepaid  .setFont(new Font("Tahoma", Font.PLAIN,20));
       notepaid.setMargin(new Insets(0,0,0,165));
       notepaid.addActionListener(this);
       p2. add(  notepaid );
       
       
       
       about= new JButton (" About ");
       about.setBounds(0,630,300,50);
       about.setBackground(new Color(0,0,102));
       about .setForeground(Color.WHITE);
       about  .setFont(new Font("Tahoma", Font.PLAIN,20));
       about.setMargin(new Insets(0,0,0,175));
       about.addActionListener(this);
       p2. add(  about);
       
       
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i5 = i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel icon = new JLabel (i6);
       icon.setBounds(0,0,1650,1000);
       add(icon);
       
        JLabel text = new JLabel("Travel Tourism Managements System ");
        text .setFont(new Font("Tahoma" ,Font.BOLD,55));
        text .setBounds(400,70,1200,70);
        text .setForeground(Color.WHITE);
        icon.add( text );
       setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == addPersonalDetails ){
          new AddCustomer(username);
       }
         else if(ae.getSource() == viewPersonalDetails){
           new ViewCustomer(username);
       }else if (ae.getSource() == updatePersonalDetails){
           new UpdateCustomer(username);
       }else if (ae.getSource()==checkpackages){
            new CheckPakage();
       }else if(ae.getSource() ==   bookPackage){
          new BookPackage(username);
       }else if(ae.getSource() ==  viewPackage ){
           new ViewPackage(username);
       }else if (ae.getSource() ==  viewHotels){
           new CheckHotels();
       }else if(ae.getSource() == destination ){
           new Destinantion ();
       }else if(ae.getSource() ==   bookHotels){
           new BookHotel(username);
       }else if(ae.getSource() == viewBookHotels ){
           new ViewBookedHotel(username);
       }else if (ae.getSource() == calculator){
           try{
               Runtime.getRuntime().exec("calc.exe");
               
           }catch(Exception e){
               e.printStackTrace();
           }
       }else  if(ae.getSource() == notepaid){
           try{
               Runtime.getRuntime().exec("notepad.exe");
           }catch(Exception e){
               e.printStackTrace();
           }
       }else if(ae.getSource() ==  payment){
           new Payment();
       }else if(ae.getSource() == about){
           new About();
       }else if(ae.getSource() == deletePersonalDetails){
            new DeleteDetails(username);
       }
           
    }  
    public static void main (String args[]){
        new Dashboard("rohit");
    } 
    
}
