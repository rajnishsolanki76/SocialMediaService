package socialmedia.service_api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServiceApp 
{
	private static Logger log = LogManager.getLogger();
	
    public static void main( String[] args )
    {
    	log.info("Social Media Service Starting ... ");
    	SpringApplication.run(ServiceApp.class, args);
    }
}
