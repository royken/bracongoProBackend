/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bracongo.sqlservertest.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vr.kenfack
 */
@Entity
@Table(name = "HHT_ARTICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhtArticle.findAll", query = "SELECT h FROM HhtArticle h")
    , @NamedQuery(name = "HhtArticle.findByCodeArt", query = "SELECT h FROM HhtArticle h WHERE h.codeArt = :codeArt")
    , @NamedQuery(name = "HhtArticle.findByLibelle", query = "SELECT h FROM HhtArticle h WHERE h.libelle = :libelle")
    , @NamedQuery(name = "HhtArticle.findByRemiseUnitaire", query = "SELECT h FROM HhtArticle h WHERE h.remiseUnitaire = :remiseUnitaire")
    , @NamedQuery(name = "HhtArticle.findBySeuilRemise", query = "SELECT h FROM HhtArticle h WHERE h.seuilRemise = :seuilRemise")
    , @NamedQuery(name = "HhtArticle.findByRistourneUnitaire", query = "SELECT h FROM HhtArticle h WHERE h.ristourneUnitaire = :ristourneUnitaire")
    , @NamedQuery(name = "HhtArticle.findByCodeBarre", query = "SELECT h FROM HhtArticle h WHERE h.codeBarre = :codeBarre")
    , @NamedQuery(name = "HhtArticle.findByTaxe1", query = "SELECT h FROM HhtArticle h WHERE h.taxe1 = :taxe1")
    , @NamedQuery(name = "HhtArticle.findByTaxe2", query = "SELECT h FROM HhtArticle h WHERE h.taxe2 = :taxe2")
    , @NamedQuery(name = "HhtArticle.findByNonActif", query = "SELECT h FROM HhtArticle h WHERE h.nonActif = :nonActif")
    , @NamedQuery(name = "HhtArticle.findByRupture", query = "SELECT h FROM HhtArticle h WHERE h.rupture = :rupture")
    , @NamedQuery(name = "HhtArticle.findByAccPrixManuel", query = "SELECT h FROM HhtArticle h WHERE h.accPrixManuel = :accPrixManuel")
    , @NamedQuery(name = "HhtArticle.findByPoids", query = "SELECT h FROM HhtArticle h WHERE h.poids = :poids")
    , @NamedQuery(name = "HhtArticle.findByConditionnement", query = "SELECT h FROM HhtArticle h WHERE h.conditionnement = :conditionnement")
    , @NamedQuery(name = "HhtArticle.findByAccReprise", query = "SELECT h FROM HhtArticle h WHERE h.accReprise = :accReprise")
    , @NamedQuery(name = "HhtArticle.findByCodeSi", query = "SELECT h FROM HhtArticle h WHERE h.codeSi = :codeSi")
    , @NamedQuery(name = "HhtArticle.findByQteEnStock", query = "SELECT h FROM HhtArticle h WHERE h.qteEnStock = :qteEnStock")
    , @NamedQuery(name = "HhtArticle.findByCodeDecompositionArticle", query = "SELECT h FROM HhtArticle h WHERE h.codeDecompositionArticle = :codeDecompositionArticle")
    , @NamedQuery(name = "HhtArticle.findByQteDecompositionArticle", query = "SELECT h FROM HhtArticle h WHERE h.qteDecompositionArticle = :qteDecompositionArticle")
    , @NamedQuery(name = "HhtArticle.findByCodeDecompositionEmballage", query = "SELECT h FROM HhtArticle h WHERE h.codeDecompositionEmballage = :codeDecompositionEmballage")
    , @NamedQuery(name = "HhtArticle.findByQteDecompositionEmballage", query = "SELECT h FROM HhtArticle h WHERE h.qteDecompositionEmballage = :qteDecompositionEmballage")
    , @NamedQuery(name = "HhtArticle.findByCodeCompositionArticle", query = "SELECT h FROM HhtArticle h WHERE h.codeCompositionArticle = :codeCompositionArticle")
    , @NamedQuery(name = "HhtArticle.findByQteCompositionArticle", query = "SELECT h FROM HhtArticle h WHERE h.qteCompositionArticle = :qteCompositionArticle")
    , @NamedQuery(name = "HhtArticle.findByTypeContenant", query = "SELECT h FROM HhtArticle h WHERE h.typeContenant = :typeContenant")})
