import com.liferay.portal.repository.liferayrepository.model.LiferayFolder;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.model.BookmarksFolder;
import com.liferay.portlet.bookmarks.service.BookmarksEntryLocalServiceUtil;
import com.liferay.portlet.bookmarks.service.BookmarksFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplate;
import com.liferay.portlet.dynamicdatamapping.service.DDMContentLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMDisplay;
import com.liferay.portlet.dynamicdatamapping.util.DDMDisplayRegistryUtil;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBCategoryServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.polls.model.PollsChoice;
import com.liferay.portlet.polls.model.PollsQuestion;
import com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil;
import com.liferay.portlet.polls.service.persistence.PollsChoiceUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.shopping.model.ShoppingCategory;
import com.liferay.portlet.shopping.model.ShoppingItemField;
import com.liferay.portlet.shopping.model.ShoppingItemPrice;
import com.liferay.portlet.shopping.service.persistence.ShoppingItemPriceUtil;
import com.liferay.portlet.shopping.service.ShoppingCategoryLocalServiceUtil;
import com.liferay.portlet.shopping.service.ShoppingItemLocalServiceUtil;
import com.liferay.portlet.trash.util.TrashUtil;
import com.liferay.portlet.wiki.model.WikiNode;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiNodeLocalServiceUtil;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.portlet.PortletPreferences;

// Add site

userId = PortalUtil.getUserId(actionRequest);

ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
	WebKeys.THEME_DISPLAY);

companyId = themeDisplay.getCompanyId();

Group group = GroupLocalServiceUtil.getGroup(companyId, "Guest");

groupId = group.getGroupId();

ServiceContext serviceContext = ServiceContextFactory.getInstance(
	Group.class.getName(), actionRequest);

// Add blog 

serviceContext.setScopeGroupId(groupId);

String[] trackbacks = new String[1];

trackbacks[0] = "";

BlogsEntry blogEntry = BlogsEntryLocalServiceUtil.addEntry(
	userId, "blog1", "blog1", "test blog1", 5, 24, 2013, 7, 9, true, false,
	trackbacks, true, "" , "", null, serviceContext);

def categoryIdBlogs = [] as long[];

def assetTagNameBlogs = ['blog'] as String[];

AssetEntryLocalServiceUtil.updateEntry(
	userId, groupId, blogEntry.getCreateDate(),
	blogEntry.getModifiedDate(), BlogsEntry.class.getName(),
	blogEntry.getEntryId(), blogEntry.getUuid(), 0, categoryIdBlogs,
	assetTagNameBlogs, true, null, null, null, "text/plain",
	blogEntry.getTitle(), blogEntry.getDescription(), null, null, null,
	0, 0, null, false);

// Add dynamic data list

Layout layoutDD = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/dynamic-data");

DDMDisplay ddmDisplay = DDMDisplayRegistryUtil.getDDMDisplay("167");

long scopeClassNameId = PortalUtil.getClassNameId(
	ddmDisplay.getStructureType());

Map<Locale, String> ddmStructureNameMap1 = new HashMap<Locale, String>();

ddmStructureNameMap1.put(Locale.US, "definitionData1");

Map<Locale, String> ddmStructureDescription1 = new HashMap<Locale, String>();

ddmStructureDescription1.put(Locale.US, "definition for person");

String xsd1 = "<?xml version='1.0'?><root available-locales='en_US' default-locale='en_US'><dynamic-element dataType='string' indexType='keyword' name='name' readOnly='false' repeatable='false' required='false' showLabel='true' type='text' width='small'><meta-data locale='en_US'><entry name='label'><![CDATA[Name]]></entry><entry name='predefinedValue'><![CDATA[]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType='string' indexType='keyword' name='school' readOnly='false' repeatable='false' required='false' showLabel='true' type='text' width='small'><meta-data locale='en_US'><entry name='label'><![CDATA[School]]></entry><entry name='predefinedValue'><![CDATA[]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType='string' indexType='keyword' multiple='false' name='major' readOnly='false' repeatable='false' required='false' showLabel='true' type='select' width=''><dynamic-element name='option7283' type='option' value='computer'><meta-data locale='en_US'><entry name='label'><![CDATA[Computer]]></entry></meta-data></dynamic-element><dynamic-element name='option7284' type='option' value='english'><meta-data locale='en_US'><entry name='label'><![CDATA[English]]></entry></meta-data></dynamic-element><meta-data locale='en_US'><entry name='label'><![CDATA[Major]]></entry><entry name='predefinedValue'><![CDATA[['']]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element></root>";

