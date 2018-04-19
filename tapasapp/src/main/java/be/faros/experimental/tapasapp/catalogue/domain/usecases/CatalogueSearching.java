package be.faros.experimental.tapasapp.catalogue.domain.usecases;

import be.faros.experimental.tapasapp.catalogue.domain.usecases.dto.Tapas;
import java.util.List;

public interface CatalogueSearching {

  List<Tapas> getAllTapas();

  Tapas getTapas(String tapasId);
}
