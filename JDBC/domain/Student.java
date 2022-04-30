package domain;

public class Student {

    private int id;
    private String name;
    private double score;
    private int age_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getAge_id() {
        return age_id;
    }

    public void setAge_id(int age_id) {
        this.age_id = age_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", age_id=" + age_id +
                '}';
    }
}
