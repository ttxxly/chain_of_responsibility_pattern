package com.hxhnzmb.example.handler.factory;

import com.hxhnzmb.example.handler.AbstractGatewayHandler;
import com.hxhnzmb.example.handler.impl.BlacklistHandler;
import com.hxhnzmb.example.handler.impl.ConversationHandler;
import com.hxhnzmb.example.handler.impl.CurrentLimitHandler;

/**
 * 描述:
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/9 10:47
 */
public class FactoryHandler {

    public static AbstractGatewayHandler getFirstGatewayHandler() {
        AbstractGatewayHandler currentLimitHandler = new CurrentLimitHandler();
        AbstractGatewayHandler blacklistHandler = new BlacklistHandler();
        AbstractGatewayHandler conversationHandler = new ConversationHandler();

        currentLimitHandler.setHandler(blacklistHandler);
        blacklistHandler.setHandler(conversationHandler);

        return currentLimitHandler;
    }
}
