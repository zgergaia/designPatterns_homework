import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Registration extends AbstractUtil {
    public Registration(String firstname, String lastname, String gender, String mobileNo) {
        this.launch(firstname, lastname, gender, mobileNo);
    }

    public void launch(String firstname, String lastname, String gender, String mobileNo) {
        $("#firstName").shouldBe(Condition.visible).sendKeys(firstname);
        $("#lastName").shouldBe(Condition.visible).sendKeys(lastname);

        //.parent(), because selenium has a weird bug with checkboxes and radios.
        //More info: https://stackoverflow.com/questions/39349919/selenide-test-fails-to-interact-with-materials-checkbox
        //Also, "\'" isn't syntax error, but IntelliJ thinks it is.

        $(By.xpath("//input[@value=" + "\'" + gender + "\'" + "]")).parent().click();
        $("#userNumber").shouldBe(Condition.visible).sendKeys(mobileNo);
        $(By.xpath("//button[@id='submit']")).shouldBe(Condition.visible)
                .scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}").click();

        $(By.xpath("//div[text()='Thanks for submitting the form']")).shouldBe(Condition.visible);

        var studentTable = $$("table tbody tr").shouldBe(CollectionCondition.sizeGreaterThan(0));

        studentTable.get(0).lastChild().shouldHave(Condition.text(firstname + " " + lastname));
        studentTable.get(2).lastChild().shouldHave(Condition.text(gender));
        studentTable.get(3).lastChild().shouldHave(Condition.text(mobileNo));
    }
}
