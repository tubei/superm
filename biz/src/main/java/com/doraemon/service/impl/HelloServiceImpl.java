package com.doraemon.service.impl;

import com.doraemon.dal.HelloDAO;
import com.doraemon.service.HelloService;
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
