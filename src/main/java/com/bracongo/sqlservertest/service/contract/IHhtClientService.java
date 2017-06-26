package com.bracongo.sqlservertest.service.contract;

import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.projection.CustumResponse;
import com.bracongo.sqlservertest.service.IGenericService;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vr.kenfack
 */
@Transactional
public interface IHhtClientService extends IGenericService<HhtClient>{
    
    /**
     * 
     * @param code
     * @return
     * @throws PdvException 
     */
    public HhtClient findByCodeNumber(String code) throws PdvException;
    
    /**
     * 
     * @param code
     * @return
     * @throws PdvException 
     */
    public CustumResponse createAccount(String code) throws PdvException;
    
    
}
