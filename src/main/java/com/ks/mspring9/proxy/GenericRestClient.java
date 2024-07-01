package com.ks.mspring9.proxy;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.function.Consumer;

@Component
public class GenericRestClient {

    public <K, T> K post(RestClient restClient, String url, T request, Class<K> clazz, Consumer<HttpHeaders> consumer) {
        K response;
        try {
            response = restClient.post().uri(url)
                    .body(BodyInserters.fromValue(request))
                    .headers(consumer)
                    .header("Authorization", "Bearer auth-token")
                    .header("User-Agent", "Web")
                    .retrieve()
                    .body(clazz);
                  //  .bodyToMono(clazz)
              //      .block();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
/*
	public <K, T> K get(WebClient webClient, String url, T request, Class<K> clazz) {
		K response;
		try {
			response = webClient.get().uri(url)
					.body(BodyInserters.fromValue(request))
					.retrieve().bodyToMono(clazz).block();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public <K, T> K put(WebClient webClient, String url, T request, Class<K> clazz) {
		K response;
		try {
			response = webClient.put().uri(url)
					.body(BodyInserters.fromValue(request))
					.retrieve().bodyToMono(clazz).block();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public <K, T> K delete(WebClient webClient, String url, T request, Class<K> clazz) {
		K response;
		try {
			response = webClient.delete().uri(url)
					.body(BodyInserters.fromValue(request))
					.retrieve().bodyToMono(clazz).block();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}
 */
}
