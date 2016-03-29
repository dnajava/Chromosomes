/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chromosomes;


/**
 *
 * @author ilpo
 */
public class Settings {
    public static final char SEPARATOR = ',';
    public static final String NL = "\n";
    public static final String TAB = "\t";
    public int debug_state;
    
    public Settings() {
        debug_state = 0;
    }
    public Settings(int i) {
        debug_state = i;
    }

    public void setDebug(int i) { debug_state = i; }
    public int getDebug() { return debug_state; }
    
    @Override
    public String toString() {
        return SEPARATOR + NL + TAB + debug_state;
    }
}
