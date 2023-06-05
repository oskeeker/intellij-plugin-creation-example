package com.example.demo;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.components.JBScrollPane;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AddSelectedTextAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        // retrieve selected text from Editor
        Editor ediTorRequiredData = event.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = ediTorRequiredData.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();

        // retrieve JTextArea component to set selected text
        ToolWindow toolWindow = ToolWindowManager.getInstance(event.getProject()).getToolWindow("DemoTool");
        JViewport viewPort = ((JBScrollPane) toolWindow.getContentManager().getContent(0).getComponent()
                .getComponent(0)).getViewport();
        JTextArea textArea = (JTextArea) viewPort.getView();
        textArea.setText(selectedText);

        // show toolWindow extension when text is added
        toolWindow.show();

    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        // retrieve model to check if there is a selected text
        CaretModel caretModel = event.getRequiredData(CommonDataKeys.EDITOR).getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();
        event.getPresentation().setVisible(selectedText != null && !selectedText.isEmpty());
    }
}
