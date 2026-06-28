/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegorolessolid;

public class Guerreros extends Personajes {

    private int fuerzaFisica;
    private int armadura;

    public Guerreros(String nombre, int vida, int ataque, int fuerzaFisica, int armadura) {
        super(nombre, vida, ataque);
        this.fuerzaFisica = fuerzaFisica;
        this.armadura = armadura;
    }

    
    @Override
    public int atacar() {
        return this.ataque + this.fuerzaFisica;
    }

    @Override
    public int defender() {
        return this.armadura;
    }

    public int getFuerzaFisica() {
        return fuerzaFisica;
    }

    public void setFuerzaFisica(int fuerzaFisica) {
        this.fuerzaFisica = fuerzaFisica;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
    
    
}
