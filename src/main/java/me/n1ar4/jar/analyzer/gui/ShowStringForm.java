package me.n1ar4.jar.analyzer.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import me.n1ar4.jar.analyzer.starter.Const;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShowStringForm {
    private JPanel masterPanel;
    private JScrollPane stringScroll;
    private JTextArea stringArea;
    private JButton prevBtn;
    private JButton nextBtn;
    private JPanel opPanel;
    private JLabel totalLabel;
    private JLabel curLabel;
    private int curPage;
    private int totalPage;

    public static void start(int total, ArrayList<String> list, JDialog dialog) {
        JFrame frame = new JFrame(Const.StringForm);
        ShowStringForm instance = new ShowStringForm();

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append("\n");
        }
        instance.stringArea.setText(sb.toString());
        instance.stringArea.setCaretPosition(0);

        int totalPage = total / 100 + 1;
        int curPage = 1;

        instance.totalLabel.setText(String.format("Total: %d", total));
        instance.curLabel.setText(String.format("Page: %d/%d", curPage, totalPage));
        instance.curPage = 1;
        instance.totalPage = totalPage;

        instance.nextBtn.addActionListener(e -> {
            if (instance.curPage == instance.totalPage) {
                JOptionPane.showMessageDialog(instance.masterPanel, "you cannot do it");
                return;
            }
            ArrayList<String> nextList = MainForm.getEngine().getStrings(instance.curPage + 1);
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : nextList) {
                stringBuilder.append(s);
                stringBuilder.append("\n");
            }
            instance.stringArea.setText(stringBuilder.toString());
            instance.stringArea.setCaretPosition(0);
            instance.curPage += 1;
            instance.curLabel.setText(String.format("Page: %d/%d", instance.curPage, instance.totalPage));
        });

        instance.prevBtn.addActionListener(e -> {
            if (instance.curPage == 1) {
                JOptionPane.showMessageDialog(instance.masterPanel, "you cannot do it");
                return;
            }
            ArrayList<String> nextList = MainForm.getEngine().getStrings(instance.curPage - 1);
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : nextList) {
                stringBuilder.append(s);
                stringBuilder.append("\n");
            }
            instance.stringArea.setText(stringBuilder.toString());
            instance.stringArea.setCaretPosition(0);
            instance.curPage -= 1;
            instance.curLabel.setText(String.format("Page: %d/%d", instance.curPage, instance.totalPage));
        });

        frame.setContentPane(instance.masterPanel);
        dialog.dispose();
        frame.setLocationRelativeTo(MainForm.getInstance().getMasterPanel());
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        masterPanel = new JPanel();
        masterPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        stringScroll = new JScrollPane();
        masterPanel.add(stringScroll, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(500, 600), null, 0, false));
        stringArea = new JTextArea();
        stringArea.setEditable(true);
        stringScroll.setViewportView(stringArea);
        opPanel = new JPanel();
        opPanel.setLayout(new GridLayoutManager(1, 5, new Insets(0, 0, 5, 0), -1, -1));
        masterPanel.add(opPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        prevBtn = new JButton();
        prevBtn.setText("Prev");
        opPanel.add(prevBtn, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        opPanel.add(spacer1, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        nextBtn = new JButton();
        nextBtn.setText("Next");
        opPanel.add(nextBtn, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        totalLabel = new JLabel();
        totalLabel.setText("Label");
        opPanel.add(totalLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        curLabel = new JLabel();
        curLabel.setText("Label");
        opPanel.add(curLabel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return masterPanel;
    }

}
