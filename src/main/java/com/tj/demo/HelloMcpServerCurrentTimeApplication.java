package com.tj.demo;

import com.tj.demo.server.CurrentTImeMcpServer;
import io.modelcontextprotocol.server.McpServer;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * 你好，MCP服务器 - 当前时间 应用程序
 * <p>
 * spring-ai 官方文档：https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html
 *
 * @author tianjie
 * @date 2025/04/07
 */
@SpringBootApplication
public class HelloMcpServerCurrentTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloMcpServerCurrentTimeApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider tools(CurrentTImeMcpServer currentTImeMcpServer) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(currentTImeMcpServer)
                .build();
    }

}
