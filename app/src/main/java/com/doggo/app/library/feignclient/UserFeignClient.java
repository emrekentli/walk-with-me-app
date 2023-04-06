package com.doggo.app.library.feignclient;
import org.springframework.cloud.openfeign.FeignClient;
@FeignClient("AUTHENTICATION")
public interface UserFeignClient extends UserFeignCallableApi {
}
