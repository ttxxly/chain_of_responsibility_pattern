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
 * @date 2019/7/9 10:31
 */
@Component
public class BlacklistHandler extends AbstractGatewayHandler {
    @Override
    public void service() {
        System.out.println("第二关黑名单拦截判断....");
        nextService();
    }
}
