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

// Collaboration part

Map<Locale, String> nameMapCollaboration = new HashMap<Locale, String>();

nameMapCollaboration.put(Locale.US, "Collaboration");

Map<Locale, String> titleMapCollaboration = new HashMap<Locale, String>();

titleMapCollaboration.put(Locale.US, "");

Map<Locale, String> descriptionMapCollaboration =
	new HashMap<Locale, String>();

descriptionMapCollaboration.put(Locale.US, "");

Map<Locale, String> keywordsMapCollaboration = new HashMap<Locale, String>();

keywordsMapCollaboration.put(Locale.US, "");

Map<Locale, String> robotsMapCollaboration = new HashMap<Locale, String>();

robotsMapCollaboration.put(Locale.US, "");

friendlyURLMapCollaboration = "/collaboration";

Layout layoutCollaboration = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapCollaboration, titleMapCollaboration,
	descriptionMapCollaboration, keywordsMapCollaboration,
	robotsMapCollaboration, "link_to_layout", false,
	friendlyURLMapCollaboration, serviceContext);

layoutCollaborationId = layoutCollaboration.getLayoutId();

Map<Locale, String> nameMapBlog = new HashMap<Locale, String>();

nameMapBlog.put(Locale.US, "Blogs");

Map<Locale, String> titleMapBlog = new HashMap<Locale, String>();

titleMapBlog.put(Locale.US, "");

Map<Locale, String> descriptionMapBlog = new HashMap<Locale, String>();

descriptionMapBlog.put(Locale.US, "");

Map<Locale, String> keywordsMapBlog = new HashMap<Locale, String>();

keywordsMapBlog.put(Locale.US, "");

Map<Locale, String> robotsMapBlog = new HashMap<Locale, String>();

robotsMapBlog.put(Locale.US, "");

friendlyURLMapBlog = "/blogs";

Layout layoutBlogs = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCollaborationId, nameMapBlog,
	titleMapBlog, descriptionMapBlog, keywordsMapBlog, robotsMapBlog,
	"portlet", false, friendlyURLMapBlog, serviceContext);

Map<Locale, String> nameMapCalendar = new HashMap<Locale, String>();

nameMapCalendar.put(Locale.US, "Calendar");

Map<Locale, String> titleMapCalendar = new HashMap<Locale, String>();

titleMapCalendar.put(Locale.US, "");

Map<Locale, String> descriptionMapCalendar = new HashMap<Locale, String>();

descriptionMapCalendar.put(Locale.US, "");

Map<Locale, String> keywordsMapCalendar = new HashMap<Locale, String>();

keywordsMapCalendar.put(Locale.US, "");

Map<Locale, String> robotsMapCalendar = new HashMap<Locale, String>();

robotsMapCalendar.put(Locale.US, "");

friendlyURLMapCalendar = "/calendar";

Layout layoutCalendar = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCollaborationId, nameMapCalendar,
	titleMapCalendar, descriptionMapCalendar, keywordsMapCalendar,
	robotsMapCalendar, "portlet", false, friendlyURLMapCalendar,
	serviceContext);

Map<Locale, String> nameMapDD = new HashMap<Locale, String>();

nameMapDD.put(Locale.US, "Dynamic Data");

Map<Locale, String> titleMapDD = new HashMap<Locale, String>();

titleMapDD.put(Locale.US, "");

Map<Locale, String> descriptionMapDD = new HashMap<Locale, String>();

descriptionMapDD.put(Locale.US, "");

Map<Locale, String> keywordsMapDD = new HashMap<Locale, String>();

keywordsMapDD.put(Locale.US, "");

Map<Locale, String> robotsMapDD = new HashMap<Locale, String>();

robotsMapDD.put(Locale.US, "");

friendlyURLMapDD = "/dynamic-data";

Layout layoutDD = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCollaborationId, nameMapDD, titleMapDD,
	descriptionMapDD, keywordsMapDD, robotsMapDD, "portlet", false,
	friendlyURLMapDD, serviceContext);

Map<Locale, String> nameMapWikiPortlet = new HashMap<Locale, String>();

nameMapWikiPortlet.put(Locale.US, "Wiki");

Map<Locale, String> titleMapWikiPortlet = new HashMap<Locale, String>();

titleMapWikiPortlet.put(Locale.US, "");

Map<Locale, String> descriptionMapWikiPortlet = new HashMap<Locale, String>();

descriptionMapWikiPortlet.put(Locale.US, "");

Map<Locale, String> keywordsMapWikiPortlet = new HashMap<Locale, String>();

keywordsMapWikiPortlet.put(Locale.US, "");

Map<Locale, String> robotsMapWikiPortlet = new HashMap<Locale, String>();

robotsMapWikiPortlet.put(Locale.US, "");

friendlyURLMapWikiPortlet = "/wiki";

Layout layoutWikiPortlet = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCollaborationId, nameMapWikiPortlet,
	titleMapWikiPortlet, descriptionMapWikiPortlet, keywordsMapWikiPortlet,
	robotsMapWikiPortlet, "portlet", false, friendlyURLMapWikiPortlet,
	serviceContext);

Map<Locale, String> nameMapMB = new HashMap<Locale, String>();

nameMapMB.put(Locale.US, "Message Board");

Map<Locale, String> titleMapMB = new HashMap<Locale, String>();

titleMapMB.put(Locale.US, "");

Map<Locale, String> descriptionMapMB = new HashMap<Locale, String>();

descriptionMapMB.put(Locale.US, "");

Map<Locale, String> keywordsMapMB = new HashMap<Locale, String>();

keywordsMapMB.put(Locale.US, "");

Map<Locale, String> robotsMapMB = new HashMap<Locale, String>();

robotsMapMB.put(Locale.US, "");

friendlyURLMapMB = "/message-board";

Layout layoutMB = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCollaborationId, nameMapMB, titleMapMB,
	descriptionMapMB, keywordsMapMB, robotsMapMB, "portlet", false,
	friendlyURLMapMB, serviceContext);

// Collaboration page link to blog page.

UnicodeProperties typeSettingsPropertiesCollaboration =
	layoutCollaboration.getTypeSettingsProperties();

typeSettingsPropertiesCollaboration.setProperty(
	"groupId", String.valueOf(groupId));
typeSettingsPropertiesCollaboration.setProperty(
	"show-alternate-links", "true");
typeSettingsPropertiesCollaboration.setProperty(
"sitemap-changefreq", "daily");
typeSettingsPropertiesCollaboration.setProperty(
	"linkToLayoutId", String.valueOf(layoutBlogs.getLayoutId()));
typeSettingsPropertiesCollaboration.setProperty("sitemap-include", "1");
typeSettingsPropertiesCollaboration.setProperty(
	"layout-template-id", "2_columns_ii");

layoutCollaboration.setTypeSettingsProperties(
	typeSettingsPropertiesCollaboration);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutCollaborationId,
	layoutCollaboration.getTypeSettings());
