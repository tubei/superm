package com.doraemon.dal.convert;

import com.doraemon.dal.enums.UserState;
import com.doraemon.dal.enums.Valueable;
import org.jooq.Converter;
import org.jooq.impl.EnumConverter;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * 转换 enum 和 int
 *
 * @author wl
 */
public class DBEnumConverter<U extends Enum<U> & Valueable> extends EnumConverter<Byte, U> {

  private DBEnumConverter(Class<Byte> fromType, Class<U> toType) {
    super(fromType, toType);
  }

  public static <T extends Enum<T> & Valueable> Converter build(Class<T> userObjClass) {
    return new DBEnumConverter<>(byte.class, userObjClass);
  }

  @Override
  public Byte to(U userObject) {
    return (byte) userObject.getValue();
  }
}
