package com.hxhnzmb.example.handler;

/**
 * 描述:
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/9 10:23
 */
public abstract class AbstractGatewayHandler {

    private AbstractGatewayHandler nextGatewayHandler;

    /**
     * 实现的 handler 处理方案，强制必须实现
     */
    public abstract void service();

    protected void nextService() {
        if (nextGatewayHandler != null) {
            nextGatewayHandler.service();
        }
    }

    public void setHandler(AbstractGatewayHandler gatewayHandler) {
        this.nextGatewayHandler = gatewayHandler;
    }
}
