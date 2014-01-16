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

// Finace part

Map<Locale, String> nameMapFinance = new HashMap<Locale, String>();

nameMapFinance.put(Locale.US, "Finance");

Map<Locale, String> titleMapFinance = new HashMap<Locale, String>();

titleMapFinance.put(Locale.US, "");

Map<Locale, String> descriptionMapFinance = new HashMap<Locale, String>();

descriptionMapFinance.put(Locale.US, "");

Map<Locale, String> keywordsMapFinance = new HashMap<Locale, String>();

keywordsMapFinance.put(Locale.US, "");

Map<Locale, String> robotsMapFinance = new HashMap<Locale, String>();

robotsMapFinance.put(Locale.US, "");

friendlyURLMapFinance = "/finance";

Layout layoutFinance = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapFinance, titleMapFinance,
	descriptionMapFinance, keywordsMapFinance, robotsMapFinance,
	"link_to_layout", false, friendlyURLMapFinance, serviceContext);

layoutFinanceId = layoutFinance.getLayoutId();

Map<Locale, String> nameMapCC = new HashMap<Locale, String>();

nameMapCC.put(Locale.US, "Currency Converter");

Map<Locale, String> titleMapCC = new HashMap<Locale, String>();

titleMapCC.put(Locale.US, "");

Map<Locale, String> descriptionMapCC = new HashMap<Locale, String>();

descriptionMapCC.put(Locale.US, "");

Map<Locale, String> keywordsMapCC = new HashMap<Locale, String>();

keywordsMapCC.put(Locale.US, "");

Map<Locale, String> robotsMapCC = new HashMap<Locale, String>();

robotsMapCC.put(Locale.US, "");

friendlyURLMapCC = "/currency-converter";

Layout layoutCC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutFinanceId, nameMapCC, titleMapCC,
	descriptionMapCC, keywordsMapCC, robotsMapCC, "portlet", false,
	friendlyURLMapCC, serviceContext);

Map<Locale, String> nameMapLC = new HashMap<Locale, String>();

nameMapLC.put(Locale.US, "Loan Calculator");

Map<Locale, String> titleMapLC = new HashMap<Locale, String>();

titleMapLC.put(Locale.US, "");

Map<Locale, String> descriptionMapLC = new HashMap<Locale, String>();

descriptionMapLC.put(Locale.US, "");

Map<Locale, String> keywordsMapLC = new HashMap<Locale, String>();

keywordsMapLC.put(Locale.US, "");

Map<Locale, String> robotsMapLC = new HashMap<Locale, String>();

robotsMapLC.put(Locale.US, "");

friendlyURLMapLC = "/loan-calculator";

Layout layoutLC = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutFinanceId, nameMapLC, titleMapLC,
	descriptionMapLC, keywordsMapLC, robotsMapLC, "portlet", false,
	friendlyURLMapLC, serviceContext);

// Finance page links to currency converter page.

UnicodeProperties typeSettingsPropertiesFinance =
	layoutFinance.getTypeSettingsProperties();

typeSettingsPropertiesFinance.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesFinance.setProperty("show-alternate-links", "true");
typeSettingsPropertiesFinance.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesFinance.setProperty(
	"linkToLayoutId", String.valueOf(layoutCC.getLayoutId()));
typeSettingsPropertiesFinance.setProperty("sitemap-include", "1");
typeSettingsPropertiesFinance.setProperty("layout-template-id", "2_columns_ii");

layoutFinance.setTypeSettingsProperties(typeSettingsPropertiesFinance);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutFinanceId, layoutFinance.getTypeSettings());

