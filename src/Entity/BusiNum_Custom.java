package Entity;

public class BusiNum_Custom {
	String busi_num;
	String custom;
	public String getBusi_num() {
		return busi_num;
	}
	public void setBusi_num(String busi_num) {
		this.busi_num = busi_num;
	}
	public String getCustom() {
		return custom;
	}
	public void setCustom(String custom) {
		this.custom = custom;
	}
	/**
	 * @param busi_num
	 * @param custom
	 */
	public BusiNum_Custom(String busi_num, String custom) {
		super();
		this.busi_num = busi_num;
		this.custom = custom;
	}
	
	
}
