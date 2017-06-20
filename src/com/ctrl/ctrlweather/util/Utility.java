package com.ctrl.ctrlweather.util;

import com.ctrl.ctrlweather.model.City;
import com.ctrl.ctrlweather.model.County;
import com.ctrl.ctrlweather.model.CtrlweatherDB;
import com.ctrl.ctrlweather.model.Province;

import android.text.TextUtils;

public class Utility {
	/**
	 * �����ʹ�����������ص�ʡ������
	 */
	public synchronized static boolean handleProvinceResponse(CtrlweatherDB ctrlweatherDB, String response) {
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if (allProvinces != null && allProvinces.length > 0) {
				for (String p : allProvinces) {
					String[] array = p.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);

					// �������ݵ����ݿ�
					ctrlweatherDB.saveProvince(province);
				}
				return true;
			}
		}

		return false;
	}
	/**
	 * �����ʹ�����������ص�ĳ��ʡ��ȫ���е�����
	 */
	public synchronized static boolean handleCtiesResponse(CtrlweatherDB ctrlweatherDB, String response,int provinceId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allCities = response.split(",");
			if (allCities != null && allCities.length > 0) {
				for (String p : allCities) {
					String[] array = p.split("\\|");
					City city = new City();
					city.setProvinceId(provinceId);
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					// �������ݵ����ݿ�
					ctrlweatherDB.saveCity(city);
				}
				return true;
			}
		}

		return false;
	}
	/**
	 * �����ʹ�����������ص��ؼ�����
	 */
	public synchronized static boolean handleCountiesResponse(CtrlweatherDB ctrlweatherDB, String response,
			int cityId) {
		if (!TextUtils.isEmpty(response)) {
			String[] allCounties = response.split(",");
			if (allCounties != null && allCounties.length > 0) {
				for (String p : allCounties) {
					String[] array = p.split("\\|");
					County county = new County();
					county.setCityId(cityId);
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					// �������ݵ����ݿ�
					ctrlweatherDB.saveCounty(county);;
				}
				return true;
			}
		}

		return false;
	}

}
