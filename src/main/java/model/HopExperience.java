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
	@Id
	@GeneratedValue
	private int id;
	private LinuxDistro distro;
	private LocalDate hopDate;
	private int rating;
	private String journal;
	private String finalThoughts;

	/****************/
	/* Constructors */
	/****************/

	public HopExperience() {
		super();
	}

	public HopExperience(LinuxDistro distro, LocalDate hopDate, int rating, String journal, String finalThoughts) {
		super();
		this.distro		= distro;
		this.hopDate	   = hopDate;
		this.rating		= rating;
		this.journal	   = journal;
		this.finalThoughts = finalThoughts;
	}

	/***********/
	/* Setters */
	/***********/

	public void setId(int id) {
		this.id = id;
	}

	public void setDistro(LinuxDistro distro) {
		this.distro = distro;
	}

	public void setHopDate(LocalDate hopDate) {
		this.hopDate = hopDate;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public void setFinalThoughts(String finalThoughts) {
		this.finalThoughts = finalThoughts;
	}

	/***********/
	/* Getters */
	/***********/

	public int getId() {
		return id;
	}

	public LinuxDistro getDistro() {
		return distro;
	}

	public LocalDate getHopDate() {
		return hopDate;
	}

	public int getRating() {
		return rating;
	}

	public String getJournal() {
		return journal;
	}

	public String getFinalThoughts() {
		return finalThoughts;
	}

	/***********/
	/* Methods */
	/***********/

	@Override
	public String toString() {
		return "HopExperience [id=" + id + ", distro=" + distro + ", hopDate=" + hopDate + ", rating=" + rating + ", journal=" + journal + ", finalThoughts=" + finalThoughts + "]";
	}
}
