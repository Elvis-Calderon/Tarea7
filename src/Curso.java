import java.util.ArrayList;

public class Curso {
    public String nombreCurso;
    public String codigo;
    public String tutor;

    // Las Lista para guardar las tareas de este curso
    public ArrayList<Tarea> misTareas;

    public Curso(String nombreCurso, String codigo, String tutor) {
        this.nombreCurso = nombreCurso;
        this.codigo = codigo;
        this.tutor = tutor;
        this.misTareas = new ArrayList<>();
    }

    // Imprimir los datos del curso y sus tareas
    public void imprimirDatos() {
        System.out.println("-----------------------------------");
        System.out.println("Curso: " + nombreCurso + " (Cod: " + codigo + ")");
        System.out.println("Tutor: " + tutor);
        System.out.println("Tareas asignadas:");

        if (misTareas.size() == 0) {
            System.out.println("   No hay tareas todavia.");
        } else {
            for (int i = 0; i < misTareas.size(); i++) {
                Tarea t = misTareas.get(i);
                System.out.println("   > " + t.nombreTarea + " [Entrega: " + t.fecha + "]");
                System.out.println("     Desc: " + t.descripcion);
            }
        }
    }
}