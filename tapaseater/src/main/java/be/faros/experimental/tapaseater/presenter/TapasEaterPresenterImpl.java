package be.faros.experimental.tapaseater.presenter;

import be.faros.experimental.tapaseater.gateway.TapasAppGateway;
import be.faros.experimental.tapaseater.gateway.dto.Tapas;
import be.faros.experimental.tapaseater.gateway.dto.TapasOrder;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TapasEaterPresenterImpl implements TapasEaterPresenter {

  private final TapasAppGateway tapasAppGateway;

  private Integer currentBasket;

  public TapasEaterPresenterImpl(TapasAppGateway tapasAppGateway) {
    this.tapasAppGateway = tapasAppGateway;
  }

  public List<Tapas> listAvailableTapas() {
    return tapasAppGateway.getAvailableTapas();
  }

  public void createNewBasket() {
    currentBasket = tapasAppGateway.createNewBasket();
  }

  public boolean basketIsSelected() {
    return currentBasket != null;
  }

  @Override
  public List<TapasOrder> retrieveListOfAllTapasOrdersInBasket() {
    return tapasAppGateway.retrieveListOfAllTapasOrdersInBasket(this.currentBasket);
  }

  @Override
  public void addNewTapasOrderToBasket(String tapasId, int amount) {
    tapasAppGateway.addNewTapasOrderToBasket(this.currentBasket, tapasId, amount);
  }

  @Override
  public BigDecimal calculateCostForBasket() {
    return tapasAppGateway.calculateCostForBasket(this.currentBasket);
  }

}