package app;

import com.*;

import java.text.MessageFormat;
import java.util.*;

public class LocaleExplorer {
    private final String baseName = "Messages";
    private Locale locale;
    private ResourceBundle resourceBundle;
    private Shell shell;
    private CommandsProp commandsProp;

    public static void main(String[] args) {
        new LocaleExplorer();
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(String tag) {
        this.locale = (Locale.forLanguageTag(tag));
        this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }

    public LocaleExplorer() {
        this.locale = Locale.getDefault();
        this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
        this.commandsProp = new CommandsProp();
        this.shell = getShell();
        while (true) {
            System.out.print(getMessage("prompt"));
            Map<String, Object> commandMap = readCommand();
            String response = executeCommand(commandMap);
            if (response != null) {
                System.out.println(response);
            }
        }
    }

    private Shell getShell() {
        Shell shell = new Shell();
        shell.addCommand(new DisplayLocales("display-locales"));
        shell.addCommand(new SetLocale("set-locale", "tag"));
        shell.addCommand(new Info("info", "tag"));
        return shell;
    }

    public String getMessage(String key, String... arguments) {
        String pattern = resourceBundle.getString(key);
        return new MessageFormat(pattern).format(arguments);
    }

    public Map<String, Object> readCommand() {
        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();

        String[] commandArg = request.split(" ", 2);
        Command command = shell.getCommand(commandArg[0]);

        Map<String, Object> commandMap = new HashMap<>();
        commandMap.put("command", command);
        commandMap.put("arguments", commandArg);
        return commandMap;
    }

    public String executeCommand(Map<String, Object> commandMap) {
        Command command = (Command) commandMap.get("command");
       if (command.getCommand().equals(commandsProp.getPropertyName("display-locales.command"))) {
            return command.execute(this);
        } else if (command.getCommand().equals(commandsProp.getPropertyName("set-locale.command"))) {
            String tag = ((String[]) commandMap.get("arguments"))[1];
            return command.execute(this, tag);
        } else if (command.getCommand().equals(commandsProp.getPropertyName("info.command"))) {
            String[] arguments = ((String[]) commandMap.get("arguments"));
            if (arguments.length > 1) {
                return command.execute(this, arguments[1]);
            }
            return command.execute(this);
        }

        return command.execute();
    }



}