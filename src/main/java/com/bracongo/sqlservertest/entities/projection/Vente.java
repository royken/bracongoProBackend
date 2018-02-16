package com.bracongo.sqlservertest.entities.projection;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vr.kenfack
 */

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "vente")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int date;
    
    private Double quantiteBiere;
    
    private Double quantiteBg;
    
    private Double quantitePet;
    
    private Double chiffreBierre;
    
    private Double chiffreBg;
    
    private Double chiffrePet;

    public Vente() {
    }
    
    

    public Vente(int date, Double quantiteBiere, Double quantiteBg, Double quantitePet, Double chiffreBierre, Double chiffreBg, Double chiffrePet) {
        this.date = date;
        this.quantiteBiere = quantiteBiere;
        this.quantiteBg = quantiteBg;
        this.quantitePet = quantitePet;
        this.chiffreBierre = chiffreBierre;
        this.chiffreBg = chiffreBg;
        this.chiffrePet = chiffrePet;
    }
    
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Double getQuantiteBiere() {
        return quantiteBiere;
    }

    public void setQuantiteBiere(Double quantiteBiere) {
        this.quantiteBiere = quantiteBiere;
    }

    public Double getQuantiteBg() {
        return quantiteBg;
    }

    public void setQuantiteBg(Double quantiteBg) {
        this.quantiteBg = quantiteBg;
    }

    public Double getQuantitePet() {
        return quantitePet;
    }

    public void setQuantitePet(Double quantitePet) {
        this.quantitePet = quantitePet;
    }

    public Double getChiffreBierre() {
        return chiffreBierre;
    }

    public void setChiffreBierre(Double chiffreBierre) {
        this.chiffreBierre = chiffreBierre;
    }

    public Double getChiffreBg() {
        return chiffreBg;
    }

    public void setChiffreBg(Double chiffreBg) {
        this.chiffreBg = chiffreBg;
    }

    public Double getChiffrePet() {
        return chiffrePet;
    }

    public void setChiffrePet(Double chiffrePet) {
        this.chiffrePet = chiffrePet;
    }
    
    
    
}
