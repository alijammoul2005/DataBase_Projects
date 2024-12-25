
package control;
import java.sql.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Musicians;
import model.concert;
import model.concerthall;
import view.musicains;

public class DBSaccess {
     private Connection con;
    private Statement stm;
    
    private void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/musical concert";
        String user = "root";
        String password = "root"; // If you have set a password for the root user, put it here

        con = DriverManager.getConnection(url, user, password);
        stm = con.createStatement();
    }
    
    private void close() throws SQLException{
        stm.close();
        con.close();
    }
     public void deleteConcert(int ID)
    {
        String query="DELETE FROM concert where CID="+ ID;
        try{
         connect();
         stm.executeUpdate(query);
         close();
        }
        catch (SQLException ex){
        Logger.getLogger(DBSaccess.class.getName()).log(Level.SEVERE,null, ex);
     }
    }
    public void UpdateConcert( int CID,String name,int res,int hall,Date d )
    {
        //String query="UPDATE `professor` SET `pname` ="+pname +"`status` ="+status +"`salary` ="+salary+" WHERE `professors`.`ssn` ="+ssn;
        String query="UPDATE concert SET Name='"+name+"', ID ='"+CID+"',reservationPrice='"+res+"',locationID='"+hall+"',Date='"+d+"' WHERE ID='"+CID+"'";
        try{
         connect();
         stm.executeUpdate(query);
         close();
        }
        catch (SQLException ex){
        Logger.getLogger(DBSaccess.class.getName()).log(Level.SEVERE,null, ex);
     }
    }
     public void addConcert(concert c){
        String query1="Insert into concert values('"+c.getID()+"','"+c.getName()+"','"+c.getHall()+"','"+c.getRes()+"','"+c.getDate()+"')";
        
        
        try{
            connect();
            stm.executeUpdate(query1);
            close();
        }
        catch (SQLException e){
            Logger.getLogger(DBSaccess.class.getName()).log(Level.SEVERE,null, e);
        }
    }
      public concert getID(int ID)
    {
        String query=" SELECT * FROM concert where CID="+ID;
        concert c=null;
        try{
         connect();
         ResultSet rs= stm.executeQuery(query);
         if(rs.next())
         {
             c=new concert();
             c.setID(rs.getInt("CID"));
             c.setName(rs.getString("cname"));
             c.setDate(rs.getDate("date"));
             c.setRes(rs.getInt("reservationPrice"));
             c.setHall(rs.getInt("locationID"));
             c.setType(c.getDate());
         }
         close();
     }
     catch (SQLException ex)
     {
        Logger.getLogger(DBSaccess.class.getName()).log(Level.SEVERE,null, ex);
     }
    return c;
    }
     
          public ArrayList<concert> getAllConcerts() {
        String query = "SELECT * FROM concert";
        ArrayList<concert> concerts = new ArrayList<>();
        try {
            connect();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                concert c = new concert();
                c.setID(rs.getInt("CID"));
                c.setName(rs.getString("cname"));
                c.setDate(rs.getDate("date"));
                c.setRes(rs.getInt("reservationPrice"));
                c.setHall(rs.getInt("locationID"));
                c.setType(c.getDate());
                concerts.add(c);
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }
    public ArrayList<concerthall> getAllHalls() {
        String query = "SELECT * FROM concerthall";
        ArrayList<concerthall> halls = new ArrayList<>();
        try {
            connect();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                concerthall c = new concerthall();
                c.setName(rs.getString("name"));
                c.setLocationID(rs.getInt("locationID"));
                c.setCapacity(rs.getInt("capacity"));
                c.setCity(rs.getString("city"));
                c.setStreet(rs.getString("street"));
                halls.add(c);
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return halls;
    }
    public ArrayList<Musicians> getMusicians() {
        String query = "SELECT * FROM musician";
        ArrayList<Musicians> concerts = new ArrayList<>();
        try {
            connect();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Musicians c = new Musicians();
                c.setPid(rs.getInt("PID"));
                c.setPname(rs.getString("pname"));
                c.setSpecialty(rs.getString("specialty"));
                c.setYOE(rs.getInt("yearsOfExperience"));
                c.setSoloist(rs.getInt("soloist"));
                concerts.add(c);
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }
     public ArrayList<concerthall> getHalls() {
        String query = "SELECT * FROM concerthall";
        ArrayList<concerthall> concerts = new ArrayList<>();
        try {
            connect();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                concerthall c = new concerthall();
                c.setLocationID(rs.getInt("locationID"));
                c.setName(rs.getString("name"));
                c.setCapacity(rs.getInt("capacity"));
                c.setCity(rs.getString("city"));
                c.setStreet(rs.getString("street"));
                concerts.add(c);
            }
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }

    public ArrayList<Integer> getAllID() {
    String query = "SELECT * FROM concert";
        ArrayList<Integer> concerts = new ArrayList<>();
        try {
            connect();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
               
                concerts.add(rs.getInt("CID"));
            }
            System.out.print(concerts);
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return concerts;
    }
    public ArrayList<Integer> getAllHID() {
    String query = "SELECT * FROM concerthall";
        ArrayList<Integer> halls = new ArrayList<>();
        try {
            connect();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
               
                halls.add(rs.getInt("LocationID"));
            }
            
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return halls;
    }

}
