package com.bracongo.sqlservertest.service.contract;

import com.bracongo.sqlservertest.entities.HhtPlainte;
import com.bracongo.sqlservertest.entities.projection.PlainteProjection;
import com.bracongo.sqlservertest.service.IGenericService;
import com.bracongo.sqlservertest.utils.Exceptions.PdvException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Transactional
public interface IHhtPlainteService extends IGenericService<HhtPlainte>{
    
    public void savePlainteFromWeb(PlainteProjection projection)  throws PdvException;
    
}
