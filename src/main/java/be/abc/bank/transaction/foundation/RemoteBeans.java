package be.abc.bank.transaction.foundation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class RemoteBeans {

}
