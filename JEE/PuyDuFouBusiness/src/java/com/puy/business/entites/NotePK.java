/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puy.business.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
<<<<<<< HEAD
 * @author utilisateur
=======
 * @author Antoine
>>>>>>> origin/master
 */
@Embeddable
public class NotePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_spectacle")
    private int idSpectacle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "id_utilisateur")
    private String idUtilisateur;

    public NotePK() {
    }

    public NotePK(int idSpectacle, String idUtilisateur) {
        this.idSpectacle = idSpectacle;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdSpectacle() {
        return idSpectacle;
    }

    public void setIdSpectacle(int idSpectacle) {
        this.idSpectacle = idSpectacle;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSpectacle;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotePK)) {
            return false;
        }
        NotePK other = (NotePK) object;
        if (this.idSpectacle != other.idSpectacle) {
            return false;
        }
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puy.business.entites.NotePK[ idSpectacle=" + idSpectacle + ", idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
