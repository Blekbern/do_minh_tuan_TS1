package cv04;

import cz.cvut.fel.ts1.cv04.DBManager;
import cz.cvut.fel.ts1.cv04.Mail;
import cz.cvut.fel.ts1.cv04.MailHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockMailHelperTest {


    DBManager mockDBManager = Mockito.mock( DBManager.class );
    MailHelper mailHelper = new MailHelper( mockDBManager );

    @Test
    public void positiveVerifySendMailOnce() {
        mailHelper.sendMail( Mockito.anyInt() );
        Mockito.verify( mockDBManager, Mockito.times( 1 ) ).findMail( Mockito.anyInt() );
    }

    @Test
    public void negativeVerifySendMainTwice() {
        mailHelper.sendMail( 10 );
        Mockito.verify(mockDBManager, Mockito.times(2)).findMail(10);
    }

    @Test
    public void mockTest() {
        int mailId = 1;
        mailHelper.setMail("MockedTo", "MockedSubject", "MockedBody" );
        Mail mail = mailHelper.getMail();
        Mockito.when( mockDBManager.findMail(mailId)).thenReturn(mail);
        mailHelper.sendMail(mailId);
        System.out.println( mailHelper.getMail().getBody() );
        Mockito.verify(mockDBManager).findMail(mailId);
    }
}
