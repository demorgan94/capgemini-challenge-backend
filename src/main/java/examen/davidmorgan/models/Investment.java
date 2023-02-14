package examen.davidmorgan.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Investment {
    @JsonProperty("init_amount")
    private float initAmount;

    @JsonProperty("annual_contribution")
    private float annualContribution;

    @JsonProperty("annual_increment")
    private float annualIncrement;

    @JsonProperty("investment_time")
    private int investmentTime;

    @JsonProperty("investment_return")
    private float investmentReturn;
}
