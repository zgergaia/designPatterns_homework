import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Homepage extends AbstractUtil {
    @Override
    public void launch() {
        $($$(By.xpath("//div[@class='card mt-4 top-card']")).get(1)).shouldBe(Condition.visible)
                .scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}").click();
    }
}
