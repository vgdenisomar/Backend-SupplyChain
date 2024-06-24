package supplychain.system.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import supplychain.domain.dto.createpurchase.CreatePurchaseDomain;
import supplychain.domain.dto.purchase.PurchaseDomain;
import supplychain.system.api.dto.RequestCreatePurchase;
import supplychain.system.api.service.CommandStack;
import supplychain.system.api.service.QueryService;
import supplychain.system.dto.request.SupplyChainRequest;
import supplychain.system.dto.response.SupplyChainResponse;

/**
 *
 * @author dovelasquez@bancatlan.hn
 */
@RestController
@RequestMapping("/api/v1/supplychain")
public class SupplyChainController {

    @Autowired
    QueryService queryService;
    
    @Autowired
    CommandStack commandStack;

    @GetMapping("/create/purchase")
    public ResponseEntity<SupplyChainResponse<CreatePurchaseDomain>> getCreatePurchase() {
        return ResponseEntity.ok().body(queryService.getCreatePurchase());
    }

    @PostMapping("/create/purchase")
    public ResponseEntity<SupplyChainResponse<String>> getCreatePurchase(@RequestBody SupplyChainRequest<RequestCreatePurchase> requestCreatePurchase) {
        return ResponseEntity.ok().body(commandStack.createPurchase(requestCreatePurchase));
    }
}
