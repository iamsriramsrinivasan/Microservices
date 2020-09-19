package org.sriraminc.quarkus.samples.lifecycle;

import javax.inject.Inject;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.CommandLineArguments;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {
	
	@Inject
	@CommandLineArguments
	String[] args;
	
	public static void main(String... args) {
		
		Quarkus.run(MyApp.class, args);
		
	}
	
	public static class MyApp implements QuarkusApplication {
		
		@Override
		public int run(String...args) throws Exception {
			System.out.println("Do Startup Logic Here");
			Quarkus.waitForExit();
			return 0;
		}
	}

}
