/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;

import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
// import java.text.SimpleDateFormat;

/**
 * Ohjelma testaa FF-matchien, Y-dna matchien ja mtDna matchien tiedot sekä
 * raw data tiedot ladatuista tiedostoista. Tämä ohjelma ei sinänsä tee mitään
 * muuta kuin testaa toiminnan.
 * 
 * Tästä ohjelmasta voi kehitellä sitten ohjelmia, jotka analysoivat tietoja,
 * tulostavat erilaisia tulosteita ja käsittelevät tietoja eri tavoin.
 *  *
 * @author ilpo@iki.fi Ilpo Kantonen 28.3.2016 - now
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
        

        List <Raw36> rl;
        rl = Raw36.read("o36.csv");
        System.out.println("Raw datassa oli rivejä " + rl.size() + " kpl.");
        
        Location paikka = new Location(new Degrees(DegreeType.NORTH, 6600000.0),
                                       new Degrees(DegreeType.EAST, 380000.0));
        
        Person i1;
        na = new Person("Nakke Nakuttaja", "Nakke", "Sebastian", "Nakuttaja",
                         new GregorianCalendar(80,1,1), SexType.MALE, "nakke.nakuttaja@guess.where");
        
        DnaPerson ilpo;
        nakke = new DnaPerson(na,"A-B1c2", "D1e2f3", "F000000", paikka, ExperienceType.BASIC);
        
        int mode = 0;
        
        ff_matches("i.csv",nakke,mode);
        //mt_matches("m.csv",nakke,mode);
        //y_matches("y.csv",nakke,mode);
        
        System.out.println("\nSiinä kaikki tulokset.");
    }

    public static void ff_matches(String fn, DnaPerson p, int pmode) {
        List <ChromoMatch> lista;
        lista = ChromoMatch.read(fn);

        if(pmode>1) System.out.println("\n\n");
        System.out.println("Löytyi " + lista.size() + " FF-matchia.");
        if(pmode > 1) {
            for(ChromoMatch object: lista){
                System.out.println(object);
            }
        }
    }
    
    public static void mt_matches(String fn, DnaPerson p, int pmode) {
        List <MtDnaMatch> lista;
        lista = MtDnaMatch.read(fn);

        if(pmode>1) System.out.println("\n\n");
        System.out.println("Löytyi " + lista.size() + " mtDna matchia.");
        if(pmode > 1) {
            for(MtDnaMatch object: lista){
                System.out.println(object);
            }
        }
    }
    
    public static void y_matches(String fn, DnaPerson p, int pmode) {
        List <YDnaMatch> lista;
        lista = YDnaMatch.read(fn);

        if(pmode>1) System.out.println("\n\n");
        System.out.println("Löytyi " + lista.size() + " Y-Dna matchia.");
        if(pmode > 1) {
            for(YDnaMatch object: lista){
                System.out.println(object);
            }
        }
    }

}

