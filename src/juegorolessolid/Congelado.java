package juegorolessolid;

public class Congelado extends EstadoAlterado {

    public Congelado(int duracion) {
        super(duracion);
    }

    @Override
    public void aplicar(Personajes personaje) {
        System.out.println(personaje.getNombre() + " está congelado.");
    }

    @Override
    public boolean puedeAtacar() {
        return false;
    }

    @Override
    public String getNombre() {
        return "Congelado";
    }
}
