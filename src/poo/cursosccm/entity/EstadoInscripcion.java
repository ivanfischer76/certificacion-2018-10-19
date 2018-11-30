package poo.cursosccm.entity;

/**
 * Clase de entidad usada para almacenar los datos de los objetos de tipo EstadoInscripcion a ser persistidos.
 * @author Iván Fischer
 */
public class EstadoInscripcion  implements java.io.Serializable {


     private int idEstadoInscripcion;
     private String estado;

    /**
     * Constructor vació de la clase.
     */
    public EstadoInscripcion() {
    }

    /**
     * Cosntructor principal de la clase
     * @param idEstadoInscripcion
     * @param estado
     */
    public EstadoInscripcion(int idEstadoInscripcion, String estado) {
        this.idEstadoInscripcion = idEstadoInscripcion;
        this.estado = estado;
    }
    
    /**
     * Obtiene el estado.
     * @return un String que representa el nombre del estado.
     */
    public String getEstado() {
        return this.estado;
    }
    
    /**
     * Setea el atributo estado de la clase.
     * @param estado un String que representa el estado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }


}