public class HhtArticle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODE_ART")
    private String codeArt;
    @Size(max = 100)
    @Column(name = "LIBELLE")
    private String libelle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "REMISE_UNITAIRE")
    private Double remiseUnitaire;
    @Column(name = "SEUIL_REMISE")
    private Double seuilRemise;
    @Column(name = "RISTOURNE_UNITAIRE")
    private Double ristourneUnitaire;
    @Size(max = 50)
    @Column(name = "CODE_BARRE")
    private String codeBarre;
    @Column(name = "TAXE1")
    private Double taxe1;
    @Column(name = "TAXE2")
    private Double taxe2;
    @Column(name = "NON_ACTIF")
    private Boolean nonActif;
    @Column(name = "RUPTURE")
    private Boolean rupture;
    @Column(name = "ACC_PRIX_MANUEL")
    private Boolean accPrixManuel;
    @Column(name = "POIDS")
    private Double poids;
    @Column(name = "CONDITIONNEMENT")
    private Integer conditionnement;
    @Column(name = "ACC_REPRISE")
    private Boolean accReprise;
    @Size(max = 20)
    @Column(name = "CODE_SI")
    private String codeSi;
    @Column(name = "QTE_EN_STOCK")
    private Integer qteEnStock;
    @Size(max = 20)
    @Column(name = "CODE_DECOMPOSITION_ARTICLE")
    private String codeDecompositionArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTE_DECOMPOSITION_ARTICLE")
    private double qteDecompositionArticle;
    @Size(max = 20)
    @Column(name = "CODE_DECOMPOSITION_EMBALLAGE")
    private String codeDecompositionEmballage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTE_DECOMPOSITION_EMBALLAGE")
    private double qteDecompositionEmballage;
    @Size(max = 20)
    @Column(name = "CODE_COMPOSITION_ARTICLE")
    private String codeCompositionArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTE_COMPOSITION_ARTICLE")
    private double qteCompositionArticle;
    @Size(max = 20)
    @Column(name = "TYPE_CONTENANT")
    private String typeContenant;
    @JoinColumn(name = "CODE_DEVISE", referencedColumnName = "CODE_DEVISE")
    @ManyToOne
    private HhtDevise codeDevise;
    @JoinColumn(name = "CODE_EMBALLAGE", referencedColumnName = "CODE_EMBALLAGE")
    @ManyToOne
    private HhtEmballage codeEmballage;
    @JoinColumn(name = "CODE_PARFUM", referencedColumnName = "CODE_PARFUM")
    @ManyToOne
    private HhtParfums codeParfum;
    @JoinColumn(name = "CODE_SOUS_FAMILLE", referencedColumnName = "CODE_SOUS_FAMILLE")
    @ManyToOne
    private HhtSousFamille codeSousFamille;
    @JoinColumn(name = "CODE_TAILLE", referencedColumnName = "CODE_TAILLE")
    @ManyToOne
    private HhtTailles codeTaille;
    @JoinColumn(name = "CODE_TVA", referencedColumnName = "CODE_TVA")
    @ManyToOne
    private HhtTva codeTva;
    @JoinColumn(name = "NUMERO_SOCIETE", referencedColumnName = "ID")
    @ManyToOne
    private NumeroSociete numeroSociete;

    public HhtArticle() {
    }

    public HhtArticle(String codeArt) {
        this.codeArt = codeArt;
    }

    public HhtArticle(String codeArt, double qteDecompositionArticle, double qteDecompositionEmballage, double qteCompositionArticle) {
        this.codeArt = codeArt;
        this.qteDecompositionArticle = qteDecompositionArticle;
        this.qteDecompositionEmballage = qteDecompositionEmballage;
        this.qteCompositionArticle = qteCompositionArticle;
    }

    public String getCodeArt() {
        return codeArt;
    }

    public void setCodeArt(String codeArt) {
        this.codeArt = codeArt;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getRemiseUnitaire() {
        return remiseUnitaire;
    }

    public void setRemiseUnitaire(Double remiseUnitaire) {
        this.remiseUnitaire = remiseUnitaire;
    }

    public Double getSeuilRemise() {
        return seuilRemise;
    }

    public void setSeuilRemise(Double seuilRemise) {
        this.seuilRemise = seuilRemise;
    }

    public Double getRistourneUnitaire() {
        return ristourneUnitaire;
    }

    public void setRistourneUnitaire(Double ristourneUnitaire) {
        this.ristourneUnitaire = ristourneUnitaire;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Double getTaxe1() {
        return taxe1;
    }

    public void setTaxe1(Double taxe1) {
        this.taxe1 = taxe1;
    }

    public Double getTaxe2() {
        return taxe2;
    }

    public void setTaxe2(Double taxe2) {
        this.taxe2 = taxe2;
    }

    public Boolean getNonActif() {
        return nonActif;
    }

    public void setNonActif(Boolean nonActif) {
        this.nonActif = nonActif;
    }

    public Boolean getRupture() {
        return rupture;
    }

    public void setRupture(Boolean rupture) {
        this.rupture = rupture;
    }

    public Boolean getAccPrixManuel() {
        return accPrixManuel;
    }

    public void setAccPrixManuel(Boolean accPrixManuel) {
        this.accPrixManuel = accPrixManuel;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Integer getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(Integer conditionnement) {
        this.conditionnement = conditionnement;
    }

    public Boolean getAccReprise() {
        return accReprise;
    }

    public void setAccReprise(Boolean accReprise) {
        this.accReprise = accReprise;
    }

    public String getCodeSi() {
        return codeSi;
    }

    public void setCodeSi(String codeSi) {
        this.codeSi = codeSi;
    }

    public Integer getQteEnStock() {
        return qteEnStock;
    }

    public void setQteEnStock(Integer qteEnStock) {
        this.qteEnStock = qteEnStock;
    }

    public String getCodeDecompositionArticle() {
        return codeDecompositionArticle;
    }

    public void setCodeDecompositionArticle(String codeDecompositionArticle) {
        this.codeDecompositionArticle = codeDecompositionArticle;
    }

    public double getQteDecompositionArticle() {
        return qteDecompositionArticle;
    }

    public void setQteDecompositionArticle(double qteDecompositionArticle) {
        this.qteDecompositionArticle = qteDecompositionArticle;
    }

    public String getCodeDecompositionEmballage() {
        return codeDecompositionEmballage;
    }

    public void setCodeDecompositionEmballage(String codeDecompositionEmballage) {
        this.codeDecompositionEmballage = codeDecompositionEmballage;
    }

    public double getQteDecompositionEmballage() {
        return qteDecompositionEmballage;
    }

    public void setQteDecompositionEmballage(double qteDecompositionEmballage) {
        this.qteDecompositionEmballage = qteDecompositionEmballage;
    }

    public String getCodeCompositionArticle() {
        return codeCompositionArticle;
    }

    public void setCodeCompositionArticle(String codeCompositionArticle) {
        this.codeCompositionArticle = codeCompositionArticle;
    }

    public double getQteCompositionArticle() {
        return qteCompositionArticle;
    }

    public void setQteCompositionArticle(double qteCompositionArticle) {
        this.qteCompositionArticle = qteCompositionArticle;
    }

    public String getTypeContenant() {
        return typeContenant;
    }

    public void setTypeContenant(String typeContenant) {
        this.typeContenant = typeContenant;
    }

    public HhtDevise getCodeDevise() {
        return codeDevise;
    }

    public void setCodeDevise(HhtDevise codeDevise) {
        this.codeDevise = codeDevise;
    }

    public HhtEmballage getCodeEmballage() {
        return codeEmballage;
    }

    public void setCodeEmballage(HhtEmballage codeEmballage) {
        this.codeEmballage = codeEmballage;
    }

    public HhtParfums getCodeParfum() {
        return codeParfum;
    }

    public void setCodeParfum(HhtParfums codeParfum) {
        this.codeParfum = codeParfum;
    }

    public HhtSousFamille getCodeSousFamille() {
        return codeSousFamille;
    }

    public void setCodeSousFamille(HhtSousFamille codeSousFamille) {
        this.codeSousFamille = codeSousFamille;
    }

    public HhtTailles getCodeTaille() {
        return codeTaille;
    }

    public void setCodeTaille(HhtTailles codeTaille) {
        this.codeTaille = codeTaille;
    }

    public HhtTva getCodeTva() {
        return codeTva;
    }

    public void setCodeTva(HhtTva codeTva) {
        this.codeTva = codeTva;
    }

    public NumeroSociete getNumeroSociete() {
        return numeroSociete;
    }

    public void setNumeroSociete(NumeroSociete numeroSociete) {
        this.numeroSociete = numeroSociete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeArt != null ? codeArt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtArticle)) {
            return false;
        }
        HhtArticle other = (HhtArticle) object;
        if ((this.codeArt == null && other.codeArt != null) || (this.codeArt != null && !this.codeArt.equals(other.codeArt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtArticle[ codeArt=" + codeArt + " ]";
    }
    
}
