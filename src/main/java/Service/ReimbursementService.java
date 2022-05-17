package Service;

import Model.Reimbursement;

import java.util.ArrayList;

public class ReimbursementService {
    ArrayList<Reimbursement> reimbursementArrayList;
    private Reimbursement[] reimbursements;
    private String updateStatus;

    public void update(Reimbursement unprocessedReimbursement, int resolverID, Reimbursement.Status updatedStatus){
        for (Reimbursement reimbursement : reimbursements) {
            if (reimbursement.getId() == unprocessedReimbursement.getID()) {
                reimbursement.setResolver(resolverID);
                reimbursement.setStatus(updateStatus);
                return;
            }
        }
        throw new RuntimeException("There was an error processing this reimbursement, please try again!");
    }
    public void submitReimbursement (Reimbursement reimbursementToBeSubmitted){
        Reimbursement latestReimbursement = reimbursements.get(reimbursements.size()-1);
        int id = latestReimbursement.getId() +1;
        reimbursementToBeSubmitted.setId(id);
        reimbursementToBeSubmitted.setStatus(Status.PENDING);
        reimbursements.add(reimbursementToBeSubmitted);

    }
    public List<Reimbursement> getResolvedReimbursements() {
        List<Reimbursement> resolvedReimbursements = new ArrayList<>();

        for (Reimbursement reimbursement :reimbursements){
            if(reimbursement.getStatus() == Status.Approved || reimbursement.getStatus() == Status.Denied){
                resolvedReimbursements.add(reimbursement);
            }
        }
        return resolvedReimbursements;
    }
    public List<Reimbursement> getResolvedReimbursements() {
        List<Reimbursement> resolvedReimbursements = new ArrayList<>();

        for (Reimbursement reimbursement :reimbursements){
            if(reimbursement.getStatus() == Status.Pending){
                pendingReimbursements.add(reimbursement);
            }
        }
        return pendingReimbursements;
    }
   public Reimbursement getReimbursementById(int id){
        for (Reimbursement reimbursement : reimbursements){
            if (reimbursement.getId() == id){
                return reimbursement;
            }
        }
        return null;
   }
   public List<Reimbursements> getReimbursementsByAuthor(int userId) {
        List<Reimbursement> userReimbursements = new ArrayList<>();

        for (Reimbursement r : reimbursements) {
            if(r.getAuthor() == userId || r.getResolver() == userId) {
                userReimbursements.add(r);
            }
        }
        return userReimbursements;
   }

}
