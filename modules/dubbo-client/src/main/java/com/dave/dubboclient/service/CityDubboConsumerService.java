package com.dave.dubboclient.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dave.api.service.CityDubboService;
import com.dave.api.vo.City;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component("city")
public class CityDubboConsumerService {

    @Reference(version = "1.0.0",timeout = 15000,check = false)
    CityDubboService cityDubboService;

    public void printCity() {
        String cityName="温岭";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
    }
}
