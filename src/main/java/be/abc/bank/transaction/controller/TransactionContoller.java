/**
 * 
 */
package be.abc.bank.transaction.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import be.abc.bank.transaction.foundation.TransactionConstants;
import be.abc.bank.transaction.management.ITransactionManagement;
import be.abc.bank.transaction.transaction.v1.model.TransactionDetailsInfo;
import be.abc.bank.transaction.transaction.v1.model.TransactionRequestInfo;

/**
 * REST based Transaction controller that exposes the rest operations which takes the transaction input
 * message as request and sends back the response output as Json
 *
 * @author Renjith
 *
 */
@RestController
@RequestMapping("abc/transactions/v1")
public class TransactionContoller {

	private static final Logger LOGGER = Logger.getLogger(TransactionContoller.class);

	@Autowired
	private ITransactionManagement myManager;

	@PostMapping(path = "/createTransaction", consumes = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void createTransaction(@RequestBody TransactionRequestInfo aInput) {
		LOGGER.debug("Rest endpoint createTransaction() is called ..");
		try {

			myManager.createTransaction(aInput);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					TransactionConstants.INTERNAL_SERVER_ERROR, e);
		}
	}

	@GetMapping(path = "/getTransactionDetail/{accountIds}", consumes = "application/json", produces = "application/json")
	public TransactionDetailsInfo getTransactionDetail(@PathVariable("accountIds") List<String> accoundIds)

	{
		try {
			return myManager.getTransactionDetail(accoundIds);
		}
		catch (Exception e) {
			LOGGER.error(e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					TransactionConstants.INTERNAL_SERVER_ERROR, e);
		}
	}
}
