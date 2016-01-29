package com.liferay.languagedetector.messaging;

import com.liferay.languagedetector.util.Constants;
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

import java.util.Locale;

public class UserLanguageDetectorMessageListener implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		// TODO Auto-generated method stub
		long companyId = PortalUtil.getDefaultCompanyId();
		try {
			User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, _userEmail);
			ExpandoTable table = ExpandoTableLocalServiceUtil.getDefaultTable(
				user.getCompanyId(), User.class.getName());

			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(
				table.getTableId(), Constants.ExpandoColumnName);

			ExpandoValue value = ExpandoValueLocalServiceUtil.getValue(
				table.getTableId(), column.getColumnId(), user.getUserId());

			String languageChangeTime = StringPool.BLANK;
			
			if (value != null) {
				languageChangeTime = value.getData();
			}
			String userLanguage = user.getLanguageId();
			
			
			//time is null, language is not en, -> add time stamp
			
			//time is null, language is en - > return
			
			//time is not null, language is en -> delete time
			
			//time is not null, language is not en, less than 10, return
			
			//time is not null, language is not en, more/equal than 10, set user languate to be en, delete time.
			if (Validator.isNull(languageChangeTime)
				&& (!userLanguage.equals("en_US"))) {
				ExpandoValueLocalServiceUtil.addValue(
					table.getClassNameId(), table.getTableId(),
					column.getColumnId(), user.getUserId(),
					String.valueOf(System.currentTimeMillis()));
				_log.info("detect user language change. Mark time " + System.currentTimeMillis());
			}
			
			if(Validator.isNotNull(languageChangeTime)
				&& userLanguage.equals("en_US")) {
				ExpandoValueLocalServiceUtil.addValue(
						table.getClassNameId(), table.getTableId(),
						column.getColumnId(), user.getUserId(),
						StringPool.BLANK);
			}
			
			if (Validator.isNotNull(languageChangeTime)
				&& (!userLanguage.equals("en_US"))
				&& (System.currentTimeMillis() - Long.valueOf(languageChangeTime) >= 600000)) {

				user.setLanguageId("en_US");
				UserLocalServiceUtil.updateUser(user);
				
				ExpandoValueLocalServiceUtil.addValue(
						table.getClassNameId(), table.getTableId(),
						column.getColumnId(), user.getUserId(),
						StringPool.BLANK);
				_log.info("update user language to en_US");
			}
		} catch(NoSuchUserException nsue) {
			//log output
			_log.info("user " + _userEmail + " does not exist");
			return;
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String _userEmail = "veracode@liferay.com";
	private static final Log _log = LogFactoryUtil.getLog(UserLanguageDetectorMessageListener.class);
}
