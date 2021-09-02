package com.mvp.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MvpKafkaMultiChannelProcess {

    @Autowired
    private StreamBridge streamBridge;
    @Bean
    public Function<String, String> process (){

        return input -> {
            streamBridge.send("topic2", input);
            streamBridge.send("topic3", input );
            return "Transaction completed";
        };

    }
}
