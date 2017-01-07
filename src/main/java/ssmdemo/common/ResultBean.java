package ssmdemo.common;

import java.util.List;

public class ResultBean {
	
	private Boolean success;
	private Object resultObj;
	private String msg;
	
	private Integer total;
	private List<?> rows;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Object getResultObj() {
		return resultObj;
	}
	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
