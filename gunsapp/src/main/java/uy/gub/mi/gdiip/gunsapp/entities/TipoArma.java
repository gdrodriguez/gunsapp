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
@Table(name = "tipo_arma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoArma.findAll", query = "SELECT t FROM TipoArma t"),
    @NamedQuery(name = "TipoArma.findByTipoArmaId", query = "SELECT t FROM TipoArma t WHERE t.tipoArmaId = :tipoArmaId"),
    @NamedQuery(name = "TipoArma.findByTipoArmaDesc", query = "SELECT t FROM TipoArma t WHERE t.tipoArmaDesc = :tipoArmaDesc")})
public class TipoArma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPO_ARMA_ID")
    private Short tipoArmaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIPO_ARMA_DESC")
    private String tipoArmaDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armaTipoarmaId")
    private List<Arma> armaList;

    public TipoArma() {
    }

    public TipoArma(Short tipoArmaId) {
        this.tipoArmaId = tipoArmaId;
    }

    public TipoArma(Short tipoArmaId, String tipoArmaDesc) {
        this.tipoArmaId = tipoArmaId;
        this.tipoArmaDesc = tipoArmaDesc;
    }

    public Short getTipoArmaId() {
        return tipoArmaId;
    }

    public void setTipoArmaId(Short tipoArmaId) {
        this.tipoArmaId = tipoArmaId;
    }

    public String getTipoArmaDesc() {
        return tipoArmaDesc;
    }

    public void setTipoArmaDesc(String tipoArmaDesc) {
        this.tipoArmaDesc = tipoArmaDesc;
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
        hash += (tipoArmaId != null ? tipoArmaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoArma)) {
            return false;
        }
        TipoArma other = (TipoArma) object;
        if ((this.tipoArmaId == null && other.tipoArmaId != null) || (this.tipoArmaId != null && !this.tipoArmaId.equals(other.tipoArmaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.TipoArma[ tipoArmaId=" + tipoArmaId + " ]";
    }
    
}
