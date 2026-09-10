package org.example.complexback.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.complexback.domain.Pokemon;
import org.example.complexback.domain.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class PokemonService {
    final private PokemonRepository pokemonRepository;

    @Transactional
    public Pokemon save(Pokemon pokemon) {
        log.debug("포켓몬 저장 {}", pokemon);
        return pokemonRepository.save(pokemon);
    }

    public List<Pokemon> findAll() {
        log.debug("포켓몬 전체 조회");
        return pokemonRepository.findAll();
    }
}
