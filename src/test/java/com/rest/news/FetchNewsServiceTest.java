package com.rest.news;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class FetchNewsServiceTest {

    @Test
    public void simpleTest(){

        // create a mock

        FetchNewsService mock_service = Mockito.mock(FetchNewsService.class);

        // mock the required service
        when(mock_service.whoIsMyFriend()).thenReturn("Benson");

        // mock test
        assertEquals("Benson",mock_service.whoIsMyFriend());
    }

    @Test
    public void mockConsumedService(){

        FetchNewsService spy_service = Mockito.spy(FetchNewsService.class);

        Mockito.doReturn("Michael").when(spy_service).whoIsMyFriend();

        assertEquals("This is a quote by Michael", spy_service.getQuote());

    }


}
