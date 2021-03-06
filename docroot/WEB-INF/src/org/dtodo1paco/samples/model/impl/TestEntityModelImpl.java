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

package org.dtodo1paco.samples.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ContainerModel;
import com.liferay.portal.model.TrashedModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.trash.model.TrashEntry;
import com.liferay.portlet.trash.service.TrashEntryLocalServiceUtil;

import org.dtodo1paco.samples.model.TestEntity;
import org.dtodo1paco.samples.model.TestEntityModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TestEntity service. Represents a row in the &quot;TEST_TestEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.dtodo1paco.samples.model.TestEntityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TestEntityImpl}.
 * </p>
 *
 * @author dtodo1paco
 * @see TestEntityImpl
 * @see org.dtodo1paco.samples.model.TestEntity
 * @see org.dtodo1paco.samples.model.TestEntityModel
 * @generated
 */
public class TestEntityModelImpl extends BaseModelImpl<TestEntity>
	implements TestEntityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a TestEntity model instance should use the {@link org.dtodo1paco.samples.model.TestEntity} interface instead.
	 */
	public static final String TABLE_NAME = "TEST_TestEntity";
	public static final Object[][] TABLE_COLUMNS = {
			{ "itemId", Types.BIGINT },
			{ "itemKey", Types.VARCHAR },
			{ "itemCompanyId", Types.BIGINT },
			{ "itemGroupId", Types.BIGINT },
			{ "itemCreatorUserId", Types.BIGINT },
			{ "itemCreateDate", Types.TIMESTAMP },
			{ "itemLastModifiedDate", Types.TIMESTAMP },
			{ "itemStatus", Types.VARCHAR },
			{ "TestStringField", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table TEST_TestEntity (itemId LONG not null primary key,itemKey VARCHAR(75) null,itemCompanyId LONG,itemGroupId LONG,itemCreatorUserId LONG,itemCreateDate DATE null,itemLastModifiedDate DATE null,itemStatus VARCHAR(75) null,TestStringField VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table TEST_TestEntity";
	public static final String ORDER_BY_JPQL = " ORDER BY testEntity.itemLastModifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY TEST_TestEntity.itemLastModifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.dtodo1paco.samples.model.TestEntity"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.dtodo1paco.samples.model.TestEntity"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.dtodo1paco.samples.model.TestEntity"),
			true);
	public static long ITEMCOMPANYID_COLUMN_BITMASK = 1L;
	public static long ITEMGROUPID_COLUMN_BITMASK = 2L;
	public static long ITEMKEY_COLUMN_BITMASK = 4L;
	public static long ITEMSTATUS_COLUMN_BITMASK = 8L;
	public static long ITEMLASTMODIFIEDDATE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.dtodo1paco.samples.model.TestEntity"));

	public TestEntityModelImpl() {
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

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	@Override
	public String getItemKey() {
		if (_itemKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _itemKey;
		}
	}

	@Override
	public void setItemKey(String itemKey) {
		_columnBitmask |= ITEMKEY_COLUMN_BITMASK;

		if (_originalItemKey == null) {
			_originalItemKey = _itemKey;
		}

		_itemKey = itemKey;
	}

	public String getOriginalItemKey() {
		return GetterUtil.getString(_originalItemKey);
	}

	@Override
	public long getItemCompanyId() {
		return _itemCompanyId;
	}

	@Override
	public void setItemCompanyId(long itemCompanyId) {
		_columnBitmask |= ITEMCOMPANYID_COLUMN_BITMASK;

		if (!_setOriginalItemCompanyId) {
			_setOriginalItemCompanyId = true;

			_originalItemCompanyId = _itemCompanyId;
		}

		_itemCompanyId = itemCompanyId;
	}

	public long getOriginalItemCompanyId() {
		return _originalItemCompanyId;
	}

	@Override
	public long getItemGroupId() {
		return _itemGroupId;
	}

	@Override
	public void setItemGroupId(long itemGroupId) {
		_columnBitmask |= ITEMGROUPID_COLUMN_BITMASK;

		if (!_setOriginalItemGroupId) {
			_setOriginalItemGroupId = true;

			_originalItemGroupId = _itemGroupId;
		}

		_itemGroupId = itemGroupId;
	}

	public long getOriginalItemGroupId() {
		return _originalItemGroupId;
	}

	@Override
	public long getItemCreatorUserId() {
		return _itemCreatorUserId;
	}

	@Override
	public void setItemCreatorUserId(long itemCreatorUserId) {
		_itemCreatorUserId = itemCreatorUserId;
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
	}

	@Override
	public Date getItemLastModifiedDate() {
		return _itemLastModifiedDate;
	}

	@Override
	public void setItemLastModifiedDate(Date itemLastModifiedDate) {
		_columnBitmask = -1L;

		_itemLastModifiedDate = itemLastModifiedDate;
	}

	@Override
	public String getItemStatus() {
		if (_itemStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _itemStatus;
		}
	}

	@Override
	public void setItemStatus(String itemStatus) {
		_columnBitmask |= ITEMSTATUS_COLUMN_BITMASK;

		if (_originalItemStatus == null) {
			_originalItemStatus = _itemStatus;
		}

		_itemStatus = itemStatus;
	}

	public String getOriginalItemStatus() {
		return GetterUtil.getString(_originalItemStatus);
	}

	@Override
	public String getTestStringField() {
		if (_TestStringField == null) {
			return StringPool.BLANK;
		}
		else {
			return _TestStringField;
		}
	}

	@Override
	public void setTestStringField(String TestStringField) {
		_TestStringField = TestStringField;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TestEntity.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TestEntity toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TestEntity)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TestEntityImpl testEntityImpl = new TestEntityImpl();

		testEntityImpl.setItemId(getItemId());
		testEntityImpl.setItemKey(getItemKey());
		testEntityImpl.setItemCompanyId(getItemCompanyId());
		testEntityImpl.setItemGroupId(getItemGroupId());
		testEntityImpl.setItemCreatorUserId(getItemCreatorUserId());
		testEntityImpl.setItemCreateDate(getItemCreateDate());
		testEntityImpl.setItemLastModifiedDate(getItemLastModifiedDate());
		testEntityImpl.setItemStatus(getItemStatus());
		testEntityImpl.setTestStringField(getTestStringField());

		testEntityImpl.resetOriginalValues();

		return testEntityImpl;
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

		if (!(obj instanceof TestEntity)) {
			return false;
		}

		TestEntity testEntity = (TestEntity)obj;

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
	public void resetOriginalValues() {
		TestEntityModelImpl testEntityModelImpl = this;

		testEntityModelImpl._originalItemKey = testEntityModelImpl._itemKey;

		testEntityModelImpl._originalItemCompanyId = testEntityModelImpl._itemCompanyId;

		testEntityModelImpl._setOriginalItemCompanyId = false;

		testEntityModelImpl._originalItemGroupId = testEntityModelImpl._itemGroupId;

		testEntityModelImpl._setOriginalItemGroupId = false;

		testEntityModelImpl._originalItemStatus = testEntityModelImpl._itemStatus;

		testEntityModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TestEntity> toCacheModel() {
		TestEntityCacheModel testEntityCacheModel = new TestEntityCacheModel();

		testEntityCacheModel.itemId = getItemId();

		testEntityCacheModel.itemKey = getItemKey();

		String itemKey = testEntityCacheModel.itemKey;

		if ((itemKey != null) && (itemKey.length() == 0)) {
			testEntityCacheModel.itemKey = null;
		}

		testEntityCacheModel.itemCompanyId = getItemCompanyId();

		testEntityCacheModel.itemGroupId = getItemGroupId();

		testEntityCacheModel.itemCreatorUserId = getItemCreatorUserId();

		Date itemCreateDate = getItemCreateDate();

		if (itemCreateDate != null) {
			testEntityCacheModel.itemCreateDate = itemCreateDate.getTime();
		}
		else {
			testEntityCacheModel.itemCreateDate = Long.MIN_VALUE;
		}

		Date itemLastModifiedDate = getItemLastModifiedDate();

		if (itemLastModifiedDate != null) {
			testEntityCacheModel.itemLastModifiedDate = itemLastModifiedDate.getTime();
		}
		else {
			testEntityCacheModel.itemLastModifiedDate = Long.MIN_VALUE;
		}

		testEntityCacheModel.itemStatus = getItemStatus();

		String itemStatus = testEntityCacheModel.itemStatus;

		if ((itemStatus != null) && (itemStatus.length() == 0)) {
			testEntityCacheModel.itemStatus = null;
		}

		testEntityCacheModel.TestStringField = getTestStringField();

		String TestStringField = testEntityCacheModel.TestStringField;

		if ((TestStringField != null) && (TestStringField.length() == 0)) {
			testEntityCacheModel.TestStringField = null;
		}

		return testEntityCacheModel;
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

	private static ClassLoader _classLoader = TestEntity.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TestEntity.class
		};
	private long _itemId;
	private String _itemKey;
	private String _originalItemKey;
	private long _itemCompanyId;
	private long _originalItemCompanyId;
	private boolean _setOriginalItemCompanyId;
	private long _itemGroupId;
	private long _originalItemGroupId;
	private boolean _setOriginalItemGroupId;
	private long _itemCreatorUserId;
	private String _itemCreatorUserUuid;
	private Date _itemCreateDate;
	private Date _itemLastModifiedDate;
	private String _itemStatus;
	private String _originalItemStatus;
	private String _TestStringField;
	private long _columnBitmask;
	private TestEntity _escapedModel;
}