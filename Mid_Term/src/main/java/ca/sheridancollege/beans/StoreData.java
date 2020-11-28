package ca.sheridancollege.beans;

public class StoreData {

	private String fnm;
	private String lnm;
	private long no;
	private String email;
	
	public StoreData() {
		
	}
	public StoreData(String fnm, String lnm, long no, String email) {
		this.fnm = fnm;
		this.lnm = lnm;
		this.no = no;
		this.email = email;
	}
	public String getFnm() {
		return fnm;
	}
	public void setFnm(String fnm) {
		this.fnm = fnm;
	}
	public String getLnm() {
		return lnm;
	}
	public void setLnm(String lnm) {
		this.lnm = lnm;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
