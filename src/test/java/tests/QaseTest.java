package tests;

import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import lombok.Builder;
import models.Project;
import models.TestSuite;
import org.testng.annotations.Test;

@Builder
public class QaseTest {

    @Test
    public void test() {
        Project project = Project.builder()
                .title("Viktoryia")
                .access("all")
                .code("Vik")
                .group(null)
                .description("Viktoryia's project")
                .build();
        new ProjectsAdapter().create(project);
    }

    @Test
    public void suite() {
        TestSuite suite = TestSuite.builder()
                .title("Title")
                .description("Omn")
                .preconditions("Description")
                .build();

        int id = new SuiteAdapter().create("VIK", suite);
        new SuiteAdapter().delete("VIK", id);
    }
}
