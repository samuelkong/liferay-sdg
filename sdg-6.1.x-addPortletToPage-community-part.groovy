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

// Bookmarks page

Layout layoutBookmarks = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/bookmarks");

UnicodeProperties typeSettingsPropertiesBookmark =
	layoutBookmarks.getTypeSettingsProperties();

typeSettingsPropertiesBookmark.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesBookmark.setProperty("column-2", "28");
typeSettingsPropertiesBookmark.setProperty(
	"column-1", "71_INSTANCE_7VL6SLQvAQyJ,");

layoutBookmarks.setTypeSettingsProperties(typeSettingsPropertiesBookmark);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutBookmarks.getLayoutId(),
	layoutBookmarks.getTypeSettings());

UnicodeProperties propertiesBookmark = new UnicodeProperties();

propertiesBookmark.setProperty("displayStyle", "from-level-0");
propertiesBookmark.setProperty("headerType", "root-layout");
propertiesBookmark.setProperty("bulletStyle", "dots");
propertiesBookmark.setProperty("rootLayoutType", "absolute");
propertiesBookmark.setProperty("includedLayouts", "auto");
propertiesBookmark.setProperty("nestedChildren", "1");
propertiesBookmark.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceBookmark", "71_INSTANCE_7VL6SLQvAQyJ");

portletResourceBookmark = (String)actionRequest.getAttribute(
	"portletResourceBookmark");

PortletPreferences portletPreferencesBookmark =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceBookmark);

for (Map.Entry<String, String> entry : propertiesBookmark.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesBookmark.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutBookmarks.getPlid(), "71_INSTANCE_7VL6SLQvAQyJ",
	portletPreferencesBookmark);

// Friends directory page

Layout layoutFriends = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/friends-directory");

UnicodeProperties typeSettingsPropertiesFriends =
	layoutFriends.getTypeSettingsProperties();

typeSettingsPropertiesFriends.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesFriends.setProperty("column-2", "11");
typeSettingsPropertiesFriends.setProperty(
	"column-1", "71_INSTANCE_HwcVOI17WGQx,");

layoutFriends.setTypeSettingsProperties(typeSettingsPropertiesFriends);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutFriends.getLayoutId(),
	layoutFriends.getTypeSettings());

UnicodeProperties propertiesFriends = new UnicodeProperties();

propertiesFriends.setProperty("displayStyle", "from-level-0");
propertiesFriends.setProperty("headerType", "root-layout");
propertiesFriends.setProperty("bulletStyle", "dots");
propertiesFriends.setProperty("rootLayoutType", "absolute");
propertiesFriends.setProperty("includedLayouts", "auto");
propertiesFriends.setProperty("nestedChildren", "1");
propertiesFriends.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceFriends", "71_INSTANCE_HwcVOI17WGQx");

portletResourceFriends = (String)actionRequest.getAttribute(
	"portletResourceFriends");

PortletPreferences portletPreferencesFriends =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceFriends);

for (Map.Entry<String, String> entry : propertiesFriends.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesFriends.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutFriends.getPlid(), "71_INSTANCE_HwcVOI17WGQx",
	portletPreferencesFriends);

// Invitation page

Layout layoutInvitation = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/invitation");

UnicodeProperties typeSettingsPropertiesInvitation =
	layoutInvitation.getTypeSettingsProperties();

typeSettingsPropertiesInvitation.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesInvitation.setProperty("column-2", "100");
typeSettingsPropertiesInvitation.setProperty(
	"column-1", "71_INSTANCE_HwcVOI17WGQm,");

layoutInvitation.setTypeSettingsProperties(typeSettingsPropertiesInvitation);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutInvitation.getLayoutId(),
	layoutInvitation.getTypeSettings());

UnicodeProperties propertiesInvitation = new UnicodeProperties();

propertiesInvitation.setProperty("displayStyle", "from-level-0");
propertiesInvitation.setProperty("headerType", "root-layout");
propertiesInvitation.setProperty("bulletStyle", "dots");
propertiesInvitation.setProperty("rootLayoutType", "absolute");
propertiesInvitation.setProperty("includedLayouts", "auto");
propertiesInvitation.setProperty("nestedChildren", "1");
propertiesInvitation.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceInvitation", "71_INSTANCE_HwcVOI17WGQm");

portletResourceInvitation = (String)actionRequest.getAttribute(
	"portletResourceInvitation");

PortletPreferences portletPreferencesInvitation =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceInvitation);

for (Map.Entry<String, String> entry : propertiesInvitation.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesInvitation.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutInvitation.getPlid(), "71_INSTANCE_HwcVOI17WGQm",
	portletPreferencesInvitation);

// My site page

Layout layoutSite = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/my-site");

UnicodeProperties typeSettingsPropertiesSite =
	layoutSite.getTypeSettingsProperties();

typeSettingsPropertiesSite.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesSite.setProperty("column-2", "29");
typeSettingsPropertiesSite.setProperty(
	"column-1", "71_INSTANCE_JfIkBcsg8840,");

layoutSite.setTypeSettingsProperties(typeSettingsPropertiesSite);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSite.getLayoutId(),
	layoutSite.getTypeSettings());

UnicodeProperties propertiesSite = new UnicodeProperties();

propertiesSite.setProperty("displayStyle", "from-level-0");
propertiesSite.setProperty("headerType", "root-layout");
propertiesSite.setProperty("bulletStyle", "dots");
propertiesSite.setProperty("rootLayoutType", "absolute");
propertiesSite.setProperty("includedLayouts", "auto");
propertiesSite.setProperty("nestedChildren", "1");
propertiesSite.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceSite", "71_INSTANCE_JfIkBcsg8840");

portletResourceSite = (String)actionRequest.getAttribute(
	"portletResourceSite");

PortletPreferences portletPreferencesSite =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceSite);

for (Map.Entry<String, String> entry : propertiesSite.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesSite.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutSite.getPlid(), "71_INSTANCE_JfIkBcsg8840",
	portletPreferencesSite);

// Page comment page

Layout layoutComment = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/page-comments");


UnicodeProperties typeSettingsPropertiesComment =
	layoutComment.getTypeSettingsProperties();

typeSettingsPropertiesComment.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesComment.setProperty("column-2", "108,107,143");
typeSettingsPropertiesComment.setProperty("column-1", "71_INSTANCE_mK2L1tZReQ4h,");

layoutComment.setTypeSettingsProperties(typeSettingsPropertiesComment);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutComment.getLayoutId(),
	layoutComment.getTypeSettings());

UnicodeProperties propertiesComment = new UnicodeProperties();

propertiesComment.setProperty("displayStyle", "from-level-0");
propertiesComment.setProperty("headerType", "root-layout");
propertiesComment.setProperty("bulletStyle", "dots");
propertiesComment.setProperty("rootLayoutType", "absolute");
propertiesComment.setProperty("includedLayouts", "auto");
propertiesComment.setProperty("nestedChildren", "1");
propertiesComment.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceComment", "71_INSTANCE_mK2L1tZReQ4h");

portletResourceComment = (String)actionRequest.getAttribute(
	"portletResourceComment");

PortletPreferences portletPreferencesComment =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceComment);

for (Map.Entry<String, String> entry : propertiesComment.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesComment.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutComment.getPlid(), "71_INSTANCE_mK2L1tZReQ4h",
	portletPreferencesComment);
