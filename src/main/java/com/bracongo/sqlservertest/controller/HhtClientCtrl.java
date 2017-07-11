package com.bracongo.sqlservertest.controller;

import com.bracongo.sqlservertest.entities.HhtClient;
import com.bracongo.sqlservertest.entities.projection.CustumResponse;
import com.bracongo.sqlservertest.entities.projection.VenteItem;
import com.bracongo.sqlservertest.entities.projection.VentesInfos;
import com.bracongo.sqlservertest.service.contract.IHhtClientService;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import com.bracongo.sqlservertest.utils.Constants;
import com.bracongo.sqlservertest.utils.SharedResourcesProvider;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@RestController
public class HhtClientCtrl {
    
    private static final Logger logger = Logger.getLogger(HhtClientCtrl.class);
    private Map<String, Object> resultMap;
    private final Properties messageCtx = SharedResourcesProvider.getInstance().getFrontMessageCtx();
    private String errorMessage;

    @Autowired
    IHhtClientService clientService;
    
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public Map<String, Object> listPointsDeVente(@RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "1", value = "size") int size) {
        resultMap = new HashMap<String, Object>();
        try {
            Page<HhtClient> payload = clientService.getAllEntities(page, size);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, payload);

        } catch (PdvException tce) {
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, tce.getMessage().substring(tce.getMessage().lastIndexOf('-') + 1));
            logger.error(tce);

        } catch (Exception e) {
            errorMessage = MessageFormat.format(messageCtx.getProperty("THRAVVELCORESTATIONCTRL-002"), (Object) null);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, errorMessage.substring(errorMessage.lastIndexOf('-') + 1));
            logger.error(errorMessage, e);

        }
        return resultMap;
    }
    
     @RequestMapping(value = "/client/{numCompte}", method = RequestMethod.GET)
    public Map<String, Object> getByCustomerNumber(HttpServletRequest request, @PathVariable("numCompte") String numCompte) {
        resultMap = new HashMap<>();
        try {
            
            HhtClient client = clientService.findByCodeNumber(numCompte);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, client);
        } catch (PdvException ex) {
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, ex.getMessage().substring(ex.getMessage().lastIndexOf('-') + 1));
            logger.error(ex);
        } catch (Exception e) {
            errorMessage = MessageFormat.format(messageCtx.getProperty("THRAVVELCORESTATIONCTRL-001"), (Object) null);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, errorMessage.substring(errorMessage.lastIndexOf('-') + 1));
            logger.error(errorMessage, e);
        }
        return resultMap;

    }
    
    @RequestMapping(value = "/client/create/{numCompte}/{password}", method = RequestMethod.GET)
    public Map<String, Object> createCustomerAccount(HttpServletRequest request, @PathVariable("numCompte") String numCompte, @PathVariable("password") String password) {
        resultMap = new HashMap<>();
        try {
            
            CustumResponse response = clientService.createAccount(numCompte, password);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, response);
        } catch (PdvException ex) {
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, ex.getMessage().substring(ex.getMessage().lastIndexOf('-') + 1));
            logger.error(ex);
        } catch (Exception e) {
            errorMessage = MessageFormat.format(messageCtx.getProperty("THRAVVELCORESTATIONCTRL-001"), (Object) null);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, errorMessage.substring(errorMessage.lastIndexOf('-') + 1));
            logger.error(errorMessage, e);
        }
        return resultMap;

    }
    
    @RequestMapping(value = "/client/remise/{numCompte}/{password}", method = RequestMethod.GET)
    public Map<String, Object> getByCustomerRemise(HttpServletRequest request, @PathVariable("numCompte") String numCompte, @PathVariable("password") String password) {
        resultMap = new HashMap<>();
        try {
            
            double value = clientService.getRemiseMonth(numCompte, password);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, value);
        } catch (PdvException ex) {
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, ex.getMessage().substring(ex.getMessage().lastIndexOf('-') + 1));
            logger.error(ex);
        } catch (Exception e) {
            errorMessage = MessageFormat.format(messageCtx.getProperty("THRAVVELCORESTATIONCTRL-001"), (Object) null);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, errorMessage.substring(errorMessage.lastIndexOf('-') + 1));
            logger.error(errorMessage, e);
        }
        return resultMap;

    }
    
    @RequestMapping(value = "/client/histo/{numCompte}/{password}", method = RequestMethod.GET)
    public Map<String, Object> getByCustomerHistorique(HttpServletRequest request, @PathVariable("numCompte") String numCompte, @PathVariable("password") String password) {
        resultMap = new HashMap<>();
        try {
            
            List<VenteItem> items = clientService.getHistorique(numCompte, password);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, items);
        } catch (PdvException ex) {
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, ex.getMessage().substring(ex.getMessage().lastIndexOf('-') + 1));
            logger.error(ex);
        } catch (Exception e) {
            errorMessage = MessageFormat.format(messageCtx.getProperty("THRAVVELCORESTATIONCTRL-001"), (Object) null);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, errorMessage.substring(errorMessage.lastIndexOf('-') + 1));
            logger.error(errorMessage, e);
        }
        return resultMap;

    }
    
    @RequestMapping(value = "/client/ventes/{numCompte}/{password}", method = RequestMethod.GET)
    public Map<String, Object> getByCustomerVentesInfos(HttpServletRequest request, @PathVariable("numCompte") String numCompte, @PathVariable("password") String password) {
        resultMap = new HashMap<>();
        try {
            
            VentesInfos infos = clientService.getVentesInfosByClient(numCompte, password);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, infos);
        } catch (PdvException ex) {
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, ex.getMessage().substring(ex.getMessage().lastIndexOf('-') + 1));
            logger.error(ex);
        } catch (Exception e) {
            errorMessage = MessageFormat.format(messageCtx.getProperty("THRAVVELCORESTATIONCTRL-001"), (Object) null);
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, errorMessage.substring(errorMessage.lastIndexOf('-') + 1));
            logger.error(errorMessage, e);
        }
        return resultMap;
    }
    
}
