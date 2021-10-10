/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Sep 16, 2021
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.LinuxDistro;

public class LinuxDistroHelper {
    private static EntityManagerFactory linuxDistributionsEMF = Persistence.createEntityManagerFactory("LinuxDistroHopNotes");
    
    public LinuxDistro findLinuxDistroID(int id) {
        EntityManager linuxDistributionsEM = linuxDistributionsEMF.createEntityManager();
        linuxDistributionsEM.getTransaction().begin();
        
        LinuxDistro foundDistro = linuxDistributionsEM.find(LinuxDistro.class, id);
        
        linuxDistributionsEM.close();
        return foundDistro;
    }
    
    public List<LinuxDistro> findLinuxDistroName(String name) {
        EntityManager linuxDistributionsEM = linuxDistributionsEMF.createEntityManager();
        linuxDistributionsEM.getTransaction().begin();
        TypedQuery<LinuxDistro> linuxDistroTypedQuery = linuxDistributionsEM.createQuery("SELECT distro FROM LinuxDistro distro WHERE distro.name = :selectedName", LinuxDistro.class);
        
        linuxDistroTypedQuery.setParameter("selectedName", name);
        
        List<LinuxDistro> distroResults = linuxDistroTypedQuery.getResultList();
        
        linuxDistributionsEM.close();
        return distroResults;
    }
    
    public List<LinuxDistro> findLinuxDistroBasedOn(String basedOn) {
        EntityManager linuxDistributionsEM = linuxDistributionsEMF.createEntityManager();
        linuxDistributionsEM.getTransaction().begin();
        TypedQuery<LinuxDistro> linuxDistroTypedQuery = linuxDistributionsEM.createQuery("SELECT distro FROM LinuxDistro distro WHERE distro.basedOn = :selectedBasedOn", LinuxDistro.class);
        
        linuxDistroTypedQuery.setParameter("selectedBasedOn", basedOn);
        
        List<LinuxDistro> distroResults = linuxDistroTypedQuery.getResultList();
        
        linuxDistributionsEM.close();
        return distroResults;
    }
    
    public List<LinuxDistro> findLinuxDistroOrigin(String origin) {
        EntityManager linuxDistributionsEM = linuxDistributionsEMF.createEntityManager();
        linuxDistributionsEM.getTransaction().begin();
        TypedQuery<LinuxDistro> linuxDistroTypedQuery = linuxDistributionsEM.createQuery("SELECT distro FROM LinuxDistro distro WHERE distro.origin = :selectedOrigin", LinuxDistro.class);
        
        linuxDistroTypedQuery.setParameter("selectedOrigin", origin);
        
        List<LinuxDistro> distroResults = linuxDistroTypedQuery.getResultList();
        
        linuxDistributionsEM.close();
        return distroResults;
    }
    
    public void insertLinuxDistro(LinuxDistro distro) {
        EntityManager linuxDistributionsEM = linuxDistributionsEMF.createEntityManager();
        linuxDistributionsEM.getTransaction().begin();
        
        linuxDistributionsEM.persist(distro);
        linuxDistributionsEM.getTransaction().commit();
        linuxDistributionsEM.close();
    }
    
    public void updateLinuxDistro(LinuxDistro distro) {
        EntityManager linuxDistributionsEM = linuxDistributionsEMF.createEntityManager();
        linuxDistributionsEM.getTransaction().begin();
        
        linuxDistributionsEM.merge(distro);
        linuxDistributionsEM.getTransaction().commit();
        linuxDistributionsEM.close();
    }
    
    public void deleteLinuxDistro(LinuxDistro distro) {
        EntityManager linuxDistributionsEM = linuxDistributionsEMF.createEntityManager();
        linuxDistributionsEM.getTransaction().begin();
        TypedQuery<LinuxDistro> linuxDistroTypedQuery = linuxDistributionsEM.createQuery("SELECT distro FROM LinuxDistro distro WHERE distro.name = :selectedName AND distro.basedOn = :selectedBasedOn AND distro.origin = :selectedOrigin", LinuxDistro.class);
        
        linuxDistroTypedQuery.setParameter("selectedName", distro.getName());
        linuxDistroTypedQuery.setParameter("selectedBasedOn", distro.getBasedOn());
        linuxDistroTypedQuery.setParameter("selectedOrigin", distro.getOrigin());
        
        linuxDistroTypedQuery.setMaxResults(1);
        
        LinuxDistro distroResult = linuxDistroTypedQuery.getSingleResult();
        
        linuxDistributionsEM.remove(distroResult);
        linuxDistributionsEM.getTransaction().commit();
        linuxDistributionsEM.close();
    }
    
    public List<LinuxDistro> getLinuxDistroList() {
        EntityManager linuxDistributionsEM = linuxDistributionsEMF.createEntityManager();
        TypedQuery<LinuxDistro> linuxDistroTypedQuery = linuxDistributionsEM.createQuery("SELECT distro FROM LinuxDistro distro", LinuxDistro.class);
        
        List<LinuxDistro> linuxDistros = linuxDistroTypedQuery.getResultList();
        
        linuxDistributionsEM.close();
        return linuxDistros;
    }
    
    public void closeEMF() {
        linuxDistributionsEMF.close();
    }
}
