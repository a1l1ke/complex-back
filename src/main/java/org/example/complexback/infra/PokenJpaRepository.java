package org.example.complexback.infra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokenJpaRepository extends JpaRepository<PokemonJpaEntity, Long> {
}
