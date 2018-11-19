package fr.bbws.api.statistics;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.GsonBuilder;

import fr.bbws.api.statistics.model.PlateAppearance;

public class StatisticsResourceTest {

    private HttpServer server;
    private WebTarget target;
    final static Logger logger = LogManager.getLogger(StatisticsResourceTest.class.getName());
	

    @Before
    public void setUp() throws Exception {
        // start the server
        // server = Main.startServer();
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
        // server.stop();
    }

    /**
     * 
     */
    @Test
    public void testWelcome() {
        String responseMsg = target.path("api").request().get(String.class);
        logger.info("[{}] msg = {}", "testWelcome", responseMsg);
        assertEquals("Welcome to the Be Better With Stats API !", responseMsg);
    }

    /**
     * 
     */
    @Test
    public void testGet_http200() {
    	
    	get("/pa/wyQxF2cBPFkMN3KnQlBj");
//    	Response response = target.path("api/pa/wyQxF2cBPFkMN3KnQlBj").request().get();
//        logger.info("[{}] response.status = {}", "testGet_http200", response.getStatus());
//        logger.info("[{}] response.json = {}", "testGet_http200", response.readEntity(String.class));
//        assertEquals(200, response.getStatus());
        
    }
    
    /**
     * 
     */
    @Test
    public void testGet_http404() {
    	Response response = target.path("api/pa/_noexist").request().get();
    	logger.info("[{}] response.status = {}", "testGet_http404", response.getStatus());
        logger.info("[{}] response.json = {}", "testGet_http404", response.readEntity(String.class));
        assertEquals(404, response.getStatus());
        
    }
    
    /**
     * 
     */
    @Test
    public void testAdd() {
    	
    	
    	// {"against":"MONTPELL. Barracudas","at":"Montigny-le-Bx (Stade Jean Marechal)","day":"2018-09-22T16:12","id":"/pa/wyQxF2cBPFkMN3KnQlBj","what":"OUT","when":"8th","where":"LEFT_FIELD","who":"RAPHET"}
    	// PlateAppearance p_pa = new PlateAppearance();
    	
    	String json = "{\"against\":\"MONTPELL. Barracudas\",\"at\":\"Montigny-le-Bx (Stade Jean Marechal)\",\"day\":\"2018-09-22T16:12\",\"id\":\"/pa/_test\",\"what\":\"OUT\",\"when\":\"8th\",\"where\":\"LEFT_FIELD\",\"who\":\"RAPHET\"}";
    	PlateAppearance in = new GsonBuilder().create().fromJson(json, PlateAppearance.class);
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	logger.info("[{}] response.status = {}", "testAdd", response.getStatus());
        // logger.info("[{}] response.json = {}", "testAdd", response.readEntity(String.class));
        assertEquals(201, response.getStatus());
        
        PlateAppearance out = new GsonBuilder().create().fromJson( response.readEntity(String.class), PlateAppearance.class);
        get(out.getId());
        
    }
    
    
    private void get(String id) {
    	logger.info("[{}] id = {}", "get", id);
        Response response = target.path("api" + id).request().get();
        logger.info("[{}] response.status = {}", "get", response.getStatus());
        logger.info("[{}] response.json = {}", "get", response.readEntity(String.class));
        assertEquals(200, response.getStatus());
    }
}
