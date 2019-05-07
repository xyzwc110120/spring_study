package com.cyx.spring._15_stereotype_annotation;

import org.springframework.stereotype.Component;

// XML 配置：<bean id="kBean" class="com.cyx.spring._15_stereotype_annotation.KBean" />
// 如果不写 value 属性值，则默认使用类型首字母小写来作为 bean 的 id
@Component("kBean")
public class KBean {
}
