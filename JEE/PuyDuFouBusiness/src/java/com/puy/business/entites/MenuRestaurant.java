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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
<<<<<<< HEAD
 * @author utilisateur
=======
 * @author Antoine
>>>>>>> origin/master
 */
@Entity
@Table(name = "menu_restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuRestaurant.findAll", query = "SELECT m FROM MenuRestaurant m"),
    @NamedQuery(name = "MenuRestaurant.findByIdMenu", query = "SELECT m FROM MenuRestaurant m WHERE m.idMenu = :idMenu"),
    @NamedQuery(name = "MenuRestaurant.findByMenu", query = "SELECT m FROM MenuRestaurant m WHERE m.menu = :menu"),
    @NamedQuery(name = "MenuRestaurant.findByTarif", query = "SELECT m FROM MenuRestaurant m WHERE m.tarif = :tarif")})
public class MenuRestaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu")
    private Integer idMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "menu")
    private String menu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarif")
    private float tarif;
    @JoinColumn(name = "id_service", referencedColumnName = "id_service")
    @ManyToOne(optional = false)
    private Service idService;

    public MenuRestaurant() {
    }

    public MenuRestaurant(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public MenuRestaurant(Integer idMenu, String menu, float tarif) {
        this.idMenu = idMenu;
        this.menu = menu;
        this.tarif = tarif;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuRestaurant)) {
            return false;
        }
        MenuRestaurant other = (MenuRestaurant) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puy.business.entites.MenuRestaurant[ idMenu=" + idMenu + " ]";
    }
    
}
