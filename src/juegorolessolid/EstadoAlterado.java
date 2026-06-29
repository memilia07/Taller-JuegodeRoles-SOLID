package juegorolessolid;

public abstract class EstadoAlterado {

    protected int duracion;

    public EstadoAlterado(int duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor a 0.");
        }
        this.duracion = duracion;
    }

    public abstract void aplicar(Personajes personaje);

    public boolean puedeAtacar() {
        return true;
    }

    public int modificarAtaque(int ataque) {
        return ataque;
    }

    public void reducirDuracion() {
        duracion--;
    }

    public boolean expiro() {
        return duracion <= 0;
    }

    public abstract String getNombre();

}
