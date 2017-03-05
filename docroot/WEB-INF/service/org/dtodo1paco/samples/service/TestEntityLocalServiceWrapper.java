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

package org.dtodo1paco.samples.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TestEntityLocalService}.
 *
 * @author dtodo1paco
 * @see TestEntityLocalService
 * @generated
 */
public class TestEntityLocalServiceWrapper implements TestEntityLocalService,
	ServiceWrapper<TestEntityLocalService> {
	public TestEntityLocalServiceWrapper(
		TestEntityLocalService testEntityLocalService) {
		_testEntityLocalService = testEntityLocalService;
	}

	/**
	* Adds the TestEntity to the database. Also notifies the appropriate model listeners.
	*
	* @param testEntity the TestEntity
	* @return the TestEntity that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.dtodo1paco.samples.model.TestEntity addTestEntity(
		org.dtodo1paco.samples.model.TestEntity testEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.addTestEntity(testEntity);
	}

	/**
	* Creates a new TestEntity with the primary key. Does not add the TestEntity to the database.
	*
	* @param itemId the primary key for the new TestEntity
	* @return the new TestEntity
	*/
	@Override
	public org.dtodo1paco.samples.model.TestEntity createTestEntity(long itemId) {
		return _testEntityLocalService.createTestEntity(itemId);
	}

	/**
	* Deletes the TestEntity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the TestEntity
	* @return the TestEntity that was removed
	* @throws PortalException if a TestEntity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.dtodo1paco.samples.model.TestEntity deleteTestEntity(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.deleteTestEntity(itemId);
	}

	/**
	* Deletes the TestEntity from the database. Also notifies the appropriate model listeners.
	*
	* @param testEntity the TestEntity
	* @return the TestEntity that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.dtodo1paco.samples.model.TestEntity deleteTestEntity(
		org.dtodo1paco.samples.model.TestEntity testEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.deleteTestEntity(testEntity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _testEntityLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.dtodo1paco.samples.model.impl.TestEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.dtodo1paco.samples.model.impl.TestEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.dtodo1paco.samples.model.TestEntity fetchTestEntity(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.fetchTestEntity(itemId);
	}

	/**
	* Returns the TestEntity with the primary key.
	*
	* @param itemId the primary key of the TestEntity
	* @return the TestEntity
	* @throws PortalException if a TestEntity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.dtodo1paco.samples.model.TestEntity getTestEntity(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.getTestEntity(itemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the TestEntities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.dtodo1paco.samples.model.impl.TestEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of TestEntities
	* @param end the upper bound of the range of TestEntities (not inclusive)
	* @return the range of TestEntities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.dtodo1paco.samples.model.TestEntity> getTestEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.getTestEntities(start, end);
	}

	/**
	* Returns the number of TestEntities.
	*
	* @return the number of TestEntities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTestEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.getTestEntitiesCount();
	}

	/**
	* Updates the TestEntity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testEntity the TestEntity
	* @return the TestEntity that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.dtodo1paco.samples.model.TestEntity updateTestEntity(
		org.dtodo1paco.samples.model.TestEntity testEntity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.updateTestEntity(testEntity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _testEntityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_testEntityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _testEntityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.dtodo1paco.samples.model.TestEntity addTest(
		com.liferay.portal.kernel.json.JSONObject properties,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntityLocalService.addTest(properties, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TestEntityLocalService getWrappedTestEntityLocalService() {
		return _testEntityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTestEntityLocalService(
		TestEntityLocalService testEntityLocalService) {
		_testEntityLocalService = testEntityLocalService;
	}

	@Override
	public TestEntityLocalService getWrappedService() {
		return _testEntityLocalService;
	}

	@Override
	public void setWrappedService(TestEntityLocalService testEntityLocalService) {
		_testEntityLocalService = testEntityLocalService;
	}

	private TestEntityLocalService _testEntityLocalService;
}