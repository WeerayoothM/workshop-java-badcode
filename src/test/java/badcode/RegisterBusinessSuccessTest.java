package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterBusinessSuccessTest {

    // Success case
    @Test
    @DisplayName("save speaker ได้")
    public void case07 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Weerayooth");
        speaker.setLastName("Manawanich");
        speaker.setEmail("test@gmail.com");

        // DAO = Data Access Object
        // DTO = Data Transfer Object
        // BO = Business Object
        // VO = Value Object
        SpeakerRepository speakerRepository = (_speaker) -> 1;
        int speakerId = registerBusiness.register(speakerRepository, speaker);

        assertEquals(1,speakerId);

    }

    @Test
    @DisplayName("test get Fee method")
    public void case08 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();
        int fee = registerBusiness.getFee(5);
        assertEquals(100,fee);
    }

}