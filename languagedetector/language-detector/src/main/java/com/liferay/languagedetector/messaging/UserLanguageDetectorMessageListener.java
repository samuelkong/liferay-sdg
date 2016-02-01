package com.liferay.languagedetector.messaging;

import com.liferay.languagedetector.util.Constants;
import com.liferay.languagedetector.util.PortletPropsValues;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
public class UserLanguageDetectorMessageListener implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		long companyId = PortalUtil.getDefaultCompanyId();
		
		try {
			User user = UserLocalServiceUtil.getUserByEmailAddress(
				companyId, PortletPropsValues.DETECT_USER_EMAIL);
			ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(
				user.getCompanyId(), User.class.getName());

			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(
				table.getTableId(), Constants.EXPANDO_COLUMN_NAME);

			ExpandoValue value = ExpandoValueLocalServiceUtil.getValue(
				table.getTableId(), column.getColumnId(), user.getUserId());

			String languageChangeTime = StringPool.BLANK;

			if (value != null) {
				languageChangeTime = value.getData();
			}

			String userLanguage = user.getLanguageId();

			/*code logic
			 * time is null, language is not en, -> add time stamp
			 * time is null, language is en - > return(no need to implement)
			 * time is not null, language is en -> delete time
			 * time is not null, language is not en, less than 10, return
			 * (no need to implement)
			 * time is not null, language is not en, more/equal than 10,
			 * set user languate to be en_US, remove timestamp from expando.
			*/
			long timeStamp = System.currentTimeMillis();

			if (Validator.isNull(languageChangeTime) &&
				(!userLanguage.equals(Constants.LANGUAGE_ID_EN_US))) {

				ExpandoValueLocalServiceUtil.addValue(
					table.getClassNameId(), table.getTableId(),
					column.getColumnId(), user.getUserId(),
					String.valueOf(timeStamp));

				_log.info("Detect user language change.");
			}

			if (Validator.isNotNull(languageChangeTime) &&
				userLanguage.equals(Constants.LANGUAGE_ID_EN_US)) {
				ExpandoValueLocalServiceUtil.addValue(
						table.getClassNameId(), table.getTableId(),
						column.getColumnId(), user.getUserId(),
						StringPool.BLANK);
			}

			if (Validator.isNotNull(languageChangeTime) 
				&& (!userLanguage.equals(Constants.LANGUAGE_ID_EN_US))
				&& (timeStamp - Long.valueOf(languageChangeTime) >= 600000)) {

				user.setLanguageId(Constants.LANGUAGE_ID_EN_US);
				UserLocalServiceUtil.updateUser(user);

				ExpandoValueLocalServiceUtil.addValue(
						table.getClassNameId(), table.getTableId(),
						column.getColumnId(), user.getUserId(),
						StringPool.BLANK);
				_log.info("update user language to en_US");
			}
		} catch (NoSuchUserException nsue) {
			_log.info("user " + PortletPropsValues.DETECT_USER_EMAIL 
				+ " does not exist");
		}
		catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	private static Log _log =
		LogFactoryUtil.getLog(UserLanguageDetectorMessageListener.class);
}