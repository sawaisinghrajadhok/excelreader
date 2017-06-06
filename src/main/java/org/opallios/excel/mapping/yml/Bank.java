package org.opallios.excel.mapping.yml;

public class Bank {
	private int start;
	private int end;
	
	public Bank() {}
	
	public Bank(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("bank:{ ")
				.append("start : ").append(start)
				.append(" ,end : ").append(end)
				.append(" }").toString();
	}
}
