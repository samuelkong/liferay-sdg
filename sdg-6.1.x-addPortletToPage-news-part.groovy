import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.PortletPreferences;

/**
 * @author Sara Liu
 */
userId = PortalUtil.getUserId(actionRequest);

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	Group.class.getName(), actionRequest);

// Alerts page

Layout layoutAlerts = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/alerts");

UnicodeProperties typeSettingsPropertiesAlerts =
	layoutAlerts.getTypeSettingsProperties();

typeSettingsPropertiesAlerts.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesAlerts.setProperty("column-2", "83");
typeSettingsPropertiesAlerts.setProperty("column-1", "71_INSTANCE_ceopyQMpL4Tj,");

layoutAlerts.setTypeSettingsProperties(typeSettingsPropertiesAlerts);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutAlerts.getLayoutId(),
	layoutAlerts.getTypeSettings());

UnicodeProperties propertiesAlerts = new UnicodeProperties();

propertiesAlerts.setProperty("displayStyle", "from-level-0");
propertiesAlerts.setProperty("headerType", "root-layout");
propertiesAlerts.setProperty("bulletStyle", "dots");
propertiesAlerts.setProperty("rootLayoutType", "absolute");
propertiesAlerts.setProperty("includedLayouts", "auto");
propertiesAlerts.setProperty("nestedChildren", "1");
propertiesAlerts.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceAlerts", "71_INSTANCE_ceopyQMpL4Tj");

portletResourceAlerts = (String)actionRequest.getAttribute("portletResourceAlerts");

PortletPreferences portletPreferencesAlerts =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceAlerts);

for (Map.Entry<String, String> entry : propertiesAlerts.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesAlerts.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutAlerts.getPlid(), "71_INSTANCE_ceopyQMpL4Tj",
	portletPreferencesAlerts);

// Announcements page

Layout layoutAnnouncements = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/announcements");

UnicodeProperties typeSettingsPropertiesAnnouncements =
	layoutAnnouncements.getTypeSettingsProperties();

typeSettingsPropertiesAnnouncements.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesAnnouncements.setProperty("column-2", "84");
typeSettingsPropertiesAnnouncements.setProperty(
	"column-1", "71_INSTANCE_9svey4gIknoo,");

layoutAnnouncements.setTypeSettingsProperties(
	typeSettingsPropertiesAnnouncements);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutAnnouncements.getLayoutId(),
	layoutAnnouncements.getTypeSettings());

UnicodeProperties propertiesAnnouncements = new UnicodeProperties();

propertiesAnnouncements.setProperty("displayStyle", "from-level-0");
propertiesAnnouncements.setProperty("headerType", "root-layout");
propertiesAnnouncements.setProperty("bulletStyle", "dots");
propertiesAnnouncements.setProperty("rootLayoutType", "absolute");
propertiesAnnouncements.setProperty("includedLayouts", "auto");
propertiesAnnouncements.setProperty("nestedChildren", "1");
propertiesAnnouncements.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceAnnouncements", "71_INSTANCE_9svey4gIknoo");

portletResourceAnnouncements = (String)actionRequest.getAttribute(
	"portletResourceAnnouncements");

PortletPreferences portletPreferencesAnnouncements =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceAnnouncements);

for (Map.Entry<String, String> entry : propertiesAnnouncements.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesAnnouncements.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutAnnouncements.getPlid(), "71_INSTANCE_9svey4gIknoo",
	portletPreferencesAnnouncements);

// Rss page

Layout layoutRSS = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/rss");

UnicodeProperties typeSettingsPropertiesRSS =
	layoutRSS.getTypeSettingsProperties();

typeSettingsPropertiesRSS.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesRSS.setProperty("column-2", "39_INSTANCE_vn59KhKI7Y2w");
typeSettingsPropertiesRSS.setProperty("column-1", "71_INSTANCE_uxxsIbKD2cfQ,");

layoutRSS.setTypeSettingsProperties(typeSettingsPropertiesRSS);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutRSS.getLayoutId(),
	layoutRSS.getTypeSettings());

UnicodeProperties propertiesRSS = new UnicodeProperties();

propertiesRSS.setProperty("displayStyle", "from-level-0");
propertiesRSS.setProperty("headerType", "root-layout");
propertiesRSS.setProperty("bulletStyle", "dots");
propertiesRSS.setProperty("rootLayoutType", "absolute");
propertiesRSS.setProperty("includedLayouts", "auto");
propertiesRSS.setProperty("nestedChildren", "1");
propertiesRSS.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceRSS", "71_INSTANCE_uxxsIbKD2cfQ");

portletResourceRSS = (String)actionRequest.getAttribute("portletResourceRSS");

PortletPreferences portletPreferencesRSS =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceRSS);

for (Map.Entry<String, String> entry : propertiesRSS.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesRSS.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutRSS.getPlid(), "71_INSTANCE_uxxsIbKD2cfQ",
	portletPreferencesRSS);
