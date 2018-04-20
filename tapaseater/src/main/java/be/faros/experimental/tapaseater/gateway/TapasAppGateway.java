package be.faros.experimental.tapaseater.gateway;

import be.faros.experimental.tapaseater.gateway.dto.Tapas;
import be.faros.experimental.tapaseater.gateway.dto.TapasOrder;
import java.math.BigDecimal;
import java.util.List;

public interface TapasAppGateway {

  List<Tapas> getAvailableTapas();

  Integer createNewBasket();

  List<TapasOrder> retrieveListOfAllTapasOrdersInBasket(int basketId);

  void addNewTapasOrderToBasket(int basketId, String tapasId, int amount);

  BigDecimal calculateCostForBasket(int basketId);

}
