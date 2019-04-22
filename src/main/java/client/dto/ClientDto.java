package client.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClientDto implements Serializable {

	private static final long serialVersionUID = -4841290405110824240L;

	@NotNull(message = "name must be not null")
    private String name;

	@NotNull(message = "limit must be not null")
    private BigDecimal limit;
	
	@NotNull(message = "risk must be not null")
    private String risk;
	
    private BigDecimal interestRate;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getLimit() {
		return limit;
	}

	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}
	
	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(name, clientDto.name) &&
                Objects.equals(limit, clientDto.limit) &&
                Objects.equals(interestRate, clientDto.interestRate) &&
                Objects.equals(risk, clientDto.risk) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, limit,interestRate,risk);
    }
}