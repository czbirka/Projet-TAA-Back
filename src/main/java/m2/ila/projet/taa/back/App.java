package m2.ila.projet.taa.back;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

//import io.swagger.jaxrs.config.BeanConfig;
import io.undertow.Undertow;
import m2.ila.projet.taa.back.web.rest.ActiviteResource;
import m2.ila.projet.taa.back.web.rest.DepartementResource;
//import web.rest.DepartementResource;
//import web.rest.EmployeeResource;
//import web.rest.SwaggerResource;
import m2.ila.projet.taa.back.web.rest.LieuResource;
import m2.ila.projet.taa.back.web.rest.RegionResource;
import m2.ila.projet.taa.back.web.rest.UserResource;


public class App extends Application 
{
    public static void main( String[] args )
    {
    	
    	UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.deploy(new App());

        server.start(Undertow.builder().addHttpListener(8080, "0.0.0.0"));
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();

        // REST endpoints
        resources.add(UserResource.class);
        resources.add(LieuResource.class);
        resources.add(RegionResource.class);
        resources.add(DepartementResource.class);
        resources.add(ActiviteResource.class);

        return resources;
    }
}