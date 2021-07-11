/**
 * 
 */
package be.abc.bank.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.abc.bank.transaction.entity.TransactionEntity;


/**
 * Transaction Service Repository
 * @author Renjith
 *
 */
@Repository
public interface ITransactionServiceRepository extends JpaRepository<TransactionEntity, Long> {

	@Query("Select td from transactiondetails td where td.accountId in :accountIds")
	List<TransactionEntity> getAllRowsById (@Param("accountIds") List<String> personCountry);
}
