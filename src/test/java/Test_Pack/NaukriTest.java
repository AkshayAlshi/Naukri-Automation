package Test_Pack;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NaukriTest {

    @Test
    public void naukriAutomate() {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(500)
            );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://www.naukri.com/nlogin/login");

            page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName("Enter Email ID / Username"))
                    .fill("AkshayAlshi10@gmail.com");

            page.getByRole(AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions().setName("Enter Password"))
                    .fill("77887");

            page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Login").setExact(true))
                    .click();

            page.locator(".nI-gNb-drawer__bars").click();
            page.getByRole(AriaRole.LINK,
                    new Page.GetByRoleOptions().setName("View & Update Profile"))
                    .click();

            page.locator("#lazyResumeHead").getByText("editOneTheme").click();
            page.locator("#resumeHeadlineTxt")
                    .fill("Sr. QA Engineer (3 yrs) | Automation Testing with Selenium WebDriver + Java | API Testing (Rest Assured) | TestNG, Maven, Jenkins (CI/CD) | Manual + Database Testing | Strong in SDLC, STLC, Agile | SDET.");
            page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Save"))
                    .click();



             page.locator("#lazyResumeHead").getByText("editOneTheme").click();
            page.locator("#resumeHeadlineTxt")
                    .fill("Sr. QA Engineer (3 yrs) | Automation Testing with Selenium WebDriver + Java | API Testing (Rest Assured) | TestNG, Maven, Jenkins (CI/CD) | Manual + Database Testing | Strong in SDLC, STLC, Agile | SDET");
            page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Save"))
                    .click();

            
            System.out.println("********** Resume updated successfully ********");

            page.locator(".nI-gNb-drawer__bars").click();
            page.getByText("Logout").click();
        }
    }
}
