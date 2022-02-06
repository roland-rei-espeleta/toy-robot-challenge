package com.iress.toyrobot.file;

import com.iress.toyrobot.common.CommandExecutor;
import com.iress.toyrobot.common.RawCommand;
import com.iress.toyrobot.common.ReaderExecutor;
import com.iress.toyrobot.common.exceptions.ToyRobotException;
import com.iress.toyrobot.file.exceptions.FileReadException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class FileReadExecutor implements ReaderExecutor {

    private String fileName;

    public FileReadExecutor() {
    }

    public FileReadExecutor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute() throws ToyRobotException {
        CommandExecutor commandExecutor = new CommandExecutor(getReader().read());
        commandExecutor.execute();
    }

    @Override
    public FileReader getReader() {
        FileReader fileReader = new FileReader();
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

    private void readFile(FileReader fileReader, String filename) {

        try {
            loadFile(fileReader, filename);
        } catch (FileReadException exception) {
            System.out.println("Command filename not found! : " + exception.getMessage());
            throw new ToyRobotException("Toy Robot Failed!");
        } catch(IOException exception) {
            System.out.println("Command file invalid! : " + exception.getMessage());
            throw new ToyRobotException("Toy Robot Failed!");
        }
    }

    private void loadFile(FileReader fileReader, String filename) throws FileReadException, IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(filename);
        if(url == null) {
            throw new FileReadException("URL Resource not found!");
        }
        File file = new File(url.getPath());
        BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            fileReader.addCommand(new RawCommand(line));
        }
    }
}
