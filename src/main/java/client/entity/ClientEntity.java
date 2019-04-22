package client.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClientEntity implements Serializable{

	private static final long serialVersionUID = 9165902477233200293L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="RISK")
	private String risk;
	
	@Column(name="CREDIT_LIMIT")
	private BigDecimal creditLimit;
	
	@Column(name="INTEREST_RATE")
	private BigDecimal interestRate;

	public ClientEntity() {
		super();
	}
	
	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity clientEntity = (ClientEntity) o;
        return Objects.equals(name, clientEntity.name) &&
                Objects.equals(creditLimit, clientEntity.creditLimit) &&
                Objects.equals(interestRate, clientEntity.interestRate) &&
                Objects.equals(risk, clientEntity.risk) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creditLimit,interestRate,risk);
    }
}