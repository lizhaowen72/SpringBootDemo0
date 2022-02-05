package com.geekbang.coupon.template.api.beans;

import com.geekbang.coupon.template.api.beans.rules.TemplateRule;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 创建优惠券模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponTemplateInfo {

    private Long id;

    @NotNull
    private String name;

    //优惠券描述
    @NotNull
    private String desc;

    @NotNull
    private String type;

    // 适用门店 - 若无则为全店通用劵
    private Long shopId;

    // 优惠券规则
    @NotNull
    private TemplateRule rule;

    private Boolean available;

}
