package act3.Modelo.Certificacio;

import act3.Modelo.Estudiante;

public interface Certificable {
    String generarCertificacion(Estudiante estudiante);
    String EntidadEmisora = "Univercidad";
}
