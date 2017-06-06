package org.opallios.excel.mapping.yml;

public class Year {
	
	private int start;
	private int end;
		
	public Year() {}
	
	public Year(int start, int end) {
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
		return new StringBuffer("year:{ ")
				.append("start : ").append(start)
				.append(" ,end : ").append(end)
				.append(" }").toString();
	}
}