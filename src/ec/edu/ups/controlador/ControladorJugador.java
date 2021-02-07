/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Jugador;
import ec.edu.ups.vista.VntRuleta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author braya
 */
public class ControladorJugador extends ControladorAbstract<Jugador>{
    private DefaultTableModel modelo2;
    private JTable tablaJugadores;
    private int nS;
    private List<Jugador> listaJ;
    private JTextField NumS;
    private JTextArea NumA;
    private VntRuleta vntR;

    public ControladorJugador() {
        super();
        modelo2 = new DefaultTableModel();
    }

    public ControladorJugador(JTable tablaJugadores, List<Jugador> listaJ, JTextField NumS, JTextArea NumA,VntRuleta vntR) {
        super();
        modelo2 = new DefaultTableModel();
        this.tablaJugadores = tablaJugadores;
        this.nS = nS;
        this.listaJ = listaJ;
        this.NumS = NumS;
        this.NumA = NumA;
        this.vntR = vntR;
        this.jugar(listaJ, NumS, NumA);
        this.llenarTbl(listaJ);
        //this.jugar(nS, listaJ, NumS);
    }

    public ControladorJugador( JTable tablaJugadores) {
        super();
        modelo2 = new DefaultTableModel();
        this.tablaJugadores = tablaJugadores;
    }
    
//    @Override
//    public void run() {
////        while (true) {            
//            llenarTbl(listaJ);
//            //vntRuleta.llenarTabla(findAll());
////        }
//    }

    public synchronized void jugar(List<Jugador> listaJ, JTextField txtNum, JTextArea NumA) {
        int numSeleccionadp = (int) (Math.random() * 36);
        System.out.println("numS------------- " + numSeleccionadp);
        txtNum.setText(String.valueOf(numSeleccionadp));
        
        for (int i = 0; i < listaJ.size(); i++) {
            try {
                Jugador jugadorP = listaJ.get(i);
                NumA.append("Numero Ruleta " + numSeleccionadp + " ||  Numero J " + jugadorP.getNumApost() +"\n");
                //System.out.println("Numero Ruleta " + numSeleccionadp + " ||  Numero J " + jugadorP.getNumApost() +"\n");
                if (!jugadorP.isBancarrota()) {
                    //System.out.println("tlba " + (tablaJugadores.getSelectedRow()));
                    if (jugadorP.getTipoJuego().equalsIgnoreCase("Par")) {
                        if (pOim(numSeleccionadp)) {
                            jugadorP.setSaldo(jugadorP.getSaldo() + 10);
                            System.out.println("= " + jugadorP.getSaldo());
//                            update(jugadorP);
//                            llenarTbl(listaJ);
                        } else {
                            jugadorP.setSaldo(jugadorP.getSaldo() - 10);
                            System.out.println("= " + jugadorP.getSaldo());
//                            update(jugadorP);
//                            llenarTbl(listaJ);
                        }
                        System.out.println("par = " + jugadorP.getNombre());
                    } else if (jugadorP.getTipoJuego().equalsIgnoreCase("Impar")) {
                        if (!pOim(numSeleccionadp)) {
                            jugadorP.setSaldo(jugadorP.getSaldo() + 10);
                            System.out.println("= " + jugadorP.getSaldo());
//                            update(jugadorP);
//                            llenarTbl(listaJ);
                        } else {
                            jugadorP.setSaldo(jugadorP.getSaldo() - 10);
                            System.out.println("= " + jugadorP.getSaldo());
//                            update(jugadorP);
//                            llenarTbl(listaJ);
                        }
                        System.out.println("impar= " + jugadorP.getNombre());
                    } else if (jugadorP.getTipoJuego().equalsIgnoreCase("Numero")) {
                        if (jugadorP.getNumApost() == numSeleccionadp) {
                            jugadorP.setSaldo(jugadorP.getSaldo() + 360);
                            System.out.println("= " + jugadorP.getSaldo());
//                            update(jugadorP);
//                            llenarTbl(listaJ);
                        } else {
                            jugadorP.setSaldo(jugadorP.getSaldo() - 10);
                            System.out.println("= " + jugadorP.getSaldo());
//                            update(jugadorP);
//                            llenarTbl(listaJ);
                        }
                        System.out.println("Numero= " + jugadorP.getNombre());
                    } else if (jugadorP.getTipoJuego().equalsIgnoreCase("Martingala")) {
                        if (jugadorP.getNumApost() == numSeleccionadp) {
                            jugadorP.setSaldo(jugadorP.getSaldo() + 10);
                            System.out.println("= " + jugadorP.getSaldo());
//                            update(jugadorP);
//                            llenarTbl(listaJ);
                        } else {
                            jugadorP.setSaldo(jugadorP.getSaldo() - 10);
                            System.out.println("= " + jugadorP.getSaldo());
//                            update(jugadorP);
//                            llenarTbl(listaJ);
                        }
                        System.out.println("martingala= " + jugadorP.getNombre());
                    }
//                    llenarTbl(listaJ);
                }
                //update(jugadorP);
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControladorJugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //vntR.llenarTabla(listaJ);
        llenarTbl(listaJ);
    }

    public boolean pOim(int num) {
        int v = num % 2;
        return v == 0;
    }

    public void llenarTbl(List<Jugador> jugadores) {
        modelo2 = (DefaultTableModel) tablaJugadores.getModel();
        modelo2.setRowCount(0);
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador ju = jugadores.get(i);
            Object[] pl = {ju.getCedula(), ju.getNombre(), ju.getSaldo(), ju.getNumApost(), ju.isBancarrota()};
            modelo2.addRow(pl);
        }
        tablaJugadores.setModel(modelo2);
    }

    public DefaultTableModel getModelo2() {
        return modelo2;
    }

    public void setModelo2(DefaultTableModel modelo2) {
        this.modelo2 = modelo2;
    }

    public JTable getTablaJugadores() {
        return tablaJugadores;
    }

    public void setTablaJugadores(JTable tablaJugadores) {
        this.tablaJugadores = tablaJugadores;
    }

    public int getnS() {
        return nS;
    }

    public void setnS(int nS) {
        this.nS = nS;
    }

    public List<Jugador> getListaJ() {
        return listaJ;
    }

    public void setListaJ(List<Jugador> listaJ) {
        this.listaJ = listaJ;
    }

    public JTextField getNumS() {
        return NumS;
    }

    public void setNumS(JTextField NumS) {
        this.NumS = NumS;
    }

    public JTextArea getNumA() {
        return NumA;
    }

    public void setNumA(JTextArea NumA) {
        this.NumA = NumA;
    }

    public VntRuleta getVntR() {
        return vntR;
    }

    public void setVntR(VntRuleta vntR) {
        this.vntR = vntR;
    }
    
}
