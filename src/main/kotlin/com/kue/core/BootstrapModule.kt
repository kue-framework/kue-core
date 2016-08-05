package com.kue.core

import com.google.inject.AbstractModule
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

/**
 * @author Michael Vaughan
 */
open class BootstrapModule : AbstractModule() {

    override fun configure() {
        bind(Config::class.java).toInstance(ConfigFactory.load())
    }

}