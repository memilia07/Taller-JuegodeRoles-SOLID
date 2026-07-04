package juegorolessolid;

import java.util.ArrayList;
import java.util.List;

public abstract class Personajes {

    protected String nombre;
    protected int vida, ataque;
    protected List<Objeto> inventario = new ArrayList<>();
    protected Objeto objetoEquipado;

    public Personajes(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void agregarInventario(Objeto o) {
        inventario.add(o);
    }

    public void equipar(Objeto o) {
        if (!inventario.contains(o)) {
            inventario.add(o);
        }
        this.objetoEquipado = o;
    }

    public void desequipar() {
        this.objetoEquipado = null;
    }

    public int getBonusAtaqueEquipado() {
        if (objetoEquipado != null) {
            return objetoEquipado.getBonusAtaque();
        }
        return 0;
    }

    public int getBonusDefensaEquipado() {
        if (objetoEquipado != null) {
            return objetoEquipado.getBonusDefensa();
        }
        return 0;
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

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public List<Objeto> getInventario() {
        return inventario;
    }

    public void setInventario(List<Objeto> inventario) {
        this.inventario = inventario;
    }

    public Objeto getObjetoEquipado() {
        return objetoEquipado;
    }

    public void setObjetoEquipado(Objeto objetoEquipado) {
        this.objetoEquipado = objetoEquipado;
    }

}
