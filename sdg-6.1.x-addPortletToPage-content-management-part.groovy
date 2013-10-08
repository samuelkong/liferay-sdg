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

// Asset publisher page

Layout layoutAssetP = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/asset-publisher");

UnicodeProperties typeSettingsPropertiesAssetP =
	layoutAssetP.getTypeSettingsProperties();

typeSettingsPropertiesAssetP.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesAssetP.setProperty(
	"column-2", "101_INSTANCE_cHzGSpUq98kH");
typeSettingsPropertiesAssetP.setProperty(
	"column-1", "71_INSTANCE_kUWGUtU6zEnt,");

layoutAssetP.setTypeSettingsProperties(typeSettingsPropertiesAssetP);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutAssetP.getLayoutId(),
	layoutAssetP.getTypeSettings());

UnicodeProperties propertiesAssetP = new UnicodeProperties();

propertiesAssetP.setProperty("displayStyle", "from-level-0");
propertiesAssetP.setProperty("headerType", "root-layout");
propertiesAssetP.setProperty("bulletStyle", "dots");
propertiesAssetP.setProperty("rootLayoutType", "absolute");
propertiesAssetP.setProperty("includedLayouts", "auto");
propertiesAssetP.setProperty("nestedChildren", "1");
propertiesAssetP.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceAssetP", "71_INSTANCE_kUWGUtU6zEnt");

portletResourceAssetP = (String)actionRequest.getAttribute(
	"portletResourceAssetP");

PortletPreferences portletPreferencesAssetP =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceAssetP);

for (Map.Entry<String, String> entry : propertiesAssetP.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesAssetP.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutAssetP.getPlid(), "71_INSTANCE_kUWGUtU6zEnt",
	portletPreferencesAssetP);

// Breadcrumb page

Layout layoutBreadcrumb = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/breadcrumb");

UnicodeProperties typeSettingsPropertiesBreadcrumb =
	layoutBreadcrumb.getTypeSettingsProperties();

typeSettingsPropertiesBreadcrumb.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesBreadcrumb.setProperty(
	"column-2", "73_INSTANCE_bOhQtaG2uIry");
typeSettingsPropertiesBreadcrumb.setProperty(
	"column-1", "71_INSTANCE_6Oy6CHmEnaPW,");

layoutBreadcrumb.setTypeSettingsProperties(typeSettingsPropertiesBreadcrumb);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutBreadcrumb.getLayoutId(),
	layoutBreadcrumb.getTypeSettings());

UnicodeProperties propertiesBreadcrumb = new UnicodeProperties();

propertiesBreadcrumb.setProperty("displayStyle", "from-level-0");
propertiesBreadcrumb.setProperty("headerType", "root-layout");
propertiesBreadcrumb.setProperty("bulletStyle", "dots");
propertiesBreadcrumb.setProperty("rootLayoutType", "absolute");
propertiesBreadcrumb.setProperty("includedLayouts", "auto");
propertiesBreadcrumb.setProperty("nestedChildren", "1");
propertiesBreadcrumb.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceBreadcrumb", "71_INSTANCE_6Oy6CHmEnaPW");

portletResourceBreadcrumb = (String)actionRequest.getAttribute(
	"portletResourceBreadcrumb");

PortletPreferences portletPreferencesBreadcrumb =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceBreadcrumb);

for (Map.Entry<String, String> entry : propertiesBreadcrumb.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesBreadcrumb.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutBreadcrumb.getPlid(), "71_INSTANCE_6Oy6CHmEnaPW",
	portletPreferencesBreadcrumb);

// Category navigation page

Layout layoutCN = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/category-navigation");

UnicodeProperties typeSettingsPropertiesCN =
	layoutCN.getTypeSettingsProperties();

typeSettingsPropertiesCN.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesCN.setProperty("column-2", "122_INSTANCE_wK4hm8kPKiq2");
typeSettingsPropertiesCN.setProperty("column-1", "71_INSTANCE_eyemFjZqJ1Kk,");

layoutCN.setTypeSettingsProperties(typeSettingsPropertiesCN);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutCN.getLayoutId(),
	layoutCN.getTypeSettings());

UnicodeProperties propertiesCN = new UnicodeProperties();

propertiesCN.setProperty("displayStyle", "from-level-0");
propertiesCN.setProperty("headerType", "root-layout");
propertiesCN.setProperty("bulletStyle", "dots");
propertiesCN.setProperty("rootLayoutType", "absolute");
propertiesCN.setProperty("includedLayouts", "auto");
propertiesCN.setProperty("nestedChildren", "1");
propertiesCN.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceCN", "71_INSTANCE_eyemFjZqJ1Kk");

portletResourceCN = (String)actionRequest.getAttribute("portletResourceCN");

