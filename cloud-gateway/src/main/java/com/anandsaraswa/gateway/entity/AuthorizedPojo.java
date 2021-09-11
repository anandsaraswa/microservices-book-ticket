package com.anandsaraswa.gateway.entity;

import java.util.Objects;

public class AuthorizedPojo {
	
	private String url;
	private String method;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public AuthorizedPojo(String url, String method) {
		super();
		this.url = url;
		this.method = method;
	}
	public AuthorizedPojo() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(method, url);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorizedPojo other = (AuthorizedPojo) obj;
		return Objects.equals(method, other.method) && Objects.equals(url, other.url);
	}
}
