package io.github.vinchauhan.gigaspaces;

import io.github.vinchauhan.gigaspaces.config.GigaspaceConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;
@SpringBootTest
@TestPropertySource(properties = {
        "spring.main.web-application-type=none",
        "spring.jta.enabled=false",
        "gigaspaces.transmission=multicast"
})
public class GigaspaceStarterAppTest {

    @Test
    public void testSpaceUrl() throws Exception {
    }
}
