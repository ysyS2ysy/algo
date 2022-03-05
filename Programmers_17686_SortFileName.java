package programmers_17686_SortFileName;
import java.util.*;
// 2022-03-05 3:40~
class Programmers_17686_SortFileName {
    static boolean DEBUG = true;    
    
    static class Info implements Comparable<Info> {
        String head;
        String number;
        String tail;
        public Info(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        @Override
        public int compareTo(Info o) {
        	String sm1 = this.head.toLowerCase();
        	String sm2 = o.head.toLowerCase();
            if(sm1.compareTo(sm2) == 0) {
            	int n1 = 0; int n2 = 0;
            	if("".equals(this.number)) n1 = 0;
            	else n1 = Integer.parseInt(this.number);
            	
            	if("".equals(o.number)) n2 = 0;
            	else n2 = Integer.parseInt(o.number);
            	
            	if(DEBUG) System.out.println("n1 "+n1+", n2 "+n2);
                return Integer.compare(n1, n2);
            } else {
                return sm1.compareTo(sm2);
            }
        }
    } // end of Info
    
    public static void main(String[] args) {
//		String[] ans = solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
//		String[] ans = solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
		String[] ans = solution(new String[] {"imskdfksdfk", "imskdfksdfk999", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat", "b1c1bar.jpg"});
		System.out.println(Arrays.toString(ans));
	}
    
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        // HEAD 정렬: 대소문자 구분X, 문자열 정렬
        // NUMBER 정렬: 숫자 순 정렬, 앞에 0이 있을 경우 무시
        // HEAD와 NUMBER가 같을 경우, 원래 입력순서 유지
        List<Info> info = new ArrayList<>();
        for(int i = 0; i < files.length; i++) {
            String[] res = split(files[i]);
            info.add(new Info(res[0], res[1], res[2]));
        }
        Collections.sort(info);
        
        StringBuilder sb;
        for(int i = 0; i < info.size(); i++) {
            sb = new StringBuilder();
        	sb.append(info.get(i).head).append(info.get(i).number).append(info.get(i).tail);
            answer[i] = sb.toString();
        }
        
        return answer;
    } // end of solution
    
    
    
    public static String[] split(String file) {
    	if(DEBUG) System.out.println("====================");
    	if(DEBUG) System.out.printf("파일명 : %s\n", file);
    	
    	String[] res = new String[3];
        // 앞에서부터 문자인것만 추출
    	String head = "";
    	int i = 0;
    	for (; i < file.length(); i++) {
			if(!Character.isDigit(file.charAt(i))) {
				head += file.charAt(i);
			} else {
				break;
			}
		}
    	
    	if(DEBUG) System.out.printf("head : %s\n", head);
    	
    	// 숫자 추출
    	int j = i; // i에 이어서 탐색한다.
    	String num = "";
    	for (; j < file.length(); j++) {
			if(Character.isDigit(file.charAt(j))) {
				num += file.charAt(j);
			} else {
				break;
			}
		}
    	if(DEBUG) System.out.printf("num : %s\n", num);
    	
    	// tail 추출
    	String tail = "";
    	for (int k = j; k < file.length(); k++) {
			tail += file.charAt(k);
		}
    	if(DEBUG) System.out.printf("tail : %s\n", tail);
    	
    	// res에 담기
    	res[0] = head; res[1] = num; res[2] = tail;
    	
        return res;
    } // end of headOf
    
    
} // end of class