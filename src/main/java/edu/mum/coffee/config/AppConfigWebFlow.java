
package edu.mum.coffee.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.security.SecurityFlowExecutionListener;
import org.springframework.web.servlet.ViewResolver;

@Configuration
//@AutoConfigureAfter(AppConfigWebMVC.class)
public class AppConfigWebFlow extends AbstractFlowConfiguration {
	
	@Autowired
	private AppConfigWebMVC webMvcConfig;
	
	@Autowired
    private List<ViewResolver> viewResolvers;

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry())
                .addFlowExecutionListener(new SecurityFlowExecutionListener(), "*")
                .build();
    }

    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
        		.addFlowLocation("/WEB-INF/flows/spring-flow.xml")
                .build();
    }

    @Bean
    public FlowBuilderServices flowBuilderServices() {
        return getFlowBuilderServicesBuilder()
                .setViewFactoryCreator(mvcViewFactoryCreator())
                .build();
    }
    
    
    @Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator() {
        viewResolvers.add(this.webMvcConfig.viewResolver());

        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
        factoryCreator.setViewResolvers(viewResolvers);
        factoryCreator.setUseSpringBeanBinding(true);
        return factoryCreator;
    }
    



}
	