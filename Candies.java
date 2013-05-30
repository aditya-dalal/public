import java.util.*;

public class Solution
{
    static List<Student> studentList = new ArrayList<Student>();

    public static void main (String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int totalStudents = Integer.parseInt(sc.nextLine());

        for(int i=0; i<totalStudents; i++){
            addStudentToList(Integer.parseInt(sc.nextLine()));
        }

        Collections.sort(studentList, new Comparator<Student>()
        {
            public int compare(Student s1, Student s2) {
                return s1.rank - s2.rank;
            }
        });

        int totalCandies = 0;
        for (Student student : studentList)
        {
            Student temp;
            
            if (student.left_neighbour != null && student.right_neighbour != null)
            {
                if(student.rank > student.left_neighbour.rank && student.rank > student.right_neighbour.rank)
                    temp = student.left_neighbour.candies > student.right_neighbour.candies ? student.left_neighbour : student.right_neighbour; 
                else
                    temp = student.left_neighbour.rank < student.right_neighbour.rank ? student.left_neighbour : student.right_neighbour; 
            }
            else
            {
                temp = student.left_neighbour == null ? student.right_neighbour : student.left_neighbour; 
            }
        
            student.candies = student.rank <= temp.rank ? 1 : temp.candies + 1;
            
            totalCandies += student.candies;
        }
        System.out.println(totalCandies);
    }

    private static void addStudentToList(int rank)
    {
        Student student = new Student();
        student.rank = rank;
        student.candies = 0;

        int listSize = studentList.size();
        if (listSize != 0)
        {
            student.left_neighbour = studentList.get(listSize - 1);
            studentList.get(listSize - 1).right_neighbour = student;
        }
        studentList.add(student);
    }

    public static class Student
    {
        public int rank;
        public Student left_neighbour;
        public Student right_neighbour;
        public int candies;
    }
}

