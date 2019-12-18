package com.mvcg.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("tiemStampConverter")
public class timeStampConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		try {
			date = sdf.parse(fecha);
			calendar.setTime(date);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Calendar ahora = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, ahora.get(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, ahora.get(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, ahora.get(Calendar.SECOND));
		Timestamp result = new Timestamp(calendar.getTime().getTime());
		
		
		return result;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		if(arg2 == null) {
			return null;
		}
		
		return arg2.toString();
		
	}

}
