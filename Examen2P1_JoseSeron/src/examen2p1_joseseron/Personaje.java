/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2p1_joseseron;

/**
 *
 * @author Jose Seron
 */
public class Personaje {
    
    
        //Atributos
    String nombre;
    int HP, MP, DP, ATK;
    
    //Constructor

    public Personaje(String nombre, int HP, int MP, int DP, int ATK) {
        this.nombre = nombre;
        this.HP = HP;
        this.MP = MP;
        this.DP = DP;
        this.ATK = ATK;
    }

    @Override
    public String toString() {
        return nombre + "\n  HP=" + HP + "\n  MP=" + MP + "\n  DP=" + DP + "\n  ATK=" + ATK ;
    }
    
    
    //Setters Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getDP() {
        return DP;
    }

    public void setDP(int DP) {
        this.DP = DP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }
    
    
}
