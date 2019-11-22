package com.datangedu.cn.Service.OperatorFa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.serviceprovider.Serviceprovider;

public interface getListSelect {
	public List<Serviceprovider> MOHuFSelect(HttpServletRequest request);
	public List<Serviceprovider> MOHuFSelectS(HttpServletRequest request);
}

