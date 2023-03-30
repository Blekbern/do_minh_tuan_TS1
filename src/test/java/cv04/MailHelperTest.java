//import cz.cvut.fel.ts1.refactoring.MailHelper;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class MailHelperTest {
//
//    private String to;
//    private String subject;
//    private String body;
//    private MailHelper mailHelper = new MailHelper();
//
//
//    @BeforeEach
//    public void setMailData() {
//        to = "Reciever";
//        subject = "Subject of mail";
//        body = "Mail body";
//        mailHelper.setMail( to, subject, body );
//    }
//
//    @Test
//    public void setMail_toReturnsExpectedString_returnsTo() {
//        Assertions.assertEquals( to, mailHelper.getMail().getTo());
//    }
//
//    @Test
//    public void setMail_subjectReturnsExpectedString_returnsSubject() {
//        Assertions.assertEquals( subject, mailHelper.getMail().getSubject());
//    }
//
//    @Test
//    public void setMail_bodyReturnsExpectedString_returnsBody() {
//        Assertions.assertEquals( body, mailHelper.getMail().getBody());
//    }
//
//
//}
