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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByVehiculoId", query = "SELECT v FROM Vehiculo v WHERE v.vehiculoId = :vehiculoId"),
    @NamedQuery(name = "Vehiculo.findByVehiculoMatricula", query = "SELECT v FROM Vehiculo v WHERE v.vehiculoMatricula = :vehiculoMatricula"),
    @NamedQuery(name = "Vehiculo.findByVehiculoNromotor", query = "SELECT v FROM Vehiculo v WHERE v.vehiculoNromotor = :vehiculoNromotor")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VEHICULO_ID")
    private Integer vehiculoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "VEHICULO_MATRICULA")
    private String vehiculoMatricula;
    @Size(max = 45)
    @Column(name = "VEHICULO_NROMOTOR")
    private String vehiculoNromotor;
    @JoinColumn(name = "VEHICULO_IDMARCA", referencedColumnName = "MARCA_VEHICULO_ID")
    @ManyToOne(optional = false)
    private MarcaVehiculo vehiculoIdmarca;
    @JoinColumn(name = "VEHICULO_IDTVEHICULO", referencedColumnName = "TIPO_VEHICULO_ID")
    @ManyToOne(optional = false)
    private TipoVehiculo vehiculoIdtvehiculo;
    @JoinColumn(name = "VEHICULO_IDPERSONA", referencedColumnName = "PERSONA_ID")
    @ManyToOne(optional = false)
    private Persona vehiculoIdpersona;

    public Vehiculo() {
    }

    public Vehiculo(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public Vehiculo(Integer vehiculoId, String vehiculoMatricula) {
        this.vehiculoId = vehiculoId;
        this.vehiculoMatricula = vehiculoMatricula;
    }

    public Integer getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getVehiculoMatricula() {
        return vehiculoMatricula;
    }

    public void setVehiculoMatricula(String vehiculoMatricula) {
        this.vehiculoMatricula = vehiculoMatricula;
    }

    public String getVehiculoNromotor() {
        return vehiculoNromotor;
    }

    public void setVehiculoNromotor(String vehiculoNromotor) {
        this.vehiculoNromotor = vehiculoNromotor;
    }

    public MarcaVehiculo getVehiculoIdmarca() {
        return vehiculoIdmarca;
    }

    public void setVehiculoIdmarca(MarcaVehiculo vehiculoIdmarca) {
        this.vehiculoIdmarca = vehiculoIdmarca;
    }

    public TipoVehiculo getVehiculoIdtvehiculo() {
        return vehiculoIdtvehiculo;
    }

    public void setVehiculoIdtvehiculo(TipoVehiculo vehiculoIdtvehiculo) {
        this.vehiculoIdtvehiculo = vehiculoIdtvehiculo;
    }

    public Persona getVehiculoIdpersona() {
        return vehiculoIdpersona;
    }

    public void setVehiculoIdpersona(Persona vehiculoIdpersona) {
        this.vehiculoIdpersona = vehiculoIdpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehiculoId != null ? vehiculoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.vehiculoId == null && other.vehiculoId != null) || (this.vehiculoId != null && !this.vehiculoId.equals(other.vehiculoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.Vehiculo[ vehiculoId=" + vehiculoId + " ]";
    }
    
}
