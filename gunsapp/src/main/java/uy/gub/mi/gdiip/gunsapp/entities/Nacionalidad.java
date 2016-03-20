/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gub.mi.gdiip.gunsapp.entities;

import java.io.Serializable;
import java.util.List;
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
 * @author gustavo
 */
@Entity
@Table(name = "nacionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nacionalidad.findAll", query = "SELECT n FROM Nacionalidad n"),
    @NamedQuery(name = "Nacionalidad.findByNacionalidadId", query = "SELECT n FROM Nacionalidad n WHERE n.nacionalidadId = :nacionalidadId"),
    @NamedQuery(name = "Nacionalidad.findByNacionalidadDesc", query = "SELECT n FROM Nacionalidad n WHERE n.nacionalidadDesc = :nacionalidadDesc")})
public class Nacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NACIONALIDAD_ID")
    private Short nacionalidadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NACIONALIDAD_DESC")
    private String nacionalidadDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidadId")
    private List<NacionalidadPersona> nacionalidadPersonaList;

    public Nacionalidad() {
    }

    public Nacionalidad(Short nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public Nacionalidad(Short nacionalidadId, String nacionalidadDesc) {
        this.nacionalidadId = nacionalidadId;
        this.nacionalidadDesc = nacionalidadDesc;
    }

    public Short getNacionalidadId() {
        return nacionalidadId;
    }

    public void setNacionalidadId(Short nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public String getNacionalidadDesc() {
        return nacionalidadDesc;
    }

    public void setNacionalidadDesc(String nacionalidadDesc) {
        this.nacionalidadDesc = nacionalidadDesc;
    }

    @XmlTransient
    public List<NacionalidadPersona> getNacionalidadPersonaList() {
        return nacionalidadPersonaList;
    }

    public void setNacionalidadPersonaList(List<NacionalidadPersona> nacionalidadPersonaList) {
        this.nacionalidadPersonaList = nacionalidadPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nacionalidadId != null ? nacionalidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidad)) {
            return false;
        }
        Nacionalidad other = (Nacionalidad) object;
        if ((this.nacionalidadId == null && other.nacionalidadId != null) || (this.nacionalidadId != null && !this.nacionalidadId.equals(other.nacionalidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.Nacionalidad[ nacionalidadId=" + nacionalidadId + " ]";
    }
    
}
