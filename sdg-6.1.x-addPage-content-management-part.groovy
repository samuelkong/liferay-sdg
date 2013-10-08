import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;

import java.util.HashMap;
import java.util.Locale;

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

// Content management

Map<Locale, String> nameMapContentMan = new HashMap<Locale, String>();

nameMapContentMan.put(Locale.US, "Content Management");

Map<Locale, String> titleMapContentMan = new HashMap<Locale, String>();

titleMapContentMan.put(Locale.US, "");

Map<Locale, String> descriptionMapContentMan = new HashMap<Locale, String>();

descriptionMapContentMan.put(Locale.US, "");

Map<Locale, String> keywordsMapContentMan = new HashMap<Locale, String>();

keywordsMapContentMan.put(Locale.US, "");

Map<Locale, String> robotsMapContentMan = new HashMap<Locale, String>();

robotsMapContentMan.put(Locale.US, "");

friendlyURLMapContentMan = "/content-management";

Layout layoutContentMan = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapContentMan, titleMapContentMan,
	descriptionMapContentMan, keywordsMapContentMan, robotsMapContentMan,
	"link_to_layout", false, friendlyURLMapContentMan, serviceContext);

layoutContentManId = layoutContentMan.getLayoutId();

Map<Locale, String> nameMapAssetP = new HashMap<Locale, String>();

nameMapAssetP.put(Locale.US, "Asset Publisher");

Map<Locale, String> titleMapAssetP = new HashMap<Locale, String>();

titleMapAssetP.put(Locale.US, "");

Map<Locale, String> descriptionMapAssetP = new HashMap<Locale, String>();

descriptionMapAssetP.put(Locale.US, "");

Map<Locale, String> keywordsMapAssetP = new HashMap<Locale, String>();

keywordsMapAssetP.put(Locale.US, "");

Map<Locale, String> robotsMapAssetP = new HashMap<Locale, String>();

robotsMapAssetP.put(Locale.US, "");

friendlyURLMapAssetP = "/asset-publisher";

Layout layoutAssetP = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapAssetP,
	titleMapAssetP, descriptionMapAssetP, keywordsMapAssetP,
	robotsMapAssetP, "portlet", false, friendlyURLMapAssetP,
	serviceContext);

Map<Locale, String> nameMapBreadcrumb = new HashMap<Locale, String>();

nameMapBreadcrumb.put(Locale.US, "Breadcrumb");

Map<Locale, String> titleMapBreadcrumb = new HashMap<Locale, String>();

titleMapBreadcrumb.put(Locale.US, "");

Map<Locale, String> descriptionMapBreadcrumb = new HashMap<Locale, String>();

descriptionMapBreadcrumb.put(Locale.US, "");

Map<Locale, String> keywordsMapBreadcrumb = new HashMap<Locale, String>();

keywordsMapBreadcrumb.put(Locale.US, "");

Map<Locale, String> robotsMapBreadcrumb = new HashMap<Locale, String>();

robotsMapBreadcrumb.put(Locale.US, "");

friendlyURLMapBreadcrumb = "/breadcrumb";

Layout layoutBreadcrumb = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapBreadcrumb,
	titleMapBreadcrumb, descriptionMapBreadcrumb, keywordsMapBreadcrumb,
	robotsMapBreadcrumb, "portlet", false, friendlyURLMapBreadcrumb,
	serviceContext);

Map<Locale, String> nameMapCN = new HashMap<Locale, String>();

nameMapCN.put(Locale.US, "Category Navigation");

Map<Locale, String> titleMapCN = new HashMap<Locale, String>();

titleMapCN.put(Locale.US, "");

Map<Locale, String> descriptionMapCN = new HashMap<Locale, String>();

descriptionMapCN.put(Locale.US, "");

Map<Locale, String> keywordsMapCN = new HashMap<Locale, String>();

keywordsMapCN.put(Locale.US, "");

Map<Locale, String> robotsMapCN = new HashMap<Locale, String>();

robotsMapCN.put(Locale.US, "");

friendlyURLMapCN = "/category-navigation";

Layout layoutCN = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapCN, titleMapCN,
	descriptionMapCN, keywordsMapCN, robotsMapCN, "portlet", false,
	friendlyURLMapCN, serviceContext);

Map<Locale, String> nameMapDM = new HashMap<Locale, String>();

nameMapDM.put(Locale.US, "Documents and Media");

Map<Locale, String> titleMapDM = new HashMap<Locale, String>();

