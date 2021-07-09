package be.abc.bank.transaction.repository;

import java.util.List;

import be.abc.bank.transaction.entity.TransactionEntity;

public interface ITransactionService {
	
	List<TransactionEntity> getTransactionDetailsById(List<String> accountId);

	void createTransaction(TransactionEntity t );


}
