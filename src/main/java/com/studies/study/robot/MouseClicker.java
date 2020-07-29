package com.studies.study.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import javax.swing.JLabel;

/**
 * detail
 *
 * @author gujiashun
 * @date 2020/4/21
 */
public class MouseClicker {

    public static void main(String[] args) {
        MouseFrame mouseFrame = new MouseFrame();
        mouseFrame.showPanel();
        /*Robot r;
        try {
            r = new Robot();
            System.out.println(0 + "," + 0 + "," + 1);
            r.mouseMove(0, 0);//将鼠标移至屏幕坐标(sum,sum2)//我的电脑的窗口的大小为1800*1000，左上角为（0,0,）
            r.delay(1000);//停留100ms，这样每秒点击10次
            r.mouseMove(100, 100);//将鼠标移至屏幕坐标(sum,sum2)//我的电脑的窗口的大小为1800*1000，左上角为（0,0,）
            r.delay(1000);//停留100ms，这样每秒点击10次
            r.mouseMove(500, 500);//将鼠标移至屏幕坐标(sum,sum2)//我的电脑的窗口的大小为1800*1000，左上角为（0,0,）
            r.delay(100);//停留100ms，这样每秒点击10次
//            for (int i = 0; i < 1 * 10; i++) {//10次一秒
//                r.mouseMove(0, 0);//将鼠标移至屏幕坐标(sum,sum2)//我的电脑的窗口的大小为1800*1000，左上角为（0,0,）
//                r.delay(100);//停留100ms，这样每秒点击10次
//                r.mousePress(InputEvent.BUTTON1_MASK);//按下鼠标左键
//                r.delay(1);
//                System.out.println("第" + i + "次点击");
//                r.mouseRelease(InputEvent.BUTTON1_MASK);//松开左键
//            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
*/
    }

}
