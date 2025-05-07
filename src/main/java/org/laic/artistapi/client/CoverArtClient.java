package org.laic.artistapi.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "coverart", url = "http://coverartarchive.org")
public interface CoverArtClient {

}
