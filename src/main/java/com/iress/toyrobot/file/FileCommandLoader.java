package com.iress.toyrobot.file;

import com.iress.toyrobot.common.CommandLoader;
import com.iress.toyrobot.common.RawCommand;
import com.iress.toyrobot.file.exceptions.FileReadException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Copyrights 2002-2022 Webb Fontaine
 * Developer: Roland Rei S.J Espeleta
 * Date: 2/11/22
 * This software is the proprietary information of Webb Fontaine.
 * Its use is subject to License terms.
 */
public class FileCommandLoader implements CommandLoader {

    private final FileCommandReader fileReader;

    private final String fileName;

    public FileCommandLoader(FileCommandReader fileReader, String fileName) {
        this.fileReader = fileReader;
        this.fileName = fileName;
    }

    public void addCommands() throws FileReadException, IOException{
        addCommandsFromFile();
    }

    public void addCommandsFromFile() throws FileReadException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
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
