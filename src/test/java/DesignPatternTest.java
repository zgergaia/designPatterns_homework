import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

public class DesignPatternTest {
    @DataProvider (name = "zuras-data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"Michael", "Scott", "Male", "8003786542"},
                {"Lara", "Croft", "Female", "8015370310"}
        };
    }

    @Test (dataProvider = "zuras-data-provider")
    public void test1(String firstname, String lastname, String gender, String mobileNo) {
        open("https://demoqa.com/");
        new Homepage();
        new Forms();
        new Registration(firstname, lastname, gender, mobileNo);
    }
}