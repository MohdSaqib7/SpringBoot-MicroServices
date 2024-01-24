package com.personal.Producer.configs;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Slf4j
@Configuration
public class AppFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Remote Host and Port Number: "+servletRequest.getRemoteHost()+"/"+servletRequest.getServerPort());
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
