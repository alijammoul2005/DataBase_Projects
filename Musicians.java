/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shadow
 */
public class Musicians {
    private int pid;
    private String pname;
    private int YOE;
    private String specialty;
    private int soloist;

    public Musicians(String pname, int YOE, String specialty, int soloist) {
        this.pname = pname;
        this.YOE = YOE;
        this.specialty = specialty;
        this.soloist = soloist;
    }
    public Musicians() {
        
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getYOE() {
        return YOE;
    }

    public void setYOE(int YOE) {
        this.YOE = YOE;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getSoloist() {
        return soloist;
    }

    public void setSoloist(int soloist) {
        this.soloist = soloist;
    }
    
    
}
