/**
 * 
 */
package com.bracongo.sqlservertest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bracongo.sqlservertest.dao.SpringDaoConfig;
import com.bracongo.sqlservertest.data.SpringPersistenceConfig;
import com.bracongo.sqlservertest.service.SpringServiceConfig;

/**
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 *
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan({ "com.bracongo.sqlservertest.dao", "com.bracongo.sqlservertest.service", "com.bracongo.sqlservertest.test",
		"com.bracongo.sqlservertest.controller" })
@Import({ SpringPersistenceConfig.class, SpringDaoConfig.class, SpringServiceConfig.class })

public class SpringGlobalConfig {

}
