package school;

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher: " + getName() + ", Age: " + getAge() + ", Subject: " + subject);
    }

    // Method Overloading
    public void teach() {
        System.out.println(getName() + " is teaching " + subject);
    }

    public void teach(String topic) {
        System.out.println(getName() + " is teaching " + topic + " in " + subject);
    }
}
