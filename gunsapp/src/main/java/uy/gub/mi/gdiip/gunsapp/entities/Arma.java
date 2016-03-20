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
@Table(name = "arma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arma.findAll", query = "SELECT a FROM Arma a"),
    @NamedQuery(name = "Arma.findByArmaId", query = "SELECT a FROM Arma a WHERE a.armaId = :armaId"),
    @NamedQuery(name = "Arma.findByArmaNroserie", query = "SELECT a FROM Arma a WHERE a.armaNroserie = :armaNroserie"),
    @NamedQuery(name = "Arma.findByArmaEstado", query = "SELECT a FROM Arma a WHERE a.armaEstado = :armaEstado")})
public class Arma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ARMA_ID")
    private Integer armaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ARMA_NROSERIE")
    private String armaNroserie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARMA_ESTADO")
    private Character armaEstado;
    @JoinColumn(name = "ARMA_FABRICANTE_ID", referencedColumnName = "ARMA_FABRICANTE_ID")
    @ManyToOne(optional = false)
    private ArmaFabricante armaFabricanteId;
    @JoinColumn(name = "CALIBRE_ARMA_ID", referencedColumnName = "CALIBRE_ARMA_ID")
    @ManyToOne(optional = false)
    private CalibreArma calibreArmaId;
    @JoinColumn(name = "ARMA_PERSONA__ID", referencedColumnName = "PERSONA_ID")
    @ManyToOne(optional = false)
    private Persona armaPersonaId;
    @JoinColumn(name = "EVENTO_SGSP", referencedColumnName = "SGSP_ID")
    @ManyToOne
    private Sgsp eventoSgsp;
    @JoinColumn(name = "SITUACION_ARMA", referencedColumnName = "SITUACION_ARMA_ID")
    @ManyToOne(optional = false)
    private SituacionArma situacionArma;
    @JoinColumn(name = "ARMA_TIPOARMA__ID", referencedColumnName = "TIPO_ARMA_ID")
    @ManyToOne(optional = false)
    private TipoArma armaTipoarmaId;

    public Arma() {
    }

    public Arma(Integer armaId) {
        this.armaId = armaId;
    }

    public Arma(Integer armaId, String armaNroserie, Character armaEstado) {
        this.armaId = armaId;
        this.armaNroserie = armaNroserie;
        this.armaEstado = armaEstado;
    }

    public Integer getArmaId() {
        return armaId;
    }

    public void setArmaId(Integer armaId) {
        this.armaId = armaId;
    }

    public String getArmaNroserie() {
        return armaNroserie;
    }

    public void setArmaNroserie(String armaNroserie) {
        this.armaNroserie = armaNroserie;
    }

    public Character getArmaEstado() {
        return armaEstado;
    }

    public void setArmaEstado(Character armaEstado) {
        this.armaEstado = armaEstado;
    }

    public ArmaFabricante getArmaFabricanteId() {
        return armaFabricanteId;
    }

    public void setArmaFabricanteId(ArmaFabricante armaFabricanteId) {
        this.armaFabricanteId = armaFabricanteId;
    }

    public CalibreArma getCalibreArmaId() {
        return calibreArmaId;
    }

    public void setCalibreArmaId(CalibreArma calibreArmaId) {
        this.calibreArmaId = calibreArmaId;
    }

    public Persona getArmaPersonaId() {
        return armaPersonaId;
    }

    public void setArmaPersonaId(Persona armaPersonaId) {
        this.armaPersonaId = armaPersonaId;
    }

    public Sgsp getEventoSgsp() {
        return eventoSgsp;
    }

    public void setEventoSgsp(Sgsp eventoSgsp) {
        this.eventoSgsp = eventoSgsp;
    }

    public SituacionArma getSituacionArma() {
        return situacionArma;
    }

    public void setSituacionArma(SituacionArma situacionArma) {
        this.situacionArma = situacionArma;
    }

    public TipoArma getArmaTipoarmaId() {
        return armaTipoarmaId;
    }

    public void setArmaTipoarmaId(TipoArma armaTipoarmaId) {
        this.armaTipoarmaId = armaTipoarmaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (armaId != null ? armaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arma)) {
            return false;
        }
        Arma other = (Arma) object;
        if ((this.armaId == null && other.armaId != null) || (this.armaId != null && !this.armaId.equals(other.armaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.Arma[ armaId=" + armaId + " ]";
    }
    
}
