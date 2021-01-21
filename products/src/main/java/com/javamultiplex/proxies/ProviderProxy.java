package com.javamultiplex.proxies;

import com.javamultiplex.config.ClientConfiguration;
import com.javamultiplex.model.Provider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Rohit Agarwal on 21/01/21 7:31 pm
 * @copyright www.javamultiplex.com
 */
@FeignClient(name = "providers-service", url = "${provider.microservice.url}", configuration = {ClientConfiguration.class})
public interface ProviderProxy {

    @GetMapping("/providers/{id}")
    Provider getDetails(@PathVariable int id);
}
