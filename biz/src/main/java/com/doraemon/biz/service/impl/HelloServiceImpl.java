package com.doraemon.biz.service.impl;

import com.doraemon.biz.service.HelloService;
import com.doraemon.dal.HelloDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wl
 */
@Service
public class HelloServiceImpl implements HelloService {

  @Resource
  private HelloDAO helloDAO;
  /**
   * {@inheritDoc}
   */
  @Override
  public String helloWorld() {
    return helloDAO.helloWorld();
  }
}
