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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "sgsp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sgsp.findAll", query = "SELECT s FROM Sgsp s"),
    @NamedQuery(name = "Sgsp.findBySgspId", query = "SELECT s FROM Sgsp s WHERE s.sgspId = :sgspId"),
    @NamedQuery(name = "Sgsp.findBySgspNroevento", query = "SELECT s FROM Sgsp s WHERE s.sgspNroevento = :sgspNroevento"),
    @NamedQuery(name = "Sgsp.findBySgspDepPolicial", query = "SELECT s FROM Sgsp s WHERE s.sgspDepPolicial = :sgspDepPolicial")})
public class Sgsp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SGSP_ID")
    private Integer sgspId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SGSP_NROEVENTO")
    private int sgspNroevento;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "SGSP_TEXTO")
    private String sgspTexto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SGSP_DEP_POLICIAL")
    private String sgspDepPolicial;
    @OneToMany(mappedBy = "eventoSgsp")
    private List<Arma> armaList;

    public Sgsp() {
    }

    public Sgsp(Integer sgspId) {
        this.sgspId = sgspId;
    }

    public Sgsp(Integer sgspId, int sgspNroevento, String sgspTexto, String sgspDepPolicial) {
        this.sgspId = sgspId;
        this.sgspNroevento = sgspNroevento;
        this.sgspTexto = sgspTexto;
        this.sgspDepPolicial = sgspDepPolicial;
    }

    public Integer getSgspId() {
        return sgspId;
    }

    public void setSgspId(Integer sgspId) {
        this.sgspId = sgspId;
    }

    public int getSgspNroevento() {
        return sgspNroevento;
    }

    public void setSgspNroevento(int sgspNroevento) {
        this.sgspNroevento = sgspNroevento;
    }

    public String getSgspTexto() {
        return sgspTexto;
    }

    public void setSgspTexto(String sgspTexto) {
        this.sgspTexto = sgspTexto;
    }

    public String getSgspDepPolicial() {
        return sgspDepPolicial;
    }

    public void setSgspDepPolicial(String sgspDepPolicial) {
        this.sgspDepPolicial = sgspDepPolicial;
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
        hash += (sgspId != null ? sgspId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sgsp)) {
            return false;
        }
        Sgsp other = (Sgsp) object;
        if ((this.sgspId == null && other.sgspId != null) || (this.sgspId != null && !this.sgspId.equals(other.sgspId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.Sgsp[ sgspId=" + sgspId + " ]";
    }
    
}
