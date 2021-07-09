package be.abc.bank.transaction.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import be.abc.bank.transaction.foundation.ApplicationUtil;


@Entity(name = "transactiondetails")
@Table(name = "ABC_BANK_TRANSACTION_DETAILS")
public class TransactionEntity {

	@Id
	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "account_number")
	private String accountId;

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name = "transaction_timestamp")
	private Timestamp transactionTimestamp;

	@Column(name = "amount")
	private long amount;



	/**
	 * @return the transactionTimestamp
	 */
	public Timestamp getTransactionTimestamp() {
		return transactionTimestamp;
	}

	/**
	 * @param transactionTimestamp the transactionTimestamp to set
	 */
	public void setTransactionTimestamp(Timestamp transactionTimestamp) {

			this.transactionTimestamp = transactionTimestamp;
	}

	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(long amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
}
