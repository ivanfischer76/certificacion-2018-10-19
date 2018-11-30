package poo.cursosccm.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de entidad usada para almacenar los datos de los objetos de tipo Tematicas a ser persistidos.
 * Provee todo el comportaiento asociado a los objetos de tipo Participantes.
 * @author Iván Fischer
 */
public class Tematicas  implements java.io.Serializable {


     private int idTematicas;
     private String tematica;
     private List<Cursos> losCursos; 

    /**
     * Constructor vacío de la clase.
     */
    public Tematicas() {
        losCursos = new ArrayList<>();
    }

    /**
     * Constructor principal de la clase.
     * @param idTematicas un entero que representa el id de la temática en la base de datos.
     * @param tematica un String que contiene el nombre de la temática.
     */
    public Tematicas(int idTematicas, String tematica) {
        this.idTematicas = idTematicas;
        this.tematica = tematica;
    }

    /**
     * Constructor completo de la clase.
     * @param idTematicas un entero que representa el id de la temática en la base de datos.
     * @param tematica un String que contiene el nombre de la temática.
     * @param losCursos una lista de los cursos asociados a esta temática.
     */
    public Tematicas(int idTematicas, String tematica, List<Cursos> losCursos) {
       this.idTematicas = idTematicas;
       this.tematica = tematica;
       this.losCursos = losCursos;
    }
   
    /**
     *
     * @return
     */
    public int getIdTematicas() {
        return this.idTematicas;
    }
    
    /**
     *
     * @param idTematicas
     */
    public void setIdTematicas(int idTematicas) {
        this.idTematicas = idTematicas;
    }

    /**
     *
     * @return
     */
    public String getTematica() {
        return this.tematica;
    }
    
    /**
     *
     * @param tematica
     */
    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    /**
     *
     * @return
     */
    public List<Cursos> getLosCursos() {
        return this.losCursos;
    }
    
    /**
     *
     * @param losCursos
     */
    public void setLosCursos(List<Cursos> losCursos) {
        this.losCursos = losCursos;
    }


    @Override
    public String toString() {
        return tematica;
    }

}


