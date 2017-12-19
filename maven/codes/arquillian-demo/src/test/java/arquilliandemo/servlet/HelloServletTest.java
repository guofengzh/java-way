package arquilliandemo.servlet;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolverSystem;
import org.jboss.shrinkwrap.resolver.api.maven.strategy.RejectDependenciesStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;

import arquilliandemo.servlet.HelloServlet;

@RunWith(Arquillian.class)
public class HelloServletTest {
	
	public static Archive<?> createTestArchiveAllFiles() {
		MavenResolverSystem resolver = Maven.resolver();  
		resolver.loadPomFromFile("pom.xml");  
		new RejectDependenciesStrategy() ;
        JavaArchive[] archives = resolver.resolve().using(new RejectDependenciesStrategy()).as(JavaArchive.class);  
		File[] webinfs = new File("src/main/webapp/WEB-INF").listFiles();
		WebArchive wa = ShrinkWrap.create(WebArchive.class, "test.war")
				.addClass(HelloServlet.class);
		if (webinfs != null) {
			for (File f : webinfs) {
				if (f.isFile())
					wa.addAsWebInfResource(f);
			}
		}
		if ( archives != null ) {
			wa.addAsLibraries(Arrays.asList(archives));
		}
		return wa;
	}

	@Deployment
	public static Archive<?> createTestArchiveProperties() {
		WebArchive wa = ShrinkWrap.create(WebArchive.class, "test.war")
				.addClass(HelloServlet.class).addAsWebInfResource("web.xml");
		return wa;
	}

	@Test
	public void testGetText() throws Exception {
		URL url = new URL("http://localhost:8080/test/hello");
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String result = br.readLine();
		String expected = "Hello, World!";
		assertEquals(expected, result);
	}
}
