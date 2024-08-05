
package travel.management.system;

import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    public void run(){
        try{
            for(int i = 1; i<= 101;i++){
                int max = bar.getMaximum();//100
                int value = bar.getValue();
                
                if(value < max){ //101 <100
                    bar.setValue(bar.getValue() + 1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                    
                }
                Thread.sleep(30);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }

    Loading(String username){
        this.username = username;
        t = new Thread(this);
        
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       
        JLabel lb1 = new JLabel("Travel And Tourism Application");
        lb1.setFont(new Font("Tahoma" ,Font.BOLD,35));
        lb1.setBounds(50,20,600,45);
        lb1.setForeground(Color.blue);
        add(lb1);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
       JLabel lb1loading = new JLabel("Loading,please wait...");
       lb1loading.setFont(new Font("Raleway" ,Font.BOLD,16));
       lb1loading.setBounds(200,120,200,60);
       lb1loading.setForeground(Color.blue);
       add(lb1loading);
        
       JLabel lb1username = new JLabel("welcome " +username);
       lb1username.setFont(new Font("Raleway" ,Font.BOLD,16));
       lb1username.setBounds(20,310,400,40);
       lb1username.setForeground(Color.blue);
       add(lb1username);
       
              
       

       t.start();
       setVisible(true);
        
        
    }
    public static void main(String args[]){
        new Loading("");
        
    }
    
}
