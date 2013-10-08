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

// Blogs page

Layout layoutBlogs = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/blogs");

UnicodeProperties typeSettingsPropertiesBlog =
	layoutBlogs.getTypeSettingsProperties();

typeSettingsPropertiesBlog.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesBlog.setProperty("column-1", "71_INSTANCE_rETjYe1irD4L");
typeSettingsPropertiesBlog.setProperty("column-2", "115,33,114");

layoutBlogs.setTypeSettingsProperties(typeSettingsPropertiesBlog);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutBlogs.getLayoutId(),
	layoutBlogs.getTypeSettings());

UnicodeProperties propertiesBlog = new UnicodeProperties();

propertiesBlog.setProperty("displayStyle", "from-level-0");
propertiesBlog.setProperty("headerType", "root-layout");
propertiesBlog.setProperty("bulletStyle", "dots");
propertiesBlog.setProperty("rootLayoutType", "absolute");
propertiesBlog.setProperty("includedLayouts", "auto");
propertiesBlog.setProperty("nestedChildren", "1");
propertiesBlog.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceBlog", "71_INSTANCE_rETjYe1irD4L");

portletResourceBlog = (String)actionRequest.getAttribute(
	"portletResourceBlog");

PortletPreferences portletPreferencesBlog =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceBlog);

for (Map.Entry<String, String> entry : propertiesBlog.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesBlog.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutBlogs.getPlid(), "71_INSTANCE_rETjYe1irD4L",
	portletPreferencesBlog);

// Calender page

Layout layoutCalendar = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/calendar");

UnicodeProperties typeSettingsPropertiesCalendar =
	layoutCalendar.getTypeSettingsProperties();

typeSettingsPropertiesCalendar.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesCalendar.setProperty(
	"column-1", "71_INSTANCE_uixmz2y3dFa6");
typeSettingsPropertiesCalendar.setProperty("column-2", "8");

layoutCalendar.setTypeSettingsProperties(typeSettingsPropertiesCalendar);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutCalendar.getLayoutId(),
	layoutCalendar.getTypeSettings());

UnicodeProperties propertiesCalendar = new UnicodeProperties();

propertiesCalendar.setProperty("displayStyle", "from-level-0");
propertiesCalendar.setProperty("headerType", "root-layout");
propertiesCalendar.setProperty("bulletStyle", "dots");
propertiesCalendar.setProperty("rootLayoutType", "absolute");
propertiesCalendar.setProperty("includedLayouts", "auto");
propertiesCalendar.setProperty("nestedChildren", "1");
propertiesCalendar.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceCalendar", "71_INSTANCE_uixmz2y3dFa6");

portletResourceCalendar = (String)actionRequest.getAttribute(
	"portletResourceCalendar");

PortletPreferences portletPreferencesCalendar =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceCalendar);

for (Map.Entry<String, String> entry : propertiesCalendar.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesCalendar.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutCalendar.getPlid(), "71_INSTANCE_uixmz2y3dFa6",
	portletPreferencesCalendar);

// Dynamic data page

Layout layoutDD = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/dynamic-data");


UnicodeProperties typeSettingsPropertiesDD =
	layoutDD.getTypeSettingsProperties();

typeSettingsPropertiesDD.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesDD.setProperty("column-1", "71_INSTANCE_cpWOAkKlrbl2");
typeSettingsPropertiesDD.setProperty("column-2", "169_INSTANCE_yOInr1Ynqt0S");

layoutDD.setTypeSettingsProperties(typeSettingsPropertiesDD);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutDD.getLayoutId(),
	layoutDD.getTypeSettings());

UnicodeProperties propertiesDD = new UnicodeProperties();

propertiesDD.setProperty("displayStyle", "from-level-0");
propertiesDD.setProperty("headerType", "root-layout");
propertiesDD.setProperty("bulletStyle", "dots");
propertiesDD.setProperty("rootLayoutType", "absolute");
propertiesDD.setProperty("includedLayouts", "auto");
propertiesDD.setProperty("nestedChildren", "1");
propertiesDD.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceDD", "71_INSTANCE_cpWOAkKlrbl2");

portletResourceDD = (String)actionRequest.getAttribute("portletResourceDD");

PortletPreferences portletPreferencesDD =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceDD);

for (Map.Entry<String, String> entry : propertiesDD.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesDD.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutDD.getPlid(), "71_INSTANCE_cpWOAkKlrbl2",
	portletPreferencesDD);

// Wiki page

Layout layoutWiki = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/wiki");

UnicodeProperties typeSettingsPropertiesWikiPortlet =
	layoutWiki.getTypeSettingsProperties();

typeSettingsPropertiesWikiPortlet.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesWikiPortlet.setProperty("column-1", "71_INSTANCE_cpWOAkKlrbl3");
typeSettingsPropertiesWikiPortlet.setProperty("column-2", "36");

layoutWiki.setTypeSettingsProperties(typeSettingsPropertiesWikiPortlet);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutWiki.getLayoutId(),
	layoutWiki.getTypeSettings());

UnicodeProperties propertiesWikiPortlet = new UnicodeProperties();

propertiesWikiPortlet.setProperty("displayStyle", "from-level-0");
propertiesWikiPortlet.setProperty("headerType", "root-layout");
propertiesWikiPortlet.setProperty("bulletStyle", "dots");
propertiesWikiPortlet.setProperty("rootLayoutType", "absolute");
propertiesWikiPortlet.setProperty("includedLayouts", "auto");
propertiesWikiPortlet.setProperty("nestedChildren", "1");
propertiesWikiPortlet.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceWikiPortlet", "71_INSTANCE_cpWOAkKlrbl3");

portletResourceWikiPortlet = (String)actionRequest.getAttribute(
	"portletResourceWikiPortlet");

PortletPreferences portletPreferencesWikiPortlet =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceWikiPortlet);

for (Map.Entry<String, String> entry : propertiesWikiPortlet.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesWikiPortlet.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutWiki.getPlid(), "71_INSTANCE_cpWOAkKlrbl3",
	portletPreferencesWikiPortlet);

// Message board page

Layout layoutMB = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/message-board");

UnicodeProperties typeSettingsPropertiesMB =
	layoutMB.getTypeSettingsProperties();

typeSettingsPropertiesMB.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesMB.setProperty("column-1", "71_INSTANCE_vRgh12ulcIbj");
typeSettingsPropertiesMB.setProperty("column-2", "19");

layoutMB.setTypeSettingsProperties(typeSettingsPropertiesMB);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutMB.getLayoutId(),
	layoutMB.getTypeSettings());

UnicodeProperties propertiesMB = new UnicodeProperties();

propertiesMB.setProperty("displayStyle", "from-level-0");
propertiesMB.setProperty("headerType", "root-layout");
propertiesMB.setProperty("bulletStyle", "dots");
propertiesMB.setProperty("rootLayoutType", "absolute");
propertiesMB.setProperty("includedLayouts", "auto");
propertiesMB.setProperty("nestedChildren", "1");
propertiesMB.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceMB", "71_INSTANCE_vRgh12ulcIbj");

portletResourceMB = (String)actionRequest.getAttribute("portletResourceMB");

PortletPreferences portletPreferencesMB =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceMB);

for (Map.Entry<String, String> entry : propertiesMB.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesMB.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutMB.getPlid(), "71_INSTANCE_vRgh12ulcIbj",
	portletPreferencesMB);
