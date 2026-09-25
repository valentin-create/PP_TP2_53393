package act2.Modelo.Certificacio;

import act2.Modelo.Estudiante;

public interface Certificable {
    String generarCertificacion(act2.Modelo.Estudiante estudiante);
    String EntidadEmisora = "Univercidad";
}
