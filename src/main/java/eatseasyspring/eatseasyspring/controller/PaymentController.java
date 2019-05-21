
package eatseasyspring.eatseasyspring.controller;

import eatseasyspring.eatseasyspring.model.Payment;
import eatseasyspring.eatseasyspring.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class PaymentController {
    @Autowired
    private PaymentRepo paymentRepo;

    // GET routes
    @GetMapping(value = "payments")
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    // POST routes
    @PostMapping(value = "payments")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentRepo.save(payment);
    }

    // PUT routes
    @PutMapping(value = "payments/{paymentId}")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable int paymentId) {
        Optional<Payment> paymentOptional = paymentRepo.findById(paymentId);

        if(!paymentOptional.isPresent())
            return ResponseEntity.notFound().build();

        payment.setPaymentId(paymentId);
        paymentRepo.save(payment);

        return ResponseEntity.ok(payment);
    }

    // DELETE routes
    @DeleteMapping(value = "payments/{paymentId}")
    public void deletePayment(@PathVariable int paymentId) {
        paymentRepo.deleteById(paymentId);
    }


}