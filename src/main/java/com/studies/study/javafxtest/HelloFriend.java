package com.studies.study.javafxtest;

import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * detail
 *
 * @Author gujiashun
 * @date 2019/12/9
 */
public class HelloFriend extends Application  {
    /**
     * atomicInteger：用于统计用户单击按钮的次数
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static Integer testInteger = 0;

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*创建一个按钮控件,并设置按钮上的文字，同时为他绑定单击事件，鼠标点击按钮后，控制台输出"Hello Friend"*/
        Button btn = new Button();
        btn.setText("Say 'Hello Friend'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(atomicInteger.addAndGet(1) + "：Hello Friend");
            }
//            public void handle(ActionEvent event) {
//                System.out.println(++testInteger + "：Hello Friend");
//            }
        });

        /*创建一个堆栈面板，面板包含控件*/
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        /*创建一个场景，场景包含面板*/
        Scene scene = new Scene(root, 300, 250);

        /*最后将场景放入到舞台中，舞台包含场景<-场景包含面板<-面板包含控件*/
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        /*显示*/
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
