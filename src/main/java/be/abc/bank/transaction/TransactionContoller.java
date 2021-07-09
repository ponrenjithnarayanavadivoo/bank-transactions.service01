/**
 * 
 */
package be.abc.bank.transaction;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.abc.bank.transaction.foundation.TransactionConstant;
import be.abc.bank.transaction.management.ITransactionManagement;
import be.abc.bank.transaction.transaction.v1.ApiException;
import be.abc.bank.transaction.transaction.v1.model.TransactionDetailsInfo;
import be.abc.bank.transaction.transaction.v1.model.TransactionRequestInfo;

/**
 * REST controller that exposes the rest operations which takes the input message as request and sends back the response output as Json
 *
 * @author Renjith
 *
 */
@RestController
@RequestMapping("transaction/v1")
public class TransactionContoller {

	private static final Logger LOGGER = Logger.getLogger(TransactionContoller.class);

	@Autowired
	private ITransactionManagement myManager;

	@PostMapping(path = "/create-transaction", consumes = "application/json", produces = "application/json")
	public void createTransaction(@RequestBody TransactionRequestInfo aInput) throws ApiException {
		LOGGER.debug("Rest endpoint createTransaction() is called ..");
		try {

			myManager.createTransaction(aInput);
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error");
		}
	}

	@GetMapping(path = "/transaction-detail/{accountIds}", consumes = "application/json", produces = "application/json")
	public TransactionDetailsInfo getTransactionDetail(@PathVariable("accountIds") List<String> accoundIds) throws ApiException

	{
		try {
			return myManager.getTransactionDetail(accoundIds);
		}

		catch (Exception e) {
			throw new ApiException();
		}
	}
}
