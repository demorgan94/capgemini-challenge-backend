package examen.davidmorgan.controllers;

import examen.davidmorgan.models.Investment;
import examen.davidmorgan.models.InvestmentResponse;
import examen.davidmorgan.services.InvestmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InvestmentController {

    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @PostMapping("/investment")
    public ResponseEntity<List<InvestmentResponse>> calculateInvestment(@RequestBody Investment investment) {
        Optional<List<InvestmentResponse>> _response = Optional.ofNullable(investmentService.calculateInvestment(investment));

        return _response.map(investmentResponse -> ResponseEntity.ok().body(investmentResponse))
                .orElse(ResponseEntity.internalServerError().build());
    }

    @PostMapping("/profit")
    public ResponseEntity<Float> calculateProfit(@RequestBody List<InvestmentResponse> investmentResponses) {
        Optional<Float> _profit = Optional.ofNullable(investmentService.calculateProfit(investmentResponses));

        return _profit.map(profit -> ResponseEntity.ok().body(profit))
                .orElse(ResponseEntity.internalServerError().build());
    }

}