DDMStructure ddmstructure1 = DDMStructureLocalServiceUtil.addStructure(
	userId, groupId, 0, scopeClassNameId, null, ddmStructureNameMap1,
	ddmStructureDescription1, xsd1, "xml", 0, serviceContext);

Map<Locale, String> ddmStructureNameMap2 = new HashMap<Locale, String>();

ddmStructureNameMap2.put(Locale.US, "definitionData2");

Map<Locale, String> ddmStructureDescription2 = new HashMap<Locale, String>();

ddmStructureDescription2.put(Locale.US, "definition for book");

String xsd2 = "<root available-locales='en_US' default-locale='en_US'><dynamic-element dataType='string' indexType='keyword' name='name' readOnly='false' repeatable='false' required='false' showLabel='true' type='text' width='small'><meta-data locale='en_US'><entry name='label'><![CDATA[Name]]></entry><entry name='predefinedValue'><![CDATA[]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType='date' fieldNamespace='ddm' indexType='keyword' name='publicdata' readOnly='false' repeatable='false' required='false' showLabel='true' type='ddm-date' width='small'><meta-data locale='en_US'><entry name='label'><![CDATA[PublicData]]></entry><entry name='predefinedValue'><![CDATA[]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType='string' indexType='keyword' name='tax' readOnly='false' repeatable='false' required='false' showLabel='true' type='radio' width=''><dynamic-element name='option6794' type='option' value='0'><meta-data locale='en_US'><entry name='label'><![CDATA[without Tax]]></entry></meta-data></dynamic-element><dynamic-element name='option6795' type='option' value='1'><meta-data locale='en_US'><entry name='label'><![CDATA[with Tax]]></entry></meta-data></dynamic-element><meta-data locale='en_US'><entry name='label'><![CDATA[Tax]]></entry><entry name='predefinedValue'><![CDATA[['']]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element></root>";

DDMStructure ddmstructure2 = DDMStructureLocalServiceUtil.addStructure(
	userId, groupId, 0, scopeClassNameId, null, ddmStructureNameMap2,
	ddmStructureDescription2, xsd2, "xml", 0, serviceContext);

Map<Locale, String> recordNameMap = new HashMap<Locale, String>();

recordNameMap.put(Locale.US, "ddl1");

Map<Locale, String> recordDescription = new HashMap<Locale, String>();

recordDescription.put(Locale.US, "ddl1");

DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.addRecordSet(
	userId, groupId, ddmstructure1.getStructureId(), null, recordNameMap,
	recordDescription, 20, 0, serviceContext);

Map<Locale, String> recordNameMap2 = new HashMap<Locale, String>();

recordNameMap2.put(Locale.US, "ddl2");

Map<Locale, String> recordDescription2 = new HashMap<Locale, String>();

recordDescription2.put(Locale.US, "ddl2");

DDLRecordSet recordSet2 = DDLRecordSetLocalServiceUtil.addRecordSet(
	userId, groupId, ddmstructure2.getStructureId(), null, recordNameMap2,
	recordDescription2, 20, 0, serviceContext);

DDMStructure ddmStructure = recordSet.getDDMStructure();

Fields fields = DDMUtil.getFields(
	ddmStructure.getStructureId(), serviceContext);

DDLRecord record = DDLRecordLocalServiceUtil.addRecord(
	userId, groupId, recordSet.getRecordSetId(), 0, fields,
	serviceContext);

String contentName = "com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink";

String xml = "<?xml version='1.0'?><root><dynamic-element default-language-id='en_US' name='school'><dynamic-content language-id='en_US'><![CDATA[DLU]]></dynamic-content></dynamic-element><dynamic-element default-language-id='en_US' name='name'><dynamic-content language-id='en_US'><![CDATA[Sara]]></dynamic-content></dynamic-element><dynamic-element default-language-id='en_US' name='_fieldsDisplay'><dynamic-content language-id='en_US'><![CDATA[name_INSTANCE_c4Dz,school_INSTANCE_Ygs8,major_INSTANCE_6GsM]]></dynamic-content></dynamic-element><dynamic-element default-language-id='en_US' name='major'><dynamic-content language-id='en_US'><![CDATA[['computer']]]></dynamic-content></dynamic-element></root>";

