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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "datos_web")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosWeb.findAll", query = "SELECT d FROM DatosWeb d"),
    @NamedQuery(name = "DatosWeb.findByDatosWebId", query = "SELECT d FROM DatosWeb d WHERE d.datosWebId = :datosWebId"),
    @NamedQuery(name = "DatosWeb.findByDatosWebDesc", query = "SELECT d FROM DatosWeb d WHERE d.datosWebDesc = :datosWebDesc")})
public class DatosWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DATOS_WEB_ID")
    private Integer datosWebId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "DATOS_WEB_DESC")
    private String datosWebDesc;
    @JoinColumn(name = "PERSONA_PERSONA_ID", referencedColumnName = "PERSONA_ID")
    @ManyToOne(optional = false)
    private Persona personaPersonaId;

    public DatosWeb() {
    }

    public DatosWeb(Integer datosWebId) {
        this.datosWebId = datosWebId;
    }

    public DatosWeb(Integer datosWebId, String datosWebDesc) {
        this.datosWebId = datosWebId;
        this.datosWebDesc = datosWebDesc;
    }

    public Integer getDatosWebId() {
        return datosWebId;
    }

    public void setDatosWebId(Integer datosWebId) {
        this.datosWebId = datosWebId;
    }

    public String getDatosWebDesc() {
        return datosWebDesc;
    }

    public void setDatosWebDesc(String datosWebDesc) {
        this.datosWebDesc = datosWebDesc;
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
        hash += (datosWebId != null ? datosWebId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosWeb)) {
            return false;
        }
        DatosWeb other = (DatosWeb) object;
        if ((this.datosWebId == null && other.datosWebId != null) || (this.datosWebId != null && !this.datosWebId.equals(other.datosWebId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.DatosWeb[ datosWebId=" + datosWebId + " ]";
    }
    
}
