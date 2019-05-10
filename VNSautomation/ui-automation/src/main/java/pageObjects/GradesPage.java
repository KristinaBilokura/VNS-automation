package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.WaitConditions;
import java.util.LinkedList;
import static consts.Constants.Application.GRADES_PAGE_URL;
import static pageObjects.ProfilePage.listOfCourses;


public class GradesPage extends AbstractPage{

    By courses = By.xpath("//tbody//a");

    @Step("Get Grades page")
    public GradesPage getGradesPage() {
        getPage(GRADES_PAGE_URL);
        return this;
    }

    @Step("Verify page is reloaded")
    public void verifyUserCourseProfiles() {
        LinkedList<String> coursList = new LinkedList<>();
        for (int i = 0; i < getElements(courses, WaitConditions.PageElements.VISIBLE_S).size(); i++) {
            coursList.add(getElements(courses, WaitConditions.PageElements.VISIBLE_S).get(i).getText());
        }
        Assert.assertEquals(listOfCourses,coursList);
    }

}
