package com;

import app.LocaleExplorer;

public class SetLocale extends Command{
    public SetLocale(String command, String arg) {
        super(command, arg);
    }

    @Override
    public String execute(Object... args) {
        if(args.length != 2){
            return "format: set tag";
        }

        LocaleExplorer localeExplorer = (LocaleExplorer) args[0];
        String languageTag = (String) args[1];
        if(languageTag.equals("en") || languageTag.equals("ro")){
            localeExplorer.setLocale(languageTag);
            String message = localeExplorer.getMessage("locale.set", localeExplorer.getLocale().toString());
            return message;
        }
        return null;
    }
}
