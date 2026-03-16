import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<Curso> listaDeCursos = new ArrayList<>();
        int opcion = 0;

        // Bucle del menu principal
        while (opcion != 4) {
            System.out.println("\n--- SISTEMA DE GESTION ACADEMICA (Tarea 7) ---");
            System.out.println("1. Crear nuevo curso");
            System.out.println("2. Agregar tarea a un curso");
            System.out.println("3. Mostrar cursos y tareas");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");

            // Leemos la opcion
            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar el buffer

            if (opcion == 1) {

                        System.out.println("\n--- NUEVO CURSO ---");
                System.out.print("Nombre del curso: ");
                String nom = leer.nextLine();
                System.out.print("Codigo del curso: ");
                String cod = leer.nextLine();
                System.out.print("Nombre del tutor responsable: ");
                String tut = leer.nextLine();

                Curso nuevo = new Curso(nom, cod, tut);
                listaDeCursos.add(nuevo);
                System.out.println("¡Curso guardado exitosamente!");

            } else if (opcion == 2) {

                if (listaDeCursos.size() == 0) {
                    System.out.println("Error: No hay cursos creados todavia.");
                } else {
                    System.out.print("Escribe el codigo del curso para la tarea: ");
                    String buscar = leer.nextLine();
                    boolean encontrado = false;

                    for (Curso c : listaDeCursos) {
                        if (c.codigo.equals(buscar)) {
                            System.out.print("Titulo de la tarea: ");
                            String t_nom = leer.nextLine();
                            System.out.print("Descripcion: ");
                            String t_desc = leer.nextLine();
                            System.out.print("Fecha de entrega: ");
                            String t_fec = leer.nextLine();

                            Tarea nuevaT = new Tarea(t_nom, t_desc, t_fec);
                            c.misTareas.add(nuevaT);
                            System.out.println("Tarea asociada al curso " + c.nombreCurso);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontro ningun curso con ese codigo.");
                    }
                }

            } else if (opcion == 3) {

                        System.out.println("\n--- REPORTE GENERAL ---");
                if (listaDeCursos.size() == 0) {
                    System.out.println("No hay datos registrados.");
                } else {
                    for (Curso c : listaDeCursos) {
                        c.imprimirDatos();
                    }
                }
                // Pausa para que no se borre el menu de inmediato
                System.out.println("\nPresiona ENTER para volver al menu...");
                leer.nextLine();

            } else if (opcion == 4) {
                System.out.println("Saliendo de la aplicacion... ¡Feliz dia!");
            } else {
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
        leer.close();
    }
}