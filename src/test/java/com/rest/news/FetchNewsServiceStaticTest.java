package com.rest.news;

import com.rest.helper.URLFetch;
import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FetchNewsServiceStatic.class , URLFetch.class})
public class FetchNewsServiceStaticTest {

    @BeforeClass
    public static void  mockStaticMethod(){
        PowerMockito.mockStatic( URLFetch.class );
        String news_response = "{\\r\\n\\t\\\"status\\\": \\\"ok\\\",\\r\\n\\t\\\"totalResults\\\": 20,\\r\\n\\t\\\"articles\\\": [{\\r\\n\\t\\t\\\"source\\\": {\\r\\n\\t\\t\\t\\\"id\\\": null,\\r\\n\\t\\t\\t\\\"name\\\": \\\"Yahoo.com\\\"\\r\\n\\t\\t},\\r\\n\\t\\t\\\"author\\\": null,\\r\\n\\t\\t\\\"title\\\": \\\"Welcome to the New NFL, where Chiefs-Rams shootout forced defenders to score or lose\\\",\\r\\n\\t\\t\\\"description\\\": \\\"The other NFL reality: As offenses are now so entertaining, they can relegate bad officiating that would have taken over the narrative of this game only five years ago to an afterthought.\\\",\\r\\n\\t\\t\\\"url\\\": \\\"https://sports.yahoo.com/welcome-new-nfl-chiefs-rams-shootout-forced-defenders-score-lose-092458961.html\\\",\\r\\n\\t\\t\\\"urlToImage\\\": \\\"https://s.yimg.com/uu/api/res/1.2/AP_gh_X3Qt7XAum0FWK5Bw--~B/aD0yNDg1O3c9MzY4NTtzbT0xO2FwcGlkPXl0YWNoeW9u/http://media.zenfs.com/en/homerun/feed_manager_auto_publish_494/64b4d88747fe8ddf256a5e318434d8f6\\\",\\r\\n\\t\\t\\\"publishedAt\\\": \\\"2018-11-20T09:24:00Z\\\",\\r\\n\\t\\t\\\"content\\\": \\\"LOS ANGELES \\u2014 As the loose football wiggled, rolled and hopped around on the green grass in front of him Monday night, Samson Ebukam \\u2014 who was only a scoop away from a wide-open path to the end zone \\u2014 heard the commanding voice of his head coach, Sean McVay, \\u2026 [+7864 chars]\\\"\\r\\n\\t}]\\r\\n}";

        PowerMockito.when(URLFetch.getResponse("https://newsapi.org/v2/top-headlines?country=in&apiKey=1e1541fe894d423ea58d74b9d519704c"))
                .thenReturn(news_response);
    }

    @Test
    public void static_method_test(){
        String news_response = "{\\r\\n\\t\\\"status\\\": \\\"ok\\\",\\r\\n\\t\\\"totalResults\\\": 20,\\r\\n\\t\\\"articles\\\": [{\\r\\n\\t\\t\\\"source\\\": {\\r\\n\\t\\t\\t\\\"id\\\": null,\\r\\n\\t\\t\\t\\\"name\\\": \\\"Yahoo.com\\\"\\r\\n\\t\\t},\\r\\n\\t\\t\\\"author\\\": null,\\r\\n\\t\\t\\\"title\\\": \\\"Welcome to the New NFL, where Chiefs-Rams shootout forced defenders to score or lose\\\",\\r\\n\\t\\t\\\"description\\\": \\\"The other NFL reality: As offenses are now so entertaining, they can relegate bad officiating that would have taken over the narrative of this game only five years ago to an afterthought.\\\",\\r\\n\\t\\t\\\"url\\\": \\\"https://sports.yahoo.com/welcome-new-nfl-chiefs-rams-shootout-forced-defenders-score-lose-092458961.html\\\",\\r\\n\\t\\t\\\"urlToImage\\\": \\\"https://s.yimg.com/uu/api/res/1.2/AP_gh_X3Qt7XAum0FWK5Bw--~B/aD0yNDg1O3c9MzY4NTtzbT0xO2FwcGlkPXl0YWNoeW9u/http://media.zenfs.com/en/homerun/feed_manager_auto_publish_494/64b4d88747fe8ddf256a5e318434d8f6\\\",\\r\\n\\t\\t\\\"publishedAt\\\": \\\"2018-11-20T09:24:00Z\\\",\\r\\n\\t\\t\\\"content\\\": \\\"LOS ANGELES \\u2014 As the loose football wiggled, rolled and hopped around on the green grass in front of him Monday night, Samson Ebukam \\u2014 who was only a scoop away from a wide-open path to the end zone \\u2014 heard the commanding voice of his head coach, Sean McVay, \\u2026 [+7864 chars]\\\"\\r\\n\\t}]\\r\\n}";
        FetchNewsServiceStatic spy_service = Mockito.spy(FetchNewsServiceStatic.class);
        TestCase.assertEquals(news_response,spy_service.getResponseFromStaticFunction());
    }

}
