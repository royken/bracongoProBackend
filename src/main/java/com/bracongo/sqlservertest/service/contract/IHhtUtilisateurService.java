package com.bracongo.sqlservertest.service.contract;

import com.bracongo.sqlservertest.entities.HhtUtilisateur;
import com.bracongo.sqlservertest.service.IGenericService;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Transactional
public interface IHhtUtilisateurService extends IGenericService<HhtUtilisateur>{
    
    public HhtUtilisateur findByLoginAndPassword(String login, String password) throws PdvException;
    
}
