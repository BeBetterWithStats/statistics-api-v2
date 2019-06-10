package fr.bbws.api.statistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Type;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import fr.bbws.api.statistics.model.Play;
import fr.bbws.api.statistics.model.Position;

public class PlayersResourceTest {

    private HttpServer server;
    
    private WebTarget target;
    
    final static Logger logger = LogManager.getLogger(PlayersResourceTest.class.getName());
    
    final static Type mapStringObjectType = new TypeToken<Map<String, Object>>(){}.getType();
	
	
    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void welcome() {
        String response = target.path("api/").request().get(String.class);
        logger.info("[{}] msg = {}", "testAPI", response);
        assertEquals("Welcome to the Be Better With Stats API !", response);
    }

    @Test
    public void add_http201() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"OUT\",\"when\":\"1st\",\"where\":\"LEFT_FIELD\",\"who\":\"DEMO\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	Response response = target.path("api/players/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "testAdd", httpCode);
        assertEquals(201, httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "testAdd", json);
        
        Map<String, Object> out = new GsonBuilder().create().fromJson( json, mapStringObjectType);
        assertEquals("DEMO", out.get("who"));
    }
    
    @Test
    public void list_http200() {
    	
    	add( "AAAA");
    	Response response = target.path("api/players/").request().get();
    	
    	int httpCode = response.getStatus();
        logger.info("[{}] response.status = {}", "list_http200", httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "list_http200", json);
        
        assertEquals(200, httpCode);
        assertTrue("Response from server should not be empty", json.startsWith("[\"AAAA"));
    }

    
    private void add(String p_name) {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"OUT\",\"when\":\"1st\",\"where\":\"LEFT_FIELD\",\"who\":\"" + p_name + "\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	Response response = target.path("api/players/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    }
    
}
