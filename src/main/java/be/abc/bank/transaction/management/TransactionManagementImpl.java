package be.abc.bank.transaction.management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.abc.bank.transaction.entity.TransactionEntity;
import be.abc.bank.transaction.foundation.ApplicationUtil;
import be.abc.bank.transaction.repository.ITransactionService;
import be.abc.bank.transaction.transaction.v1.model.TransactionDetail;
import be.abc.bank.transaction.transaction.v1.model.TransactionDetailsInfo;
import be.abc.bank.transaction.transaction.v1.model.TransactionRequestInfo;

@Component
public class TransactionManagementImpl implements ITransactionManagement {

	private static final Logger LOGGER = Logger.getLogger(TransactionManagementImpl.class);

	@Autowired
	ITransactionService myTransactionService;

	@Override
	public void createTransaction(TransactionRequestInfo anInput) {
		
		TransactionEntity aTransactionEntity = new TransactionEntity();
		aTransactionEntity.setAccountId(""+anInput.getAccountNumber());
		aTransactionEntity.setAmount(anInput.getAmount());
		aTransactionEntity.setTransactionTimestamp(ApplicationUtil.currentTimeStamp());
		aTransactionEntity.setTransactionId(ApplicationUtil.getTransNumber());
		myTransactionService.createTransaction(aTransactionEntity);
	}
	
	@Override
	public TransactionDetailsInfo getTransactionDetail(List<String> accountIds) {
		
		List<TransactionEntity> theTransactionEntities=myTransactionService.getTransactionDetailsById(accountIds);
		List<TransactionDetail> theTransactionDetails = theTransactionEntities.stream().map(theTransactionalEntity-> {
			TransactionDetail aTransactionDetail =new TransactionDetail();
			aTransactionDetail.setTransactionTimestamp(theTransactionalEntity.getTransactionTimestamp().toString());
			aTransactionDetail.setAccountNumber(""+theTransactionalEntity.getAccountId());
			aTransactionDetail.setAmount(theTransactionalEntity.getAmount());
			aTransactionDetail.setTransactionId(""+theTransactionalEntity.getTransactionId());
			return aTransactionDetail;
		}).collect(Collectors.toList());
		TransactionDetailsInfo aTransactionDetailsInfo =new TransactionDetailsInfo();
		aTransactionDetailsInfo.setTransactionDetails(theTransactionDetails);
		// TODO Auto-generated method stub
		return aTransactionDetailsInfo;
	}
}