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
@Table(name = "tipo_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVehiculo.findAll", query = "SELECT t FROM TipoVehiculo t"),
    @NamedQuery(name = "TipoVehiculo.findByTipoVehiculoId", query = "SELECT t FROM TipoVehiculo t WHERE t.tipoVehiculoId = :tipoVehiculoId"),
    @NamedQuery(name = "TipoVehiculo.findByTipoVehiculoDesc", query = "SELECT t FROM TipoVehiculo t WHERE t.tipoVehiculoDesc = :tipoVehiculoDesc")})
public class TipoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIPO_VEHICULO_ID")
    private Short tipoVehiculoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TIPO_VEHICULO_DESC")
    private String tipoVehiculoDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoIdtvehiculo")
    private List<Vehiculo> vehiculoList;

    public TipoVehiculo() {
    }

    public TipoVehiculo(Short tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public TipoVehiculo(Short tipoVehiculoId, String tipoVehiculoDesc) {
        this.tipoVehiculoId = tipoVehiculoId;
        this.tipoVehiculoDesc = tipoVehiculoDesc;
    }

    public Short getTipoVehiculoId() {
        return tipoVehiculoId;
    }

    public void setTipoVehiculoId(Short tipoVehiculoId) {
        this.tipoVehiculoId = tipoVehiculoId;
    }

    public String getTipoVehiculoDesc() {
        return tipoVehiculoDesc;
    }

    public void setTipoVehiculoDesc(String tipoVehiculoDesc) {
        this.tipoVehiculoDesc = tipoVehiculoDesc;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoVehiculoId != null ? tipoVehiculoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVehiculo)) {
            return false;
        }
        TipoVehiculo other = (TipoVehiculo) object;
        if ((this.tipoVehiculoId == null && other.tipoVehiculoId != null) || (this.tipoVehiculoId != null && !this.tipoVehiculoId.equals(other.tipoVehiculoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.TipoVehiculo[ tipoVehiculoId=" + tipoVehiculoId + " ]";
    }
    
}
