package com.liferay.languagedetector.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

public class PortletPropsValues {
	public static final String DETECT_USER_EMAIL = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.DETECT_USER_EMAIL));
}
