import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class HotelList {
	public HotelList() {
		String[] keywords = {"class", "a", "controls", "objects", "tradeoff", "need", "made", "time", "Generally"};
		int[] hotels = {2, 1, 1, 2, 1, 2, 2, 2, 2, 1, 1, 2};
		String[] reviews = {"c b", "a, b", "as, b ser", "as, d c"};
		
		int[] res = HotelListRating(keywords, hotels, reviews);
		for (int i=0; i<res.length; i++)
			System.out.println(res[i]);
	}

	public int[] HotelListRating(String[] keywords, int[] hotelIds, String[] reviews) {
		Map<Integer, Integer> hmHotelRating = new HashMap<>();
		HashSet<String> hsKeywords = new HashSet<String>();
		for (int i=0; i<keywords.length; i++)
			hsKeywords.add(keywords[i].toLowerCase());
		for (int i=0; i<reviews.length; i++) {
			if (!hmHotelRating.containsKey(hotelIds[i]))
				hmHotelRating.put(hotelIds[i], 0);
			int b = 0, e = 0;
			while (e<reviews[i].length()) {
				while (e<reviews[i].length() && !" ,.".contains(String.valueOf(reviews[i].charAt(e))))
					e++;
				String s = reviews[i].substring(b, e);
				if (hsKeywords.contains(s))
					hmHotelRating.replace(hotelIds[i], hmHotelRating.get(hotelIds[i])+1);
				while (e<reviews[i].length() && " ,.".contains(String.valueOf(reviews[i].charAt(e))))
					e++;
				b = e;
			}
		}
	    List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
	    list.addAll(hmHotelRating.entrySet());
	    list.sort((o1, o2)-> (o1.getValue()==o2.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue())));
		int[] res = new int[list.size()];
	    for (int i=0; i<list.size(); i++)
	    	res[i] = list.get(i).getKey();
	    return res;
	}
}
