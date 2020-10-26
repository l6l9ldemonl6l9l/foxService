package distributedsystems.foxService.api.restControllers;

import distributedsystems.foxService.api.payload.FoxPayload;
import distributedsystems.foxService.services.models.Fox;
import distributedsystems.foxService.services.IService.FoxIService;
import distributedsystems.foxService.FoxApplication;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fox")
@RequiredArgsConstructor
public final class FoxController {
    static final Logger log = LoggerFactory.getLogger(FoxApplication.class);

    @Autowired
    private FoxIService FoxService;

    @GetMapping
    public ResponseEntity<List<Fox>> index() {
        return ResponseEntity.ok(FoxService.findAll());
    }

    @PostMapping
    public ResponseEntity<Fox> create(@RequestBody FoxPayload payload) {
        Fox newFox = new Fox(payload.getName(),
                payload.getLastLunchTime(),payload.getEnergy(),
                payload.getSizeCunning());
        return ResponseEntity.ok(FoxService.save(newFox));
    }

    @GetMapping("{FoxId}")
    public ResponseEntity<Fox> show(@PathVariable UUID FoxId) throws NotFoundException {
        return ResponseEntity.ok(FoxService.getById(FoxId));
    }

    @DeleteMapping("{FoxId}")
    public ResponseEntity<Void> delete(@PathVariable UUID FoxId) throws NotFoundException {
        FoxService.deleteById(FoxId);
        return ResponseEntity.noContent().build();
    }
}