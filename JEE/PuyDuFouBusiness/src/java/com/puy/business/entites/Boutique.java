/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antoine
 */
@Entity
@Table(name = "boutique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boutique.findAll", query = "SELECT b FROM Boutique b"),
    @NamedQuery(name = "Boutique.findByIdBoutique", query = "SELECT b FROM Boutique b WHERE b.idBoutique = :idBoutique"),
    @NamedQuery(name = "Boutique.findByNomBoutique", query = "SELECT b FROM Boutique b WHERE b.nomBoutique = :nomBoutique"),
    @NamedQuery(name = "Boutique.findByDescriptionBoutique", query = "SELECT b FROM Boutique b WHERE b.descriptionBoutique = :descriptionBoutique"),
    @NamedQuery(name = "Boutique.findByNoteBoutique", query = "SELECT b FROM Boutique b WHERE b.noteBoutique = :noteBoutique"),
    @NamedQuery(name = "Boutique.findByPositionLatitude", query = "SELECT b FROM Boutique b WHERE b.positionLatitude = :positionLatitude"),
    @NamedQuery(name = "Boutique.findByPositionLongitude", query = "SELECT b FROM Boutique b WHERE b.positionLongitude = :positionLongitude")})
public class Boutique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_boutique")
    private Integer idBoutique;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom_boutique")
    private String nomBoutique;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description_boutique")
    private String descriptionBoutique;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note_boutique")
    private float noteBoutique;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position_latitude")
    private float positionLatitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position_longitude")
    private float positionLongitude;

    public Boutique() {
    }

    public Boutique(Integer idBoutique) {
        this.idBoutique = idBoutique;
    }

    public Boutique(Integer idBoutique, String nomBoutique, String descriptionBoutique, float noteBoutique, float positionLatitude, float positionLongitude) {
        this.idBoutique = idBoutique;
        this.nomBoutique = nomBoutique;
        this.descriptionBoutique = descriptionBoutique;
        this.noteBoutique = noteBoutique;
        this.positionLatitude = positionLatitude;
        this.positionLongitude = positionLongitude;
    }

    public Integer getIdBoutique() {
        return idBoutique;
    }

    public void setIdBoutique(Integer idBoutique) {
        this.idBoutique = idBoutique;
    }

    public String getNomBoutique() {
        return nomBoutique;
    }

    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    public String getDescriptionBoutique() {
        return descriptionBoutique;
    }

    public void setDescriptionBoutique(String descriptionBoutique) {
        this.descriptionBoutique = descriptionBoutique;
    }

    public float getNoteBoutique() {
        return noteBoutique;
    }

    public void setNoteBoutique(float noteBoutique) {
        this.noteBoutique = noteBoutique;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBoutique != null ? idBoutique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boutique)) {
            return false;
        }
        Boutique other = (Boutique) object;
        if ((this.idBoutique == null && other.idBoutique != null) || (this.idBoutique != null && !this.idBoutique.equals(other.idBoutique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puy.business.entites.Boutique[ idBoutique=" + idBoutique + " ]";
    }
    
}
