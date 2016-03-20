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
@Table(name = "oficio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oficio.findAll", query = "SELECT o FROM Oficio o"),
    @NamedQuery(name = "Oficio.findByOficioId", query = "SELECT o FROM Oficio o WHERE o.oficioId = :oficioId"),
    @NamedQuery(name = "Oficio.findByOficioOficio", query = "SELECT o FROM Oficio o WHERE o.oficioOficio = :oficioOficio")})
public class Oficio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OFICIO_ID")
    private Short oficioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "OFICIO_OFICIO")
    private String oficioOficio;
    @JoinColumn(name = "OFICIO_IDOPERACION", referencedColumnName = "OPERACION_ID")
    @ManyToOne(optional = false)
    private Operacion oficioIdoperacion;

    public Oficio() {
    }

    public Oficio(Short oficioId) {
        this.oficioId = oficioId;
    }

    public Oficio(Short oficioId, String oficioOficio) {
        this.oficioId = oficioId;
        this.oficioOficio = oficioOficio;
    }

    public Short getOficioId() {
        return oficioId;
    }

    public void setOficioId(Short oficioId) {
        this.oficioId = oficioId;
    }

    public String getOficioOficio() {
        return oficioOficio;
    }

    public void setOficioOficio(String oficioOficio) {
        this.oficioOficio = oficioOficio;
    }

    public Operacion getOficioIdoperacion() {
        return oficioIdoperacion;
    }

    public void setOficioIdoperacion(Operacion oficioIdoperacion) {
        this.oficioIdoperacion = oficioIdoperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oficioId != null ? oficioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficio)) {
            return false;
        }
        Oficio other = (Oficio) object;
        if ((this.oficioId == null && other.oficioId != null) || (this.oficioId != null && !this.oficioId.equals(other.oficioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.Oficio[ oficioId=" + oficioId + " ]";
    }
    
}
