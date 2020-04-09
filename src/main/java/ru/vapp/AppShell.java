package ru.vapp;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

// chrome://apps/

@PWA(name = "VPlatform Application",
        shortName = "VPlatform",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false,
		startPath = "login",
		backgroundColor = "#227aef", themeColor = "#227aef",
		offlinePath = "offline-page.html",
		offlineResources = {"images/offline-login-banner.jpg"})
public class AppShell implements AppShellConfigurator {
}