PortletPreferences portletPreferencesCN =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceCN);

for (Map.Entry<String, String> entry : propertiesCN.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesCN.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutCN.getPlid(), "71_INSTANCE_eyemFjZqJ1Kk",
	portletPreferencesCN);

// Documents and media

Layout layoutDM = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/documents-and-media");

UnicodeProperties typeSettingsPropertiesDM =
	layoutDM.getTypeSettingsProperties();

typeSettingsPropertiesDM.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesDM.setProperty("column-2", "20");
typeSettingsPropertiesDM.setProperty("column-1", "71_INSTANCE_rXmUME1go3zw");

layoutDM.setTypeSettingsProperties(typeSettingsPropertiesDM);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutDM.getLayoutId(),
	layoutDM.getTypeSettings());

UnicodeProperties propertiesDM = new UnicodeProperties();

propertiesDM.setProperty("displayStyle", "from-level-0");
propertiesDM.setProperty("headerType", "root-layout");
propertiesDM.setProperty("bulletStyle", "dots");
propertiesDM.setProperty("rootLayoutType", "absolute");
propertiesDM.setProperty("includedLayouts", "auto");
propertiesDM.setProperty("nestedChildren", "1");
propertiesDM.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceDM", "71_INSTANCE_rXmUME1go3zw");

portletResourceDM = (String)actionRequest.getAttribute("portletResourceDM");

PortletPreferences portletPreferencesDM =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceDM);

for (Map.Entry<String, String> entry : propertiesDM.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesDM.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutDM.getPlid(), "71_INSTANCE_rXmUME1go3zw",
	portletPreferencesDM);

// Nested portlets page

Layout layoutNested = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/nested-portlets");
UnicodeProperties typeSettingsPropertiesNested =
	layoutNested.getTypeSettingsProperties();

typeSettingsPropertiesNested.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesNested.setProperty(
	"_118_INSTANCE_mQnir2HWDHrM__column-3", "115");
typeSettingsPropertiesNested.setProperty(
	"_118_INSTANCE_mQnir2HWDHrM__column-2", "71_INSTANCE_u9La1oksuZYZ,");
typeSettingsPropertiesNested.setProperty(
	"_118_INSTANCE_mQnir2HWDHrM__column-1", "73_INSTANCE_TtL6I5irPv5t,");
typeSettingsPropertiesNested.setProperty(
	"nested-column-ids",
	"118_INSTANCE_mQnir2HWDHrM__column-1,_118_INSTANCE_mQnir2HWDHrM__column-2,_118_INSTANCE_mQnir2HWDHrM__column-3,");
typeSettingsPropertiesNested.setProperty("column-2", "118_INSTANCE_mQnir2HWDHrM,");
typeSettingsPropertiesNested.setProperty("column-1", "71_INSTANCE_rXmUME1go3zm,");

layoutNested.setTypeSettingsProperties(typeSettingsPropertiesNested);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutNested.getLayoutId(),
	layoutNested.getTypeSettings());

UnicodeProperties propertiesNested = new UnicodeProperties();

propertiesNested.setProperty("displayStyle", "from-level-0");
propertiesNested.setProperty("headerType", "root-layout");
propertiesNested.setProperty("bulletStyle", "dots");
propertiesNested.setProperty("rootLayoutType", "absolute");
propertiesNested.setProperty("includedLayouts", "auto");
propertiesNested.setProperty("nestedChildren", "1");
propertiesNested.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceNested", "71_INSTANCE_rXmUME1go3zm");

portletResourceNested = (String)actionRequest.getAttribute(
	"portletResourceNested");

PortletPreferences portletPreferencesNested =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceNested);

for (Map.Entry<String, String> entry : propertiesNested.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesNested.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutNested.getPlid(), "71_INSTANCE_rXmUME1go3zm",
	portletPreferencesNested);

// Polls display page

Layout layoutPolls = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/polls-display");

UnicodeProperties typeSettingsPropertiesPolls =
	layoutPolls.getTypeSettingsProperties();

typeSettingsPropertiesPolls.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesPolls.setProperty("column-2", "59_INSTANCE_TbzT9KKPaRFZ");
typeSettingsPropertiesPolls.setProperty("column-1", "71_INSTANCE_FkVY7cJ3m6cm,");

layoutPolls.setTypeSettingsProperties(typeSettingsPropertiesPolls);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutPolls.getLayoutId(),
	layoutPolls.getTypeSettings());

UnicodeProperties propertiesPolls = new UnicodeProperties();

propertiesPolls.setProperty("displayStyle", "from-level-0");
propertiesPolls.setProperty("headerType", "root-layout");
propertiesPolls.setProperty("bulletStyle", "dots");
propertiesPolls.setProperty("rootLayoutType", "absolute");
propertiesPolls.setProperty("includedLayouts", "auto");
propertiesPolls.setProperty("nestedChildren", "1");
propertiesPolls.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourcePolls", "71_INSTANCE_FkVY7cJ3m6cm");

