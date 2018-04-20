package be.faros.experimental.tapasapp.store.controller;

import be.faros.experimental.tapasapp.store.domain.usecases.UserBasketManagement;
import be.faros.experimental.tapasapp.store.domain.usecases.dto.TapasOrder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class UserBasketManagementController {

  private UserBasketManagement userBasketManagement;

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Object> handleBadRequest(Exception ex) {
      final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
      return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
  }

  public UserBasketManagementController(UserBasketManagement userBasketManagement) {
    this.userBasketManagement = userBasketManagement;
  }

  @RequestMapping(value = "/basket", method = RequestMethod.POST)
  public int createNewBasket() {
    return userBasketManagement.createNewBasket();
  }

  @RequestMapping(value = "/basket/{basketId}", method = RequestMethod.GET)
  public List<TapasOrder> retrieveListOfAllTapasOrdersInBasket(@PathVariable int basketId) {
    return userBasketManagement.retrieveListOfAllTapasOrdersInBasket(basketId);
  }

  @RequestMapping(value = "/basket/{basketId}", method = RequestMethod.PUT)
  public void addNewTapasOrderToBasket(@PathVariable int basketId, @RequestParam("tapasId") String tapasId, @RequestParam("amount") int amount) {
    userBasketManagement.addNewTapasOrderToBasket(basketId, new TapasOrder(tapasId, amount));
  }

  @RequestMapping(value = "/basket/{basketId}/totalCost", method = RequestMethod.GET)
  public BigDecimal calculateCostForBasket(@PathVariable int basketId) {
    return userBasketManagement.calculateCostForBasket(basketId);
  }

}
