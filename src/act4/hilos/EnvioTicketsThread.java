package act4.hilos;

import act4.Modelo.EventoUniversitario;
import act4.Modelo.Actividades.Actividad;
import act4.Modelo.Inscripcion;

public class EnvioTicketsThread extends Thread {
    public EventoUniversitario evento;

    public EnvioTicketsThread(EventoUniversitario evento) {
        this.evento = evento;
    }

    @Override
    public void run() {
        System.out.println("Iniciando proceso de envío de tickets");

        Actividad[] actividades = evento.getActividades();

        for (Actividad act : actividades) {
            for (Inscripcion insc : act.lInscripcion) {
                if (insc.getEstado() != null && insc.getEstado().equalsIgnoreCase("Confirmada")) {
                    System.out.println("Enviando ticket de acceso para el estudiante: " + insc.getEstudiante().getNombre());

                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        System.out.println("El hilo de envío fue interrumpido.");
                    }
                }
            }
        }
        System.out.println("Proceso de envío de tickets finalizado con éxito.");
    }

    @Override
    public void start() {
        super.start();
    }
}