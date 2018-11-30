package poo.cursosccm.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de entidad usada para almacenar los datos de los objetos de tipo Cursos a ser persistidos.
 * Provee todo el comportaiento asociado a los objetos de tipo Curso.
 * @author Iván Fischer
 */
public class Cursos  implements java.io.Serializable {

     private int idCursos;
     private Tematicas tematicas;
     private String nombre;
     private String profesor;
     private int aula;
     private String duracion;
     private String cargaHoraria;
     private int cupo;
     private List<Inscripcion> inscripciones;

    /**
     * Constructor vacío de la clase.
     */
    public Cursos() {
        inscripciones = new ArrayList();
    }
	
    /**
     * Constructor principal de la clase
     * @param idCursos
     * @param tematicas
     * @param nombre
     * @param profesor
     * @param aula
     * @param duracion
     * @param cargaHoraria
     * @param cupo
     */
    public Cursos(int idCursos, Tematicas tematicas, String nombre, String profesor, int aula, String duracion, String cargaHoraria, int cupo) {
        this.idCursos = idCursos;
        this.tematicas = tematicas;
        this.nombre = nombre;
        this.profesor = profesor;
        this.aula = aula;
        this.duracion = duracion;
        this.cargaHoraria = cargaHoraria;
        this.cupo = cupo;
        this.inscripciones = new ArrayList();
    }
    
    /**
     * Constructor completo de la clase
     * @param idCursos
     * @param tematicas
     * @param nombre
     * @param profesor
     * @param aula
     * @param duracion
     * @param cargaHoraria
     * @param cupo
     * @param inscripciones
     */
    public Cursos(int idCursos, Tematicas tematicas, String nombre, String profesor, int aula, String duracion, String cargaHoraria, int cupo, List<Inscripcion> inscripciones) {
       this.idCursos = idCursos;
       this.tematicas = tematicas;
       this.nombre = nombre;
       this.profesor = profesor;
       this.aula = aula;
       this.duracion = duracion;
       this.cargaHoraria = cargaHoraria;
       this.cupo = cupo;
       this.inscripciones = inscripciones;
    }

    /**
     * Obtiene el nombre del curso.
     * @return un String que es el nombre del curso.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Obtiene el profesor a cargo del curso
     * @return un String que identifica al profesor del curso.
     */
    public String getProfesor() {
        return this.profesor;
    }
   
    /**
     * obtiene el aula donde se dicta el curso.
     * @return un entero que representa el aula donde se dicta el curso.
     */
    public int getAula() {
        return this.aula;
    }
 
    /**
     * Obtiene la duración del curso
     * @return un String con la descripción de la duración del curso.
     */
    public String getDuracion() {
        return this.duracion;
    }
  
    /**
     * Obtiene la carga horaria del curso.
     * @return un String con la descripción de la carga horaria del curso.
     */
    public String getCargaHoraria() {
        return this.cargaHoraria;
    }

    /**
     * Obtiene el cupo del curso.
     * @return un entero que representa el cupo del curso.
     */
    public int getCupo() {
        return this.cupo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    /**
     * Este método valida que haya lugar en el curso para inscribir mas participantes.
     * @return true si hay vacantes, de lo contrario false.
     */
    public boolean hayVacante(){
        return cupo>inscripciones.size();
    }

}


