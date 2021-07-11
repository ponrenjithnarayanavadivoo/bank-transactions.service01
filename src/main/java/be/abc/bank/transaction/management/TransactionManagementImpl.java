package be.abc.bank.transaction.management;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.abc.bank.transaction.entity.TransactionEntity;
import be.abc.bank.transaction.foundation.ApplicationUtil;
import be.abc.bank.transaction.repository.ITransactionService;
import be.abc.bank.transaction.transaction.v1.model.TransactionDetail;
import be.abc.bank.transaction.transaction.v1.model.TransactionDetailsInfo;
import be.abc.bank.transaction.transaction.v1.model.TransactionRequestInfo;

/**
 * Manager service supervise the transaction service operations or communications.
 * It is used to create the business logic and communicating with other sub ordinate services.
 *
 * @author Renjith
 *
 */
@Component
public class TransactionManagementImpl implements ITransactionManagement {

	@Autowired
	private ITransactionService myTransactionService;

	/**
	 * create a new transaction for accounts
	 * @param anInput CustomerRequestInfo
	 * @return String
	 */
	@Override
	public void createTransaction(TransactionRequestInfo anInput) {
		
		TransactionEntity aTransactionEntity = new TransactionEntity();
		aTransactionEntity.setAccountId(""+anInput.getAccountNumber());
		aTransactionEntity.setAmount(anInput.getAmount());
		aTransactionEntity.setTransactionTimestamp(ApplicationUtil.currentTimeStamp());
		aTransactionEntity.setTransactionId(ApplicationUtil.getTransNumber());
		myTransactionService.createTransaction(aTransactionEntity);
	}
	
	/**
	 * Get transaction detail from transaction table
	 * @param anInput CustomerRequestInfo
	 * @return String
	 */
	@Override
	public TransactionDetailsInfo getTransactionDetail(List<String> accountIds) {
		
		List<TransactionEntity> theTransactionEntities=myTransactionService.getTransactionDetailsById(accountIds);
		List<TransactionDetail> theTransactionDetails = theTransactionEntities.stream().map(theTransactionalEntity-> {
			TransactionDetail aTransactionDetail =new TransactionDetail();
			aTransactionDetail.setTransactionTimestamp(theTransactionalEntity.getTransactionTimestamp().toString());
			aTransactionDetail.setAccountNumber(String.valueOf(theTransactionalEntity.getAccountId()));
			aTransactionDetail.setAmount(theTransactionalEntity.getAmount());
			aTransactionDetail.setTransactionId(String.valueOf(theTransactionalEntity.getTransactionId()));
			return aTransactionDetail;
		}).collect(Collectors.toList());
		TransactionDetailsInfo aTransactionDetailsInfo =new TransactionDetailsInfo();
		aTransactionDetailsInfo.setTransactionDetails(theTransactionDetails);

		return aTransactionDetailsInfo;
	}
}