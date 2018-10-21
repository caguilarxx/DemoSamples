package com.awi;

import com.awi.appForMockito.business.TodoBusinessImpl;
import com.awi.appForMockito.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoTest {

  @Test
  public void usingMockito() {
    TodoService todoService = mock(TodoService.class);

    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

    when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

    List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");

    assertEquals(2, todos.size());
  }

  @Test
  public void usingMockito_UsingBDD() {
//    TodoService todoService = mock(TodoService.class);
//    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
//    List<String> allTodos = Arrays.asList("Learn Spring MVC",
//        "Learn Spring", "Learn to Dance");
//
//    //given
//    given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);
//
//    //when
////    List<String> todos = todoBusin essImpl
//        .retrieveTodosRelatedToSpring("Ranga");
//
//    //then
//    assertThat(todos.size(), is(2));
  }

  @Test
  public void letsTestDeleteNow() {

    TodoService todoService = mock(TodoService.class);

    List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

    when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

    TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

    todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

    verify(todoService).deleteTodo("Learn to Dance");

    verify(todoService, never()).deleteTodo("Learn Spring MVC");

    verify(todoService, never()).deleteTodo("Learn Spring");

    verify(todoService, times(1)).deleteTodo("Learn to Dance");

  }
}
