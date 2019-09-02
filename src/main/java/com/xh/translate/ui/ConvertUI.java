package com.xh.translate.ui;

import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;

public class ConvertUI extends JFrame {

    public ConvertUI() throws HeadlessException {
        buildView();
    }

    private void buildView(){
        JPanel jPanel = new JPanel();
        JLabel outLabel = new JLabel();
        outLabel.setText("输出文件");

        JTextField outTextField = new JTextField("请添加输出文件",36);
        JButton addOutBtn = new JButton();
        addOutBtn.setText("+");
        jPanel.add(outLabel, BorderLayout.WEST);
        jPanel.add(outTextField, BorderLayout.CENTER);
        jPanel.add(addOutBtn, BorderLayout.EAST);


        getContentPane().add(jPanel, BorderLayout.NORTH);

        this.setTitle("Android翻译转换工具");
        this.setBounds(200,200, 600, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
