# Trabajo Práctico N° 2 - Actividad 4: Sistema de Gestión de Eventos Universitarios (Versión Final)

Proyecto desarrollado para la cátedra **Paradigmas de Programación** (UTN FRM), correspondiente a la integración final del Trabajo Práctico 2 
---

##  Características Principales ##
1. Concurrencia:
2. Clases Anidadas
3. Manejo de Errores
4. Generics y Wildcards

---

## Estructura del Proyecto
📁 act4
 ┣ 📁 Excepciones
 ┃  ┗ ⚡ CupoExcedidoException
 ┣ 📁 hilos
 ┃  ┗ ☕ EnvioTicketsThread
 ┣ 📁 Modelo
 ┃  ┣ 📁 Actividades
 ┃  ┃  ┣ ☕ Actividad (Abstracta)
 ┃  ┃  ┣ ☕ Charla
 ┃  ┃  ┣ ☕ Curso
 ┃  ┃  ┗ ☕ Taller
 ┃  ┣ 📁 Certificacío
 ┃  ┃  ┗ ⓘ Certificable (Interfaz)
 ┃  ┣ ☕ Estudiante
 ┃  ┣ ☕ EventoUniversitario
 ┃  ┣ ☕ Inscripcion
 ┃  ┃  ┗ ☕ TicketDeAcceso (Clase Anidada Miembro)
 ┃  ┗ ☕ Salas
 ┗ ☕ App (Clase Principal / Ejecutable)


---

 Ejecución
1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/tu-usuario/PP_TP2_tu-legajo.git](https://github.com/tu-usuario/PP_TP2_tu-legajo.git)
