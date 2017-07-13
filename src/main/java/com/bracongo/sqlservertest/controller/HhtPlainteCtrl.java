package com.bracongo.sqlservertest.controller;

import com.bracongo.sqlservertest.entities.projection.RequestAnswer;
import com.bracongo.sqlservertest.entities.projection.CommandeProjection;
import com.bracongo.sqlservertest.entities.projection.PlainteProjection;
import com.bracongo.sqlservertest.service.contract.IHhtPlainteService;
import com.bracongo.sqlservertest.utils.Constants;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import com.bracongo.sqlservertest.utils.SharedResourcesProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@RestController
public class HhtPlainteCtrl {
    
     private static final Logger logger = Logger.getLogger(HhtClientCtrl.class);
    private Map<String, Object> resultMap;
    private final Properties messageCtx = SharedResourcesProvider.getInstance().getFrontMessageCtx();
    private String errorMessage;
    
    @Autowired
    private IHhtPlainteService plainteService;
    
    @RequestMapping(value = "/plaintes/send", method = RequestMethod.POST)
    public Map<String, Object> sendCommand(HttpServletRequest request, @RequestBody PlainteProjection projection) {
        resultMap = new HashMap<>();
        RequestAnswer answer;
        try {
            plainteService.savePlainteFromWeb(projection);
            answer = new RequestAnswer();
            answer.setContenu("Plainte enregistrée");
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.TRUE);
            resultMap.put(Constants.JSON_PAYLOAD_KEY, answer);

        } catch (PdvException tce) {
            answer = new RequestAnswer();
            answer.setContenu("Erreur lors de l'envoie");
            resultMap.put(Constants.JSON_SUCCESS_KEY, Boolean.FALSE);
            resultMap.put(Constants.JSON_MESSAGE_KEY, answer);
            logger.error(tce);

        } 
        return resultMap;
    }
    
}
