// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.yakami129.concise.chatrobot.plugin.config;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;

/**
 * Supports creating and managing a {@link JPanel} for the Settings Dialog.
 */
public class AppSettingsComponent {

    private final JPanel chatGPTConfigPanel;
    private final JBTextField openAIKeyText = new JBTextField();
    private final JBTextField openAIHostText = new JBTextField();
    private final JBTextField proxyHostText = new JBTextField();
    private final JBTextField proxyPortText = new JBTextField();

    public AppSettingsComponent() {

        chatGPTConfigPanel = FormBuilder
                .createFormBuilder()
                .addLabeledComponent(new JBLabel("openAIKey: "), openAIKeyText, 1, false)
                .addLabeledComponent(new JBLabel("openAIHost: "), openAIHostText, 2, false)
                .addLabeledComponent(new JBLabel("proxyHost: "), proxyHostText, 3, false)
                .addLabeledComponent(new JBLabel("proxyPort: "), proxyPortText, 4, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();

    }

    public JPanel getPanel() {
        return chatGPTConfigPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return openAIKeyText;
    }

    public JBTextField getOpenAIKeyText() {
        return openAIKeyText;
    }

    public JBTextField getOpenAIHostText() {
        return openAIHostText;
    }

    public JBTextField getProxyHostText() {
        return proxyHostText;
    }

    public JBTextField getProxyPortText() {
        return proxyPortText;
    }

    public void setOpenAIKeyText(String openAIkey) {
        openAIKeyText.setText(openAIkey);
    }

    public void setOpenAIHostText(String openAIHost) {
        openAIHostText.setText(openAIHost);
    }

    public void setProxyHostText(String proxyHost) {
        proxyHostText.setText(proxyHost);
    }

    public void setProxyPortText(String proxyPort) {
        proxyPortText.setText(proxyPort);
    }


}
