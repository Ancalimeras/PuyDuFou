/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

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
public class Spectacle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spectacle")
    private Integer idSpectacle;
    @Column(name = "nom_spectacle")
    private String nomSpectacle;
    @Column(name = "description_spectacle")
    private String descriptionSpectacle;
    @Column(name = "nb_acteurs")
    private int nbActeurs;
    @Column(name = "duree")
    private int duree;
    @Column(name = "position_latitude")
    private float positionLatitude;
    @Column(name = "position_longitude")
    private float positionLongitude;
    @Column(name = "moyenne_note")
    private float moyenneNote;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
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
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }
    
    @Override
    public String toString() {
        return "entites.Spectacle[ idSpectacle=" + idSpectacle + " ]";
    }
    
}
