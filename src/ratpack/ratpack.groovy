import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ratpack.hikari.HikariModule
import ratpack.hikari.HikariService

import javax.sql.DataSource

import static ratpack.groovy.Groovy.ratpack

final Logger logger = LoggerFactory.getLogger(ratpack.class);
ratpack {
    //ratpack.groovy.internal.capture.RatpackDslBacking
    serverConfig {
        //ratpack.server.internal.DefaultServerConfigBuilder
    }
    bindings {
        //ratpack.guice.internal.DefaultBindingsSpec@a4d3df
        module(HikariModule){config ->
            config.dataSourceClassName ='org.h2.jdbcx.JdbcDataSource'
            config.addDataSourceProperty('URL',"jdbc:h2:mem:indb")
        }
    }

    handlers {
        //ratpack.groovy.handling.internal.DefaultGroovyChain
        get(':path/:subpath?'){
            def dataSource = get(DataSource)
            def hikariService = get(HikariService)
            println "The dataSource is: $dataSource \n\n hikariService: $hikariService"
            //ratpack.groovy.handling.internal.DefaultGroovyContext
            render "Hello ${pathTokens.get('path')} ${pathTokens.get('subpath')?:''}!!!"
        }
    }
}

