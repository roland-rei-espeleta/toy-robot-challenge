package com.iress.toyrobot;

import com.iress.toyrobot.common.ReaderExecutor;
import com.iress.toyrobot.common.exceptions.ToyRobotException;
import com.iress.toyrobot.file.FileReadExecutor;

public class ToyRobotMainClass {

    public static void main(String[] args) {
        System.out.println("-----------------");
        try{
            ReaderExecutor executor = new FileReadExecutor();
            executor.execute();
        } catch(ToyRobotException exception) {
            System.out.println("" + exception.getMessage());
        }
    }
}
