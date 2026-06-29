package juegorolessolid;

public class AumentoFuerza extends EstadoAlterado {

    private int bonus;

    public AumentoFuerza(int duracion, int bonus) {
        super(duracion);
        this.bonus = bonus;
    }

    @Override
    public void aplicar(Personajes personaje) {
        // No realiza ninguna acción al inicio del turno.
    }

    @Override
    public int modificarAtaque(int ataque) {
        return ataque + bonus;
    }

    @Override
    public String getNombre() {
        return "Aumento de Fuerza";
    }
}    

