/*
 * 
 */
package poo.cursosccm.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.cursosccm.entity.Inscripcion;

/**
 * Clase de implementación de la interface InscripcionDao.
 * Permite interactuar con la base de datos con objetos de tipo Tematicas usando
 * el framework Hibernate para las operaciones de persistencia.
 * @author Iván Fischer
 */
public class InscripcionDaoHibernateImpl implements InscripcionDao{
    
    private final SessionFactory sessionFactory;

    /**
     * Constructor principal de la clase
     * @param sessionFactory
     */
    public InscripcionDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public int guardar(Inscripcion inscripcion) {
        Integer id;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            id = (Integer) session.save(inscripcion);
            session.getTransaction().commit();
        }
        return id;
    }
    
}
