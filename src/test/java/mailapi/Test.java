package mailapi;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;

import com.leetech.apis.mailapi.mail.MailSentEvent;
import com.leetech.apis.mailapi.mail.SendMailCommand;
import com.leetech.apis.mailapi.rest.MailItem;

 
public class Test {
	private FixtureConfiguration fixture;

	@Before
	public void before() {
		fixture = new AggregateTestFixture(MailItem.class);

	}

	@org.junit.Test
	public void test() {
		fixture.givenNoPriorActivity()
		.when(new SendMailCommand("body", "lee"))
		.expectEvents(new MailSentEvent(""));
	}

}
