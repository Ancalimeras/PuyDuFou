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
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_utilisateur")
    private String idUtilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<Note> noteCollection;

    public Utilisateur() {
    }

    public Utilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    @Override
    public String toString() {
        return "entites.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