DDMContentLocalServiceUtil.updateContent(
	record.getDDMStorageId(), contentName, "", xml, serviceContext);

UnicodeProperties propertiesDDL = new UnicodeProperties();

propertiesDDL.setProperty(
	"recordSetId", String.valueOf(recordSet.getRecordSetId()));

actionRequest.setAttribute("portletResourceDDL", "169_INSTANCE_yOInr1Ynqt0S");

portletResourceDDL = (String)actionRequest.getAttribute("portletResourceDDL");

PortletPreferences portletPreferencesDDL =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceDDL);

for (Map.Entry<String, String> entry : propertiesDDL.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesDDL.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutDD.getPlid(), "169_INSTANCE_yOInr1Ynqt0S",
	portletPreferencesDDL);

// Add wiki

Layout layoutWikiD = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/wiki-dispaly");

WikiNode wikiNode = WikiNodeLocalServiceUtil.addNode(
	userId, "wikiNode", "wiki", serviceContext);

WikiPageLocalServiceUtil.addPage(
	userId, wikiNode.getNodeId(), "test wiki Page", 0.0,
	"this is wiki page1.\\\\", "", false, "creole", true, "", null,
	serviceContext);

WikiPage wikiPage = WikiPageLocalServiceUtil.updatePage(
	wikiNode.getUserId(), wikiNode.getNodeId(), "FrontPage", 1.1,
	"Front Page\\\\", "", false, "creole", "", null, serviceContext);

def categoryIdWikis = [] as long[];

def assetTagNameWikis = ['wikis'] as String[];

AssetEntryLocalServiceUtil.updateEntry(
	userId, groupId, wikiPage.getCreateDate(),
	wikiPage.getModifiedDate(), WikiPage.class.getName(),
	wikiPage.getPrimaryKey(), wikiPage.getUuid(), 0, categoryIdWikis,
	assetTagNameWikis, false, null, null, null, "text/plain",
	wikiPage.getTitle(), null, null, null, null, 0, 0, null, false);

UnicodeProperties typeSettingsPropertiesWiki = new UnicodeProperties();

typeSettingsPropertiesWiki.setProperty(
	"nodeId", String.valueOf(wikiNode.getNodeId()));
typeSettingsPropertiesWiki.setProperty("title", "FrontPage");

actionRequest.setAttribute("portletResourceWiki", "54_INSTANCE_p6Z9AOc8mPgb");

portletResourceWiki = (String)actionRequest.getAttribute(
	"portletResourceWiki");

PortletPreferences portletPreferencesWiki =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceWiki);

for (Map.Entry<String, String> entry : typeSettingsPropertiesWiki.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesWiki.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutWikiD.getPlid(), "54_INSTANCE_p6Z9AOc8mPgb",
	portletPreferencesWiki);

// Add message board

parentCategoryId = 0;

MBCategory category = MBCategoryLocalServiceUtil.addCategory(
	userId, parentCategoryId, "category", "category1", "default", "",
	"pop3", "", 110, false, "test@liferay.com", "test", 5, "", false, "",
	25, false, "", "", false, false, serviceContext);

MBCategory categoryQ = MBCategoryServiceUtil.addCategory(
	parentCategoryId, "category-question", "category type is question",
	"question", "", "pop3", "", 110, false, "test@liferay.com", "test", 5,
	"", false, "", 25, false, "", "", false, false, serviceContext);

List inputStreamOVPs = new ArrayList(5);

MBMessageLocalServiceUtil.addMessage(
	userId, null, groupId, category.getCategoryId(), "message1",
	"message1", "bbcode", inputStreamOVPs, false, 0.0, true,
	serviceContext);

question = true;

MBMessage message = MBMessageLocalServiceUtil.addMessage(
	userId, null, groupId, categoryQ.getCategoryId(), "question",
	"question", "bbcode", inputStreamOVPs, true, 0.0, true,
	serviceContext);

if(question){
	MBThreadLocalServiceUtil.updateQuestion(message.getThreadId(), true);
}

// Add bookmards

