package be.faros.experimental.tapasapp.store.controller;

import be.faros.experimental.tapasapp.store.domain.usecases.UserBasketManagement;
import be.faros.experimental.tapasapp.store.domain.usecases.dto.TapasOrder;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
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

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseBody
  public String handleBadRequest(HttpServletRequest req, Exception ex) {
    return ex.getMessage();
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
