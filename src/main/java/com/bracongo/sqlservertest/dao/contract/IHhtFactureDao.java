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
    @Query("select sum(facture.totalRistourneEncour) from HhtFacture facture where facture.codeClt = :client and DATEPART(m, dateFact) = DATEPART(m, DATEADD(m, -1, getdate())) AND DATEPART(yyyy, dateFact) = DATEPART(yyyy, DATEADD(m, -1, getdate())) and annule is NULL")
    public Double getRemiseMoisPasse(@Param("client") HhtClient client);
    
    @Query("select sum(facture.totalRistourneEncour) from HhtFacture facture where facture.codeClt = :client and (dateFact between :dateDebut and  :dateFin) and annule is NULL")
    public Double getRemiseBetweenDates(@Param("client") HhtClient client, @Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
    
    @Query("select sum(facture.totalLiquide) from HhtFacture facture where facture.codeClt = :client and (dateFact between :dateDebut and  :dateFin) and annule is NULL")
    public Double getAchatsBetweenDates(@Param("client") HhtClient client, @Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
    
    @Query("select new com.bracongo.sqlservertest.entities.projection.VenteItem(sum(factdetail.qte) as quantite, Month(fact.dateFact) as mois, sum(factdetail.total) as chiffre) from HhtFacture fact, HhtClient hclient, HhtDetailFactureArt factdetail, HhtArticle art where  fact.codeClt = :client and hclient = :client and fact.hhtFacturePK.codeDevise=1 and fact.annule is NULL and year(fact.dateFact) = :annee and fact.hhtFacturePK.codeFact = factdetail.hhtDetailFactureArtPK.codeFact and factdetail.hhtDetailFactureArtPK.codeArt = art.codeArt and substring (art.libelle,1,2) = 'CS' group by (Month (fact.dateFact))")
    public List<VenteItem> getHistoriqueVente(@Param("client") HhtClient client, @Param("annee") int annee);
    
    @Query("select new com.bracongo.sqlservertest.entities.projection.VenteJourItem(sum(factdetail.qte) as quanfactdetailtite, Day(fact.dateFact) as jour, sum(factdetail.total) as chiffre) from HhtFacture fact, HhtClient hclient, HhtDetailFactureArt factdetail, HhtArticle art where  fact.codeClt = :client and hclient = :client and fact.hhtFacturePK.codeDevise=1 and fact.annule is NULL and year(fact.dateFact) = :annee and Month(fact.dateFact) = :mois and fact.hhtFacturePK.codeFact = factdetail.hhtDetailFactureArtPK.codeFact and factdetail.hhtDetailFactureArtPK.codeArt = art.codeArt and substring (art.libelle,1,2) = 'CS' group by (Day (fact.dateFact))")
    public List<VenteJourItem> getHistoriqueJourVente(@Param("client") HhtClient client, @Param("annee") int annee , @Param("mois") int mois);
    
    @Query("select new com.bracongo.sqlservertest.entities.projection.VenteItem(sum(factdetail.qte) as quantite, Month(fact.dateFact) as mois, sum(factdetail.total) as chiffre, famille.codeFamille as type) from HhtFacture fact, HhtClient hclient, HhtDetailFactureArt factdetail, HhtArticle art, HhtFamille famille, HhtSousFamille sFamille where  fact.codeClt = :client and hclient = :client and fact.hhtFacturePK.codeDevise=1 and fact.annule is NULL and year(fact.dateFact) = :annee and fact.hhtFacturePK.codeFact = factdetail.hhtDetailFactureArtPK.codeFact and factdetail.hhtDetailFactureArtPK.codeArt = art.codeArt and art.codeSousFamille = sFamille.codeSousFamille and sFamille.codeFamille = famille and famille.codeFamille = :type  group by (Month (fact.dateFact)), famille.codeFamille")
    public List<VenteItem> getHistoriqueVenteByTypeProduit(@Param("client") HhtClient client, @Param("annee") int annee, @Param("type") String type);
    
    @Query("select new com.bracongo.sqlservertest.entities.projection.VenteJourItem(sum(factdetail.qte) as quantite, Day(fact.dateFact) as jour, famille.codeFamille as type, sum(factdetail.total) as chiffre) from HhtFacture fact, HhtClient hclient, HhtDetailFactureArt factdetail, HhtArticle art, HhtFamille famille, HhtSousFamille sFamille where  fact.codeClt = :client and hclient = :client and fact.hhtFacturePK.codeDevise=1 and fact.annule is NULL and year(fact.dateFact) = :annee and Month(fact.dateFact) = :mois and fact.hhtFacturePK.codeFact = factdetail.hhtDetailFactureArtPK.codeFact and factdetail.hhtDetailFactureArtPK.codeArt = art.codeArt and art.codeSousFamille = sFamille.codeSousFamille and sFamille.codeFamille = famille and famille.codeFamille = :type  group by (Day (fact.dateFact)), famille.codeFamille")
    public List<VenteJourItem> getHistoriqueJourVenteByTypeProduit(@Param("client") HhtClient client, @Param("annee") int annee, @Param("mois") int mois, @Param("type") String type);
  
}
