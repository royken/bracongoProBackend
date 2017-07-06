/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bracongo.sqlservertest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Entity
@Table(name = "HHT_CLIENT")
@XmlRootElement(name="HHT_CLIENT")
@XmlAccessorType(XmlAccessType.FIELD)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
    @NamedQuery(name = "HhtClient.findAll", query = "SELECT h FROM HhtClient h")})
public class HhtClient extends BaseClass{

    @Lob
    @Column(name = "PHOTO")
    @JsonIgnore
    @XmlTransient
    private byte[] photo;
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeClt")
    @JsonIgnore
    @XmlTransient
    private List<HhtFacture> hhtFactureList;
    @JoinColumn(name = "CODE_CARTE_FID", referencedColumnName = "CODE_CARTE_FID")
    @ManyToOne
    @JsonIgnore
    @XmlTransient
    private HhtCarteFidelite codeCarteFid;
    @JoinColumn(name = "CODE_CREDIT", referencedColumnName = "CODE_CREDIT")
    @ManyToOne
    @JsonIgnore
    @XmlTransient
    private HhtCredit codeCredit;
    @JoinColumn(name = "CODE_TYPE_DOCUMENT_DEFAUT", referencedColumnName = "CODE_TYPE_DOCUMENT")
    @ManyToOne
    @JsonIgnore
    @XmlTransient
    private HhtDocuments codeTypeDocumentDefaut;
    @JoinColumn(name = "NUM_TARIF", referencedColumnName = "NUM_TARIF")
    @ManyToOne
    @JsonIgnore
    @XmlTransient
    private HhtNumTarifs numTarif;
    @JoinColumn(name = "CODE_TYPE_CLI", referencedColumnName = "CODE_TYPE_CLI")
    @ManyToOne
    @JsonIgnore
    @XmlTransient
    private HhtTypeClient codeTypeCli;
    */
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_CLT")
    private String codeClt;
    @Column(name = "NOM_CLT")
    private String nomClt;
    @Column(name = "RAISON_SOCIALE")
    private String raisonSociale;
    @Column(name = "ADRESSE_CLT")
    private String adresseClt;
    @Column(name = "CP")
    private String cp;
    @Column(name = "VILLE")
    private String ville;
    @Column(name = "PAYS")
    private String pays;
    @Column(name = "TEL")
    private String tel;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "N_TVA")
    private String nTva;
    @Column(name = "CODE_RISTOURNE")
    private String codeRistourne;
    @Column(name = "TAXABLE")
    private Boolean taxable;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PLAFOND_CREDIT_CLT")
    @JsonIgnore
    @XmlTransient
    private Double plafondCreditClt;
    @Column(name = "PRESTIGE")
    private Boolean prestige;
    @Column(name = "ACC_REMISE")
    private Boolean accRemise;
    @Column(name = "CODE_CONTRIBUABLE")
    private String codeContribuable;
    @Column(name = "CODE_BARRE")
    @JsonIgnore
    @XmlTransient
    private String codeBarre;
    @Column(name = "ACC_PRIX_MANUEL")
    @JsonIgnore
    @XmlTransient
    private Boolean accPrixManuel;
    @Column(name = "TAUX_LIVRAISON")
    @JsonIgnore
    @XmlTransient
    private Double tauxLivraison;
    @Column(name = "CODE_CLT_NUMERIQUE")
    @JsonIgnore
    @XmlTransient
    private BigInteger codeCltNumerique;
    @Column(name = "INFO")
    @JsonIgnore
    @XmlTransient
    private String info;
    @Column(name = "NON_ACTIF")
    @JsonIgnore
    @XmlTransient
    private Boolean nonActif;
    @Column(name = "ACC_REPRISE")
    @JsonIgnore
    @XmlTransient
    private Boolean accReprise;
    @Column(name = "ACC_DECONSIGNATION")
    @JsonIgnore
    @XmlTransient
    private Boolean accDeconsignation;
    @Column(name = "ID_FISCAL")
    @JsonIgnore
    @XmlTransient
    private String idFiscal;
    @Column(name = "REGISTRE_COMMERCE")
    @JsonIgnore
    @XmlTransient
    private String registreCommerce;
    @Column(name = "ID_SOCIAL")
    @JsonIgnore
    @XmlTransient
    private String idSocial;
    @Column(name = "TAUX_REMISE")
    @JsonIgnore
    @XmlTransient
    private Double tauxRemise;
    @Column(name = "SEUIL_REMISE")
    @JsonIgnore
    @XmlTransient
    private Double seuilRemise;
    @Column(name = "CB_VISITE")
    @JsonIgnore
    @XmlTransient
    private String cbVisite;
    @Column(name = "EXT")
    @JsonIgnore
    @XmlTransient
    private String ext;
    @Column(name = "XGPS")
    @JsonIgnore
    @XmlTransient
    private String xgps;
    @Column(name = "YGPS")
    @JsonIgnore
    @XmlTransient
    private String ygps;
    @Column(name = "ZGPS")
    @JsonIgnore
    @XmlTransient
    private String zgps;
    @Column(name = "CODE_TARIF_RISTOURNE")
    @JsonIgnore
    @XmlTransient
    private String codeTarifRistourne;
    @Column(name = "CODE_GROSSISTE")
    @JsonIgnore
    @XmlTransient
    private String codeGrossiste;
    @Column(name = "CODE_CLT_SI")
    @JsonIgnore
    @XmlTransient
    private String codeCltSi;
    @Column(name = "CODE_ACCES_RISTOURNE")
    @JsonIgnore
    @XmlTransient
    private String codeAccesRistourne;
    @Basic(optional = false)
    @Column(name = "QTE_VENTE_MINIMALE")
    @JsonIgnore
    @XmlTransient
    private double qteVenteMinimale;
    @Basic(optional = false)
    @Column(name = "QTE_RISTOURNE_MINIMALE")
    @JsonIgnore
    @XmlTransient
    private double qteRistourneMinimale;
    @Column(name = "CODE_CLASSE")
    @JsonIgnore
    @XmlTransient
    private String codeClasse;
    @Column(name = "EMAIL")
    @JsonIgnore
    @XmlTransient
    private String email;
    @Column(name = "NOUVEAU_CLIENT")
    @JsonIgnore
    @XmlTransient
    private Boolean nouveauClient;
    @Column(name = "AREA")
    @JsonIgnore
    @XmlTransient
    private Double area;
    
    @XmlTransient
    @JsonIgnore
    @OneToOne(mappedBy = "client")
    private HhtClientCredentials hhtClientCredentials;
   

    public HhtClient() {
    }

    public HhtClient(String codeClt) {
        this.codeClt = codeClt;
    }

    public HhtClient(String codeClt, double qteVenteMinimale, double qteRistourneMinimale) {
        this.codeClt = codeClt;
        this.qteVenteMinimale = qteVenteMinimale;
        this.qteRistourneMinimale = qteRistourneMinimale;
    }

    public String getCodeClt() {
        return codeClt;
    }

    public void setCodeClt(String codeClt) {
        this.codeClt = codeClt;
    }

    public String getNomClt() {
        return nomClt;
    }

    public void setNomClt(String nomClt) {
        this.nomClt = nomClt;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresseClt() {
        return adresseClt;
    }

    public void setAdresseClt(String adresseClt) {
        this.adresseClt = adresseClt;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNTva() {
        return nTva;
    }

    public void setNTva(String nTva) {
        this.nTva = nTva;
    }

    public String getCodeRistourne() {
        return codeRistourne;
    }

    public void setCodeRistourne(String codeRistourne) {
        this.codeRistourne = codeRistourne;
    }

    public Boolean getTaxable() {
        return taxable;
    }

    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    public Double getPlafondCreditClt() {
        return plafondCreditClt;
    }

    public void setPlafondCreditClt(Double plafondCreditClt) {
        this.plafondCreditClt = plafondCreditClt;
    }

    public Boolean getPrestige() {
        return prestige;
    }

    public void setPrestige(Boolean prestige) {
        this.prestige = prestige;
    }

    public Boolean getAccRemise() {
        return accRemise;
    }

    public void setAccRemise(Boolean accRemise) {
        this.accRemise = accRemise;
    }

    public String getCodeContribuable() {
        return codeContribuable;
    }

    public void setCodeContribuable(String codeContribuable) {
        this.codeContribuable = codeContribuable;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Boolean getAccPrixManuel() {
        return accPrixManuel;
    }

    public void setAccPrixManuel(Boolean accPrixManuel) {
        this.accPrixManuel = accPrixManuel;
    }

    public Double getTauxLivraison() {
        return tauxLivraison;
    }

    public void setTauxLivraison(Double tauxLivraison) {
        this.tauxLivraison = tauxLivraison;
    }

    public BigInteger getCodeCltNumerique() {
        return codeCltNumerique;
    }

    public void setCodeCltNumerique(BigInteger codeCltNumerique) {
        this.codeCltNumerique = codeCltNumerique;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getNonActif() {
        return nonActif;
    }

    public void setNonActif(Boolean nonActif) {
        this.nonActif = nonActif;
    }

    public Boolean getAccReprise() {
        return accReprise;
    }

    public void setAccReprise(Boolean accReprise) {
        this.accReprise = accReprise;
    }

    public Boolean getAccDeconsignation() {
        return accDeconsignation;
    }

    public void setAccDeconsignation(Boolean accDeconsignation) {
        this.accDeconsignation = accDeconsignation;
    }

    public String getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(String idFiscal) {
        this.idFiscal = idFiscal;
    }

    public String getRegistreCommerce() {
        return registreCommerce;
    }

    public void setRegistreCommerce(String registreCommerce) {
        this.registreCommerce = registreCommerce;
    }

    public String getIdSocial() {
        return idSocial;
    }

    public void setIdSocial(String idSocial) {
        this.idSocial = idSocial;
    }

    public Double getTauxRemise() {
        return tauxRemise;
    }

    public void setTauxRemise(Double tauxRemise) {
        this.tauxRemise = tauxRemise;
    }

    public Double getSeuilRemise() {
        return seuilRemise;
    }

    public void setSeuilRemise(Double seuilRemise) {
        this.seuilRemise = seuilRemise;
    }

    public String getCbVisite() {
        return cbVisite;
    }

    public void setCbVisite(String cbVisite) {
        this.cbVisite = cbVisite;
    }


    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getXgps() {
        return xgps;
    }

    public void setXgps(String xgps) {
        this.xgps = xgps;
    }

    public String getYgps() {
        return ygps;
    }

    public void setYgps(String ygps) {
        this.ygps = ygps;
    }

    public String getZgps() {
        return zgps;
    }

    public void setZgps(String zgps) {
        this.zgps = zgps;
    }

    public String getCodeTarifRistourne() {
        return codeTarifRistourne;
    }

    public void setCodeTarifRistourne(String codeTarifRistourne) {
        this.codeTarifRistourne = codeTarifRistourne;
    }

    public String getCodeGrossiste() {
        return codeGrossiste;
    }

    public void setCodeGrossiste(String codeGrossiste) {
        this.codeGrossiste = codeGrossiste;
    }

    public String getCodeCltSi() {
        return codeCltSi;
    }

    public void setCodeCltSi(String codeCltSi) {
        this.codeCltSi = codeCltSi;
    }

    public String getCodeAccesRistourne() {
        return codeAccesRistourne;
    }

    public void setCodeAccesRistourne(String codeAccesRistourne) {
        this.codeAccesRistourne = codeAccesRistourne;
    }

    public double getQteVenteMinimale() {
        return qteVenteMinimale;
    }

    public void setQteVenteMinimale(double qteVenteMinimale) {
        this.qteVenteMinimale = qteVenteMinimale;
    }

    public double getQteRistourneMinimale() {
        return qteRistourneMinimale;
    }

    public void setQteRistourneMinimale(double qteRistourneMinimale) {
        this.qteRistourneMinimale = qteRistourneMinimale;
    }

    public String getCodeClasse() {
        return codeClasse;
    }

    public void setCodeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getNouveauClient() {
        return nouveauClient;
    }

    public void setNouveauClient(Boolean nouveauClient) {
        this.nouveauClient = nouveauClient;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }



   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeClt != null ? codeClt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtClient)) {
            return false;
        }
        HhtClient other = (HhtClient) object;
        if ((this.codeClt == null && other.codeClt != null) || (this.codeClt != null && !this.codeClt.equals(other.codeClt))) {
            return false;
        }
        return true;
    }

 

    public String getnTva() {
        return nTva;
    }

    public void setnTva(String nTva) {
        this.nTva = nTva;
    }

    public HhtClientCredentials getHhtClientCredentials() {
        return hhtClientCredentials;
    }

    public void setHhtClientCredentials(HhtClientCredentials hhtClientCredentials) {
        this.hhtClientCredentials = hhtClientCredentials;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

//    @XmlTransient
//    @org.codehaus.jackson.annotate.JsonIgnore
//    public List<HhtFacture> getHhtFactureList() {
//        return hhtFactureList;
//    }
//
//    public void setHhtFactureList(List<HhtFacture> hhtFactureList) {
//        this.hhtFactureList = hhtFactureList;
//    }
//
//    public HhtCarteFidelite getCodeCarteFid() {
//        return codeCarteFid;
//    }
//
//    public void setCodeCarteFid(HhtCarteFidelite codeCarteFid) {
//        this.codeCarteFid = codeCarteFid;
//    }
//
//    public HhtCredit getCodeCredit() {
//        return codeCredit;
//    }
//
//    public void setCodeCredit(HhtCredit codeCredit) {
//        this.codeCredit = codeCredit;
//    }
//
//    public HhtDocuments getCodeTypeDocumentDefaut() {
//        return codeTypeDocumentDefaut;
//    }
//
//    public void setCodeTypeDocumentDefaut(HhtDocuments codeTypeDocumentDefaut) {
//        this.codeTypeDocumentDefaut = codeTypeDocumentDefaut;
//    }
//
//    public HhtNumTarifs getNumTarif() {
//        return numTarif;
//    }
//
//    public void setNumTarif(HhtNumTarifs numTarif) {
//        this.numTarif = numTarif;
//    }
//
//    public HhtTypeClient getCodeTypeCli() {
//        return codeTypeCli;
//    }
//
//    public void setCodeTypeCli(HhtTypeClient codeTypeCli) {
//        this.codeTypeCli = codeTypeCli;
//    }

}
