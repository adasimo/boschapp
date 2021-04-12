package com.adamsimon.bosch.feladat1.converters;

import com.adamsimon.bosch.feladat1.domains.Auto;
import com.adamsimon.bosch.feladat1.domains.AutoEletkor;
import com.adamsimon.bosch.feladat1.domains.Szervizkonyv;
import com.adamsimon.bosch.feladat1.forms.AdditionForm;

public class AdditionFormToSzervizkonyv extends AbstractConverter {

	@Override
	public Object convert(Object o) {
		
		AdditionForm form = (AdditionForm) o;
		
		Auto a = new Auto();
		a.setMegnevezes(form.getCar());
		
		AutoEletkor ae = new AutoEletkor();
		ae.setMegnevezes(form.getAge().getAge());
		
		Szervizkonyv sz = new Szervizkonyv();
		sz.setAuto(a);
		a.setSzervizkonyv(sz);
		sz.setEletkor(ae);
		ae.setSzervizkonyv(sz);
		sz.setGarancialis(form.getGuaranteed());
		sz.setSzerviz_kezdete(form.getServiceStart());
		sz.setSzerviz_vege(null);
		sz.setTulajdonos(form.getOwner());
		
		return sz;
	}

	
}
