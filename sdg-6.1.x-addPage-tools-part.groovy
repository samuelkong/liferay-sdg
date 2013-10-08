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

// Tools part

Map<Locale, String> nameMapTools = new HashMap<Locale, String>();

nameMapTools.put(Locale.US, "Tools");

Map<Locale, String> titleMapTools = new HashMap<Locale, String>();

titleMapTools.put(Locale.US, "");

Map<Locale, String> descriptionMapTools = new HashMap<Locale, String>();

descriptionMapTools.put(Locale.US, "");

Map<Locale, String> keywordsMapTools = new HashMap<Locale, String>();

keywordsMapTools.put(Locale.US, "");

Map<Locale, String> robotsMapTools = new HashMap<Locale, String>();

robotsMapTools.put(Locale.US, "");

friendlyURLMapTools = "/tools";

Layout layoutTools = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapTools, titleMapTools,
	descriptionMapTools, keywordsMapTools, robotsMapTools,
	"link_to_layout", false, friendlyURLMapTools, serviceContext);

layoutToolsId = layoutTools.getLayoutId();

Map<Locale, String> nameMapDictionary = new HashMap<Locale, String>();

nameMapDictionary.put(Locale.US, "Dictionary");

Map<Locale, String> titleMapDictionary = new HashMap<Locale, String>();

titleMapDictionary.put(Locale.US, "");

Map<Locale, String> descriptionMapDictionary = new HashMap<Locale, String>();

descriptionMapDictionary.put(Locale.US, "");

Map<Locale, String> keywordsMapDictionary = new HashMap<Locale, String>();

keywordsMapDictionary.put(Locale.US, "");

Map<Locale, String> robotsMapDictionary = new HashMap<Locale, String>();

robotsMapDictionary.put(Locale.US, "");

friendlyURLMapDictionary = "/dictionary";

Layout layoutDictionary = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapDictionary,
	titleMapDictionary, descriptionMapDictionary, keywordsMapDictionary,
	robotsMapDictionary, "portlet", false, friendlyURLMapDictionary,
	serviceContext);

Map<Locale, String> nameMapLanguage = new HashMap<Locale, String>();

nameMapLanguage.put(Locale.US, "Language Portlet");

Map<Locale, String> titleMapLanguage = new HashMap<Locale, String>();

titleMapLanguage.put(Locale.US, "");

Map<Locale, String> descriptionMapLanguage = new HashMap<Locale, String>();

descriptionMapLanguage.put(Locale.US, "");

Map<Locale, String> keywordsMapLanguage = new HashMap<Locale, String>();

keywordsMapLanguage.put(Locale.US, "");

Map<Locale, String> robotsMapLanguage = new HashMap<Locale, String>();

robotsMapLanguage.put(Locale.US, "");

friendlyURLMapLanguage = "/language-portlet";

Layout layoutLanguage = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapLanguage,
	titleMapLanguage, descriptionMapLanguage, keywordsMapLanguage,
	robotsMapLanguage, "portlet", false, friendlyURLMapLanguage,
	serviceContext);

Map<Locale, String> nameMapNU = new HashMap<Locale, String>();

nameMapNU.put(Locale.US, "Network Utilities");

Map<Locale, String> titleMapNU = new HashMap<Locale, String>();

titleMapNU.put(Locale.US, "");

Map<Locale, String> descriptionMapNU = new HashMap<Locale, String>();

descriptionMapNU.put(Locale.US, "");

Map<Locale, String> keywordsMapNU = new HashMap<Locale, String>();

keywordsMapNU.put(Locale.US, "");

Map<Locale, String> robotsMapNU = new HashMap<Locale, String>();

robotsMapNU.put(Locale.US, "");

friendlyURLMapNU = "/network-utilities";

Layout layoutNU = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapNU, titleMapNU,
	descriptionMapNU, keywordsMapNU, robotsMapNU, "portlet", false,
	friendlyURLMapNU, serviceContext);

Map<Locale, String> nameMapPG = new HashMap<Locale, String>();

nameMapPG.put(Locale.US, "Password Generator");

Map<Locale, String> titleMapPG = new HashMap<Locale, String>();

titleMapPG.put(Locale.US, "");

Map<Locale, String> descriptionMapPG = new HashMap<Locale, String>();

descriptionMapPG.put(Locale.US, "");

Map<Locale, String> keywordsMapPG = new HashMap<Locale, String>();

keywordsMapPG.put(Locale.US, "");

Map<Locale, String> robotsMapPG = new HashMap<Locale, String>();

robotsMapPG.put(Locale.US, "");

friendlyURLMapPG = "/password-generator";

Layout layoutPG = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapPG, titleMapPG,
	descriptionMapPG, keywordsMapPG, robotsMapPG, "portlet", false,
	friendlyURLMapPG, serviceContext);

Map<Locale, String> nameMapQN = new HashMap<Locale, String>();

nameMapQN.put(Locale.US, "Quick Note");

Map<Locale, String> titleMapQN = new HashMap<Locale, String>();

titleMapQN.put(Locale.US, "");

Map<Locale, String> descriptionMapQN = new HashMap<Locale, String>();

descriptionMapQN.put(Locale.US, "");

Map<Locale, String> keywordsMapQN = new HashMap<Locale, String>();

keywordsMapQN.put(Locale.US, "");

Map<Locale, String> robotsMapQN = new HashMap<Locale, String>();

robotsMapQN.put(Locale.US, "");

friendlyURLMapQN = "/quick-note";