BookmarksFolder bookmarkFolder = BookmarksFolderLocalServiceUtil.addFolder(
	userId, 0, "Folder1", "the first folder", serviceContext);

BookmarksEntry bookmarksEntry1 = BookmarksEntryLocalServiceUtil.addEntry(
	userId, groupId, bookmarkFolder.getFolderId(), "bookmark1",
	"http://www.baidu.com", "�ٶ�", serviceContext);

BookmarksEntry bookmarksEntry2 = BookmarksEntryLocalServiceUtil.addEntry(
	userId, groupId, bookmarkFolder.getFolderId(), "bookmark2",
	"http://www.google.com", "Google", serviceContext);

def categoryIds1 = [] as long[];

def assetTagNames1 = ['bookmark'] as String[];

AssetEntryLocalServiceUtil.updateEntry(
	userId, groupId, bookmarksEntry1.getCreateDate(),
	bookmarksEntry1.getModifiedDate(), BookmarksEntry.class.getName(),
	bookmarksEntry1.getEntryId(), bookmarksEntry1.getUuid(), 0,
	categoryIds1, assetTagNames1, true, null, null, null, "text/plain",
	bookmarksEntry1.getName(), bookmarksEntry1.getDescription(), null,
	bookmarksEntry1.getUrl(), null, 0, 0, null, false);

def categoryIds2 = [] as long[];

def assetTagNames2 = ['bookmark', 'google'] as String[];

AssetEntryLocalServiceUtil.updateEntry(
	userId, groupId, bookmarksEntry2.getCreateDate(),
	bookmarksEntry2.getModifiedDate(), BookmarksEntry.class.getName(),
	bookmarksEntry2.getEntryId(), bookmarksEntry2.getUuid(), 0,
	categoryIds2, assetTagNames2, true, null, null, null, "text/plain",
	bookmarksEntry2.getName(), bookmarksEntry2.getDescription(), null,
	bookmarksEntry2.getUrl(), null, 0, 0, null, false);

// Add page comments

Layout layoutPComment = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/page-comments");

classPK = layoutPComment.getPlid();

MBMessageDisplay md = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(
	userId, groupId, "com.liferay.portal.model.Layout", classPK, 0);

MBMessage commentMessage = md.getMessage();

MBMessageLocalServiceUtil.addDiscussionMessage(
	userId, null, groupId, "com.liferay.portal.model.Layout",
	classPK, commentMessage.getThreadId(), commentMessage.getMessageId(),
	"", "cool!", serviceContext);

// Add poll

Layout layoutPD = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/polls-display");

Map<Locale, String> titleMapP = new HashMap<Locale, String>();

titleMapP.put(Locale.US, "question1");

Map<Locale, String> descriptionMapP = new HashMap<Locale, String>();

descriptionMapP.put(Locale.US, "Do you like Chinese food?");

expirationDateMonth = 0;
expirationDateDay = 0;
expirationDateYear = 0;
expirationDateHour = 0;
expirationDateMinute = 0;

neverExpire = true;

Set<String> readParameters = new HashSet<String>();

List<PollsChoice> choices = new ArrayList<PollsChoice>();

String param = "choiceDescriptiona_en_US";
String id = "a";
String choiceName = "a";

Map<Locale, String> localeChoiceDescriptionMap = new HashMap<Locale, String>();

localeChoiceDescriptionMap.put(Locale.US, "yes");

PollsChoice choice = PollsChoiceUtil.create(0);

choice.setName(choiceName);
choice.setDescriptionMap(localeChoiceDescriptionMap);

choices.add(choice);

String param2 = "choiceDescriptiona_en_US";
String id2 = "b";
String choiceName2 = "b";

Map<Locale, String> localeChoiceDescriptionMapb = new HashMap<Locale, String>();

localeChoiceDescriptionMapb.put(Locale.US, "no");

PollsChoice choice2 = PollsChoiceUtil.create(0);

choice2.setName(choiceName2);
choice2.setDescriptionMap(localeChoiceDescriptionMapb);

choices.add(choice2);

PollsQuestion question = PollsQuestionLocalServiceUtil.addQuestion(
	userId, titleMapP, descriptionMapP, expirationDateMonth,
	expirationDateDay, expirationDateYear, expirationDateHour,
	expirationDateMinute, neverExpire, choices, serviceContext);

