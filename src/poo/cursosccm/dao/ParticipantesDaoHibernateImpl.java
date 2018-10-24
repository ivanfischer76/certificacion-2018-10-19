/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.cursosccm.entity.Participantes;

/**
 *
 * @author ivan
 */
public class ParticipantesDaoHibernateImpl implements ParticipantesDao{
    
    private SessionFactory sessionFactory;
    private Participantes participante;
    
    public ParticipantesDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public Participantes buscarParticipanteXemail(String email) {    
        Session session = sessionFactory.openSession();       
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Participantes> query = builder.createQuery(Participantes.class);
        Root<Participantes> root = query.from(Participantes.class);
        query.select(root);
        query.where(builder.equal(root.get("email"), email));     
        participante = session.createQuery(query).uniqueResult();        
        session.close(); 
        return participante;
    }
    
}
