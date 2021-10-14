package io.codebyexample.springbootcassandra.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author huypva
 */
@Setter
@Getter
@AllArgsConstructor
public class Greeting {

  private long userId;
  private String message;

}
