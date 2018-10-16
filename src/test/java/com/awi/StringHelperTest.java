package com.awi;

import com.awi.appForJUnit.StringHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class StringHelperTest {

  @InjectMocks
  private StringHelper stringHelper;

  @BeforeClass
  public static void before(){


  }

  @Test
  public void areFirstAndLastTwoCharactersTheSame_1(){



  }

  @Test
  public void truncateAInFirst2Positions_1() {

    String cadena = "AABBB";
    String result = stringHelper.truncateAInFirst2Positions(cadena);

    assertEquals("BBB", result);
  }

  @Test
  public void truncateAInFirst2Positions_2() {

    String cadena = "CC";
    String result = stringHelper.truncateAInFirst2Positions(cadena);

    assertEquals("CC", result);
  }
}
