package io.github.vinchauhan.gigaspaces.config;

import lombok.extern.slf4j.Slf4j;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(GigaSpace.class)
@EnableConfigurationProperties(GigaspaceConfigProperties.class)
@Slf4j
public class GigaspaceConfig {

        @Bean
        @ConditionalOnProperty(prefix = "gigaspaces", name = "transmission", havingValue = "unicast")
        GigaSpace configureXapUniCast(GigaspaceConfigProperties properties) {
            log.info("Autoconfiguring Gigaspace for {}", "unicast");
            log.info("Default SpaceUrl {}, set gigaspace.space-url property for custom url", properties.getSpaceUrl());
            UrlSpaceConfigurer urlSpaceConfigurer = new UrlSpaceConfigurer(properties.getSpaceUrl());
            urlSpaceConfigurer.lookupTimeout(20000);
            GigaSpaceConfigurer gigaSpaceConfigurer = new GigaSpaceConfigurer(urlSpaceConfigurer);
            return gigaSpaceConfigurer.gigaSpace();
        }

        @Bean
        @ConditionalOnProperty(prefix = "gigaspaces", name = "transmission", havingValue = "multicast")
        GigaSpace configureXapMultiCast(GigaspaceConfigProperties properties) {
            log.info("Autoconfiguring Gigaspace for {}", "multicast");
            log.info("Default SpaceUrl {}, set gigaspace.space-url property for custom url", properties.getSpaceUrl());
            UrlSpaceConfigurer urlSpaceConfigurer = new UrlSpaceConfigurer(properties.getSpaceUrl());
            urlSpaceConfigurer.lookupTimeout(20000);
            GigaSpaceConfigurer gigaSpaceConfigurer = new GigaSpaceConfigurer(urlSpaceConfigurer);
            return gigaSpaceConfigurer.gigaSpace();
        }
}
