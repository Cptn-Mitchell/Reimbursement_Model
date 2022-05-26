import Controller.AuthController;
import Controller.UserController;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.put;
import static io.javalin.apibuilder.ApiBuilder.post;

public class ReimbursementDriver {
    public static void main(String[] args) {
        UserController controller = new UserController();
        controller.startController();


    }
    public void start(int port){
        this.app.start(port);
    }
    AuthController authController = new AuthController();
    UserController userController = new UserController();
    UserController reimbursementController = new UserController();
    Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins).routes(()->{
        path("login",()->{
            post(authController::handleLogin);
        });
        path("register", ()-> {
            post(authController::handleRegister);

        });
        path("users", () -> {
        get(authController::handleGetUsers);

        path("{id}", ()-> {
            get(userController::handleGetUserByID);
        });
    });
    path("reimbursements", () -> {
        get(reimbursementController)::handleGetReimbursements);
        put(reimbursementController::handleSubmit);
        path ("{id}", ()->{
            get(reimbursementController::handleGetReimbursementById);
            put(reimbursementController::handleProcess);
         });
        });
    });
}