/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Oct 9, 2021
 */

package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HopExperience {
    // Instance Variable(s) =======================
    @Id
    @GeneratedValue
    private int id;               // ID
    private LinuxDistro distro;   // Linux Distro
    private LocalDate hopDate;    // Hop Date
    private int rating;           // Rating
    private String journal;       // Journal
    private String finalThoughts; // Final Thoughts
    // ============================================
    
    // Constructor(s) =============================================================================================
    // Default
    public HopExperience() {
        super();
    }
    
    // Linux Distro, Hop Date, Rating, Journal, Final Thoughts
    public HopExperience(LinuxDistro distro, LocalDate hopDate, int rating, String journal, String finalThoughts) {
        super();
        this.distro        = distro;
        this.hopDate       = hopDate;
        this.rating        = rating;
        this.journal       = journal;
        this.finalThoughts = finalThoughts;
    }
    // ============================================================================================================
    
    // Setter(s) =======================================
    // ID
    public void setId(int id) {
        this.id = id;
    }
    
    // Linux Distro
    public void setDistro(LinuxDistro distro) {
        this.distro = distro;
    }
    
    // Hop Date
    public void setHopDate(LocalDate hopDate) {
        this.hopDate = hopDate;
    }
    
    // Rating
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    // Journal
    public void setJournal(String journal) {
        this.journal = journal;
    }
    
    // Final Thoughts
    public void setFinalThoughts(String finalThoughts) {
        this.finalThoughts = finalThoughts;
    }
    // =================================================
    
    // Getter(s) =====================
    // ID
    public int getId() {
        return id;
    }
    
    // Linux Distro
    public LinuxDistro getDistro() {
        return distro;
    }
    
    // Hop Date
    public LocalDate getHopDate() {
        return hopDate;
    }
    
    // Rating
    public int getRating() {
        return rating;
    }
    
    // Journal
    public String getJournal() {
        return journal;
    }
    
    // Final Thoughts
    public String getFinalThoughts() {
        return finalThoughts;
    }
    // ===============================
    
    // Method(s) ===================================================================================================================================================================
    // toString Override
    @Override
    public String toString() {
        return "HopExperience [id=" + id + ", distro=" + distro + ", hopDate=" + hopDate + ", rating=" + rating + ", journal=" + journal + ", finalThoughts=" + finalThoughts + "]";
    }
    // =============================================================================================================================================================================
}
