package co.gobd.tracker.utility.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.gobd.tracker.model.job.Profile;

import static org.junit.Assert.*;

/**
 * Created by fahad on 5/26/2016.
 */
public class ProfileDeserializerTest {

    private Gson gson;

    @Before
    public void setUp() throws Exception {

        gson = new GsonBuilder()
                .registerTypeAdapter(ProfileDeserializer.class , new ProfileDeserializer())
                .create();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDeserialize() throws Exception{
        String json = "{\n" +
                "\"FirstName\":null,\n" +
                "\"LastName\":null,\n" +
                "\"Age\":0,\n" +
                "\"Gender\":\"MALE\",\n" +
                "\"InterestedLocalities\":null,\n" +
                "\"Address\":null,\n" +
                "\"PicUri\":null\n" +
                "}";

        Profile profile = gson.fromJson(json, Profile.class);

        assertEquals(null, profile.getFirstName());
        assertEquals(null, profile.getLastName());
        assertEquals(new Integer(0), profile.getAge());
        assertEquals("MALE", profile.getGender());
        assertEquals(null, profile.getInterestedLocalities());
        assertEquals(null, profile.getAddress());
        assertEquals(null, profile.getPicUri());
    }
}