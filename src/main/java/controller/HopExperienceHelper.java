/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Oct 9, 2021
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.HopExperience;

public class HopExperienceHelper {
    private static EntityManagerFactory hopExperiencesEMF = Persistence.createEntityManagerFactory("LinuxDistroHopNotes");
    
    public HopExperience findHopExperienceID(int id) {
        EntityManager hopExperiencesEM = hopExperiencesEMF.createEntityManager();
        hopExperiencesEM.getTransaction().begin();
        
        HopExperience foundHopExperience = hopExperiencesEM.find(HopExperience.class, id);
        
        hopExperiencesEM.close();
        return foundHopExperience;
    }
    
    public void insertHopExperience(HopExperience hopExperience) {
        EntityManager hopExperiencesEM = hopExperiencesEMF.createEntityManager();
        hopExperiencesEM.getTransaction().begin();
        
        hopExperiencesEM.persist(hopExperience);
        hopExperiencesEM.getTransaction().commit();
        hopExperiencesEM.close();
    }
    
    public void updateHopExperience(HopExperience hopExperience) {
        EntityManager hopExperiencesEM = hopExperiencesEMF.createEntityManager();
        hopExperiencesEM.getTransaction().begin();
        
        hopExperiencesEM.merge(hopExperience);
        hopExperiencesEM.getTransaction().commit();
        hopExperiencesEM.close();
    }
    
    public List<HopExperience> getHopExperienceList() {
        EntityManager hopExperiencesEM = hopExperiencesEMF.createEntityManager();
        TypedQuery<HopExperience> hopExperienceTypedQuery = hopExperiencesEM.createQuery("SELECT hopExperience FROM HopExperience hopExperience", HopExperience.class);
        
        List<HopExperience> hopExperiences = hopExperienceTypedQuery.getResultList();
        
        hopExperiencesEM.close();
        return hopExperiences;
    }
    
    public void deleteHopExperience(HopExperience hopExperience) {
        EntityManager hopExperiencesEM = hopExperiencesEMF.createEntityManager();
        hopExperiencesEM.getTransaction().begin();
        TypedQuery<HopExperience> hopExperienceTypedQuery = hopExperiencesEM.createQuery("SELECT hopExperience FROM HopExperience hopExperience WHERE hopExperience.id = :selectedId", HopExperience.class);
        
        hopExperienceTypedQuery.setParameter("selectedId", hopExperience.getId());
        
        hopExperienceTypedQuery.setMaxResults(1);
        
        HopExperience hopExperienceResult = hopExperienceTypedQuery.getSingleResult();
        
        hopExperiencesEM.remove(hopExperienceResult);
        hopExperiencesEM.getTransaction().commit();
        hopExperiencesEM.close();
    }
}
