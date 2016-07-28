package annotations;

/**
 * Created by aditya.dalal on 01/05/16.
 */

@TesterInfo(name = "aditya", created_at = "01/05/16")
public class CustomAnnotationTests {

    @CustomTest(groups = {"Stage"})
    public void test1() {
        throw new RuntimeException("This test will always execute and fail");
    }

    @CustomTest(enabled = false, groups = {"Prod"})
    public void test2() {
        System.out.println("This test wil not run");
    }

    @CustomTest(groups = {"Stage", "Prod"})
    public void test3() {
        System.out.println("This test passes");
    }
}
