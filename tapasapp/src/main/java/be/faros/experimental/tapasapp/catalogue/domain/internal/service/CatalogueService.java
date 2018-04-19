package be.faros.experimental.tapasapp.catalogue.domain.internal.service;

import be.faros.experimental.tapasapp.catalogue.domain.usecases.dto.Tapas;
import java.util.List;

public interface CatalogueService {

  List<Tapas> getAllTapas();

  Tapas getTapas(String tapasId);

}
