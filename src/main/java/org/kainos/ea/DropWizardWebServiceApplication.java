package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.models.Swagger;
import org.kainos.ea.resources.OrderController;
import org.kainos.ea.resources.ProductController;

public class DropWizardWebServiceApplication extends Application<DropWizardWebServicesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardWebServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardWebService";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardWebServicesConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<DropWizardWebServicesConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(DropWizardWebServicesConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(final DropWizardWebServicesConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new OrderController());
        environment.jersey().register(new ProductController());
    }

}
