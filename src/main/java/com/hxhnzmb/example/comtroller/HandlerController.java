package com.hxhnzmb.example.comtroller;

import com.hxhnzmb.example.handler.AbstractGatewayHandler;
import com.hxhnzmb.example.handler.factory.FactoryHandler;
import com.hxhnzmb.example.service.GatewayHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/9 10:56
 */
@RestController
public class HandlerController {

    @Autowired
    private GatewayHandlerService service;

    @RequestMapping("/client")
    public String client() {
        AbstractGatewayHandler firstGatewayHandler = service.getDbFirstGatewayHandler();
        if (firstGatewayHandler != null) {
            firstGatewayHandler.service();
        }
        return "success";
    }
}
