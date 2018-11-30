/*
 * 
 */
package poo.cursosccm.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.cursosccm.entity.Participantes;

/**
 * Clase de implementación de la interface ParticipantesDao.
 * Permite interactuar con la base de datos con objetos de tipo Participante usando
 * el framework Hibernate y su API criteria para las consultas.
 * @author Iván Fischer
 */
public class ParticipantesDaoHibernateImpl implements ParticipantesDao{
    
    private final SessionFactory sessionFactory;
    private Participantes participante;
    
    /**
     * Constructor Principal de la clase.
     * @param sessionFactory
     */
    public ParticipantesDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public Participantes buscarParticipanteXemail(String email) {    
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Participantes> query = builder.createQuery(Participantes.class);
            Root<Participantes> root = query.from(Participantes.class);
            query.select(root);
            query.where(builder.equal(root.get("email"), email));
            participante = session.createQuery(query).uniqueResult();
        } 
        return participante;
    }
    
}
