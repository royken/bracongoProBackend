/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bracongo.sqlservertest.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Embeddable
public class HhtDetailFactureArtPK  extends BaseClass {

    private static final long serialVersionUID = 1815016687203793313L;

    @Basic(optional = false)
    @Column(name = "CODE_FACT")
    private String codeFact;
    @Basic(optional = false)
    @Column(name = "CODE_ART")
    private String codeArt;
    @Basic(optional = false)
    @Column(name = "CODE_TYPE_DOCUMENT")
    private String codeTypeDocument;
    @Basic(optional = false)
    @Column(name = "NUM_PU")
    private int numPu;
    @Basic(optional = false)
    @Column(name = "CB_BIGLOX")
    private String cbBiglox;
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private int numero;
    @Basic(optional = false)
    @Column(name = "CODE_DEVISE")
    private String codeDevise;

    public HhtDetailFactureArtPK() {
    }

    public HhtDetailFactureArtPK(String codeFact, String codeArt, String codeTypeDocument, int numPu, String cbBiglox, int numero, String codeDevise) {
        this.codeFact = codeFact;
        this.codeArt = codeArt;
        this.codeTypeDocument = codeTypeDocument;
        this.numPu = numPu;
        this.cbBiglox = cbBiglox;
        this.numero = numero;
        this.codeDevise = codeDevise;
    }

    public String getCodeFact() {
        return codeFact;
    }

    public void setCodeFact(String codeFact) {
        this.codeFact = codeFact;
    }

    public String getCodeArt() {
        return codeArt;
    }

    public void setCodeArt(String codeArt) {
        this.codeArt = codeArt;
    }

    public String getCodeTypeDocument() {
        return codeTypeDocument;
    }

    public void setCodeTypeDocument(String codeTypeDocument) {
        this.codeTypeDocument = codeTypeDocument;
    }

    public int getNumPu() {
        return numPu;
    }

    public void setNumPu(int numPu) {
        this.numPu = numPu;
    }

    public String getCbBiglox() {
        return cbBiglox;
    }

    public void setCbBiglox(String cbBiglox) {
        this.cbBiglox = cbBiglox;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodeDevise() {
        return codeDevise;
    }

    public void setCodeDevise(String codeDevise) {
        this.codeDevise = codeDevise;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeFact != null ? codeFact.hashCode() : 0);
        hash += (codeArt != null ? codeArt.hashCode() : 0);
        hash += (codeTypeDocument != null ? codeTypeDocument.hashCode() : 0);
        hash += (int) numPu;
        hash += (cbBiglox != null ? cbBiglox.hashCode() : 0);
        hash += (int) numero;
        hash += (codeDevise != null ? codeDevise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HhtDetailFactureArtPK)) {
            return false;
        }
        HhtDetailFactureArtPK other = (HhtDetailFactureArtPK) object;
        if ((this.codeFact == null && other.codeFact != null) || (this.codeFact != null && !this.codeFact.equals(other.codeFact))) {
            return false;
        }
        if ((this.codeArt == null && other.codeArt != null) || (this.codeArt != null && !this.codeArt.equals(other.codeArt))) {
            return false;
        }
        if ((this.codeTypeDocument == null && other.codeTypeDocument != null) || (this.codeTypeDocument != null && !this.codeTypeDocument.equals(other.codeTypeDocument))) {
            return false;
        }
        if (this.numPu != other.numPu) {
            return false;
        }
        if ((this.cbBiglox == null && other.cbBiglox != null) || (this.cbBiglox != null && !this.cbBiglox.equals(other.cbBiglox))) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if ((this.codeDevise == null && other.codeDevise != null) || (this.codeDevise != null && !this.codeDevise.equals(other.codeDevise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bracongo.sqlservertest.entities.HhtDetailFactureArtPK[ codeFact=" + codeFact + ", codeArt=" + codeArt + ", codeTypeDocument=" + codeTypeDocument + ", numPu=" + numPu + ", cbBiglox=" + cbBiglox + ", numero=" + numero + ", codeDevise=" + codeDevise + " ]";
    }
    
}
