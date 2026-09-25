package act4.Modelo.Actividades;

import act4.Modelo.Certificacio.Certificable;
import act4.Modelo.Estudiante;
import act4.Modelo.Inscripcion;

public class Taller extends Actividad implements Certificable {

    @Override
    public String generarCertificacion(Estudiante estudiante) {
        return "--- CERTIFICADO DE TALLER ---" +
                "Se certifica que el/la estudiante: " + estudiante.getNombre() +
                " (Legajo: " + estudiante.getLegajo() + ")" +
                "Ha completado exitosamente el taller: " + getTitulo();
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
        return this.lInscripcion.toArray(new Inscripcion[0]);
    }

    @Override
    public Inscripcion[] getInscripciones() {
        return this.lInscripcion.toArray(new Inscripcion[0]);
    }
}