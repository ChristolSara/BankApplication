package loans.loans.repository;

import loans.loans.models.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends JpaRepository<Loans,Integer> {
    @Query("SELECT l  FROM Loans l WHERE l.customerId =:customerId ORDER BY startDt DESC")
    List<Loans> findAllByCustomerId(@Param("customerId") int customerId);
}
