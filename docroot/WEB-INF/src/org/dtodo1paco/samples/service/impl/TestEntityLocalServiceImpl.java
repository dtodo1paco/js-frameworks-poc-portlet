/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.dtodo1paco.samples.service.impl;

import java.util.Date;

import javax.xml.bind.ValidationException;

import org.dtodo1paco.samples.model.TestEntity;
import org.dtodo1paco.samples.service.base.TestEntityLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the TestEntity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.dtodo1paco.samples.service.TestEntityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author dtodo1paco
 * @see org.dtodo1paco.samples.service.base.TestEntityLocalServiceBaseImpl
 * @see org.dtodo1paco.samples.service.TestEntityLocalServiceUtil
 */
public class TestEntityLocalServiceImpl extends TestEntityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.dtodo1paco.samples.service.TestEntityLocalServiceUtil} to access the TestEntity local service.
	 */
	public TestEntity addTest(JSONObject properties, ServiceContext serviceContext) throws SystemException {
		TestEntity newEntity = null;
		Exception ex = null;
		try {
			validate(properties);
			newEntity = testEntityPersistence.create(
				counterLocalService.increment(TestEntity.class.getName()));
			newEntity.setItemCompanyId(serviceContext.getCompanyId());
			newEntity.setItemCreateDate(new Date());
			newEntity.setItemCreatorUserId(serviceContext.getUserId());
			newEntity.setItemGroupId(serviceContext.getScopeGroupId());
			String testEntityText = properties.getString("testEntityText");
			newEntity.setItemKey("key_" + testEntityText);
			newEntity.setTestStringField(testEntityText);
			testEntityPersistence.update(newEntity);
		} catch (ValidationException e) {
			_log.error("Invalid entity [" + properties+ "]: " + e.getMessage(), e);
			ex = e;
		} catch (SystemException e) {
			_log.error("Unable to create entity [" + properties+ "]. ServiceContext: " + serviceContext, e);
			ex = e;
		}
		if (newEntity == null) {
			throw new SystemException("Unable to create new TestEntity",ex);
		}
		return newEntity;
	}
	
	private void validate(JSONObject properties) throws ValidationException {
		if (properties == null) throw new ValidationException("Properties cannot be null");
		if (properties.length() < 1) throw new ValidationException("Empty object received");
	}
	
	private static final Log _log = LogFactoryUtil
			.getLog(TestEntityLocalServiceImpl.class);
}