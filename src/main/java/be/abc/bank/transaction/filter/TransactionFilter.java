package be.abc.bank.transaction.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import be.abc.bank.transaction.foundation.TransactionConstants;


/**
 * Filter class for account service can be interrupted to validate the header
 * and exception handling
 * 
 * @author Renjith
 *
 */
public class TransactionFilter extends OncePerRequestFilter {

	private static final String REQUEST_ID = "Request-id";
	private static final String RESPONSE_ID = "Response-id";
	private static final String API_VERSION = "Api-version";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (StringUtils.isNotBlank(request.getHeader(REQUEST_ID))) {
			response.setHeader(RESPONSE_ID, request.getHeader(REQUEST_ID));
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, TransactionConstants.INVALID_INPUT_HEADERS);
		}

		if (!request.getHeader(API_VERSION).equals("1.0.0")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, TransactionConstants.INVALID_INPUT_HEADERS);
		}

		filterChain.doFilter(request, response);
	}

}
