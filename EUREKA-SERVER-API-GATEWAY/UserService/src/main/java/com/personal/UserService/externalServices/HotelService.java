package com.personal.UserService.externalServices;

import com.personal.UserService.responseEntities.ResponseHotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/all")
    List<ResponseHotel> getAll();
}
