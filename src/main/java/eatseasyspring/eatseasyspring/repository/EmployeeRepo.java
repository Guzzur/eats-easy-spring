package eatseasyspring.eatseasyspring.repository;

        import eatseasyspring.eatseasyspring.model.Employee;
        import eatseasyspring.eatseasyspring.model.Restaurant;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.*;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
        Employee findEmployeeByUserId(int userId);
}
