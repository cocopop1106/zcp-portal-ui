package com.skcc.cloudz.zcp.portal.management.user.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class ZcpNamespace {

	private String name;
	private NamespaceStatus status;
	private Date creationDate;
	private int userCount;

	@JsonIgnore
	private BigDecimal hardCpuRequests;
	@JsonIgnore
	private BigDecimal usedCpuRequests;
	@JsonProperty("hardCpuRequests")
	private String hardCpuRequestsString;
	@JsonProperty("usedCpuRequests")
	private String usedCpuRequestsString;
	private int cpuRequestsPercentage;

	@JsonIgnore
	private BigDecimal hardMemoryRequests;
	@JsonIgnore
	private BigDecimal usedMemoryRequests;
	@JsonProperty("hardMemoryRequests")
	private String hardMemoryRequestsString;
	@JsonProperty("usedMemoryRequests")
	private String usedMemoryRequestsString;
	private int memoryRequestsPercentage;

	@JsonIgnore
	private BigDecimal hardCpuLimits;
	@JsonIgnore
	private BigDecimal usedCpuLimits;
	@JsonProperty("hardCpuLimits")
	private String hardCpuLimitsString;
	@JsonProperty("usedCpuLimits")
	private String usedCpuLimitsString;
	private int cpuLimitsPercentage;

	@JsonIgnore
	private BigDecimal hardMemoryLimits;
	@JsonIgnore
	private BigDecimal usedMemoryLimits;
	@JsonProperty("hardMemoryLimits")
	private String hardMemoryLimitsString;
	@JsonProperty("usedMemoryLimits")
	private String usedMemoryLimitsString;
	private int memoryLimitsPercentage;

	public enum NamespaceStatus {
		active("Active"), inactive("Terminating");
		private String status;

		private NamespaceStatus(String status) {
			this.status = status;
		}

		@JsonValue
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@JsonCreator
		public static NamespaceStatus getNamespaceStatus(String status) {
			for (NamespaceStatus s : values()) {
				if (s.getStatus().equals(status)) {
					return s;
				}
			}

			throw new IllegalArgumentException("[" + status + "] is invalid");
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NamespaceStatus getStatus() {
		return status;
	}

	public void setStatus(NamespaceStatus status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getHardCpuRequests() {
		return hardCpuRequests;
	}

	public void setHardCpuRequests(BigDecimal hardCpuRequests) {
		this.hardCpuRequests = hardCpuRequests;
	}

	public BigDecimal getUsedCpuRequests() {
		return cpuToInteger(usedCpuRequestsString);
	}

	public void setUsedCpuRequests(BigDecimal usedCpuRequests) {
		this.usedCpuRequests = usedCpuRequests;
	}

	public String getHardCpuRequestsString() {
		return hardCpuRequestsString;
	}

	public void setHardCpuRequestsString(String hardCpuRequestsString) {
		this.hardCpuRequestsString = hardCpuRequestsString;
	}

	public String getUsedCpuRequestsString() {
		return usedCpuRequestsString;
	}

	public void setUsedCpuRequestsString(String usedCpuRequestsString) {
		this.usedCpuRequestsString = usedCpuRequestsString;
	}

	public int getCpuRequestsPercentage() {
		return cpuRequestsPercentage;
	}

	public void setCpuRequestsPercentage(int cpuRequestsPercentage) {
		this.cpuRequestsPercentage = cpuRequestsPercentage;
	}

	public BigDecimal getHardMemoryRequests() {
		return hardMemoryRequests;
	}

	public void setHardMemoryRequests(BigDecimal hardMemoryRequests) {
		this.hardMemoryRequests = hardMemoryRequests;
	}

	public BigDecimal getUsedMemoryRequests() {
		return memoryToInteger(usedMemoryRequestsString);
	}

	public void setUsedMemoryRequests(BigDecimal usedMemoryRequests) {
		this.usedMemoryRequests = usedMemoryRequests;
	}

	public String getHardMemoryRequestsString() {
		return hardMemoryRequestsString;
	}

	public void setHardMemoryRequestsString(String hardMemoryRequestsString) {
		this.hardMemoryRequestsString = hardMemoryRequestsString;
	}

	public String getUsedMemoryRequestsString() {
		return usedMemoryRequestsString;
	}

	public void setUsedMemoryRequestsString(String usedMemoryRequestsString) {
		this.usedMemoryRequestsString = usedMemoryRequestsString;
	}

	public int getMemoryRequestsPercentage() {
		return memoryRequestsPercentage;
	}

	public void setMemoryRequestsPercentage(int memoryRequestsPercentage) {
		this.memoryRequestsPercentage = memoryRequestsPercentage;
	}

	public BigDecimal getHardCpuLimits() {
		return hardCpuLimits;
	}

	public void setHardCpuLimits(BigDecimal hardCpuLimits) {
		this.hardCpuLimits = hardCpuLimits;
	}

	public BigDecimal getUsedCpuLimits() {
		return cpuToInteger(usedCpuLimitsString);
	}

	public void setUsedCpuLimits(BigDecimal usedCpuLimits) {
		this.usedCpuLimits = usedCpuLimits;
	}

	public String getHardCpuLimitsString() {
		return hardCpuLimitsString;
	}

	public void setHardCpuLimitsString(String hardCpuLimitsString) {
		this.hardCpuLimitsString = hardCpuLimitsString;
	}

	public String getUsedCpuLimitsString() {
		return usedCpuLimitsString;
	}

	public void setUsedCpuLimitsString(String usedCpuLimitsString) {
		this.usedCpuLimitsString = usedCpuLimitsString;
	}

	public int getCpuLimitsPercentage() {
		return cpuLimitsPercentage;
	}

	public void setCpuLimitsPercentage(int cpuLimitsPercentage) {
		this.cpuLimitsPercentage = cpuLimitsPercentage;
	}

	public BigDecimal getHardMemoryLimits() {
		return hardMemoryLimits;
	}

	public void setHardMemoryLimits(BigDecimal hardMemoryLimits) {
		this.hardMemoryLimits = hardMemoryLimits;
	}

	public BigDecimal getUsedMemoryLimits() {
		return memoryToInteger(usedMemoryLimitsString);
	}

	public void setUsedMemoryLimits(BigDecimal usedMemoryLimits) {
		this.usedMemoryLimits = usedMemoryLimits;
	}

	public String getHardMemoryLimitsString() {
		return hardMemoryLimitsString;
	}

	public void setHardMemoryLimitsString(String hardMemoryLimitsString) {
		this.hardMemoryLimitsString = hardMemoryLimitsString;
	}

	public String getUsedMemoryLimitsString() {
		return usedMemoryLimitsString;
	}

	public void setUsedMemoryLimitsString(String usedMemoryLimitsString) {
		this.usedMemoryLimitsString = usedMemoryLimitsString;
	}

	public int getMemoryLimitsPercentage() {
		return memoryLimitsPercentage;
	}

	public void setMemoryLimitsPercentage(int memoryLimitsPercentage) {
		this.memoryLimitsPercentage = memoryLimitsPercentage;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
	private BigDecimal cpuToInteger(String integer) {
		if(integer.indexOf("m") > -1)	
			return new BigDecimal(integer.replace("m", ""));
		else
			return new BigDecimal(Integer.parseInt(integer)* 1000);
	}
	
	private BigDecimal memoryToInteger(String integer) {
		if(integer.indexOf("Gi") > -1) {
			integer = integer.replace("Gi", "");
			return new BigDecimal(Integer.parseInt(integer) * 1000);
		}else {
			return new BigDecimal(integer);	
		}
		
		
	}

}


