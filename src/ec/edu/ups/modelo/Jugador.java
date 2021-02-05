/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author braya
 */
@Entity
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Cedula")
    private String cedula;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Direccion")
    private String Direccion;
    @Column(name = "Saldo")
    private double saldo;
    @Column(name = "Bancarrota")
    private boolean bancarrota;
    @OneToOne
    @JoinColumn(name = "fk_Banca")
    private Banca banca;
    @OneToMany(mappedBy = "Jugador", cascade = CascadeType.ALL)
    private List<Apuestas> listaApuestas;
            
    public Jugador() {
    }

    public Jugador(String cedula, String nombre, String Direccion, double saldo, boolean bancarrota) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.Direccion = Direccion;
        this.saldo = saldo;
        this.bancarrota = bancarrota;
    }
    
//    public Jugador(String cedula, String nombre, String Direccion, double saldo, boolean bancarrota, Banca b) {
//        this.cedula = cedula;
//        this.nombre = nombre;
//        this.Direccion = Direccion;
//        this.saldo = saldo;
//        this.bancarrota = bancarrota;
//        this.banca = b;
//    }
//
    public Jugador(String cedula, String nombre, String Direccion, double saldo, boolean bancarrota, Banca banca, List<Apuestas> listaApuestas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.Direccion = Direccion;
        this.saldo = saldo;
        this.bancarrota = bancarrota;
        this.banca = banca;
        this.listaApuestas = listaApuestas;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isBancarrota() {
        return bancarrota;
    }

    public void setBancarrota(boolean bancarrota) {
        this.bancarrota = bancarrota;
    }

    public Banca getBanca() {
        return banca;
    }

    public void setBanca(Banca banca) {
        this.banca = banca;
    }

    public List<Apuestas> getListaApuestas() {
        return listaApuestas;
    }

    public void setListaApuestas(List<Apuestas> listaApuestas) {
        this.listaApuestas = listaApuestas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.modelo.Jugador[ id=" + id + " ]";
    }
    
}
