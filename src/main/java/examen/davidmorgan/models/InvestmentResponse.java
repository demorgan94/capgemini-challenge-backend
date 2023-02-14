package examen.davidmorgan.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InvestmentResponse {

    private int year;

    @JsonProperty("init_amount")
    private float initAmount;

    private float contribution;

    @JsonProperty("investment_return")
    private float investmentReturn;

    @JsonProperty("final_amount")
    private float finalAmount;
}