UnicodeProperties propertiesPoll = new UnicodeProperties();

propertiesPoll.setProperty("questionId", String.valueOf(question.getQuestionId()));

actionRequest.setAttribute("portletResourcePoll","59_INSTANCE_TbzT9KKPaRFZ");

portletResourcePoll = (String)actionRequest.getAttribute("portletResourcePoll");

PortletPreferences portletPreferencesPoll =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourcePoll);

for (Map.Entry<String, String> entry : propertiesPoll.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesPoll.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutPD.getPlid(), "59_INSTANCE_TbzT9KKPaRFZ",
	portletPreferencesPoll);

// Add alerts

announcementsClassNameId = 10001;

classPKAnnouncements = groupId;

AnnouncementsEntryLocalServiceUtil.addEntry(
	userId, announcementsClassNameId, classPKAnnouncements, "No Smoking",
	"Smoking is harmful to health",
	"http://baike.baidu.com/view/78799.htm", "general", 0, 0, 0, 0, 0,
	true, 8, 4, 2013, 3, 30, 0, true);

// Add announcements

AnnouncementsEntryLocalServiceUtil.addEntry(
	userId, announcementsClassNameId, classPKAnnouncements, "Meeting",
	"Tech- Talk Meeting : 2-4 PM today.", "", "general", 0, 0, 0, 0, 0,
	true, 7, 5, 2013, 3, 30, 1, false);

// Add rss

Layout layoutRSS = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/rss");

UnicodeProperties typeSettingsPropertiesRSS = new UnicodeProperties();

typeSettingsPropertiesRSS.setProperty(
	"urls", "http://news.baidu.com/n?cmd=1&class=shizheng&tn=rss&sub=0");
typeSettingsPropertiesRSS.setProperty("titles", "baidu");

actionRequest.setAttribute("portletResourceRSS", "39_INSTANCE_vn59KhKI7Y2w");

portletResourceRSS = (String)actionRequest.getAttribute("portletResourceRSS");

PortletPreferences portletPreferencesRSS =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceRSS);

for (Map.Entry<String, String> entry : typeSettingsPropertiesRSS.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesRSS.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutRSS.getPlid(), "39_INSTANCE_vn59KhKI7Y2w",
	portletPreferencesRSS);

// Add iframe

Layout layoutIFrame = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/iFrame");

UnicodeProperties typeSettingsPropertiesIFrame = new UnicodeProperties();

typeSettingsPropertiesIFrame.setProperty("src", "http://www.baidu.com.cn");

actionRequest.setAttribute("portletResourceIFrame", "48_INSTANCE_mpN1u52gzmbO");

portletResourceIFrame = (String)actionRequest.getAttribute(
	"portletResourceIFrame");

PortletPreferences portletPreferencesIFrame =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceIFrame);

for (Map.Entry<String, String> entry : typeSettingsPropertiesIFrame.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesIFrame.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutIFrame.getPlid(), "48_INSTANCE_mpN1u52gzmbO",
	portletPreferencesIFrame);

// Add quick note

Layout layoutQN = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/quick-note");

UnicodeProperties typeSettingsPropertiesNote = new UnicodeProperties();

typeSettingsPropertiesNote.setProperty("data", "this is the first note.");

actionRequest.setAttribute("portletResourceNote","97_INSTANCE_a1SJg50KuLFc");
portletResourceNote = (String)actionRequest.getAttribute(
	"portletResourceNote");

PortletPreferences portletPreferencesNote =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceNote);

for (Map.Entry<String, String> entry : typeSettingsPropertiesNote.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesNote.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutQN.getPlid(), "97_INSTANCE_a1SJg50KuLFc",
	portletPreferencesNote);

// Add web content

Layout layoutWC = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/web-content");

Map<Locale, String> WCTitleMap1 = new HashMap<Locale, String>();

WCTitleMap1.put(Locale.US, "Web Content1");

Map<Locale, String> WCDescriptionMap1 = new HashMap<Locale, String>();

WCDescriptionMap1.put(Locale.US, "Test Web Content1");

String webCContent1 = "<?xml version='1.0' encoding='UTF-8'?><root available-locales='en_US' default-locale='en_US'><static-content language-id='en_US'><![CDATA[Test Web Content]]></static-content></root>";

Map<String, byte[]> images1 = new HashMap<String, byte[]>();

