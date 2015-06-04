package net.yasite.testinfo.entity;

import java.io.Serializable;

public class FunctionEntity implements Serializable {
	private String functionName;
	private Class activityName;
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public Class getActivityName() {
		return activityName;
	}
	public void setActivityName(Class activityName) {
		this.activityName = activityName;
	}
	
}
