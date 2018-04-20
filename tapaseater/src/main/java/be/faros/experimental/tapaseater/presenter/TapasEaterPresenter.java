package be.faros.experimental.tapaseater.presenter;

import be.faros.experimental.tapaseater.gateway.dto.Tapas;
import be.faros.experimental.tapaseater.gateway.dto.TapasOrder;
import java.math.BigDecimal;
import java.util.List;

public interface TapasEaterPresenter {

  List<Tapas> listAvailableTapas();

  void createNewBasket();

  boolean basketIsSelected();

  List<TapasOrder> retrieveListOfAllTapasOrdersInBasket();

  void addNewTapasOrderToBasket(String tapasId, int amount);

  BigDecimal calculateCostForBasket();

}
