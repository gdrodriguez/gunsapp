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
@Table(name = "situacion_arma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacionArma.findAll", query = "SELECT s FROM SituacionArma s"),
    @NamedQuery(name = "SituacionArma.findBySituacionArmaId", query = "SELECT s FROM SituacionArma s WHERE s.situacionArmaId = :situacionArmaId"),
    @NamedQuery(name = "SituacionArma.findBySituacionArmaDesc", query = "SELECT s FROM SituacionArma s WHERE s.situacionArmaDesc = :situacionArmaDesc")})
public class SituacionArma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SITUACION_ARMA_ID")
    private Integer situacionArmaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SITUACION_ARMA_DESC")
    private String situacionArmaDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "situacionArma")
    private List<Arma> armaList;

    public SituacionArma() {
    }

    public SituacionArma(Integer situacionArmaId) {
        this.situacionArmaId = situacionArmaId;
    }

    public SituacionArma(Integer situacionArmaId, String situacionArmaDesc) {
        this.situacionArmaId = situacionArmaId;
        this.situacionArmaDesc = situacionArmaDesc;
    }

    public Integer getSituacionArmaId() {
        return situacionArmaId;
    }

    public void setSituacionArmaId(Integer situacionArmaId) {
        this.situacionArmaId = situacionArmaId;
    }

    public String getSituacionArmaDesc() {
        return situacionArmaDesc;
    }

    public void setSituacionArmaDesc(String situacionArmaDesc) {
        this.situacionArmaDesc = situacionArmaDesc;
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
        hash += (situacionArmaId != null ? situacionArmaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionArma)) {
            return false;
        }
        SituacionArma other = (SituacionArma) object;
        if ((this.situacionArmaId == null && other.situacionArmaId != null) || (this.situacionArmaId != null && !this.situacionArmaId.equals(other.situacionArmaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.SituacionArma[ situacionArmaId=" + situacionArmaId + " ]";
    }
    
}
