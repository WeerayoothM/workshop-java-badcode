package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessFailureTest {

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

    @Test
    @DisplayName("Email ของ speaker มีรูปแบบ ไม่ถูกต้อง จึงเกิด exception ขึ้นมา")
    public void case04 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Weerayooth");
        speaker.setLastName("Manawanich");
        speaker.setEmail("test@test.com");

        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () ->
                registerBusiness.register(null, speaker));
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    @DisplayName("Email ของ speaker มี @ เกินมา จึงเกิด exception ขึ้นมา")
    public void case05 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Weerayooth");
        speaker.setLastName("Manawanich");
        speaker.setEmail("test@gmail.com@asg");

        Exception exception = assertThrows(DomainEmailInvalidException.class, () ->
                registerBusiness.register(null, speaker));
    }

    @Test
    @DisplayName("Email ของ speaker ไม่มี @ จึงเกิด exception ขึ้นมา")
    public void case051 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Weerayooth");
        speaker.setLastName("Manawanich");
        speaker.setEmail("test.gmail.com");

        Exception exception = assertThrows(DomainEmailInvalidException.class, () ->
                registerBusiness.register(null, speaker));
    }

    @Test
    @DisplayName("ไม่สามารถ save speaker ได้")
    public void case06 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Weerayooth");
        speaker.setLastName("Manawanich");
        speaker.setEmail("test@gmail.com");

        Exception exception = assertThrows(SaveSpeakerException.class, () ->
                registerBusiness.register(null, speaker));
    }

}