package be.abc.bank.transaction.management;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import be.abc.bank.transaction.entity.TransactionEntity;
import be.abc.bank.transaction.repository.ITransactionService;
import be.abc.bank.transaction.transaction.v1.model.TransactionRequestInfo;

/**
 * Transaction Management Impl Unit testing 
 * @author Renjith
 *
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionManagementImplUnitTest {

	@Mock
	private ITransactionService myTransactionService;

	@InjectMocks
	private TransactionManagementImpl unitTest;

	/**
	 * create Transaction test method
	 */
	@Before
	public void initMocks() {
		unitTest = new TransactionManagementImpl();
		MockitoAnnotations.initMocks(this);
		myTransactionService = mock(ITransactionService.class);
	}

	/**
	 * Create Transaction Test
	 */
	@Test
	public void createTransactionTest() {
		TransactionRequestInfo trans = getTestInputCustomer();
		TransactionEntity t = new TransactionEntity();
		doNothing().when(myTransactionService).createTransaction(t);
		unitTest.createTransaction(trans);
	}

	private TransactionRequestInfo getTestInputCustomer() {
		TransactionRequestInfo trans = new TransactionRequestInfo();
		trans.accountNumber((long) 1234567);
		trans.setAmount((long) 100);
		return trans;
	}
}