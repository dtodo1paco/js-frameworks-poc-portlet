package org.dtodo1paco.samples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletRequest;

import org.dtodo1paco.samples.model.TestEntity;
import org.dtodo1paco.samples.service.TestEntityLocalServiceUtil;
import org.dtodo1paco.util.ServiceUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class MVCPortlet
 */
public class ResourcesPortlet extends com.liferay.util.bridges.mvc.MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		User user = (User) renderRequest.getAttribute(WebKeys.USER);
		String userScreenName = user != null ? user.getScreenName()
				: "anonymous";
		ResourceURL baseResourceUrl = renderResponse.createResourceURL();
		renderResponse.addProperty("authenticatedUser", userScreenName);
		renderResponse.addProperty("portletId", getPortletId(renderRequest));
		renderResponse.addProperty("portletAppContextPath",
				renderRequest.getContextPath() + "/");
		if (_log.isDebugEnabled()) {
			_log.debug("doView: " + renderResponse);
		}
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		String resource = ParamUtil.getString(resourceRequest, "resource",
				"default");
		String action = ParamUtil.getString(resourceRequest,
				"serve_resource_action", "default");
		String properties = ParamUtil.getString(resourceRequest, "properties",
				null);
		JSONObject propertiesJSON = null;
		if (properties != null) {
			try {
				propertiesJSON = JSONFactoryUtil.createJSONObject(properties);
			} catch (JSONException e) {
				_log.error("Unable to parse properties: " + propertiesJSON, e);
			}
		}
		if (_log.isDebugEnabled()) {
			_log.debug("Serving resource: " + resource);
			_log.debug("____action: " + action);
			_log.debug("____properties " + propertiesJSON);
		}

		Throwable exception = null;
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		jsonResponse.put("resource", resource);
		jsonResponse.put("success", true);
		try {
			if ("TestEntity".equals(resource)) {
				if ("save".equals(action)) {
					ThemeDisplay themeDisplay = ((ThemeDisplay) resourceRequest
							.getAttribute(WebKeys.THEME_DISPLAY));
					ServiceContext serviceContext = ServiceUtils
							.createServiceContext(themeDisplay);
					JSONObject entity = saveTestEntity(propertiesJSON,
							serviceContext);
					jsonResponse.put("total", 1);
					jsonResponse.put("result", entity);
				}
			}
		} catch (SystemException e) {
			exception = e;
		} catch (Exception e) {
			exception = e;
		}
		if (exception != null) {
			jsonResponse.put("success", false);
			jsonResponse.put("total", 0);
			JSONObject exc = JSONFactoryUtil.createJSONObject();
			exc.put("type", exception.getClass().getName());
			exc.put("message", exception.getMessage());
			exc.put("properties", properties);
			jsonResponse.put("result", exc);
			_log.error("Unable to serve resource [" + resource + "] for ["
					+ action + "] due to: " + exc, exception);
		}
		if (_log.isDebugEnabled()) {
			_log.debug("Serving response: " + jsonResponse);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonResponse.toString());
	}

	private String getPortletId(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		return portletDisplay.getId();
	}

	private JSONObject parseToJSON(Map<String, Object> modelAttributes) {
		JSONObject result = JSONFactoryUtil.createJSONObject();
		for (String key : modelAttributes.keySet()) {
			Object data = modelAttributes.get(key);
			if (data instanceof String) {
				result.put(key, (String) data);
			} else if (data instanceof Date) {
				result.put(key, (Date) data);
			} else if (data instanceof Boolean) {
				result.put(key, (Boolean) data);
			} else if (data instanceof Double) {
				result.put(key, (Double) data);
			} else if (data instanceof Integer) {
				result.put(key, (Integer) data);
			} else if (data instanceof Long) {
				result.put(key, (Long) data);
			} // TODO: JSONObject and JSONArray cases
		}
		return result;
	}

	private JSONObject saveTestEntity(JSONObject propertiesJSON,
			ServiceContext serviceContext) throws SystemException {
		TestEntity result = TestEntityLocalServiceUtil.addTest(propertiesJSON,
				serviceContext);
		return parseToJSON(result.getModelAttributes());
	}

	private static final Log _log = LogFactoryUtil
			.getLog(ResourcesPortlet.class);
}
