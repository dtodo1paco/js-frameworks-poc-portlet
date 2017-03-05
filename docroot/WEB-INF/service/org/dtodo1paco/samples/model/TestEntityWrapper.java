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

package org.dtodo1paco.samples.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TestEntity}.
 * </p>
 *
 * @author dtodo1paco
 * @see TestEntity
 * @generated
 */
public class TestEntityWrapper implements TestEntity, ModelWrapper<TestEntity> {
	public TestEntityWrapper(TestEntity testEntity) {
		_testEntity = testEntity;
	}

	@Override
	public Class<?> getModelClass() {
		return TestEntity.class;
	}

	@Override
	public String getModelClassName() {
		return TestEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("itemKey", getItemKey());
		attributes.put("itemCompanyId", getItemCompanyId());
		attributes.put("itemGroupId", getItemGroupId());
		attributes.put("itemCreatorUserId", getItemCreatorUserId());
		attributes.put("itemCreateDate", getItemCreateDate());
		attributes.put("itemLastModifiedDate", getItemLastModifiedDate());
		attributes.put("itemStatus", getItemStatus());
		attributes.put("TestStringField", getTestStringField());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		String itemKey = (String)attributes.get("itemKey");

		if (itemKey != null) {
			setItemKey(itemKey);
		}

		Long itemCompanyId = (Long)attributes.get("itemCompanyId");

		if (itemCompanyId != null) {
			setItemCompanyId(itemCompanyId);
		}

		Long itemGroupId = (Long)attributes.get("itemGroupId");

		if (itemGroupId != null) {
			setItemGroupId(itemGroupId);
		}

		Long itemCreatorUserId = (Long)attributes.get("itemCreatorUserId");

		if (itemCreatorUserId != null) {
			setItemCreatorUserId(itemCreatorUserId);
		}

		Date itemCreateDate = (Date)attributes.get("itemCreateDate");

		if (itemCreateDate != null) {
			setItemCreateDate(itemCreateDate);
		}

		Date itemLastModifiedDate = (Date)attributes.get("itemLastModifiedDate");

		if (itemLastModifiedDate != null) {
			setItemLastModifiedDate(itemLastModifiedDate);
		}

		String itemStatus = (String)attributes.get("itemStatus");

		if (itemStatus != null) {
			setItemStatus(itemStatus);
		}

		String TestStringField = (String)attributes.get("TestStringField");

		if (TestStringField != null) {
			setTestStringField(TestStringField);
		}
	}

