/*
 * 
 */
package poo.cursosccm.controller;

import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import poo.cursosccm.dao.CursosDao;
import poo.cursosccm.dao.CursosDaoHibernateImpl;
import poo.cursosccm.dao.EstadoInscripcionDao;
import poo.cursosccm.dao.EstadoInscripcionHibernateImpl;
import poo.cursosccm.dao.InscripcionDao;
import poo.cursosccm.dao.InscripcionDaoHibernateImpl;
import poo.cursosccm.dao.ParticipantesDao;
import poo.cursosccm.dao.ParticipantesDaoHibernateImpl;
import poo.cursosccm.dao.TematicasDao;
import poo.cursosccm.dao.TematicasDaoHibernateImpl;
import poo.cursosccm.entity.Cursos;
import poo.cursosccm.entity.EstadoInscripcion;
import poo.cursosccm.entity.Inscripcion;
import poo.cursosccm.entity.Participantes;
import poo.cursosccm.entity.Tematicas;
import poo.cursosccm.ui.PantallaInscripcion;

/**
 * Clase que se encarga de gestionar todos los aspectos e la inscripción.
 * Clase controladora principal encargada de desarrollar el flujo de resolución
 * del caso de uso Registrar Inscripción a Curso.
 * @author Iván Fischer
 */
public class GestorInscripcion {
    
    private final CursosDao cursosDao;
    private final TematicasDao tematicasDao;
    private final ParticipantesDao participantesDao;
    private final InscripcionDao inscripcionDao; 
    private final EstadoInscripcionDao estadoInscrocionDao;
    
    /**
     * Constructor principal de la clase
     * @param sessionFactory
     */
    public GestorInscripcion(SessionFactory sessionFactory) {
        // creamos las instancias de los objetos de acceso a datos
        this.cursosDao = new CursosDaoHibernateImpl(sessionFactory);
        this.tematicasDao = new TematicasDaoHibernateImpl(sessionFactory);
        this.participantesDao = new ParticipantesDaoHibernateImpl(sessionFactory);
        this.inscripcionDao = new InscripcionDaoHibernateImpl(sessionFactory);
        this.estadoInscrocionDao = new EstadoInscripcionHibernateImpl(sessionFactory);
    }

    /**
     * Este método carga la pantalla de inscripción en el sistema y pone en marcha
     * el flujo del resolución del caso de uso Registrar Inscripción a Curso.
     */
    public void run() {
        new PantallaInscripcion(this).setVisible(true);
    }
    
    /**
     * Este método Lista todos los cursos  relacionados a una Temática en particular.
     * @param tematica un objeto de tipo Tematicas.
     * @return un objeto de tipo List de Cursos asociados al objeto Tematicas pasado como parámetro.
     */
    public List<Cursos> listarCursos(Tematicas tematica){        
        return cursosDao.listarCursos(tematica);
    }
    
    /**
     * Este método Lista todos los objetos Tematicas.
     * @return un objeto de tipo List de Tematicas.
     */
    public List<Tematicas> listarTematicas(){        
        return tematicasDao.listarTematicas();
    }
    
    /**
     * Este método obtiene un participante asociado a un e-mail.
     * @param mail
     * @return un único objeto de tipo Participantes asociado al mail pasado como parámetro.
     */
    public Participantes buscarParticipante(String mail){       
        return participantesDao.buscarParticipanteXemail(mail);
    }
    
    /**
     * Este método se encarga de crear un nuevo objeto de tipo Inscripcion.
     * @param participante un objeto de tipo Participantes.
     * @param curso un objeto de tipo Cursos.
     */
    public void generarInscripcion(Participantes participante, Cursos curso){
        Calendar ahora = Calendar.getInstance();
        ahora.add(Calendar.MINUTE, -55);
        //validamos que no exista una inscripcion de ese participante para ese curso
        //esta no es una regla de negocio explicita pero es implícita
        if(!participante.estaInscripto(curso)){
            //validamos que ese participante no se encuantre inscripto en 3 cursos
            //esta es una regla de negocio explícita
            if(participante.cuantosCursos()<3){
                //validamos que haya vacantes en ese curso
                //esta es una regla de negocio exĺícita 
                if(curso.hayVacante()){
                    //creamos una instancia de inscripcion 
                    Inscripcion inscripcion = new Inscripcion(curso, new EstadoInscripcion(1, "Inscripto"), participante, ahora.getTime());
                    //guardamos la inscripcion recuperando el id
                    int nuevoId = inscripcionDao.guardar(inscripcion);
                    //si todo ha sido exitoso mostramos el mensaje de inscripcion realizada                   
                    JOptionPane.showMessageDialog(null, "Inscripcion realizada\n"
                        + "Estimado "+participante.toString()+" ("+participante.getEmail()+") Usted se encuentra inscripto al curso"
                            + "\nelegido con el número de inscripción "+nuevoId, 
                            "Informe de Inscripcion", JOptionPane.INFORMATION_MESSAGE);                    
                }else{
                    //si no hay vacantes en el curso seleccionado
                    //creamos una instancia de inscripcion condicional
                    Inscripcion inscripcion = new Inscripcion(curso, new EstadoInscripcion(2, "Condicional"), participante, ahora.getTime());
                    //guardamos la inscripcion en forma condicional e informamos la situación
                    int nuevoId = inscripcionDao.guardar(inscripcion);
                    //informamos de la situación
                    JOptionPane.showMessageDialog(null, "Estimado "+participante.toString()+" ("+participante.getEmail()+") "
                            + "En este momento no hay vacantes en el curso seleccionado.\n"
                        + "Usted se encuentra inscripto en el curso elegido de forma condicional con el numero "+nuevoId
                            + ".\nSi se producen vacantes, el Centro Cultural se pondrá en contacto con con usted para informarle."
                            + "\n Muchas gracias.", "Informe de Inscripcion", JOptionPane.INFORMATION_MESSAGE);
                }               
            }else{
                //si se encuentra inscripto en 3 cursos
                //informamos la situación
                JOptionPane.showMessageDialog(null, "Lo sentimos mucho pero sólo puede inscribirse en 3 cursos y usted ya lo ha hecho\n"
                        + "Usted se encuentra inscripto en los siguientes cursos:\n"+participante.listarCursosInscripto()+".\n"
                        + "No puede inscribirse en más cursos por ahora", "Informe de Inscripcion", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            //si ya se encuentra inscripto en el curso seleccionado
            //informamos la situación
            JOptionPane.showMessageDialog(null, "El Estudiante ya está inscripto en el curso seleccionado\n",
                        "Informe de Inscripcion", JOptionPane.INFORMATION_MESSAGE);
        }          
    }
    
}