String articletURL1 = null;

JournalArticle journalArticle = JournalArticleLocalServiceUtil.addArticle(
	userId, groupId, 0, 0, 0, "", true, 1.0, WCTitleMap1, WCDescriptionMap1,
	webCContent1, "false", "", "", null, 6, 5, 2013, 5, 48, 0, 0, 0, 0, 0,
	true, 0, 0, 0, 0, 0, true, true, false, "", null, images1,
	articletURL1, serviceContext);

DDMDisplay WCddmDisplay = DDMDisplayRegistryUtil.getDDMDisplay("15");

long WCScopeClassNameId = PortalUtil.getClassNameId(WCddmDisplay.getStructureType());

parentStructureId = 0;

Map<Locale, String> nameMapStructure1 = new HashMap<Locale, String>();

nameMapStructure1.put(Locale.US, "Web Content Structure1");

Map<Locale, String> nameDescriptionStructure1 = new HashMap<Locale, String>();

nameDescriptionStructure1.put(Locale.US, "Web Content Structure1");

xsd = "<root available-locales='en_US' default-locale='en_US'><dynamic-element dataType='string' indexType='keyword' name='name' readOnly='false' repeatable='false' required='false' showLabel='true' type='text' width='small'><meta-data locale='en_US'><entry name='label'><![CDATA[Name]]></entry><entry name='predefinedValue'><![CDATA[]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType='date' fieldNamespace='ddm' indexType='keyword' name='birthday' readOnly='false' repeatable='false' required='false' showLabel='true' type='ddm-date' width='small'><meta-data locale='en_US'><entry name='label'><![CDATA[Birthday]]></entry><entry name='predefinedValue'><![CDATA[]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType='number' fieldNamespace='ddm' indexType='keyword' name='number3798' readOnly='false' repeatable='false' required='false' showLabel='true' type='ddm-number' width='small'><meta-data locale='en_US'><entry name='label'><![CDATA[Number]]></entry><entry name='predefinedValue'><![CDATA[]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element><dynamic-element dataType='string' indexType='keyword' name='gender' readOnly='false' repeatable='false' required='false' showLabel='true' type='radio' width=''><dynamic-element name='option8579' type='option' value='0'><meta-data locale='en_US'><entry name='label'><![CDATA[male]]></entry></meta-data></dynamic-element><dynamic-element name='option8580' type='option' value='1'><meta-data locale='en_US'><entry name='label'><![CDATA[female]]></entry></meta-data></dynamic-element><meta-data locale='en_US'><entry name='label'><![CDATA[Gender]]></entry><entry name='predefinedValue'><![CDATA[['']]]></entry><entry name='tip'><![CDATA[]]></entry></meta-data></dynamic-element></root>";

storageType = "xml";

DDMStructure structure = DDMStructureLocalServiceUtil.addStructure(
	userId, groupId, parentStructureId, WCScopeClassNameId, null,
	nameMapStructure1, nameDescriptionStructure1, xsd, storageType, 0,
	serviceContext);

templateClassNameId = 10102;

templateClassPK = structure.getStructureId();

Map<Locale, String> nameMapTemplete1 = new HashMap<Locale, String>()

nameMapTemplete1.put(Locale.US, "Web Content Template1");

Map<Locale, String> DescriptionTemplete1 = new HashMap<Locale, String>();

DescriptionTemplete1.put(Locale.US, "Web Content Template1");

script = '''<#--Web content templates are used to lay out the fields defined in a web content structure. Please use the left panel to quickly add commonly used variables.Autocomplete is also available and can be invoked by typing '${.'-->''';

File smallImageFile = null;

DDMTemplate template = DDMTemplateLocalServiceUtil.addTemplate(
	userId, groupId, templateClassNameId, templateClassPK, null,
	nameMapTemplete1, DescriptionTemplete1, "display", "", "ftl", script,
	false, false, "", smallImageFile, serviceContext);

WCClassNameId = 0;
WCClassPK = 0;

articleId = "";
autoArticleId = true;

Map<Locale, String> WCTitleMap2 = new HashMap<Locale, String>();

WCTitleMap2.put(Locale.US, "Web Content with structure");

Map<Locale, String> WCDecriptionMap2 = new HashMap<Locale, String>();

