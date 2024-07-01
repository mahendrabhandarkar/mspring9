package com.ks.mspring9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

@Configuration
public class LocaleSetting implements WebMvcConfigurer {

    public Locale IND;
    NumberFormat india;
    DecimalFormat decimalFormat;
    DecimalFormatSymbols decimalFormatSymbols;
    LocaleSetting() {
        IND = new Locale("en", "IN");
        india = NumberFormat.getCurrencyInstance(IND);
    //    Currency currency = Currency.getInstance("IN");
    //    india.setCurrency(currency);
        decimalFormat = new DecimalFormat("##,##,###.00"); // extra line
        decimalFormat = (DecimalFormat) decimalFormat.getCurrencyInstance(IND);
        decimalFormatSymbols = DecimalFormatSymbols.getInstance(IND);
        decimalFormatSymbols.setCurrencySymbol("\u20B9");
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        decimalFormat.setMaximumIntegerDigits(15);
        decimalFormat.setMinimumIntegerDigits(1);
      //  decimalFormat.applyLocalizedPattern("##,##,###.00");
        Double payment = 1012324.13;
        System.out.println(decimalFormat.format(payment));
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(IND);
        return sessionLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(localeChangeInterceptor());
    }
}
