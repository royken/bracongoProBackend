package com.bracongo.sqlservertest.entities.projection;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "ventesItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenteItem implements Serializable{

    private static final long serialVersionUID = 1L;

    private double quantite;
    
    private int mois;
    
    private double chiffre;
    
    private String type;

    public VenteItem(double quantite, int mois, double chiffre, String type) {
        this.quantite = quantite;
        this.mois = mois;
        this.chiffre = chiffre;
        this.type = type;
    }
    
    

    public VenteItem(double quantite, int mois, double chiffre) {
        this.quantite = quantite;
        this.mois = mois;
        this.chiffre = chiffre;
    }

  
    

    public VenteItem(double quantite, int mois) {
        this.quantite = quantite;
        this.mois = mois;
    }
    
    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }
    
      public double getChiffre() {
        return chiffre;
    }

    public void setChiffre(double chiffre) {
        this.chiffre = chiffre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

    @Override
    public String toString() {
        return "VenteItem{" + "quantite=" + quantite + ", mois=" + mois + '}';
    }
    
}
