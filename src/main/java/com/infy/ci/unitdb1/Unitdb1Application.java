package com.infy.ci.unitdb1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

@SpringBootApplication
public class Unitdb1Application {

	public static void main(String[] args) {
		SpringApplication.run(Unitdb1Application.class, args);
	}
	
	private static final String RPC_QUEUE_NAME = "rpc_queue1";

    @Bean
    public Queue queue() {
        return new Queue(RPC_QUEUE_NAME);
    }

    @Component
    public static class RpcListener {

        @RabbitListener(queues = RPC_QUEUE_NAME)
        public String reply() {
            String response = "{" + "\n" + "" + "\"glossary\"" + ":" +  "{" + "\n" + "\"title\":" + "\"example glossary\"" + "\n" + "}" + "\n" + "}";
            return response;
        }

    }
}
