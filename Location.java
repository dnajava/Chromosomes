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
public class Location {
    Degrees xd;
    Degrees yd;
    
    public Location() {
        xd = new Degrees(DegreeType.NORTH, 0.0);
        yd = new Degrees(DegreeType.EAST, 0.0);
    }
    
    public Location(Degrees pxd, Degrees pyd) {
        xd = pxd;
        yd = pyd;
    }
    
    public Location(DegreeType dt1, double d1, DegreeType dt2, double d2) {
        xd = new Degrees(dt1, d1);
        yd = new Degrees(dt2, d2);
    }
    
    public void setXD(DegreeType dt, double d) {}
    public void setYD(DegreeType dt, double d) {}
    
    public Degrees getXD() { return xd; }
    public Degrees getYD() { return yd; }

    @Override
    public String toString() {
        return "(" + xd + " , " + yd + ")";
    }
    
}
