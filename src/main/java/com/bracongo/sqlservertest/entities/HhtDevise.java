/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bracongo.sqlservertest.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vr.kenfack
 */
@Entity
@Table(name = "HHT_DEVISE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhtDevise.findAll", query = "SELECT h FROM HhtDevise h")
    , @NamedQuery(name = "HhtDevise.findByCodeDevise", query = "SELECT h FROM HhtDevise h WHERE h.codeDevise = :codeDevise")
    , @NamedQuery(name = "HhtDevise.findByLibelleDevise", query = "SELECT h FROM HhtDevise h WHERE h.libelleDevise = :libelleDevise")
    , @NamedQuery(name = "HhtDevise.findBySymboleDevise", query = "SELECT h FROM HhtDevise h WHERE h.symboleDevise = :symboleDevise")
    , @NamedQuery(name = "HhtDevise.findByNombreDecimale", query = "SELECT h FROM HhtDevise h WHERE h.nombreDecimale = :nombreDecimale")
    , @NamedQuery(name = "HhtDevise.findByDeviseDefaut", query = "SELECT h FROM HhtDevise h WHERE h.deviseDefaut = :deviseDefaut")})
public class HhtDevise implements Serializable {

    @OneToMany(mappedBy = "codeDevise")
    private List<HhtArticle> hhtArticleList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODE_DEVISE")
    private String codeDevise;
    @Size(max = 50)
    @Column(name = "LIBELLE_DEVISE")
    private String libelleDevise;
    @Size(max = 20)
    @Column(name = "SYMBOLE_DEVISE")
    private String symboleDevise;
    @Column(name = "NOMBRE_DECIMALE")
    private Integer nombreDecimale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEVISE_DEFAUT")
    private boolean deviseDefaut;
    @OneToMany(mappedBy = "codeDevise")
    private List<HhtEmballage> hhtEmballageList;

    public HhtDevise() {
    }

    public HhtDevise(String codeDevise) {
        this.codeDevise = codeDevise;
    }

    public HhtDevise(String codeDevise, boolean deviseDefaut) {
        this.codeDevise = codeDevise;
        this.deviseDefaut = deviseDefaut;
    }

    public String getCodeDevise() {
        return codeDevise;
    }

    public void setCodeDevise(String codeDevise) {
        this.codeDevise = codeDevise;
    }

    public String getLibelleDevise() {
        return libelleDevise;
    }

    public void setLibelleDevise(String libelleDevise) {
        this.libelleDevise = libelleDevise;
    }

    public String getSymboleDevise() {
        return symboleDevise;
    }

    public void setSymboleDevise(String symboleDevise) {
        this.symboleDevise = symboleDevise;
    }

    public Integer getNombreDecimale() {
        return nombreDecimale;
    }

    public void setNombreDecimale(Integer nombreDecimale) {
        this.nombreDecimale = nombreDecimale;
    }

    public boolean getDeviseDefaut() {
        return deviseDefaut;
    }

    public void setDeviseDefaut(boolean deviseDefaut) {
        this.deviseDefaut = deviseDefaut;
    }

    @XmlTransient
    public List<HhtEmballage> getHhtEmballageList() {
        return hhtEmballageList;
    }

    public void setHhtEmballageList(List<HhtEmballage> hhtEmballageList) {
        this.hhtEmballageList = hhtEmballageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeDevise != null ? codeDevise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtDevise)) {
            return false;
        }
        HhtDevise other = (HhtDevise) object;
        if ((this.codeDevise == null && other.codeDevise != null) || (this.codeDevise != null && !this.codeDevise.equals(other.codeDevise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtDevise[ codeDevise=" + codeDevise + " ]";
    }

    @XmlTransient
    public List<HhtArticle> getHhtArticleList() {
        return hhtArticleList;
    }

    public void setHhtArticleList(List<HhtArticle> hhtArticleList) {
        this.hhtArticleList = hhtArticleList;
    }
    
}
