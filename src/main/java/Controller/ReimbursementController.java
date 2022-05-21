package Controller;

import Model.Reimbursement;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import Service.ReimbursementService;

public class ReimbursementController {
    ReimbursementService reimbursementService;
    public ReimbursementController() {
        ReimbursementService reimbursementService= new ReimbursementService();
    }
    public void handleSubmit(Context json){
        try{
            Int input = json.body

        }
    }
    public void handleProcess(Context ctx) {
        String authHeader = ctx.header("Current User");
        if(authHeader !=null){
            int UserId = Integer.parseInt(authHeader);
            try{
                String reimbursementIdInput = ctx.pathParam("id");
                int id =Integer.parseInt(reimbursementIdInput);
                String statusInput = ctx.formParam("status");
                Reimbursement reimbursement = reimbursementService.getReimbursementById(id);
                if(reimbursement!= null){
                    Reimbursement processedReimbursement = reimbursementService.update(reimbursement, userId, Status.valueOf(statusInput));

                    ctx.status(HttpCode.ACCEPTED);
                    ctx.result("Reimbursement processing was not successful");
                }else{
                    ctx.status(HttpCode.BAD_REQUEST);
                    ctx.result("Reimbursement processing was ")
                }
            }

        }
    }

}
