package test1;

import java.util.ArrayList;
import java.util.List;

public class ITimeConverterDaoImpl implements ITimeConverterDao {

	@Override
	public String convertTime(String aTime) {

		// In this arrayList we will store minutes ,hours and seconds.
		// case : Check aTime is null or not
		List<List<String>> timeList = new ArrayList<>();
		StringBuilder convertTime = new StringBuilder();
		if (aTime.equalsIgnoreCase("")) {
			System.out.println("Time is not valid");
		} else {
			// If it enters into this block that means time is not null
			// except time in HH:MM:SS format so check that format
			String timeArray[] = aTime.split(":", 3);
			if (timeArray.length != 3) {
				System.out.println("Time format is not valid");
			} else {
				// That means time format is valid
				int hours = Integer.parseInt(timeArray[0]);
				int minutes = Integer.parseInt(timeArray[1]);
				int seconds = Integer.parseInt(timeArray[2]);

				System.out.println("HH:" + hours + "MM:" + minutes + "SS:" + seconds);
				int value, rem;

				// logic for seconds
				// On the top of the clock there is a yellow lamp that blinks
				// on/off every two seconds.
				// Y-> On ; O->Off
				List<String> lampList = new ArrayList<>();
				if (seconds % 2 == 0) {
					lampList.add("Y");
				} else {
					lampList.add("O");
				}
				timeList.add(lampList);

				// convert hours and calculate
				// 0->Off ; R->On
				if (hours < 0 && hours > 24) {
					System.out.println("Hours format is not valid");
				} else {
					value = hours / 5;
					rem = hours % 5;
					List<String> hoursList = new ArrayList<>();

					// this logic for hours but for 5 hours
					if (value == 0) {
						hoursList = new ArrayList<>();
						for (int i = 0; i < 4; i++) {
							hoursList.add("O");
						}
						timeList.add(hoursList);
					} else {
						hoursList = new ArrayList<>();
						for (int i = 0; i < 4; i++) {
							if (i < value)
								hoursList.add("R");
							else
								hoursList.add("O");
						}
						timeList.add(hoursList);
					}

					// this logic for hours but for 1 hours
					if (rem == 0) {
						hoursList = new ArrayList<>();
						for (int i = 0; i < 4; i++) {
							hoursList.add("O");
						}
						timeList.add(hoursList);
					} else {
						hoursList = new ArrayList<>();
						for (int i = 0; i < 4; i++) {
							if (i < rem)
								hoursList.add("R");
							else
								hoursList.add("O");
						}
						timeList.add(hoursList);
					}
				}

				// logic for minutes
				// R ->on/first/half quarter ; O -> Off ; Y ->On 5 minutes
				if (minutes < 0 && minutes > 59) {
					System.out.println("Minutes format is not valid");
				} else {
					value = minutes / 5;
					rem = minutes % 5;

					List<String> minutesList = new ArrayList<>();

					if (value == 0) {
						minutesList = new ArrayList<>();
						for (int i = 0; i < 11; i++) {
							minutesList.add("O");
						}
						timeList.add(minutesList);
					} else {
						minutesList = new ArrayList<>();
						for (int i = 1; i <= value; i++) {
							if (i == 3 || i == 6 || value == 9) {
								minutesList.add("R");
							} else if (i < value) {
								minutesList.add("Y");
							}
						}

						for (int i = 0; i < 11 - value; i++) {
							minutesList.add("O");
						}
						timeList.add(minutesList);
					}
					// this logic for hours but for 1 minutes
					if (rem == 0) {
						minutesList = new ArrayList<>();
						for (int i = 0; i < 4; i++) {
							minutesList.add("O");
						}
						timeList.add(minutesList);
					} else {
						minutesList = new ArrayList<>();
						for (int i = 0; i < 4; i++) {
							if (i < rem)
								minutesList.add("Y");
							else
								minutesList.add("O");
						}
						timeList.add(minutesList);
					}

				}
				for (int i = 0; i < timeList.size(); i++) {
					for (int j = 0; j < timeList.get(i).size(); j++) {
						convertTime.append(timeList.get(i).get(j));
					}
					convertTime.append(";");
				}
				System.out.println(convertTime.toString());
			}
		}
		return convertTime.toString();
	}

}
