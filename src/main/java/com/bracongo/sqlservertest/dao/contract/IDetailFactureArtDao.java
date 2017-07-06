package com.bracongo.sqlservertest.dao.contract;

import com.bracongo.sqlservertest.dao.IGenericDao;
import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.HhtDetailFactureArt;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Repository
public interface IDetailFactureArtDao extends IGenericDao<HhtDetailFactureArt>{
    
    @Query("select sum(df.qte) from HhtDetailFactureArt df, HhtFacture f1 where df.hhtDetailFactureArtPK.codeFact in (select f2.hhtFacturePK.codeFact from HhtFacture f2 where f2.codeClt = :client and (f2.dateFact between :dateDebut and  :dateFin) and f2.annule is NULL )")
    public int getCustumerAchatBetweenDates(@Param("client")HhtClient client, @Param("dateDebut")Date dateDebut, @Param("dateFin")Date dateFin);
    
}
