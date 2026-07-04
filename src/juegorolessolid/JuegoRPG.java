package juegorolessolid;

import java.util.Scanner;

public class JuegoRPG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Creando Personaje 1:");
        Personajes p1 = crearPersonaje(sc);

        System.out.println("Creando Personaje 2:");
        Personajes p2 = crearPersonaje(sc);

        iniciarBatalla(p1, p2);
    }

    public static Personajes crearPersonaje(Scanner sc) {
        System.out.println("Elige: 1. Guerrero, 2. Mago, 3. Arquero");
        int opcion = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        return switch (opcion) {
            case 1 ->
                new Guerreros(nombre, 100, 20, 15, 10);
            case 2 ->
                new Mago(nombre, 80, 15, 40);
            case 3 ->
                new Arqueros(nombre, 90, 12, 10, 20);
            default ->
                null;
        };

    }

    public static void iniciarBatalla(Personajes p1, Personajes p2) {
        Arma espadaAcero = new Arma("Espada de Acero", 10);
        Armadura escudoMadera = new Armadura("Escudo de Madera", 5);
        Arma dagaBasica = new Arma("Daga Básica", 5);

        p1.agregarInventario(espadaAcero);
        p1.agregarInventario(escudoMadera);
        p1.equipar(espadaAcero);

        p2.agregarInventario(dagaBasica);
        p2.equipar(dagaBasica);

        System.out.println("¡Combate entre " + p1.getNombre() + " y " + p2.getNombre() + "!");

        int turnos = 0;
        while (p1.getVida() > 0 && p2.getVida() > 0 && turnos < 10) {

            int danio1 = Math.max(0, p1.atacar() - p2.defender());
            p2.recibirDanio(danio1);

            System.out.println(p1.getNombre() + " causa " + danio1 + " de daño a " + p2.getNombre());

            turnos++;

        }

        System.out.println("\n--- RESULTADO FINAL ---");
        if (p1.vida <= 0 && p2.vida <= 0) {
            System.out.println("¡Empate! Ambos han caído.");
        } else if (p1.vida > 0) {
            System.out.println("¡Ganador: " + p1.nombre + "!");
        } else {
            System.out.println("¡Ganador: " + p2.nombre + "!");
        }
    }
}
