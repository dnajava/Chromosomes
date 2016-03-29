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
public class Degrees {
    DegreeType t;
    double wgs84;
    
    public Degrees() {
        t = DegreeType.NONE;
        wgs84 = 0.0;
    }

    public Degrees(DegreeType dt, double d) {
        t = dt;
        wgs84 = d;
    }
    
    public void setDT(DegreeType dt) { t = dt; }
    public void setD(double d) { wgs84 = d; }
    
    public DegreeType getDT() { return t; }
    public double getD() { return wgs84; }
    
    @Override
    public String toString() {
        return "" + t + " " + wgs84;
    }
}
