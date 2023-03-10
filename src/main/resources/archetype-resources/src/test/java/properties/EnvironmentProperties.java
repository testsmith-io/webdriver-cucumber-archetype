#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("file:src/test/resources/environments/${env}_environment.properties" )
public interface EnvironmentProperties extends Config {
    String url();

    String email();

    String password();
}
