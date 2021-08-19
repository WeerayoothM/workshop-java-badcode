package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    @Test
    @DisplayName("Firstname ของ speaker มีค่าเป็น null จึงเกิด exception ขึ้นมา")
    public void case01 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();

        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, new Speaker()));
        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Lastname ของ speaker มีค่าเป็น null จึงเกิด exception ขึ้นมา")
    public void case02 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Weerayooth");

        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker));
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Email ของ speaker มีค่าเป็น null จึงเกิด exception ขึ้นมา")
    public void case03 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Weerayooth");
        speaker.setLastName("Manawanich");

        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker));
        assertEquals("Email is required.", exception.getMessage());
    }
}