package edu.innotech.inno.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@ConditionalOnExpression("${app.check-product-api-header:true}")
public class ProductApiFilterChecker extends OncePerRequestFilter {

    private static final String HTTP_PRODUCT_HEADER = "X-Product-Api-Key";
    @Value("${app.product-api-key}")
    private String productApiKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String headerValue = request.getHeader(HTTP_PRODUCT_HEADER);

        if (headerValue == null || !headerValue.equals(productApiKey)) {
            response.setHeader(HTTP_PRODUCT_HEADER, "Invalid");
            response.sendError(HttpStatus.BAD_REQUEST.value(), "Заголовок X-Product-Api-Key отсутствует или указан неверно!");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
