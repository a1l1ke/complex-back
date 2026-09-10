package org.example.complexback.domain;

import java.util.List;

public interface PokemonRepository {
    Pokemon save(Pokemon pokemon);
    List<Pokemon> findAll();
}
