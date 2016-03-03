package com.liferay.languagedetector.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

public class PortletPropsValues {
	public static final String DETECT_USER_EMAIL = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.DETECT_USER_EMAIL));

	public static final String DETECT_LANGUAGE = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.DETECT_LANGUAGE));

	public static final String RECOVER_LANGUAGE = GetterUtil.getString(
		PortletProps.get(PortletPropsKeys.RECOVER_LANGUAGE));

	public static final long LANGUAGE_LIFE_MS = GetterUtil.getLong(
			PortletProps.get(PortletPropsKeys.LANGUAGE_LIFE_MS));
}
