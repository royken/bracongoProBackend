/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bracongo.sqlservertest.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vr.kenfack
 */
@Entity
@Table(name = "ANALYSE VENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnalyseVente.findAll", query = "SELECT a FROM AnalyseVente a")
    , @NamedQuery(name = "AnalyseVente.findByArticleLibelle", query = "SELECT a FROM AnalyseVente a WHERE a.articleLibelle = :articleLibelle")
    , @NamedQuery(name = "AnalyseVente.findByClientAdresse", query = "SELECT a FROM AnalyseVente a WHERE a.clientAdresse = :clientAdresse")
    , @NamedQuery(name = "AnalyseVente.findByArticleCode", query = "SELECT a FROM AnalyseVente a WHERE a.articleCode = :articleCode")
    , @NamedQuery(name = "AnalyseVente.findByClientCode", query = "SELECT a FROM AnalyseVente a WHERE a.clientCode = :clientCode")
    , @NamedQuery(name = "AnalyseVente.findByClient", query = "SELECT a FROM AnalyseVente a WHERE a.client = :client")
    , @NamedQuery(name = "AnalyseVente.findByMesureQuantite", query = "SELECT a FROM AnalyseVente a WHERE a.mesureQuantite = :mesureQuantite")
    , @NamedQuery(name = "AnalyseVente.findByMesureCa", query = "SELECT a FROM AnalyseVente a WHERE a.mesureCa = :mesureCa")
    , @NamedQuery(name = "AnalyseVente.findByGeoRoute", query = "SELECT a FROM AnalyseVente a WHERE a.geoRoute = :geoRoute")
    , @NamedQuery(name = "AnalyseVente.findByTempsDate", query = "SELECT a FROM AnalyseVente a WHERE a.tempsDate = :tempsDate")
    , @NamedQuery(name = "AnalyseVente.findByVendeur", query = "SELECT a FROM AnalyseVente a WHERE a.vendeur = :vendeur")
    , @NamedQuery(name = "AnalyseVente.findByGeoTournee", query = "SELECT a FROM AnalyseVente a WHERE a.geoTournee = :geoTournee")
    , @NamedQuery(name = "AnalyseVente.findByClientCanal", query = "SELECT a FROM AnalyseVente a WHERE a.clientCanal = :clientCanal")
    , @NamedQuery(name = "AnalyseVente.findByNFacture", query = "SELECT a FROM AnalyseVente a WHERE a.nFacture = :nFacture")
    , @NamedQuery(name = "AnalyseVente.findByGeoDepot", query = "SELECT a FROM AnalyseVente a WHERE a.geoDepot = :geoDepot")
    , @NamedQuery(name = "AnalyseVente.findByGeoSecteur", query = "SELECT a FROM AnalyseVente a WHERE a.geoSecteur = :geoSecteur")
    , @NamedQuery(name = "AnalyseVente.findByArticleFamille", query = "SELECT a FROM AnalyseVente a WHERE a.articleFamille = :articleFamille")
    , @NamedQuery(name = "AnalyseVente.findByArticleTaille", query = "SELECT a FROM AnalyseVente a WHERE a.articleTaille = :articleTaille")
    , @NamedQuery(name = "AnalyseVente.findByArticleGamme", query = "SELECT a FROM AnalyseVente a WHERE a.articleGamme = :articleGamme")
    , @NamedQuery(name = "AnalyseVente.findByTempsJour", query = "SELECT a FROM AnalyseVente a WHERE a.tempsJour = :tempsJour")
    , @NamedQuery(name = "AnalyseVente.findByTempsMois", query = "SELECT a FROM AnalyseVente a WHERE a.tempsMois = :tempsMois")
    , @NamedQuery(name = "AnalyseVente.findByTempsAnnee", query = "SELECT a FROM AnalyseVente a WHERE a.tempsAnnee = :tempsAnnee")
    , @NamedQuery(name = "AnalyseVente.findByVendeurCode", query = "SELECT a FROM AnalyseVente a WHERE a.vendeurCode = :vendeurCode")
    , @NamedQuery(name = "AnalyseVente.findByRouteCode", query = "SELECT a FROM AnalyseVente a WHERE a.routeCode = :routeCode")
    , @NamedQuery(name = "AnalyseVente.findByBl", query = "SELECT a FROM AnalyseVente a WHERE a.bl = :bl")
    , @NamedQuery(name = "AnalyseVente.findByCodeDevise", query = "SELECT a FROM AnalyseVente a WHERE a.codeDevise = :codeDevise")})
