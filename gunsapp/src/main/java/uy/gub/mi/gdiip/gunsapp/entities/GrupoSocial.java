/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gub.mi.gdiip.gunsapp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author gustavo
 */
@Entity
@Table(name = "grupo_social")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoSocial.findAll", query = "SELECT g FROM GrupoSocial g"),
    @NamedQuery(name = "GrupoSocial.findByGrupoSocialId", query = "SELECT g FROM GrupoSocial g WHERE g.grupoSocialId = :grupoSocialId"),
    @NamedQuery(name = "GrupoSocial.findByGrupoSocialDesc", query = "SELECT g FROM GrupoSocial g WHERE g.grupoSocialDesc = :grupoSocialDesc")})
public class GrupoSocial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GRUPO_SOCIAL_ID")
    private Short grupoSocialId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GRUPO_SOCIAL_DESC")
    private String grupoSocialDesc;
    @OneToMany(mappedBy = "personaIdgsocial")
    private List<Persona> personaList;

    public GrupoSocial() {
    }

    public GrupoSocial(Short grupoSocialId) {
        this.grupoSocialId = grupoSocialId;
    }

    public GrupoSocial(Short grupoSocialId, String grupoSocialDesc) {
        this.grupoSocialId = grupoSocialId;
        this.grupoSocialDesc = grupoSocialDesc;
    }

    public Short getGrupoSocialId() {
        return grupoSocialId;
    }

    public void setGrupoSocialId(Short grupoSocialId) {
        this.grupoSocialId = grupoSocialId;
    }

    public String getGrupoSocialDesc() {
        return grupoSocialDesc;
    }

    public void setGrupoSocialDesc(String grupoSocialDesc) {
        this.grupoSocialDesc = grupoSocialDesc;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoSocialId != null ? grupoSocialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoSocial)) {
            return false;
        }
        GrupoSocial other = (GrupoSocial) object;
        if ((this.grupoSocialId == null && other.grupoSocialId != null) || (this.grupoSocialId != null && !this.grupoSocialId.equals(other.grupoSocialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.GrupoSocial[ grupoSocialId=" + grupoSocialId + " ]";
    }
    
}
