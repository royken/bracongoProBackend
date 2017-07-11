package com.bracongo.sqlservertest.service.impl;

import com.bracongo.sqlservertest.dao.contract.IDetailFactureArtDao;
import com.bracongo.sqlservertest.dao.contract.IHhtClientCredentialsDao;
import com.bracongo.sqlservertest.dao.contract.IHhtClientDao;
import com.bracongo.sqlservertest.dao.contract.IHhtFactureDao;
import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.HhtClientCredentials;
import com.bracongo.sqlservertest.entities.projection.CustumResponse;
import com.bracongo.sqlservertest.entities.projection.VenteItem;
import com.bracongo.sqlservertest.entities.projection.VenteJourItem;
import com.bracongo.sqlservertest.entities.projection.VentesInfos;
import com.bracongo.sqlservertest.service.CommonService;
import com.bracongo.sqlservertest.service.contract.IHhtClientService;
import static com.bracongo.sqlservertest.utils.Constants.CLIENT_ERROR;
import static com.bracongo.sqlservertest.utils.Constants.NEW_CLIENT;
import static com.bracongo.sqlservertest.utils.Constants.OLD_CLIENT;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    @Autowired
    IHhtFactureDao factureDao;

    @Autowired
    IDetailFactureArtDao detailFactureArtDao;

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
    public CustumResponse createAccount(String code, String password) throws PdvException {
        try {
            HhtClientCredentials credentials;
            HhtClient client = clientDao.findByCustumerNumber(code.trim());
            CustumResponse resp = new CustumResponse();
            if (client != null) {
                credentials = credentialsDao.findByCustomer(client);
                if (credentials == null) {
                    credentials = new HhtClientCredentials();
                    credentials.setActive(1);
                    credentials.setClient(client);
                    credentials.setDateCreation(new Date());
                    credentials.setPassword(password.trim());
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

    @Override
    public double getRemiseMonth(String code, String password) throws PdvException {
        try {
            HhtClientCredentials credentials;
            HhtClient client = clientDao.findByCustumerNumber(code.trim());
            CustumResponse resp = new CustumResponse();
            if (client != null) {
                credentials = credentialsDao.findByCustomer(client);
                if (credentials != null) {
                    if (credentials.getPassword().equals(password)) {
                        Date debut, fin, date;
                        Calendar cal = Calendar.getInstance();

                        cal.set(Calendar.HOUR_OF_DAY, 27);
                        cal.set(Calendar.MINUTE, 0);
                        cal.set(Calendar.MONTH, 3);
                        cal.set(Calendar.YEAR, 2014);
                        debut = cal.getTime();

                        //cal = Calendar.getInstance();
                        //cal.setTime(date);
                        //cal.set(Calendar.HOUR_OF_DAY, 23);
                        //cal.set(Calendar.MINUTE, 0);
                        //debut = cal.getTime();
                        cal = Calendar.getInstance();
                        cal.setTime(debut);
                        cal.set(Calendar.HOUR_OF_DAY, 0);
                        cal.set(Calendar.MINUTE, 0);
                        cal.add(Calendar.MONTH, -1);
                        fin = cal.getTime();
                        System.out.println("Date debut : " + fin + "Date fin : " + debut);
                          System.out.println("REMISEEEEEEEE : " + factureDao.getRemiseBetweenDates(client, fin, debut));
                        //Double remise =  factureDao.getRemiseBetweenDates(client, fin, debut);
                        int value = detailFactureArtDao.getCustumerAchatBetweenDates(client, debut, fin);
                        System.out.println("REMISE : " + value);
                        return value;
                    }
                }
            }

        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
        return 0;
    }

    @Override
    public List<VenteItem> getHistorique(String code, String password) throws PdvException {
        try {
            HhtClientCredentials credentials;
            HhtClient client = clientDao.findByCustumerNumber(code.trim());
            CustumResponse resp = new CustumResponse();
            if (client != null) {
                credentials = credentialsDao.findByCustomer(client);
                if (credentials != null) {
                    if (credentials.getPassword().equals(password)) {
                        Calendar cal = Calendar.getInstance();
                        List<VenteItem> items = factureDao.getHistoriqueVente(client, cal.get(Calendar.YEAR));
                        System.out.println("LE RESULTAT : " + (VenteItem) items.get(0));
                        return items;
                    }
                }
            }

        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
        return null;
    }

    @Override
    public VentesInfos getVentesInfosByClient(String code, String password) throws PdvException {
        try {
            HhtClientCredentials credentials;
            HhtClient client = clientDao.findByCustumerNumber(code.trim());
            CustumResponse resp = new CustumResponse();
            if (client != null) {
                credentials = credentialsDao.findByCustomer(client);
                if (credentials != null) {
                    if (credentials.getPassword().equals(password)) {
                        Calendar cal;
                        Date debut, fin;
                        /*Calcul de remise*/

                        cal = Calendar.getInstance();
                        cal.set(Calendar.MONTH, 4);
                        debut = cal.getTime();
                        cal = Calendar.getInstance();
                        cal.setTime(debut);
                        cal.set(Calendar.HOUR_OF_DAY, 0);
                        cal.set(Calendar.MINUTE, 0);
                        //cal.add(Calendar.MONTH, -1);
                        cal.set(Calendar.DAY_OF_MONTH, 1);
                        fin = cal.getTime();
                        System.out.println("MES DATTESSSS : " + " debut = " + debut + " fin = " + fin);
                        //int value = detailFactureArtDao.getCustumerAchatBetweenDates(client, fin, debut);
                        Double remise = factureDao.getRemiseBetweenDates(client, fin, debut);
                        /* Calcul de l'hitorique de vente*/
                        cal = Calendar.getInstance();
                        List<VenteItem> items = factureDao.getHistoriqueVente(client, cal.get(Calendar.YEAR));
                        cal = Calendar.getInstance();
                        /* To remove after*/
                        cal.set(Calendar.MONTH, 4);
                        List<VenteJourItem> items2 = factureDao.getHistoriqueJourVente(client, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH));
                        //    System.out.println("LE RESULTAT : " + (VenteItem)items.get(0) );
                        VentesInfos result = new VentesInfos();
                        result.setRemise(remise == null ? 0: remise);
                        result.setVenteItems(items);
                        result.setVenteJourItems(items2);
                        result.setDateDebutRemise(fin);
                        result.setDateFinRemise(debut);
                        return result;
                    }
                }
            }
        } catch (Exception e) {
            PdvException coreException = new PdvException(errorMessagesFilePath,
                    "THRAVVELCOREAGENCYSERVICEERROR-007");
            logger.error(coreException.getMessage(), e);
            throw coreException;
        }
        return null;
    }

}
