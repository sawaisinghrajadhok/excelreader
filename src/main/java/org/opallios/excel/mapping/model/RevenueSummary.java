package org.opallios.excel.mapping.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "RevenueSummary_Monthly", uniqueConstraints={@UniqueConstraint(columnNames = { "bankId","month" })})

public class RevenueSummary implements Serializable {
	
	private static final long serialVersionUID = 3463544549692850137L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "BankId")
	private String bankId;
	
	@Column(name = "Month")
	private Date month;
	
	@Column(name = "ActiveCards")
	private long activeCards;
	
	@Column(name = "TotalTransactions")
	private long totalTransactions;
	
	@Column(name = "Total_Net_Revenue")
	private double totalNetRevenue;
	
	@Column(name = "ATM_Count")
	private long atmCount;
	
	@Column(name = "ATM_TranRevenue")
	private double atmTranRevenue;
	
	@Column(name = "ATM_OIF")
	private double atmOIF;
	
	@Column(name = "ATM_ISA")
	private double atmISA;
	
	@Column(name = "ATM_VisaTranFee")
	private double atmVisaTranFee;
	
	@Column(name = "ATM_NetRevenue")
	private double atmNetRevenue;
	
	@Column(name = "POS_Count")
	private double posCount;
	
	@Column(name = "POS_TranRevenue")
	private double posTranRevenue; 
	
	@Column(name = "POS_Interchange")
	private double posInterchange;
	
	@Column(name = "POS_OIF")
	private double posOIF;
	
	@Column(name = "POS_ISA")
	private double posISA;
	
	@Column(name = "POS_VisaTranFees")
	private double posVisaTranFee;
	
	@Column(name = "POS_NetRevenue")
	private double posNetRevenue;
	
	@Column(name = "Load_Count")
	private double loadCount;
	
	@Column(name = "Card_LoadRevenue")
	private double cardLoadRevenue;
	
	@Column(name = "Maintenance_Fees")
	private double maintenanceFees;
	
	@Column(name = "Processing_Fees")
	private double processingFees;
	
	@Column(name = "SMS_Fees")
	private double smsFees;
	
	@Column(name = "Manual_Adj")
	private double manualAdj;
	
	@Column(name = "Tier_2_Customer_Svc")
	private double tier2CustomerSvc;
	
	@Column(name = "Visa_Chargebacks")
	private double visaChargebacks;
	
	@Column(name = "Card_Sales")
	private double cardSales;
	
	@Column(name = "Active_Card_Fee")
	private double activeCardFee;
	
	@Column(name = "Registered_Card_Fee")
	private double registeredCardFee;
	
	@Column(name = "SubCompany_Set_Up_Fee")
	private double subCompanySetUpFee;
	
	@Column(name = "Inactive_Card_Fee")
	private double inactiveCardFee;
	
	@Column(name = "API_Fees")
	private double apiFees;
	
	@Column(name = "Visa_Monthly_Billing")
	private double visaMonthlyBilling;
	
	public double getTotalNetRevenue() {
		return totalNetRevenue;
	}
	public void setTotalNetRevenue(double totalNetRevenue) {
		this.totalNetRevenue = totalNetRevenue;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public Date getMonth() {
		return month;
	}
	public void setMonth(Date month) {
		this.month = month;
	}
	public long getActiveCards() {
		return activeCards;
	}
	public void setActiveCards(long activeCards) {
		this.activeCards = activeCards;
	}
	public long getTotalTransactions() {
		return totalTransactions;
	}
	public void setTotalTransactions(long totalTransactions) {
		this.totalTransactions = totalTransactions;
	}
	public long getAtmCount() {
		return atmCount;
	}
	public void setAtmCount(long atmCount) {
		this.atmCount = atmCount;
	}
	public double getAtmTranRevenue() {
		return atmTranRevenue;
	}
	public void setAtmTranRevenue(double atmTranRevenue) {
		this.atmTranRevenue = atmTranRevenue;
	}
	public double getAtmOIF() {
		return atmOIF;
	}
	public void setAtmOIF(double atmOIF) {
		this.atmOIF = atmOIF;
	}
	public double getAtmISA() {
		return atmISA;
	}
	public void setAtmISA(double atmISA) {
		this.atmISA = atmISA;
	}
	public double getAtmVisaTranFee() {
		return atmVisaTranFee;
	}
	public void setAtmVisaTranFee(double atmVisaTranFee) {
		this.atmVisaTranFee = atmVisaTranFee;
	}
	public double getAtmNetRevenue() {
		return atmNetRevenue;
	}
	public void setAtmNetRevenue(double atmNetRevenue) {
		this.atmNetRevenue = atmNetRevenue;
	}
	public double getPosCount() {
		return posCount;
	}
	public void setPosCount(double posCount) {
		this.posCount = posCount;
	}
	public double getPosTranRevenue() {
		return posTranRevenue;
	}
	public void setPosTranRevenue(double posTranRevenue) {
		this.posTranRevenue = posTranRevenue;
	}
	public double getPosInterchange() {
		return posInterchange;
	}
	public void setPosInterchange(double posInterchange) {
		this.posInterchange = posInterchange;
	}
	public double getPosOIF() {
		return posOIF;
	}
	public void setPosOIF(double posOIF) {
		this.posOIF = posOIF;
	}
	public double getPosISA() {
		return posISA;
	}
	public void setPosISA(double posISA) {
		this.posISA = posISA;
	}
	public double getPosVisaTranFee() {
		return posVisaTranFee;
	}
	public void setPosVisaTranFee(double posVisaTranFee) {
		this.posVisaTranFee = posVisaTranFee;
	}
	public double getPosNetRevenue() {
		return posNetRevenue;
	}
	public void setPosNetRevenue(double posNetRevenue) {
		this.posNetRevenue = posNetRevenue;
	}
	public double getLoadCount() {
		return loadCount;
	}
	public void setLoadCount(double loadCount) {
		this.loadCount = loadCount;
	}
	public double getCardLoadRevenue() {
		return cardLoadRevenue;
	}
	public void setCardLoadRevenue(double cardLoadRevenue) {
		this.cardLoadRevenue = cardLoadRevenue;
	}
	public double getMaintenanceFees() {
		return maintenanceFees;
	}
	public void setMaintenanceFees(double maintenanceFees) {
		this.maintenanceFees = maintenanceFees;
	}
	public double getProcessingFees() {
		return processingFees;
	}
	public void setProcessingFees(double processingFees) {
		this.processingFees = processingFees;
	}
	public double getSmsFees() {
		return smsFees;
	}
	public void setSmsFees(double smsFees) {
		this.smsFees = smsFees;
	}
	public double getManualAdj() {
		return manualAdj;
	}
	public void setManualAdj(double manualAdj) {
		this.manualAdj = manualAdj;
	}
	public double getTier2CustomerSvc() {
		return tier2CustomerSvc;
	}
	public void setTier2CustomerSvc(double tier2CustomerSvc) {
		this.tier2CustomerSvc = tier2CustomerSvc;
	}
	public double getVisaChargebacks() {
		return visaChargebacks;
	}
	public void setVisaChargebacks(double visaChargebacks) {
		this.visaChargebacks = visaChargebacks;
	}
	public double getCardSales() {
		return cardSales;
	}
	public void setCardSales(double cardSales) {
		this.cardSales = cardSales;
	}
	public double getActiveCardFee() {
		return activeCardFee;
	}
	public void setActiveCardFee(double activeCardFee) {
		this.activeCardFee = activeCardFee;
	}
	public double getRegisteredCardFee() {
		return registeredCardFee;
	}
	public void setRegisteredCardFee(double registeredCardFee) {
		this.registeredCardFee = registeredCardFee;
	}
	public double getSubCompanySetUpFee() {
		return subCompanySetUpFee;
	}
	public void setSubCompanySetUpFee(double subCompanySetUpFee) {
		this.subCompanySetUpFee = subCompanySetUpFee;
	}
	public double getInactiveCardFee() {
		return inactiveCardFee;
	}
	public void setInactiveCardFee(double inactiveCardFee) {
		this.inactiveCardFee = inactiveCardFee;
	}
	public double getApiFees() {
		return apiFees;
	}
	public void setApiFees(double apiFees) {
		this.apiFees = apiFees;
	}
	public double getVisaMonthlyBilling() {
		return visaMonthlyBilling;
	}
	public void setVisaMonthlyBilling(double visaMonthlyBilling) {
		this.visaMonthlyBilling = visaMonthlyBilling;
	}
	@Override
	public String toString() {
		return "RevenueSummary [id=" + id + ", bankId=" + bankId + ", month="
				+ month + ", activeCards=" + activeCards
				+ ", totalTransactions=" + totalTransactions + ", atmCount="
				+ atmCount + ", atmTranRevenue=" + atmTranRevenue + ", atmOIF="
				+ atmOIF + ", atmISA=" + atmISA + ", atmVisaTranFee="
				+ atmVisaTranFee + ", atmNetRevenue=" + atmNetRevenue
				+ ", posCount=" + posCount + ", posTranRevenue="
				+ posTranRevenue + ", posInterchange=" + posInterchange
				+ ", posOIF=" + posOIF + ", posISA=" + posISA
				+ ", posVisaTranFee=" + posVisaTranFee + ", posNetRevenue="
				+ posNetRevenue + ", loadCount=" + loadCount
				+ ", cardLoadRevenue=" + cardLoadRevenue + ", maintenanceFees="
				+ maintenanceFees + ", processingFees=" + processingFees
				+ ", smsFees=" + smsFees + ", manualAdj=" + manualAdj
				+ ", tier2CustomerSvc=" + tier2CustomerSvc
				+ ", visaChargebacks=" + visaChargebacks + ", cardSales="
				+ cardSales + ", activeCardFee=" + activeCardFee
				+ ", registeredCardFee=" + registeredCardFee
				+ ", subCompanySetUpFee=" + subCompanySetUpFee
				+ ", inactiveCardFee=" + inactiveCardFee + ", apiFees="
				+ apiFees + ", visaMonthlyBilling=" + visaMonthlyBilling + "]";
	}  
}