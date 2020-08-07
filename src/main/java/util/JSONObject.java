package util;

import java.util.Map;

//此类用于做上传接口的返回值,因为layui必须使用json格式的返回值接口
public class JSONObject {
	private int code;//解析接口状态（0代表上传成功）
	private String msg;//解析提示文本
	private Map<String,Object> data;//解析数据列表
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JSONObject [code=");
		builder.append(code);
		builder.append(", msg=");
		builder.append(msg);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
