package org.sriraminc.quarkus.samples.config;

import java.util.Optional;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "greeting")
public class GreetingsConfiguration {

	private String message;
	private String suffix = "!";
	private Optional<String> name;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Optional<String> getName() {
		return name;
	}

	public void setName(Optional<String> name) {
		this.name = name;
	}

}
