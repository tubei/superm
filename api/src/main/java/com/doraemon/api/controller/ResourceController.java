package com.doraemon.api.controller;

import com.doraemon.api.vo.ApiResult;
import com.doraemon.data.gen.tables.pojos.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tubei
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

  @PostMapping
  public ApiResult<?> createResource(Resource resource){
    return null;
  }
}
