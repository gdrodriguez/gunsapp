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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "telefono")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByTelefonoId", query = "SELECT t FROM Telefono t WHERE t.telefonoId = :telefonoId"),
    @NamedQuery(name = "Telefono.findByTelefonoNrotel", query = "SELECT t FROM Telefono t WHERE t.telefonoNrotel = :telefonoNrotel")})
public class Telefono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TELEFONO_ID")
    private Integer telefonoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONO_NROTEL")
    private int telefonoNrotel;
    @JoinColumn(name = "PERSONA_PERSONA_ID", referencedColumnName = "PERSONA_ID")
    @ManyToOne(optional = false)
    private Persona personaPersonaId;

    public Telefono() {
    }

    public Telefono(Integer telefonoId) {
        this.telefonoId = telefonoId;
    }

    public Telefono(Integer telefonoId, int telefonoNrotel) {
        this.telefonoId = telefonoId;
        this.telefonoNrotel = telefonoNrotel;
    }

    public Integer getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId(Integer telefonoId) {
        this.telefonoId = telefonoId;
    }

    public int getTelefonoNrotel() {
        return telefonoNrotel;
    }

    public void setTelefonoNrotel(int telefonoNrotel) {
        this.telefonoNrotel = telefonoNrotel;
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
        hash += (telefonoId != null ? telefonoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.telefonoId == null && other.telefonoId != null) || (this.telefonoId != null && !this.telefonoId.equals(other.telefonoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.Telefono[ telefonoId=" + telefonoId + " ]";
    }
    
}
