package be.faros.experimental.tapasapp.store.domain.usecases;

import be.faros.experimental.tapasapp.store.domain.usecases.dto.TapasOrder;
import java.math.BigDecimal;
import java.util.List;

public interface UserBasketManagement {

  int createNewBasket();

  List<TapasOrder> retrieveListOfAllTapasOrdersInBasket(int basketId);

  void addNewTapasOrderToBasket(int basketId, TapasOrder tapasOrder);

  BigDecimal calculateCostForBasket(int basketId);

}
