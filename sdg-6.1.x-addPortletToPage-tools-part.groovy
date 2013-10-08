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

// Dictionary page

Layout layoutDictionary = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/dictionary");

UnicodeProperties typeSettingsPropertiesDictionary =
	layoutDictionary.getTypeSettingsProperties();

typeSettingsPropertiesDictionary.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesDictionary.setProperty("column-2", "23");
typeSettingsPropertiesDictionary.setProperty(
	"column-1", "71_INSTANCE_CUiKVFT7IRBd,");

layoutDictionary.setTypeSettingsProperties(typeSettingsPropertiesDictionary);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutDictionary.getLayoutId(),
	layoutDictionary.getTypeSettings());

UnicodeProperties propertiesDictionary = new UnicodeProperties();

propertiesDictionary.setProperty("displayStyle", "from-level-0");
propertiesDictionary.setProperty("headerType", "root-layout");
propertiesDictionary.setProperty("bulletStyle", "dots");
propertiesDictionary.setProperty("rootLayoutType", "absolute");
propertiesDictionary.setProperty("includedLayouts", "auto");
propertiesDictionary.setProperty("nestedChildren", "1");
propertiesDictionary.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceDictionary", "71_INSTANCE_CUiKVFT7IRBd");

portletResourceDictionary = (String)actionRequest.getAttribute(
	"portletResourceDictionary");

PortletPreferences portletPreferencesDictionary =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceDictionary);

for (Map.Entry<String, String> entry : propertiesDictionary.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesDictionary.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutDictionary.getPlid(), "71_INSTANCE_CUiKVFT7IRBd",
	portletPreferencesDictionary);

// Language portlet page

Layout layoutLanguage = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/language-portlet");

UnicodeProperties typeSettingsPropertiesLanguage =
	layoutLanguage.getTypeSettingsProperties();

typeSettingsPropertiesLanguage.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesLanguage.setProperty("column-2", "82");
typeSettingsPropertiesLanguage.setProperty(
	"column-1", "71_INSTANCE_7h25Ypo7Byd4,");

layoutLanguage.setTypeSettingsProperties(typeSettingsPropertiesLanguage);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutLanguage.getLayoutId(),
	layoutLanguage.getTypeSettings());

UnicodeProperties propertiesLanguage = new UnicodeProperties();

propertiesLanguage.setProperty("displayStyle", "from-level-0");
propertiesLanguage.setProperty("headerType", "root-layout");
propertiesLanguage.setProperty("bulletStyle", "dots");
propertiesLanguage.setProperty("rootLayoutType", "absolute");
propertiesLanguage.setProperty("includedLayouts", "auto");
propertiesLanguage.setProperty("nestedChildren", "1");
propertiesLanguage.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceLanguage", "71_INSTANCE_7h25Ypo7Byd4");

portletResourceLanguage = (String)actionRequest.getAttribute(
	"portletResourceLanguage");

PortletPreferences portletPreferencesLanguage =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceLanguage);

for (Map.Entry<String, String> entry : propertiesLanguage.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesLanguage.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutLanguage.getPlid(), "71_INSTANCE_7h25Ypo7Byd4",
	portletPreferencesLanguage);

// Network utilities page

Layout layoutNU = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/network-utilities");

UnicodeProperties typeSettingsPropertiesNU =
	layoutNU.getTypeSettingsProperties();

typeSettingsPropertiesNU.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesNU.setProperty("column-2", "30");
typeSettingsPropertiesNU.setProperty("column-1", "71_INSTANCE_rT4G4vSmVqOL,");

layoutNU.setTypeSettingsProperties(typeSettingsPropertiesNU);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutNU.getLayoutId(),
	layoutNU.getTypeSettings());

UnicodeProperties propertiesNU = new UnicodeProperties();

propertiesNU.setProperty("displayStyle", "from-level-0");
propertiesNU.setProperty("headerType", "root-layout");
propertiesNU.setProperty("bulletStyle", "dots");
propertiesNU.setProperty("rootLayoutType", "absolute");
propertiesNU.setProperty("includedLayouts", "auto");
propertiesNU.setProperty("nestedChildren", "1");
propertiesNU.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceNU", "71_INSTANCE_rT4G4vSmVqOL");

portletResourceNU = (String)actionRequest.getAttribute("portletResourceNU");

PortletPreferences portletPreferencesNU =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceNU);

for (Map.Entry<String, String> entry : propertiesNU.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesNU.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutNU.getPlid(), "71_INSTANCE_rT4G4vSmVqOL",
	portletPreferencesNU);

// Password generator page

Layout layoutPG = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/password-generator");

UnicodeProperties typeSettingsPropertiesPG =
	layoutPG.getTypeSettingsProperties();

typeSettingsPropertiesPG.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesPG.setProperty("column-2", "70");
typeSettingsPropertiesPG.setProperty("column-1", "71_INSTANCE_U1NyroFwJGZ4,");

