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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author vr.kenfack
 */
@Entity
@Table(name = "HHT_SOUS_FAMILLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhtSousFamille.findAll", query = "SELECT h FROM HhtSousFamille h")
    , @NamedQuery(name = "HhtSousFamille.findByCodeSousFamille", query = "SELECT h FROM HhtSousFamille h WHERE h.codeSousFamille = :codeSousFamille")
    , @NamedQuery(name = "HhtSousFamille.findByLibSousFamille", query = "SELECT h FROM HhtSousFamille h WHERE h.libSousFamille = :libSousFamille")})
public class HhtSousFamille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_SOUS_FAMILLE")
    private String codeSousFamille;
    @Column(name = "LIB_SOUS_FAMILLE")
    private String libSousFamille;
    @OneToMany(mappedBy = "codeSousFamille")
    private List<HhtArticle> hhtArticleList;
    @JoinColumn(name = "CODE_FAMILLE", referencedColumnName = "CODE_FAMILLE")
    @ManyToOne
    private HhtFamille codeFamille;

    public HhtSousFamille() {
    }

    public HhtSousFamille(String codeSousFamille) {
        this.codeSousFamille = codeSousFamille;
    }

    public String getCodeSousFamille() {
        return codeSousFamille;
    }

    public void setCodeSousFamille(String codeSousFamille) {
        this.codeSousFamille = codeSousFamille;
    }

    public String getLibSousFamille() {
        return libSousFamille;
    }

    public void setLibSousFamille(String libSousFamille) {
        this.libSousFamille = libSousFamille;
    }

    @XmlTransient
    @JsonIgnore
    public List<HhtArticle> getHhtArticleList() {
        return hhtArticleList;
    }

    public void setHhtArticleList(List<HhtArticle> hhtArticleList) {
        this.hhtArticleList = hhtArticleList;
    }

    public HhtFamille getCodeFamille() {
        return codeFamille;
    }

    public void setCodeFamille(HhtFamille codeFamille) {
        this.codeFamille = codeFamille;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeSousFamille != null ? codeSousFamille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtSousFamille)) {
            return false;
        }
        HhtSousFamille other = (HhtSousFamille) object;
        if ((this.codeSousFamille == null && other.codeSousFamille != null) || (this.codeSousFamille != null && !this.codeSousFamille.equals(other.codeSousFamille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtSousFamille[ codeSousFamille=" + codeSousFamille + " ]";
    }
    
}
