package next.controller;

import core.db.DataBase;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController implements Controller {

    private static Logger logger = LoggerFactory.getLogger(CreateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user
            = new User
                (request.getParameter("userId"), request.getParameter("password"),
                        request.getParameter("name"), request.getParameter("email"));
        logger.debug("User : {}", user);

        DataBase.addUser(user);

        return "redirect:/";
    }
}
