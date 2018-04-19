package be.faros.experimental.tapasapp.store.domain.internal.repository;

import be.faros.experimental.tapasapp.store.domain.internal.entity.BasketEntity;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<BasketEntity, Integer> {

}
