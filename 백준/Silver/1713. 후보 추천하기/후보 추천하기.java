import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student {
    int num;
    int like;
    int seq;

    Student(int num, int like, int seq){
        this.num = num;
        this.like = like;
        this.seq = seq;
    }
}
public class Main {
    static int N, T;
    static List<Student> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= T; i++) {
            int x = Integer.parseInt(st.nextToken());
            boolean exist = false;
            
            for(Student student : list) {
                if(student.num == x) {
                    student.like++;
                    exist = true;
                    break;
                }
            }
            
            if(!exist) {
                if(list.size() < N) list.add(new Student(x, 1, i));
                else {
                    int remove = 0;
                    
                    for(int j = 1; j < list.size(); j++) {
                        Student current = list.get(j);
                        Student target = list.get(remove);
                        
                        if(current.like < target.like) remove = j;
                        else if(current.like == target.like) {
                            if(current.seq < target.seq) remove = j;
                        }
                    }
                    
                    list.remove(remove);
                    list.add(new Student(x, 1, i));
                }
            }
        }
        
        Collections.sort(list, (a, b) -> a.num - b.num);
        StringBuilder sb = new StringBuilder();
        for(Student student : list) {
            sb.append(student.num).append(" ");
        }
        System.out.print(sb.toString());
    }

}
