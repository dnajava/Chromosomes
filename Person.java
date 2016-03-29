/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author ilpo
 */
public class Person {
    String first, middle, last, name;
    GregorianCalendar birth;
    SexType sex;
    String email;
    
    public Person() {
        first = middle = last = name = "";
        birth = new GregorianCalendar();
        sex = SexType.MALE;
        email = "";
    }
    
    public Person(String n, GregorianCalendar b, SexType s, String e) {
        name = n;
        birth = b;
        sex = s;
        email = e;
    }
    
    public Person(String n, String pfirst, String pmiddle, String plast, GregorianCalendar b, SexType s, String e) {
        name = n;
        first = pfirst;
        middle = pmiddle;
        last = plast;
        birth = b;
        sex = s;
        email = e;
    }
    
    public Person(Person p) {
        this.first = p.first;
        this.middle = p.middle;
        this.last = p.last;
        this.name = p.name;
        this.birth = p.birth;
        this.sex = p.sex;
        this.email = p.email;
    }
    
    public void setName(String s) { name = s;}
    public void setFirstName(String s) { first = s;}
    public void setMiddleName(String s) { middle = s;}
    public void setLastName(String s) { last = s;}
    public void setSex(SexType s) { sex = s; }
    public void setBirth(GregorianCalendar d) { birth = d; }
    public void setEmail(String s) { email = s; }
    
    // public void setBirth(Date d) { birth = new Date(d);}
    // public void setName(String s) { name = s;}
    
    public String  getName() { return name;}
    public String  getFirstName() { return first;}
    public String  getMiddleName() { return middle;}
    public String  getLastName() { return last;}
    public SexType getSex() { return sex; }
    public GregorianCalendar    getBirth() { return birth;}
    public String  getEmail() { return email; }

    @Override
    public String toString() {
        return name + " " + birth.get(Calendar.DATE) + "." +
                (birth.get(Calendar.MONTH) + 1)  + "." +
                (birth.get(Calendar.YEAR) + 1900) + ", " + sex + ", " + email + " ";
    }
            
}
