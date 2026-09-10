package org.example.complexback.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.complexback.app.PokemonService;
import org.example.complexback.domain.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
// ---
@RequiredArgsConstructor
@Slf4j
public class PokemonController {
    private final PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<Pokemon> save(@Validated PokemonCreateDTO dto) {
        log.info("포켓몬 저장 {}", dto);
        Pokemon pokemon = pokemonService.save(dto.to());
        return ResponseEntity.status(HttpStatus.CREATED).body(pokemon);
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> findAll() {
        log.info("포켓몬 전체 조회");
        return ResponseEntity.ok(pokemonService.findAll());
    }
}
