import io.zonky.test.db.postgres.embedded.LiquibasePreparer;
import io.zonky.test.db.postgres.junit.EmbeddedPostgresRules;
import io.zonky.test.db.postgres.junit.PreparedDbRule;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class LiquibasePreparerTest {

    @Rule
    public PreparedDbRule db = EmbeddedPostgresRules.preparedDatabase(LiquibasePreparer.forClasspathLocation("master.xml"));

    @Test
    public void testTablesMade() throws Exception {
        try (Connection c = db.getTestDatabase().getConnection();
             Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery("SELECT * FROM foo");
            rs.next();
            assertEquals("bar", rs.getString(1));
        }
    }
}