package io.ctdev.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public interface TestConfig extends Config {
    TestConfig cfg = ConfigFactory.create(TestConfig.class);

    @DefaultValue("true")
    boolean remote();

    @DefaultValue("firefox")
    String browser();

    @DefaultValue(" http://3.18.213.48")
    String webSite();

    @DefaultValue("https://abbvieonecrm--preprod1v3.lightning.force.com/")
    String salesForcePreProd1v3();
}
