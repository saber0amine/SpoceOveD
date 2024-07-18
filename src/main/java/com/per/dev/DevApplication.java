package com.per.dev;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RestController
public class DevApplication {

     @Autowired
    private MessageSource messageSource ;
    Locale locale =  LocaleContextHolder.getLocale() ;
    private static final Map<Locale, String> localeToTimezoneMap = new HashMap<>();

    static {
         localeToTimezoneMap.put(Locale.US, "America/New_York");
        localeToTimezoneMap.put(Locale.FRANCE, "Europe/Paris");
        localeToTimezoneMap.put(new Locale("ar", "MA"), "Africa/Casablanca");
     }
    @GetMapping("/")
    public String sayHello( HttpServletRequest httpRequestHandler) {
        Locale locale =  LocaleContextHolder.getLocale() ;

        System.out.println(httpRequestHandler.getRequestURI());
        System.out.println(httpRequestHandler.getHeader("Accept-Language"));

        System.out.println(locale.getLanguage(  ) + " |||" + locale.getCountry(  ) + " ||| " +
                locale.getDisplayCountry(  ) + " ||| " + locale.getDisplayLanguage(  ) + "  |||" + locale.getDisplayName(  )
                + "  |||" + locale.getISO3Country(  ) + "  |||" + locale.getISO3Language(  ) + " ||| " + locale.getVariant(   )  );

        return messageSource.getMessage("welcome.message", null, locale) ;
    }
    public String formatTimestamp(LocalDateTime timestamp) {
        Locale locale =  LocaleContextHolder.getLocale() ;

        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(locale);

        return timestamp.format(formatter);
    }


    public String formatTimestampWithZone(ZonedDateTime timestamp, String zoneId) {
        Locale locale =  LocaleContextHolder.getLocale() ;

        ZoneId zone = ZoneId.of(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(LocaleContextHolder.getLocale())
                .withZone(zone);

        return timestamp.format(formatter);
    }
    @GetMapping("/myTime") 
    public String  myTime(HttpServletRequest httpRequestHandler) {
        Locale locale =  LocaleContextHolder.getLocale() ;

        System.out.println(httpRequestHandler.getRequestURI());
        System.out.println(locale.getLanguage(  ) + " |||" + locale.getCountry(  ) + " ||| " +
                locale.getDisplayCountry(  ) + " ||| " + locale.getDisplayLanguage(  ) + "  |||" + locale.getDisplayName(  )
                + "  |||" + locale.getISO3Country(  ) + "  |||" + locale.getISO3Language(  ) + " ||| " + locale.getVariant(   )  );
        String timezone = localeToTimezoneMap.getOrDefault(locale, "UTC"); // Default to UTC if mapping not found
        System.out.println(httpRequestHandler.getHeader("Accept-Language"));
        ZonedDateTime now = ZonedDateTime.now() ;
        //LocalDateTime now = LocalDateTime.now() ;
        return formatTimestampWithZone(now , timezone) ;
    }

    public static void main(String[] args) {
        SpringApplication.run(DevApplication.class, args);
    }

}
