package com.bracongo.sqlservertest.service.contract;

import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.projection.CustumResponse;
import com.bracongo.sqlservertest.entities.projection.VenteItem;
import com.bracongo.sqlservertest.entities.projection.VentesInfos;
import com.bracongo.sqlservertest.service.IGenericService;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import java.util.Date;
import java.util.List;
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
    
    /**
     * 
     * @param code
     * @param password
     * @param date
     * @return
     * @throws PdvException 
     */
    public double getRemiseMonth(String code, String password) throws PdvException;
    
    /**
     * 
     * @param code
     * @return
     * @throws PdvException 
     */
    public List<VenteItem> getHistorique(String code, String password) throws PdvException;
    
    /**
     * 
     * @param code
     * @param password
     * @return
     * @throws PdvException 
     */
    public VentesInfos getVentesInfosByClient(String code, String password) throws PdvException;
    
    
}
