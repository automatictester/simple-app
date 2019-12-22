package uk.co.automatictester.simple.app;

import io.javalin.Javalin;

import java.util.Random;

public class SimpleWebServer {

    private static final int RUNTIME_ID = new Random().nextInt(8999) + 1000;
    private static Random rand = new Random();

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);
        app.get("/", ctx -> ctx.result(getResponse()));
    }

    private static String getResponse() {
        return String.format("Version:   %s\nRuntimeId: %d\nRequestId: %d\n",
                appVersion(),
                RUNTIME_ID,
                getRequestId()
        );
    }

    private static int getRequestId() {
        return rand.nextInt(8999) + 1000;
    }

    private static String appVersion() {
        String version = SimpleWebServer.class.getPackage().getImplementationVersion();
        return version == null ? "unknown" : version;
    }
}
