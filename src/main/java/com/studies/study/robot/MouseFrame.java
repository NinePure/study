package com.studies.study.robot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * detail
 *
 * @author gujiashun
 * @date 2020/4/21
 */
public class MouseFrame extends JFrame implements Runnable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // 初始提示
    private JLabel startLabel = new JLabel("鼠标初始位置");
    // 初始位置
    private JTextArea startArea = new JTextArea();
    // 第二次提示
    private JLabel secLabel = new JLabel("鼠标第二次点击");
    // 第二次确认位置
    private JTextArea secArea = new JTextArea();
    // 第三次提示
    private JLabel endLabel = new JLabel("鼠标最终位置");
    // 第三次确认位置
    private JTextArea endArea = new JTextArea();
    // 输入时间范围
    private JLabel timeLabel = new JLabel("请输入每个周期时间范围(s)");
    private JLabel space = new JLabel("");
    private JLabel minTimeLabel = new JLabel("请输入最小时间(s)");
    private JLabel maxTimeLabel = new JLabel("请输入最大时间(s)");
    private JLabel timeIntervalLabel = new JLabel("两次点击时间间隔(s)");
    private JLabel timesLabel = new JLabel("请输入周期次数");
    private JLabel lessTimes = new JLabel("剩余次数");
    // 最小时间
    private JTextField minTimeTextField = new JTextField();
    // 最大时间
    private JTextField maxTimeTextField = new JTextField();
    // 时间间隔
    private JTextField timeIntervalTextField = new JTextField();
    // 时间间隔
    private JTextField timesTextField = new JTextField();
    // 剩余次数
    private JTextArea lessTimeArea = new JTextArea();
    // 版权
    private JLabel author = new JLabel("Stanley Xu 制作");
    // 鼠标当前坐标
    double pointY = 0;
    double pointX = 0;
    // 鼠标起始坐标
    double startX = 0;
    double startY = 0;
    // 鼠标最终坐标
    double secX = 0;
    double secY = 0;
    // 鼠标最终坐标
    double endX = 0;
    double endY = 0;
    // 线程运行标记
    boolean autoFlag = false;
    // 设置时间范围
    double minTime = 1000;
    double maxTime = 2000;
    double timeInterval = 300;
    int n = 0;
    int i = 0;


    public void showPanel() {
        this.setSize(500, 300);
        JPanel panel = new JPanel();
        // 设置边框
        startArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        secArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        endArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        lessTimeArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        // 布置格式
        panel.setLayout(new GridLayout(13, 2));
        panel.add(startLabel);
        panel.add(startArea);
        // panel.add(startButton);
        panel.add(secLabel);
        panel.add(secArea);
        panel.add(endLabel);
        panel.add(endArea);
        panel.add(timeLabel);
        panel.add(space);
        panel.add(minTimeLabel);
        panel.add(minTimeTextField);
        panel.add(maxTimeLabel);
        panel.add(maxTimeTextField);
        panel.add(timeIntervalLabel);
        panel.add(timeIntervalTextField);
        panel.add(timesLabel);
        panel.add(timesTextField);
        panel.add(lessTimes);
        panel.add(lessTimeArea);
        // 布置操作提示
        JLabel metionLabel1 = new JLabel("F1确认鼠标初始位置");
        JLabel metionLabel2 = new JLabel("F2确认鼠标最终位置");
        JLabel metionLabel3 = new JLabel("F3确认鼠标最终位置");
        JLabel metionLabel4 = new JLabel("");
        JLabel metionLabel5 = new JLabel("F4开始结束 ");
        JLabel metionLabel6 = new JLabel("F5退出 ");
        JLabel metionLabel7 = new JLabel("F6最小化");
        JLabel metionLabel8 = new JLabel("F7恢复窗口");
        panel.add(metionLabel1);
        panel.add(metionLabel2);
        panel.add(metionLabel3);
        panel.add(metionLabel4);
        panel.add(metionLabel5);
        panel.add(metionLabel6);
        panel.add(metionLabel7);
        panel.add(metionLabel8);
        // 显示窗口
        JPanel authorPanel = new JPanel();
        authorPanel.setLayout(new FlowLayout());
        authorPanel.add(author);
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        this.add(authorPanel, BorderLayout.SOUTH);
        setTitle("按键精灵");
        this.setVisible(true);
        // 窗口一直在上面
        this.setAlwaysOnTop(true);

    }
    /**
     * When an object implementing interface <code>Runnable</code> is used to create a thread, starting the thread
     * causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
// TODO Auto-generated method stub
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            while (autoFlag && i <= n) {

                lessTimeArea.setText(n - i + "次");
                i++;
                double time = timeCal(minTime, maxTime);
//                RobotOperation.mouseOp(startX, startY, secX,secY,endX, endY, timeInterval);
                try {
                    Thread.sleep((long) time);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    // 计算时间范围
    public double timeCal(double minTime, double maxTime) {
        double timeDev = maxTime - minTime;
        double time =  (timeDev * (Math.random())) + minTime;
        return time;
    }
}
