package com.cesi.puydufou.entities;

import java.util.Date;
import android.location.Location;

public class Spectacle {
	
	private int id;
	private String nom;
	private String description;
	private int nb_acteurs;
	private int duree;
	private Date dateDebut;
	private Location location;
	private int note;
	private int moyenne;
	
	
	public Spectacle() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getNb_acteurs() {
		return nb_acteurs;
	}


	public void setNb_acteurs(int nb_acteurs) {
		this.nb_acteurs = nb_acteurs;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public int getNote() {
		return note;
	}


	public void setNote(int note) {
		this.note = note;
	}


	public int getMoyenne() {
		return moyenne;
	}


	public void setMoyenne(int moyenne) {
		this.moyenne = moyenne;
	}

}
