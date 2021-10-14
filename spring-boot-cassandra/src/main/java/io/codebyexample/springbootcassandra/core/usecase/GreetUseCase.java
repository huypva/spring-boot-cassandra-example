package io.codebyexample.springbootcassandra.core.usecase;

import io.codebyexample.springbootcassandra.core.entity.Greeting;

/**
 * @author huypva
 */
public interface GreetUseCase {

  Greeting greet(long userId);
}
