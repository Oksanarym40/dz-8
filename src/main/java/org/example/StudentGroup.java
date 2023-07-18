package org.example;


        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

    public abstract class StudentGroup {
        private Student mayor;
        private List<Student> students;
        private List<String> tasks;
        private Map<Integer, Boolean> taskStatus;

        public StudentGroup(Student mayor) {
            this.mayor = mayor;
            this.students = new ArrayList<>();
            this.tasks = new ArrayList<>();
            this.taskStatus = new HashMap<>();
        }

        public Student getMayor() {
            return mayor;
        }

        public void changeMayor(Student newMayor) {
            this.mayor = newMayor;
        }

        public List<Student> getStudents() {
            return new ArrayList<>(students);
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void deleteStudent(Student student) {
            students.remove(student);
        }

        public List<String> getTasks() {
            return new ArrayList<>(tasks);
        }

        public void addTask(String task) {
            tasks.add(task);
            for (Student student : students) {
                taskStatus.put(student.getStudentId(), false);
            }
        }

        public void markTaskAsCompleted(Student student, String task) {
            if (students.contains(student) && tasks.contains(task)) {
                taskStatus.put(student.getStudentId(), true);
            }
        }


        protected abstract void customMethod();

        @Override
        public String toString() {
            return "StudentsGroup{" +
                    "mayor=" + mayor +
                    ", students=" + students +
                    ", tasks=" + tasks +
                    '}';
        }
    }

