package com.maple.loganalyzer.preparer;

import java.util.ArrayList;
import java.util.List;

import com.maple.loganalyzer.data.Url;
import com.maple.loganalyzer.data.Parameter;
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
	private Url url;

	public UrlParser() {
		stringUtil = new StringUtil();
	}

	public Url parseUrl(String strUrl) {
		url = new Url();
		url.serviceId = getServiceId(strUrl);
		url.parameters.addAll(getParameters(strUrl));
		
		return url;
	}

	public String getServiceId(String strUrl) {
		
		String serviceId;
		
		List<String> matchedStrings = new ArrayList<String>();
		
		matchedStrings = stringUtil.pickStringList(strUrl,
				Url.PREFIX_FOR_SERVICE_ID, Url.SUFFIX_FOR_SERVICE_ID);
		
		if (matchedStrings.size() == 0) {
			return "unrecognized";
		} else {
			serviceId = matchedStrings.get(0);
		}
		
		return serviceId;

	}

	public List<Parameter> getParameters(String strUrl) {
		String parameterSpace = strUrl.substring(strUrl.indexOf("?") + 1);

		String[] parameters = stringUtil.splitter(parameterSpace, "&");

		List<Parameter> parameterList = new ArrayList<Parameter>();

		for (String param : parameters) {

			String[] paramContent = stringUtil.splitter(param, "=");
			Parameter paramter = new Parameter(paramContent[0],
					paramContent[1]);
			parameterList.add(paramter);
			
		}

		return parameterList;
	}
}
