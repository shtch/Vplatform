package ru.vapp;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

// chrome://apps/

@PWA(name = "VPlatform Application",
        shortName = "VPlatform",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = true)
public class AppShell implements AppShellConfigurator {
}
