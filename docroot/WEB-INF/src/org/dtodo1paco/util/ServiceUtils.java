/**
 * 
 */
package org.dtodo1paco.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class ServiceUtils {

	public static ServiceContext createServiceContext(ThemeDisplay themeDisplay) {
		ServiceContext sc = ServiceUtils.createServiceContext(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		sc.setUserId(themeDisplay.getUserId());;
		return sc;
	}
	public static ServiceContext createServiceContext(long companyId, long groupId) {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setCompanyId(companyId);
		if (_log.isTraceEnabled()) {
			_log.trace("New ServiceContext created {companyId:"+companyId+",groupId:"+groupId+"}");
		}
		return serviceContext;
	}
	
	public static User getDefaultUser(long companyId) {
		try {
			User user = UserLocalServiceUtil.getDefaultUser(companyId);
			return user;
		} catch (Throwable e) {
			_log.error(
				"Unable to get default user for companyId: " + companyId, e);
			return null;
		}
	}
	private static Log _log = LogFactoryUtil.getLog(ServiceUtils.class);

}