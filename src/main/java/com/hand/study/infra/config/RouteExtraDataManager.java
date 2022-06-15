package com.hand.study.infra.config;

import org.springframework.beans.factory.annotation.Autowired;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;

/**
 * 服务路由配置
 *
 * @author RouteExtraDataManager
 */
@ChoerodonExtraData
public class RouteExtraDataManager implements ExtraDataManager {

    @Autowired
    private org.springframework.core.env.Environment environment;

    @Override
    public ExtraData getData() {
        String applName = environment.getProperty("spring.application.name", "hfins-study");
        ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
        choerodonRouteData.setName(applName);
        choerodonRouteData.setPath("/" + applName + "/**");
        choerodonRouteData.setServiceId(applName);
        extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
        return extraData;
    }
}
