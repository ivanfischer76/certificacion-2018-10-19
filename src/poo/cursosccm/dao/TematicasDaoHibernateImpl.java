/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.cursosccm.entity.Tematicas;


public class TematicasDaoHibernateImpl implements TematicasDao {
    
    private final SessionFactory sessionFactory;

    public TematicasDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
    @Override
    public List<Tematicas> listarTematicas() {
        Session session = sessionFactory.openSession();        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tematicas> query = builder.createQuery(Tematicas.class);
        Root<Tematicas> root = query.from(Tematicas.class);
        query.select(root);        
        List<Tematicas> tematicas = session.createQuery(query).list();        
        session.close();
        return tematicas;
    }
    
}
