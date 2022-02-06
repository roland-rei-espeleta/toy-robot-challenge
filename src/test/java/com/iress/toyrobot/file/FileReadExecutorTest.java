package com.iress.toyrobot.file;

import com.iress.toyrobot.common.exceptions.ToyRobotException;
import com.iress.toyrobot.file.exceptions.FileReadException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileReadExecutorTest {

    @Test
    void testFileReadIfExecuteIsCalledForExistingFiles() {
        FileReadExecutor fileReadExecutor = Mockito.spy(new FileReadExecutor("command_a.txt"));
        fileReadExecutor.execute();
        verify(fileReadExecutor).execute();
    }

    @Test
    void testFileReadIfExecuteIsCalledForExampleB() {
        FileReadExecutor fileReadExecutor = Mockito.spy(new FileReadExecutor("command_b.txt"));
        fileReadExecutor.execute();
        verify(fileReadExecutor).execute();
    }

    @Test
    void verifyFileReadIfExecuteIsCalledForExampleC() {
        FileReadExecutor fileReadExecutor = Mockito.spy(new FileReadExecutor("command_c.txt"));
        fileReadExecutor.execute();
        verify(fileReadExecutor).execute();
    }

    @Test
    void testExecuteIfExceptionThrownForNonExistentFiles() {
        FileReadExecutor fileReadExecutor = new FileReadExecutor("command_d.txt");
        ToyRobotException thrown = assertThrows(ToyRobotException.class, () -> fileReadExecutor.execute(), "Toy Robot Failed");
        assertTrue(thrown.getMessage().contains("Toy Robot Failed"));
    }

    @Test
    void testExecuteIfFileNameIsEmpty() {
        FileReadExecutor fileReadExecutor = new FileReadExecutor("");
        ToyRobotException thrown = assertThrows(ToyRobotException.class, () -> fileReadExecutor.execute(), "File name must not be empty!");
        assertEquals("File name must not be empty!", thrown.getMessage());
    }

}