portletResourcePolls = (String)actionRequest.getAttribute(
	"portletResourcePolls");

PortletPreferences portletPreferencesPolls =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourcePolls);

for (Map.Entry<String, String> entry : propertiesPolls.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesPolls.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutPolls.getPlid(), "71_INSTANCE_FkVY7cJ3m6cm",
	portletPreferencesPolls);

// Recent downloads page

Layout layoutRD = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/recent-downloads");

UnicodeProperties typeSettingsPropertiesRD =
	layoutRD.getTypeSettingsProperties();

typeSettingsPropertiesRD.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesRD.setProperty("column-2", "64");
typeSettingsPropertiesRD.setProperty("column-1", "71_INSTANCE_yDtUc5UAAhWm,");

layoutRD.setTypeSettingsProperties(typeSettingsPropertiesRD);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutRD.getLayoutId(),
	layoutRD.getTypeSettings());

UnicodeProperties propertiesRD = new UnicodeProperties();

propertiesRD.setProperty("displayStyle", "from-level-0");
propertiesRD.setProperty("headerType", "root-layout");
propertiesRD.setProperty("bulletStyle", "dots");
propertiesRD.setProperty("rootLayoutType", "absolute");
propertiesRD.setProperty("includedLayouts", "auto");
propertiesRD.setProperty("nestedChildren", "1");
propertiesRD.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceRD", "71_INSTANCE_yDtUc5UAAhWm");

portletResourceRD = (String)actionRequest.getAttribute("portletResourceRD");

PortletPreferences portletPreferencesRD =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceRD);

for (Map.Entry<String, String> entry : propertiesRD.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesRD.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutRD.getPlid(), "71_INSTANCE_yDtUc5UAAhWm",
	portletPreferencesRD);

// Related assets page

Layout layoutRA = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/related-assets");

UnicodeProperties typeSettingsPropertiesRA =
	layoutRA.getTypeSettingsProperties();

typeSettingsPropertiesRA.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesRA.setProperty(
	"column-2", "175_INSTANCE_s90usYdR23Ii,");
typeSettingsPropertiesRA.setProperty("column-1", "71_INSTANCE_yDtUc5UAAhW4,");

layoutRA.setTypeSettingsProperties(typeSettingsPropertiesRA);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutRA.getLayoutId(),
	layoutRA.getTypeSettings());

UnicodeProperties propertiesRA = new UnicodeProperties();

propertiesRA.setProperty("displayStyle", "from-level-0");
propertiesRA.setProperty("headerType", "root-layout");
propertiesRA.setProperty("bulletStyle", "dots");
propertiesRA.setProperty("rootLayoutType", "absolute");
propertiesRA.setProperty("includedLayouts", "auto");
propertiesRA.setProperty("nestedChildren", "1");
propertiesRA.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceRA", "71_INSTANCE_yDtUc5UAAhW4");

portletResourceRA = (String)actionRequest.getAttribute("portletResourceRA");

PortletPreferences portletPreferencesRA =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceRA);

for (Map.Entry<String, String> entry : propertiesRA.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesRA.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutRA.getPlid(), "71_INSTANCE_yDtUc5UAAhW4",
	portletPreferencesRA);

// Site map page

Layout layoutSiteMap = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/site-map");

UnicodeProperties typeSettingsPropertiesSiteMap =
	layoutSiteMap.getTypeSettingsProperties();

typeSettingsPropertiesSiteMap.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesSiteMap.setProperty(
	"column-2", "85_INSTANCE_8ynIjUSaM1Xf");
typeSettingsPropertiesSiteMap.setProperty(
	"column-1", "71_INSTANCE_YnegvD2AETDa,");

layoutSiteMap.setTypeSettingsProperties(typeSettingsPropertiesSiteMap);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSiteMap.getLayoutId(),
	layoutSiteMap.getTypeSettings());

UnicodeProperties propertiesSiteMap = new UnicodeProperties();

propertiesSiteMap.setProperty("displayStyle", "from-level-0");
propertiesSiteMap.setProperty("headerType", "root-layout");
propertiesSiteMap.setProperty("bulletStyle", "dots");
propertiesSiteMap.setProperty("rootLayoutType", "absolute");
propertiesSiteMap.setProperty("includedLayouts", "auto");
propertiesSiteMap.setProperty("nestedChildren", "1");
propertiesSiteMap.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceSiteMap", "71_INSTANCE_YnegvD2AETDa");

portletResourceSiteMap = (String)actionRequest.getAttribute(
	"portletResourceSiteMap");

