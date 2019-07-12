package zaas.ClockTimestamp.model.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimerFormater {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String dateTimerFormater() {

		return simpleDateFormat.format(new Date());
	}

	public String dateTimerFormaterTimestemp() {
		// TODO Auto-generated method stub
		
		
		return ""+org.apache.poi.ss.usermodel.DateUtil.getExcelDate(new Date());
		
		
	}

}
