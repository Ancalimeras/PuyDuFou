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
 * @author Antoine
 */
@Entity
@Table(name = "service")
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private Integer idService;
    @Column(name = "nom_service")
    private String nomService;
    @Column(name = "description_service")
    private String descriptionService;
    @Column(name = "note_service")
    private float noteService;
    @Column(name = "position_latitude")
    private float positionLatitude;
    @Column(name = "position_longitude")
    private float positionLongitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idService")
    private Collection<MenuRestaurant> menuRestaurantCollection;
    @JoinColumn(name = "type_service", referencedColumnName = "id_type")
    @ManyToOne(optional = false)
    private TypeService typeService;

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

    @XmlTransient
    public Collection<MenuRestaurant> getMenuRestaurantCollection() {
        return menuRestaurantCollection;
    }

    public void setMenuRestaurantCollection(Collection<MenuRestaurant> menuRestaurantCollection) {
        this.menuRestaurantCollection = menuRestaurantCollection;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "entites.Service[ idService=" + idService + " ]";
    }
    
}
