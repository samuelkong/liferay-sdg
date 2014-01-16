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

// News part

Map<Locale, String> nameMapNews = new HashMap<Locale, String>();

nameMapNews.put(Locale.US, "News");

Map<Locale, String> titleMapNews = new HashMap<Locale, String>();

titleMapNews.put(Locale.US, "");

Map<Locale, String> descriptionMapNews = new HashMap<Locale, String>();

descriptionMapNews.put(Locale.US, "");

Map<Locale, String> keywordsMapNews = new HashMap<Locale, String>();

keywordsMapNews.put(Locale.US, "");

Map<Locale, String> robotsMapNews = new HashMap<Locale, String>();

robotsMapNews.put(Locale.US, "");

friendlyURLMapNews = "/news";

Layout layoutNews = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapNews, titleMapNews,
	descriptionMapNews, keywordsMapNews, robotsMapNews, "link_to_layout", 
	false, friendlyURLMapNews, serviceContext);

layoutNewsId = layoutNews.getLayoutId();

Map<Locale, String> nameMapAlerts = new HashMap<Locale, String>();

nameMapAlerts.put(Locale.US, "Alerts");

Map<Locale, String> titleMapAlerts = new HashMap<Locale, String>();

titleMapAlerts.put(Locale.US, "");

Map<Locale, String> descriptionMapAlerts = new HashMap<Locale, String>();

descriptionMapAlerts.put(Locale.US, "");

Map<Locale, String> keywordsMapAlerts = new HashMap<Locale, String>();

keywordsMapAlerts.put(Locale.US, "");

Map<Locale, String> robotsMapAlerts = new HashMap<Locale, String>();

robotsMapAlerts.put(Locale.US, "");

friendlyURLMapAlerts = "/alerts";

Layout layoutAlerts = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutNewsId, nameMapAlerts, titleMapAlerts,
	descriptionMapAlerts, keywordsMapAlerts, robotsMapAlerts, "portlet",
	false, friendlyURLMapAlerts, serviceContext);

Map<Locale, String> nameMapAnnouncements = new HashMap<Locale, String>();

nameMapAnnouncements.put(Locale.US, "Announcements");

Map<Locale, String> titleMapAnnouncements = new HashMap<Locale, String>();

titleMapAnnouncements.put(Locale.US, "");

Map<Locale, String> descriptionMapAnnouncements = new HashMap<Locale, String>();

descriptionMapAnnouncements.put(Locale.US, "");

Map<Locale, String> keywordsMapAnnouncements = new HashMap<Locale, String>();

keywordsMapAnnouncements.put(Locale.US, "");

Map<Locale, String> robotsMapAnnouncements = new HashMap<Locale, String>();

robotsMapAnnouncements.put(Locale.US, "");

friendlyURLMapAnnouncements = "/announcements";

Layout layoutAnnouncements = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutNewsId, nameMapAnnouncements,
	titleMapAnnouncements, descriptionMapAnnouncements,
	keywordsMapAnnouncements, robotsMapAnnouncements, "portlet", false,
	friendlyURLMapAnnouncements, serviceContext);

Map<Locale, String> nameMapRSS = new HashMap<Locale, String>();

nameMapRSS.put(Locale.US, "RSS");

Map<Locale, String> titleMapRSS = new HashMap<Locale, String>();

titleMapRSS.put(Locale.US, "");

Map<Locale, String> descriptionMapRSS = new HashMap<Locale, String>();

descriptionMapRSS.put(Locale.US, "");

Map<Locale, String> keywordsMapRSS = new HashMap<Locale, String>();

keywordsMapRSS.put(Locale.US, "");

Map<Locale, String> robotsMapRSS = new HashMap<Locale, String>();

robotsMapRSS.put(Locale.US, "");

friendlyURLMapRSS = "/rss";

Layout layoutRSS = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutNewsId, nameMapRSS, titleMapRSS,
	descriptionMapRSS, keywordsMapRSS, robotsMapRSS, "portlet", false,
	friendlyURLMapRSS, serviceContext);

// News page links to alert converter page.

UnicodeProperties typeSettingsPropertiesNews =
	layoutNews.getTypeSettingsProperties();

typeSettingsPropertiesNews.setProperty("groupId", String.valueOf(groupId));
typeSettingsPropertiesNews.setProperty("show-alternate-links", "true");
typeSettingsPropertiesNews.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiesNews.setProperty(
	"linkToLayoutId", String.valueOf(layoutAlerts.getLayoutId()));
typeSettingsPropertiesNews.setProperty("sitemap-include", "1");
typeSettingsPropertiesNews.setProperty("layout-template-id", "2_columns_ii");

layoutNews.setTypeSettingsProperties(typeSettingsPropertiesNews);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutNewsId, layoutNews.getTypeSettings());

