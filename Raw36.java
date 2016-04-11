/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Raw data research. Reads and uses Raw 36 data from downloaded file.
 * 
 * Format to this data is described in
 * https://www.familytreedna.com/learn/autosomal-ancestry/universal-dna-matching/read-family-finder-raw-data-file/
 * 
 * @author ilpo
 */
public class Raw36 {
    String rsid;            // RS number for the SNP in the NIH dbSNP database
    int chr;                // Name of the chromosome where the SNP is located
    boolean xchr;           // Is this X-chromosome
    long pos;               // location on the chromosome of the SNP
    String result;          // allele values for the SNP
    
    public Raw36() {
        rsid = "";
        chr = 0;
        xchr = false;
        pos = 0;
        result = "";
    }
    
    public Raw36(String prsid, int pchr, long ppos, String presult) {
        rsid = prsid;
        chr = pchr;
        xchr = false;
        pos = ppos;
        result = presult;
    }
    
    public void setRsid(String s) { rsid = s; };
    public void setChr(int c) { chr = c; };
    public void setXChr(boolean b) { xchr = b; };
    public void setPos(long p) { pos = p; };
    public void setResult(String s) { result = s; };

    public String getRsid() { return rsid; };
    public int getChr() { return chr; };
    public boolean getXChr() { return xchr; };
    public long getPos() { return pos; };
    public String getResult() { return result; };
    
    public static List<Raw36> read(String fn) /* throws ParseException */ {
        List <Raw36> lista;
        lista = new ArrayList<>();
        boolean add = false;
        int i = 0; // for debug purposes
        int chr2 = 0;
        boolean xchr2 = false;
        
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

                    // parts[0] = parts[0].substring(2); // Skip first two chars rs if you want

                    chr2 = 0;
                    
                    if(parts[2].equals("X")) {
                        chr2 = 0;
                        xchr2 = true;
                    }
                    else
                        chr2 = Integer.parseInt(parts[2]);
                    
/*
for(int ii = 0; ii< parts.length; ii++)
    System.out.println("***" + ii + "***" + parts[ii] + "***");
*/                    

                    // public Raw36(int prsid, int pchr, long ppos, String presult) {

                    // int prsid, int pchr, boolean pxchr, long ppos, String presult
                    Raw36 a = new Raw36(parts[0], chr2, Long.parseLong(parts[2]),
                                        parts[3]);
                    
/*
if(i < 100) {
    System.out.println("Luettu " + i + " rivi, a=" + a);
    i++;
}
else
    System.exit(0);
*/
                    
                    add = lista.add(a);
                    i++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Virhe: " + e);
            }
        } catch(FileNotFoundException e) {
                System.out.println("Tiedostoa " + fn + " ei löytynyt.");
        }

// System.out.println("Tiedostossa oli rivejä " + i + " kpl.");        
        return lista;
    }
    
    @Override
    public String toString() {
        return "RSID=" + rsid + "\tCHR=" + chr + "\t" + xchr + "\t pos=" + pos + " result=" + result;
    }
    
}
