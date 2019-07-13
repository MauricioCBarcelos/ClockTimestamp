package zaas.ClockTimestamp.controller;

import zaas.ClockTimestamp.model.bo.DateTimerFormater;

public class ControllerTimer {
	private DateTimerFormater dateTimerFormater = new DateTimerFormater();

	public String timerControllerNormal() {

		return dateTimerFormater.dateTimerFormater();
	}

	public String timerControllerTimestamp() {
		return dateTimerFormater.dateTimerFormaterTimestemp();
	}

	public String formaterDateTimeController(String value) {

		return dateTimerFormater.dateTimerFormaterTimestemp(value);
	}

}
