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

// Shopping part

Map<Locale, String> nameMapShoppingP = new HashMap<Locale, String>();

nameMapShoppingP.put(Locale.US, "Shopping");

Map<Locale, String> titleMapShoppingP = new HashMap<Locale, String>();

titleMapShoppingP.put(Locale.US, "");

Map<Locale, String> descriptionMapShoppingP = new HashMap<Locale, String>();

descriptionMapShoppingP.put(Locale.US, "");

Map<Locale, String> keywordsMapShoppingP = new HashMap<Locale, String>();

keywordsMapShoppingP.put(Locale.US, "");

Map<Locale, String> robotsMapShoppingP = new HashMap<Locale, String>();

robotsMapShoppingP.put(Locale.US, "");

friendlyURLMapShoppingP = "/shopping";

Layout shoppingLayout = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapShoppingP, titleMapShoppingP,
	descriptionMapShoppingP, keywordsMapShoppingP, robotsMapShoppingP,
	"link_to_layout", false, friendlyURLMapShoppingP, serviceContext);

shoppingLayoutId = shoppingLayout.getLayoutId();

Map<Locale, String> nameMapAmazon = new HashMap<Locale, String>();

nameMapAmazon.put(Locale.US, "Amazon Rankings");

Map<Locale, String> titleMapAmazon = new HashMap<Locale, String>();

titleMapAmazon.put(Locale.US, "");

Map<Locale, String> descriptionMapAmazon = new HashMap<Locale, String>();

descriptionMapAmazon.put(Locale.US, "");

Map<Locale, String> keywordsMapAmazon = new HashMap<Locale, String>();

keywordsMapAmazon.put(Locale.US, "");

Map<Locale, String> robotsMapAmazon = new HashMap<Locale, String>();

robotsMapAmazon.put(Locale.US, "");

friendlyURLMapAmazon = "/amazon-rankings";

Layout layoutAmazon = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, shoppingLayoutId, nameMapAmazon,
	titleMapAmazon, descriptionMapAmazon, keywordsMapAmazon,
	robotsMapAmazon, "portlet", false, friendlyURLMapAmazon,
	serviceContext);

Map<Locale, String> nameMapShopping = new HashMap<Locale, String>();

nameMapShopping.put(Locale.US, "Shopping Portlet");

Map<Locale, String> titleMapShopping = new HashMap<Locale, String>();

titleMapShopping.put(Locale.US, "");

Map<Locale, String> descriptionMapShopping = new HashMap<Locale, String>();

descriptionMapShopping.put(Locale.US, "");

Map<Locale, String> keywordsMapShopping = new HashMap<Locale, String>();

keywordsMapShopping.put(Locale.US, "");

Map<Locale, String> robotsMapShopping = new HashMap<Locale, String>();

robotsMapShopping.put(Locale.US, "");

friendlyURLMapShopping = "/shopping-portlet";

Layout layoutShopping = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, shoppingLayoutId, nameMapShopping,
	titleMapShopping, descriptionMapShopping, keywordsMapShopping,
	robotsMapShopping, "portlet", false, friendlyURLMapShopping,
	serviceContext);

// Shopping page links to amazon rankings page.

UnicodeProperties typeSettingsPropertiesS =
	shoppingLayout.getTypeSettingsProperties();

typeSettingsPropertiesS.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesS.setProperty("show-alternate-links", "true");
typeSettingsPropertiesS.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesS.setProperty(
	"linkToLayoutId", String.valueOf(layoutAmazon.getLayoutId()));
typeSettingsPropertiesS.setProperty("sitemap-include", "1");
typeSettingsPropertiesS.setProperty("layout-template-id", "2_columns_ii");

shoppingLayout.setTypeSettingsProperties(typeSettingsPropertiesS);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, shoppingLayoutId, shoppingLayout.getTypeSettings());
