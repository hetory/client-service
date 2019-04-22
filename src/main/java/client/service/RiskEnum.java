package client.service;

import java.math.BigDecimal;

public enum RiskEnum {
	
    A("A", BigDecimal.ZERO),
    B("B", BigDecimal.TEN),
    C("C", new BigDecimal(20l));

	private final String risk;
    
    private final BigDecimal interestRate;

    RiskEnum(String risk, BigDecimal interestRate) {
        this.risk = risk;
        this.interestRate = interestRate;
    }

    public String getRisk() {
		return risk;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}
}
