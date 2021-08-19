package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFeeTest {

    @Test
    void getFee() {
    }

    @Test
    @DisplayName("คำนวณค่า fee จากประสบการณ์ทำงาน")
    public void case02 (){
        RegisterBusiness registerBusiness = new RegisterBusiness();

        assertEquals(500,registerBusiness.getFee(1));
        assertEquals(250,registerBusiness.getFee(3));
        assertEquals(100,registerBusiness.getFee(5));
        assertEquals(50,registerBusiness.getFee(9));
        assertEquals(0,registerBusiness.getFee(10));
    }

}