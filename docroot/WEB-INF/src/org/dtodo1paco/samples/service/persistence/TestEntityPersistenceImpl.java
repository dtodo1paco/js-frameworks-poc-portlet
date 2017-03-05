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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.dtodo1paco.samples.NoSuchTestEntityException;
import org.dtodo1paco.samples.model.TestEntity;
import org.dtodo1paco.samples.model.impl.TestEntityImpl;
import org.dtodo1paco.samples.model.impl.TestEntityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the TestEntity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dtodo1paco
 * @see TestEntityPersistence
 * @see TestEntityUtil
 * @generated
 */
public class TestEntityPersistenceImpl extends BasePersistenceImpl<TestEntity>
	implements TestEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TestEntityUtil} to access the TestEntity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TestEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_K = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_K",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			TestEntityModelImpl.ITEMCOMPANYID_COLUMN_BITMASK |
			TestEntityModelImpl.ITEMGROUPID_COLUMN_BITMASK |
			TestEntityModelImpl.ITEMKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_K = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_K",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the TestEntity where itemCompanyId = &#63; and itemGroupId = &#63; and itemKey = &#63; or throws a {@link org.dtodo1paco.samples.NoSuchTestEntityException} if it could not be found.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemKey the item key
	 * @return the matching TestEntity
	 * @throws org.dtodo1paco.samples.NoSuchTestEntityException if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity findByC_G_K(long itemCompanyId, long itemGroupId,
		String itemKey) throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = fetchByC_G_K(itemCompanyId, itemGroupId, itemKey);

		if (testEntity == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("itemCompanyId=");
			msg.append(itemCompanyId);

			msg.append(", itemGroupId=");
			msg.append(itemGroupId);

			msg.append(", itemKey=");
			msg.append(itemKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTestEntityException(msg.toString());
		}

		return testEntity;
	}

	/**
	 * Returns the TestEntity where itemCompanyId = &#63; and itemGroupId = &#63; and itemKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemKey the item key
	 * @return the matching TestEntity, or <code>null</code> if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity fetchByC_G_K(long itemCompanyId, long itemGroupId,
		String itemKey) throws SystemException {
		return fetchByC_G_K(itemCompanyId, itemGroupId, itemKey, true);
	}

	/**
	 * Returns the TestEntity where itemCompanyId = &#63; and itemGroupId = &#63; and itemKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemKey the item key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching TestEntity, or <code>null</code> if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity fetchByC_G_K(long itemCompanyId, long itemGroupId,
		String itemKey, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { itemCompanyId, itemGroupId, itemKey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_K,
					finderArgs, this);
		}

		if (result instanceof TestEntity) {
			TestEntity testEntity = (TestEntity)result;

			if ((itemCompanyId != testEntity.getItemCompanyId()) ||
					(itemGroupId != testEntity.getItemGroupId()) ||
					!Validator.equals(itemKey, testEntity.getItemKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TESTENTITY_WHERE);

			query.append(_FINDER_COLUMN_C_G_K_ITEMCOMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_K_ITEMGROUPID_2);

			boolean bindItemKey = false;

			if (itemKey == null) {
				query.append(_FINDER_COLUMN_C_G_K_ITEMKEY_1);
			}
			else if (itemKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_K_ITEMKEY_3);
			}
			else {
				bindItemKey = true;

				query.append(_FINDER_COLUMN_C_G_K_ITEMKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemCompanyId);

				qPos.add(itemGroupId);

				if (bindItemKey) {
					qPos.add(itemKey);
				}

				List<TestEntity> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_K,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TestEntityPersistenceImpl.fetchByC_G_K(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TestEntity testEntity = list.get(0);

					result = testEntity;

					cacheResult(testEntity);

					if ((testEntity.getItemCompanyId() != itemCompanyId) ||
							(testEntity.getItemGroupId() != itemGroupId) ||
							(testEntity.getItemKey() == null) ||
							!testEntity.getItemKey().equals(itemKey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_K,
							finderArgs, testEntity);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_K,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TestEntity)result;
		}
	}

	/**
	 * Removes the TestEntity where itemCompanyId = &#63; and itemGroupId = &#63; and itemKey = &#63; from the database.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemKey the item key
	 * @return the TestEntity that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity removeByC_G_K(long itemCompanyId, long itemGroupId,
		String itemKey) throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = findByC_G_K(itemCompanyId, itemGroupId, itemKey);

		return remove(testEntity);
	}

	/**
	 * Returns the number of TestEntities where itemCompanyId = &#63; and itemGroupId = &#63; and itemKey = &#63;.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemKey the item key
	 * @return the number of matching TestEntities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_K(long itemCompanyId, long itemGroupId, String itemKey)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_K;

		Object[] finderArgs = new Object[] { itemCompanyId, itemGroupId, itemKey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TESTENTITY_WHERE);

			query.append(_FINDER_COLUMN_C_G_K_ITEMCOMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_K_ITEMGROUPID_2);

			boolean bindItemKey = false;

			if (itemKey == null) {
				query.append(_FINDER_COLUMN_C_G_K_ITEMKEY_1);
			}
			else if (itemKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_K_ITEMKEY_3);
			}
			else {
				bindItemKey = true;

				query.append(_FINDER_COLUMN_C_G_K_ITEMKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemCompanyId);

				qPos.add(itemGroupId);

				if (bindItemKey) {
					qPos.add(itemKey);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_G_K_ITEMCOMPANYID_2 = "testEntity.itemCompanyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_K_ITEMGROUPID_2 = "testEntity.itemGroupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_K_ITEMKEY_1 = "testEntity.itemKey IS NULL";
	private static final String _FINDER_COLUMN_C_G_K_ITEMKEY_2 = "testEntity.itemKey = ?";
	private static final String _FINDER_COLUMN_C_G_K_ITEMKEY_3 = "(testEntity.itemKey IS NULL OR testEntity.itemKey = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_G_S = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			TestEntityModelImpl.ITEMCOMPANYID_COLUMN_BITMASK |
			TestEntityModelImpl.ITEMGROUPID_COLUMN_BITMASK |
			TestEntityModelImpl.ITEMSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G_S = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the TestEntity where itemCompanyId = &#63; and itemGroupId = &#63; and itemStatus = &#63; or throws a {@link org.dtodo1paco.samples.NoSuchTestEntityException} if it could not be found.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemStatus the item status
	 * @return the matching TestEntity
	 * @throws org.dtodo1paco.samples.NoSuchTestEntityException if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity findByC_G_S(long itemCompanyId, long itemGroupId,
		String itemStatus) throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = fetchByC_G_S(itemCompanyId, itemGroupId,
				itemStatus);

		if (testEntity == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("itemCompanyId=");
			msg.append(itemCompanyId);

			msg.append(", itemGroupId=");
			msg.append(itemGroupId);

			msg.append(", itemStatus=");
			msg.append(itemStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTestEntityException(msg.toString());
		}

		return testEntity;
	}

	/**
	 * Returns the TestEntity where itemCompanyId = &#63; and itemGroupId = &#63; and itemStatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemStatus the item status
	 * @return the matching TestEntity, or <code>null</code> if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity fetchByC_G_S(long itemCompanyId, long itemGroupId,
		String itemStatus) throws SystemException {
		return fetchByC_G_S(itemCompanyId, itemGroupId, itemStatus, true);
	}

	/**
	 * Returns the TestEntity where itemCompanyId = &#63; and itemGroupId = &#63; and itemStatus = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemStatus the item status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching TestEntity, or <code>null</code> if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity fetchByC_G_S(long itemCompanyId, long itemGroupId,
		String itemStatus, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				itemCompanyId, itemGroupId, itemStatus
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_G_S,
					finderArgs, this);
		}

		if (result instanceof TestEntity) {
			TestEntity testEntity = (TestEntity)result;

			if ((itemCompanyId != testEntity.getItemCompanyId()) ||
					(itemGroupId != testEntity.getItemGroupId()) ||
					!Validator.equals(itemStatus, testEntity.getItemStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TESTENTITY_WHERE);

			query.append(_FINDER_COLUMN_C_G_S_ITEMCOMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_S_ITEMGROUPID_2);

			boolean bindItemStatus = false;

			if (itemStatus == null) {
				query.append(_FINDER_COLUMN_C_G_S_ITEMSTATUS_1);
			}
			else if (itemStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_S_ITEMSTATUS_3);
			}
			else {
				bindItemStatus = true;

				query.append(_FINDER_COLUMN_C_G_S_ITEMSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemCompanyId);

				qPos.add(itemGroupId);

				if (bindItemStatus) {
					qPos.add(itemStatus);
				}

				List<TestEntity> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TestEntityPersistenceImpl.fetchByC_G_S(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TestEntity testEntity = list.get(0);

					result = testEntity;

					cacheResult(testEntity);

					if ((testEntity.getItemCompanyId() != itemCompanyId) ||
							(testEntity.getItemGroupId() != itemGroupId) ||
							(testEntity.getItemStatus() == null) ||
							!testEntity.getItemStatus().equals(itemStatus)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S,
							finderArgs, testEntity);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_S,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TestEntity)result;
		}
	}

	/**
	 * Removes the TestEntity where itemCompanyId = &#63; and itemGroupId = &#63; and itemStatus = &#63; from the database.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemStatus the item status
	 * @return the TestEntity that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity removeByC_G_S(long itemCompanyId, long itemGroupId,
		String itemStatus) throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = findByC_G_S(itemCompanyId, itemGroupId,
				itemStatus);

		return remove(testEntity);
	}

	/**
	 * Returns the number of TestEntities where itemCompanyId = &#63; and itemGroupId = &#63; and itemStatus = &#63;.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param itemStatus the item status
	 * @return the number of matching TestEntities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G_S(long itemCompanyId, long itemGroupId,
		String itemStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_S;

		Object[] finderArgs = new Object[] {
				itemCompanyId, itemGroupId, itemStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TESTENTITY_WHERE);

			query.append(_FINDER_COLUMN_C_G_S_ITEMCOMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_S_ITEMGROUPID_2);

			boolean bindItemStatus = false;

			if (itemStatus == null) {
				query.append(_FINDER_COLUMN_C_G_S_ITEMSTATUS_1);
			}
			else if (itemStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_G_S_ITEMSTATUS_3);
			}
			else {
				bindItemStatus = true;

				query.append(_FINDER_COLUMN_C_G_S_ITEMSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemCompanyId);

				qPos.add(itemGroupId);

				if (bindItemStatus) {
					qPos.add(itemStatus);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_G_S_ITEMCOMPANYID_2 = "testEntity.itemCompanyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_S_ITEMGROUPID_2 = "testEntity.itemGroupId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_S_ITEMSTATUS_1 = "testEntity.itemStatus IS NULL";
	private static final String _FINDER_COLUMN_C_G_S_ITEMSTATUS_2 = "testEntity.itemStatus = ?";
	private static final String _FINDER_COLUMN_C_G_S_ITEMSTATUS_3 = "(testEntity.itemStatus IS NULL OR testEntity.itemStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, TestEntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			TestEntityModelImpl.ITEMCOMPANYID_COLUMN_BITMASK |
			TestEntityModelImpl.ITEMGROUPID_COLUMN_BITMASK |
			TestEntityModelImpl.ITEMLASTMODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the TestEntities where itemCompanyId = &#63; and itemGroupId = &#63;.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @return the matching TestEntities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestEntity> findByC_G(long itemCompanyId, long itemGroupId)
		throws SystemException {
		return findByC_G(itemCompanyId, itemGroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the TestEntities where itemCompanyId = &#63; and itemGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.dtodo1paco.samples.model.impl.TestEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param start the lower bound of the range of TestEntities
	 * @param end the upper bound of the range of TestEntities (not inclusive)
	 * @return the range of matching TestEntities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestEntity> findByC_G(long itemCompanyId, long itemGroupId,
		int start, int end) throws SystemException {
		return findByC_G(itemCompanyId, itemGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the TestEntities where itemCompanyId = &#63; and itemGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.dtodo1paco.samples.model.impl.TestEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param start the lower bound of the range of TestEntities
	 * @param end the upper bound of the range of TestEntities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching TestEntities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestEntity> findByC_G(long itemCompanyId, long itemGroupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] { itemCompanyId, itemGroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
			finderArgs = new Object[] {
					itemCompanyId, itemGroupId,
					
					start, end, orderByComparator
				};
		}

		List<TestEntity> list = (List<TestEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TestEntity testEntity : list) {
				if ((itemCompanyId != testEntity.getItemCompanyId()) ||
						(itemGroupId != testEntity.getItemGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TESTENTITY_WHERE);

			query.append(_FINDER_COLUMN_C_G_ITEMCOMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_ITEMGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TestEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemCompanyId);

				qPos.add(itemGroupId);

				if (!pagination) {
					list = (List<TestEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TestEntity>(list);
				}
				else {
					list = (List<TestEntity>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first TestEntity in the ordered set where itemCompanyId = &#63; and itemGroupId = &#63;.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching TestEntity
	 * @throws org.dtodo1paco.samples.NoSuchTestEntityException if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity findByC_G_First(long itemCompanyId, long itemGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = fetchByC_G_First(itemCompanyId, itemGroupId,
				orderByComparator);

		if (testEntity != null) {
			return testEntity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemCompanyId=");
		msg.append(itemCompanyId);

		msg.append(", itemGroupId=");
		msg.append(itemGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestEntityException(msg.toString());
	}

	/**
	 * Returns the first TestEntity in the ordered set where itemCompanyId = &#63; and itemGroupId = &#63;.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching TestEntity, or <code>null</code> if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity fetchByC_G_First(long itemCompanyId, long itemGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TestEntity> list = findByC_G(itemCompanyId, itemGroupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last TestEntity in the ordered set where itemCompanyId = &#63; and itemGroupId = &#63;.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching TestEntity
	 * @throws org.dtodo1paco.samples.NoSuchTestEntityException if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity findByC_G_Last(long itemCompanyId, long itemGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = fetchByC_G_Last(itemCompanyId, itemGroupId,
				orderByComparator);

		if (testEntity != null) {
			return testEntity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("itemCompanyId=");
		msg.append(itemCompanyId);

		msg.append(", itemGroupId=");
		msg.append(itemGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTestEntityException(msg.toString());
	}

	/**
	 * Returns the last TestEntity in the ordered set where itemCompanyId = &#63; and itemGroupId = &#63;.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching TestEntity, or <code>null</code> if a matching TestEntity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity fetchByC_G_Last(long itemCompanyId, long itemGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_G(itemCompanyId, itemGroupId);

		if (count == 0) {
			return null;
		}

		List<TestEntity> list = findByC_G(itemCompanyId, itemGroupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the TestEntities before and after the current TestEntity in the ordered set where itemCompanyId = &#63; and itemGroupId = &#63;.
	 *
	 * @param itemId the primary key of the current TestEntity
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next TestEntity
	 * @throws org.dtodo1paco.samples.NoSuchTestEntityException if a TestEntity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity[] findByC_G_PrevAndNext(long itemId, long itemCompanyId,
		long itemGroupId, OrderByComparator orderByComparator)
		throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = findByPrimaryKey(itemId);

		Session session = null;

		try {
			session = openSession();

			TestEntity[] array = new TestEntityImpl[3];

			array[0] = getByC_G_PrevAndNext(session, testEntity, itemCompanyId,
					itemGroupId, orderByComparator, true);

			array[1] = testEntity;

			array[2] = getByC_G_PrevAndNext(session, testEntity, itemCompanyId,
					itemGroupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TestEntity getByC_G_PrevAndNext(Session session,
		TestEntity testEntity, long itemCompanyId, long itemGroupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TESTENTITY_WHERE);

		query.append(_FINDER_COLUMN_C_G_ITEMCOMPANYID_2);

		query.append(_FINDER_COLUMN_C_G_ITEMGROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TestEntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(itemCompanyId);

		qPos.add(itemGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(testEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TestEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the TestEntities where itemCompanyId = &#63; and itemGroupId = &#63; from the database.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_G(long itemCompanyId, long itemGroupId)
		throws SystemException {
		for (TestEntity testEntity : findByC_G(itemCompanyId, itemGroupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(testEntity);
		}
	}

	/**
	 * Returns the number of TestEntities where itemCompanyId = &#63; and itemGroupId = &#63;.
	 *
	 * @param itemCompanyId the item company ID
	 * @param itemGroupId the item group ID
	 * @return the number of matching TestEntities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_G(long itemCompanyId, long itemGroupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

		Object[] finderArgs = new Object[] { itemCompanyId, itemGroupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TESTENTITY_WHERE);

			query.append(_FINDER_COLUMN_C_G_ITEMCOMPANYID_2);

			query.append(_FINDER_COLUMN_C_G_ITEMGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(itemCompanyId);

				qPos.add(itemGroupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_G_ITEMCOMPANYID_2 = "testEntity.itemCompanyId = ? AND ";
	private static final String _FINDER_COLUMN_C_G_ITEMGROUPID_2 = "testEntity.itemGroupId = ?";

	public TestEntityPersistenceImpl() {
		setModelClass(TestEntity.class);
	}

	/**
	 * Caches the TestEntity in the entity cache if it is enabled.
	 *
	 * @param testEntity the TestEntity
	 */
	@Override
	public void cacheResult(TestEntity testEntity) {
		EntityCacheUtil.putResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityImpl.class, testEntity.getPrimaryKey(), testEntity);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_K,
			new Object[] {
				testEntity.getItemCompanyId(), testEntity.getItemGroupId(),
				testEntity.getItemKey()
			}, testEntity);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S,
			new Object[] {
				testEntity.getItemCompanyId(), testEntity.getItemGroupId(),
				testEntity.getItemStatus()
			}, testEntity);

		testEntity.resetOriginalValues();
	}

	/**
	 * Caches the TestEntities in the entity cache if it is enabled.
	 *
	 * @param testEntities the TestEntities
	 */
	@Override
	public void cacheResult(List<TestEntity> testEntities) {
		for (TestEntity testEntity : testEntities) {
			if (EntityCacheUtil.getResult(
						TestEntityModelImpl.ENTITY_CACHE_ENABLED,
						TestEntityImpl.class, testEntity.getPrimaryKey()) == null) {
				cacheResult(testEntity);
			}
			else {
				testEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all TestEntities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TestEntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TestEntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the TestEntity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TestEntity testEntity) {
		EntityCacheUtil.removeResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityImpl.class, testEntity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(testEntity);
	}

	@Override
	public void clearCache(List<TestEntity> testEntities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TestEntity testEntity : testEntities) {
			EntityCacheUtil.removeResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
				TestEntityImpl.class, testEntity.getPrimaryKey());

			clearUniqueFindersCache(testEntity);
		}
	}

	protected void cacheUniqueFindersCache(TestEntity testEntity) {
		if (testEntity.isNew()) {
			Object[] args = new Object[] {
					testEntity.getItemCompanyId(), testEntity.getItemGroupId(),
					testEntity.getItemKey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_K, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_K, args,
				testEntity);

			args = new Object[] {
					testEntity.getItemCompanyId(), testEntity.getItemGroupId(),
					testEntity.getItemStatus()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_S, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S, args,
				testEntity);
		}
		else {
			TestEntityModelImpl testEntityModelImpl = (TestEntityModelImpl)testEntity;

			if ((testEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_K.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testEntity.getItemCompanyId(),
						testEntity.getItemGroupId(), testEntity.getItemKey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_K, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_K, args,
					testEntity);
			}

			if ((testEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testEntity.getItemCompanyId(),
						testEntity.getItemGroupId(), testEntity.getItemStatus()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_G_S, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_G_S, args,
					testEntity);
			}
		}
	}

	protected void clearUniqueFindersCache(TestEntity testEntity) {
		TestEntityModelImpl testEntityModelImpl = (TestEntityModelImpl)testEntity;

		Object[] args = new Object[] {
				testEntity.getItemCompanyId(), testEntity.getItemGroupId(),
				testEntity.getItemKey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_K, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_K, args);

		if ((testEntityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_K.getColumnBitmask()) != 0) {
			args = new Object[] {
					testEntityModelImpl.getOriginalItemCompanyId(),
					testEntityModelImpl.getOriginalItemGroupId(),
					testEntityModelImpl.getOriginalItemKey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_K, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_K, args);
		}

		args = new Object[] {
				testEntity.getItemCompanyId(), testEntity.getItemGroupId(),
				testEntity.getItemStatus()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_S, args);

		if ((testEntityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_G_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					testEntityModelImpl.getOriginalItemCompanyId(),
					testEntityModelImpl.getOriginalItemGroupId(),
					testEntityModelImpl.getOriginalItemStatus()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_S, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_G_S, args);
		}
	}

	/**
	 * Creates a new TestEntity with the primary key. Does not add the TestEntity to the database.
	 *
	 * @param itemId the primary key for the new TestEntity
	 * @return the new TestEntity
	 */
	@Override
	public TestEntity create(long itemId) {
		TestEntity testEntity = new TestEntityImpl();

		testEntity.setNew(true);
		testEntity.setPrimaryKey(itemId);

		return testEntity;
	}

	/**
	 * Removes the TestEntity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemId the primary key of the TestEntity
	 * @return the TestEntity that was removed
	 * @throws org.dtodo1paco.samples.NoSuchTestEntityException if a TestEntity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity remove(long itemId)
		throws NoSuchTestEntityException, SystemException {
		return remove((Serializable)itemId);
	}

	/**
	 * Removes the TestEntity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the TestEntity
	 * @return the TestEntity that was removed
	 * @throws org.dtodo1paco.samples.NoSuchTestEntityException if a TestEntity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity remove(Serializable primaryKey)
		throws NoSuchTestEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TestEntity testEntity = (TestEntity)session.get(TestEntityImpl.class,
					primaryKey);

			if (testEntity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTestEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(testEntity);
		}
		catch (NoSuchTestEntityException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TestEntity removeImpl(TestEntity testEntity)
		throws SystemException {
		testEntity = toUnwrappedModel(testEntity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(testEntity)) {
				testEntity = (TestEntity)session.get(TestEntityImpl.class,
						testEntity.getPrimaryKeyObj());
			}

			if (testEntity != null) {
				session.delete(testEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (testEntity != null) {
			clearCache(testEntity);
		}

		return testEntity;
	}

	@Override
	public TestEntity updateImpl(
		org.dtodo1paco.samples.model.TestEntity testEntity)
		throws SystemException {
		testEntity = toUnwrappedModel(testEntity);

		boolean isNew = testEntity.isNew();

		TestEntityModelImpl testEntityModelImpl = (TestEntityModelImpl)testEntity;

		Session session = null;

		try {
			session = openSession();

			if (testEntity.isNew()) {
				session.save(testEntity);

				testEntity.setNew(false);
			}
			else {
				session.merge(testEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TestEntityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((testEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						testEntityModelImpl.getOriginalItemCompanyId(),
						testEntityModelImpl.getOriginalItemGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);

				args = new Object[] {
						testEntityModelImpl.getItemCompanyId(),
						testEntityModelImpl.getItemGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
					args);
			}
		}

		EntityCacheUtil.putResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
			TestEntityImpl.class, testEntity.getPrimaryKey(), testEntity);

		clearUniqueFindersCache(testEntity);
		cacheUniqueFindersCache(testEntity);

		return testEntity;
	}

	protected TestEntity toUnwrappedModel(TestEntity testEntity) {
		if (testEntity instanceof TestEntityImpl) {
			return testEntity;
		}

		TestEntityImpl testEntityImpl = new TestEntityImpl();

		testEntityImpl.setNew(testEntity.isNew());
		testEntityImpl.setPrimaryKey(testEntity.getPrimaryKey());

		testEntityImpl.setItemId(testEntity.getItemId());
		testEntityImpl.setItemKey(testEntity.getItemKey());
		testEntityImpl.setItemCompanyId(testEntity.getItemCompanyId());
		testEntityImpl.setItemGroupId(testEntity.getItemGroupId());
		testEntityImpl.setItemCreatorUserId(testEntity.getItemCreatorUserId());
		testEntityImpl.setItemCreateDate(testEntity.getItemCreateDate());
		testEntityImpl.setItemLastModifiedDate(testEntity.getItemLastModifiedDate());
		testEntityImpl.setItemStatus(testEntity.getItemStatus());
		testEntityImpl.setTestStringField(testEntity.getTestStringField());

		return testEntityImpl;
	}

	/**
	 * Returns the TestEntity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the TestEntity
	 * @return the TestEntity
	 * @throws org.dtodo1paco.samples.NoSuchTestEntityException if a TestEntity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTestEntityException, SystemException {
		TestEntity testEntity = fetchByPrimaryKey(primaryKey);

		if (testEntity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTestEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return testEntity;
	}

	/**
	 * Returns the TestEntity with the primary key or throws a {@link org.dtodo1paco.samples.NoSuchTestEntityException} if it could not be found.
	 *
	 * @param itemId the primary key of the TestEntity
	 * @return the TestEntity
	 * @throws org.dtodo1paco.samples.NoSuchTestEntityException if a TestEntity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity findByPrimaryKey(long itemId)
		throws NoSuchTestEntityException, SystemException {
		return findByPrimaryKey((Serializable)itemId);
	}

	/**
	 * Returns the TestEntity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the TestEntity
	 * @return the TestEntity, or <code>null</code> if a TestEntity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TestEntity testEntity = (TestEntity)EntityCacheUtil.getResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
				TestEntityImpl.class, primaryKey);

		if (testEntity == _nullTestEntity) {
			return null;
		}

		if (testEntity == null) {
			Session session = null;

			try {
				session = openSession();

				testEntity = (TestEntity)session.get(TestEntityImpl.class,
						primaryKey);

				if (testEntity != null) {
					cacheResult(testEntity);
				}
				else {
					EntityCacheUtil.putResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
						TestEntityImpl.class, primaryKey, _nullTestEntity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TestEntityModelImpl.ENTITY_CACHE_ENABLED,
					TestEntityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return testEntity;
	}

	/**
	 * Returns the TestEntity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemId the primary key of the TestEntity
	 * @return the TestEntity, or <code>null</code> if a TestEntity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TestEntity fetchByPrimaryKey(long itemId) throws SystemException {
		return fetchByPrimaryKey((Serializable)itemId);
	}

	/**
	 * Returns all the TestEntities.
	 *
	 * @return the TestEntities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestEntity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TestEntity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the TestEntities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.dtodo1paco.samples.model.impl.TestEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of TestEntities
	 * @param end the upper bound of the range of TestEntities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of TestEntities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TestEntity> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TestEntity> list = (List<TestEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TESTENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TESTENTITY;

				if (pagination) {
					sql = sql.concat(TestEntityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TestEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TestEntity>(list);
				}
				else {
					list = (List<TestEntity>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the TestEntities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TestEntity testEntity : findAll()) {
			remove(testEntity);
		}
	}

	/**
	 * Returns the number of TestEntities.
	 *
	 * @return the number of TestEntities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TESTENTITY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the TestEntity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.dtodo1paco.samples.model.TestEntity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TestEntity>> listenersList = new ArrayList<ModelListener<TestEntity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TestEntity>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TestEntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TESTENTITY = "SELECT testEntity FROM TestEntity testEntity";
	private static final String _SQL_SELECT_TESTENTITY_WHERE = "SELECT testEntity FROM TestEntity testEntity WHERE ";
	private static final String _SQL_COUNT_TESTENTITY = "SELECT COUNT(testEntity) FROM TestEntity testEntity";
	private static final String _SQL_COUNT_TESTENTITY_WHERE = "SELECT COUNT(testEntity) FROM TestEntity testEntity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "testEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TestEntity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TestEntity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TestEntityPersistenceImpl.class);
	private static TestEntity _nullTestEntity = new TestEntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TestEntity> toCacheModel() {
				return _nullTestEntityCacheModel;
			}
		};

	private static CacheModel<TestEntity> _nullTestEntityCacheModel = new CacheModel<TestEntity>() {
			@Override
			public TestEntity toEntityModel() {
				return _nullTestEntity;
			}
		};
}