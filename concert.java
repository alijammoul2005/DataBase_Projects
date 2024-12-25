
package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class concert {
    private int Hall;
    private int ID;
    private String name;
    private Date date;
    private int res;
    private String type="recent";
   
    
    public concert(int ID,String name,Date d,int res,int hall){
        this.ID=ID;
        this.res=res;
        this.name=name;
        this.date=d;
        this.Hall=hall;
        setType(d);
    }
    
        
        
    
    public concert(){
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public String getType() {
        return type;
    }

    public int getHall() {
        return Hall;
    }

    public void setHall(int Hall) {
        this.Hall = Hall;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
     

   

    public void setType(Date d) {
      
        LocalDate today = LocalDate.now();
        LocalDate date =d.toLocalDate();

        long daysBetween = ChronoUnit.DAYS.between(today, date);

        if (daysBetween > 30) { // more than a month from today
            
            
            this.type="upcoming";
        } else if (Math.abs( daysBetween) <= 90 ) { // within the month range
           this.type="recent";
            
        } else { // older than a month from today
            System.out.println(daysBetween);
           this.type="old";
            
        }
    }
    }

    
    
    
    
    

