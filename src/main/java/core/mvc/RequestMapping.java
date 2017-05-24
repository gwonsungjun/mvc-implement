package core.mvc;

import com.google.common.collect.ImmutableMap;
import next.controller.*;

import java.util.Map;

/**
 * Created by kanghonggu on 2017. 5. 24..
 */
public class RequestMapping {

    private Map<String ,Controller> requestMap;

    private RequestMapping () {
        initRequestMap();
    }

    private void initRequestMap () {
        this.requestMap = ImmutableMap.<String, Controller>builder()
                .put("/", new HomeController())
                .put("/users", new ListUserController())
                .put("/users/logout", new LogoutController())
                .put("/users/login", new LoginController())
                .put("/users/loginForm", new ForwardController("/user/login.jsp"))
                .put("/users/create", new CreateUserController())
                .put("/users/form", new ForwardController("//user/form.jsp"))
                .put("/users/profile", new ProfileController())
                .put("/users/update", new ProfileController())
                .put("/users/updateForm", new ProfileController())
                .build();
    }

    public Controller getRequestMap(String url) {
        return requestMap.get(url);
    }

    public static RequestMapping init () {
        return new RequestMapping();
    }
}
