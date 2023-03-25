package io.github.yakami129.concise.chatrobot.plugin.chatgpt;


import io.github.yakami129.starter.chatgpt.ChatGPT;
import io.github.yakami129.starter.chatgpt.util.Proxys;

import java.net.Proxy;

/**
 * Created by alan on 2023/3/24.
 */
public class ChatGPTClient {

    private ChatGPT chatGPT;

    public ChatGPTClient(String apiKey, String apiHost) {
        this.chatGPT = ChatGPT.builder()
                .openAIKey(apiKey)
                .openaiHost(apiHost)
                .build()
                .init();
    }

    public ChatGPTClient(String apiKey, String apiHost, String proxyHost, Integer proxyPort) {
        Proxy proxy = Proxys.http(proxyHost, proxyPort);
        this.chatGPT = ChatGPT.builder()
                .openAIKey(apiKey)
                .openaiHost(apiHost)
                .proxy(proxy)
                .build()
                .init();
    }

    public ChatGPTClient(String apiKey, String proxyHost, Integer proxyPort) {
        Proxy proxy = Proxys.http(proxyHost, proxyPort);
        this.chatGPT = ChatGPT.builder()
                .openAIKey(apiKey)
                .proxy(proxy)
                .build()
                .init();
    }

    public String chat(String message) {
        return chatGPT.chatRequest().chat(message);
    }

}
