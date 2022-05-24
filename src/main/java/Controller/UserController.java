package Controller;
import Model.Reimbursement;
import Model.UserData;
import Service.UserService;
import Service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.HttpCode;

import static Service.UserService.*;

public class UserController {
    public UserController(){


    }

    public void startController() {
        Javalin app = Javalin.create();
        ReimbursementService reimbursementService = new ReimbursementService();
        UserService loginService = new UserService();
        app.start(5000);

        app.get("Username/{Employee1}", context ->{
        String HandlerId = (context.pathParam("Employee1"));
        context.json(loginService.getUserByUsername(HandlerId));
        });

        app.get("User/{ID}", context ->{
        int HandlerId = Integer.parseInt(context.pathParam("ID"));
        context.json(loginService.getUserByID(HandlerId));
        });

        app.get("Username/{}", context ->{
        context.json(loginService.getAllUsers());
        });

        app.get("User/{Role}", context ->{
        String HandlerId = (context.pathParam("Role"));
        context.json(loginService.getUsersByRole(HandlerId));
        });

        app.get("login/{}", anything -> {
            ObjectMapper mapper = new ObjectMapper();
            UserService user = mapper.readValue(anything.body(), UserService.class);
            UserData u = loginService.login(getUsername(), getPassword());
            if (u == null) {
                anything.status(HttpCode.INTERNAL_SERVER_ERROR);
            } else {
                anything.json(u);
            }
        });
        app.get("register", context -> {
                    ObjectMapper mapper = new ObjectMapper();
                    UserService user = mapper.readValue(context.body(), UserService.class);
                    int userID = loginService.register(user.getUsername(), user.getPassword());
                    if (userID == 0) {
                        context.status(HttpCode.INTERNAL_SERVER_ERROR);
                    } else {
                        context.result("" + userID);
                    }
                });

        app.post("Submit", context ->{
            ObjectMapper mapper = new ObjectMapper();
            Reimbursement reimbursementToBeAdded = mapper.readValue(context.body(), Reimbursement.class);
            context.json(reimbursementService.addReimbursement(reimbursementToBeAdded));
        });

        app.put("Process", context ->{
            Object mapper = new ObjectMapper();
            Reimbursement reimbursement = ((ObjectMapper) mapper).readValue(context.body(), Reimbursement.class);
            int reimbursementId = Integer.parseInt(context.pathParam("ID"));
            context.json(reimbursementService.getReimbursementByID(reimbursementId));

        });
        app.get("Status", context -> {
            context.json(reimbursementService.getReimbursementByStatus(reimbursementByStatus));

        });

        app.get("Author", context -> {
            String author = (context.pathParam("author"));
            context.json(reimbursementService.getReimbursementByAuthor("author"));
        });
        app.get("Author/{Name}", context -> {
            String Name = (context.pathParam("Name"));
            context.json(reimbursementService.getReimbursementByAuthor(Name));
        }):

        app.get("/Reimbursement/ID", context ->{
            Object mapper = new ObjectMapper();
            Reimbursement reimbursement = ((ObjectMapper) mapper).readValue(context.body(), Reimbursement.class);
            int reimbursementId = Integer.parseInt(context.pathParam("ID"));
            context.json(reimbursementService.getReimbursementByID(reimbursementId));
        });


    }}

