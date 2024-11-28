import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de alumnos a cargar:");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese el nombre completo del alumno:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el legajo del alumno:");
            long legajo = scanner.nextLong();
            scanner.nextLine(); // Consumir el salto de línea

            Alumno alumno = new Alumno(nombre, legajo);

            System.out.println("Ingrese la cantidad de notas para este alumno (al menos 1):");
            int cantidadNotas = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            while (cantidadNotas < 1) {
                System.out.println("Debe ingresar al menos una nota. Intente nuevamente:");
                cantidadNotas = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
            }

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.println("Ingrese el nombre de la cátedra:");
                String catedra = scanner.nextLine();

                System.out.println("Ingrese la nota del examen:");
                double notaExamen = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea

                Nota nota = new Nota(catedra, notaExamen);
                alumno.agregarNota(nota);
            }

            alumnos.add(alumno);
        }

        // Mostrar la información de los alumnos
        System.out.println("\nInformación de los alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
            System.out.printf("Promedio de notas: %.2f\n", alumno.calcularPromedio());
        }

        scanner.close();
    }
}
