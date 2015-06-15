/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Antoine
 */
@Embeddable
public class NotePK implements Serializable {
    @Column(name = "id_spectacle")
    private int idSpectacle;
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
    public String toString() {
        return "entites.NotePK[ idSpectacle=" + idSpectacle + ", idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
