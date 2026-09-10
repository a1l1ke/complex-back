package org.example.complexback.ui;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.example.complexback.domain.Pokemon;

public record PokemonCreateDTO(
        @NotBlank String name,
        @Positive @Max(100) int level
) {
    public Pokemon to() {
        return new Pokemon(name, level);
    }
}
