package com.example.demo;

import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.ui.components.JBScrollPane;

import javax.swing.*;

public class DemoToolWindow {
    private JPanel contentToolWindow = null;

    public JComponent getContent() {
        return contentToolWindow;
    }

    public DemoToolWindow() {
        contentToolWindow = new SimpleToolWindowPanel(true, false);
        JTextArea textArea = new JTextArea();
        JBScrollPane scrollPane = new JBScrollPane(textArea);
        contentToolWindow.setLayout(new BoxLayout(contentToolWindow, BoxLayout.Y_AXIS));
        contentToolWindow.add(scrollPane);
    }
}
