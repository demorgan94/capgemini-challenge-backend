package examen.davidmorgan.services;

import examen.davidmorgan.models.Investment;
import examen.davidmorgan.models.InvestmentResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvestmentService {

    public List<InvestmentResponse> calculateInvestment(Investment investment) {
        List<InvestmentResponse> investmentResponses = new ArrayList<>();

        for (int i = 0; i < investment.getInvestmentTime(); i++) {
            InvestmentResponse investmentResponse = new InvestmentResponse();
            investmentResponse.setYear(i+1);
            if (i == 0) {
                investmentResponse.setInitAmount((int) investment.getInitAmount());
                investmentResponse.setContribution((int) investment.getAnnualContribution());
            } else {
                investmentResponse.setInitAmount(investmentResponses.get(i-1).getFinalAmount());

                float contribution = (investmentResponses.get(i-1).getContribution() * (1 + (investment.getAnnualIncrement()/100)));
                investmentResponse.setContribution((int) contribution);
            }

            float investmentReturn = (investmentResponse.getInitAmount() + investment.getAnnualContribution()) *
                    (investment.getInvestmentReturn()/100);
            investmentResponse.setInvestmentReturn((int) investmentReturn);

            float finalAmount = (investmentResponse.getInitAmount() + investmentResponse.getContribution() + investmentReturn);
            investmentResponse.setFinalAmount((int) finalAmount);

            investmentResponses.add(investmentResponse);
        }

        return investmentResponses;
    }
}
