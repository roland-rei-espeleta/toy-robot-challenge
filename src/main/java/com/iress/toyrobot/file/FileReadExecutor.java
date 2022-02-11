package com.iress.toyrobot.file;

import com.iress.toyrobot.common.CommandLoader;
import com.iress.toyrobot.common.CommandReader;
import com.iress.toyrobot.common.ReaderExecutor;
import com.iress.toyrobot.common.exceptions.ToyRobotException;
import com.iress.toyrobot.file.exceptions.FileReadException;

import java.io.IOException;
import java.util.Scanner;

public class FileReadExecutor implements ReaderExecutor {

    private String fileName;

    public FileReadExecutor() {
    }

    public FileReadExecutor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public CommandReader getCommandReader() {
        CommandReader fileReader = new FileCommandReader();
        String filename;
        System.out.print("Enter commands filename : ");
        filename = getFileName();
        if(!filename.isEmpty()) {
            readFile(fileReader, filename);
        } else {
            throw new FileReadException("File name must not be empty!");
        }
        return fileReader;
    }

    private String getFileName() {
        if(fileName != null) {
            return fileName;
        } else {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
    }

    private void readFile(CommandReader fileReader, String filename) throws ToyRobotException {

        try {
            CommandLoader loader = new FileCommandLoader(fileReader, filename);
            loader.addCommands();
        } catch (FileReadException exception) {
            System.out.println("Command filename not found! : " + exception.getMessage());
            throw new ToyRobotException("Toy Robot Failed!");
        } catch(IOException exception) {
            System.out.println("Command file invalid! : " + exception.getMessage());
            throw new ToyRobotException("Toy Robot Failed!");
        }
    }
}
