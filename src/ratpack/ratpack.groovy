import static ratpack.groovy.Groovy.ratpack

ratpack {
    //ratpack.groovy.internal.capture.RatpackDslBacking
    serverConfig {
        //ratpack.server.internal.DefaultServerConfigBuilder
    }
    handlers {
        //ratpack.groovy.handling.internal.DefaultGroovyChain
        get(':path'){
            //ratpack.groovy.handling.internal.DefaultGroovyContext
            render "Hello ${pathTokens.get('path')} !!!"
        }
    }
}