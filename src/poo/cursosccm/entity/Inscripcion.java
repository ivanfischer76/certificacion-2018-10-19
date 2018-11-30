package poo.cursosccm.entity;

import java.util.Date;

/**
 * Clase de entidad usada para almacenar los datos de los objetos de tipo Inscripcion a ser persistidos.
 * @author Iván Fischer
 */
public class Inscripcion  implements java.io.Serializable {


     private int idInscripcion;
     private Cursos cursos;
     private EstadoInscripcion estadoInscripcion;
     private Participantes participantes;
     private Date fechaHora;

    /**
     * Constructor vacío de la clase.
     */
    public Inscripcion() {
    }

    /**
     * Constructor completo de la clase.
     * @param idInscripcion
     * @param cursos
     * @param estadoInscripcion
     * @param participantes
     * @param fechaHora
     */
    public Inscripcion(int idInscripcion, Cursos cursos, EstadoInscripcion estadoInscripcion, Participantes participantes, Date fechaHora) {
       this.idInscripcion = idInscripcion;
       this.cursos = cursos;
       this.estadoInscripcion = estadoInscripcion;
       this.participantes = participantes;
       this.fechaHora = fechaHora;
    }

    /**
     * Constructor de la clase sin el atributo idInscripcion
     * @param curso
     * @param estadoInscripcion
     * @param participante
     * @param fechaHora
     */
    public Inscripcion(Cursos curso, EstadoInscripcion estadoInscripcion, Participantes participante, Date fechaHora) {
        this.cursos = curso;
        this.estadoInscripcion = estadoInscripcion;
        this.participantes = participante;
        this.fechaHora = fechaHora;
    }
   
    /**
     *
     * @return
     */
    public int getIdInscripcion() {
        return this.idInscripcion;
    }
    
    /**
     *
     * @param idInscripcion
     */
    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }
    
    /**
     *
     * @return
     */
    public Cursos getCursos() {
        return this.cursos;
    }
    
    /**
     *
     * @param cursos
     */
    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    /**
     *
     * @return
     */
    public EstadoInscripcion getEstadoInscripcion() {
        return this.estadoInscripcion;
    }
    
    /**
     *
     * @param estadoInscripcion
     */
    public void setEstadoInscripcion(EstadoInscripcion estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    /**
     *
     * @return
     */
    public Participantes getParticipantes() {
        return this.participantes;
    }
    
    /**
     *
     * @param participantes
     */
    public void setParticipantes(Participantes participantes) {
        this.participantes = participantes;
    }

    /**
     *
     * @return
     */
    public Date getFechaHora() {
        return this.fechaHora;
    }
    
    /**
     *
     * @param fechaHora
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder().append("Inscripcion N° ").append(idInscripcion);
                retorno.append("\nFecha y Hora: ").append(getFechaHora());
                retorno.append("\nCurso: ").append(getCursos());
                retorno.append("\nEstudiante: ").append(getParticipantes());
                retorno.append("\nEstado: ").append(getEstadoInscripcion().getEstado());      
        return  retorno.toString();
    }


}


