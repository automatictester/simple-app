package uk.co.automatictester.simple.app.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class Versions {

    private static final Random RANDOM = new Random();
    private final int runtimeId = RANDOM.nextInt(8999) + 1000;
    private final String appVersion;

    public Versions() {
        String artifactVersion = Versions.class.getPackage().getImplementationVersion();
        appVersion = artifactVersion == null ? "unknown" : artifactVersion;
    }

    public int getRequestId() {
        return RANDOM.nextInt(8999) + 1000;
    }
}
