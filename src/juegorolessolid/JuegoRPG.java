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
        System.out.println("¡Combate entre " + p1.nombre + " y " + p2.nombre + "!");

        int turnos = 0;
        while (p1.vida > 0 && p2.vida > 0 && turnos < 10) {
            System.out.println("\n--- Turno " + (turnos + 1) + " ---");

            int danio1 = Math.max(0, p1.atacar() - p2.defender());
            p2.vida -= danio1;
            System.out.println(p1.nombre + " causa " + danio1 + " de daño a " + p2.nombre);

            if (p1.vida > 0) {
                int danio2 = Math.max(0, p2.atacar() - p1.defender());
                p1.vida -= danio2;
                System.out.println(p2.nombre + " causa " + danio2 + " de daño a " + p1.nombre);
            }
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
