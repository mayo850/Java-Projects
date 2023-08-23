
/**
 * @author Izan Khan 
 * @assignment CSC212-Routine13
 * @version (10 May, 2019)
 */

import java.util.*;

public class OrderByBMI implements Comparator<HealthProfile> {

	@Override
	public int compare(HealthProfile o, HealthProfile o2) {
		HealthProfile obj = new HealthProfile();
		if (obj.getBmi() == o.getBmi())
			return 0;
		else if (obj.getBmi() > o.getBmi())
			return 1;
		else
			return -1;
	}

}
