package juegorolessolid;

public class Mago extends Personajes {

    private int potenciaMagica;

    public Mago(String nombre, int vida, int ataque, int potenciaMagica) {
        super(nombre, vida, ataque);
        this.potenciaMagica = potenciaMagica;
    }

    @Override
    public int atacar() {
        return this.ataque + (this.potenciaMagica / 2);
    }

    @Override
    public int defender() {
        
        return this.potenciaMagica / 2;
    }

    public int getPotenciaMagica() {
        return potenciaMagica;
    }

    public void setPotenciaMagica(int potenciaMagica) {
        this.potenciaMagica = potenciaMagica;
    }
    
    
    
}
