
package examen2p1_joseseron;

/**
 *
 * @author Jose Seron
 */
public class Items {

    
    //Atributos
    String nombre;
    int HPpoints;
    int MPpoints;

    
    //Constructor
    public Items(String nombre, int HPpoints, int MPpoints) {
        this.nombre = nombre;
        this.HPpoints = HPpoints;
        this.MPpoints = MPpoints;
    }

    @Override
    public String toString() {
        return   "ITEM: "+nombre + " (HP = " + HPpoints + ", MP = " + MPpoints +')' ;
    }

    
    
    
    //Setters y Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHPpoints() {
        return HPpoints;
    }

    public void setHPpoints(int HPpoints) {
        this.HPpoints = HPpoints;
    }

    public int getMPpoints() {
        return MPpoints;
    }

    public void setMPpoints(int MPpoints) {
        this.MPpoints = MPpoints;
    }


    
    
}