titleMapDM.put(Locale.US, "");

Map<Locale, String> descriptionMapDM = new HashMap<Locale, String>();

descriptionMapDM.put(Locale.US, "");

Map<Locale, String> keywordsMapDM = new HashMap<Locale, String>();

keywordsMapDM.put(Locale.US, "");

Map<Locale, String> robotsMapDM = new HashMap<Locale, String>();

robotsMapDM.put(Locale.US, "");

friendlyURLMapDM = "/documents-and-media";

Layout layoutDM = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapDM, titleMapDM,
	descriptionMapDM, keywordsMapDM, robotsMapDM, "portlet", false,
	friendlyURLMapDM, serviceContext);

Map<Locale, String> nameMapNested = new HashMap<Locale, String>();

nameMapNested.put(Locale.US, "Nested Portlets");

Map<Locale, String> titleMapNested = new HashMap<Locale, String>();

titleMapNested.put(Locale.US, "");

Map<Locale, String> descriptionMapNested = new HashMap<Locale, String>();

descriptionMapNested.put(Locale.US, "");

Map<Locale, String> keywordsMapNested = new HashMap<Locale, String>();

keywordsMapNested.put(Locale.US, "");

Map<Locale, String> robotsMapNested = new HashMap<Locale, String>();

robotsMapNested.put(Locale.US, "");

friendlyURLMapNested = "/nested-portlets";

Layout layoutNested = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapNested, titleMapNested,
	descriptionMapNested, keywordsMapNested, robotsMapNested, "portlet", false,
	friendlyURLMapNested, serviceContext);

Map<Locale, String> nameMapPolls = new HashMap<Locale, String>();

nameMapPolls.put(Locale.US, "Polls Display");

Map<Locale, String> titleMapPolls = new HashMap<Locale, String>();

titleMapPolls.put(Locale.US, "");

Map<Locale, String> descriptionMapPolls = new HashMap<Locale, String>();

descriptionMapPolls.put(Locale.US, "");

Map<Locale, String> keywordsMapPolls = new HashMap<Locale, String>();

keywordsMapPolls.put(Locale.US, "");

Map<Locale, String> robotsMapPolls = new HashMap<Locale, String>();

robotsMapPolls.put(Locale.US, "");

friendlyURLMapPolls = "/polls-display";

Layout layoutPolls = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapPolls,
	titleMapPolls, descriptionMapPolls, keywordsMapPolls, robotsMapPolls,
	"portlet", false, friendlyURLMapPolls, serviceContext);

Map<Locale, String> nameMapRD = new HashMap<Locale, String>();

nameMapRD.put(Locale.US, "Recent Downloads");

Map<Locale, String> titleMapRD = new HashMap<Locale, String>();

titleMapRD.put(Locale.US, "");

Map<Locale, String> descriptionMapRD = new HashMap<Locale, String>();

descriptionMapRD.put(Locale.US, "");

Map<Locale, String> keywordsMapRD = new HashMap<Locale, String>();

keywordsMapRD.put(Locale.US, "");

Map<Locale, String> robotsMapRD = new HashMap<Locale, String>();

robotsMapRD.put(Locale.US, "");

friendlyURLMapRD = "/recent-downloads";

Layout layoutRD = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapRD, titleMapRD,
	descriptionMapRD, keywordsMapRD, robotsMapRD, "portlet", false,
	friendlyURLMapRD, serviceContext);

Map<Locale, String> nameMapRA = new HashMap<Locale, String>();

nameMapRA.put(Locale.US, "Related Assets");

Map<Locale, String> titleMapRA = new HashMap<Locale, String>();

titleMapRA.put(Locale.US, "");

Map<Locale, String> descriptionMapRA = new HashMap<Locale, String>();

descriptionMapRA.put(Locale.US, "");

Map<Locale, String> keywordsMapRA = new HashMap<Locale, String>();

keywordsMapRA.put(Locale.US, "");

Map<Locale, String> robotsMapRA = new HashMap<Locale, String>();

robotsMapRA.put(Locale.US, "");

friendlyURLMapRA = "/related-assets";

Layout layoutRA = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapRA, titleMapRA,
	descriptionMapRA, keywordsMapRA, robotsMapRA, "portlet", false,
	friendlyURLMapRA, serviceContext);

Map<Locale, String> nameMapSiteMap = new HashMap<Locale, String>();

nameMapSiteMap.put(Locale.US, "Site Map");

