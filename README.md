# kue-core
Sets up core functionality for Kue including:

* Default main class at com.kue.core.Main which will initialize the BootstrapModule and Typesafe Config.
* BootstrapModule which then allows other modules to be added via Typesafe Config via guice.modules property.

See the full documentation at https://github.com/kue-framework/kue.
