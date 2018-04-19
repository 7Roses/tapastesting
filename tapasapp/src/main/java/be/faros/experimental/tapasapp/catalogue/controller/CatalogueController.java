package be.faros.experimental.tapasapp.catalogue.controller;

import be.faros.experimental.tapasapp.catalogue.domain.usecases.CatalogueSearching;
import be.faros.experimental.tapasapp.catalogue.domain.usecases.dto.Tapas;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogueController {

  private final CatalogueSearching catalogueSearching;

  public CatalogueController(CatalogueSearching catalogueSearching) {
    this.catalogueSearching = catalogueSearching;
  }

  @RequestMapping("/tapas")
  public List<Tapas> findAllTapas() {
    return catalogueSearching.getAllTapas();
  }

}
