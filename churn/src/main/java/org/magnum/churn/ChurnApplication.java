package org.magnum.churn;

import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChurnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChurnApplication.class, args);
    }

    @Bean
    public Node elasticSearch(){
    	return NodeBuilder.nodeBuilder().local(true).build();
    }
   
}
