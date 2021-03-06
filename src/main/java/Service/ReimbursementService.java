package Service;

import Model.Reimbursement;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import DAO.ReimbursementDao;
import java.util.ArrayList;
import java.util.List;

import static java.io.ObjectInputFilter.*;

public class ReimbursementService {
    ArrayList<Reimbursement> reimbursementArrayList;

    public ReimbursementService() {
        reimbursementArrayList = new ArrayList<>();
    }

    public ArrayList<Reimbursement> getAllReimbursement() {
        return reimbursementArrayList;
    }

    public Object addReimbursement(Reimbursement r) {
        reimbursementArrayList.add(r);
        return null;
    }

    public void getReimbursementByAuthor(Reimbursement R) {
        ArrayList.add(reimbursementArrayList);
        reimbursementArrayList.set(reimbursementArrayList, R);
    }

    public void Reimbursement(Reimbursement r, int id) {
        reimbursementArrayList.set(id,r);
    }

    public Reimbursement getReimbursement(int id) {
        return reimbursementArrayList.get(id);
    }

        public Reimbursement getReimbursementById ( int id){
            Reimbursement[] reimbursements = new Reimbursement[0];
            for (Reimbursement reimbursement : reimbursements) {
                if (reimbursement.getId() == id) {
                    return reimbursement;
                }
            }
            return null;
        }
        public ArrayList<Reimbursement> getReimbursementByAuthor(int userId) {
            List<Reimbursement> userReimbursements = new ArrayList<>();
            Reimbursement[] reimbursements = new Reimbursement[0];
            for (Reimbursement reimbursement : reimbursements) {
                if (reimbursement.getAuthor() == userId || reimbursement.getResolver() == userId) {
                    userReimbursement.add(reimbursement);
                }
            }
            return (ArrayList<Reimbursement>) userReimbursements;
        }
        public Integer getReimbursementByID ( int reimbursementId){
            return null;
        }
    public void getReimbursementByStatus(Context ctx){
            try {
                String statusParam = ctx.queryParam("Status");

                Status status = Status.valueOf(statusParam);
                if (status == Status.UNDECIDED) {
                    ctx.status(HttpCode.OK);
                    ctx.json(reimbursementDAO.getPendingReimbursement());
                } else {
                    boolean b = status == Status.ALLOWED;
                    ctx.status(HttpCode.OK);
                    ctx.json(reimbursementDAO.getResolvedReimbursement());
                }
            } catch (Exception e) {

                ctx.status(HttpCode.INTERNAL_SERVER_ERROR);

                if (!e.getMessage().isEmpty()) {
                    ctx.result(e.getMessage());
                }
            }
            Throwable e = null;
            e.printStackTrace();
        return reimbursementStatus;
        }

    private static Object getResolvedReimbursement() {
        return getResolvedReimbursement();
    }

    private static Object getPendingReimbursement() {
        return getPendingReimbursement();
    }


}