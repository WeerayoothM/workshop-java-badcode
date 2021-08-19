package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({
            "0 , 500",
            "1 , 500",
            "2 , 250",
            "5 , 100",
            "8 , 50",
            "9 , 50",
            "10, 0"
    })
    public void getFeeWithDataTable(int experience, int expectedFee) {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        assertEquals(expectedFee,registerBusiness.getFee(experience));
    }

}