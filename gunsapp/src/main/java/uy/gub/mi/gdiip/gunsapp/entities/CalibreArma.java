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
@Table(name = "calibre_arma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalibreArma.findAll", query = "SELECT c FROM CalibreArma c"),
    @NamedQuery(name = "CalibreArma.findByCalibreArmaId", query = "SELECT c FROM CalibreArma c WHERE c.calibreArmaId = :calibreArmaId"),
    @NamedQuery(name = "CalibreArma.findByCalibreArmaDesc", query = "SELECT c FROM CalibreArma c WHERE c.calibreArmaDesc = :calibreArmaDesc")})
public class CalibreArma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CALIBRE_ARMA_ID")
    private Short calibreArmaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CALIBRE_ARMA_DESC")
    private String calibreArmaDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calibreArmaId")
    private List<Arma> armaList;

    public CalibreArma() {
    }

    public CalibreArma(Short calibreArmaId) {
        this.calibreArmaId = calibreArmaId;
    }

    public CalibreArma(Short calibreArmaId, String calibreArmaDesc) {
        this.calibreArmaId = calibreArmaId;
        this.calibreArmaDesc = calibreArmaDesc;
    }

    public Short getCalibreArmaId() {
        return calibreArmaId;
    }

    public void setCalibreArmaId(Short calibreArmaId) {
        this.calibreArmaId = calibreArmaId;
    }

    public String getCalibreArmaDesc() {
        return calibreArmaDesc;
    }

    public void setCalibreArmaDesc(String calibreArmaDesc) {
        this.calibreArmaDesc = calibreArmaDesc;
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
        hash += (calibreArmaId != null ? calibreArmaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalibreArma)) {
            return false;
        }
        CalibreArma other = (CalibreArma) object;
        if ((this.calibreArmaId == null && other.calibreArmaId != null) || (this.calibreArmaId != null && !this.calibreArmaId.equals(other.calibreArmaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.CalibreArma[ calibreArmaId=" + calibreArmaId + " ]";
    }
    
}
