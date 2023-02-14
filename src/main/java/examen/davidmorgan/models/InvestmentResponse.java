package examen.davidmorgan.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InvestmentResponse {

    private Integer year;

    @JsonProperty("init_amount")
    private Integer initAmount;

    private Integer contribution;

    @JsonProperty("investment_return")
    private Integer investmentReturn;

    @JsonProperty("final_amount")
    private Integer finalAmount;
}
