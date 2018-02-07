//package mailapi;
//
//import org.axonframework.test.aggregate.AggregateTestFixture;
//import org.axonframework.test.aggregate.FixtureConfiguration;
//import org.junit.Before;
//
//import com.leetech.apis.mailapi.mail.Mail;
//import com.leetech.apis.mailapi.mail.MailSentEvent;
//import com.leetech.apis.mailapi.mail.SendMailCommand;
//
//public class Test {
//
//	private FixtureConfiguration<Mail> fixture;
//
//	@Before
//	public void setUp() throws Exception {
//		fixture = new AggregateTestFixture<Mail>(Mail.class);
//	}
//
//	@org.junit.Test
//	public void test() {
//		fixture.givenNoPriorActivity().when(new SendMailCommand("mail subject", "Message Body", "lee"))
//				.expectEvents(new MailSentEvent("mail subject", "lee"));
//	}
//
//}
