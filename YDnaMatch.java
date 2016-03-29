/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;

import java.io.File;
import java.io.FileNotFoundException;
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
    GregorianCalendar md;       // Date to match found
    
    YDnaMatch() {
        super();
        mda = "";
        haplo = "";
        md = new GregorianCalendar();
    }
    
    YDnaMatch(int a, String n, String e, String m, String s, String em, String ea, String h, GregorianCalendar d) {
        super(a, d, new Person(), new Person(), ea, em);
        mda = "";
        name = n;
        fn = e;
        mn = m;
        ln = s;
        haplo = h;
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
        
        try {
            Scanner scan = new Scanner(new File(fn));
        
            if(scan.hasNextLine()) {
                String nextLine = scan.nextLine(); /* Luetaan ensimmäinen header-rivi pois */
            }
            
            try {
                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    
                    String[] parts;
                    parts = line.split(",");
                    
                    // Skip citation marks
                    for(int j=0;j<parts.length;j++) {
                        if((parts[j]).length() > 2)
                            parts[j] = (parts[j]).substring(1,(parts[j].length() - 1));
                        else
                            parts[j] = "";
                    }
                    
                    String[] parts2;
                    parts2 = parts[9].split("/");
                    
/*                    if(line.equals("\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\"")) {
                        System.out.println("Loppu tuli tiedoille.");
                        continue;
                    }
*/                    

                    Settings s = new Settings(3);

                    if(s.getDebug() > 1) {
                        for(int j=0;j<parts2.length;j++)
                            System.out.println("Parts2 " + j + " = ***" + parts2[j] + "***");
                    }

                    GregorianCalendar apu = new GregorianCalendar(
                            Integer.parseInt(parts2[2]) - 1900,
                            Integer.parseInt(parts2[1]) - 1,
                            Integer.parseInt(parts2[0]) );

                    if(s.getDebug() > 2) tulosta(apu);
                    
                    YDnaMatch cmatch = new YDnaMatch(Integer.parseInt(parts[0]), parts[1],
                            parts[2], parts[3], parts[4], parts[5], parts[6], parts[7],
                            apu );

                    if (s.getDebug() > 0) System.out.println("Lisätään uusi tieto listana.");
                    add = lista.add(cmatch);

                    if (s.getDebug() > 0) {
                        System.out.println("***ALKU***");
                        for (YDnaMatch y : lista) { System.out.println(y);}
                        System.out.println("***LOPPU***");
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
        final char SEPARATOR = ',';
        final String TAB = "\t";
        
        /* return  "" + gd + SEPARATOR + name + // SEPARATOR + fn + SEPARATOR + mn + SEPARATOR + ln +
                TAB + email + TAB + mda + TAB + haplo + TAB + md; */
        
        return  "" + super.toString() + Settings.SEPARATOR + name +
        Settings.TAB + email + Settings.TAB + mda + Settings.TAB + haplo +
        md.get(Calendar.DAY_OF_MONTH) + "." +
        (md.get(Calendar.MONTH) + 1) +
        (md.get(Calendar.YEAR) + 1900);

    }

    /*
    *   Aputulostus päivämääriin. Lopullisesta ohjelmasta tämä metodi pois.
    */
    private static void tulosta(GregorianCalendar d) {
        System.out.println( d.get(Calendar.DAY_OF_MONTH) + "." + (d.get(Calendar.MONTH) + 1) + "." + (d.get(Calendar.YEAR) + 1900) + ".");
    }

}
