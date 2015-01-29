package com.maple.loganalyzer.preprocessor;

import java.util.ArrayList;
import java.util.List;

import com.maple.loganalyzer.data.Log;
import com.maple.loganalyzer.data.Log.Url;
import com.maple.loganalyzer.util.StringUtil;

/**
 * 
 * @author Deok
 *
 * @Description URL을 받아서 ServiceID와 Parameter들을 Log.listUrl의 각 인스턴스에 저장
 * 
 */
public class UrlParser {
	
	private StringUtil stringUtil;
	private Log.Url url;

	public UrlParser() {
		stringUtil = new StringUtil();
		url = new Log.Url();
	}

	public Url parseUrl(String strUrl) {
		
		url.serviceID = getServiceId(strUrl);
		url.parameters = getParameters(strUrl);

		return url;
	}

	public String getServiceId(String strUrl) {
		
		String serviceId;
		
		List<String> matchedStrings = new ArrayList<String>();
		
		matchedStrings = stringUtil.pickStringList(strUrl,
				Log.Url.PREFIX_FOR_SERVICE_ID, Log.Url.SUFFIX_FOR_SERVICE_ID);
		
		if (matchedStrings.size() == 0) {
			return null;
		}
		
		serviceId = matchedStrings.get(0);
		
		return serviceId;

	}

	public List<Log.Url.Parameter> getParameters(String strUrl) {
		String parameterSpace = strUrl.substring(strUrl.indexOf("?") + 1);

		String[] parameters = stringUtil.splitter(parameterSpace, "&");

		List<Log.Url.Parameter> parameterList = new ArrayList<Log.Url.Parameter>();

		for (String param : parameters) {

			String[] paramContent = stringUtil.splitter(param, "=");
			Log.Url.Parameter paramter = new Log.Url.Parameter(paramContent[0],
					paramContent[1]);
			parameterList.add(paramter);
			
		}

		return parameterList;
	}
}
