package act4.Modelo.Actividades;

import act4.Modelo.Certificacio.Certificable;
import act4.Modelo.Estudiante;
import act4.Modelo.Inscripcion;

public class Curso extends Actividad implements Certificable {
    public Curso(int id, String titulo, int cupoMaximo) {
        super(id, titulo, cupoMaximo);
    }

    @Override
    public double calcularCostoMateriales() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "";
    }

    @Override
    public Inscripcion[] getInscripcion() {
        return new Inscripcion[0];
    }

    @Override
    public Inscripcion[] getInscripciones() {
        return new Inscripcion[0];
    }

    @Override
    public String generarCertificacion(Estudiante estudiante) {
        return "";
    }
}
