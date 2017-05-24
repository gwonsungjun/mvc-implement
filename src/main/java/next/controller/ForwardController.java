package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kanghonggu on 2017. 5. 24..
 */
public class ForwardController implements Controller {

    private String forwardingUrl;

    public ForwardController(String forwardingUrl) {
        this.forwardingUrl = forwardingUrl;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return forwardingUrl;
    }
}
