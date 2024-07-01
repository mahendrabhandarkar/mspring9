package com.ks.mspring9.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BaseService {

    public RestClient webClient = null;

    protected void setWebClient(String baseAddressUrl) {
        webClient = RestClient.builder().baseUrl(baseAddressUrl)
                .defaultHeaders(httpHeaders -> {})
        //        .defaultCookie("cookie-name", "cookie-value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
           /*     .filter(exchangeFilterFunctions -> {
                    exchangeFilterFunctions.add(logRequest());
                    exchangeFilterFunctions.add(logResponse());
                })
             */   .build();
    }
/*
    ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            if(log.isDebugEnabled()) {
                StringBuilder sb = new StringBuilder("Request: \n");
                // append clientRequest method and url
                clientRequest.headers()
                        .forEach((name, values) -> values.forEach(value ->

                        ));
            }
            return Mono.just(clientRequest);
        });
    }
    */
}
