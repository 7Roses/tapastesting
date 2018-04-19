package be.faros.experimental.tapasapp.store.domain.internal.service;

import be.faros.experimental.tapasapp.store.domain.internal.entity.BasketEntity;

public interface BasketService {

  int createNewBasket();

  BasketEntity getExpectedBasket(int basketId);

  void addTapasOrder(BasketEntity basket, String tapasId, long amount);

}
