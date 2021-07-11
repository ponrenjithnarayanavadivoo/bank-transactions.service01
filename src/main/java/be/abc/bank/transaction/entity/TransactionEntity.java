package be.abc.bank.transaction.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for transaction table
 * 
 * @author Renjith
 *
 */

@Entity(name = "transactiondetails")
@Table(name = "ABC_BANK_TRANSACTION_DETAILS")
public class TransactionEntity implements Serializable{

	private static final long serialVersionUID = 922675883775507927L;

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
	 * TransactionEntity constructor
	 */
	public TransactionEntity() {
		super();
	}

	/**
	 * TransactionEntity
	 * 
	 * @param transactionId String
	 * @param accountId String
	 * @param transactionTimestamp Timestamp
	 * @param amount long
	 */
	public TransactionEntity(String transactionId, String accountId, Timestamp transactionTimestamp, long amount) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.transactionTimestamp = transactionTimestamp;
		this.amount = amount;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result + ((transactionTimestamp == null) ? 0 : transactionTimestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionEntity other = (TransactionEntity) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (amount != other.amount)
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		if (transactionTimestamp == null) {
			if (other.transactionTimestamp != null)
				return false;
		} else if (!transactionTimestamp.equals(other.transactionTimestamp))
			return false;
		return true;
	}

}
