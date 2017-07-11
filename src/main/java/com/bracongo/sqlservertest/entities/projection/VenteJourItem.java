package com.bracongo.sqlservertest.entities.projection;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "venteJourItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenteJourItem implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private double quantite;
    
    private int jour;

    public VenteJourItem(double quantite, int jour) {
        this.quantite = quantite;
        this.jour = jour;
    }
    
    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    @Override
    public String toString() {
        return "VenteJourItem{" + "quantite=" + quantite + ", jour=" + jour + '}';
    }
    
    
    
}
