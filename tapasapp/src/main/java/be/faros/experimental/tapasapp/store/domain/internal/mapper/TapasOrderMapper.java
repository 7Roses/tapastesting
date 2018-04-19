package be.faros.experimental.tapasapp.store.domain.internal.mapper;

import be.faros.experimental.tapasapp.store.domain.internal.entity.TapasOrderEntity;
import be.faros.experimental.tapasapp.store.domain.usecases.dto.TapasOrder;
import java.util.List;
import java.util.stream.Collectors;

public class TapasOrderMapper {

  public List<TapasOrder> map(List<TapasOrderEntity> tapasOrders) {
    return tapasOrders.stream().map(this::map).collect(Collectors.toList());
  }

  public TapasOrder map(TapasOrderEntity tapasOrderEntity) {
    return new TapasOrder(tapasOrderEntity.getTapasId(), tapasOrderEntity.getAmount());
  }

}
