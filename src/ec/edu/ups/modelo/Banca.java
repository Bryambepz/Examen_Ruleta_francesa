/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author braya
 */
@Entity
public class Banca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Saldo")
    private double saldo;
    @Column(name = "Bancarrota")
    private boolean bancarrota;
    @Column(name = "Comenzar_Apuesta")
    private boolean comenzar_Apuesta;

    public Banca() {
    }

    public Banca(double saldo, boolean bancarrota, boolean comenzar_Apuesta) {
        this.saldo = saldo;
        this.bancarrota = bancarrota;
        this.comenzar_Apuesta = comenzar_Apuesta;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isComenzar_Apuesta() {
        return comenzar_Apuesta;
    }

    public void setComenzar_Apuesta(boolean comenzar_Apuesta) {
        this.comenzar_Apuesta = comenzar_Apuesta;
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
        if (!(object instanceof Banca)) {
            return false;
        }
        Banca other = (Banca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.modelo.Banca[ id=" + id + " ]";
    }
    
}
