import Controller.AuthController;
import Controller.ReimbursementController;
import Controller.UserController;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;


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
    ReimbursementController reimbursementController = new ReimbursementController();
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
            put(rembursementController::handleProcess);
         });
        });
    });
    }
}