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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author braya
 */
@Entity
public class Apuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Dinero_Apostado")
    private double dinero_Apostado;
    @Column(name = "Tipo_Juego")
    private String tipo_Juego;
    
    public Apuestas() {
    }

    public Apuestas(double dinero_Apostado, String tipo_Juego) {
        this.dinero_Apostado = dinero_Apostado;
        this.tipo_Juego = tipo_Juego;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDinero_Apostado() {
        return dinero_Apostado;
    }

    public void setDinero_Apostado(double dinero_Apostado) {
        this.dinero_Apostado = dinero_Apostado;
    }

    public String getTipo_Juego() {
        return tipo_Juego;
    }

    public void setTipo_Juego(String tipo_Juego) {
        this.tipo_Juego = tipo_Juego;
    }

//    public Jugador getJugador() {
//        return jugador;
//    }
//
//    public void setJugador(Jugador jugador) {
//        this.jugador = jugador;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apuestas)) {
            return false;
        }
        Apuestas other = (Apuestas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.modelo.Apuestas[ id=" + id + " ]";
    }
    
}
