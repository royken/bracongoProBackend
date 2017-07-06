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
@Table(name = "HHT_PARFUMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhtParfums.findAll", query = "SELECT h FROM HhtParfums h")
    , @NamedQuery(name = "HhtParfums.findByCodeParfum", query = "SELECT h FROM HhtParfums h WHERE h.codeParfum = :codeParfum")
    , @NamedQuery(name = "HhtParfums.findByLibParfum", query = "SELECT h FROM HhtParfums h WHERE h.libParfum = :libParfum")
    , @NamedQuery(name = "HhtParfums.findByAbrevParfum", query = "SELECT h FROM HhtParfums h WHERE h.abrevParfum = :abrevParfum")})
public class HhtParfums  extends BaseClass{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_PARFUM")
    private String codeParfum;
    @Column(name = "LIB_PARFUM")
    private String libParfum;
    @Column(name = "ABREV_PARFUM")
    private String abrevParfum;
    @OneToMany(mappedBy = "codeParfum")
    private List<HhtArticle> hhtArticleList;

    public HhtParfums() {
    }

    public HhtParfums(String codeParfum) {
        this.codeParfum = codeParfum;
    }

    public String getCodeParfum() {
        return codeParfum;
    }

    public void setCodeParfum(String codeParfum) {
        this.codeParfum = codeParfum;
    }

    public String getLibParfum() {
        return libParfum;
    }

    public void setLibParfum(String libParfum) {
        this.libParfum = libParfum;
    }

    public String getAbrevParfum() {
        return abrevParfum;
    }

    public void setAbrevParfum(String abrevParfum) {
        this.abrevParfum = abrevParfum;
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
        hash += (codeParfum != null ? codeParfum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtParfums)) {
            return false;
        }
        HhtParfums other = (HhtParfums) object;
        if ((this.codeParfum == null && other.codeParfum != null) || (this.codeParfum != null && !this.codeParfum.equals(other.codeParfum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtParfums[ codeParfum=" + codeParfum + " ]";
    }
    
}
