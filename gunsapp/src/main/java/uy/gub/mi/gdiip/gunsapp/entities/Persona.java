/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.gub.mi.gdiip.gunsapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gustavo
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPersonaId", query = "SELECT p FROM Persona p WHERE p.personaId = :personaId"),
    @NamedQuery(name = "Persona.findByPersonaNombre1", query = "SELECT p FROM Persona p WHERE p.personaNombre1 = :personaNombre1"),
    @NamedQuery(name = "Persona.findByPersonaNombre2", query = "SELECT p FROM Persona p WHERE p.personaNombre2 = :personaNombre2"),
    @NamedQuery(name = "Persona.findByPersonaApellido1", query = "SELECT p FROM Persona p WHERE p.personaApellido1 = :personaApellido1"),
    @NamedQuery(name = "Persona.findByPersonaApellido2", query = "SELECT p FROM Persona p WHERE p.personaApellido2 = :personaApellido2"),
    @NamedQuery(name = "Persona.findByPersonaAlias", query = "SELECT p FROM Persona p WHERE p.personaAlias = :personaAlias"),
    @NamedQuery(name = "Persona.findByPersonaSexo", query = "SELECT p FROM Persona p WHERE p.personaSexo = :personaSexo"),
    @NamedQuery(name = "Persona.findByPersonaFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.personaFechaNacimiento = :personaFechaNacimiento"),
    @NamedQuery(name = "Persona.findByPersonaFoto", query = "SELECT p FROM Persona p WHERE p.personaFoto = :personaFoto"),
    @NamedQuery(name = "Persona.findByPersonaRsocial", query = "SELECT p FROM Persona p WHERE p.personaRsocial = :personaRsocial"),
    @NamedQuery(name = "Persona.findByPersonaCalle", query = "SELECT p FROM Persona p WHERE p.personaCalle = :personaCalle"),
    @NamedQuery(name = "Persona.findByPersonaNpuerta", query = "SELECT p FROM Persona p WHERE p.personaNpuerta = :personaNpuerta"),
    @NamedQuery(name = "Persona.findByPersonaBarrio", query = "SELECT p FROM Persona p WHERE p.personaBarrio = :personaBarrio"),
    @NamedQuery(name = "Persona.findByPersonaCiudad", query = "SELECT p FROM Persona p WHERE p.personaCiudad = :personaCiudad"),
    @NamedQuery(name = "Persona.findByPersonaFechaRegistro", query = "SELECT p FROM Persona p WHERE p.personaFechaRegistro = :personaFechaRegistro"),
    @NamedQuery(name = "Persona.findByPersonaFechaModificacion", query = "SELECT p FROM Persona p WHERE p.personaFechaModificacion = :personaFechaModificacion")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERSONA_ID")
    private Integer personaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PERSONA_NOMBRE1")
    private String personaNombre1;
    @Size(max = 45)
    @Column(name = "PERSONA_NOMBRE2")
    private String personaNombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PERSONA_APELLIDO1")
    private String personaApellido1;
    @Size(max = 45)
    @Column(name = "PERSONA_APELLIDO2")
    private String personaApellido2;
    @Size(max = 45)
    @Column(name = "PERSONA_ALIAS")
    private String personaAlias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA_SEXO")
    private Character personaSexo;
    @Column(name = "PERSONA_FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date personaFechaNacimiento;
    @Size(max = 200)
    @Column(name = "PERSONA_FOTO")
    private String personaFoto;
    @Size(max = 75)
    @Column(name = "PERSONA_RSOCIAL")
    private String personaRsocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PERSONA_CALLE")
    private String personaCalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PERSONA_NPUERTA")
    private String personaNpuerta;
    @Size(max = 100)
    @Column(name = "PERSONA_BARRIO")
    private String personaBarrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "PERSONA_CIUDAD")
    private String personaCiudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date personaFechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA_FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date personaFechaModificacion;
    @JoinColumn(name = "PERSONA_IDGSOCIAL", referencedColumnName = "GRUPO_SOCIAL_ID")
    @ManyToOne
    private GrupoSocial personaIdgsocial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armaPersonaId")
    private List<Arma> armaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoPersonaId")
    private List<Documento> documentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaPersonaId")
    private List<NacionalidadPersona> nacionalidadPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoIdpersona")
    private List<Vehiculo> vehiculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaPersonaId")
    private List<OperacionPersona> operacionPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaPersonaId")
    private List<DatosWeb> datosWebList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaPersonaId")
    private List<Telefono> telefonoList;

    public Persona() {
    }

    public Persona(Integer personaId) {
        this.personaId = personaId;
    }

    public Persona(Integer personaId, String personaNombre1, String personaApellido1, Character personaSexo, String personaCalle, String personaNpuerta, String personaCiudad, Date personaFechaRegistro, Date personaFechaModificacion) {
        this.personaId = personaId;
        this.personaNombre1 = personaNombre1;
        this.personaApellido1 = personaApellido1;
        this.personaSexo = personaSexo;
        this.personaCalle = personaCalle;
        this.personaNpuerta = personaNpuerta;
        this.personaCiudad = personaCiudad;
        this.personaFechaRegistro = personaFechaRegistro;
        this.personaFechaModificacion = personaFechaModificacion;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getPersonaNombre1() {
        return personaNombre1;
    }

    public void setPersonaNombre1(String personaNombre1) {
        this.personaNombre1 = personaNombre1;
    }

    public String getPersonaNombre2() {
        return personaNombre2;
    }

    public void setPersonaNombre2(String personaNombre2) {
        this.personaNombre2 = personaNombre2;
    }

    public String getPersonaApellido1() {
        return personaApellido1;
    }

    public void setPersonaApellido1(String personaApellido1) {
        this.personaApellido1 = personaApellido1;
    }

    public String getPersonaApellido2() {
        return personaApellido2;
    }

    public void setPersonaApellido2(String personaApellido2) {
        this.personaApellido2 = personaApellido2;
    }

    public String getPersonaAlias() {
        return personaAlias;
    }

    public void setPersonaAlias(String personaAlias) {
        this.personaAlias = personaAlias;
    }

    public Character getPersonaSexo() {
        return personaSexo;
    }

    public void setPersonaSexo(Character personaSexo) {
        this.personaSexo = personaSexo;
    }

    public Date getPersonaFechaNacimiento() {
        return personaFechaNacimiento;
    }

    public void setPersonaFechaNacimiento(Date personaFechaNacimiento) {
        this.personaFechaNacimiento = personaFechaNacimiento;
    }

    public String getPersonaFoto() {
        return personaFoto;
    }

    public void setPersonaFoto(String personaFoto) {
        this.personaFoto = personaFoto;
    }

    public String getPersonaRsocial() {
        return personaRsocial;
    }

    public void setPersonaRsocial(String personaRsocial) {
        this.personaRsocial = personaRsocial;
    }

    public String getPersonaCalle() {
        return personaCalle;
    }

    public void setPersonaCalle(String personaCalle) {
        this.personaCalle = personaCalle;
    }

    public String getPersonaNpuerta() {
        return personaNpuerta;
    }

    public void setPersonaNpuerta(String personaNpuerta) {
        this.personaNpuerta = personaNpuerta;
    }

    public String getPersonaBarrio() {
        return personaBarrio;
    }

    public void setPersonaBarrio(String personaBarrio) {
        this.personaBarrio = personaBarrio;
    }

    public String getPersonaCiudad() {
        return personaCiudad;
    }

    public void setPersonaCiudad(String personaCiudad) {
        this.personaCiudad = personaCiudad;
    }

    public Date getPersonaFechaRegistro() {
        return personaFechaRegistro;
    }

    public void setPersonaFechaRegistro(Date personaFechaRegistro) {
        this.personaFechaRegistro = personaFechaRegistro;
    }

    public Date getPersonaFechaModificacion() {
        return personaFechaModificacion;
    }

    public void setPersonaFechaModificacion(Date personaFechaModificacion) {
        this.personaFechaModificacion = personaFechaModificacion;
    }

    public GrupoSocial getPersonaIdgsocial() {
        return personaIdgsocial;
    }

    public void setPersonaIdgsocial(GrupoSocial personaIdgsocial) {
        this.personaIdgsocial = personaIdgsocial;
    }

    @XmlTransient
    public List<Arma> getArmaList() {
        return armaList;
    }

    public void setArmaList(List<Arma> armaList) {
        this.armaList = armaList;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @XmlTransient
    public List<NacionalidadPersona> getNacionalidadPersonaList() {
        return nacionalidadPersonaList;
    }

    public void setNacionalidadPersonaList(List<NacionalidadPersona> nacionalidadPersonaList) {
        this.nacionalidadPersonaList = nacionalidadPersonaList;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<OperacionPersona> getOperacionPersonaList() {
        return operacionPersonaList;
    }

    public void setOperacionPersonaList(List<OperacionPersona> operacionPersonaList) {
        this.operacionPersonaList = operacionPersonaList;
    }

    @XmlTransient
    public List<DatosWeb> getDatosWebList() {
        return datosWebList;
    }

    public void setDatosWebList(List<DatosWeb> datosWebList) {
        this.datosWebList = datosWebList;
    }

    @XmlTransient
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.gub.mi.gdiip.gunsapp.entities.Persona[ personaId=" + personaId + " ]";
    }
    
}
