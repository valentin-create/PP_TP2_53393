package act4.Modelo.Certificacio;

import act4.Modelo.Estudiante;

public interface Certificable {
    String generarCertificacion(Estudiante estudiante);
    String EntidadEmisora = "Univercidad";
}
