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
import poo.cursosccm.entity.Cursos;
import poo.cursosccm.entity.Tematicas;


public class CursosDaoHibernateImpl implements CursosDao {
    
    private final SessionFactory sessionFactory;

    public CursosDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Cursos> listarCursos(Tematicas tematica) {    
        Session session = sessionFactory.openSession();       
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Cursos> query = builder.createQuery(Cursos.class);
        Root<Cursos> root = query.from(Cursos.class);
        query.select(root);
        query.where(builder.equal(root.get("tematicas"), tematica));     
        List<Cursos> cursos = session.createQuery(query).list();        
        session.close();  
        return cursos;
    }
    
}