WCDecriptionMap2.put(Locale.US, "Web Content with structure");

content2 = "<?xml version='1.0'?><root available-locales='en_US' default-locale='en_US'><dynamic-element name='name' index='0' type='text' index-type='keyword'><dynamic-content language-id='en_US'><![CDATA[web content2]]></dynamic-content></dynamic-element><dynamic-element name='birthday' index='0' index-type='keyword'><dynamic-content language-id='en_US'><![CDATA[1373328000000]]></dynamic-content></dynamic-element><dynamic-element name='number3798' index='0' index-type='keyword'><dynamic-content language-id='en_US'><![CDATA[null]]></dynamic-content></dynamic-element><dynamic-element name='gender' index='0' index-type='keyword'><dynamic-content language-id='en_US'><![CDATA[['0']]]></dynamic-content></dynamic-element></root>";

type = "false";

structureId = structure.getStructureKey();

templateId = template.getTemplateKey();

File smallFile = null;

Map<String, byte[]> images = new HashMap<String, byte[]>();

JournalArticle article = JournalArticleLocalServiceUtil.addArticle(
	userId, groupId, 0, WCClassNameId, WCClassPK, articleId, true, 1.0,
	WCTitleMap2, WCDecriptionMap2, content2, type, structureId, templateId,
	null, 6, 9, 1990, 6, 27, 0, 0, 0, 0, 0, true, 0, 0, 0, 0, 0, true,
	false, false, "", smallFile, images, null, serviceContext);

UnicodeProperties typeSettingsPropertiesWC = new UnicodeProperties();

typeSettingsPropertiesWC.setProperty("articleId", article.getArticleId());
typeSettingsPropertiesWC.setProperty("groupId", String.valueOf(groupId));

actionRequest.setAttribute("portletResourceWC", "56_INSTANCE_COxqya3VTLhr");

portletResourceWC = (String)actionRequest.getAttribute("portletResourceWC");

PortletPreferences portletPreferencesWC =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceWC);

for (Map.Entry<String, String> entry : typeSettingsPropertiesWC.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesWC.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutWC.getPlid(), "56_INSTANCE_COxqya3VTLhr",
	portletPreferencesWC);

UnicodeProperties typeSettingsPropertiesWCList = new UnicodeProperties();

typeSettingsPropertiesWCList.setProperty("groupId", String.valueOf(groupId));

actionRequest.setAttribute("portletResourceWCList", "62_INSTANCE_ffagnWrlaM2y");

portletResourceWCList = (String)actionRequest.getAttribute(
	"portletResourceWCList");

PortletPreferences portletPreferencesWCList =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceWCList);

for (Map.Entry<String, String> entry : typeSettingsPropertiesWCList.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesWCList.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutWC.getPlid(), "62_INSTANCE_ffagnWrlaM2y",
	portletPreferencesWCList);

// Add shopping

ShoppingCategory shoppingCategory =
	ShoppingCategoryLocalServiceUtil.addCategory(
		userId, 0, "Book", "book", serviceContext)

categoryId = shoppingCategory.getCategoryId();

File smallFileShopping = null;
File mediumFile = null;
File largeFileShopping = null;

List<ShoppingItemField> itemFields = new ArrayList<ShoppingItemField>();

List<ShoppingItemPrice> itemPrices = new ArrayList<ShoppingItemPrice>();

int minQuantity = 0;
int maxQuantity = 0;
double price = 28.0;
double discount = 0.2;
boolean taxable = true;
double shipping = 0.0;
boolean useShippingFormula = true;
boolean active = true;
int defaultPrice = 0;
int status = 1;

ShoppingItemPrice itemPrice = ShoppingItemPriceUtil.create(0);

itemPrice.setMinQuantity(minQuantity);
itemPrice.setMaxQuantity(maxQuantity);
itemPrice.setPrice(price);
itemPrice.setDiscount(discount);
itemPrice.setTaxable(taxable);
itemPrice.setShipping(shipping);
itemPrice.setUseShippingFormula(useShippingFormula);
itemPrice.setStatus(status);

itemPrices.add(itemPrice);

ShoppingItemLocalServiceUtil.addItem(
	userId, groupId, categoryId, "novels", "tiny time 2",
	"this is a story about girls and friendship.", "magazine", "", true,
	1000, false, null, false, "", smallFileShopping, false, "", mediumFile,
	false, "", largeFileShopping, itemFields, itemPrices, serviceContext);

