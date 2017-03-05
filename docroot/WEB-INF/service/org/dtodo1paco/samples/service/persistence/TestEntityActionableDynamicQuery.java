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

package org.dtodo1paco.samples.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.dtodo1paco.samples.model.TestEntity;
import org.dtodo1paco.samples.service.TestEntityLocalServiceUtil;

/**
 * @author dtodo1paco
 * @generated
 */
public abstract class TestEntityActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public TestEntityActionableDynamicQuery() throws SystemException {
		setBaseLocalService(TestEntityLocalServiceUtil.getService());
		setClass(TestEntity.class);

		setClassLoader(org.dtodo1paco.samples.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("itemId");
	}
}