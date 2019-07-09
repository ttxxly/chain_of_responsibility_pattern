package com.hxhnzmb.example.service;

import com.hxhnzmb.example.entity.GatewayHandlerEntity;
import com.hxhnzmb.example.handler.AbstractGatewayHandler;
import com.hxhnzmb.example.mapper.GatewayHandlerMapper;
import com.hxhnzmb.example.utils.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/9 14:13
 */
@Component
public class GatewayHandlerService {

    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;

    private AbstractGatewayHandler firstGatewayHandler;

    public AbstractGatewayHandler getDbFirstGatewayHandler() {

        if (this.firstGatewayHandler != null) {
            return this.firstGatewayHandler;
        }
        // 1.查询数据库第一个handler配置
        GatewayHandlerEntity firstGatewayHandlerEntity = gatewayHandlerMapper.getFirstGatewayHandler();
        if (firstGatewayHandlerEntity == null) {
            return null;
        }
        String firstBeanHandlerId = firstGatewayHandlerEntity.getHandlerId();
        if (StringUtils.isEmpty(firstBeanHandlerId)) {
            return null;
        }
        // 2.从SpringBoot容器获取第一个handler对象
        AbstractGatewayHandler firstGatewayHandler = SpringUtils.getBean(firstBeanHandlerId, AbstractGatewayHandler.class);
        if (firstGatewayHandler == null) {
            return null;
        }
        // 3. 获取下一个handlerBeanId
        String nextBeanHandlerId = firstGatewayHandlerEntity.getNextHandlerId();
        // 定义临时循环遍历指针
        AbstractGatewayHandler tempNextGatewayHandler = firstGatewayHandler;
        while (!StringUtils.isEmpty(nextBeanHandlerId)) {
            // 4.从SpringBoot容器获取下一个handler对象
            AbstractGatewayHandler nextGatewayHandler = SpringUtils.getBean(nextBeanHandlerId, AbstractGatewayHandler.class);
            if (nextGatewayHandler == null) {
                break;
            }
            // 5.从数据库查询该hanlder信息
            GatewayHandlerEntity nextGatewayHandlerEntity = gatewayHandlerMapper.getByHandler(nextBeanHandlerId);
            if (nextGatewayHandlerEntity == null) {
                break;
            }
            // 6.设置下一个white循环遍历hanlderid
            nextBeanHandlerId = nextGatewayHandlerEntity.getNextHandlerId();
            tempNextGatewayHandler.setHandler(nextGatewayHandler);
            tempNextGatewayHandler = nextGatewayHandler;
        }
        this.firstGatewayHandler = firstGatewayHandler;
        return firstGatewayHandler;
    }
}