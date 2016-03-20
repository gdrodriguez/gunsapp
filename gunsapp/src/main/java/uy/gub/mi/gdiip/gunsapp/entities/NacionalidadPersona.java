/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gub.mi.gdiip.gunsapp.entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "nacionalidad_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NacionalidadPersona.findAll", query = "SELECT n FROM NacionalidadPersona n"),
    @NamedQuery(name = "NacionalidadPersona.findByNacionalidadPersonaId", query = "SELECT n FROM NacionalidadPersona n WHERE n.nacionalidadPersonaId = :nacionalidadPersonaId")})
public class NacionalidadPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NACIONALIDAD_PERSONA_ID")
    private Short nacionalidadPersonaId;
    @JoinColumn(name = "NACIONALIDAD_ID", referencedColumnName = "NACIONALIDAD_ID")
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidadId;
    @JoinColumn(name = "PERSONA_PERSONA_ID", referencedColumnName = "PERSONA_ID")
    @ManyToOne(optional = false)
    private Persona personaPersonaId;

    public NacionalidadPersona() {
    }

    public NacionalidadPersona(Short nacionalidadPersonaId) {
        this.nacionalidadPersonaId = nacionalidadPersonaId;
    }

    public Short getNacionalidadPersonaId() {
        return nacionalidadPersonaId;
    }

    public void setNacionalidadPersonaId(Short nacionalidadPersonaId) {
        this.nacionalidadPersonaId = nacionalidadPersonaId;
    }

    public Nacionalidad getNacionalidadId() {
        return nacionalidadId;
    }

    public void setNacionalidadId(Nacionalidad nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public Persona getPersonaPersonaId() {
        return personaPersonaId;
    }

    public void setPersonaPersonaId(Persona personaPersonaId) {
        this.personaPersonaId = personaPersonaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nacionalidadPersonaId != null ? nacionalidadPersonaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NacionalidadPersona)) {
            return false;
        }
        NacionalidadPersona other = (NacionalidadPersona) object;
        if ((this.nacionalidadPersonaId == null && other.nacionalidadPersonaId != null) || (this.nacionalidadPersonaId != null && !this.nacionalidadPersonaId.equals(other.nacionalidadPersonaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.NacionalidadPersona[ nacionalidadPersonaId=" + nacionalidadPersonaId + " ]";
    }
    
}
