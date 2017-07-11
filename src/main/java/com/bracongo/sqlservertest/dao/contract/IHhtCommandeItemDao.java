package com.bracongo.sqlservertest.dao.contract;

import com.bracongo.sqlservertest.dao.IGenericDao;
import com.bracongo.sqlservertest.entities.HhtCommande;
import com.bracongo.sqlservertest.entities.HhtCommandeItem;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Repository
public interface IHhtCommandeItemDao extends IGenericDao<HhtCommandeItem>{
    
    @Query("select item from HhtCommandeItem item where item.commande = :commande")
    public List<HhtCommandeItem> findAllByCommande(HhtCommande commande) throws PdvException;
}
