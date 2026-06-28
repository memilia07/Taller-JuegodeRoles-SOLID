package juegorolessolid;

import java.util.ArrayList;
import java.util.List;

public abstract class Personajes {

    protected String nombre;
    protected int vida, ataque;
    protected List<Objeto> inventario = new ArrayList<>();
    protected Arma armaEquipada;
    protected Armadura armaduraEquipada;

    public Personajes(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void equiparArma(Arma a) {
        this.armaEquipada = a;
    }

    public void equiparArmadura(Armadura a) {
        this.armaduraEquipada = a;
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

}
