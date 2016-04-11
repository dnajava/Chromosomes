/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ilpo
 */
public class YDnaMatch extends DnaMatch {
    String name, fn,mn,ln;      // Full name, first name, middle name and last name
    String mda;                 // Most distant ancestor
    String haplo;
    String snp;
    GregorianCalendar md;       // Date to match found
    
    YDnaMatch() {
        super();
        mda = "";
        haplo = "";
        snp = "";
        md = new GregorianCalendar();
    }
    
    YDnaMatch(int a, String n, String e, String m, String s, String em, String ea, String h, String psnp, GregorianCalendar d) {
        super(a, d, new Person(), new Person(), ea, em);
        mda = "";
        name = n;
        fn = e;
        mn = m;
        ln = s;
        haplo = h;
        snp = psnp;
        md = d;
    }
    
    public void setMDA(String s) { mda = s; };
    public void setHaplo(String s) { haplo = s; };
    public void setDate(GregorianCalendar d) { md = d; };
    
    public String getMDA() { return mda; };
    public String getHaplo() { return name; };
    public GregorianCalendar getDate() { return md; };
    
    public static List<YDnaMatch> read(String fn) /* throws ParseException */ {
        List <YDnaMatch> lista;
        lista = new ArrayList<>();
        ChromoMatch cm;
        boolean add = false;
        int j2 = 0;
        
        Settings s = new Settings(1);

        try {
            Scanner scan = new Scanner(new File(fn));
        
            if(scan.hasNextLine()) {
                String nextLine = scan.nextLine(); /* Luetaan ensimmäinen header-rivi pois */
            }
            
            try {
                while(scan.hasNextLine()){
                    String[] parts = new String[8]; // = Tools.split2(line);
                    String line = scan.nextLine();

                    parts = Tools.split2(line,s.Y_PARTSLENGTH);

                    GregorianCalendar apu;
                    String[] parts2;
                    if(parts[9] != "") {
                        parts2 = parts[9].split("/");
                        apu = new GregorianCalendar(
                            (Integer.parseInt( parts2[2]) - 1900),
                            (Integer.parseInt(parts2[1]) - 1),
                            (Integer.parseInt( parts2[0])) );
                    }
                    else apu = null;
                    if(parts[0] != "") { // Ei ole viimeinen tyhjä rivi?
                        YDnaMatch cmatch = new YDnaMatch(Integer.parseInt(parts[0]), parts[1],
                            parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8],
                            apu );

                        add = lista.add(cmatch);
                        j2++;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Virhe: " + e);
            }
        } catch(FileNotFoundException e) {
                System.out.println("Tiedostoa " + fn + " ei löytynyt.");
        }
        
        return lista;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        return  Settings.TAB +
                super.toString() + Settings.SEPARATOR + name + // SEPARATOR + fn + SEPARATOR + mn + SEPARATOR + ln +
                Settings.TAB + email + Settings.TAB + mda + Settings.TAB + haplo +
                sdf.format(md.getTime());
    }
}
