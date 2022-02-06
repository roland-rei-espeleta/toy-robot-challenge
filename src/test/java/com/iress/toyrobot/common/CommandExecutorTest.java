package com.iress.toyrobot.common;

import com.iress.toyrobot.common.commands.BaseCommand;
import com.iress.toyrobot.common.commands.Commands;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandExecutorTest {

    @Test
    public void testUseValidCommands() {
        List<RawCommand> rawCommands = new ArrayList<>();
        rawCommands.add(new RawCommand("PLACE 0,1,NORTH"));
        rawCommands.add(new RawCommand("MOVE"));
        CommandExecutor executor = new CommandExecutor(rawCommands);
        List<BaseCommand> commands = executor.getBaseCommands();
        List<BaseCommand> error_commands = getCommandsByType(commands, Commands.ERROR);
        assertEquals(0, error_commands.size());
    }

    @Test
    public void testUseInvalidCommands() {
        List<RawCommand> rawCommands = new ArrayList<>();
        rawCommands.add(new RawCommand("PLACE 0,1,NORTH"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("JUMP"));
        CommandExecutor executor = new CommandExecutor(rawCommands);
        List<BaseCommand> commands = executor.getBaseCommands();
        List<BaseCommand> error_commands = getCommandsByType(commands, Commands.ERROR);
        assertEquals(1, error_commands.size());
    }

    @Test
    public void testIfRobotMoveBasedOnExampleA() {
        List<RawCommand> rawCommands = new ArrayList<>();
        rawCommands.add(new RawCommand("PLACE 0,0,NORTH"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("REPORT"));
        CommandExecutor executor = new CommandExecutor(rawCommands);
        executor.execute();
        Position pos = executor.getRobot().getPosition();

        assertEquals(0, pos.getX());
        assertEquals(1, pos.getY());
        assertEquals(Direction.NORTH, pos.getDirection());
    }

    @Test
    public void testIfRobotMoveBasedOnExampleB() {
        List<RawCommand> rawCommands = new ArrayList<>();
        rawCommands.add(new RawCommand("PLACE 0,0,NORTH"));
        rawCommands.add(new RawCommand("LEFT"));
        rawCommands.add(new RawCommand("REPORT"));
        CommandExecutor executor = new CommandExecutor(rawCommands);
        executor.execute();
        Position pos = executor.getRobot().getPosition();

        assertEquals(0, pos.getX());
        assertEquals(0, pos.getY());
        assertEquals(Direction.WEST, pos.getDirection());
    }

    @Test
    public void testIfRobotMoveBasedOnExampleC() {
        List<RawCommand> rawCommands = new ArrayList<>();
        rawCommands.add(new RawCommand("PLACE 1,2,EAST"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("LEFT"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("REPORT"));
        CommandExecutor executor = new CommandExecutor(rawCommands);
        executor.execute();
        Position pos = executor.getRobot().getPosition();

        assertEquals(3, pos.getX());
        assertEquals(3, pos.getY());
        assertEquals(Direction.NORTH, pos.getDirection());
    }

    @Test
    public void testIfCommandsIgnoredBeforeRobotIsPlaced() {

        List<RawCommand> rawCommands = new ArrayList<>();
        rawCommands.add(new RawCommand("RIGHT"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("PLACE 1,2,EAST"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("LEFT"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("REPORT"));

        CommandExecutor executor = new CommandExecutor(rawCommands);
        executor.execute();
        List<BaseCommand> baseCommands = executor.getBaseCommands();

        assertEquals(false, baseCommands.get(0).isSuccess());
        assertEquals(false, baseCommands.get(1).isSuccess());
        assertEquals(true, baseCommands.get(3).isSuccess());
    }

    @Test
    public void test2PlaceCommandsIfItWillUpdateThePosition() {

        List<RawCommand> rawCommands = new ArrayList<>();
        rawCommands.add(new RawCommand("PLACE 1,2,EAST"));
        rawCommands.add(new RawCommand("MOVE"));
        rawCommands.add(new RawCommand("PLACE 3,3,EAST"));
        rawCommands.add(new RawCommand("REPORT"));

        CommandExecutor executor = new CommandExecutor(rawCommands);
        executor.execute();
        Position pos = executor.getRobot().getPosition();

        assertEquals(3, pos.getX());
        assertEquals(3, pos.getY());

    }

    private List<BaseCommand> getCommandsByType(List<BaseCommand> baseCommands, Commands commands) {
        return baseCommands.stream()
                .filter( baseCommand -> baseCommand.getCommand() == commands)
                .collect(Collectors.toList());
    }
}
