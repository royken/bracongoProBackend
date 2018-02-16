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
@XmlRootElement(name = "ventesResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class VentesResult implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Double remise;
    
    private Double remisePasse;
    
    private Double chiffreAffaire;
    
    private Date dateFinRemise;
    
    private Date dateDebutRemise;
    
    private List<Vente> ventesMois;
    
    private List<Vente> ventesJours;

    public Double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public Double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(Double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
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

    public List<Vente> getVentesMois() {
        return ventesMois;
    }

    public void setVentesMois(List<Vente> ventesMois) {
        this.ventesMois = ventesMois;
    }

    public List<Vente> getVentesJours() {
        return ventesJours;
    }

    public void setVentesJours(List<Vente> ventesJours) {
        this.ventesJours = ventesJours;
    }

    public Double getRemisePasse() {
        return remisePasse;
    }

    public void setRemisePasse(Double remisePasse) {
        this.remisePasse = remisePasse;
    }
    
    
    
}