PortletPreferences portletPreferencesSiteMap =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceSiteMap);

for (Map.Entry<String, String> entry : propertiesSiteMap.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesSiteMap.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutSiteMap.getPlid(), "71_INSTANCE_YnegvD2AETDa",
	portletPreferencesSiteMap);

// Tag cloud page

Layout layoutTag = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/tag-cloud");

UnicodeProperties typeSettingsPropertiesTag =
	layoutTag.getTypeSettingsProperties();

typeSettingsPropertiesTag.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesTag.setProperty(
	"column-2", "141_INSTANCE_W3mu4VyEzpgz,148_INSTANCE_ovvJg184K1ix");
typeSettingsPropertiesTag.setProperty("column-1", "71_INSTANCE_LWB5t48iFqIP,");

layoutTag.setTypeSettingsProperties(typeSettingsPropertiesTag);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutTag.getLayoutId(),
	layoutTag.getTypeSettings());

UnicodeProperties propertiesTag = new UnicodeProperties();

propertiesTag.setProperty("displayStyle", "from-level-0");
propertiesTag.setProperty("headerType", "root-layout");
propertiesTag.setProperty("bulletStyle", "dots");
propertiesTag.setProperty("rootLayoutType", "absolute");
propertiesTag.setProperty("includedLayouts", "auto");
propertiesTag.setProperty("nestedChildren", "1");
propertiesTag.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceTag", "71_INSTANCE_LWB5t48iFqIP");

portletResourceTag = (String)actionRequest.getAttribute("portletResourceTag");

PortletPreferences portletPreferencesTag =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceTag);

for (Map.Entry<String, String> entry : propertiesTag.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesTag.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutTag.getPlid(), "71_INSTANCE_LWB5t48iFqIP",
	portletPreferencesTag);

// Web content page

Layout layoutWC = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/web-content");

UnicodeProperties typeSettingsPropertiesWC =
	layoutWC.getTypeSettingsProperties();

typeSettingsPropertiesWC.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesWC.setProperty(
	"column-2", "77,56_INSTANCE_COxqya3VTLhr,62_INSTANCE_ffagnWrlaM2y");
typeSettingsPropertiesWC.setProperty("column-1", "71_INSTANCE_kcplKlFfMkj3,");

layoutWC.setTypeSettingsProperties(typeSettingsPropertiesWC);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutWC.getLayoutId(),
	layoutWC.getTypeSettings());

UnicodeProperties propertiesWC = new UnicodeProperties();

propertiesWC.setProperty("displayStyle", "from-level-0");
propertiesWC.setProperty("headerType", "root-layout");
propertiesWC.setProperty("bulletStyle", "dots");
propertiesWC.setProperty("rootLayoutType", "absolute");
propertiesWC.setProperty("includedLayouts", "auto");
propertiesWC.setProperty("nestedChildren", "1");
propertiesWC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceWC", "71_INSTANCE_kcplKlFfMkj3");

portletResourceWC = (String)actionRequest.getAttribute("portletResourceWC");

PortletPreferences portletPreferencesWC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceWC);

for (Map.Entry<String, String> entry : propertiesWC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesWC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutWC.getPlid(), "71_INSTANCE_kcplKlFfMkj3",
	portletPreferencesWC);

// Xsl content page

Layout layoutXSL = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/xsl-content");

UnicodeProperties typeSettingsPropertiesXSL =
	layoutXSL.getTypeSettingsProperties();

typeSettingsPropertiesXSL.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesXSL.setProperty("column-2", "102_INSTANCE_4WS583Eepz19");
typeSettingsPropertiesXSL.setProperty("column-1", "71_INSTANCE_9sS3bcUNQ2ox,");

layoutXSL.setTypeSettingsProperties(typeSettingsPropertiesXSL);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutXSL.getLayoutId(),
	layoutXSL.getTypeSettings());

UnicodeProperties propertiesXSL = new UnicodeProperties();

propertiesXSL.setProperty("displayStyle", "from-level-0");
propertiesXSL.setProperty("headerType", "root-layout");
propertiesXSL.setProperty("bulletStyle", "dots");
propertiesXSL.setProperty("rootLayoutType", "absolute");
propertiesXSL.setProperty("includedLayouts", "auto");
propertiesXSL.setProperty("nestedChildren", "1");
propertiesXSL.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceXSL", "71_INSTANCE_9sS3bcUNQ2ox");

portletResourceXSL = (String)actionRequest.getAttribute("portletResourceXSL");

PortletPreferences portletPreferencesXSL =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceXSL);

for (Map.Entry<String, String> entry : propertiesXSL.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesXSL.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutXSL.getPlid(), "71_INSTANCE_9sS3bcUNQ2ox",
	portletPreferencesXSL);
