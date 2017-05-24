package core.mvc;

import next.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kanghonggu on 2017. 5. 24..
 */

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    private RequestMapping requestMapping;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        requestMapping = RequestMapping.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();

        logger.info("url - {}", url);

        Controller controller = requestMapping.getRequestMap(url);

        try {
            String forwardingUrl = controller.execute(req,resp);

            if (forwardingUrl.contains("redirect:")) {
                String redirectUrl = forwardingUrl.split(":")[1];

                resp.sendRedirect(redirectUrl);

                return;
            }

            RequestDispatcher rd = req.getRequestDispatcher(forwardingUrl);
            rd.forward(req, resp);

        } catch (Exception e) {
            logger.error("error occur - {}", e);
        }
    }

    @Override
    public void destroy() {

    }
}
