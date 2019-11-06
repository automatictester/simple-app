package uk.co.automatictester.simple.app;

import io.javalin.Javalin;

import java.util.Random;

public class SimpleWebServer {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);
        app.get("/", ctx -> ctx.result(getRandomNumber()));
    }

    private static String getRandomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(8999) + 1000;
        return String.format("haha 2: %d", randomNumber);
    }
}
