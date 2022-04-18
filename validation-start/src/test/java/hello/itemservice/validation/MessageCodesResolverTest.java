package hello.itemservice.validation;

import com.sun.jdi.Field;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.FieldError;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageCodesResolverTest {
    MessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();

    @Test
    void MessageCodesResolverObject() {
        String[] messageCodes = messageCodesResolver.resolveMessageCodes("required", "item");

        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] messageCodes = messageCodesResolver.resolveMessageCodes("required", "item","itemName", String.class);

        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required");
    }
}
