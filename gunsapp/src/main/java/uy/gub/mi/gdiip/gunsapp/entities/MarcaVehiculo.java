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
@Table(name = "marca_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaVehiculo.findAll", query = "SELECT m FROM MarcaVehiculo m"),
    @NamedQuery(name = "MarcaVehiculo.findByMarcaVehiculoId", query = "SELECT m FROM MarcaVehiculo m WHERE m.marcaVehiculoId = :marcaVehiculoId"),
    @NamedQuery(name = "MarcaVehiculo.findByMarcaVehiculoDesc", query = "SELECT m FROM MarcaVehiculo m WHERE m.marcaVehiculoDesc = :marcaVehiculoDesc")})
public class MarcaVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MARCA_VEHICULO_ID")
    private Short marcaVehiculoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MARCA_VEHICULO_DESC")
    private String marcaVehiculoDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoIdmarca")
    private List<Vehiculo> vehiculoList;

    public MarcaVehiculo() {
    }

    public MarcaVehiculo(Short marcaVehiculoId) {
        this.marcaVehiculoId = marcaVehiculoId;
    }

    public MarcaVehiculo(Short marcaVehiculoId, String marcaVehiculoDesc) {
        this.marcaVehiculoId = marcaVehiculoId;
        this.marcaVehiculoDesc = marcaVehiculoDesc;
    }

    public Short getMarcaVehiculoId() {
        return marcaVehiculoId;
    }

    public void setMarcaVehiculoId(Short marcaVehiculoId) {
        this.marcaVehiculoId = marcaVehiculoId;
    }

    public String getMarcaVehiculoDesc() {
        return marcaVehiculoDesc;
    }

    public void setMarcaVehiculoDesc(String marcaVehiculoDesc) {
        this.marcaVehiculoDesc = marcaVehiculoDesc;
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
        hash += (marcaVehiculoId != null ? marcaVehiculoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaVehiculo)) {
            return false;
        }
        MarcaVehiculo other = (MarcaVehiculo) object;
        if ((this.marcaVehiculoId == null && other.marcaVehiculoId != null) || (this.marcaVehiculoId != null && !this.marcaVehiculoId.equals(other.marcaVehiculoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.MarcaVehiculo[ marcaVehiculoId=" + marcaVehiculoId + " ]";
    }
    
}
