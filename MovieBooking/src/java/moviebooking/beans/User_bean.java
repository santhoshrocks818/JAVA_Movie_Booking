/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviebooking.beans;

/**
 *
 * @author tcs
 */
public class User_bean {
    private String uFirstname,uSecondname,uPasswd,uEmail,uMobileno,uDob,admin;  

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getuFirstname() {
        return uFirstname;
    }

    public void setuFirstname(String uFirstname) {
        this.uFirstname = uFirstname;
    }

    public String getuSecondname() {
        return uSecondname;
    }

    public void setuSecondname(String uSecondname) {
        this.uSecondname = uSecondname;
    }

    public String getuPasswd() {
        return uPasswd;
    }

    public void setuPasswd(String uPasswd) {
        this.uPasswd = uPasswd;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuMobileno() {
        return uMobileno;
    }

    public void setuMobileno(String uMobileno) {
        this.uMobileno = uMobileno;
    }

    public String getuDob() {
        return uDob;
    }

    public void setuDob(String uDob) {
        this.uDob = uDob;
    }
}
