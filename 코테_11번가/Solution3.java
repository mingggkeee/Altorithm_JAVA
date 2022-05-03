package 코테_11번가;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution3 {
	
	static class Photo implements Comparable<Photo>{
		String name;
		String city;
		String date;
		
		public Photo(String name, String city, String date) {
			this.name = name;
			this.city = city;
			this.date = date;
		}

		@Override
		public int compareTo(Photo o) {
			
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date d1 = null;
			Date d2 = null;
			try {
				d1 = fm.parse(date);
				d2 = fm.parse(o.date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			if(d1.compareTo(d2) > 0) {
				return 1;
			} else {
				return -1;
			}
		}
	}
	
	
	public static String solution(String S) {
		
		int range = S.split("\n").length;
		String[][] saved = new String[range][3];
		
		StringTokenizer st = new StringTokenizer(S, "\n");
		String answer = "";
		
		Set<String> set = new HashSet<>();
		
		int idx = 0;
		
		while(st.hasMoreElements()) {
			String temp = st.nextToken();
			String[] arr = temp.split(", ");
			
			saved[idx][0] = arr[0];
			saved[idx][1] = arr[1];
			set.add(arr[1]);
			saved[idx][2] = arr[2];
			
			idx++;
		}
		
		Object[] sets = set.toArray();
		
		for(int k=0; k<set.size(); k++) {
			
			String nowCity = sets[k].toString();
			
			PriorityQueue<Photo> pq = new PriorityQueue<>();
			
			for(int i=0; i<range; i++) {
				String name = saved[i][0];
				String city = saved[i][1];
				String date = saved[i][2];
				
				if(city.equals(nowCity)) {
					pq.add(new Photo(name, city, date));
				}
			}
			
			int cnt = 1;
			
			if(pq.size() < 10) {
				
				while(!pq.isEmpty()) {
					Photo now = pq.poll();
					
					for(int i=0; i<range; i++) {
						String name = saved[i][0];
						String city = saved[i][1];
						String date = saved[i][2];
						
						if(name.equals(now.name) && city.equals(now.city) && date.equals(now.date)) {
							
							String[] splits = name.split("\\.");
							splits[0] = city+Integer.toString(cnt++);
							splits[1] = "." + splits[1];
							saved[i][0] = splits[0] + splits[1];
							break;
						}
						
					}
				}
				
			} else {
				
				while(!pq.isEmpty()) {
					Photo now = pq.poll();
					
					for(int i=0; i<range; i++) {
						String name = saved[i][0];
						String city = saved[i][1];
						String date = saved[i][2];
						
						if(name.equals(now.name) && city.equals(now.city) && date.equals(now.date)) {
							
							String[] splits = name.split("\\.");
							if(cnt < 10) {
								splits[0] = city+"0"+Integer.toString(cnt++);
							} else {
								splits[0] = city+Integer.toString(cnt++);
							}
							splits[1] = "." + splits[1];
							saved[i][0] = splits[0] + splits[1];
							break;
						}
						
					}
				}
			}

		}
		

		for(int i=0; i<range; i++) {
			answer+=saved[i][0]+"\n";
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String input = "photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11";
		System.out.println(solution(input));
	}
	
}