	/**
	* Returns the primary key of this TestEntity.
	*
	* @return the primary key of this TestEntity
	*/
	@Override
	public long getPrimaryKey() {
		return _testEntity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this TestEntity.
	*
	* @param primaryKey the primary key of this TestEntity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_testEntity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item ID of this TestEntity.
	*
	* @return the item ID of this TestEntity
	*/
	@Override
	public long getItemId() {
		return _testEntity.getItemId();
	}

	/**
	* Sets the item ID of this TestEntity.
	*
	* @param itemId the item ID of this TestEntity
	*/
	@Override
	public void setItemId(long itemId) {
		_testEntity.setItemId(itemId);
	}

	/**
	* Returns the item key of this TestEntity.
	*
	* @return the item key of this TestEntity
	*/
	@Override
	public java.lang.String getItemKey() {
		return _testEntity.getItemKey();
	}

	/**
	* Sets the item key of this TestEntity.
	*
	* @param itemKey the item key of this TestEntity
	*/
	@Override
	public void setItemKey(java.lang.String itemKey) {
		_testEntity.setItemKey(itemKey);
	}

	/**
	* Returns the item company ID of this TestEntity.
	*
	* @return the item company ID of this TestEntity
	*/
	@Override
	public long getItemCompanyId() {
		return _testEntity.getItemCompanyId();
	}

	/**
	* Sets the item company ID of this TestEntity.
	*
	* @param itemCompanyId the item company ID of this TestEntity
	*/
	@Override
	public void setItemCompanyId(long itemCompanyId) {
		_testEntity.setItemCompanyId(itemCompanyId);
	}

	/**
	* Returns the item group ID of this TestEntity.
	*
	* @return the item group ID of this TestEntity
	*/
	@Override
	public long getItemGroupId() {
		return _testEntity.getItemGroupId();
	}

	/**
	* Sets the item group ID of this TestEntity.
	*
	* @param itemGroupId the item group ID of this TestEntity
	*/
	@Override
	public void setItemGroupId(long itemGroupId) {
		_testEntity.setItemGroupId(itemGroupId);
	}

	/**
	* Returns the item creator user ID of this TestEntity.
	*
	* @return the item creator user ID of this TestEntity
	*/
	@Override
	public long getItemCreatorUserId() {
		return _testEntity.getItemCreatorUserId();
	}

	/**
	* Sets the item creator user ID of this TestEntity.
	*
	* @param itemCreatorUserId the item creator user ID of this TestEntity
	*/
	@Override
	public void setItemCreatorUserId(long itemCreatorUserId) {
		_testEntity.setItemCreatorUserId(itemCreatorUserId);
	}

	/**
	* Returns the item creator user uuid of this TestEntity.
	*
	* @return the item creator user uuid of this TestEntity
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getItemCreatorUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _testEntity.getItemCreatorUserUuid();
	}

	/**
	* Sets the item creator user uuid of this TestEntity.
	*
	* @param itemCreatorUserUuid the item creator user uuid of this TestEntity
	*/
	@Override
	public void setItemCreatorUserUuid(java.lang.String itemCreatorUserUuid) {
		_testEntity.setItemCreatorUserUuid(itemCreatorUserUuid);
	}

	/**
	* Returns the item create date of this TestEntity.
	*
	* @return the item create date of this TestEntity
	*/
	@Override
	public java.util.Date getItemCreateDate() {
		return _testEntity.getItemCreateDate();
	}

	/**
	* Sets the item create date of this TestEntity.
	*
	* @param itemCreateDate the item create date of this TestEntity
	*/
	@Override
	public void setItemCreateDate(java.util.Date itemCreateDate) {
		_testEntity.setItemCreateDate(itemCreateDate);
	}

	/**
	* Returns the item last modified date of this TestEntity.
	*
	* @return the item last modified date of this TestEntity
	*/
	@Override
	public java.util.Date getItemLastModifiedDate() {
		return _testEntity.getItemLastModifiedDate();
	}

	/**
	* Sets the item last modified date of this TestEntity.
	*
	* @param itemLastModifiedDate the item last modified date of this TestEntity
	*/
	@Override
	public void setItemLastModifiedDate(java.util.Date itemLastModifiedDate) {
		_testEntity.setItemLastModifiedDate(itemLastModifiedDate);
	}

	/**
	* Returns the item status of this TestEntity.
	*
	* @return the item status of this TestEntity
	*/
	@Override
	public java.lang.String getItemStatus() {
		return _testEntity.getItemStatus();
	}

	/**
	* Sets the item status of this TestEntity.
	*
	* @param itemStatus the item status of this TestEntity
	*/
	@Override
	public void setItemStatus(java.lang.String itemStatus) {
		_testEntity.setItemStatus(itemStatus);
	}

	/**
	* Returns the test string field of this TestEntity.
	*
	* @return the test string field of this TestEntity
	*/
	@Override
	public java.lang.String getTestStringField() {
		return _testEntity.getTestStringField();
	}

	/**
	* Sets the test string field of this TestEntity.
	*
	* @param TestStringField the test string field of this TestEntity
	*/
	@Override
	public void setTestStringField(java.lang.String TestStringField) {
		_testEntity.setTestStringField(TestStringField);
	}

	/**
	* Returns the status of this TestEntity.
	*
	* @return the status of this TestEntity
	*/
	@Override
	public int getStatus() {
		return _testEntity.getStatus();
	}

	/**
	* Returns the trash entry created when this TestEntity was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this TestEntity.
	*
	* @return the trash entry created when this TestEntity was moved to the Recycle Bin
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.portlet.trash.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _testEntity.getTrashEntry();
	}

	/**
	* Returns the class primary key of the trash entry for this TestEntity.
	*
	* @return the class primary key of the trash entry for this TestEntity
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _testEntity.getTrashEntryClassPK();
	}

	/**
	* Returns the trash handler for this TestEntity.
	*
	* @return the trash handler for this TestEntity
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _testEntity.getTrashHandler();
	}

	/**
	* Returns <code>true</code> if this TestEntity is in the Recycle Bin.
	*
	* @return <code>true</code> if this TestEntity is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _testEntity.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this TestEntity is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this TestEntity is in the Recycle Bin; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean isInTrashContainer() {
		return _testEntity.isInTrashContainer();
	}

	@Override
	public boolean isNew() {
		return _testEntity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_testEntity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _testEntity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_testEntity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _testEntity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _testEntity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_testEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _testEntity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_testEntity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_testEntity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_testEntity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TestEntityWrapper((TestEntity)_testEntity.clone());
	}

	@Override
	public int compareTo(org.dtodo1paco.samples.model.TestEntity testEntity) {
		return _testEntity.compareTo(testEntity);
	}

	@Override
	public int hashCode() {
		return _testEntity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.dtodo1paco.samples.model.TestEntity> toCacheModel() {
		return _testEntity.toCacheModel();
	}

	@Override
	public org.dtodo1paco.samples.model.TestEntity toEscapedModel() {
		return new TestEntityWrapper(_testEntity.toEscapedModel());
	}

	@Override
	public org.dtodo1paco.samples.model.TestEntity toUnescapedModel() {
		return new TestEntityWrapper(_testEntity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _testEntity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _testEntity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_testEntity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestEntityWrapper)) {
			return false;
		}

		TestEntityWrapper testEntityWrapper = (TestEntityWrapper)obj;

		if (Validator.equals(_testEntity, testEntityWrapper._testEntity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TestEntity getWrappedTestEntity() {
		return _testEntity;
	}

	@Override
	public TestEntity getWrappedModel() {
		return _testEntity;
	}

	@Override
	public void resetOriginalValues() {
		_testEntity.resetOriginalValues();
	}

	private TestEntity _testEntity;
}