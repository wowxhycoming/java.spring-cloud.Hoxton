package me.xhy.java.springcloud.s01.provider.book.configvalue;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="info")
public class InfoConfiguration {
}
