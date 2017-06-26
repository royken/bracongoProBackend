package com.bracongo.sqlservertest.dao.specifications;

import com.bracongo.sqlservertest.entities.HhtClient;

/**
 *
 * @author vr.kenfack
 */
public interface IHhtClientDaoCriteria {
 
    public HhtClient getByCode(String code);
}
