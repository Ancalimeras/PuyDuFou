/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antoine
 */
@Entity
@Table(name = "note")
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotePK notePK;
    @Column(name = "note")
    private float note;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;
    @JoinColumn(name = "id_spectacle", referencedColumnName = "id_spectacle", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Spectacle spectacle;

    public Note() {
    }

    public Note(NotePK notePK) {
        this.notePK = notePK;
    }

    public Note(NotePK notePK, float note) {
        this.notePK = notePK;
        this.note = note;
    }

    public Note(int idSpectacle, String idUtilisateur) {
        this.notePK = new NotePK(idSpectacle, idUtilisateur);
    }

    public NotePK getNotePK() {
        return notePK;
    }

    public void setNotePK(NotePK notePK) {
        this.notePK = notePK;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    @Override
    public String toString() {
        return "entites.Note[ notePK=" + notePK + " ]";
    }
    
}
