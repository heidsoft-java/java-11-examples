package itx.examples.sshd.commands;

import itx.examples.sshd.commands.keymaps.KeyMap;
import itx.examples.sshd.commands.repl.REPLCommand;
import org.apache.sshd.common.Factory;
import org.apache.sshd.server.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShellFactoryImpl implements Factory<Command> {

    final private static Logger LOG = LoggerFactory.getLogger(ShellFactoryImpl.class);

    private CommandProcessor commandProcessor;
    private KeyMap keyMap;
    private String prompt;

    public ShellFactoryImpl(String prompt, KeyMap keyMap, CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
        this.keyMap = keyMap;
        this.prompt = prompt;
    }

    @Override
    public Command get() {
        LOG.info("get command");
        return new REPLCommand(prompt, keyMap, commandProcessor);
    }

    @Override
    public Command create() {
        LOG.info("create command");
        return new REPLCommand(prompt, keyMap, commandProcessor);
    }

}