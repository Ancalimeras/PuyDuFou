/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

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
public class Planning implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planning")
    private Integer idPlanning;
    @Column(name = "id_spectacle")
    private int idSpectacle;
    @Column(name = "jour_semaine")
    private String jourSemaine;
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
    public String toString() {
        return "entites.Planning[ idPlanning=" + idPlanning + " ]";
    }
    
}
