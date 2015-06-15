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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
<<<<<<< HEAD
 * @author utilisateur
=======
 * @author Antoine
>>>>>>> origin/master
 */
@Entity
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByIdService", query = "SELECT s FROM Service s WHERE s.idService = :idService"),
    @NamedQuery(name = "Service.findByNomService", query = "SELECT s FROM Service s WHERE s.nomService = :nomService"),
    @NamedQuery(name = "Service.findByDescriptionService", query = "SELECT s FROM Service s WHERE s.descriptionService = :descriptionService"),
    @NamedQuery(name = "Service.findByNoteService", query = "SELECT s FROM Service s WHERE s.noteService = :noteService"),
    @NamedQuery(name = "Service.findByPositionLatitude", query = "SELECT s FROM Service s WHERE s.positionLatitude = :positionLatitude"),
    @NamedQuery(name = "Service.findByPositionLongitude", query = "SELECT s FROM Service s WHERE s.positionLongitude = :positionLongitude")})
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_service")
    private Integer idService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom_service")
    private String nomService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description_service")
    private String descriptionService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note_service")
    private float noteService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position_latitude")
    private float positionLatitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "position_longitude")
    private float positionLongitude;
<<<<<<< HEAD
    @JoinColumn(name = "type_service", referencedColumnName = "id_type")
    @ManyToOne(optional = false)
    private TypeService typeService;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idService")
    private Collection<MenuRestaurant> menuRestaurantCollection;
=======
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idService")
    private Collection<MenuRestaurant> menuRestaurantCollection;
    @JoinColumn(name = "type_service", referencedColumnName = "id_type")
    @ManyToOne(optional = false)
    private TypeService typeService;
>>>>>>> origin/master

    public Service() {
    }

    public Service(Integer idService) {
        this.idService = idService;
    }

    public Service(Integer idService, String nomService, String descriptionService, float noteService, float positionLatitude, float positionLongitude) {
        this.idService = idService;
        this.nomService = nomService;
        this.descriptionService = descriptionService;
        this.noteService = noteService;
        this.positionLatitude = positionLatitude;
        this.positionLongitude = positionLongitude;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    public float getNoteService() {
        return noteService;
    }

    public void setNoteService(float noteService) {
        this.noteService = noteService;
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

<<<<<<< HEAD
    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

=======
>>>>>>> origin/master
    @XmlTransient
    public Collection<MenuRestaurant> getMenuRestaurantCollection() {
        return menuRestaurantCollection;
    }

    public void setMenuRestaurantCollection(Collection<MenuRestaurant> menuRestaurantCollection) {
        this.menuRestaurantCollection = menuRestaurantCollection;
    }

<<<<<<< HEAD
=======
    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

>>>>>>> origin/master
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idService != null ? idService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.idService == null && other.idService != null) || (this.idService != null && !this.idService.equals(other.idService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puy.business.entites.Service[ idService=" + idService + " ]";
    }
    
}
