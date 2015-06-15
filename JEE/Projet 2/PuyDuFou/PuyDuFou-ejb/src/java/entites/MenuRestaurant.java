/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

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
 * @author Antoine
 */
@Entity
@Table(name = "menu_restaurant")
public class MenuRestaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer idMenu;
    @Column(name = "menu")
    private String menu;
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
    public String toString() {
        return "entites.MenuRestaurant[ idMenu=" + idMenu + " ]";
    }
    
}
