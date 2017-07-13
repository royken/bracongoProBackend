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
@Table(name = "HHT_TVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhtTva.findAll", query = "SELECT h FROM HhtTva h")
    , @NamedQuery(name = "HhtTva.findByCodeTva", query = "SELECT h FROM HhtTva h WHERE h.codeTva = :codeTva")
    , @NamedQuery(name = "HhtTva.findByLibelleTva", query = "SELECT h FROM HhtTva h WHERE h.libelleTva = :libelleTva")
    , @NamedQuery(name = "HhtTva.findByTauxTva", query = "SELECT h FROM HhtTva h WHERE h.tauxTva = :tauxTva")})
public class HhtTva implements Serializable {

    @OneToMany(mappedBy = "codeTva")
    private List<HhtArticle> hhtArticleList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODE_TVA")
    private String codeTva;
    @Size(max = 50)
    @Column(name = "LIBELLE_TVA")
    private String libelleTva;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAUX_TVA")
    private Double tauxTva;
    @OneToMany(mappedBy = "codeTva")
    private List<HhtEmballage> hhtEmballageList;
    @OneToMany(mappedBy = "codeTva")
    private List<HhtFamille> hhtFamilleList;

    public HhtTva() {
    }

    public HhtTva(String codeTva) {
        this.codeTva = codeTva;
    }

    public String getCodeTva() {
        return codeTva;
    }

    public void setCodeTva(String codeTva) {
        this.codeTva = codeTva;
    }

    public String getLibelleTva() {
        return libelleTva;
    }

    public void setLibelleTva(String libelleTva) {
        this.libelleTva = libelleTva;
    }

    public Double getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(Double tauxTva) {
        this.tauxTva = tauxTva;
    }

    @XmlTransient
    public List<HhtEmballage> getHhtEmballageList() {
        return hhtEmballageList;
    }

    public void setHhtEmballageList(List<HhtEmballage> hhtEmballageList) {
        this.hhtEmballageList = hhtEmballageList;
    }

    @XmlTransient
    public List<HhtFamille> getHhtFamilleList() {
        return hhtFamilleList;
    }

    public void setHhtFamilleList(List<HhtFamille> hhtFamilleList) {
        this.hhtFamilleList = hhtFamilleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeTva != null ? codeTva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtTva)) {
            return false;
        }
        HhtTva other = (HhtTva) object;
        if ((this.codeTva == null && other.codeTva != null) || (this.codeTva != null && !this.codeTva.equals(other.codeTva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtTva[ codeTva=" + codeTva + " ]";
    }

    @XmlTransient
    public List<HhtArticle> getHhtArticleList() {
        return hhtArticleList;
    }

    public void setHhtArticleList(List<HhtArticle> hhtArticleList) {
        this.hhtArticleList = hhtArticleList;
    }
    
}