layoutPG.setTypeSettingsProperties(typeSettingsPropertiesPG);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutPG.getLayoutId(),
	layoutPG.getTypeSettings());

UnicodeProperties propertiesPG = new UnicodeProperties();

propertiesPG.setProperty("displayStyle", "from-level-0");
propertiesPG.setProperty("headerType", "root-layout");
propertiesPG.setProperty("bulletStyle", "dots");
propertiesPG.setProperty("rootLayoutType", "absolute");
propertiesPG.setProperty("includedLayouts", "auto");
propertiesPG.setProperty("nestedChildren", "1");
propertiesPG.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourcePG", "71_INSTANCE_U1NyroFwJGZ4");

portletResourcePG = (String)actionRequest.getAttribute("portletResourcePG");

PortletPreferences portletPreferencesPG =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourcePG);

for (Map.Entry<String, String> entry : propertiesPG.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesPG.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutPG.getPlid(), "71_INSTANCE_U1NyroFwJGZ4",
	portletPreferencesPG);

// Quick note page

Layout layoutQN = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/quick-note");

UnicodeProperties typeSettingsPropertiesQN =
	layoutQN.getTypeSettingsProperties();

typeSettingsPropertiesQN.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesQN.setProperty("column-2", "97_INSTANCE_a1SJg50KuLFc");
typeSettingsPropertiesQN.setProperty("column-1", "71_INSTANCE_FPD3mqOPjU8G,");

layoutQN.setTypeSettingsProperties(typeSettingsPropertiesQN);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutQN.getLayoutId(),
	layoutQN.getTypeSettings());

UnicodeProperties propertiesQN = new UnicodeProperties();

propertiesQN.setProperty("displayStyle", "from-level-0");
propertiesQN.setProperty("headerType", "root-layout");
propertiesQN.setProperty("bulletStyle", "dots");
propertiesQN.setProperty("rootLayoutType", "absolute");
propertiesQN.setProperty("includedLayouts", "auto");
propertiesQN.setProperty("nestedChildren", "1");
propertiesQN.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceQN", "71_INSTANCE_FPD3mqOPjU8G");

portletResourceQN = (String)actionRequest.getAttribute("portletResourceQN");

PortletPreferences portletPreferencesQN =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceQN);

for (Map.Entry<String, String> entry : propertiesQN.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesQN.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutQN.getPlid(), "71_INSTANCE_FPD3mqOPjU8G",
	portletPreferencesQN);

// Search page

Layout layoutSearch = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/search");

UnicodeProperties typeSettingsPropertiesSearch =
	layoutSearch.getTypeSettingsProperties();

typeSettingsPropertiesSearch.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesSearch.setProperty("column-2", "3");
typeSettingsPropertiesSearch.setProperty(
	"column-1", "71_INSTANCE_7rd4A6QxGxX8,");

layoutSearch.setTypeSettingsProperties(typeSettingsPropertiesSearch);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSearch.getLayoutId(),
	layoutSearch.getTypeSettings());

UnicodeProperties propertiesSearch = new UnicodeProperties();

propertiesSearch.setProperty("displayStyle", "from-level-0");
propertiesSearch.setProperty("headerType", "root-layout");
propertiesSearch.setProperty("bulletStyle", "dots");
propertiesSearch.setProperty("rootLayoutType", "absolute");
propertiesSearch.setProperty("includedLayouts", "auto");
propertiesSearch.setProperty("nestedChildren", "1");
propertiesSearch.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceSearch", "71_INSTANCE_7rd4A6QxGxX8");

portletResourceSearch = (String)actionRequest.getAttribute(
	"portletResourceSearch");

PortletPreferences portletPreferencesSearch =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceSearch);

for (Map.Entry<String, String> entry : propertiesSearch.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesSearch.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutSearch.getPlid(), "71_INSTANCE_7rd4A6QxGxX8",
	portletPreferencesSearch);

// Sign in page

Layout layoutSignIn = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/sign-in");

UnicodeProperties typeSettingsPropertiesSignIn =
	layoutSignIn.getTypeSettingsProperties();

typeSettingsPropertiesSignIn.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesSignIn.setProperty("column-2", "58");
typeSettingsPropertiesSignIn.setProperty(
	"column-1", "71_INSTANCE_shdK63UBb9yk,");

layoutSignIn.setTypeSettingsProperties(typeSettingsPropertiesSignIn);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSignIn.getLayoutId(),
	layoutSignIn.getTypeSettings());

UnicodeProperties propertiesSignIn = new UnicodeProperties();

propertiesSignIn.setProperty("displayStyle", "from-level-0");
propertiesSignIn.setProperty("headerType", "root-layout");
propertiesSignIn.setProperty("bulletStyle", "dots");
propertiesSignIn.setProperty("rootLayoutType", "absolute");
propertiesSignIn.setProperty("includedLayouts", "auto");
propertiesSignIn.setProperty("nestedChildren", "1");
propertiesSignIn.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceSignIn", "71_INSTANCE_shdK63UBb9yk");

