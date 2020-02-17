package uk.co.automatictester.simple.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.co.automatictester.simple.app.model.Versions;

@Slf4j
@Controller
public class VersionsController {

    private final Versions versions;

    public VersionsController(@Autowired Versions versions) {
        this.versions = versions;
    }

    @GetMapping("/")
    public ModelAndView versions() {
        log.info("GET request...");
        ModelAndView model = new ModelAndView("versions");
        model.addObject("appVersion", versions.getAppVersion());
        model.addObject("runtimeId", versions.getRuntimeId());
        model.addObject("requestId", versions.getRequestId());
        return model;
    }
}
