/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antoine
 */
@Entity
@Table(name = "planning")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planning.findAll", query = "SELECT p FROM Planning p"),
    @NamedQuery(name = "Planning.findByIdPlanning", query = "SELECT p FROM Planning p WHERE p.idPlanning = :idPlanning"),
    @NamedQuery(name = "Planning.findByIdSpectacle", query = "SELECT p FROM Planning p WHERE p.idSpectacle = :idSpectacle"),
    @NamedQuery(name = "Planning.findByJourSemaine", query = "SELECT p FROM Planning p WHERE p.jourSemaine = :jourSemaine"),
    @NamedQuery(name = "Planning.findByHeureDebut", query = "SELECT p FROM Planning p WHERE p.heureDebut = :heureDebut")})
public class Planning implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_planning")
    private Integer idPlanning;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_spectacle")
    private int idSpectacle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "jour_semaine")
    private String jourSemaine;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure_debut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;

    public Planning() {
    }

    public Planning(Integer idPlanning) {
        this.idPlanning = idPlanning;
    }

    public Planning(Integer idPlanning, int idSpectacle, String jourSemaine, Date heureDebut) {
        this.idPlanning = idPlanning;
        this.idSpectacle = idSpectacle;
        this.jourSemaine = jourSemaine;
        this.heureDebut = heureDebut;
    }

    public Integer getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(Integer idPlanning) {
        this.idPlanning = idPlanning;
    }

    public int getIdSpectacle() {
        return idSpectacle;
    }

    public void setIdSpectacle(int idSpectacle) {
        this.idSpectacle = idSpectacle;
    }

    public String getJourSemaine() {
        return jourSemaine;
    }

    public void setJourSemaine(String jourSemaine) {
        this.jourSemaine = jourSemaine;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanning != null ? idPlanning.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planning)) {
            return false;
        }
        Planning other = (Planning) object;
        if ((this.idPlanning == null && other.idPlanning != null) || (this.idPlanning != null && !this.idPlanning.equals(other.idPlanning))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puy.business.entites.Planning[ idPlanning=" + idPlanning + " ]";
    }
    
}
