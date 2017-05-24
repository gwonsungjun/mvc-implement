package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kanghonggu on 2017. 5. 24..
 */
public interface Controller {
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