// Add categories

Map<Locale, String> titleMapVocabulary1 = new HashMap<Locale, String>();

titleMapVocabulary1.put(Locale.US, "Book");

Map<Locale, String> decriptionMapVocabulary1 = new HashMap<Locale, String>();

decriptionMapVocabulary1.put(Locale.US, "Book");

UnicodeProperties settingPropertiesVocabulary1 = new UnicodeProperties();

settingPropertiesVocabulary1.setProperty("multiValued", String.valueOf(true));
settingPropertiesVocabulary1.setProperty(
	"selectedClassNameIds", String.valueOf(0));

AssetVocabulary vocabulary1 = AssetVocabularyLocalServiceUtil.addVocabulary(
	userId, StringPool.BLANK, titleMapVocabulary1,
	decriptionMapVocabulary1, settingPropertiesVocabulary1.toString(),
	serviceContext);

Map<Locale, String> titleMapCategory1 = new HashMap<Locale, String>();

titleMapCategory1.put(Locale.US, "Novel");

Map<Locale, String> decriptionMapCategory1 = new HashMap<Locale, String>();

decriptionMapCategory1.put(Locale.US, "novel");

String[] categoryProperties = null;

AssetCategoryLocalServiceUtil.addCategory(
	userId, 0, titleMapCategory1, decriptionMapCategory1,
	vocabulary1.getVocabularyId(), categoryProperties, serviceContext);

// Add tag

Layout layoutTagC = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(
	groupId, false, "/tag-cloud");

String[] tagProperties = null;

AssetTagLocalServiceUtil.addTag(
	userId, "bookmarks", tagProperties, serviceContext);

UnicodeProperties propertiesTagN = new UnicodeProperties();

propertiesTagN.setProperty("showAssetCount","true");
propertiesTagN.setProperty("showZeroAssetCount","true");

actionRequest.setAttribute("propertiesTagN", "141_INSTANCE_W3mu4VyEzpgz");

portletResourceTagN = (String)actionRequest.getAttribute("propertiesTagN");

PortletPreferences portletPreferencesTagN =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceTagN);

for (Map.Entry<String, String> entry : propertiesTagN.entrySet()) {
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesTagN.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutTagC.getPlid(), "141_INSTANCE_W3mu4VyEzpgz",
	portletPreferencesTagN);

UnicodeProperties propertiesTagCloud = new UnicodeProperties();

propertiesTagCloud.setProperty("showAssetCount","true");
propertiesTagCloud.setProperty("showZeroAssetCount","true");

actionRequest.setAttribute("propertiesTagCloud", "148_INSTANCE_ovvJg184K1ix");

portletResourceTagCloud = (String)actionRequest.getAttribute(
	"propertiesTagCloud");

PortletPreferences portletPreferencesTagCloud =
	PortletPreferencesFactoryUtil.getPortletSetup(
		actionRequest, portletResourceTagCloud);

for (Map.Entry<String, String> entry : propertiesTagCloud.entrySet()) { 
	String name = entry.getKey();
	String value = entry.getValue();

	portletPreferencesTagCloud.setValue(name, value);
}

PortletPreferencesLocalServiceUtil.updatePreferences(
	0, 3, layoutTagC.getPlid(), "148_INSTANCE_ovvJg184K1ix",
	portletPreferencesTagCloud);

// Add relate asset

AssetEntry assetBlog = AssetEntryLocalServiceUtil.getEntry(
	"com.liferay.portlet.blogs.model.BlogsEntry", blogEntry.getEntryId());

AssetEntry assetArticle = AssetEntryLocalServiceUtil.getEntry(
	"com.liferay.portlet.journal.model.JournalArticle",
	journalArticle.getResourcePrimKey());

AssetLinkLocalServiceUtil.addLink(
	userId, assetBlog.getEntryId(), assetArticle.getEntryId(), 0, 0);

AssetEntry assetWiki = AssetEntryLocalServiceUtil.getEntry(
	"com.liferay.portlet.wiki.model.WikiPage", wikiPage.getPageId());

AssetLinkLocalServiceUtil.addLink(
	userId, assetBlog.getEntryId(), assetWiki.getEntryId(), 0, 0);
