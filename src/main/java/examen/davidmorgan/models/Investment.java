package examen.davidmorgan.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Investment {
    @JsonProperty("init_amount")
    private Integer initAmount;

    @JsonProperty("annual_investment")
    private Integer annualInvestment;

    @JsonProperty("annual_increment")
    private Integer annualIncrement;

    @JsonProperty("investment_time")
    private Integer investmentTime;

    @JsonProperty("investment_return")
    private Integer investmentReturn;
}
