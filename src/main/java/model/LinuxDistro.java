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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="BasedOn")
	private String basedOn;
	@Column(name="Origin")
	private String origin;

	/****************/
	/* Constructors */
	/****************/

	public LinuxDistro() {
		super();
	}

	public LinuxDistro(String name, String basedOn, String origin) {
		super();
		this.name	= name;
		this.basedOn = basedOn;
		this.origin  = origin;
	}

	/***********/
	/* Setters */
	/***********/

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBasedOn(String basedOn) {
		this.basedOn = basedOn;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/***********/
	/* Getters */
	/***********/

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBasedOn() {
		return basedOn;
	}

	public String getOrigin() {
		return origin;
	}

	/***********/
	/* Methods */
	/***********/

	public String getInformation() {
		return this.name + " [Based On: " + this.basedOn + ", Origin: " + this.origin + "]";
	}
}
