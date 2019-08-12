package com.doraemon.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class JSON {

  @FunctionalInterface
  public interface JsonGeneratorCallback {
    public void accept(JsonGenerator gen) throws IOException;
  }

  private static ObjectMapper DEFAULT_MAPPER;

  private static final Set<Module> GLOBAL_MODULES;

  static {
    // when parsing JSON, we want to automatically trim away and leading and trailing whitespace
    // (this includes not only spaces, but tabs and newlines as well)
//    final SimpleModule trimWhitespace = new SimpleModule().addDeserializer(String.class, TrimWhitespaceDeserializer.SINGLETON);

    // change Jackson Enum deserialization so that it forces to uppercase
//    final SimpleModule forceEnumsUppercase = new SimpleModule().setDeserializerModifier(new EnumUppercaseDeserializerModifier());

    // handle ZonedDateTime using DateUtils
    /*final SimpleModule javaDates = new SimpleModule() //
        .addSerializer(new ZonedDateTimeSerializer()) //
        .addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());*/

    // customize Jackson
    GLOBAL_MODULES = new LinkedHashSet<>();
//    addModule(trimWhitespace, forceEnumsUppercase, javaDates);
    DEFAULT_MAPPER = configure(new ObjectMapper(), false);
  }

  private static ObjectMapper configure(final ObjectMapper mapper, final boolean pretty) {
    // keep JSON simple and readable by removing empty values from output
    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    // we don't want scientific notation used for big decimals
    mapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);

    // seems reasonable to allow caller to pass single value for an array
    mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

    // we do want to enforce some strict policies on other "bad" data
    mapper.configure(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY, true);
    mapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
    mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);

    // we don't care if a bean has any serializable properties
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    // caller can optionally request pretty formatting
    if (pretty) {
      mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    // add default modules
    mapper.findAndRegisterModules();

    // register custom modules, which take priority because they are registered last
    for (final Module module : GLOBAL_MODULES) {
      mapper.registerModule(module);
    }

    // return mapper
    return mapper;
  }

  public static <T> String toJson(T obj) {
    Objects.requireNonNull(obj);
    try {
      return DEFAULT_MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}