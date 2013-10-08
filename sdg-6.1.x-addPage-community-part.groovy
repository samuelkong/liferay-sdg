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

// Community part

Map<Locale, String> nameMapCommunity = new HashMap<Locale, String>();

nameMapCommunity.put(Locale.US, "Community");

Map<Locale, String> titleMapCommunity = new HashMap<Locale, String>();

titleMapCommunity.put(Locale.US, "");

Map<Locale, String> descriptionMapCommunity = new HashMap<Locale, String>();

descriptionMapCommunity.put(Locale.US, "");

Map<Locale, String> keywordsMapCommunity = new HashMap<Locale, String>();

keywordsMapCommunity.put(Locale.US, "");

Map<Locale, String> robotsMapCommunity = new HashMap<Locale, String>();

robotsMapCommunity.put(Locale.US, "");

friendlyURLMapCommunity = "/community";

Layout layoutCommunity = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, 0, nameMapCommunity, titleMapCommunity,
	descriptionMapCommunity, keywordsMapCommunity, robotsMapCommunity,
	"link_to_layout", false, friendlyURLMapCommunity, serviceContext);

layoutCommunityId = layoutCommunity.getLayoutId();

Map<Locale, String> nameMapBookmark = new HashMap<Locale, String>();

nameMapBookmark.put(Locale.US, "Bookmarks");

Map<Locale, String> titleMapBookmark = new HashMap<Locale, String>();

titleMapBookmark.put(Locale.US, "");

Map<Locale, String> descriptionMapBookmark = new HashMap<Locale, String>();

descriptionMapBookmark.put(Locale.US, "");

Map<Locale, String> keywordsMapBookmark = new HashMap<Locale, String>();

keywordsMapBookmark.put(Locale.US, "");

Map<Locale, String> robotsMapBookmark = new HashMap<Locale, String>();

robotsMapBookmark.put(Locale.US, "");

friendlyURLMapBookmark = "/bookmarks";

Layout layoutBookmarks = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapBookmark,
	titleMapBookmark, descriptionMapBookmark, keywordsMapBookmark,
	robotsMapBookmark, "portlet", false, friendlyURLMapBookmark,
	serviceContext);

Map<Locale, String> nameMapFriends = new HashMap<Locale, String>();

nameMapFriends.put(Locale.US, "Friends Directory");

Map<Locale, String> titleMapFriends = new HashMap<Locale, String>();

titleMapFriends.put(Locale.US, "");

Map<Locale, String> descriptionMapFriends = new HashMap<Locale, String>();

descriptionMapFriends.put(Locale.US, "");

Map<Locale, String> keywordsMapFriends = new HashMap<Locale, String>();

keywordsMapFriends.put(Locale.US, "");

Map<Locale, String> robotsMapFriends = new HashMap<Locale, String>();

robotsMapFriends.put(Locale.US, "");

friendlyURLMapFriends = "/friends-directory";

Layout layoutFriends = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapFriends,
	titleMapFriends, descriptionMapFriends, keywordsMapFriends,
	robotsMapFriends, "portlet", false, friendlyURLMapFriends,
	serviceContext);

Map<Locale, String> nameMapInvitation = new HashMap<Locale, String>();

nameMapInvitation.put(Locale.US, "Invitation");

Map<Locale, String> titleMapInvitation = new HashMap<Locale, String>();

titleMapInvitation.put(Locale.US, "");

Map<Locale, String> descriptionMapInvitation = new HashMap<Locale, String>();

descriptionMapInvitation.put(Locale.US, "");

Map<Locale, String> keywordsMapInvitation = new HashMap<Locale, String>();

keywordsMapInvitation.put(Locale.US, "");

Map<Locale, String> robotsMapInvitation = new HashMap<Locale, String>();

robotsMapInvitation.put(Locale.US, "");

friendlyURLMapInvitation = "/invitation";

Layout layoutInvitation = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapInvitation,
	titleMapInvitation, descriptionMapInvitation, keywordsMapInvitation,
	robotsMapInvitation, "portlet", false, friendlyURLMapInvitation,
	serviceContext);

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

Map<Locale, String> nameMapSite = new HashMap<Locale, String>();

nameMapSite.put(Locale.US, "My Site");

Map<Locale, String> titleMapSite = new HashMap<Locale, String>();

titleMapSite.put(Locale.US, "");

Map<Locale, String> descriptionMapSite = new HashMap<Locale, String>();

descriptionMapSite.put(Locale.US, "");

Map<Locale, String> keywordsMapSite = new HashMap<Locale, String>();

keywordsMapSite.put(Locale.US, "");

Map<Locale, String> robotsMapSite = new HashMap<Locale, String>();

robotsMapSite.put(Locale.US, "");

friendlyURLMapSite = "/my-site";

Layout layoutSite = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapSite, titleMapSite,
	descriptionMapSite, keywordsMapSite, robotsMapSite, "portlet", false,
	friendlyURLMapSite, serviceContext);

Map<Locale, String> nameMapComment = new HashMap<Locale, String>();

nameMapComment.put(Locale.US, "Page Comments");

Map<Locale, String> titleMapComment = new HashMap<Locale, String>();

titleMapComment.put(Locale.US, "");

Map<Locale, String> descriptionMapComment = new HashMap<Locale, String>();

descriptionMapComment.put(Locale.US, "");

Map<Locale, String> keywordsMapComment = new HashMap<Locale, String>();

keywordsMapComment.put(Locale.US, "");

Map<Locale, String> robotsMapComment = new HashMap<Locale, String>();

robotsMapComment.put(Locale.US, "");

friendlyURLMapComment = "/page-comments";

Layout layoutComment = LayoutLocalServiceUtil.addLayout(
	userId, groupId, false, layoutCommunityId, nameMapComment,
	titleMapComment, descriptionMapComment, keywordsMapComment,
	robotsMapComment, "portlet", false, friendlyURLMapComment,
	serviceContext);

// Community page link to bookmarks page.

UnicodeProperties typeSettingsPropertiescommunity =
	layoutCommunity.getTypeSettingsProperties();

typeSettingsPropertiescommunity.setProperty(
	"groupId", String.valueOf(groupId));
typeSettingsPropertiescommunity.setProperty("show-alternate-links", "true");
typeSettingsPropertiescommunity.setProperty("sitemap-changefreq", "daily");
typeSettingsPropertiescommunity.setProperty(
	"linkToLayoutId", String.valueOf(layoutBookmarks.getLayoutId()));
typeSettingsPropertiescommunity.setProperty("sitemap-include", "1");
typeSettingsPropertiescommunity.setProperty(
	"layout-template-id", "2_columns_ii");

layoutCommunity.setTypeSettingsProperties(typeSettingsPropertiescommunity);

LayoutLocalServiceUtil.updateLayout(
	groupId, false, layoutCommunityId,
	layoutCommunity.getTypeSettings());
