package io.github.yakami129.concise.chatrobot.plugin;

import com.intellij.openapi.wm.ToolWindow;
import io.github.yakami129.concise.chatrobot.plugin.config.AppSettingsState;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

/**
 * Created by alan on 2023/3/24.
 */
@Slf4j
public class ChatrobotWindow {

    private JTextField chatInputTextField;
    private JButton sendChatButton;
    private JTextPane chatrobotViewTextPane;
    private JPanel panel1;
    private ToolWindow toolWindow;

    public ChatrobotWindow(ToolWindow toolWindow) {

        this.toolWindow = toolWindow;

        // 监听到提交动作
        sendChatButton.addActionListener(a -> {

            // 获取到输入框字符
            final String text = chatInputTextField.getText();

            // 发送到chatGPT
            final String response = AppSettingsState.getInstance().getChatGPTClient().chat(text);
            if (log.isDebugEnabled()) {
                log.debug("[BIZ] ChatGPT response is {}", response);
            }

            // 发送到对话框
            chatrobotViewTextPane.setText(response);
        });

    }

    public JPanel getContent() {
        return panel1;
    }

}
