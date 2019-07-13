package zaas.ClockTimestamp.model.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateTimerFormater {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final Logger logger = Logger.getLogger(DateTimerFormater.class);

	public String dateTimerFormater() {

		return simpleDateFormat.format(new Date());
	}

	public String dateTimerFormaterTimestemp(String value) {
		try {

			if (value.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$")
					|| value.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}")) {

				if (value.trim().length() == 10) {

					Date dataConvertida = simpleDateFormat.parse(value + " 00:00:00");

					return "" + org.apache.poi.ss.usermodel.DateUtil.getExcelDate(dataConvertida);
				} else {

					Date dataConvertida = simpleDateFormat.parse(value);

					return "" + org.apache.poi.ss.usermodel.DateUtil.getExcelDate(dataConvertida);

				}

			} else {

				return "" + simpleDateFormat.format(org.apache.poi.ss.usermodel.DateUtil
						.getJavaDate(Double.parseDouble(value.replaceAll(",", "."))));
			}

		} catch (Exception e) {
			logger.error("Valor invalido: " + e.getMessage(), e);
			return "";
		}

	}

	public String dateTimerFormaterTimestemp() {

		return "" + org.apache.poi.ss.usermodel.DateUtil.getExcelDate(new Date());

	}

}
