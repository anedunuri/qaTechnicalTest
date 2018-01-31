package APItests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        tags = {"@PatchPlaylist"},
        features = "src/main/resources/features",
        glue = {"definitions"})
@RunWith(Cucumber.class)
public class FUpdatePlaylist {
}