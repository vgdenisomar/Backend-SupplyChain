package supplychain.command.stack;

import javax.persistence.EntityManager;
import supplychain.command.stack.contract.PurchaseContract;
import supplychain.domain.dto.purchase.PurchaseDomain;
import supplychain.repository.config.SupplyChainDBConfig;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
public class SupplyChainCommandStack {

    public String savePurchase(PurchaseDomain purchaseDomain) {
        EntityManager entityManager = SupplyChainDBConfig.getInstance().getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            
            PurchaseContract purchaseContract = PurchaseContract.builder()
                    .entityManager(entityManager)
                    .purchaseDomain(purchaseDomain)
                    .build();
            
            purchaseContract.save();
            
            entityManager.getTransaction().commit();
            
            return purchaseContract.getPurchaseNumber();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

    }
}
