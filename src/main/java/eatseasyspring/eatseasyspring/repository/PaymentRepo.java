
package eatseasyspring.eatseasyspring.repository;

        import java.util.*;

        import eatseasyspring.eatseasyspring.model.Payment;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
