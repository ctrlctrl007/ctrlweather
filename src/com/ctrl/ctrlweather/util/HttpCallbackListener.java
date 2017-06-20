package com.ctrl.ctrlweather.util;

public interface HttpCallbackListener {
	void OnFinish(String response);
	void onError(Exception e);
}