portletResourceSignIn = (String)actionRequest.getAttribute(
	"portletResourceSignIn");

PortletPreferences portletPreferencesSignIn =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceSignIn);

for (Map.Entry<String, String> entry : propertiesSignIn.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesSignIn.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutSignIn.getPlid(), "71_INSTANCE_shdK63UBb9yk",
	portletPreferencesSignIn);

// Software catalog page

Layout layoutSC = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/software-catalog");

UnicodeProperties typeSettingsPropertiesSC =
	layoutSC.getTypeSettingsProperties();

typeSettingsPropertiesSC.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesSC.setProperty("column-2", "98");
typeSettingsPropertiesSC.setProperty("column-1", "71_INSTANCE_X6zDk2NRQIS0,");

layoutSC.setTypeSettingsProperties(typeSettingsPropertiesSC);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutSC.getLayoutId(),
	layoutSC.getTypeSettings());

UnicodeProperties propertiesSC = new UnicodeProperties();

propertiesSC.setProperty("displayStyle", "from-level-0");
propertiesSC.setProperty("headerType", "root-layout");
propertiesSC.setProperty("bulletStyle", "dots");
propertiesSC.setProperty("rootLayoutType", "absolute");
propertiesSC.setProperty("includedLayouts", "auto");
propertiesSC.setProperty("nestedChildren", "1");
propertiesSC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceSC", "71_INSTANCE_X6zDk2NRQIS0");

portletResourceSC = (String)actionRequest.getAttribute("portletResourceSC");

PortletPreferences portletPreferencesSC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceSC);

for (Map.Entry<String, String> entry : propertiesSC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesSC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutSC.getPlid(), "71_INSTANCE_X6zDk2NRQIS0",
	portletPreferencesSC);

// Translator page

Layout layoutTranslator = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/translator");


UnicodeProperties typeSettingsPropertiesTranslator =
	layoutTranslator.getTypeSettingsProperties();

typeSettingsPropertiesTranslator.setProperty(
	"layout-template-id", "2_columns_ii");
typeSettingsPropertiesTranslator.setProperty("column-2", "26");
typeSettingsPropertiesTranslator.setProperty(
	"column-1", "71_INSTANCE_3mDQzC5CSJCA,");

layoutTranslator.setTypeSettingsProperties(typeSettingsPropertiesTranslator);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutTranslator.getLayoutId(),
	layoutTranslator.getTypeSettings());

UnicodeProperties propertiesTranslator = new UnicodeProperties();

propertiesTranslator.setProperty("displayStyle", "from-level-0");
propertiesTranslator.setProperty("headerType", "root-layout");
propertiesTranslator.setProperty("bulletStyle", "dots");
propertiesTranslator.setProperty("rootLayoutType", "absolute");
propertiesTranslator.setProperty("includedLayouts", "auto");
propertiesTranslator.setProperty("nestedChildren", "1");
propertiesTranslator.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute(
	"portletResourceTranslator", "71_INSTANCE_3mDQzC5CSJCA");

portletResourceTranslator = (String)actionRequest.getAttribute(
	"portletResourceTranslator");

PortletPreferences portletPreferencesTranslator =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceTranslator);

for (Map.Entry<String, String> entry : propertiesTranslator.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesTranslator.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutTranslator.getPlid(), "71_INSTANCE_3mDQzC5CSJCA",
	portletPreferencesTranslator);

// Unit converter page

Layout layoutUC = LayoutLocalServiceUtil.getFriendlyURLLayout(
	groupId, false, "/unit-converter");

UnicodeProperties typeSettingsPropertiesUC =
	layoutUC.getTypeSettingsProperties();

typeSettingsPropertiesUC.setProperty("layout-template-id", "2_columns_ii");
typeSettingsPropertiesUC.setProperty("column-2", "27");
typeSettingsPropertiesUC.setProperty("column-1", "71_INSTANCE_vMl8RSCKxaP8,");

layoutUC.setTypeSettingsProperties(typeSettingsPropertiesUC);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutUC.getLayoutId(),
	layoutUC.getTypeSettings());

UnicodeProperties propertiesUC = new UnicodeProperties();

propertiesUC.setProperty("displayStyle", "from-level-0");
propertiesUC.setProperty("headerType", "root-layout");
propertiesUC.setProperty("bulletStyle", "dots");
propertiesUC.setProperty("rootLayoutType", "absolute");
propertiesUC.setProperty("includedLayouts", "auto");
propertiesUC.setProperty("nestedChildren", "1");
propertiesUC.setProperty("rootLayoutLevel", "1");

actionRequest.setAttribute("portletResourceUC", "71_INSTANCE_vMl8RSCKxaP8");

portletResourceUC = (String)actionRequest.getAttribute("portletResourceUC");

PortletPreferences portletPreferencesUC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceUC);

for (Map.Entry<String, String> entry : propertiesUC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesUC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutUC.getPlid(), "71_INSTANCE_vMl8RSCKxaP8",
	portletPreferencesUC);
