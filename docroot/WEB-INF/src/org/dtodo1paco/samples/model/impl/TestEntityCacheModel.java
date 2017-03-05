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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.dtodo1paco.samples.model.TestEntity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TestEntity in entity cache.
 *
 * @author dtodo1paco
 * @see TestEntity
 * @generated
 */
public class TestEntityCacheModel implements CacheModel<TestEntity>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{itemId=");
		sb.append(itemId);
		sb.append(", itemKey=");
		sb.append(itemKey);
		sb.append(", itemCompanyId=");
		sb.append(itemCompanyId);
		sb.append(", itemGroupId=");
		sb.append(itemGroupId);
		sb.append(", itemCreatorUserId=");
		sb.append(itemCreatorUserId);
		sb.append(", itemCreateDate=");
		sb.append(itemCreateDate);
		sb.append(", itemLastModifiedDate=");
		sb.append(itemLastModifiedDate);
		sb.append(", itemStatus=");
		sb.append(itemStatus);
		sb.append(", TestStringField=");
		sb.append(TestStringField);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TestEntity toEntityModel() {
		TestEntityImpl testEntityImpl = new TestEntityImpl();

		testEntityImpl.setItemId(itemId);

		if (itemKey == null) {
			testEntityImpl.setItemKey(StringPool.BLANK);
		}
		else {
			testEntityImpl.setItemKey(itemKey);
		}

		testEntityImpl.setItemCompanyId(itemCompanyId);
		testEntityImpl.setItemGroupId(itemGroupId);
		testEntityImpl.setItemCreatorUserId(itemCreatorUserId);

		if (itemCreateDate == Long.MIN_VALUE) {
			testEntityImpl.setItemCreateDate(null);
		}
		else {
			testEntityImpl.setItemCreateDate(new Date(itemCreateDate));
		}

		if (itemLastModifiedDate == Long.MIN_VALUE) {
			testEntityImpl.setItemLastModifiedDate(null);
		}
		else {
			testEntityImpl.setItemLastModifiedDate(new Date(
					itemLastModifiedDate));
		}

		if (itemStatus == null) {
			testEntityImpl.setItemStatus(StringPool.BLANK);
		}
		else {
			testEntityImpl.setItemStatus(itemStatus);
		}

		if (TestStringField == null) {
			testEntityImpl.setTestStringField(StringPool.BLANK);
		}
		else {
			testEntityImpl.setTestStringField(TestStringField);
		}

		testEntityImpl.resetOriginalValues();

		return testEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemId = objectInput.readLong();
		itemKey = objectInput.readUTF();
		itemCompanyId = objectInput.readLong();
		itemGroupId = objectInput.readLong();
		itemCreatorUserId = objectInput.readLong();
		itemCreateDate = objectInput.readLong();
		itemLastModifiedDate = objectInput.readLong();
		itemStatus = objectInput.readUTF();
		TestStringField = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemId);

		if (itemKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemKey);
		}

		objectOutput.writeLong(itemCompanyId);
		objectOutput.writeLong(itemGroupId);
		objectOutput.writeLong(itemCreatorUserId);
		objectOutput.writeLong(itemCreateDate);
		objectOutput.writeLong(itemLastModifiedDate);

		if (itemStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemStatus);
		}

		if (TestStringField == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TestStringField);
		}
	}

	public long itemId;
	public String itemKey;
	public long itemCompanyId;
	public long itemGroupId;
	public long itemCreatorUserId;
	public long itemCreateDate;
	public long itemLastModifiedDate;
	public String itemStatus;
	public String TestStringField;
}