package com.kue.core

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Module
import com.typesafe.config.Config
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * @author Michael Vaughan
 */
object Main {

    @JvmStatic
    fun main(args: Array<String>) : Unit {
        Log.info("Starting Kue")
        // The bootstrap injector allows us to have the Config available for injection as well as using a config value
        // for loading new modules.
        val bootstrap = Guice.createInjector(BootstrapModule())
        val config = bootstrap.getInstance(Config::class.java)
        Application.config = config

        // Load application.conf defined modules
        val modules = config.getStringList("guice.modules").map {Class.forName(it)}.map {it.newInstance() as Module }
        val injector = bootstrap.createChildInjector(modules)
        Application.injector = injector
    }

}

open class LogClass(logger: Logger) : Logger by logger

object Log : LogClass(LoggerFactory.getLogger("application"))

object Application {

    var config: Config? = null
    var injector: Injector? = null

}