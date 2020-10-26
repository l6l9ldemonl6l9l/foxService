package distributedsystems.foxService.services.Service;

import distributedsystems.foxService.services.models.Fox;
import distributedsystems.foxService.services.repository.FoxRepository;
import distributedsystems.foxService.services.IService.FoxIService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FoxService implements FoxIService {
    @Autowired
    private FoxRepository repository;

    @Override
    public List<Fox> findAll() {
        return (List<Fox>) repository.findAll();
    }

    @Override
    public Fox save(Fox FoxForSave) {
        return repository.save(FoxForSave);
    }

    @Override
    public Fox getById(UUID id) throws NotFoundException {
        Optional<Fox> tempFox = repository.findById(id);
        if (tempFox.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Fox with id %s does not exist", id));
    }

    @Override
    public void deleteById(UUID id) throws NotFoundException {
        repository.delete(getById(id));
    }
}