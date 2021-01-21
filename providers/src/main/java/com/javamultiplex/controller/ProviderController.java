package com.javamultiplex.controller;

import com.javamultiplex.model.Provider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Rohit Agarwal on 21/01/21 7:22 pm
 * @copyright www.javamultiplex.com
 */
@RestController
@RequestMapping("/providers")
public class ProviderController {

    private List<Provider> providers= Stream.of(
            new Provider(1, "Provider1"),
            new Provider(2, "Provider2")
    ).collect(Collectors.toList());

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProvider(@PathVariable int id){
        Optional<Provider> optionalProvider = providers
                .stream()
                .filter(provider -> provider.getId() == id)
                .findFirst();
        return optionalProvider.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
