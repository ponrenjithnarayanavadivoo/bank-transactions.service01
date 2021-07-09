package be.abc.bank.transaction.management;

import java.util.List;

import be.abc.bank.transaction.transaction.v1.model.TransactionDetailsInfo;
import be.abc.bank.transaction.transaction.v1.model.TransactionRequestInfo;

public interface ITransactionManagement {

	void createTransaction(TransactionRequestInfo anInput);
	
	TransactionDetailsInfo getTransactionDetail(List<String> accountId);
}
