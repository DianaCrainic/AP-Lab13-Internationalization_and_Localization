package com;

import app.LocaleExplorer;

import java.util.Locale;

/**
 * DisplayLocales class: displays all available locales
 */
public class DisplayLocales extends Command{
    public DisplayLocales(String command) {
        super(command);
    }

    @Override
    public String execute(Object... args) {
        LocaleExplorer localeExplorer = (LocaleExplorer) args[0];
        System.out.println(localeExplorer.getMessage("locales"));
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale: locales){
            System.out.println(locale.getDisplayCountry() + "  "+
                    locale.getDisplayLanguage(locale));
        }
        return null;
    }
}
