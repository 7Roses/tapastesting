package be.faros.experimental.tapasapp.store.domain.internal.usecases.impl;

import be.faros.experimental.tapasapp.catalogue.domain.usecases.CatalogueSearching;
import be.faros.experimental.tapasapp.catalogue.domain.usecases.dto.Tapas;
import be.faros.experimental.tapasapp.store.domain.internal.entity.BasketEntity;
import be.faros.experimental.tapasapp.store.domain.internal.entity.TapasOrderEntity;
import be.faros.experimental.tapasapp.store.domain.internal.mapper.TapasOrderMapper;
import be.faros.experimental.tapasapp.store.domain.internal.service.BasketService;
import be.faros.experimental.tapasapp.store.domain.usecases.UserBasketManagement;
import be.faros.experimental.tapasapp.store.domain.usecases.dto.TapasOrder;
import java.math.BigDecimal;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class UserBasketManagementImpl implements UserBasketManagement {

  private final BasketService basketService;
  private final TapasOrderMapper tapasOrderMapper = new TapasOrderMapper();
  private final CatalogueSearching catalogueSearching;

  public UserBasketManagementImpl(BasketService basketService, CatalogueSearching catalogueSearching) {
    this.basketService = basketService;
    this.catalogueSearching = catalogueSearching;
  }

  @Override
  public int createNewBasket() {
    return basketService.createNewBasket();
  }

  @Override
  public List<TapasOrder> retrieveListOfAllTapasOrdersInBasket(int basketId) {
    final BasketEntity basket = basketService.getExpectedBasket(basketId);

    return tapasOrderMapper.map(basket.getTapasOrders());
  }

  @Override
  public void addNewTapasOrderToBasket(int basketId, TapasOrder tapasOrder) {
    if (catalogueSearching.getTapas(tapasOrder.getTapasId()) == null) {
      throw new IllegalArgumentException("No tapas found for this ID!");
    }

    final BasketEntity basket = basketService.getExpectedBasket(basketId);

    basketService.addTapasOrder(basket, tapasOrder.getTapasId(), tapasOrder.getAmount());
  }

  @Override
  public BigDecimal calculateCostForBasket(int basketId) {
    final BasketEntity basket = basketService.getExpectedBasket(basketId);

    BigDecimal sum = BigDecimal.ZERO;

    for(TapasOrderEntity tapasOrder : basket.getTapasOrders()) {
      final Tapas tapasPriceInfo = catalogueSearching.getTapas(tapasOrder.getTapasId());

      final BigDecimal subTotal = tapasPriceInfo.getPrice().multiply(BigDecimal.valueOf(tapasOrder.getAmount()));

      sum.add(subTotal);
    }

    return sum;
  }
}
