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
@Table(name = "restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r"),
    @NamedQuery(name = "Restaurant.findByIdRestaurant", query = "SELECT r FROM Restaurant r WHERE r.idRestaurant = :idRestaurant"),
    @NamedQuery(name = "Restaurant.findByNomRestaurant", query = "SELECT r FROM Restaurant r WHERE r.nomRestaurant = :nomRestaurant"),
    @NamedQuery(name = "Restaurant.findByDescriptionRestaurant", query = "SELECT r FROM Restaurant r WHERE r.descriptionRestaurant = :descriptionRestaurant"),
    @NamedQuery(name = "Restaurant.findByNoteRestaurant", query = "SELECT r FROM Restaurant r WHERE r.noteRestaurant = :noteRestaurant"),
    @NamedQuery(name = "Restaurant.findByPositionLatitude", query = "SELECT r FROM Restaurant r WHERE r.positionLatitude = :positionLatitude"),
    @NamedQuery(name = "Restaurant.findByPositionLongitude", query = "SELECT r FROM Restaurant r WHERE r.positionLongitude = :positionLongitude")})
public class Restaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_restaurant")
    private Integer idRestaurant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom_restaurant")
    private String nomRestaurant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description_restaurant")
    private String descriptionRestaurant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note_restaurant")
    private float noteRestaurant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position_latitude")
    private float positionLatitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position_longitude")
    private float positionLongitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRestaurant")
    private Collection<MenuRestaurant> menuRestaurantCollection;

    public Restaurant() {
    }

    public Restaurant(Integer idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public Restaurant(Integer idRestaurant, String nomRestaurant, String descriptionRestaurant, float noteRestaurant, float positionLatitude, float positionLongitude) {
        this.idRestaurant = idRestaurant;
        this.nomRestaurant = nomRestaurant;
        this.descriptionRestaurant = descriptionRestaurant;
        this.noteRestaurant = noteRestaurant;
        this.positionLatitude = positionLatitude;
        this.positionLongitude = positionLongitude;
    }

    public Integer getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Integer idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNomRestaurant() {
        return nomRestaurant;
    }

    public void setNomRestaurant(String nomRestaurant) {
        this.nomRestaurant = nomRestaurant;
    }

    public String getDescriptionRestaurant() {
        return descriptionRestaurant;
    }

    public void setDescriptionRestaurant(String descriptionRestaurant) {
        this.descriptionRestaurant = descriptionRestaurant;
    }

    public float getNoteRestaurant() {
        return noteRestaurant;
    }

    public void setNoteRestaurant(float noteRestaurant) {
        this.noteRestaurant = noteRestaurant;
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

    @XmlTransient
    public Collection<MenuRestaurant> getMenuRestaurantCollection() {
        return menuRestaurantCollection;
    }

    public void setMenuRestaurantCollection(Collection<MenuRestaurant> menuRestaurantCollection) {
        this.menuRestaurantCollection = menuRestaurantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRestaurant != null ? idRestaurant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.idRestaurant == null && other.idRestaurant != null) || (this.idRestaurant != null && !this.idRestaurant.equals(other.idRestaurant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puy.business.entites.Restaurant[ idRestaurant=" + idRestaurant + " ]";
    }
    
}
