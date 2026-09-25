package act4.Modelo.Actividades;

import act4.Modelo.Inscripcion;

public class Charla extends Actividad
{
    private static String disertante = "Jorge Fuentes";

    public Charla(int id, String titulo, int cupoMaximo)
    {
        super(id, titulo, cupoMaximo);
    }

    public static String getDisertante()
    {
        return disertante;
    }

    @Override
    public double calcularCostoMateriales()
    {
        return 5000;
    }

    @Override
    public String getTipo()
    {
        return "act2.Modelo.Actividades.Charla";
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