package dev.lefteris.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bosses")
public class BossController {

    @Autowired
    private BossService bossService;

    // Get a list of all bosses
    @GetMapping
    public ResponseEntity<List<Boss>> getAllBosses() {
        return ResponseEntity.ok(bossService.findAllBosses());
    }

    // Get a single boss by name
    @GetMapping("/{name}")
    public ResponseEntity<Boss> getBossByName(@PathVariable String name) {
        return bossService.findBossByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new boss
    @PostMapping
    public ResponseEntity<Boss> createBoss(@RequestBody Boss boss) {
        return ResponseEntity.ok(bossService.createBoss(boss));
    }

//     Update an existing boss
    @PutMapping("/{name}")
    public ResponseEntity<Boss> updateBoss(@PathVariable String name, @RequestBody Boss boss) {
        return bossService.updateBoss(name, boss)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//     Delete a boss
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteBoss(@PathVariable String name) {
        bossService.deleteBoss(name);
        return ResponseEntity.ok().build();
    }
}