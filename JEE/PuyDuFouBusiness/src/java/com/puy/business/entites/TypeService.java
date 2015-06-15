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
 * @author utilisateur
 */
@Entity
@Table(name = "type_service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeService.findAll", query = "SELECT t FROM TypeService t"),
    @NamedQuery(name = "TypeService.findByIdType", query = "SELECT t FROM TypeService t WHERE t.idType = :idType"),
    @NamedQuery(name = "TypeService.findByLibelleType", query = "SELECT t FROM TypeService t WHERE t.libelleType = :libelleType")})
public class TypeService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_type")
    private Integer idType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "libelle_type")
    private String libelleType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeService")
    private Collection<Service> serviceCollection;

    public TypeService() {
    }

    public TypeService(Integer idType) {
        this.idType = idType;
    }

    public TypeService(Integer idType, String libelleType) {
        this.idType = idType;
        this.libelleType = libelleType;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getLibelleType() {
        return libelleType;
    }

    public void setLibelleType(String libelleType) {
        this.libelleType = libelleType;
    }

    @XmlTransient
    public Collection<Service> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idType != null ? idType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeService)) {
            return false;
        }
        TypeService other = (TypeService) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.puy.business.entites.TypeService[ idType=" + idType + " ]";
    }
    
}
