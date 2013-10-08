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

// Amazon rankings page

Layout layoutAmazon = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/amazon-rankings");

UnicodeProperties typeSettingsPropertiesAmazon =
	layoutAmazon.getTypeSettingsProperties();

typeSettingsPropertiesAmazon.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesAmazon.setProperty("column-2", "67");
typeSettingsPropertiesAmazon.setProperty("column-1", "71_INSTANCE_uixmz2y3dFa6,");

layoutAmazon.setTypeSettingsProperties(typeSettingsPropertiesAmazon);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutAmazon.getLayoutId(),
	layoutAmazon.getTypeSettings());

UnicodeProperties propertiesAmazon = new UnicodeProperties();

propertiesAmazon.setProperty("displayStyle", "from-level-0");
propertiesAmazon.setProperty("headerType", "root-layout");
propertiesAmazon.setProperty("bulletStyle", "dots");
propertiesAmazon.setProperty("rootLayoutType", "absolute");
propertiesAmazon.setProperty("includedLayouts", "auto");
propertiesAmazon.setProperty("nestedChildren", "1");
propertiesAmazon.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceAmazon", "71_INSTANCE_uixmz2y3dFa6");

portletResourceAmazon = (String)actionRequest.getAttribute(
	"portletResourceAmazon");

PortletPreferences portletPreferencesAmazon =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceAmazon);

for (Map.Entry<String, String> entry : propertiesAmazon.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesAmazon.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutAmazon.getPlid(), "71_INSTANCE_uixmz2y3dFa6",
	portletPreferencesAmazon);

// Shopping portlet page

Layout layoutShopping = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/shopping-portlet");

UnicodeProperties typeSettingsPropertiesShopping =
	layoutShopping.getTypeSettingsProperties();

typeSettingsPropertiesShopping.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesShopping.setProperty("column-2", "34");
typeSettingsPropertiesShopping.setProperty("column-1", "71_INSTANCE_uixmz6y3dFa6,");

layoutShopping.setTypeSettingsProperties(typeSettingsPropertiesShopping);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutShopping.getLayoutId(),
	layoutShopping.getTypeSettings());

UnicodeProperties propertiesShopping = new UnicodeProperties();

propertiesShopping.setProperty("displayStyle", "from-level-0");
propertiesShopping.setProperty("headerType", "root-layout");
propertiesShopping.setProperty("bulletStyle", "dots");
propertiesShopping.setProperty("rootLayoutType", "absolute");
propertiesShopping.setProperty("includedLayouts", "auto");
propertiesShopping.setProperty("nestedChildren", "1");
propertiesShopping.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceShopping", "71_INSTANCE_uixmz6y3dFa6");

portletResourceShopping = (String)actionRequest.getAttribute(
	"portletResourceShopping");

PortletPreferences portletPreferencesShopping =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceShopping);

for (Map.Entry<String, String> entry : propertiesShopping.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesShopping.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutShopping.getPlid(), "71_INSTANCE_uixmz6y3dFa6",
	portletPreferencesShopping);
