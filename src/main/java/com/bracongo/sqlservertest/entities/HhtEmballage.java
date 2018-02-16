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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HHT_EMBALLAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhtEmballage.findAll", query = "SELECT h FROM HhtEmballage h")
    , @NamedQuery(name = "HhtEmballage.findByCodeEmballage", query = "SELECT h FROM HhtEmballage h WHERE h.codeEmballage = :codeEmballage")
    , @NamedQuery(name = "HhtEmballage.findByDesignation", query = "SELECT h FROM HhtEmballage h WHERE h.designation = :designation")
    , @NamedQuery(name = "HhtEmballage.findByTypeEmballage", query = "SELECT h FROM HhtEmballage h WHERE h.typeEmballage = :typeEmballage")
    , @NamedQuery(name = "HhtEmballage.findByNbrUnite", query = "SELECT h FROM HhtEmballage h WHERE h.nbrUnite = :nbrUnite")
    , @NamedQuery(name = "HhtEmballage.findByPrixEmballage", query = "SELECT h FROM HhtEmballage h WHERE h.prixEmballage = :prixEmballage")
    , @NamedQuery(name = "HhtEmballage.findByCodeBarreEmb", query = "SELECT h FROM HhtEmballage h WHERE h.codeBarreEmb = :codeBarreEmb")
    , @NamedQuery(name = "HhtEmballage.findByPrixManuelEmb", query = "SELECT h FROM HhtEmballage h WHERE h.prixManuelEmb = :prixManuelEmb")
    , @NamedQuery(name = "HhtEmballage.findByNonActif", query = "SELECT h FROM HhtEmballage h WHERE h.nonActif = :nonActif")
    , @NamedQuery(name = "HhtEmballage.findByPrixSupplement", query = "SELECT h FROM HhtEmballage h WHERE h.prixSupplement = :prixSupplement")
    , @NamedQuery(name = "HhtEmballage.findByCodeSi", query = "SELECT h FROM HhtEmballage h WHERE h.codeSi = :codeSi")})
public class HhtEmballage implements Serializable {

    @OneToMany(mappedBy = "codeEmballage")
    private List<HhtArticle> hhtArticleList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODE_EMBALLAGE")
    private String codeEmballage;
    @Size(max = 100)
    @Column(name = "DESIGNATION")
    private String designation;
    @Size(max = 20)
    @Column(name = "TYPE_EMBALLAGE")
    private String typeEmballage;
    @Column(name = "NBR_UNITE")
    private Integer nbrUnite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRIX_EMBALLAGE")
    private Double prixEmballage;
    @Size(max = 50)
    @Column(name = "CODE_BARRE_EMB")
    private String codeBarreEmb;
    @Column(name = "PRIX_MANUEL_EMB")
    private Boolean prixManuelEmb;
    @Column(name = "NON_ACTIF")
    private Boolean nonActif;
    @Column(name = "PRIX_SUPPLEMENT")
    private Double prixSupplement;
    @Size(max = 20)
    @Column(name = "CODE_SI")
    private String codeSi;
   
    public HhtEmballage() {
    }

    public HhtEmballage(String codeEmballage) {
        this.codeEmballage = codeEmballage;
    }

    public String getCodeEmballage() {
        return codeEmballage;
    }

    public void setCodeEmballage(String codeEmballage) {
        this.codeEmballage = codeEmballage;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTypeEmballage() {
        return typeEmballage;
    }

    public void setTypeEmballage(String typeEmballage) {
        this.typeEmballage = typeEmballage;
    }

    public Integer getNbrUnite() {
        return nbrUnite;
    }

    public void setNbrUnite(Integer nbrUnite) {
        this.nbrUnite = nbrUnite;
    }

    public Double getPrixEmballage() {
        return prixEmballage;
    }

    public void setPrixEmballage(Double prixEmballage) {
        this.prixEmballage = prixEmballage;
    }

    public String getCodeBarreEmb() {
        return codeBarreEmb;
    }

    public void setCodeBarreEmb(String codeBarreEmb) {
        this.codeBarreEmb = codeBarreEmb;
    }

    public Boolean getPrixManuelEmb() {
        return prixManuelEmb;
    }

    public void setPrixManuelEmb(Boolean prixManuelEmb) {
        this.prixManuelEmb = prixManuelEmb;
    }

    public Boolean getNonActif() {
        return nonActif;
    }

    public void setNonActif(Boolean nonActif) {
        this.nonActif = nonActif;
    }

    public Double getPrixSupplement() {
        return prixSupplement;
    }

    public void setPrixSupplement(Double prixSupplement) {
        this.prixSupplement = prixSupplement;
    }

    public String getCodeSi() {
        return codeSi;
    }

    public void setCodeSi(String codeSi) {
        this.codeSi = codeSi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeEmballage != null ? codeEmballage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtEmballage)) {
            return false;
        }
        HhtEmballage other = (HhtEmballage) object;
        if ((this.codeEmballage == null && other.codeEmballage != null) || (this.codeEmballage != null && !this.codeEmballage.equals(other.codeEmballage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtEmballage[ codeEmballage=" + codeEmballage + " ]";
    }

    @XmlTransient
    public List<HhtArticle> getHhtArticleList() {
        return hhtArticleList;
    }

    public void setHhtArticleList(List<HhtArticle> hhtArticleList) {
        this.hhtArticleList = hhtArticleList;
    }
    
}
