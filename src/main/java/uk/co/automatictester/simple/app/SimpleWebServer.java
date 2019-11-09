package uk.co.automatictester.simple.app;

import io.javalin.Javalin;

import java.util.Random;

public class SimpleWebServer {

    private static final int RUNTIME_ID = new Random().nextInt(8999) + 1000;
    private static Random rand = new Random();

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);
        app.get("/", ctx -> ctx.result(getRandomNumber()));
    }

    private static String getRandomNumber() {
        int requestId = rand.nextInt(8999) + 1000;
        return String.format("Version:   %s\nRuntimeId: %d\nRequestId: %d",
                appVersion(),
                RUNTIME_ID,
                requestId
        );
    }

    private static String appVersion() {
        String version = SimpleWebServer.class.getPackage().getImplementationVersion();
        return version == null ? "unknown" : version;
    }
}
