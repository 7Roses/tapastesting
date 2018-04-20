package be.faros.experimental.tapasapp.store.domain.internal.service.impl;

import be.faros.experimental.tapasapp.store.domain.internal.entity.BasketEntity;
import be.faros.experimental.tapasapp.store.domain.internal.entity.TapasOrderEntity;
import be.faros.experimental.tapasapp.store.domain.internal.repository.BasketRepository;
import be.faros.experimental.tapasapp.store.domain.internal.service.BasketService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {

  private BasketRepository basketRepository;

  public BasketServiceImpl(BasketRepository basketRepository) {
    this.basketRepository = basketRepository;
  }

  @Override
  public int createNewBasket() {
    return basketRepository.save(new BasketEntity()).getId();
  }

  @Override
  public BasketEntity getExpectedBasket(int basketId) {
    return basketRepository.findById(basketId)
        .orElseThrow(() -> new IllegalArgumentException("Basket not found"));
  }

  @Override
  public void addTapasOrder(BasketEntity basket, String tapasId, long amount) {
    final Optional<TapasOrderEntity> tapasOrderEntity = basket.getTapasOrder(tapasId);

    if (tapasOrderEntity.isPresent()) {
      final TapasOrderEntity foundTapasOrderEntity = tapasOrderEntity.get();
      foundTapasOrderEntity.setAmount(amount);
    } else {
      final TapasOrderEntity newTapasOrderEntity = new TapasOrderEntity();
      newTapasOrderEntity.setTapasId(tapasId);
      newTapasOrderEntity.setAmount(amount);
      newTapasOrderEntity.setBasket(basket);
      basket.getTapasOrders().add(newTapasOrderEntity);
    }
  }
}
