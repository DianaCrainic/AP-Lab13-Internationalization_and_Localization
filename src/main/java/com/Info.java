package com;

import app.LocaleExplorer;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;


/**
 * Info class displays information about the current or a specific locale
 */
public class Info extends Command {
    public Info(String command, String arg) {
        super(command, arg);
    }

    @Override
    public String execute(Object... args) {
        LocaleExplorer localeExplorer = (LocaleExplorer) args[0];
        String languageTag = localeExplorer.getLocale().getLanguage();
        if (args.length >= 2) {
            languageTag = (String) args[1];
        }

        System.out.println(localeExplorer.getMessage("info", languageTag));
        getInfo(languageTag);
        return null;
    }

    private void getInfo(String languageTag) {
        Locale locale = new Locale(languageTag);
        Locale englishLocale = Locale.getDefault();

        System.out.print("Country: ");
        System.out.println(locale.getDisplayCountry(englishLocale) + " (" + locale.getDisplayCountry(locale) + ")");

        System.out.print("Language: ");
        System.out.println(locale.getDisplayLanguage(englishLocale) + " (" + locale.getDisplayLanguage(locale) + ")");

        System.out.print("Currency: ");
        System.out.println(Currency.getInstance(locale).getDisplayName(englishLocale) + " (" + Currency.getInstance(locale).getCurrencyCode() + ")");

        String[] days = new DateFormatSymbols(locale).getWeekdays();
        System.out.println("Weekdays: " + Arrays.toString(days));

        String[] months = new DateFormatSymbols(locale).getMonths();
        System.out.println("Months: " + Arrays.toString(months));
        System.out.println("Today: " + DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, locale).format(new Date()));
    }
}
