package com.hxhnzmb.example.handler.impl;

import com.hxhnzmb.example.handler.AbstractGatewayHandler;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/9 10:27
 */
@Component
public class CurrentLimitHandler extends AbstractGatewayHandler {
    @Override
    public void service() {
        System.out.println("第一关 API 接口限流操作 ....");
        nextService();
    }
}
