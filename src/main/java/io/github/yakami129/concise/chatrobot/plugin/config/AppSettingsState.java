// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.yakami129.concise.chatrobot.plugin.config;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import io.github.yakami129.concise.chatrobot.plugin.chatgpt.ChatGPTClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
        name = "org.intellij.sdk.settings.AppSettingsState",
        storages = @Storage("SdkSettingsPlugin.xml")
)
public class AppSettingsState implements PersistentStateComponent<AppSettingsState> {

    // config
    public String apiKey = "sk-xxxxxxxxxxx";
    public String apiHost = "https://api.openai.com";
    public String proxyHost = "127.0.0.1";
    public Integer proxyPort = 8081;

    // client
    private ChatGPTClient chatGPTClient;

    public static AppSettingsState getInstance() {
        return ApplicationManager.getApplication().getService(AppSettingsState.class);
    }

    public ChatGPTClient getChatGPTClient() {
        if (Objects.isNull(chatGPTClient)) {
            chatGPTClient = new ChatGPTClient(AppSettingsState.getInstance().apiKey, AppSettingsState.getInstance().apiHost
                    , AppSettingsState.getInstance().proxyHost, AppSettingsState.getInstance().proxyPort);
        }
        return chatGPTClient;
    }

    public void buildChatGPTClient() {
        chatGPTClient = new ChatGPTClient(AppSettingsState.getInstance().apiKey, AppSettingsState.getInstance().apiHost
                , AppSettingsState.getInstance().proxyHost, AppSettingsState.getInstance().proxyPort);
    }

    @Nullable
    @Override
    public AppSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AppSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}
