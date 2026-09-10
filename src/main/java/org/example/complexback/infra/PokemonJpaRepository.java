package org.example.complexback.infra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonJpaRepository extends JpaRepository<PokemonJpaEntity, Long> {
}
