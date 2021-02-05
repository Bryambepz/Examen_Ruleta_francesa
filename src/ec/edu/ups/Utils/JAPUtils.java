/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.Utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

/**
 *
 * @author braya
 */
public class JAPUtils {
//    private static final EntityManagerFactory
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Examen_Ruleta_FrancesaJPA");
    
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
