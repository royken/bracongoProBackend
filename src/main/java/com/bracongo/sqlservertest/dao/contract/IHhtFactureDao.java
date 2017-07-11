package com.bracongo.sqlservertest.dao.contract;

import com.bracongo.sqlservertest.dao.IGenericDao;
import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.HhtFacture;
import com.bracongo.sqlservertest.entities.projection.VenteItem;
import com.bracongo.sqlservertest.entities.projection.VenteJourItem;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Repository
public interface IHhtFactureDao extends IGenericDao<HhtFacture> {
    
    @Query("select sum(facture.totalRistourneEncour) from HhtFacture facture where facture.codeClt = :client and (dateFact between :dateDebut and  :dateFin) and annule is NULL")
    public Double getRemiseBetweenDates(@Param("client") HhtClient client, @Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
    
    @Query("select new com.bracongo.sqlservertest.entities.projection.VenteItem(sum(factdetail.qte) as quantite, Month(fact.dateFact) as mois) from HhtFacture fact, HhtClient hclient, HhtDetailFactureArt factdetail, HhtArticle art where  fact.codeClt = :client and hclient = :client and fact.hhtFacturePK.codeDevise=1 and fact.annule is NULL and year(fact.dateFact) = :annee and fact.hhtFacturePK.codeFact = factdetail.hhtDetailFactureArtPK.codeFact and factdetail.hhtDetailFactureArtPK.codeArt = art.codeArt and substring (art.libelle,1,2) = 'CS' group by (Month (fact.dateFact))")
    public List<VenteItem> getHistoriqueVente(@Param("client") HhtClient client, @Param("annee") int annee);
    
    @Query("select new com.bracongo.sqlservertest.entities.projection.VenteJourItem(sum(factdetail.qte) as quantite, Day(fact.dateFact) as jour) from HhtFacture fact, HhtClient hclient, HhtDetailFactureArt factdetail, HhtArticle art where  fact.codeClt = :client and hclient = :client and fact.hhtFacturePK.codeDevise=1 and fact.annule is NULL and year(fact.dateFact) = :annee and Month(fact.dateFact) = :mois and fact.hhtFacturePK.codeFact = factdetail.hhtDetailFactureArtPK.codeFact and factdetail.hhtDetailFactureArtPK.codeArt = art.codeArt and substring (art.libelle,1,2) = 'CS' group by (Day (fact.dateFact))")
    public List<VenteJourItem> getHistoriqueJourVente(@Param("client") HhtClient client, @Param("annee") int annee , @Param("mois") int mois);
   /* 
    @Query(value = "SELECT \n" +
"sum(HHT_DETAIL_FACTURE_ART.QTE) as quantite, Month (HHT_FACTURE.DATE_FACT) as mois \n" +
"FROM HHT_BRACONGO.dbo.HHT_FACTURE, HHT_BRACONGO.dbo.HHT_CLIENT, HHT_BRACONGO.dbo.HHT_DETAIL_FACTURE_ART,HHT_BRACONGO.dbo.HHT_ARTICLE\n" +
"WHERE HHT_FACTURE.CODE_CLT = HHT_CLIENT.CODE_CLT \n" +
"		AND		HHT_CLIENT.CODE_CLT= :client\n" +
"		AND		HHT_FACTURE.CODE_DEVISE = 1 \n" +
"		AND		HHT_FACTURE.ANNULE IS NULL\n" +
"		AND		year (HHT_FACTURE.DATE_FACT) = :annee \n" +
"		AND		HHT_FACTURE.CODE_FACT = HHT_DETAIL_FACTURE_ART.CODE_FACT \n" +
"		AND		HHT_DETAIL_FACTURE_ART.CODE_ART = HHT_ARTICLE.CODE_ART\n" +
"		AND		substring (HHT_ARTICLE.LIBELLE,1,2) = 'CS'\n" +
"group by (Month (HHT_FACTURE.DATE_FACT))", nativeQuery = true)
    public List<VenteItem> getHistoriqueVente2(@Param("client") String client, @Param("annee") int annee);
 */   
}
