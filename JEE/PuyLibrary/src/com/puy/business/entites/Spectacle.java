/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antoine
 */
@Entity
@Table(name = "spectacle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spectacle.findAll", query = "SELECT s FROM Spectacle s"),
    @NamedQuery(name = "Spectacle.findByIdSpectacle", query = "SELECT s FROM Spectacle s WHERE s.idSpectacle = :idSpectacle"),
    @NamedQuery(name = "Spectacle.findByNomSpectacle", query = "SELECT s FROM Spectacle s WHERE s.nomSpectacle = :nomSpectacle"),
    @NamedQuery(name = "Spectacle.findByDescriptionSpectacle", query = "SELECT s FROM Spectacle s WHERE s.descriptionSpectacle = :descriptionSpectacle"),
    @NamedQuery(name = "Spectacle.findByNbActeurs", query = "SELECT s FROM Spectacle s WHERE s.nbActeurs = :nbActeurs"),
    @NamedQuery(name = "Spectacle.findByDuree", query = "SELECT s FROM Spectacle s WHERE s.duree = :duree"),
    @NamedQuery(name = "Spectacle.findByPositionLatitude", query = "SELECT s FROM Spectacle s WHERE s.positionLatitude = :positionLatitude"),
    @NamedQuery(name = "Spectacle.findByPositionLongitude", query = "SELECT s FROM Spectacle s WHERE s.positionLongitude = :positionLongitude"),
    @NamedQuery(name = "Spectacle.findByMoyenneNote", query = "SELECT s FROM Spectacle s WHERE s.moyenneNote = :moyenneNote"),
    @NamedQuery(name = "Spectacle.findByImage", query = "SELECT s FROM Spectacle s WHERE s.image = :image")})
public class Spectacle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_spectacle")
    private Integer idSpectacle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom_spectacle")
    private String nomSpectacle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description_spectacle")
    private String descriptionSpectacle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nb_acteurs")
    private int nbActeurs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duree")
    private int duree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position_latitude")
    private float positionLatitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position_longitude")
    private float positionLongitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "moyenne_note")
    private float moyenneNote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSpectacle")
    private Collection<Planning> planningCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spectacle")
    private Collection<Note> noteCollection;

    public Spectacle() {
    }

    public Spectacle(Integer idSpectacle) {
        this.idSpectacle = idSpectacle;
    }

    public Spectacle(Integer idSpectacle, String nomSpectacle, String descriptionSpectacle, int nbActeurs, int duree, float positionLatitude, float positionLongitude, float moyenneNote, String image) {
        this.idSpectacle = idSpectacle;
        this.nomSpectacle = nomSpectacle;
        this.descriptionSpectacle = descriptionSpectacle;
        this.nbActeurs = nbActeurs;
        this.duree = duree;
        this.positionLatitude = positionLatitude;
        this.positionLongitude = positionLongitude;
        this.moyenneNote = moyenneNote;
        this.image = image;
    }

    public Integer getIdSpectacle() {
        return idSpectacle;
    }

    public void setIdSpectacle(Integer idSpectacle) {
        this.idSpectacle = idSpectacle;
    }

    public String getNomSpectacle() {
        return nomSpectacle;
    }

    public void setNomSpectacle(String nomSpectacle) {
        this.nomSpectacle = nomSpectacle;
    }

    public String getDescriptionSpectacle() {
        return descriptionSpectacle;
    }

    public void setDescriptionSpectacle(String descriptionSpectacle) {
        this.descriptionSpectacle = descriptionSpectacle;
    }

    public int getNbActeurs() {
        return nbActeurs;
    }

    public void setNbActeurs(int nbActeurs) {
        this.nbActeurs = nbActeurs;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public float getPositionLatitude() {
        return positionLatitude;
    }

    public void setPositionLatitude(float positionLatitude) {
        this.positionLatitude = positionLatitude;
    }

    public float getPositionLongitude() {
        return positionLongitude;
    }

    public void setPositionLongitude(float positionLongitude) {
        this.positionLongitude = positionLongitude;
    }

    public float getMoyenneNote() {
        return moyenneNote;
    }

    public void setMoyenneNote(float moyenneNote) {
        this.moyenneNote = moyenneNote;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<Planning> getPlanningCollection() {
        return planningCollection;
    }

    public void setPlanningCollection(Collection<Planning> planningCollection) {
        this.planningCollection = planningCollection;
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpectacle != null ? idSpectacle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spectacle)) {
            return false;
        }
        Spectacle other = (Spectacle) object;
        if ((this.idSpectacle == null && other.idSpectacle != null) || (this.idSpectacle != null && !this.idSpectacle.equals(other.idSpectacle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puy.business.entites.Spectacle[ idSpectacle=" + idSpectacle + " ]";
    }
    
}
