
package eatseasyspring.eatseasyspring.repository;

        import java.util.*;

        import eatseasyspring.eatseasyspring.model.CreditCard;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCard, Integer> {
}
