package io.codebyexample.springbootcassandra.core.usecase;

import io.codebyexample.springbootcassandra.core.entity.Greeting;
import io.codebyexample.springbootcassandra.dataprovider.cassandra.UserEntity;
import io.codebyexample.springbootcassandra.dataprovider.cassandra.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Component
public class GreetUseCaseImpl implements GreetUseCase {

  @Autowired
  UserRepository userRepository;

  @Override
  public Greeting greet(long userId) {
    UserEntity userEntity = userRepository.findById(userId).get();
    return new Greeting(userEntity.getUserId(), String.format("Hello %s!", userEntity.getUserName()));
  }
}
