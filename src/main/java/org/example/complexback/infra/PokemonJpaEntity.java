package org.example.complexback.infra;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.example.complexback.domain.Pokemon;

import java.util.UUID;

@Table(name = "pokemons")
@Entity
// ---
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class PokemonJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Builder.Default
    private UUID uuid = UUID.randomUUID();
    private String name;
    private int level;

    // from
    public static PokemonJpaEntity from(Pokemon pokemon) {
        return PokemonJpaEntity.builder()
                .name(pokemon.name())
                .level(pokemon.level())
                .build();
    }

    // to
    public Pokemon to() {
        return new Pokemon(name, level);
    }
}
