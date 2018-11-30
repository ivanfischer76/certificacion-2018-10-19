package poo.cursosccm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Clase de entidad usada para almacenar los datos de los objetos de tipo Participantes a ser persistidos.
 * Provee todo el comportaiento asociado a los objetos de tipo Participantes.
 * @author Iván Fischer
 */
public class Participantes  implements java.io.Serializable {


     private int idParticipante;
     private String apellido;
     private String nombre;
     private String direccion;
     private String telefono;
     private String email;
     private Date fechaNacimiento;
     private String nombreTutor;
     private List<Inscripcion> inscripciones;

    /**
     * Constructor vacío de la clase.
     */
    public Participantes() {
        inscripciones = new ArrayList();
    }
	
    /**
     * Constructor principal de la clase.
     * @param idParticipante un entero que representa el id del participante.
     * @param apellido un String que representa el apellido del participante.
     * @param nombre un String que representa el nombre del participante.
     * @param direccion un String que representa la dirección del participante.
     * @param telefono un String que representa el teléfono del participante.
     * @param email un String que representa el e-mail del participante.
     * @param fechaNacimiento un Date que representa fecha del nacimiento del participante.
     */
    public Participantes(int idParticipante, String apellido, String nombre, String direccion, String telefono, String email, Date fechaNacimiento) {
        this.idParticipante = idParticipante;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        inscripciones = new ArrayList();
    }
    
    /**
     * Constructor completo de la clase.
     * @param idParticipante un entero que representa el id del participante.
     * @param apellido un String que representa el apellido del participante.
     * @param nombre un String que representa el nombre del participante.
     * @param direccion un String que representa la dirección del participante.
     * @param telefono un String que representa el teléfono del participante.
     * @param email un String que representa el e-mail del participante.
     * @param fechaNacimiento un Date que representa fecha del nacimiento del participante.
     * @param nombreTutor un String que representa el nombre del tutor a cargo del participante.
     * Sólo es necesario si el participante es menor de edad.
     * @param inscripciones una Lista de objetos de tipo Inscripcion que representa las inscripciones en donde se encuentra
     * registrado el participante.
     */
    public Participantes(int idParticipante, String apellido, String nombre, String direccion, String telefono, String email, Date fechaNacimiento, String nombreTutor, List<Inscripcion> inscripciones) {
       this.idParticipante = idParticipante;
       this.apellido = apellido;
       this.nombre = nombre;
       this.direccion = direccion;
       this.telefono = telefono;
       this.email = email;
       this.fechaNacimiento = fechaNacimiento;
       this.nombreTutor = nombreTutor;
       this.inscripciones = inscripciones;
    }
   
    /**
     *
     * @return
     */
    public int getIdParticipante() {
        return this.idParticipante;
    }
    
    /**
     *
     * @param idParticipante
     */
    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }
    
    /**
     *
     * @return
     */
    public String getApellido() {
        return this.apellido;
    }
    
    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     *
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     *
     * @return
     */
    public String getDireccion() {
        return this.direccion;
    }
    
    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     *
     * @return
     */
    public String getTelefono() {
        return this.telefono;
    }
    
    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     *
     * @return
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     *
     * @return
     */
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    /**
     *
     * @return
     */
    public String getNombreTutor() {
        return this.nombreTutor;
    }
    
    /**
     *
     * @param nombreTutor
     */
    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }
    
    /**
     *
     * @return
     */
    public List<Inscripcion> getInscripciones() {
        return this.inscripciones;
    }
    
    /**
     *
     * @param inscripciones
     */
    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return nombre+" "+apellido;
    }
    
    //comportamiento

    /**
     * Determina si un participante es menor de edad, en cuyo caso
     * el campo tutor debe contener datos.
     * @return true si es menor de edad, false de lo contrario.
     */
    
    public boolean esmenor(){
        //este metodo no aplica en la resolución del caso de uso planteado
        //sólo sirve para determinar si el participante es menor de edad para 
        //poner como obligatorio el campo nombreTutor de acuerdo a las reglas
        //del negocio.
        return false;
    }

    /**
     * Determina si este participante está inscripto en el curso que se pasa como parámetro.
     * @param curso un objeto de tipo Cursos.
     * @return true si se encuentra inscripto en el curso, de lo contrario false.
     */
    public boolean estaInscripto(Cursos curso){
        boolean retorno = false;
        Iterator<Inscripcion> i= inscripciones.iterator();
        while(i.hasNext()){
            Inscripcion in = i.next();
            if(in.getParticipantes().equals(this) && in.getCursos().equals(curso)){
                retorno = true;
            }
        }
        return retorno;
    }
    
    /**
     * Determina en cuantos cursos se encuentra inscripto el participante.
     * @return un entero que representa la cantidad de cursos en los que el participante se encuentra inscripto.
     */
    public int cuantosCursos(){
        return inscripciones.size();
    }
    
    /**
     * Obtiene una lista de los cursos en los que el participate se encuentra instripto.
     * @return un String que representa una lista de todos los cursos en los que el aprticipante se encuentra inscripto.
     */
    public String listarCursosInscripto(){
        StringBuilder retorno = new StringBuilder();
                
        Iterator<Inscripcion> it = inscripciones.iterator();
        while(it.hasNext())
        {
            Inscripcion i = it.next();
            retorno.append("\n");
            retorno.append(i.getCursos().toString());
            retorno.append(" en condición de: ");
            retorno.append(i.getEstadoInscripcion());
        }
        return  retorno.toString();
    }
}


