package Test_Pack;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.testng.annotations.Test;
import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NaukriTest {

 @Test
    public void naukriAutomate() {
       try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setSlowMo(1000));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();


            page.navigate("https://www.naukri.com/nlogin/login");


            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).click();

            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).fill("AkshayAlshi10@gmail.com");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Password")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Password")).fill("Akshay@123");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login").setExact(true)).click();
            page.locator("//div[@class='nI-gNb-drawer__bars']").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View & Update Profile")).click();
            page.locator("#lazyResumeHead").getByText("editOneTheme").click();
            page.locator("#resumeHeadlineTxt").fill("Senior QA Engineer | SDET | Selenium WebDriver + Java | API Automation with Rest Assured | TestNG | Maven | Jenkins CI/CD | Manual & Database Testing | Automation Frameworks");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
//
           Locator crossBtn = page.locator("xpath=/html/body/div[6]/div[2]/div[1]/span");

           crossBtn.waitFor();
           crossBtn.click();



           page.locator("#lazyResumeHead").getByText("editOneTheme").click();
            page.locator("#resumeHeadlineTxt").fill("Senior QA Engineer | SDET | Selenium WebDriver + Java | API Automation with Rest Assured | TestNG | Maven | Jenkins CI/CD | Manual & Database Testing | Automation Frameworks.");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
            System.out.println("********** From Save successfully ********");
            page.waitForLoadState();
            page.locator("//div[@class='nI-gNb-drawer__bars']").click();
//           page.locator("/html/body/div[7]/div[5]/div[1]/span").click();
            page.getByText("Logout").click();
        }

    }
}

