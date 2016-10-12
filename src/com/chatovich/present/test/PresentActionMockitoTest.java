package com.chatovich.present.test;

import com.chatovich.present.action.PresentAction;
import com.chatovich.present.entity.Confection;
import com.chatovich.present.entity.Present;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

//static import
import static org.mockito.Mockito.*;


/**
 * Created by Yultos_ on 09.10.2016
 */
public class PresentActionMockitoTest {

      PresentAction presentAction;
      Present present;
      Confection a;
      Confection b;
      List<Confection> list;
      List spy;

      @Before
      public void init(){
          presentAction = new PresentAction();
          a = mock(Confection.class);
          b = mock(Confection.class);
          list = new ArrayList<>();
          spy = spy(list);
          present = new Present();
          present.setPresentList(spy);
          when(a.getWeight()).thenReturn(1);
          when(b.getWeight()).thenReturn(2);
    }

    @After
    public void clear(){
        present = null;
        list = null;
        a = null;
        b = null;
        presentAction = null;
    }

    @Test
    public void isPresentBigEnoughTest (){
        doReturn(6).when(spy).size();
        boolean actual = presentAction.isPresentBigEnough(spy);
        Assert.assertTrue(actual);
    }

    @Test
    public void addConfentionToPresentTest(){
        present = mock(Present.class);
        present.addConfention(a);
        verify(present).addConfention(a);

    }

    @Test
    public void checkFile (){
        File file = new File(System.getProperty("user.dir")+"/file/present.txt");
        boolean actual = file.exists();
        Assert.assertTrue("File doesn't exist",actual);
    }

}