Layout layoutQN = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapQN, titleMapQN,
	descriptionMapQN, keywordsMapQN, robotsMapQN, "portlet", false,
	friendlyURLMapQN, serviceContext);

Map<Locale, String> nameMapSearch = new HashMap<Locale, String>();

nameMapSearch.put(Locale.US, "Search");

Map<Locale, String> titleMapSearch = new HashMap<Locale, String>();

titleMapSearch.put(Locale.US, "");

Map<Locale, String> descriptionMapSearch = new HashMap<Locale, String>();

descriptionMapSearch.put(Locale.US, "");

Map<Locale, String> keywordsMapSearch = new HashMap<Locale, String>();

keywordsMapSearch.put(Locale.US, "");

Map<Locale, String> robotsMapSearch = new HashMap<Locale, String>();

robotsMapSearch.put(Locale.US, "");

friendlyURLMapSearch = "/search";

Layout layoutSearch = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapSearch, titleMapSearch,
	descriptionMapSearch, keywordsMapSearch, robotsMapSearch, "portlet",
	false, friendlyURLMapSearch, serviceContext);

Map<Locale, String> nameMapSignIn = new HashMap<Locale, String>();

nameMapSignIn.put(Locale.US, "Sign In");

Map<Locale, String> titleMapSignIn = new HashMap<Locale, String>();

titleMapSignIn.put(Locale.US, "");

Map<Locale, String> descriptionMapSignIn = new HashMap<Locale, String>();

descriptionMapSignIn.put(Locale.US, "");

Map<Locale, String> keywordsMapSignIn = new HashMap<Locale, String>();

keywordsMapSignIn.put(Locale.US, "");

Map<Locale, String> robotsMapSignIn = new HashMap<Locale, String>();

robotsMapSignIn.put(Locale.US, "");

friendlyURLMapSignIn = "/sign-in";

Layout layoutSignIn = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapSignIn, titleMapSignIn,
	descriptionMapSignIn, keywordsMapSignIn, robotsMapSignIn, "portlet",
	false, friendlyURLMapSignIn, serviceContext);

Map<Locale, String> nameMapSC = new HashMap<Locale, String>();

nameMapSC.put(Locale.US, "Software Catalog");

Map<Locale, String> titleMapSC = new HashMap<Locale, String>();

titleMapSC.put(Locale.US, "");

Map<Locale, String> descriptionMapSC = new HashMap<Locale, String>();

descriptionMapSC.put(Locale.US, "");

Map<Locale, String> keywordsMapSC = new HashMap<Locale, String>();

keywordsMapSC.put(Locale.US, "");

Map<Locale, String> robotsMapSC = new HashMap<Locale, String>();

robotsMapSC.put(Locale.US, "");

friendlyURLMapSC = "/software-catalog";

Layout layoutSC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapSC, titleMapSC,
	descriptionMapSC, keywordsMapSC, robotsMapSC, "portlet", false,
	friendlyURLMapSC, serviceContext);

Map<Locale, String> nameMapTranslator = new HashMap<Locale, String>();

nameMapTranslator.put(Locale.US, "Translator");

Map<Locale, String> titleMapTranslator = new HashMap<Locale, String>();

titleMapTranslator.put(Locale.US, "");

Map<Locale, String> descriptionMapTranslator = new HashMap<Locale, String>();

descriptionMapTranslator.put(Locale.US, "");

Map<Locale, String> keywordsMapTranslator = new HashMap<Locale, String>();

keywordsMapTranslator.put(Locale.US, "");

Map<Locale, String> robotsMapTranslator = new HashMap<Locale, String>();

robotsMapTranslator.put(Locale.US, "");

friendlyURLMapTranslator = "/translator";

Layout layoutTranslator = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapTranslator,
	titleMapTranslator, descriptionMapTranslator, keywordsMapTranslator,
	robotsMapTranslator, "portlet", false, friendlyURLMapTranslator,
	serviceContext);

Map<Locale, String> nameMapUC = new HashMap<Locale, String>();

nameMapUC.put(Locale.US, "Unit Converter");

Map<Locale, String> titleMapUC = new HashMap<Locale, String>();

titleMapUC.put(Locale.US, "");

Map<Locale, String> descriptionMapUC = new HashMap<Locale, String>();

descriptionMapUC.put(Locale.US, "");

Map<Locale, String> keywordsMapUC = new HashMap<Locale, String>();

keywordsMapUC.put(Locale.US, "");

Map<Locale, String> robotsMapUC = new HashMap<Locale, String>();

robotsMapUC.put(Locale.US, "");

friendlyURLMapUC = "/unit-converter";

Layout layoutUC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutToolsId, nameMapUC, titleMapUC,
	descriptionMapUC, keywordsMapUC, robotsMapUC, "portlet", false,
	friendlyURLMapUC, serviceContext);

// Tools page links to dictionary page.

UnicodeProperties typeSettingsPropertiesTools =
	layoutTools.getTypeSettingsProperties();

typeSettingsPropertiesTools.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesTools.setProperty("show-alternate-links", "true");
typeSettingsPropertiesTools.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesTools.setProperty(
	"linkToLayoutId", String.valueOf(layoutDictionary.getLayoutId()));
typeSettingsPropertiesTools.setProperty("sitemap-include", "1");
typeSettingsPropertiesTools.setProperty("layout-template-id", "2_columns_ii");

layoutTools.setTypeSettingsProperties(typeSettingsPropertiesTools);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutToolsId, layoutTools.getTypeSettings());
