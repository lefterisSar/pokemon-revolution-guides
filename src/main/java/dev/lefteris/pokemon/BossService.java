package dev.lefteris.pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BossService {

    @Autowired
    private BossRepository repository;

    public List<Boss> findAllBosses(){
        return repository.findAll();
    }
    public Optional<Boss> findBossByName(String name){
        return repository.findByName(name);
    }


    public Boss createBoss(Boss boss) {
        // You can include any additional business logic here.
        // For example, you might want to validate the boss object or set some defaults.

        return repository.save(boss);
    }

    public void deleteBoss(String name) {
        // You can add additional logic here, for instance, to check if the boss exists.
        repository.findByName(name).ifPresent(boss -> {
            repository.delete(boss);
        });
    }

    public Optional<Boss> updateBoss(String name, Boss updatedBoss) {
        Optional<Boss> existingBoss = repository.findByName(name);
        if (existingBoss.isPresent()) {
            Boss boss = existingBoss.get();

            // Update the properties of the existing boss with the properties of the updated boss
            boss.setRegion(updatedBoss.getRegion());
            boss.setLocation(updatedBoss.getLocation());
            boss.setCooldown(updatedBoss.getCooldown());
            boss.setLineup(updatedBoss.getLineup());
            boss.setRewards(updatedBoss.getRewards());
            // ... set any other fields that can be updated ...

            Boss savedBoss = repository.save(boss);
            return Optional.of(savedBoss);
        }

        // If the boss doesn't exist, return an empty Optional
        return Optional.empty();
    }

}