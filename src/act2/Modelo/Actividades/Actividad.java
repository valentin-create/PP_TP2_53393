package act2.Modelo.Actividades;

import act2.Excepciones.CupoExcedidoException;
import act2.Modelo.Estudiante;
import act2.Modelo.Inscripcion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract public class Actividad implements Serializable
{
    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int CUPO_MINIMO = 1;
    public List<Inscripcion> lInscripcion;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public Actividad(int id, String titulo, int cupoMaximo)
    {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.lInscripcion = new ArrayList<Inscripcion>();
    }

    public Inscripcion inscribir(Estudiante estudiante) throws CupoExcedidoException
    {

        if (this.lInscripcion.size() >= this.cupoMaximo) {
            throw new CupoExcedidoException("Cupo Excedido para la actividad: " + this.titulo);
        }

        Inscripcion inscripcion1 = new Inscripcion(LocalDate.now(), "Inscripto", estudiante);
        this.lInscripcion.add(inscripcion1);
        return inscripcion1;
    }

    public void mostrarInscripciones()
    {
        for (Inscripcion oInsc : lInscripcion)
        {
            Estudiante oEst = oInsc.getEstudiante();
            System.out.println("act2.Modelo.Estudiante Inscripto: " + oEst.getNombre());
            System.out.println("Legajo: " + oEst.getLegajo());
            System.out.println("La fecha de la inscripciÃ³n es " + oInsc.getFecha());
            System.out.println("El estado de inscripcion del alumno es: " + oInsc.getEstado());
            System.out.println(" ");
        }
    }

    public final void mostrarIdentificacion()
    {
        System.out.println("act2.Modelo.Actividades.Actividad: " + titulo + " (ID: " + id + ") - Tipo: " + getTipo() + " (Cupo Maximo: " + cupoMaximo + " ) (Cupo Minimo: " + CUPO_MINIMO + " )");

        System.out.println(" ");

        if (getTipo().equals("act2.Modelo.Actividades.Charla"))
        {
            System.out.println("Disertente: " + Charla.getDisertante());
        }
    }

    public abstract double calcularCostoMateriales();

    public abstract String getTipo();

    public abstract Inscripcion[] getInscripcion();

    public abstract Inscripcion[] getInscripciones();
}