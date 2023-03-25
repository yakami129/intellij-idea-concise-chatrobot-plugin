// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.yakami129.concise.chatrobot.plugin.config;

import com.intellij.openapi.options.Configurable;
import org.apache.commons.lang3.math.NumberUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Provides controller functionality for application settings.
 */
public class AppSettingsConfigurable implements Configurable {

    private AppSettingsComponent settingsComponent;

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EPz

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "ChatRobot Setting";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return settingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        settingsComponent = new AppSettingsComponent();
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.apiKey = settingsComponent.getOpenAIKeyText().getText();
        settings.apiHost = settingsComponent.getOpenAIHostText().getText();
        settings.proxyHost = settingsComponent.getProxyHostText().getText();
        settings.proxyPort = NumberUtils.toInt(settingsComponent.getProxyPortText().getText());
        settings.buildChatGPTClient();
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settingsComponent.setOpenAIKeyText(settings.apiKey);
        settingsComponent.setOpenAIHostText(settings.apiHost);
        settingsComponent.setProxyHostText(settings.proxyHost);
        settingsComponent.setProxyPortText(settings.proxyPort.toString());
    }

    @Override
    public void disposeUIResources() {
        settingsComponent = null;
    }

}
