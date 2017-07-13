package com.bracongo.sqlservertest.service.impl;

import com.bracongo.sqlservertest.dao.contract.IHhtClientDao;
import com.bracongo.sqlservertest.dao.contract.IHhtPlainteDao;
import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.HhtPlainte;
import com.bracongo.sqlservertest.entities.projection.PlainteProjection;
import com.bracongo.sqlservertest.service.CommonService;
import com.bracongo.sqlservertest.service.contract.IHhtPlainteService;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Service
@Transactional
public class HhtPlainteServiceImpl extends CommonService implements IHhtPlainteService{

    private static final long serialVersionUID = 1L;
    
    private static Logger logger = Logger.getLogger(HhtPlainteServiceImpl.class);

    private HhtPlainteServiceImpl() {
    }
    
    @Autowired
    private IHhtPlainteDao plainteDao;
    
    @Autowired
    private IHhtClientDao clientDao;
    

    @Override
    public HhtPlainte createOrUpdateEntity(HhtPlainte entity) throws PdvException {
        try {
            if(entity != null){
                return plainteDao.save(entity);
            }
            else{
                PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage());
            throw coreException;
            }
        } catch (PdvException e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

    @Override
    public HhtPlainte getEntityById(Long entityId) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntity(HhtPlainte entity) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long entityId) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<HhtPlainte> getAllEntities(int page, int size) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<HhtPlainte> findEntities(String keyWord, int page, int size) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void savePlainteFromWeb(PlainteProjection projection) throws PdvException {
        try {
            if(projection != null && projection.getClient() != null && projection.getPlainte() != null){
                HhtClient client = clientDao.findByCustumerNumber(projection.getClient().trim());
                if(client != null){
                    HhtPlainte plainte = projection.getPlainte();
                    plainte.setDatePlainte(new Date());
                    plainte.setClient(client);
                    plainteDao.save(plainte);
                }
            }
        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }
    
}