public class AnalyseVente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ARTICLE LIBELLE")
    private String articleLibelle;
    @Column(name = "CLIENT ADRESSE")
    private String clientAdresse;
    @Column(name = "ARTICLE CODE")
    private String articleCode;
    @Column(name = "CLIENT CODE")
    @Id
    private String clientCode;
    @Column(name = "CLIENT")
    private String client;
    @Column(name = "MESURE QUANTITE")
    private Long mesureQuantite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MESURE CA")
    private Double mesureCa;
    @Column(name = "GEO ROUTE")
    private String geoRoute;
    @Column(name = "TEMPS DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tempsDate;
    @Column(name = "VENDEUR")
    private String vendeur;
    @Column(name = "GEO TOURNEE")
    private String geoTournee;
    @Column(name = "CLIENT CANAL")
    private String clientCanal;
    @Column(name = "N\u00b0 FACTURE")
    private String nFacture;
    @Column(name = "GEO DEPOT")
    private String geoDepot;
    @Column(name = "GEO SECTEUR")
    private String geoSecteur;
    @Column(name = "ARTICLE FAMILLE")
    private String articleFamille;
    @Column(name = "ARTICLE TAILLE")
    private String articleTaille;
    @Column(name = "ARTICLE GAMME")
    private String articleGamme;
    @Column(name = "TEMPS JOUR")
    private Integer tempsJour;
    @Column(name = "TEMPS MOIS")
    private String tempsMois;
    @Column(name = "TEMPS ANNEE")
    private Integer tempsAnnee;
    @Column(name = "VENDEUR CODE")
    private String vendeurCode;
    @Column(name = "ROUTE CODE")
    private String routeCode;
    @Column(name = "BL")
    private String bl;
    @Column(name = "CODE_DEVISE")
    private String codeDevise;

    public AnalyseVente() {
    }

    public String getArticleLibelle() {
        return articleLibelle;
    }

    public void setArticleLibelle(String articleLibelle) {
        this.articleLibelle = articleLibelle;
    }

    public String getClientAdresse() {
        return clientAdresse;
    }

    public void setClientAdresse(String clientAdresse) {
        this.clientAdresse = clientAdresse;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getMesureQuantite() {
        return mesureQuantite;
    }

    public void setMesureQuantite(Long mesureQuantite) {
        this.mesureQuantite = mesureQuantite;
    }

    public Double getMesureCa() {
        return mesureCa;
    }

    public void setMesureCa(Double mesureCa) {
        this.mesureCa = mesureCa;
    }

    public String getGeoRoute() {
        return geoRoute;
    }

    public void setGeoRoute(String geoRoute) {
        this.geoRoute = geoRoute;
    }

    public Date getTempsDate() {
        return tempsDate;
    }

    public void setTempsDate(Date tempsDate) {
        this.tempsDate = tempsDate;
    }

    public String getVendeur() {
        return vendeur;
    }

    public void setVendeur(String vendeur) {
        this.vendeur = vendeur;
    }

    public String getGeoTournee() {
        return geoTournee;
    }

    public void setGeoTournee(String geoTournee) {
        this.geoTournee = geoTournee;
    }

    public String getClientCanal() {
        return clientCanal;
    }

    public void setClientCanal(String clientCanal) {
        this.clientCanal = clientCanal;
    }

    public String getNFacture() {
        return nFacture;
    }

    public void setNFacture(String nFacture) {
        this.nFacture = nFacture;
    }

    public String getGeoDepot() {
        return geoDepot;
    }

    public void setGeoDepot(String geoDepot) {
        this.geoDepot = geoDepot;
    }

    public String getGeoSecteur() {
        return geoSecteur;
    }

    public void setGeoSecteur(String geoSecteur) {
        this.geoSecteur = geoSecteur;
    }

    public String getArticleFamille() {
        return articleFamille;
    }

    public void setArticleFamille(String articleFamille) {
        this.articleFamille = articleFamille;
    }

    public String getArticleTaille() {
        return articleTaille;
    }

    public void setArticleTaille(String articleTaille) {
        this.articleTaille = articleTaille;
    }

    public String getArticleGamme() {
        return articleGamme;
    }

    public void setArticleGamme(String articleGamme) {
        this.articleGamme = articleGamme;
    }

    public Integer getTempsJour() {
        return tempsJour;
    }

    public void setTempsJour(Integer tempsJour) {
        this.tempsJour = tempsJour;
    }

    public String getTempsMois() {
        return tempsMois;
    }

    public void setTempsMois(String tempsMois) {
        this.tempsMois = tempsMois;
    }

    public Integer getTempsAnnee() {
        return tempsAnnee;
    }

    public void setTempsAnnee(Integer tempsAnnee) {
        this.tempsAnnee = tempsAnnee;
    }

    public String getVendeurCode() {
        return vendeurCode;
    }

    public void setVendeurCode(String vendeurCode) {
        this.vendeurCode = vendeurCode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public String getCodeDevise() {
        return codeDevise;
    }

    public void setCodeDevise(String codeDevise) {
        this.codeDevise = codeDevise;
    }
    
}
