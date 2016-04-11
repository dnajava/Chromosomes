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
 * Splits a sting several parts with citation marks
 * 
 * @author ilpo
 */
public class Tools {
    static int rp;                          // Reading position
    static int j = 0;                       // Part number in part
    static int kierros = 0;                 // Kierros
    static Settings sg;
    
    public Tools() { rp = 0; j = 0; sg = new Settings(); }
    
    public static String[] split2(String s, int parlen) {
        
        String[] parts = new String[parlen];

        kierros++;
        j=0;

        if(s.charAt(0)  != '"') {              // Line have to start with "
            return null;
        }
        else {
            rp = 1;

            while(rp < s.length() && j < parlen) {
                parts[j] = nextPart(s,j,parlen);
                j++;
                
            }        
        }
        
        return parts;
    }
    
    private static String nextPart(String s, int pj, int pparlen) {
        String token;
        String apu;                         // String if needed
        char ch;                            // Char just read
        boolean inc = false;                // Is reading in citation
        
        ch = ' '; 
        token = "";
        if(s.charAt(rp) == '"') {
            rp += 3;
            return "";
        }
        
        while(rp < s.length() && j < pparlen && s.charAt(rp) != '"') {
                token = token + s.charAt(rp);
                rp++;
        }

        if(s.charAt(rp) == '"')
            if(j < pparlen) {
                rp += 3; // Skip next part end mark
            } else { }
        else
            System.out.println("Method nextPart warning: no usual token end and next beginning.");
        
        return token;
    }
    
        public static String[] split5(String s, int parlen) {
        
        String[] parts = new String[parlen];

        kierros++;
        j=0;

        if(s.charAt(0)  != '"') {              // Line have to start with "
            return null;
        }
        else {
            rp = 1;

            while(rp < s.length() && j < parlen) {
                parts[j] = nextPart(s,j,parlen);
                j++;
                
            }        
        }
        
        return parts;
    }

}
