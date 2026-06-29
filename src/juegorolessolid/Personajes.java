package juegorolessolid;

import java.util.ArrayList;
import java.util.List;

public abstract class Personajes {

    protected String nombre;
    protected int vida, ataque;

    // Atributos de equipo
    protected Arma armaEquipada;
    protected Armadura armaduraEquipada;

    public Personajes(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void equiparArma(Arma arma) {
        this.armaEquipada = arma;
    }

    public void equiparArmadura(Armadura armadura) {
        this.armaduraEquipada = armadura;
    }

    public int getBonusAtaqueEquipado() {
        return (armaEquipada != null) ? armaEquipada.getBonusAtaque() : 0;
    }

    public int getBonusDefensaEquipado() {
        return (armaduraEquipada != null) ? armaduraEquipada.getBonusDefensa() : 0;
    }

    public abstract int atacar();

    public abstract int defender();

    public void recibirDanio(int danio) {
        this.vida -= danio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }
}
