package com.geekbang.coupon.customer.fegin.fallback;

import com.geekbang.coupon.customer.fegin.TemplateService;
import com.geekbang.coupon.template.api.beans.CouponTemplateInfo;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Slf4j
@Component
public class TemplateServiceFallbackFactory implements FallbackFactory<TemplateService> {
    @Override
    public TemplateService create(Throwable cause) {
        return new TemplateService() {
            @Override
            public CouponTemplateInfo getTemplate(Long id) {
                log.info("fallback factory method  getTemplate test:{}",cause.getMessage());
                return null;
            }

            @Override
            public Map<Long, CouponTemplateInfo> getTemplateInBatch(Collection<Long> ids) {
                log.info("fallback factory method  getTemplateInBatch test");
                return Maps.newHashMap();
            }
        };
    }
}
