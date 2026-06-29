package juegorolessolid;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public abstract class Personajes {

    protected String nombre;
    protected int vida, ataque;
    protected List<Objeto> inventario = new ArrayList<>();
    protected Arma armaEquipada;
    protected Armadura armaduraEquipada;
    protected List<EstadoAlterado> estados = new ArrayList<>();

    public Personajes(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void agregarEstado(EstadoAlterado estado) {
        estados.add(estado);
        System.out.println(nombre + " ahora tiene el estado: " + estado.getNombre());
    }

    public void procesarEstados() {

        Iterator<EstadoAlterado> it = estados.iterator();

        while (it.hasNext()) {

            EstadoAlterado estado = it.next();

            estado.aplicar(this);

            estado.reducirDuracion();

            if (estado.expiro()) {
                System.out.println(nombre + " ya no tiene el estado " + estado.getNombre());
                it.remove();
            }
        }
    }

    public boolean puedeAtacar() {

        for (EstadoAlterado estado : estados) {

            if (!estado.puedeAtacar()) {
                return false;
            }

        }

        return true;
    }

    public int obtenerAtaqueFinal() {

        int ataqueFinal = atacar();

        for (EstadoAlterado estado : estados) {
            ataqueFinal = estado.modificarAtaque(ataqueFinal);
        }

        return ataqueFinal;
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

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public Armadura getArmaduraEquipada() {
        return armaduraEquipada;
    }

    public void setArmaduraEquipada(Armadura armaduraEquipada) {
        this.armaduraEquipada = armaduraEquipada;
    }
}
