import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class Forms extends AbstractUtil {
    @Override
    public void launch() {
        $($$(".element-group").get(1)).$("#item-0").shouldBe(Condition.visible).click();
    }
}
