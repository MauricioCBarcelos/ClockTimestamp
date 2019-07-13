package zaas.ClockTimestamp.model.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import zaas.ClockTimestamp.view.TelaPrincipal;

public class DateTimerFormater {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final Logger logger = Logger.getLogger(DateTimerFormater.class);

	public String dateTimerFormater() {

		return simpleDateFormat.format(new Date());
	}

	public String dateTimerFormaterTimestemp(String value) {
		try {

			if (value.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$")) {

				Date dataConvertida = simpleDateFormat.parse(value);

				return "" + org.apache.poi.ss.usermodel.DateUtil.getExcelDate(dataConvertida);

			} else {
				
				
				return "" + simpleDateFormat
						.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(Double.parseDouble(value.replaceAll(",", "."))));
			}

		} catch (Exception e) {
			logger.error("Valor invalido: " + e.getMessage(), e);
			return "";
		}

	}

	public String dateTimerFormaterTimestemp() {
		// TODO Auto-generated method stub

		return "" + org.apache.poi.ss.usermodel.DateUtil.getExcelDate(new Date());

	}

}
