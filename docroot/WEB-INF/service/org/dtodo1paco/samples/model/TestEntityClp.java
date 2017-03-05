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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.ContainerModel;
import com.liferay.portal.model.TrashedModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.trash.model.TrashEntry;
import com.liferay.portlet.trash.service.TrashEntryLocalServiceUtil;

import org.dtodo1paco.samples.service.ClpSerializer;
import org.dtodo1paco.samples.service.TestEntityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dtodo1paco
 */
public class TestEntityClp extends BaseModelImpl<TestEntity>
	implements TestEntity {
	public TestEntityClp() {
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
	public long getPrimaryKey() {
		return _itemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;

		if (_testEntityRemoteModel != null) {
			try {
				Class<?> clazz = _testEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setItemId", long.class);

				method.invoke(_testEntityRemoteModel, itemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemKey() {
		return _itemKey;
	}

	@Override
	public void setItemKey(String itemKey) {
		_itemKey = itemKey;

		if (_testEntityRemoteModel != null) {
			try {
				Class<?> clazz = _testEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setItemKey", String.class);

				method.invoke(_testEntityRemoteModel, itemKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemCompanyId() {
		return _itemCompanyId;
	}

	@Override
	public void setItemCompanyId(long itemCompanyId) {
		_itemCompanyId = itemCompanyId;

		if (_testEntityRemoteModel != null) {
			try {
				Class<?> clazz = _testEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCompanyId", long.class);

				method.invoke(_testEntityRemoteModel, itemCompanyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemGroupId() {
		return _itemGroupId;
	}

	@Override
	public void setItemGroupId(long itemGroupId) {
		_itemGroupId = itemGroupId;

		if (_testEntityRemoteModel != null) {
			try {
				Class<?> clazz = _testEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setItemGroupId", long.class);

				method.invoke(_testEntityRemoteModel, itemGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemCreatorUserId() {
		return _itemCreatorUserId;
	}

	@Override
	public void setItemCreatorUserId(long itemCreatorUserId) {
		_itemCreatorUserId = itemCreatorUserId;

		if (_testEntityRemoteModel != null) {
			try {
				Class<?> clazz = _testEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCreatorUserId",
						long.class);

				method.invoke(_testEntityRemoteModel, itemCreatorUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemCreatorUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getItemCreatorUserId(), "uuid",
			_itemCreatorUserUuid);
	}

	@Override
	public void setItemCreatorUserUuid(String itemCreatorUserUuid) {
		_itemCreatorUserUuid = itemCreatorUserUuid;
	}

	@Override
	public Date getItemCreateDate() {
		return _itemCreateDate;
	}

	@Override
	public void setItemCreateDate(Date itemCreateDate) {
		_itemCreateDate = itemCreateDate;

		if (_testEntityRemoteModel != null) {
			try {
				Class<?> clazz = _testEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setItemCreateDate", Date.class);

				method.invoke(_testEntityRemoteModel, itemCreateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getItemLastModifiedDate() {
		return _itemLastModifiedDate;
	}

	@Override
	public void setItemLastModifiedDate(Date itemLastModifiedDate) {
		_itemLastModifiedDate = itemLastModifiedDate;

		if (_testEntityRemoteModel != null) {
			try {
				Class<?> clazz = _testEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setItemLastModifiedDate",
						Date.class);

				method.invoke(_testEntityRemoteModel, itemLastModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemStatus() {
		return _itemStatus;
	}

	@Override
	public void setItemStatus(String itemStatus) {
		_itemStatus = itemStatus;

		if (_testEntityRemoteModel != null) {
			try {
				Class<?> clazz = _testEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setItemStatus", String.class);

				method.invoke(_testEntityRemoteModel, itemStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTestStringField() {
		return _TestStringField;
	}

	@Override
	public void setTestStringField(String TestStringField) {
		_TestStringField = TestStringField;

		if (_testEntityRemoteModel != null) {
			try {
				Class<?> clazz = _testEntityRemoteModel.getClass();

				Method method = clazz.getMethod("setTestStringField",
						String.class);

				method.invoke(_testEntityRemoteModel, TestStringField);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return 0;
	}

	@Override
	public TrashEntry getTrashEntry() throws PortalException, SystemException {
		if (!isInTrash()) {
			return null;
		}

		TrashEntry trashEntry = TrashEntryLocalServiceUtil.fetchEntry(getModelClassName(),
				getTrashEntryClassPK());

		if (trashEntry != null) {
			return trashEntry;
		}

		TrashHandler trashHandler = getTrashHandler();

		if (!Validator.isNull(trashHandler.getContainerModelClassName())) {
			ContainerModel containerModel = trashHandler.getParentContainerModel(this);

			while (containerModel != null) {
				if (containerModel instanceof TrashedModel) {
					TrashedModel trashedModel = (TrashedModel)containerModel;

					return trashedModel.getTrashEntry();
				}

				trashHandler = TrashHandlerRegistryUtil.getTrashHandler(trashHandler.getContainerModelClassName());

				if (trashHandler == null) {
					return null;
				}

				containerModel = trashHandler.getContainerModel(containerModel.getParentContainerModelId());
			}
		}

		return null;
	}

	@Override
	public long getTrashEntryClassPK() {
		return getPrimaryKey();
	}

	@Override
	public TrashHandler getTrashHandler() {
		return TrashHandlerRegistryUtil.getTrashHandler(getModelClassName());
	}

	@Override
	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInTrashContainer() {
		TrashHandler trashHandler = getTrashHandler();

		if ((trashHandler == null) ||
				Validator.isNull(trashHandler.getContainerModelClassName())) {
			return false;
		}

		try {
			ContainerModel containerModel = trashHandler.getParentContainerModel(this);

			if (containerModel == null) {
				return false;
			}

			if (containerModel instanceof TrashedModel) {
				return ((TrashedModel)containerModel).isInTrash();
			}
		}
		catch (Exception e) {
		}

		return false;
	}

	public BaseModel<?> getTestEntityRemoteModel() {
		return _testEntityRemoteModel;
	}

	public void setTestEntityRemoteModel(BaseModel<?> testEntityRemoteModel) {
		_testEntityRemoteModel = testEntityRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _testEntityRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_testEntityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TestEntityLocalServiceUtil.addTestEntity(this);
		}
		else {
			TestEntityLocalServiceUtil.updateTestEntity(this);
		}
	}

	@Override
	public TestEntity toEscapedModel() {
		return (TestEntity)ProxyUtil.newProxyInstance(TestEntity.class.getClassLoader(),
			new Class[] { TestEntity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TestEntityClp clone = new TestEntityClp();

		clone.setItemId(getItemId());
		clone.setItemKey(getItemKey());
		clone.setItemCompanyId(getItemCompanyId());
		clone.setItemGroupId(getItemGroupId());
		clone.setItemCreatorUserId(getItemCreatorUserId());
		clone.setItemCreateDate(getItemCreateDate());
		clone.setItemLastModifiedDate(getItemLastModifiedDate());
		clone.setItemStatus(getItemStatus());
		clone.setTestStringField(getTestStringField());

		return clone;
	}

	@Override
	public int compareTo(TestEntity testEntity) {
		int value = 0;

		value = DateUtil.compareTo(getItemLastModifiedDate(),
				testEntity.getItemLastModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestEntityClp)) {
			return false;
		}

		TestEntityClp testEntity = (TestEntityClp)obj;

		long primaryKey = testEntity.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{itemId=");
		sb.append(getItemId());
		sb.append(", itemKey=");
		sb.append(getItemKey());
		sb.append(", itemCompanyId=");
		sb.append(getItemCompanyId());
		sb.append(", itemGroupId=");
		sb.append(getItemGroupId());
		sb.append(", itemCreatorUserId=");
		sb.append(getItemCreatorUserId());
		sb.append(", itemCreateDate=");
		sb.append(getItemCreateDate());
		sb.append(", itemLastModifiedDate=");
		sb.append(getItemLastModifiedDate());
		sb.append(", itemStatus=");
		sb.append(getItemStatus());
		sb.append(", TestStringField=");
		sb.append(getTestStringField());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.dtodo1paco.samples.model.TestEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemKey</column-name><column-value><![CDATA[");
		sb.append(getItemKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCompanyId</column-name><column-value><![CDATA[");
		sb.append(getItemCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemGroupId</column-name><column-value><![CDATA[");
		sb.append(getItemGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCreatorUserId</column-name><column-value><![CDATA[");
		sb.append(getItemCreatorUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemCreateDate</column-name><column-value><![CDATA[");
		sb.append(getItemCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemLastModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getItemLastModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemStatus</column-name><column-value><![CDATA[");
		sb.append(getItemStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TestStringField</column-name><column-value><![CDATA[");
		sb.append(getTestStringField());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemId;
	private String _itemKey;
	private long _itemCompanyId;
	private long _itemGroupId;
	private long _itemCreatorUserId;
	private String _itemCreatorUserUuid;
	private Date _itemCreateDate;
	private Date _itemLastModifiedDate;
	private String _itemStatus;
	private String _TestStringField;
	private BaseModel<?> _testEntityRemoteModel;
}