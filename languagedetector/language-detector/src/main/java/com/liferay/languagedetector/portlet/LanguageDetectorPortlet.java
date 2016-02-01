package com.liferay.languagedetector.portlet;

import com.liferay.languagedetector.util.Constants;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.DuplicateColumnNameException;
import com.liferay.portlet.expando.DuplicateTableNameException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.PortletException;

/**
 * Portlet implementation class LanguageDetectorPortlet
 */
public class LanguageDetectorPortlet extends MVCPortlet {
	public void init() throws PortletException {
		super.init();
		ExpandoTable table = null;
		long companyId = PortalUtil.getDefaultCompanyId();
		try {
			table = ExpandoTableLocalServiceUtil.addDefaultTable(
				companyId, User.class.getName());
		}
		catch (DuplicateTableNameException dtne) {
			try {
				table = ExpandoTableLocalServiceUtil.getDefaultTable(
					companyId, User.class.getName());
			} catch (Exception e) {

				throw new PortletException();
			}
		} catch (Exception e) {
			throw new PortletException();
		}

		ExpandoColumn column = null;

		long tableId = table.getTableId();

		String expandoColumnName = Constants.EXPANDO_COLUMN_NAME;

		try {
			column = ExpandoColumnLocalServiceUtil.addColumn(
				tableId, expandoColumnName, ExpandoColumnConstants.STRING);

			UnicodeProperties properties = new UnicodeProperties();

			properties.setProperty(
				ExpandoColumnConstants.INDEX_TYPE, Boolean.TRUE.toString());

			column.setTypeSettingsProperties(properties);

			ExpandoColumnLocalServiceUtil.updateExpandoColumn(column);
		}
		catch (DuplicateColumnNameException dcne) {
		}
		catch (Exception e) {
			throw new PortletException();
		}
	}
}