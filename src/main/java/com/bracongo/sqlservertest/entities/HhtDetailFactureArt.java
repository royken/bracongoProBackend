/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bracongo.sqlservertest.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Entity
@Table(name = "HHT_DETAIL_FACTURE_ART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhtDetailFactureArt.findAll", query = "SELECT h FROM HhtDetailFactureArt h")
    , @NamedQuery(name = "HhtDetailFactureArt.findByCodeFact", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.hhtDetailFactureArtPK.codeFact = :codeFact")
    , @NamedQuery(name = "HhtDetailFactureArt.findByCodeArt", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.hhtDetailFactureArtPK.codeArt = :codeArt")
    , @NamedQuery(name = "HhtDetailFactureArt.findByQte", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.qte = :qte")
    , @NamedQuery(name = "HhtDetailFactureArt.findByStock", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.stock = :stock")
    , @NamedQuery(name = "HhtDetailFactureArt.findByMontantTva", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.montantTva = :montantTva")
    , @NamedQuery(name = "HhtDetailFactureArt.findByMontantRemise", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.montantRemise = :montantRemise")
    , @NamedQuery(name = "HhtDetailFactureArt.findByMontantTaxe1", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.montantTaxe1 = :montantTaxe1")
    , @NamedQuery(name = "HhtDetailFactureArt.findByMontantTaxe2", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.montantTaxe2 = :montantTaxe2")
    , @NamedQuery(name = "HhtDetailFactureArt.findByMontantTaxePrelevement", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.montantTaxePrelevement = :montantTaxePrelevement")
    , @NamedQuery(name = "HhtDetailFactureArt.findByTotal", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.total = :total")
    , @NamedQuery(name = "HhtDetailFactureArt.findByQteCommande", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.qteCommande = :qteCommande")
    , @NamedQuery(name = "HhtDetailFactureArt.findByCodeTypeDocument", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.hhtDetailFactureArtPK.codeTypeDocument = :codeTypeDocument")
    , @NamedQuery(name = "HhtDetailFactureArt.findByPu", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.pu = :pu")
    , @NamedQuery(name = "HhtDetailFactureArt.findByNumPu", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.hhtDetailFactureArtPK.numPu = :numPu")
    , @NamedQuery(name = "HhtDetailFactureArt.findByQteCaisses", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.qteCaisses = :qteCaisses")
    , @NamedQuery(name = "HhtDetailFactureArt.findByCbBiglox", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.hhtDetailFactureArtPK.cbBiglox = :cbBiglox")
    , @NamedQuery(name = "HhtDetailFactureArt.findByNumero", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.hhtDetailFactureArtPK.numero = :numero")
    , @NamedQuery(name = "HhtDetailFactureArt.findByBl", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.bl = :bl")
    , @NamedQuery(name = "HhtDetailFactureArt.findByCodeDevise", query = "SELECT h FROM HhtDetailFactureArt h WHERE h.hhtDetailFactureArtPK.codeDevise = :codeDevise")})
public class HhtDetailFactureArt  extends BaseClass{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HhtDetailFactureArtPK hhtDetailFactureArtPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QTE")
    private Double qte;
    @Column(name = "STOCK")
    private Double stock;
    @Column(name = "MONTANT_TVA")
    private Double montantTva;
    @Column(name = "MONTANT_REMISE")
    private Double montantRemise;
    @Column(name = "MONTANT_TAXE1")
    private Double montantTaxe1;
    @Column(name = "MONTANT_TAXE2")
    private Double montantTaxe2;
    @Column(name = "MONTANT_TAXE_PRELEVEMENT")
    private Double montantTaxePrelevement;
    @Column(name = "TOTAL")
    private Double total;
    @Column(name = "QTE_COMMANDE")
    private Double qteCommande;
    @Column(name = "PU")
    private Double pu;
    @Column(name = "QTE_CAISSES")
    private Double qteCaisses;
    @Column(name = "BL")
    private String bl;
    @JoinColumn(name = "CODE_ART", referencedColumnName = "CODE_ART", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HhtArticle hhtArticle;

    public HhtDetailFactureArt() {
    }

    public HhtDetailFactureArt(HhtDetailFactureArtPK hhtDetailFactureArtPK) {
        this.hhtDetailFactureArtPK = hhtDetailFactureArtPK;
    }

    public HhtDetailFactureArt(String codeFact, String codeArt, String codeTypeDocument, int numPu, String cbBiglox, int numero, String codeDevise) {
        this.hhtDetailFactureArtPK = new HhtDetailFactureArtPK(codeFact, codeArt, codeTypeDocument, numPu, cbBiglox, numero, codeDevise);
    }

    public HhtDetailFactureArtPK getHhtDetailFactureArtPK() {
        return hhtDetailFactureArtPK;
    }

    public void setHhtDetailFactureArtPK(HhtDetailFactureArtPK hhtDetailFactureArtPK) {
        this.hhtDetailFactureArtPK = hhtDetailFactureArtPK;
    }

    public Double getQte() {
        return qte;
    }

    public void setQte(Double qte) {
        this.qte = qte;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Double getMontantTva() {
        return montantTva;
    }

    public void setMontantTva(Double montantTva) {
        this.montantTva = montantTva;
    }

    public Double getMontantRemise() {
        return montantRemise;
    }

    public void setMontantRemise(Double montantRemise) {
        this.montantRemise = montantRemise;
    }

    public Double getMontantTaxe1() {
        return montantTaxe1;
    }

    public void setMontantTaxe1(Double montantTaxe1) {
        this.montantTaxe1 = montantTaxe1;
    }

    public Double getMontantTaxe2() {
        return montantTaxe2;
    }

    public void setMontantTaxe2(Double montantTaxe2) {
        this.montantTaxe2 = montantTaxe2;
    }

    public Double getMontantTaxePrelevement() {
        return montantTaxePrelevement;
    }

    public void setMontantTaxePrelevement(Double montantTaxePrelevement) {
        this.montantTaxePrelevement = montantTaxePrelevement;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(Double qteCommande) {
        this.qteCommande = qteCommande;
    }

    public Double getPu() {
        return pu;
    }

    public void setPu(Double pu) {
        this.pu = pu;
    }

    public Double getQteCaisses() {
        return qteCaisses;
    }

    public void setQteCaisses(Double qteCaisses) {
        this.qteCaisses = qteCaisses;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public HhtArticle getHhtArticle() {
        return hhtArticle;
    }

    public void setHhtArticle(HhtArticle hhtArticle) {
        this.hhtArticle = hhtArticle;
    }

//    public HhtMotifsModifications getCodeMotif() {
//        return codeMotif;
//    }
//
//    public void setCodeMotif(HhtMotifsModifications codeMotif) {
//        this.codeMotif = codeMotif;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hhtDetailFactureArtPK != null ? hhtDetailFactureArtPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtDetailFactureArt)) {
            return false;
        }
        HhtDetailFactureArt other = (HhtDetailFactureArt) object;
        if ((this.hhtDetailFactureArtPK == null && other.hhtDetailFactureArtPK != null) || (this.hhtDetailFactureArtPK != null && !this.hhtDetailFactureArtPK.equals(other.hhtDetailFactureArtPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtDetailFactureArt[ hhtDetailFactureArtPK=" + hhtDetailFactureArtPK + " ]";
    }
    
}
