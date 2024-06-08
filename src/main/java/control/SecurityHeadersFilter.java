package control;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityHeadersFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inizializzazione del filtro se necessario
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Imposta l'intestazione X-Frame-Options
        httpResponse.setHeader("X-Frame-Options", "DENY");

        // Imposta l'intestazione Content-Security-Policy
        httpResponse.setHeader("Content-Security-Policy", "frame-ancestors 'self'");

        // Continua la catena dei filtri
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Pulizia del filtro se necessario
    }
}