Map<Locale, String> titleMapSiteMap = new HashMap<Locale, String>();

titleMapSiteMap.put(Locale.US, "");

Map<Locale, String> descriptionMapSiteMap = new HashMap<Locale, String>();

descriptionMapSiteMap.put(Locale.US, "");

Map<Locale, String> keywordsMapSiteMap = new HashMap<Locale, String>();

keywordsMapSiteMap.put(Locale.US, "");

Map<Locale, String> robotsMapSiteMap = new HashMap<Locale, String>();

robotsMapSiteMap.put(Locale.US, "");

friendlyURLMapSiteMap = "/site-map";

Layout layoutSiteMap = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapSiteMap,
	titleMapSiteMap, descriptionMapSiteMap, keywordsMapSiteMap,
	robotsMapSiteMap, "portlet", false, friendlyURLMapSiteMap,
	serviceContext);

Map<Locale, String> nameMapTag = new HashMap<Locale, String>();

nameMapTag.put(Locale.US, "Tag Cloud");

Map<Locale, String> titleMapTag = new HashMap<Locale, String>();

titleMapTag.put(Locale.US, "");

Map<Locale, String> descriptionMapTag = new HashMap<Locale, String>();

descriptionMapTag.put(Locale.US, "");

Map<Locale, String> keywordsMapTag = new HashMap<Locale, String>();

keywordsMapTag.put(Locale.US, "");

Map<Locale, String> robotsMapTag = new HashMap<Locale, String>();

robotsMapTag.put(Locale.US, "");

friendlyURLMapTag = "/tag-cloud";

Layout layoutTag = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapTag, titleMapTag,
	descriptionMapTag, keywordsMapTag, robotsMapTag, "portlet", false,
	friendlyURLMapTag, serviceContext);

Map<Locale, String> nameMapWC = new HashMap<Locale, String>();

nameMapWC.put(Locale.US, "Web Content");

Map<Locale, String> titleMapWC = new HashMap<Locale, String>();

titleMapWC.put(Locale.US, "");

Map<Locale, String> descriptionMapWC = new HashMap<Locale, String>();

descriptionMapWC.put(Locale.US, "");

Map<Locale, String> keywordsMapWC = new HashMap<Locale, String>();

keywordsMapWC.put(Locale.US, "");

Map<Locale, String> robotsMapWC = new HashMap<Locale, String>();

robotsMapWC.put(Locale.US, "");

friendlyURLMapWC = "/web-content";

Layout layoutWC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapWC, titleMapWC,
	descriptionMapWC, keywordsMapWC, robotsMapWC, "portlet", false,
	friendlyURLMapWC, serviceContext);

Map<Locale, String> nameMapXSL = new HashMap<Locale, String>();

nameMapXSL.put(Locale.US, "XSL Content");

Map<Locale, String> titleMapXSL = new HashMap<Locale, String>();

titleMapXSL.put(Locale.US, "");

Map<Locale, String> descriptionMapXSL = new HashMap<Locale, String>();

descriptionMapXSL.put(Locale.US, "");

Map<Locale, String> keywordsMapXSL = new HashMap<Locale, String>();

keywordsMapXSL.put(Locale.US, "");

Map<Locale, String> robotsMapXSL = new HashMap<Locale, String>();

robotsMapXSL.put(Locale.US, "");

friendlyURLMapXSL = "/xsl-content";

Layout layoutXSL = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutContentManId, nameMapXSL, titleMapXSL,
	descriptionMapXSL, keywordsMapXSL, robotsMapXSL, "portlet", false,
	friendlyURLMapXSL, serviceContext);

// Content Management page link to asset publish page.

UnicodeProperties typeSettingsPropertiesContentMan =
	layoutContentMan.getTypeSettingsProperties();

typeSettingsPropertiesContentMan.setProperty(
	"groupId", String.valueOf(groupId));
typeSettingsPropertiesContentMan.setProperty("show-alternate-links", "true");
typeSettingsPropertiesContentMan.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesContentMan.setProperty(
	"linkToLayoutId", String.valueOf(layoutAssetP.getLayoutId()));
typeSettingsPropertiesContentMan.setProperty("sitemap-include", "1");
typeSettingsPropertiesContentMan.setProperty(
	"layout-template-id", "2_columns_ii");

layoutContentMan.setTypeSettingsProperties(typeSettingsPropertiesContentMan);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutContentManId,
	layoutContentMan.getTypeSettings());
