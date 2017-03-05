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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author dtodo1paco
 * @generated
 */
public class TestEntitySoap implements Serializable {
	public static TestEntitySoap toSoapModel(TestEntity model) {
		TestEntitySoap soapModel = new TestEntitySoap();

		soapModel.setItemId(model.getItemId());
		soapModel.setItemKey(model.getItemKey());
		soapModel.setItemCompanyId(model.getItemCompanyId());
		soapModel.setItemGroupId(model.getItemGroupId());
		soapModel.setItemCreatorUserId(model.getItemCreatorUserId());
		soapModel.setItemCreateDate(model.getItemCreateDate());
		soapModel.setItemLastModifiedDate(model.getItemLastModifiedDate());
		soapModel.setItemStatus(model.getItemStatus());
		soapModel.setTestStringField(model.getTestStringField());

		return soapModel;
	}

	public static TestEntitySoap[] toSoapModels(TestEntity[] models) {
		TestEntitySoap[] soapModels = new TestEntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TestEntitySoap[][] toSoapModels(TestEntity[][] models) {
		TestEntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TestEntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TestEntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TestEntitySoap[] toSoapModels(List<TestEntity> models) {
		List<TestEntitySoap> soapModels = new ArrayList<TestEntitySoap>(models.size());

		for (TestEntity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TestEntitySoap[soapModels.size()]);
	}

	public TestEntitySoap() {
	}

	public long getPrimaryKey() {
		return _itemId;
	}

	public void setPrimaryKey(long pk) {
		setItemId(pk);
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public String getItemKey() {
		return _itemKey;
	}

	public void setItemKey(String itemKey) {
		_itemKey = itemKey;
	}

	public long getItemCompanyId() {
		return _itemCompanyId;
	}

	public void setItemCompanyId(long itemCompanyId) {
		_itemCompanyId = itemCompanyId;
	}

	public long getItemGroupId() {
		return _itemGroupId;
	}

	public void setItemGroupId(long itemGroupId) {
		_itemGroupId = itemGroupId;
	}

	public long getItemCreatorUserId() {
		return _itemCreatorUserId;
	}

	public void setItemCreatorUserId(long itemCreatorUserId) {
		_itemCreatorUserId = itemCreatorUserId;
	}

	public Date getItemCreateDate() {
		return _itemCreateDate;
	}

	public void setItemCreateDate(Date itemCreateDate) {
		_itemCreateDate = itemCreateDate;
	}

	public Date getItemLastModifiedDate() {
		return _itemLastModifiedDate;
	}

	public void setItemLastModifiedDate(Date itemLastModifiedDate) {
		_itemLastModifiedDate = itemLastModifiedDate;
	}

	public String getItemStatus() {
		return _itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		_itemStatus = itemStatus;
	}

	public String getTestStringField() {
		return _TestStringField;
	}

	public void setTestStringField(String TestStringField) {
		_TestStringField = TestStringField;
	}

	private long _itemId;
	private String _itemKey;
	private long _itemCompanyId;
	private long _itemGroupId;
	private long _itemCreatorUserId;
	private Date _itemCreateDate;
	private Date _itemLastModifiedDate;
	private String _itemStatus;
	private String _TestStringField;
}