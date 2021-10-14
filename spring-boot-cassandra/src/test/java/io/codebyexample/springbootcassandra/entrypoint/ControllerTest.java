package io.codebyexample.springbootcassandra.entrypoint;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import io.codebyexample.springbootcassandra.core.entity.Greeting;
import io.codebyexample.springbootcassandra.core.usecase.GreetUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author huypva
 */
@WebMvcTest(Controller.class)
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GreetUseCase greetUseCase;

  @Test
  void greet() throws Exception {
    String api = "/greet?user_id=1";
    Greeting greeting = new Greeting(1L, "Hello Nguyen Van A!");

    given(greetUseCase.greet(1L)).willReturn(greeting);

    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(api))
        .andDo(print());

    resultActions.andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.jsonPath("$.userId", Matchers.is(greeting.getUserId())))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is(greeting.getMessage())));
  }
}