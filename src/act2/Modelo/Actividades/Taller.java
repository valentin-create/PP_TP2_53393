package act2.Modelo.Actividades;

import act2.Modelo.Certificacio.Certificable;
import act2.Modelo.Estudiante;
import act2.Modelo.Inscripcion;

public class Taller extends Actividad implements Certificable {
    @Override
    public String generarCertificacion(Estudiante estudiante) {
        return "";
    }

    private boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo)
    {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = false;
    }

    public boolean isRequiereNotebook()
    {
        return requiereNotebook;
    }

    public void setRequiereNotebook(boolean requiereNotebook)
    {
        this.requiereNotebook = requiereNotebook;
    }

    @Override
    public double calcularCostoMateriales()
    {
        return requiereNotebook ? 5000 : 2000;
    }

    @Override
    public String getTipo()
    {
        return "act2.Modelo.Actividades.Taller";
    }

    @Override
    public Inscripcion[] getInscripcion() {
        return new Inscripcion[0];
    }

    @Override
    public Inscripcion[] getInscripciones() {
        return new Inscripcion[0];
    }
}