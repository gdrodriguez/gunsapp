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
@Table(name = "tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t"),
    @NamedQuery(name = "TipoDocumento.findByTipoDocId", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocId = :tipoDocId"),
    @NamedQuery(name = "TipoDocumento.findByTipoDocDescripcion", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocDescripcion = :tipoDocDescripcion")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPO_DOC_ID")
    private Short tipoDocId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TIPO_DOC_DESCRIPCION")
    private String tipoDocDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoTipoDocId")
    private List<Documento> documentoList;

    public TipoDocumento() {
    }

    public TipoDocumento(Short tipoDocId) {
        this.tipoDocId = tipoDocId;
    }

    public TipoDocumento(Short tipoDocId, String tipoDocDescripcion) {
        this.tipoDocId = tipoDocId;
        this.tipoDocDescripcion = tipoDocDescripcion;
    }

    public Short getTipoDocId() {
        return tipoDocId;
    }

    public void setTipoDocId(Short tipoDocId) {
        this.tipoDocId = tipoDocId;
    }

    public String getTipoDocDescripcion() {
        return tipoDocDescripcion;
    }

    public void setTipoDocDescripcion(String tipoDocDescripcion) {
        this.tipoDocDescripcion = tipoDocDescripcion;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDocId != null ? tipoDocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.tipoDocId == null && other.tipoDocId != null) || (this.tipoDocId != null && !this.tipoDocId.equals(other.tipoDocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.TipoDocumento[ tipoDocId=" + tipoDocId + " ]";
    }
    
}
