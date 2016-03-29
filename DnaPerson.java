/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;

import java.util.Date;

/**
 *
 * @author ilpo
 */
public class DnaPerson extends Person {
    String y_haplo;
    String mt_haplo;
    Location loc;
    ExperienceType exp;                    // Genealogical experience
    String kit;
    
    public DnaPerson() {
        super();
        y_haplo = "";
        mt_haplo = "";
        kit = "";
        loc = null;
        exp = ExperienceType.NOTHING;
    }
    
    public DnaPerson(String n, String pfirst, String pmiddle, String plast, Date b, SexType s, String e,
            String yh, String mh, String kitnro, Location lo, ExperienceType et) {
        super();
        y_haplo = yh;
        mt_haplo = mh;
        kit = kitnro;
        loc = lo;
        exp = et;
    }
    
    public DnaPerson(Person p, String yh, String mh, String kitnro, Location lo, ExperienceType et) {
        super(p.getName(),p.getFirstName(),p.getMiddleName(),p.getLastName(),p.getBirth(),p.getSex(),p.getEmail());
        y_haplo = yh;
        mt_haplo = mh;
        kit = kitnro;
        loc = lo;
        exp = et;
    }
    
    public void setKIT(String s) { kit = s; }
    public void setYHaplo(String s) { y_haplo = s; }
    public void setMHaplo(String s) { mt_haplo = s; }
    // set location
    public void setExp(ExperienceType e) { exp = e; }
    
    public String getKIT() { return kit; }
    public String getYHaplo() { return y_haplo; }
    public String getMHaplo() { return mt_haplo; }
    public ExperienceType getExp() { return exp; }
    
    @Override
    public String toString() {
        return super.toString() + ", Y-haplo " + y_haplo + Settings.SEPARATOR +
                ", mt-haplo " + mt_haplo + Settings.SEPARATOR + ", location = " +
                loc + "Experience level: " + exp;
    }
}
