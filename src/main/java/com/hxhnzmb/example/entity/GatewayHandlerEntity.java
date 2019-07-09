package com.hxhnzmb.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述:
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/9 14:15
 */
@Data
public class GatewayHandlerEntity implements Serializable, Cloneable {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * handler名称
     */
    private String handlerName;
    /**
     * handler主键id
     */
    private String handlerId;
    /**
     * 下一个handler
     */
    private String nextHandlerId;
}
