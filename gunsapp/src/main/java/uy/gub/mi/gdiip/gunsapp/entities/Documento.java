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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByDocumentoId", query = "SELECT d FROM Documento d WHERE d.documentoId = :documentoId")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DOCUMENTO_ID")
    private Integer documentoId;
    @JoinColumn(name = "DOCUMENTO_TIPO_DOC_ID", referencedColumnName = "TIPO_DOC_ID")
    @ManyToOne(optional = false)
    private TipoDocumento documentoTipoDocId;
    @JoinColumn(name = "DOCUMENTO_PERSONA_ID", referencedColumnName = "PERSONA_ID")
    @ManyToOne(optional = false)
    private Persona documentoPersonaId;

    public Documento() {
    }

    public Documento(Integer documentoId) {
        this.documentoId = documentoId;
    }

    public Integer getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Integer documentoId) {
        this.documentoId = documentoId;
    }

    public TipoDocumento getDocumentoTipoDocId() {
        return documentoTipoDocId;
    }

    public void setDocumentoTipoDocId(TipoDocumento documentoTipoDocId) {
        this.documentoTipoDocId = documentoTipoDocId;
    }

    public Persona getDocumentoPersonaId() {
        return documentoPersonaId;
    }

    public void setDocumentoPersonaId(Persona documentoPersonaId) {
        this.documentoPersonaId = documentoPersonaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoId != null ? documentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.documentoId == null && other.documentoId != null) || (this.documentoId != null && !this.documentoId.equals(other.documentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.Documento[ documentoId=" + documentoId + " ]";
    }
    
}
