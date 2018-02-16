package com.bracongo.sqlservertest.dao.contract;

import com.bracongo.sqlservertest.dao.IGenericDao;
import com.bracongo.sqlservertest.entities.HhtClient;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Repository
public interface IHhtClientDao extends IGenericDao<HhtClient> {
    @Query("select c from HhtClient c where codeClt like :CODE_CLT")
    public HhtClient findByCustumerNumber(@Param("CODE_CLT") String code);
    
    @Query("select c from HhtClient c where nonActif != 1")
    public List<HhtClient> findAllActive();
    
    @Query("select c from HhtClient c where nonActif != 1 and substring (c.codeClt,1,5) = :circuit")
    public List<HhtClient> findAllByCircuitActive(@Param("circuit") String circuit);
  
}
