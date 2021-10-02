/**
 * @author NAE (Noah Ertz) - naertz
 * CIS-175 - Fall 2021
 * Sep 16, 2021
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LinuxDistributions")
public class LinuxDistro {
    // Instance Variable(s) ===========================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;         // ID
    @Column(name="Name")
    private String name;    // Name
    @Column(name="BasedOn")
    private String basedOn; // Based On
    @Column(name="Origin")
    private String origin;  // Origin
    // ================================================
    
    // Constructor(s) ==============================================
    // Default
    public LinuxDistro() {
        super();
    }
    
    // Name, Based On, Origin
    public LinuxDistro(String name, String basedOn, String origin) {
        super();
        this.name = name;
        this.basedOn = basedOn;
        this.origin = origin;
    }
    // =============================================================
    
    // Setter(s) =======================
    // ID
    public void setId(int id) {
        this.id = id;
    }
    
    // Name
    public void setName(String name) {
        this.name = name;
    }
    
    // Based On
    public void setBasedOn(String basedOn) {
        this.basedOn = basedOn;
    }
    
    // Origin
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    // =================================
    
    // Getter(s) ===============
    // ID
    public int getId() {
        return id;
    }
    
    // Name
    public String getName() {
        return name;
    }
    
    // Based On
    public String getBasedOn() {
        return basedOn;
    }
    
    // Origin
    public String getOrigin() {
        return origin;
    }
    // =========================
    
    // Method(s) ===========================================================================
    // Linux Distro Information
    public String getInformation() {
        return this.name + " [Based On: " + this.basedOn + ", Origin: " + this.origin + "]";
    }
    // =====================================================================================
}
