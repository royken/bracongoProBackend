/**
 * 
 */
package com.bracongo.sqlservertest.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 *
 */

public abstract class CommonService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8537206751107697L;

	@Autowired
	protected String errorMessagesFilePath;

	/**
	 * @param errorMessagesFilePath
	 *            the errorMessagesFilePath to set
	 */
	public void setErrorMessagesFilePath(String errorMessagesFilePath) {
		this.errorMessagesFilePath = errorMessagesFilePath;
	}

}
