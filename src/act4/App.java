package act4;

import act4.Excepciones.CupoExcedidoException;
import act4.Modelo.Actividades.Actividad;
import act4.Modelo.Actividades.Charla;
import act4.Modelo.Actividades.Curso;
import act4.Modelo.Actividades.Taller;
import act4.Modelo.Certificacio.Certificable;
import act4.Modelo.Estudiante;
import act4.Modelo.EventoUniversitario;
import act4.Modelo.Inscripcion;
import act4.Modelo.Salas;

import java.util.List;

public class App {

    public static void main(String[] args) {

        String idEvento = "1";
        EventoUniversitario evento1 = new EventoUniversitario(idEvento, "Introducción a la Robótica", 1500.0, false);

        Estudiante estudiante1 = new Estudiante("Jorge Fernandez", "12332");
        Estudiante estudiante2 = new Estudiante("Luisa Diaz", "11234");
        Estudiante estudiante3 = new Estudiante("Bernardo Rojas", "12455");

        Salas salita1 = new Salas(1, "Sala TIC");

        System.out.println(" ");

        evento1.asignarSala(salita1);


        evento1.crearActividad("act2.Modelo.Actividades.Taller", 1, "Introduccion", 2);
        evento1.crearActividad("act2.Modelo.Actividades.Charla", 2, "Historia de la Robotica", 15);

        Actividad oAct4 = evento1.getActividad(1);
        Actividad oAct5 = evento1.getActividad(2);

        try {
            oAct4.inscribir(estudiante2);
            System.out.println("Inscripción exitosa: " + estudiante2.getNombre() + " en " + oAct4.getTitulo());

            oAct4.inscribir(estudiante3);
            System.out.println("Inscripción exitosa: " + estudiante3.getNombre() + " en " + oAct4.getTitulo());

            oAct4.inscribir(estudiante1);
            System.out.println("Inscripción exitosa: " + estudiante1.getNombre() + " en " + oAct4.getTitulo());
        } catch (CupoExcedidoException e) {
            System.out.println("No se pudo inscribir en '" + oAct4.getTitulo() + "': " + e.getMessage());
        }


        EventoUniversitario eventoLeido = null;
        try {
            oAct5.inscribir(estudiante1);
            oAct5.inscribir(estudiante2);
            System.out.println("Inscripción exitosa en '" + oAct5.getTitulo() + "'");

            evento1.persistirEvento();
            eventoLeido = evento1.recuperarEvento(idEvento);

        } catch (CupoExcedidoException e) {
            System.out.println("No se pudo inscribir en '" + oAct5.getTitulo() + "': " + e.getMessage());
        } finally {
            System.out.println("Flujo de inscripción y persistencia finalizado.");
        }

        System.out.println("--- EMISIÓN DE CERTIFICADOS ---");
        for (Actividad act : evento1.getActividades()) {
            if (act instanceof Certificable) {
                Certificable actividadCertificable = (Certificable) act;

                for (Inscripcion inscripcion : act.getInscripciones()) {
                    Estudiante estudiante = inscripcion.getEstudiante();

                    String certificado = actividadCertificable.generarCertificacion(estudiante);
                    System.out.println(certificado);
                    System.out.println("--------------------------------------------------");
                }
            }
        }
        System.out.println("----Filtradso y Costos Materiales----");
        List<Taller> talleres = evento1.filtrarActividadesPorTipo(Taller.class);
        List<Charla> charlas = evento1.filtrarActividadesPorTipo(Charla.class);
        List<Curso> cursos = evento1.filtrarActividadesPorTipo(Curso.class);

        System.out.println("Talleres creados: " + talleres.size());
        System.out.println("Charlas creadas: " + charlas.size());
        System.out.println("Cursos creados: " + cursos.size());

        System.out.println("Costo de materiales de Talleres: " + evento1.calcularCostoMateriales(talleres));
        System.out.println("Costo de materiales de Charlas: " + evento1.calcularCostoMateriales(charlas));
        System.out.println("Costo de materiales de Cursos: " + evento1.calcularCostoMateriales(cursos));

        System.out.println(" ");
        evento1.mostrarDatos();
        System.out.println(" ");
        System.out.println("Total de eventos registrados: " + EventoUniversitario.getCantidadEventos());

        if (eventoLeido != null) {
            System.out.println("Evento recuperado desde archivo:");
            eventoLeido.mostrarDatos();
        }
        System.out.println("---- HILOS Y ENVÍO DE TICKETS ----");

        for (Actividad act : evento1.getActividades()) {
            for (Inscripcion insc : act.lInscripcion) {
                insc.setEstado("Confirmada");
            }
        }

        act4.hilos.EnvioTicketsThread hiloEnvio = new act4.hilos.EnvioTicketsThread(evento1);
        hiloEnvio.start();

        System.out.println("Continuando con la ejecución principal mientras el hilo secundario envía los tickets");

        for (int i = 1; i <= 2; i++) {
            System.out.println(" Iteración de visualización N° " + i + " ---");
            evento1.mostrarDatos();

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El hilo principal fue interrumpido.");
            }
        }

        try {
            hiloEnvio.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---- FIN DEL PROGRAMA ----");

    }
}