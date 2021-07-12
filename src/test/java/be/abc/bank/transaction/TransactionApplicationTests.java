package be.abc.bank.transaction;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.abc.bank.transaction.transaction.v1.model.TransactionRequestInfo;

/**
 * Integration Test for Account Services
 * 
 * @author Renjith
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TransactionApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void createTransaction_whenTransactionRequestInfo_thenStatus204() throws Exception {

		TransactionRequestInfo aTransRequestInfo = prepareCreateTransaction();

		mvc.perform(post("http://localhost:9083/abc/transactions/v1/createTransaction").header("Request-id", "1")
				.header("version", "1.0.0").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(aTransRequestInfo))).andExpect(status().isNoContent());
	}

	@Test
	public void givenAccount_whenGetAccountList_thenStatus200() throws Exception {

		TransactionRequestInfo aTransRequestInfo = prepareCreateTransaction();
		aTransRequestInfo.setAccountNumber((long) 134578);
		mvc.perform(post("http://localhost:9083/abc/transactions/v1/createTransaction").header("Request-id", "1")
				.header("version", "1.0.0").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(aTransRequestInfo))).andExpect(status().isNoContent());

		mvc.perform(get("http://localhost:8082/abc/transactions/v1/getTransactionDetail/134578").header("Request-id", "1")
				.header("version", "1.0.0").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	private TransactionRequestInfo prepareCreateTransaction() {
		
		TransactionRequestInfo aCustomerRequestInfo = new TransactionRequestInfo();
		aCustomerRequestInfo.setAccountNumber((long) 1234567);
		aCustomerRequestInfo.setAmount((long) 7654310);
		return aCustomerRequestInfo;
	}

}
