package com.AutoClicker;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutoClicker {
    
    public static void main(String[] args) {
        
        int rate = 50; // Clicks per second
        
        try {
            Robot robot = new Robot();
            
            while (true) {
                Thread.sleep(1000/rate);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
