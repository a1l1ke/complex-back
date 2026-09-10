package org.example.complexback.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.complexback.domain.Pokemon;
import org.example.complexback.domain.PokemonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PokemonRepositoryImpl implements PokemonRepository {
    private final PokenJpaRepository jpaRepository;

    @Override
    public Pokemon save(Pokemon pokemon) {
        log.debug("포켓몬 저장 {}", pokemon);
        return jpaRepository.save(PokemonJpaEntity.from(pokemon)).to();
    }

    @Override
    public List<Pokemon> findAll() {
        log.debug("포켓몬 전체 조회");
        return jpaRepository.findAll()
                .stream().map(PokemonJpaEntity::to).toList();
    }
}
