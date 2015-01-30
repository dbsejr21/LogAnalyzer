package com.maple.loganalyzer.preprocessor;

import java.util.ArrayList;
import java.util.List;

import com.maple.loganalyzer.data.InputLog;
import com.maple.loganalyzer.data.InputLog.Url;
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
	private InputLog.Url url;

	public UrlParser() {
		stringUtil = new StringUtil();
		url = new InputLog.Url();
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
				InputLog.Url.PREFIX_FOR_SERVICE_ID, InputLog.Url.SUFFIX_FOR_SERVICE_ID);
		
		if (matchedStrings.size() == 0) {
			return null;
		}
		
		serviceId = matchedStrings.get(0);
		
		return serviceId;

	}

	public List<InputLog.Url.Parameter> getParameters(String strUrl) {
		String parameterSpace = strUrl.substring(strUrl.indexOf("?") + 1);

		String[] parameters = stringUtil.splitter(parameterSpace, "&");

		List<InputLog.Url.Parameter> parameterList = new ArrayList<InputLog.Url.Parameter>();

		for (String param : parameters) {

			String[] paramContent = stringUtil.splitter(param, "=");
			InputLog.Url.Parameter paramter = new InputLog.Url.Parameter(paramContent[0],
					paramContent[1]);
			parameterList.add(paramter);
			
		}

		return parameterList;
	}
}
