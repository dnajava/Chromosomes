/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;

import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Ohjelma lukee FTDNA Chromosome Browserista ladatut matchit ja vie niiden tiedot
 * listaan. Tulostaa listan sisällön.
 *
 * @author ilpo@iki.fi Ilpo Kantonen 28.3.2016
 * @version 1.1
 */
public class Chromosomes {

    /**
     * Tests other tools like FF-matches, Y-dna matches and mtDna matches. The
     * data is downloaded from FTDNA.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        // Siltamäki, Helsinki, Finland: N = 6683508.0 E = 388611.0
        Location paikka = new Location(new Degrees(DegreeType.NORTH, 6683508.0),
                                       new Degrees(DegreeType.EAST, 388611.0));
        
        Person i1;
        i1 = new Person("Ilpo Kantonen", "Ilpo", "Kullervo", "Kantonen",
                         new GregorianCalendar(62,2,16), SexType.MALE, "ilpo@iki.fi");
        
        DnaPerson ilpo;
        ilpo = new DnaPerson(i1,"N-Y5003", "U8a1a1b", "F439365", paikka, ExperienceType.BASIC);
        
        Settings s = new Settings(0);
        
        if(s.getDebug() > 0)
            System.out.println("Henkilö: " + ilpo);

        // ff_matches("i.csv",ilpo);
        // mt_matches("m.csv",ilpo);
        y_matches("y.csv",ilpo);
        
    }

    public static void ff_matches(String fn, DnaPerson p) {
        List <ChromoMatch> lista;
        lista = ChromoMatch.read(fn);

        System.out.println("Löytyi " + lista.size() + " matchia.");
        for(ChromoMatch object: lista){
            System.out.println(object);
        }
    }
    
    public static void mt_matches(String fn, DnaPerson p) {
        List <MtDnaMatch> lista;
        lista = MtDnaMatch.read(fn);

        System.out.println("Löytyi " + lista.size() + " mtDna matchia.");
        for(MtDnaMatch object: lista){
            System.out.println(object);
        }
    }
    
    public static void y_matches(String fn, DnaPerson p) {
        List <YDnaMatch> lista;
        lista = YDnaMatch.read(fn);

        System.out.println("Löytyi " + lista.size() + " mtDna matchia.");
        for(YDnaMatch object: lista){
            System.out.println(object);
        }
    }

}

