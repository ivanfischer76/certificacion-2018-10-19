/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.cursosccm.controller;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author ivan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;        
        // ¡Una SessionFactory es configurada una sola vez para una aplicación!
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure("resources/hibernate.cfg.xml") // configura los ajustes desde hibernate.cfg.xml
			.build();
	try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	}
	catch (Exception e) {
            // El registro debería ser destruído por SessionFactory, pero si tuvimos problemas 
            // para construir SessionFactory lo destruímos manualmente.
            StandardServiceRegistryBuilder.destroy( registry );           
            throw e;
	}
        //lanzamos el gestor principal de la aplicación
        new GestorInscripcion(sessionFactory).run();
    }
    
}
