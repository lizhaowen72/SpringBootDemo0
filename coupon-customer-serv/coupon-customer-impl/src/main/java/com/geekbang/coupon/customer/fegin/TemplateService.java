package com.geekbang.coupon.customer.fegin;

import com.geekbang.coupon.customer.fegin.fallback.TemplateServiceFallback;
import com.geekbang.coupon.customer.fegin.fallback.TemplateServiceFallbackFactory;
import com.geekbang.coupon.template.api.beans.CouponTemplateInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

//@FeignClient(value = "coupon-template-serv", path = "/template",fallback = TemplateServiceFallback.class,fallbackFactory = TemplateServiceFallbackFactory.class)
@FeignClient(value = "coupon-template-serv", path = "/template",fallbackFactory = TemplateServiceFallbackFactory.class)
public interface TemplateService {

    @GetMapping("/getTemplate")
    CouponTemplateInfo getTemplate(@RequestParam("id") Long id);

    @GetMapping("/getBatch")
    Map<Long,CouponTemplateInfo> getTemplateInBatch(@RequestParam("ids")Collection<Long> ids);
}
