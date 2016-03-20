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
@Table(name = "arma_fabricante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArmaFabricante.findAll", query = "SELECT a FROM ArmaFabricante a"),
    @NamedQuery(name = "ArmaFabricante.findByArmaFabricanteId", query = "SELECT a FROM ArmaFabricante a WHERE a.armaFabricanteId = :armaFabricanteId"),
    @NamedQuery(name = "ArmaFabricante.findByArmaFabricanteDesc", query = "SELECT a FROM ArmaFabricante a WHERE a.armaFabricanteDesc = :armaFabricanteDesc")})
public class ArmaFabricante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ARMA_FABRICANTE_ID")
    private Integer armaFabricanteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ARMA_FABRICANTE_DESC")
    private String armaFabricanteDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armaFabricanteId")
    private List<Arma> armaList;

    public ArmaFabricante() {
    }

    public ArmaFabricante(Integer armaFabricanteId) {
        this.armaFabricanteId = armaFabricanteId;
    }

    public ArmaFabricante(Integer armaFabricanteId, String armaFabricanteDesc) {
        this.armaFabricanteId = armaFabricanteId;
        this.armaFabricanteDesc = armaFabricanteDesc;
    }

    public Integer getArmaFabricanteId() {
        return armaFabricanteId;
    }

    public void setArmaFabricanteId(Integer armaFabricanteId) {
        this.armaFabricanteId = armaFabricanteId;
    }

    public String getArmaFabricanteDesc() {
        return armaFabricanteDesc;
    }

    public void setArmaFabricanteDesc(String armaFabricanteDesc) {
        this.armaFabricanteDesc = armaFabricanteDesc;
    }

    @XmlTransient
    public List<Arma> getArmaList() {
        return armaList;
    }

    public void setArmaList(List<Arma> armaList) {
        this.armaList = armaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (armaFabricanteId != null ? armaFabricanteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArmaFabricante)) {
            return false;
        }
        ArmaFabricante other = (ArmaFabricante) object;
        if ((this.armaFabricanteId == null && other.armaFabricanteId != null) || (this.armaFabricanteId != null && !this.armaFabricanteId.equals(other.armaFabricanteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.ArmaFabricante[ armaFabricanteId=" + armaFabricanteId + " ]";
    }
    
}
