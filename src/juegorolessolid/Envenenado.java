package juegorolessolid;

public class Envenenado extends EstadoAlterado {

    private int dano;

    public Envenenado(int duracion, int dano) {
        super(duracion);
        this.dano = dano;
    }

    @Override
    public void aplicar(Personajes personaje) {
        personaje.recibirDanio(dano);
        System.out.println(personaje.getNombre() + " recibe " + dano + " de daño por veneno.");
    }

    @Override
    public String getNombre() {
        return "Envenenado";
    }

}
