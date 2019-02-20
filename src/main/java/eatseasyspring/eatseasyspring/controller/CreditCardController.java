
package eatseasyspring.eatseasyspring.controller;

        import eatseasyspring.eatseasyspring.model.CreditCard;
        import eatseasyspring.eatseasyspring.repository.CreditCardRepo;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class CreditCardController {
    @Autowired
    private CreditCardRepo creditCardRepo;

    // GET routes
    @GetMapping(value = "creditcards")
    public List<CreditCard> getAllCreditCards() {
        return creditCardRepo.findAll();
    }

    // POST routes
    @PostMapping(value = "creditcards")
    public CreditCard addOrder(@RequestBody CreditCard creditCard) {
        return creditCardRepo.save(creditCard);
    }

    // PUT routes
    @PutMapping(value = "creditcards/{creditCardId}")
    public ResponseEntity<CreditCard> updateCreditCard(@RequestBody CreditCard creditCard, @PathVariable int creditCardId) {
        Optional<CreditCard> creditCardOptional = creditCardRepo.findById(creditCardId);

        if(!creditCardOptional.isPresent())
            return ResponseEntity.notFound().build();

        creditCard.setCardId(creditCardId);
        creditCardRepo.save(creditCard);

        return ResponseEntity.ok(creditCard);
    }

    // DELETE routes
    @DeleteMapping(value = "creditcards/{creditCardId}")
    public void deleteCreditCard(@PathVariable int creditCardId) {
        creditCardRepo.deleteById(creditCardId);
    }


}