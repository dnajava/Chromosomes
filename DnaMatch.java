/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ilpo
 */
public abstract class DnaMatch {
    int gd;                 // Genetic distance
    GregorianCalendar day;  // Date of the found match
    Person p;               // Person, who is tested
    Person m;               // Match person
    String mda;             // Most distant ancestor
    String email;           // Email address
    
    public DnaMatch() {
        gd = 0;
        day = new GregorianCalendar();
        p = new Person();
        m = new Person();
        mda = "";
        email = "";
        
    }
    
    public DnaMatch(int pgd, GregorianCalendar d, Person pp, Person pm, String pmda, String pemail) {
        gd = pgd;
        day = d;
        p = pp;
        m = pm;
        mda = pmda;
        email = pemail;
    }
    
    public void setGD(int i) { gd = i; };
    public void setDate(GregorianCalendar d) { day = d; };
    public void setMDA(String s) { mda = s; };
    public void setP(Person pers) { p = new Person(pers); }
    public void setM(Person pers) { m = new Person(pers); }
    
    public int getGD() { return gd; };
    public GregorianCalendar getDate() { return day; } 
    public String getMDA() { return mda; };
    public Person getP() { return p; }
    public Person getM() { return m; }
    
    @Override
    public String toString() {
        return day.get(Calendar.DAY_OF_MONTH) + "." + (day.get(Calendar.MONTH) + 1) + "." + (day.get(Calendar.YEAR) + 1900) +
                " GD=" + gd + " Matchin nimi: " + m + ", MDA = " + mda + ", email = " + email;
    }
}
