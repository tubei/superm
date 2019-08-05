package com.doraemon.dal;

import com.doraemon.common.HelloUtils;
import org.springframework.stereotype.Repository;

/**
 * @author wl
 */
@Repository
public class HelloDAO {

  public String helloWorld() {
    return HelloUtils.helloWorld();
  }
}
