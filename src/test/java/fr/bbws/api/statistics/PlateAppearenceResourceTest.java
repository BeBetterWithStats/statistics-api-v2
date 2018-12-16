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

public class PlateAppearenceResourceTest {

    private HttpServer server;
    
    private WebTarget target;
    
    final static Logger logger = LogManager.getLogger(PlateAppearenceResourceTest.class.getName());
    
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
    @Ignore
    public void get_http200() {
    	get("/pa/0FAouGcBblz1j4IFCYLi", null, null, null, null, "RIVER");
    }
    
    @Test
    public void get_http404() {
    	Response response = target.path("api/pa/_noexist").request().get();
    	
    	int httpCode = response.getStatus();
        logger.info("[{}] response.status = {}", "get_http404", httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "get_http404", json);
        assertEquals(404, response.getStatus());
    }
    
    @Test
    public void add_http201() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"OUT\",\"when\":\"1st\",\"where\":\"LEFT_FIELD\",\"who\":\"DEMO\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "testAdd", httpCode);
        assertEquals(201, httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "testAdd", json);
        
        Map<String, Object> out = new GsonBuilder().create().fromJson( json, mapStringObjectType);
        get(out.get("id"), Position.LEFT_FIELD, Play.OUT, "1st", "DEMO", "TEST");
    }
    
    @Test
    public void add_http500_withoutState() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"what\":\"OUT\",\"when\":\"1st\",\"where\":\"LEFT_FIELD\",\"who\":\"DEMO\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "add_http500_withoutState", httpCode);
    	
    	String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "add_http500_withoutState", json);
        
        assertEquals(500, httpCode);
    }
    
    @Test
    public void add_http400_withoutWho() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"OUT\",\"when\":\"1st\",\"where\":\"LEFT_FIELD\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "add_http400_withoutWho", httpCode);
    	
    	String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "add_http400_withoutWho", json);
        
        assertEquals(400, httpCode);
    }
    
    @Test
    public void add_http400_withoutWhen() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"OUT\",\"where\":\"LEFT_FIELD\",\"who\":\"DEMO\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "add_http400_withoutWhen", httpCode);
    	
    	String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "add_http400_withoutWhen", json);
        
        assertEquals(400, httpCode);
    }

    @Test
    public void add_http400_withoutWhere() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"OUT\",\"when\":\"1st\",\"who\":\"DEMO\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "add_http400_withoutWhere", httpCode);
    	
    	String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "add_http400_withoutWhere", json);
        
        assertEquals(400, httpCode);
    }
    
    @Test
    public void add_http400_withWhereNotValid() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"OUT\",\"when\":\"1st\",\"where\":\"NOT_VALID\",\"who\":\"DEMO\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "add_http400_withWhereNotValid", httpCode);
    	
    	String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "add_http400_withWhereNotValid", json);
        
        assertEquals(400, httpCode);
    }

    @Test
    public void add_http400_withWhatNotValid() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"NOT_VALID\",\"when\":\"1st\",\"where\":\"LEFT_FIELD\",\"who\":\"DEMO\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "add_http400_withWhatNotValid", httpCode);
    	
    	String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "add_http400_withWhatNotValid", json);
        
        assertEquals(400, httpCode);
    }

    @Test
    public void add_http400_withWhenNotValid() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"OUT\",\"when\":\"NOT_VALID\",\"where\":\"LEFT_FIELD\",\"who\":\"DEMO\"}";
    	Map<String, Object> in = new GsonBuilder().create().fromJson(inJson, mapStringObjectType);
    	
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "add_http400_withWhatNotValid", httpCode);
    	
    	String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "add_http400_withWhatNotValid", json);
        
        assertEquals(400, httpCode);
    }
    @Test
    public void list_http200() {
    	Response response = target.path("api/pa").queryParam("search", "DEMO").request().get();
    	
    	int httpCode = response.getStatus();
        logger.info("[{}] response.status = {}", "list_http200", httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "list_http200", json);
        
        assertEquals(200, httpCode);
        assertTrue("Response from server should not be empty", json.startsWith("[{\"game\":\""));
    }

    @Test
    public void list_http200_empty() {
    	Response response = target.path("api/pa").queryParam("search", "NO_NAME").request().get();
    	
    	int httpCode = response.getStatus();
        logger.info("[{}] response.status = {}", "list_http200_empty", httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "list_http200_empty", json);
        
        assertEquals(200, httpCode);
        assertEquals("[]", json);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    private void get(Object p_id, Position p_where, Play p_what, String p_when, String p_who, String p_state) {
    	logger.info("[{}] id = {}", "get", p_id);
        Response response = target.path("api" + p_id).request().get();
        
        int httpCode = response.getStatus();
        logger.info("[{}] response.status = {}", "get", httpCode);
        assertEquals(200, httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "get", json);
        
        Map<String, Object> out = new GsonBuilder().create().fromJson( json, mapStringObjectType);
        if (p_where != null && p_what != null && StringUtils.isNotEmpty(p_when) && StringUtils.isNotEmpty(p_who) && StringUtils.isNotEmpty(p_state)) {
        	assertEquals(p_where.name(), out.get("where"));
        	assertEquals(p_what.name(), out.get("what"));
        	assertEquals(p_when, out.get("when"));
        	assertEquals(p_who, out.get("who"));
        	// assertEquals(p_state, out.getState()); // TODO décomenter lorsque le GET de statisticsResource renverra cet élément
        }
    }
}
