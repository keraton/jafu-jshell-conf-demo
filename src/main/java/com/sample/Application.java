package com.sample;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.fu.jafu.JafuApplication;
import uk.org.cinquin.attaching_jshell.ExistingVMRemoteExecutionControl;

import static org.springframework.fu.jafu.Jafu.webApplication;
import static org.springframework.fu.jafu.web.WebFluxServerDsl.server;

public class Application {

	public static JafuApplication app = webApplication(app -> {

		app.beans(beans -> {
			beans.bean(SampleHandler.class);
			beans.bean(SampleService.class);
			beans.bean(MessageRepository.class);
		});

		app.enable(server(server -> {
			server.port(8080);
			server.router(router -> {
				SampleHandler handler = server.ref(SampleHandler.class);
				router.GET("/", handler::hello);
				router.GET("/api", handler::json);
			});
			server.codecs(codecs -> {
				codecs.string();
				codecs.jackson();
			});
		}));


	});


	public static ConfigurableApplicationContext applicationContext;

	public static void main (String[] args) {
		applicationContext = app.run(args);

        ExistingVMRemoteExecutionControl.startJshell("localhost", "4568");
	}
}
