package com.bracongo.sqlservertest.entities.projection;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name = "ventesInfos")
@XmlAccessorType(XmlAccessType.FIELD)
public class VentesInfos implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Double remise;
    
    private Double chiffreAffaire;
    
    private Date dateFinRemise;
    
    private Date dateDebutRemise;
    
    private List<VenteItem> venteItemBiere;
    
    private List<VenteItem> venteItemBG;
    
    private List<VenteItem> venteItemPET;
    
    private List<VenteJourItem> venteJourItemBiere;
    
    private List<VenteJourItem> venteJourItemBG;
    
    private List<VenteJourItem> venteJourItemPET;

    public double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public List<VenteItem> getVenteItemBiere() {
        return venteItemBiere;
    }

    public void setVenteItemBiere(List<VenteItem> venteItemBiere) {
        this.venteItemBiere = venteItemBiere;
    }

    public List<VenteJourItem> getVenteJourItemBiere() {
        return venteJourItemBiere;
    }

    public void setVenteJourItemBiere(List<VenteJourItem> venteJourItems) {
        this.venteJourItemBiere = venteJourItems;
    }

    public Date getDateFinRemise() {
        return dateFinRemise;
    }

    public void setDateFinRemise(Date dateFinRemise) {
        this.dateFinRemise = dateFinRemise;
    }

    public Date getDateDebutRemise() {
        return dateDebutRemise;
    }

    public void setDateDebutRemise(Date dateDebutRemise) {
        this.dateDebutRemise = dateDebutRemise;
    }

    public Double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(Double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public List<VenteItem> getVenteItemBG() {
        return venteItemBG;
    }

    public void setVenteItemBG(List<VenteItem> venteItemBG) {
        this.venteItemBG = venteItemBG;
    }

    public List<VenteItem> getVenteItemPET() {
        return venteItemPET;
    }

    public void setVenteItemPET(List<VenteItem> venteItemPET) {
        this.venteItemPET = venteItemPET;
    }

 
    public List<VenteJourItem> getVenteJourItemBG() {
        return venteJourItemBG;
    }

    public void setVenteJourItemBG(List<VenteJourItem> venteJourItemBG) {
        this.venteJourItemBG = venteJourItemBG;
    }

    public List<VenteJourItem> getVenteJourItemPET() {
        return venteJourItemPET;
    }

    public void setVenteJourItemPET(List<VenteJourItem> venteJourItemPET) {
        this.venteJourItemPET = venteJourItemPET;
    }
    
    
    
}
