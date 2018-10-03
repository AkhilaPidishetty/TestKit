package appium.appium;

import java.io.IOException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public abstract class BaseTest {
	private static AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;

	@Before
	public void globalSetup() throws IOException {
//		builder = new AppiumServiceBuilder();
//		builder.withIPAddress("127.0.0.1");
//		builder.usingPort(4723);
//		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
//		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}

	@After
	public void globalTearDown() {
		service.stop();
	}

	public URL getServiceUrl() {
		System.out.println(service.getUrl());
		return service.getUrl();
	}
}