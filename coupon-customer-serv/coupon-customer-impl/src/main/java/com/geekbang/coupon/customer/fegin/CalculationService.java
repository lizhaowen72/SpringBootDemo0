package com.geekbang.coupon.customer.fegin;

import com.geekbang.coupon.calculation.api.beans.ShoppingCart;
import com.geekbang.coupon.calculation.api.beans.SimulationOrder;
import com.geekbang.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "coupon-calculation-serv",path="/calculator")
public interface CalculationService {

    // 订单结算
    @PostMapping("/checkout")
    ShoppingCart checkout(ShoppingCart settlement);

    @PostMapping("/simulate")
    SimulationResponse simulate(SimulationOrder simulator);
}
