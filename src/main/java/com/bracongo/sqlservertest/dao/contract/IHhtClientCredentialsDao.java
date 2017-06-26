package com.bracongo.sqlservertest.dao.contract;

import com.bracongo.sqlservertest.dao.IGenericDao;
import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.HhtClientCredentials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Repository
public interface IHhtClientCredentialsDao extends IGenericDao<HhtClientCredentials>{
    
    /**
     * 
     * @param client
     * @return 
     */
    @Query("select cc from HhtClientCredentials cc where client = :client")
    public HhtClientCredentials findByCustomer(@Param("client")HhtClient client);
}