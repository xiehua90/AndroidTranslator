package com.xh.translate.ui;

import javax.swing.*;
import java.awt.*;

public class Demo9 extends JFrame {
    int size = 9;
    JButton jbs[] = new JButton[size];


    public Demo9() throws HeadlessException {
        createView();
    }

    private void createView(){
        // 创建组件
        for (int i = 0; i < size; i++) {
            jbs[i] = new JButton(String.valueOf(i));
        }
        // 设置网格布局,这里只有前两个参数（行/列）3和3 的话，网格没有空隙
        this.setLayout(new GridLayout(3, 3, 10, 10));

        // 添加组件
        for (int i = 0; i < size; i++) {
            this.add(jbs[i]);
        }
        // 设置窗体属性
        this.setTitle("网格布局案例");
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);

        // 显示
        this.setVisible(true);
    }


}
