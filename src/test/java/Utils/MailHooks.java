package Utils;


import Mail.EmailSender;
import io.cucumber.java.AfterAll;

public class MailHooks {

    @AfterAll
    public static void sendEmailAfterAllTests() {
        System.out.println("All tests finished. Sending report by email...");
        EmailSender.main(null); 
    }
}
