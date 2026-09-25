package act4.Modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;

    public Inscripcion(LocalDate fecha, String estado, Estudiante estudiante) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {

        return estado;
    }

    public Estudiante getEstudiante() {

        return estudiante;
    }
    private TicketdeAcceso ticket;


    public class TicketdeAcceso implements Serializable {
        private static final long serialVersionUID = 1L;

        private String idTicket;
        private LocalDate fechaEmision;

        public TicketdeAcceso(String idTicket, LocalDate fechaEmision)
        {
            this.idTicket = idTicket;
            this.fechaEmision = fechaEmision;
        }

        public String getIdTicket() {
            return idTicket;
        }

        public LocalDate getFechaEmision() {
            return fechaEmision;
        }

        public void EnviarTicket()
        {
            System.out.println("Enviando ticket de acceso con ID: " + idTicket + " emitido el: " + fechaEmision);
        }
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
