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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author vr.kenfack
 */
@Entity
@Table(name = "HHT_TAILLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhtTailles.findAll", query = "SELECT h FROM HhtTailles h")
    , @NamedQuery(name = "HhtTailles.findByCodeTaille", query = "SELECT h FROM HhtTailles h WHERE h.codeTaille = :codeTaille")
    , @NamedQuery(name = "HhtTailles.findByTaille", query = "SELECT h FROM HhtTailles h WHERE h.taille = :taille")})
public class HhtTailles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_TAILLE")
    private String codeTaille;
    @Column(name = "TAILLE")
    private String taille;
    @OneToMany(mappedBy = "codeTaille")
    private List<HhtArticle> hhtArticleList;

    public HhtTailles() {
    }

    public HhtTailles(String codeTaille) {
        this.codeTaille = codeTaille;
    }

    public String getCodeTaille() {
        return codeTaille;
    }

    public void setCodeTaille(String codeTaille) {
        this.codeTaille = codeTaille;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    @XmlTransient
    @JsonIgnore
    public List<HhtArticle> getHhtArticleList() {
        return hhtArticleList;
    }

    public void setHhtArticleList(List<HhtArticle> hhtArticleList) {
        this.hhtArticleList = hhtArticleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeTaille != null ? codeTaille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtTailles)) {
            return false;
        }
        HhtTailles other = (HhtTailles) object;
        if ((this.codeTaille == null && other.codeTaille != null) || (this.codeTaille != null && !this.codeTaille.equals(other.codeTaille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtTailles[ codeTaille=" + codeTaille + " ]";
    }
    
}
