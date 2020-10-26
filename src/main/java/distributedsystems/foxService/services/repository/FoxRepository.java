package distributedsystems.foxService.services.repository;

import distributedsystems.foxService.services.models.Fox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoxRepository extends CrudRepository <Fox, Long > {
    Optional<Fox> findById(UUID id);
}
