package tk.mybatis.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import tk.mybatis.web.utils.DbSetup;

import javax.sql.DataSource;

@Component
public class ApplicationStartup {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartup.class);

    @Autowired
    DataSource dataSource ;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @EventListener(ContextRefreshedEvent.class)
    void contextRefreshedEvent() {
        try {
            System.out.println("Init database") ;
            DbSetup.runScript(dataSource, "sys_dict-schema.sql");
        } catch (Throwable t) {
            LOGGER.error(t.getMessage());
        }
    }
}
