
/**
 * @author Izan Khan 
 * @assignment CSC212-Routine13
 * @version (10 May, 2019)
 */

import java.util.*;

public class OrderByBasicInfo implements Comparator<HealthProfile> {

	@Override
	public int compare(HealthProfile o, HealthProfile o2) {
		HealthProfile obj = new HealthProfile();
		if (obj.getHeight() == o.getHeight()) {
			if (obj.getWeight() == o.getWeight()) {
				return 0;
			} else if (obj.getWeight() > o.getWeight()) {
				return 1;
			} else
				return -1;
		} else {
			if (obj.getWeight() > o.getWeight()) {
				return 1;
			} else
				return -1;
		}
	}
}
