/**
 * 
 */
package be.abc.bank.transaction.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.abc.bank.transaction.entity.TransactionEntity;

/**
 * Transaction service implementation between  DB and management class
 * 
 * @author Renjith
 */
@Service
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired
	private ITransactionServiceRepository myAccountRepository;

	@Override
	public List<TransactionEntity> getTransactionDetailsById(List<String> accountId) {
		return myAccountRepository.getAllRowsById(accountId);
	}

	@Override
	public void createTransaction(TransactionEntity t) {

		myAccountRepository.save(t);
	}
}
