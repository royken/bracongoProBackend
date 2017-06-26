package com.bracongo.sqlservertest.service.impl;

import com.bracongo.sqlservertest.dao.contract.IHhtClientCredentialsDao;
import com.bracongo.sqlservertest.dao.contract.IHhtClientDao;
import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.HhtClientCredentials;
import com.bracongo.sqlservertest.entities.projection.CustumResponse;
import com.bracongo.sqlservertest.service.CommonService;
import com.bracongo.sqlservertest.service.contract.IHhtClientService;
import static com.bracongo.sqlservertest.utils.Constants.CLIENT_ERROR;
import static com.bracongo.sqlservertest.utils.Constants.NEW_CLIENT;
import static com.bracongo.sqlservertest.utils.Constants.OLD_CLIENT;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Service
@Transactional
public class HhtClientServiceImpl extends CommonService implements IHhtClientService {

    private HhtClientServiceImpl() {

    }

    private static Logger logger = Logger.getLogger(HhtClientServiceImpl.class);

    @Autowired
    IHhtClientDao clientDao;

    @Autowired
    IHhtClientCredentialsDao credentialsDao;

    /**
     *
     */
    private static final long serialVersionUID = 5312654627637510804L;

    @Override
    public HhtClient createOrUpdateEntity(HhtClient entity) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HhtClient getEntityById(Long entityId) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntity(HhtClient entity) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long entityId) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<HhtClient> getAllEntities(int page, int size) throws PdvException {
        try {
            return clientDao.findAll(new PageRequest(1, 10));

        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;

        }
    }

    @Override
    public Page<HhtClient> findEntities(String keyWord, int page, int size) throws PdvException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HhtClient findByCodeNumber(String code) throws PdvException {
        try {
            return clientDao.findByCustumerNumber(code);
        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

    @Override
    public CustumResponse createAccount(String code) throws PdvException {
        try {
            HhtClientCredentials credentials ;
            HhtClient client = clientDao.findByCustumerNumber(code.trim());
            CustumResponse resp = new CustumResponse();
            if (client != null) {
                credentials = credentialsDao.findByCustomer(client);
                if (credentials == null) {
                    credentials = new HhtClientCredentials();
                    credentials.setActive(1);
                    credentials.setClient(client);
                    credentials.setDateCreation(new Date());
                    credentials.setPassword("password");
                    credentials = credentialsDao.save(credentials);
                    resp.setNumclient(code);
                    resp.setStatus(NEW_CLIENT);
                    resp.setMessage(credentials.getPassword());
                    return resp;
                } else {
                    resp.setStatus(OLD_CLIENT);
                    resp.setNumclient(code);
                    resp.setMessage("Vous avez déjà un mot de passe");
                    return resp;
                }
            } else {
                resp.setStatus(CLIENT_ERROR);
                resp.setNumclient(code);
                resp.setMessage("Ce numéro de compte n'est pas reconnu");
                return resp;
            }
        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
    }

}