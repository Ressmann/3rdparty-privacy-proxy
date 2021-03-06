/*--- (C) 1999-2019 Techniker Krankenkasse ---*/

package de.tk.opensource.privacyproxy.config;

import org.springframework.util.StringUtils;

public class RetrievalEndpoint {

	private String remoteUrl;

	private String filename;

	public String getRemoteUrl() {
		return remoteUrl;
	}

	/**
	 * @return  url with cache buster added as querystring parameter
	 */
	public String getRemoteUrlWithCacheBuster() {
		StringBuilder result = new StringBuilder(remoteUrl);
		if (remoteUrl.contains("?")) {
			result.append("&_=");
		} else {
			result.append("?_=");
		}
		result.append(System.currentTimeMillis());
		return result.toString();
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setRemoteUrl(String remoteUrl) {

		this.remoteUrl = remoteUrl;
		if (StringUtils.isEmpty(this.filename)) {
			setFilename(remoteUrl.substring(remoteUrl.lastIndexOf('/')));
		}

	}

	public String getFilename() {
		return filename;
	}

}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
