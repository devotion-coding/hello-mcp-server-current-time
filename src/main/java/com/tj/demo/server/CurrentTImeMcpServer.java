package com.tj.demo.server;

import io.modelcontextprotocol.server.McpServer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 当前时间MCP服务器
 *
 * @author tianjie
 * @date 2025/04/07
 */
@Component
public class CurrentTImeMcpServer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取当前时间
     *
     * @return {@link Long }
     */
    @Tool(description = "Returns the current timestamp")
    public Long getCurrentTime() {
        long result = System.currentTimeMillis();
        logger.info("Current time is {}", result);
        return result;
    }

    @Tool(description = "Returns the current time string in the format specified by the user，默认：yyyy-MM-dd HH:mm:ss")
    public String getCurrentTimeStr(@ToolParam(description = "返回的时间格式", required = false) String pattern) {
        String result = DateFormatUtils.format(new Date(), StringUtils.defaultString(pattern, "yyyy-MM-dd HH:mm:ss"));
        logger.info("Current time whit pattern {} is {}", pattern, result);
        return result;
    }

}
