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
@Table(name = "HHT_FAMILLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HhtFamille.findAll", query = "SELECT h FROM HhtFamille h")
    , @NamedQuery(name = "HhtFamille.findByCodeFamille", query = "SELECT h FROM HhtFamille h WHERE h.codeFamille = :codeFamille")
    , @NamedQuery(name = "HhtFamille.findByLibFamille", query = "SELECT h FROM HhtFamille h WHERE h.libFamille = :libFamille")})
public class HhtFamille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_FAMILLE")
    private String codeFamille;
    @Column(name = "LIB_FAMILLE")
    private String libFamille;
    @JoinColumn(name = "CODE_TVA", referencedColumnName = "CODE_TVA")
    @ManyToOne
    private HhtTva codeTva;
    @OneToMany(mappedBy = "codeFamille")
    private List<HhtSousFamille> hhtSousFamilleList;

    public HhtFamille() {
    }

    public HhtFamille(String codeFamille) {
        this.codeFamille = codeFamille;
    }

    public String getCodeFamille() {
        return codeFamille;
    }

    public void setCodeFamille(String codeFamille) {
        this.codeFamille = codeFamille;
    }

    public String getLibFamille() {
        return libFamille;
    }

    public void setLibFamille(String libFamille) {
        this.libFamille = libFamille;
    }

    public HhtTva getCodeTva() {
        return codeTva;
    }

    public void setCodeTva(HhtTva codeTva) {
        this.codeTva = codeTva;
    }

    @XmlTransient
    @JsonIgnore
    public List<HhtSousFamille> getHhtSousFamilleList() {
        return hhtSousFamilleList;
    }

    public void setHhtSousFamilleList(List<HhtSousFamille> hhtSousFamilleList) {
        this.hhtSousFamilleList = hhtSousFamilleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeFamille != null ? codeFamille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtFamille)) {
            return false;
        }
        HhtFamille other = (HhtFamille) object;
        if ((this.codeFamille == null && other.codeFamille != null) || (this.codeFamille != null && !this.codeFamille.equals(other.codeFamille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtFamille[ codeFamille=" + codeFamille + " ]";
    }
    
}
