package registrationform;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


class Welcome extends JFrame
{
  Welcome()
  {
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Welcome");
     setSize(400, 200);
  }
 }




public class RegistrationForm extends JFrame  {
    private static Object jTable;

    public static void main(String[] args) throws SQLException {
        Welcome welcome = new Welcome();
        Database obj = new Database();
            try {
                obj.openConnection();
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    JFrame f=new JFrame("Pharmacy Mannagement System");    
     f.getContentPane().setBackground( Color.cyan );
     
     final JTextField value = new JTextField();
     value.setBounds(200,55,150,30); 
     final JTextField label = new JTextField();
     label.setBounds(200,105,150,30);
     final JTextField fpass = new JTextField();  
     fpass.setBounds(200,155,150,30); 
     String country[]={"Square","Beximco","Incepta","ACI","ACME ","Aristopharma","Nuvista ","Novo","Novartis "};        
     final JComboBox cb=new JComboBox(country);    
     cb.setBounds(200, 205,90,20);
     final JTextField phonefld = new JTextField();  
     phonefld.setBounds(200,255,150,30);
      
     
        JLabel rf=new JLabel("Daily Sales Information"); 
        rf.setOpaque(true);
        rf.setForeground(Color.RED);
        rf.setBackground( Color.WHITE );
        rf.setFont(new Font("Serif", Font.BOLD, 20)); 
        rf.setBounds(40,10, 200,30); 
     
     
     
        
        
        JLabel rlabel=new JLabel("Total Sales Information"); 
        rlabel.setOpaque(true);
        rlabel.setForeground(Color.RED);
        rlabel.setBackground( Color.WHITE );
        rlabel.setFont(new Font("Serif", Font.BOLD, 20)); 
        rlabel.setBounds(525,10, 200,30); 
        
        
        JLabel Tlabel=new JLabel("         ID         DragName       Quantity        Price        CompanyName         Date"); 
        Tlabel.setOpaque(true);  
        Tlabel.setBounds(400,55,420,30); 
        
        
        JLabel name=new JLabel("Drug Name :");    
        name.setBounds(40,50, 80,30); 
        final JLabel email=new JLabel("Quantity: ");    
        email.setBounds(40,100, 80,30); 
        final JLabel pass=new JLabel("Price : ");    
        pass.setBounds(40,150, 80,30); 
        final JLabel contry=new JLabel("Company Name : ");    
        contry.setBounds(40,200, 80,30); 
        JLabel phone=new JLabel("Date : ");    
        phone.setBounds(40,250, 80,30);
        
        //table
        
       /* String data[][]={ {"101","Amit","670000"},    
                              {"102","Jai","780000"},    
                              {"101","Sachin","700000"}};    
        String[] columnNames = { "Name", "Roll Number", "Department" };        
        JTable jt=new JTable(data,columnNames);    
        jt.setBounds(400,40,200,200);     
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp); 
        f.add(jt);
        */
        
        
            String url = "jdbc:mysql://localhost/";
            String dbName = "javadatabase";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";
            String query = "select * from `admin`";
            
            try{
                Class.forName(driver);
                Connection connection = (Connection)DriverManager.getConnection(url+dbName,userName,password);
                System.out.println("Connection Successfully");
                
                
                java.sql.Statement statement = connection.createStatement();
                ResultSet result;
                result = statement.executeQuery(query);
                //result.next();
                
               // String name = result.getString("userName");
               //l System.out.println("answer is:"+name);
                
                result.beforeFirst();
                while (result.next()) {
                    String id = result.getString("id");
                    String drugName = result.getString("drugName");
                    String quantity = result.getString("quantity");
                    String price = result.getString("price");
                    String companyName = result.getString("companyName");
                    String date = result.getString("date");
                    
                    String data[][]={ {id,drugName,quantity,price,companyName,date}};
                            String column[]={"ID","DrugName","QUANTITY","PRICE","COMPANYNAME","DATE"};       
                            final JTable jt=new JTable(data,column);    
                jt.setCellSelectionEnabled(true);
                ListSelectionModel select= jt.getSelectionModel();  

                jt.setBounds(400,88,420,200);
             JScrollPane sp=new JScrollPane(jt); 
                f.add(sp); 
                f.add(jt);
                }
                connection.close();
                statement.close();
                
            }
            catch(ClassNotFoundException | SQLException sqle)
            {
                System.out.println("Connection Faild");
            }
        
        JButton e = new JButton("Refresh");
        e.setForeground(Color.RED);
        e.setFont(new Font("Serif", Font.BOLD, 15)); 
        e.setBounds(500,323, 100,30);
        
        JButton d = new JButton("Exit");
        d.setForeground(Color.RED);
        d.setFont(new Font("Serif", Font.BOLD, 15)); 
        d.setBounds(610,323, 80,30);
        JButton c = new JButton("Reset");
        c.setBounds(240,320, 80,30);
        c.setForeground(Color.RED);
        c.setFont(new Font("Serif", Font.BOLD, 15)); 
        JButton b = new JButton("Add Data");
        b.setForeground(Color.RED);
        b.setFont(new Font("Serif", Font.BOLD, 15)); 
        b.setBounds(85,320, 120,30);   
                f.add(value); f.add(name); f.add(label); f.add(email); f.add(b); f.add(fpass);f.add(rf);
                f.add(pass);f.add(contry);f.add(phone);f.add(cb);f.add(phonefld);f.add(c);f.add(d);f.add(e);f.add(rlabel);f.add(Tlabel);
                f.setSize(880,470);    
                f.setLayout(null);
                f.setVisible(true);    
                
        b.addActionListener(new ActionListener() {
            private Object jTextname;
            public void actionPerformed(ActionEvent arg0) {
                if(value.getText().isEmpty()||(label.getText().isEmpty())||(fpass.getText().isEmpty())||(cb.getSelectedItem().equals("Select"))||(phonefld.getText().isEmpty()))
                    JOptionPane.showMessageDialog(null, "Invalide your data field");
                else{     
                JOptionPane.showMessageDialog(null, "Data Submit Complete.."); 
                
        //INSERT DATA ON TABLE
                
            String url = "jdbc:mysql://localhost/";
            String dbName = "javadatabase";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";
            //String query = "select * from `admin`";
                
            try {

                String sql = " INSERT INTO admin " 
                        + "( drugName, quantity, price, companyName,date)" + 
                        " VALUES (?,?,?,?,?)";

                Connection connection = (Connection)DriverManager.getConnection(url+dbName,userName,password);

                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, value.getText());
                ps.setString(2, label.getText());
                ps.setString(3, fpass.getText());
                ps.setString(4, cb.getSelectedItem().toString());
                ps.setString(5, phonefld.getText());
                ps.executeUpdate();

    //         if(jTextid.getText().isEmpty() || jTextname.getText().isEmpty() || jTextdept.getText().isEmpty()
    //               || jTextaddress.getText().isEmpty())
    //           {
    //           JOptionPane.showMessageDialog(null, "Filled All Form ");
    //      }

            JOptionPane.showMessageDialog(null, "Add Successfully");

              }

            catch (HeadlessException | SQLException ex){
             JOptionPane.showMessageDialog(null, "Already Student ID Exists ");
            }
            
            //showTableData ();
                
                }
            }

        private void validEmail() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
      });
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                value.setText(null);
                label.setText(null);
                fpass.setText(null);
                phonefld.setText(null);
                cb.setSelectedItem("");
            }
        });
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 System.exit(0);
            }
        });
        e.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 value.setText(null);
                label.setText(null);
                fpass.setText(null);
                phonefld.setText(null);
                cb.setSelectedItem("");
            }
        });
    }
}
