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
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * "Genetic Distance","Full Name","First Name","Middle Name","Last Name","Email","Most Distant Ancestor"
 * ,"mtDNA Haplogroup","Match Date"
 * "1","Mr. Eric Wittouck","Eric","","Wittouck","222412@igenea.org","","U8a1a1b","11/11/2015"
* 
* 
/**
 *
 * @author ilpo
 */
public class MtDnaMatch extends DnaMatch {
    String name, fn,mn,ln;      // Full name, first name, middle name and last name
    String mda;                 // Most distant ancestor
    String haplo;
    GregorianCalendar md;       // Date to match found

    MtDnaMatch() {
        super();
        
        name = "";
        fn = "";
        mn = "";
        ln = "";
        email = "";
        mda = "";
        haplo = "";
        md = null;
    }

    // public DnaMatch(int pgd, Date d, Person pp, Person pm, String pmda, String pemail) 
    MtDnaMatch(int a, String n, String e, String m, String s, String em, String ea, String h, GregorianCalendar d) {
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
    public String getHaplo() { return haplo; };
    public GregorianCalendar getDate() { return md; };
    
    public static List<MtDnaMatch> read(String fn) /* throws ParseException */ {
        List <MtDnaMatch> lista;
        lista = new ArrayList<>();
        ChromoMatch cm;
        boolean add = false;

        Settings s = new Settings(0);

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
                    parts2 = parts[8].split("/");

                    GregorianCalendar apu = new GregorianCalendar(
                            (Integer.parseInt( parts2[2]) - 1900),
                            (Integer.parseInt(parts2[1]) - 1),
                            (Integer.parseInt( parts2[0])) );

                    MtDnaMatch cmatch = new MtDnaMatch(Integer.parseInt(parts[0]), parts[1],
                            parts[2], parts[3], parts[4], parts[5], parts[6], parts[7],
                            apu );
                    
                    if(s.getDebug() > 1) System.out.println("Sijoitus cmatchiin tehty.");
                    
                    add = lista.add(cmatch);
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
                
/*                md.get(Calendar.DAY_OF_MONTH) + "." +
                (md.get(Calendar.MONTH) + 1) +
                (md.get(Calendar.YEAR) + 1900);
*/                
    }

    /*
    *   Aputulostus päivämääriin. Lopullisesta ohjelmasta tämä metodi pois.
    */
    private static void tulosta(GregorianCalendar d) {
        System.out.println( d.get(Calendar.DAY_OF_MONTH) + "." + (d.get(Calendar.MONTH) + 1) + "." + (d.get(Calendar.YEAR) + 1900) + ".");
    }
}

