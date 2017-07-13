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
@Table(name = "NUMERO_SOCIETE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NumeroSociete.findAll", query = "SELECT n FROM NumeroSociete n")
    , @NamedQuery(name = "NumeroSociete.findById", query = "SELECT n FROM NumeroSociete n WHERE n.id = :id")
    , @NamedQuery(name = "NumeroSociete.findByNomSociete", query = "SELECT n FROM NumeroSociete n WHERE n.nomSociete = :nomSociete")})
public class NumeroSociete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID")
    private String id;
    @Size(max = 100)
    @Column(name = "NOM_SOCIETE")
    private String nomSociete;
    @OneToMany(mappedBy = "numeroSociete")
    private List<HhtArticle> hhtArticleList;

    public NumeroSociete() {
    }

    public NumeroSociete(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    @XmlTransient
    public List<HhtArticle> getHhtArticleList() {
        return hhtArticleList;
    }

    public void setHhtArticleList(List<HhtArticle> hhtArticleList) {
        this.hhtArticleList = hhtArticleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumeroSociete)) {
            return false;
        }
        NumeroSociete other = (NumeroSociete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.NumeroSociete[ id=" + id + " ]";
    }
    
}
