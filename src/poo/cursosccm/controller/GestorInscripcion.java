/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.controller;

import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import poo.cursosccm.dao.CursosDao;
import poo.cursosccm.dao.CursosDaoHibernateImpl;
import poo.cursosccm.dao.InscripcionDao;
import poo.cursosccm.dao.InscripcionDaoHibernateImpl;
import poo.cursosccm.dao.ParticipantesDao;
import poo.cursosccm.dao.ParticipantesDaoHibernateImpl;
import poo.cursosccm.dao.TematicasDao;
import poo.cursosccm.dao.TematicasDaoHibernateImpl;
import poo.cursosccm.entity.Cursos;
import poo.cursosccm.entity.Inscripcion;
import poo.cursosccm.entity.Participantes;
import poo.cursosccm.entity.Tematicas;
import poo.cursosccm.ui.PantallaInscripcion;

/**
 *
 * @author ivan
 */
public class GestorInscripcion {
    
    private final CursosDao cursosDao;
    private final TematicasDao tematicasDao;
    private final ParticipantesDao participantesDao;
    private final InscripcionDao inscripcionDao; 
    
    public GestorInscripcion(SessionFactory sessionFactory) {
        // creamos las instancias de los objetos de acceso a datos
        this.cursosDao = new CursosDaoHibernateImpl(sessionFactory);
        this.tematicasDao = new TematicasDaoHibernateImpl(sessionFactory);
        this.participantesDao = new ParticipantesDaoHibernateImpl(sessionFactory);
        this.inscripcionDao = new InscripcionDaoHibernateImpl(sessionFactory);
    }

    /**
     *
     */
    public void run() {
        new PantallaInscripcion(this).setVisible(true);
    }
    
    public List<Cursos> listarCursos(Tematicas tematica){        
        return cursosDao.listarCursos(tematica);
    }
    
    public List<Tematicas> listarTematicas(){        
        return tematicasDao.listarTematicas();
    }
    
    public Participantes buscarParticipante(String mail){       
        return participantesDao.buscarParticipanteXemail(mail);
    }
    
    public void generarInscripcion(Participantes participante, Cursos curso){
        Calendar ahora = Calendar.getInstance();
        ahora.add(Calendar.MINUTE, -55);
        //validamos que no exista una inscripcion de ese participante para ese curso
        //esta no es una regla de negocio explicita pero creo que es implícita
        if(!inscripcionDao.estaInscripto(participante, curso)){
            //validamos que ese participante no se encuantre inscripto en 3 cursos
            //esta es una regla de negocio explícita
            if(inscripcionDao.getCantidadCursosPorParticipante(participante)<3){
                //validamos que haya cupo
                //esta es una regla de negocio exĺícita 
                if(inscripcionDao.hayVacantes(curso)){
                    //creamos una instancia de inscripcion 
                    Inscripcion inscripcion = new Inscripcion(curso, participante, 0, ahora.getTime());
                    //guardamos la inscripcion recuperando el id
                    int nuevoId = inscripcionDao.guardar(inscripcion);
                    //si todo ha sido exitoso mostramos el mensaje de inscripcion realizada                   
                    JOptionPane.showMessageDialog(null, "Inscripcion realizada\n"
                        + "Estimado "+participante.toString()+" ("+participante.getEmail()+") Usted se encuentra inscripto al curso"
                            + "\nelegido con el número de inscripción "+nuevoId, 
                            "Informe de Inscripcion", JOptionPane.INFORMATION_MESSAGE);                    
                }else{
                    //creamos una instancia de inscripcion condicional
                    Inscripcion inscripcion = new Inscripcion(curso, participante, 1, ahora.getTime());
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
                //informamos la situación
                JOptionPane.showMessageDialog(null, "Lo sentimos mucho pero sólo puede inscribirse en 3 cursos y usted ya lo ha hecho\n"
                        + "No puede inscribirse en más cursos por ahora", "Informe de Inscripcion", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            //informamos la situación
            JOptionPane.showMessageDialog(null, "El Estudiante ya está inscripto en el curso seleccionado\n",
                        "Informe de Inscripcion", JOptionPane.INFORMATION_MESSAGE);
        }          
    }
    
}
