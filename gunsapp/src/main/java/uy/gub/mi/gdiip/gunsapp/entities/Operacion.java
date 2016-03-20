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
@Table(name = "operacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o"),
    @NamedQuery(name = "Operacion.findByOperacionId", query = "SELECT o FROM Operacion o WHERE o.operacionId = :operacionId"),
    @NamedQuery(name = "Operacion.findByOperacionNombre", query = "SELECT o FROM Operacion o WHERE o.operacionNombre = :operacionNombre"),
    @NamedQuery(name = "Operacion.findByOperacionOrigen", query = "SELECT o FROM Operacion o WHERE o.operacionOrigen = :operacionOrigen"),
    @NamedQuery(name = "Operacion.findByOperacionMotivo", query = "SELECT o FROM Operacion o WHERE o.operacionMotivo = :operacionMotivo"),
    @NamedQuery(name = "Operacion.findByOperacionMemo", query = "SELECT o FROM Operacion o WHERE o.operacionMemo = :operacionMemo"),
    @NamedQuery(name = "Operacion.findByOperacionNroexp", query = "SELECT o FROM Operacion o WHERE o.operacionNroexp = :operacionNroexp")})
public class Operacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OPERACION_ID")
    private Integer operacionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "OPERACION_NOMBRE")
    private String operacionNombre;
    @Size(max = 150)
    @Column(name = "OPERACION_ORIGEN")
    private String operacionOrigen;
    @Size(max = 75)
    @Column(name = "OPERACION_MOTIVO")
    private String operacionMotivo;
    @Size(max = 200)
    @Column(name = "OPERACION_MEMO")
    private String operacionMemo;
    @Size(max = 45)
    @Column(name = "OPERACION_NROEXP")
    private String operacionNroexp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oficioIdoperacion")
    private List<Oficio> oficioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operacionOperacionId")
    private List<OperacionPersona> operacionPersonaList;

    public Operacion() {
    }

    public Operacion(Integer operacionId) {
        this.operacionId = operacionId;
    }

    public Operacion(Integer operacionId, String operacionNombre) {
        this.operacionId = operacionId;
        this.operacionNombre = operacionNombre;
    }

    public Integer getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(Integer operacionId) {
        this.operacionId = operacionId;
    }

    public String getOperacionNombre() {
        return operacionNombre;
    }

    public void setOperacionNombre(String operacionNombre) {
        this.operacionNombre = operacionNombre;
    }

    public String getOperacionOrigen() {
        return operacionOrigen;
    }

    public void setOperacionOrigen(String operacionOrigen) {
        this.operacionOrigen = operacionOrigen;
    }

    public String getOperacionMotivo() {
        return operacionMotivo;
    }

    public void setOperacionMotivo(String operacionMotivo) {
        this.operacionMotivo = operacionMotivo;
    }

    public String getOperacionMemo() {
        return operacionMemo;
    }

    public void setOperacionMemo(String operacionMemo) {
        this.operacionMemo = operacionMemo;
    }

    public String getOperacionNroexp() {
        return operacionNroexp;
    }

    public void setOperacionNroexp(String operacionNroexp) {
        this.operacionNroexp = operacionNroexp;
    }

    @XmlTransient
    public List<Oficio> getOficioList() {
        return oficioList;
    }

    public void setOficioList(List<Oficio> oficioList) {
        this.oficioList = oficioList;
    }

    @XmlTransient
    public List<OperacionPersona> getOperacionPersonaList() {
        return operacionPersonaList;
    }

    public void setOperacionPersonaList(List<OperacionPersona> operacionPersonaList) {
        this.operacionPersonaList = operacionPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operacionId != null ? operacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacion)) {
            return false;
        }
        Operacion other = (Operacion) object;
        if ((this.operacionId == null && other.operacionId != null) || (this.operacionId != null && !this.operacionId.equals(other.operacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.Operacion[ operacionId=" + operacionId + " ]";
    }
    
}
