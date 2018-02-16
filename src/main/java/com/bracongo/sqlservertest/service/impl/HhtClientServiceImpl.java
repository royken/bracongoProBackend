package com.bracongo.sqlservertest.service.impl;

import com.bracongo.sqlservertest.dao.contract.IDetailFactureArtDao;
import com.bracongo.sqlservertest.dao.contract.IHhtClientDao;
import com.bracongo.sqlservertest.dao.contract.IHhtFactureDao;
import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.projection.CustumResponse;
import com.bracongo.sqlservertest.entities.projection.Vente;
import com.bracongo.sqlservertest.entities.projection.VenteItem;
import com.bracongo.sqlservertest.entities.projection.VenteJourItem;
import com.bracongo.sqlservertest.entities.projection.VentesInfos;
import com.bracongo.sqlservertest.entities.projection.VentesResult;
import com.bracongo.sqlservertest.service.CommonService;
import com.bracongo.sqlservertest.service.contract.IHhtClientService;
import static com.bracongo.sqlservertest.utils.Constants.CLIENT_ERROR;
import static com.bracongo.sqlservertest.utils.Constants.NEW_CLIENT;
import static com.bracongo.sqlservertest.utils.Constants.OLD_CLIENT;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import com.bracongo.sqlservertest.utils.PasswordUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    IHhtFactureDao factureDao;

    @Autowired
    IDetailFactureArtDao detailFactureArtDao;

    List<Vente> ventesMois;
    
    List<Vente> ventesJour;
    
    Double remise;

    Double chiffreAffaire;

    Double remisePasse;

    private HhtClient client;

    private static final int MYTHREADS = 30;

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
            HhtClient client = clientDao.findByCustumerNumber(code.trim());
            CustumResponse resp = new CustumResponse();
            if (client != null) {
                if (!PasswordUtils.getKeyFromClient(client.getCodeClt().trim()).trim().equalsIgnoreCase(password)) {
                    resp.setStatus(CLIENT_ERROR);
                    resp.setNumclient(code);
                    resp.setMessage("Identifiants Incorrects");
                    return resp;
                } else {
                    resp.setStatus(OLD_CLIENT);
                    resp.setNumclient(code);
                    resp.setMessage(PasswordUtils.getKeyFromClient(client.getCodeClt().trim()).trim());
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

            HhtClient client = clientDao.findByCustumerNumber(code.trim());
            CustumResponse resp = new CustumResponse();
            if (client != null) {
                if (PasswordUtils.getKeyFromClient(client.getCodeClt().trim()).trim().equals(password)) {
                    Date debut, fin, date;
                    Calendar cal = Calendar.getInstance();
                    System.out.println("TIMEZONE : " + cal.getTimeZone());
                    cal.setTimeZone(TimeZone.getTimeZone("Africa/Kinshasa"));
                    cal.set(Calendar.DAY_OF_MONTH, 19);
                    //   cal.set(Calendar.HOUR_OF_DAY, 23);
                    //  cal.set(Calendar.MINUTE, 59);
                    // cal.set(Calendar.SECOND, 59);
                    debut = cal.getTime();

                    cal = Calendar.getInstance();
                    cal.setTimeZone(TimeZone.getTimeZone("Africa/Kinshasa"));
                    cal.setTime(debut);
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                    cal.set(Calendar.MINUTE, 0);
                    fin = cal.getTime();
                    System.out.println("Date debut : " + fin + "Date fin : " + debut);

                    System.out.println("REMISEEEEEEEE : " + factureDao.getRemiseBetweenDates(client, fin, debut));
                    //Double remise =  factureDao.getRemiseBetweenDates(client, fin, debut);
                    //Double value = Double.parseDouble(detailFactureArtDao.getCustumerAchatBetweenDates(client, fin, debut)+"");
                    //System.out.println("REMISE : " + value);
                    return 0;
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

            HhtClient client = clientDao.findByCustumerNumber(code.trim());
            CustumResponse resp = new CustumResponse();
            if (client != null) {
                if (PasswordUtils.getKeyFromClient(client.getCodeClt().trim()).trim().equals(password)) {
                    Calendar cal = Calendar.getInstance();
                    List<VenteItem> items = factureDao.getHistoriqueVente(client, cal.get(Calendar.YEAR));
                    System.out.println("LE RESULTAT : " + (VenteItem) items.get(0));
                    return items;
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
    public VentesResult getVentesInfosByClient(String code, String password) throws PdvException {
        try {

            client = clientDao.findByCustumerNumber(code.trim());
            CustumResponse resp = new CustumResponse();
            if (client != null) {
                if (PasswordUtils.getKeyFromClient(client.getCodeClt().trim()).trim().equals(password)) {
                    Calendar cal;
                    Date debut, fin;
                    

                    /*Calcul de remise*/
                    cal = Calendar.getInstance();
                    debut = cal.getTime();
                    cal = Calendar.getInstance();
                    cal.setTime(debut);
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                    cal.set(Calendar.MINUTE, 0);
                    //cal.add(Calendar.MONTH, -1);
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    fin = cal.getTime();
                    // System.out.println("MES DATTESSSS : " + " debut = " + debut + " fin = " + fin);
                    //int value = detailFactureArtDao.getCustumerAchatBetweenDates(client, fin, debut);

                    cal = Calendar.getInstance();
                    //cal.setTime(debut);
                    cal.set(Calendar.HOUR_OF_DAY, 23);
                    cal.set(Calendar.MINUTE, 59);
                    cal.set(Calendar.SECOND, 59);
                    debut = cal.getTime();
                    System.out.println("MES DATTESSSS : " + " debut = " + debut + " fin = " + fin);
                    /**************************************************************************************************************/
                    ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
                    ventesMois = new ArrayList<>();
                    ventesJour = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        int rang = i;
                        Runnable worker = new MyRunnable(rang, client);
                        executor.execute(worker);
                    }
                    executor.shutdown();
                    // Wait until all threads are finish
                    while (!executor.isTerminated()) {

                    }
                    System.out.println("\nFinished all threads");
                    VentesResult ventes = new VentesResult();
                    ventes.setRemise(remise == null ? 0 : remise);
                    ventes.setRemisePasse(remisePasse == null ? 0 : remisePasse);
                    ventes.setChiffreAffaire(chiffreAffaire == null ? 0 : chiffreAffaire);
                    ventes.setDateDebutRemise(fin);
                    ventes.setDateFinRemise(debut);
                    ventes.setVentesMois(ventesMois);
                    ventes.setVentesJours(ventesJour);
                  
                    
                    /********************************************************************/
                /*    remise = factureDao.getRemiseBetweenDates(client, fin, debut);

                    remisePasse = factureDao.getRemiseMoisPasse(client);

                    chiffreAffaire = factureDao.getAchatsBetweenDates(client, fin, debut);
                    /* Calcul de l'hitorique de vente*/
                /*   cal = Calendar.getInstance();
                    List<VenteItem> itemBiere = factureDao.getHistoriqueVenteByTypeProduit(client, cal.get(Calendar.YEAR), "BIERE");

                    List<VenteItem> itemBg = factureDao.getHistoriqueVenteByTypeProduit(client, cal.get(Calendar.YEAR), "BG");
                    List<VenteItem> itemPet = factureDao.getHistoriqueVenteByTypeProduit(client, cal.get(Calendar.YEAR), "PET");
                    cal = Calendar.getInstance();
                    /* To remove after*/
                /*   List<VenteJourItem> itemsBiere = factureDao.getHistoriqueJourVenteByTypeProduit(client, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, "BIERE");
                    List<VenteJourItem> itemsBG = factureDao.getHistoriqueJourVenteByTypeProduit(client, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, "BG");
                    List<VenteJourItem> itemsPET = factureDao.getHistoriqueJourVenteByTypeProduit(client, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, "PET");
                    //    System.out.println("LE RESULTAT : " + (VenteItem)items.get(0) );
                    VentesInfos result = new VentesInfos();
                 
                    List<VenteItem> itemBiere2 = equilibrateMois(itemBiere);
                    List<VenteItem> itemBg2 = equilibrateMois(itemBg);
                    List<VenteItem> itemPet2 = equilibrateMois(itemPet);
                    List<VenteJourItem> itemsBG2 = equilibrate(itemsBG);
                    List<VenteJourItem> itemsBiere2 = equilibrate(itemsBiere);
                    List<VenteJourItem> itemsPET2 = equilibrate(itemsPET);

                    VentesResult ventes = new VentesResult();
                    ventes.setRemise(remise == null ? 0 : remise);
                    ventes.setRemisePasse(remisePasse == null ? 0 : remisePasse);
                    ventes.setChiffreAffaire(chiffreAffaire == null ? 0 : chiffreAffaire);
                    ventes.setDateDebutRemise(fin);
                    ventes.setDateFinRemise(debut);
                     List<Vente> ventesMois = new ArrayList<>();
                    for (int i = 0; i < itemBiere2.size(); i++) {
                        Vente vente = new Vente();
                        vente.setDate(itemBiere2.get(i).getMois());
                        vente.setQuantiteBiere(itemBiere2.get(i).getQuantite());
                        vente.setChiffreBierre(itemBiere2.get(i).getChiffre());
                        vente.setQuantiteBg(itemBg2.get(i).getQuantite());
                        vente.setChiffreBg(itemBg2.get(i).getChiffre());
                        vente.setQuantitePet(itemPet2.get(i).getQuantite());
                        vente.setChiffrePet(itemPet2.get(i).getChiffre());
                        ventesMois.add(vente);
                    }
                    ventes.setVentesMois(ventesMois);
                    List<Vente> ventesJour = new ArrayList<>();
                    for (int i = 0; i < itemsBiere2.size(); i++) {
                        Vente vente = new Vente();
                        vente.setDate(itemsBiere2.get(i).getJour());
                        vente.setQuantiteBiere(itemsBiere2.get(i).getQuantite());
                        vente.setChiffreBierre(itemsBiere2.get(i).getChiffre());
                        vente.setQuantiteBg(itemsBG2.get(i).getQuantite());
                        vente.setChiffreBg(itemsBG2.get(i).getChiffre());
                        vente.setQuantitePet(itemsPET2.get(i).getQuantite());
                        vente.setChiffrePet(itemsPET2.get(i).getChiffre());
                        ventesJour.add(vente);
                    }
                    ventes.setVentesJours(ventesJour);
                  */
                    return ventes;
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

    private List<VenteJourItem> equilibrate(List<VenteJourItem> items) {
        Calendar cal;
        cal = Calendar.getInstance();

        int jour = cal.get(Calendar.DAY_OF_MONTH);

        List<VenteJourItem> result = new ArrayList<>();
        for (VenteJourItem item : items) {
            result.add(item);
        }
        for (int i = 1; i <= jour; i++) {
            if (!dateExistInList(i, items)) {
                result.add(new VenteJourItem(0, i, "", 0));
            }
        }

        Collections.sort(result, new Comparator<VenteJourItem>() {
            @Override
            public int compare(VenteJourItem o1, VenteJourItem o2) {
                return o1.getJour() - o2.getJour();
            }
        });

        return result;
    }

    private List<VenteItem> equilibrateMois(List<VenteItem> items) {
        Calendar cal;
        cal = Calendar.getInstance();

        int jour = cal.get(Calendar.MONTH) + 1;

        List<VenteItem> result = new ArrayList<>();

        for (VenteItem item : items) {
            result.add(item);
        }
        for (int i = 1; i <= jour; i++) {
            if (!dateExistInListMois(i, items)) {
                result.add(new VenteItem(0, i, 0, ""));
            }
        }

        Collections.sort(result, new Comparator<VenteItem>() {
            @Override
            public int compare(VenteItem o1, VenteItem o2) {
                return o1.getMois() - o2.getMois();
            }
        });
        return result;
    }

    private boolean dateExistInList(int jour, List<VenteJourItem> items) {
        for (VenteJourItem item : items) {
            if (item.getJour() == jour) {
                return true;
            }
        }
        return false;
    }

    private boolean dateExistInListMois(int jour, List<VenteItem> items) {
        for (VenteItem item : items) {
            if (item.getMois() == jour) {
                return true;
            }
        }
        return false;
    }

    /*
    @Override
    public void generatePassword() throws PdvException {
        try {
            try {
                List<HhtClient> clients = clientDao.findAllActive();
                HhtClientCredentials credentials;
                for (HhtClient client : clients) {
                    credentials = credentialsDao.findByCustomer(client);
                    if (credentials == null) {
                        credentials = new HhtClientCredentials();
                        credentials.setActive(1);
                        credentials.setClient(client.getCodeClt());
                        credentials.setDateCreation(new Date());
                        credentials.setPassword(PasswordUtils.getKeyFromClient(client.getCodeClt().trim()).trim());
                        credentialsDao.save(credentials);
                    }
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        
        
    }
     */
    @Override
    public List<HhtClient> getAllByCircuit(String circuit) throws PdvException {
        try {
            return clientDao.findAllByCircuitActive(circuit);
        } catch (Exception e) {
        }
        return Collections.EMPTY_LIST;
    }

    class MyRunnable implements Runnable {

        private final int rang;
        private final HhtClient client;
        Calendar cal;

        MyRunnable(int rang, HhtClient client) {
            this.rang = rang;
            this.client = client;
        }

        @Override
        public void run() {
            // premire possibilité
            if (this.rang == 0) {
                getRemise();
            }
            if (this.rang == 1) {
                getRemisePasse();
            }
            if (this.rang == 2) {
                getChiffreAffaire();
            }
            if (this.rang == 3) {
                histoMois();
            }
            if (this.rang == 4) {
                histoJour();
            }
        }

        public void getRemise() {
            // premier service ...
            // resultat dans une variable global result1
            Date debut, fin;
            /*Calcul de remise*/

            cal = Calendar.getInstance();
            debut = cal.getTime();
            cal = Calendar.getInstance();
            cal.setTime(debut);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            //cal.add(Calendar.MONTH, -1);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            fin = cal.getTime();
            // System.out.println("MES DATTESSSS : " + " debut = " + debut + " fin = " + fin);
            //int value = detailFactureArtDao.getCustumerAchatBetweenDates(client, fin, debut);

            cal = Calendar.getInstance();
            //cal.setTime(debut);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            debut = cal.getTime();
            remise = factureDao.getRemiseBetweenDates(client, fin, debut);
            
        }

        public void getRemisePasse() {
            // deuxieme service ...
            // resultat dans une variable global result2

            remisePasse = factureDao.getRemiseMoisPasse(client);
            
        }

        public void getChiffreAffaire() {
            // troisieme service ...
            // resultat dans une variable global result3
            Date debut, fin;
            /*Calcul de remise*/

            cal = Calendar.getInstance();
            debut = cal.getTime();
            cal = Calendar.getInstance();
            cal.setTime(debut);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            //cal.add(Calendar.MONTH, -1);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            fin = cal.getTime();
            // System.out.println("MES DATTESSSS : " + " debut = " + debut + " fin = " + fin);
            //int value = detailFactureArtDao.getCustumerAchatBetweenDates(client, fin, debut);

            cal = Calendar.getInstance();
            //cal.setTime(debut);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            debut = cal.getTime();
            chiffreAffaire = factureDao.getAchatsBetweenDates(client, fin, debut);
            
        }

        public void histoMois() {
            // troisieme service ...
            // resultat dans une variable global result3
            /* Calcul de l'hitorique de vente*/
            cal = Calendar.getInstance();
            List<VenteItem> itemBiere = factureDao.getHistoriqueVenteByTypeProduit(client, cal.get(Calendar.YEAR), "BIERE");
            List<VenteItem> itemBg = factureDao.getHistoriqueVenteByTypeProduit(client, cal.get(Calendar.YEAR), "BG");
            List<VenteItem> itemPet = factureDao.getHistoriqueVenteByTypeProduit(client, cal.get(Calendar.YEAR), "PET");
            List<VenteItem> itemBiere2 = equilibrateMois(itemBiere);
            List<VenteItem> itemBg2 = equilibrateMois(itemBg);
            List<VenteItem> itemPet2 = equilibrateMois(itemPet);
            for (int i = 0; i < itemBiere2.size(); i++) {
                Vente vente = new Vente();
                vente.setDate(itemBiere2.get(i).getMois());
                vente.setQuantiteBiere(itemBiere2.get(i).getQuantite());
                vente.setChiffreBierre(itemBiere2.get(i).getChiffre());
                vente.setQuantiteBg(itemBg2.get(i).getQuantite());
                vente.setChiffreBg(itemBg2.get(i).getChiffre());
                vente.setQuantitePet(itemPet2.get(i).getQuantite());
                vente.setChiffrePet(itemPet2.get(i).getChiffre());
                ventesMois.add(vente);
            }
            
        }

        public void histoJour() {
            // troisieme service ...
            // resultat dans une variable global result3
            cal = Calendar.getInstance();
            /* To remove after*/
            List<VenteJourItem> itemsBiere = factureDao.getHistoriqueJourVenteByTypeProduit(client, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, "BIERE");
            List<VenteJourItem> itemsBG = factureDao.getHistoriqueJourVenteByTypeProduit(client, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, "BG");
            List<VenteJourItem> itemsPET = factureDao.getHistoriqueJourVenteByTypeProduit(client, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, "PET");
            List<VenteJourItem> itemsBG2 = equilibrate(itemsBG);
            List<VenteJourItem> itemsBiere2 = equilibrate(itemsBiere);
            List<VenteJourItem> itemsPET2 = equilibrate(itemsPET);
            for (int i = 0; i < itemsBiere2.size(); i++) {
                Vente vente = new Vente();
                vente.setDate(itemsBiere2.get(i).getJour());
                vente.setQuantiteBiere(itemsBiere2.get(i).getQuantite());
                vente.setChiffreBierre(itemsBiere2.get(i).getChiffre());
                vente.setQuantiteBg(itemsBG2.get(i).getQuantite());
                vente.setChiffreBg(itemsBG2.get(i).getChiffre());
                vente.setQuantitePet(itemsPET2.get(i).getQuantite());
                vente.setChiffrePet(itemsPET2.get(i).getChiffre());
                ventesJour.add(vente);
            }
            
        }
    }
}
