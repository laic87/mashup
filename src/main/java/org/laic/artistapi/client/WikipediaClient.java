package org.laic.artistapi.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "widipedia", url = "https://en.wikipedia.org/w/api.php")
public interface WikipediaClient {

}
