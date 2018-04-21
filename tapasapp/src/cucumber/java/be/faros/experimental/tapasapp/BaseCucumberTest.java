package be.faros.experimental.tapasapp;

import static org.junit.Assert.fail;

import be.faros.experimental.tapasapp.catalogue.domain.usecases.CatalogueSearching;
import be.faros.experimental.tapasapp.store.domain.usecases.UserBasketManagement;
import be.faros.experimental.tapasapp.system.TestDatabaseManager;
import java.sql.SQLException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration // Magic. Don't ask :-)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@DirtiesContext
public class BaseCucumberTest {

  @Autowired
  protected CatalogueSearching catalogueSearching;
  @Autowired
  protected UserBasketManagement userBasketManagement;

  @Autowired
  protected TestDatabaseManager databaseManager;

  protected void clearDatabase() {
    try {
      databaseManager.clearDatabase();
    } catch (SQLException e) {
      fail();
    }
  }
}


