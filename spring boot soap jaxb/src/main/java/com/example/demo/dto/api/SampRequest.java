package com.example.demo.dto.api;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record SampRequest(@NotNull String countryIso) {

}
