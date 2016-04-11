/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * Chromosome match between two person.
 * @author ilpo
 */
public class ChromoMatch extends DnaMatch {
    // NAME,MATCHNAME,CHROMOSOME,START LOCATION,END LOCATION,CENTIMORGANS,MATCHING SNPS

    String  name,matchname;      // Match name one and two
    int     cnum;                // Chromosome number
    long    start, end;          // Shared area begin location and end location
    double  cM;                  // CentiMorgans
    int     snps;                // Matching snps

    ChromoMatch() {
        super();
        
        name = "";
        matchname = "";
        start = 0;
        end = 0;
        cM = 0.0;
        snps = 0;
    }
    
    ChromoMatch(String n1, String n2, int c, long s, long e, double cm, int z) {
        name = n1;
        matchname = n2;
        cnum = c;
        start = s;
        end = e;
        cM = cm;
        snps = z;
    }
 
    void    setName(String s) { name = s; }
    void    setMatch(String s) { matchname = s; }
    void    setC(int i) { cnum = i; }
    void    setStart(long l) { start = l; }
    void    setEnd(long l) { end = l; }
    void    setCM(double d) { cM = d; }
    void    setSnps(int i) { snps = i; }
    
    String  getName() { return name; }
    String  getMatch() { return matchname; }
    int     getC() { return cnum; }
    long    getStart() { return start; }
    long    getEnd() { return end; }
    double  getCM() { return cM; }
    int     getSnps() { return snps; }
    
    public static List<ChromoMatch> read(String fn) {
        List<ChromoMatch> lista;
        lista = new ArrayList<>();
        ChromoMatch cm;
        boolean add = false;
        int j2 = 0;
        
        try {
            Scanner scan = new Scanner(new File(fn));
        
            if(scan.hasNextLine()) {
                String nextLine = scan.nextLine(); /* Luetaan ensimmäinen header-rivi pois */
            }
            
            try {
                while(scan.hasNextLine()){
                    String[] parts = new String[8]; // = Tools.split2(line);
                    String line = scan.nextLine();

                    parts = Tools.split2(line,Settings.FF_PARTSLENGTH);
/*
System.out.println("***** Osat *****");
for(int ai=0;ai<parts.length;ai++)
    
    System.out.println("Osa " + ai + "\t" + parts[ai]);
System.out.println("**** LOPPU ****");
System.exit(0);
*/
                    GregorianCalendar apu;
                    String[] parts2;
                    if(parts[8] != "") {
                        parts2 = parts[4].split("/");
                        apu = new GregorianCalendar(
                            (Integer.parseInt( parts2[2]) - 1900),
                            (Integer.parseInt(parts2[1]) - 1),
                            (Integer.parseInt( parts2[0])) );
                    }
                    else apu = null;

                    if(parts[0] != "") { // Ei ole viimeinen tyhjä rivi?
                        MtDnaMatch cmatch = new MtDnaMatch(Integer.parseInt(parts[0]), parts[1],
                            parts[2], parts[3], parts[4], parts[5], parts[6], parts[7],
                            apu );

//                        add = lista.add(cmatch);
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
/*                
                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    String[] parts;
//                    parts = line.split(",");

                    parts = Tools.split5(line,1);
                    
System.out.println("***** Osat *****");
for(int ai=0;ai<parts.length;ai++)
    System.out.println(parts[ai]);
System.out.println("**** LOPPU ****");
                    ChromoMatch cmatch;
                    cmatch = new ChromoMatch(parts[0], parts[1],
                            Integer.parseInt(parts[2]),
                            Long.parseLong(parts[3]), Long.parseLong(parts[4]),
                            Double.parseDouble(parts[5]), Integer.parseInt(parts[6]) );
                    add = lista.add(cmatch);
                }
            } catch (NumberFormatException e) {
                System.out.println("Virhe: " + e);
            }
        } catch(FileNotFoundException e) {
                System.out.println("Tiedostoa " + fn + " ei löytynyt.");
        }
        
        return lista;
        */
    }
    
    @Override
    public String toString() {
        return name + Settings.SEPARATOR + matchname + Settings.SEPARATOR + cnum + Settings.SEPARATOR + Settings.TAB + start + Settings.TAB + end + Settings.TAB + cM + Settings.TAB + snps;
    }
    
}
