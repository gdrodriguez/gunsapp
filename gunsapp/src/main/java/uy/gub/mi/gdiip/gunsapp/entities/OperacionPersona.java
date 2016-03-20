/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gub.mi.gdiip.gunsapp.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "operacion_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperacionPersona.findAll", query = "SELECT o FROM OperacionPersona o"),
    @NamedQuery(name = "OperacionPersona.findByOperacionPersonaId", query = "SELECT o FROM OperacionPersona o WHERE o.operacionPersonaId = :operacionPersonaId"),
    @NamedQuery(name = "OperacionPersona.findByOperacionPersonFinicio", query = "SELECT o FROM OperacionPersona o WHERE o.operacionPersonFinicio = :operacionPersonFinicio"),
    @NamedQuery(name = "OperacionPersona.findByOperacionPersonaFfin", query = "SELECT o FROM OperacionPersona o WHERE o.operacionPersonaFfin = :operacionPersonaFfin")})
public class OperacionPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OPERACION_PERSONA_ID")
    private Integer operacionPersonaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPERACION_PERSON_FINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operacionPersonFinicio;
    @Column(name = "OPERACION_PERSONA_FFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operacionPersonaFfin;
    @JoinColumn(name = "OPERACION_OPERACION_ID", referencedColumnName = "OPERACION_ID")
    @ManyToOne(optional = false)
    private Operacion operacionOperacionId;
    @JoinColumn(name = "PERSONA_PERSONA_ID", referencedColumnName = "PERSONA_ID")
    @ManyToOne(optional = false)
    private Persona personaPersonaId;

    public OperacionPersona() {
    }

    public OperacionPersona(Integer operacionPersonaId) {
        this.operacionPersonaId = operacionPersonaId;
    }

    public OperacionPersona(Integer operacionPersonaId, Date operacionPersonFinicio) {
        this.operacionPersonaId = operacionPersonaId;
        this.operacionPersonFinicio = operacionPersonFinicio;
    }

    public Integer getOperacionPersonaId() {
        return operacionPersonaId;
    }

    public void setOperacionPersonaId(Integer operacionPersonaId) {
        this.operacionPersonaId = operacionPersonaId;
    }

    public Date getOperacionPersonFinicio() {
        return operacionPersonFinicio;
    }

    public void setOperacionPersonFinicio(Date operacionPersonFinicio) {
        this.operacionPersonFinicio = operacionPersonFinicio;
    }

    public Date getOperacionPersonaFfin() {
        return operacionPersonaFfin;
    }

    public void setOperacionPersonaFfin(Date operacionPersonaFfin) {
        this.operacionPersonaFfin = operacionPersonaFfin;
    }

    public Operacion getOperacionOperacionId() {
        return operacionOperacionId;
    }

    public void setOperacionOperacionId(Operacion operacionOperacionId) {
        this.operacionOperacionId = operacionOperacionId;
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
        hash += (operacionPersonaId != null ? operacionPersonaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionPersona)) {
            return false;
        }
        OperacionPersona other = (OperacionPersona) object;
        if ((this.operacionPersonaId == null && other.operacionPersonaId != null) || (this.operacionPersonaId != null && !this.operacionPersonaId.equals(other.operacionPersonaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.OperacionPersona[ operacionPersonaId=" + operacionPersonaId + " ]";
    }
    
}
