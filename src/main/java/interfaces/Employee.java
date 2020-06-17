package interfaces;

public class Employee implements Measurable {

    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public double getMeasure() {
        return salary;
    }

    public double average(Measurable[] objects){
        double sum = 0;
        for(Measurable item : objects){
            sum = sum + item.getMeasure();
        }
        return sum / objects.length;
    }

    public Measurable largest(Measurable[] objects){
        Measurable theBestMeasurable = objects[0];
        Employee theBestEmployee = (Employee) objects[0];
        Employee temporaryEmployee;
        for(int i = 1; i < objects.length; i++){
            temporaryEmployee = (Employee) objects[i];
            if(theBestEmployee.getSalary() < temporaryEmployee.getSalary()){
                theBestEmployee = (Employee) objects[i];
                theBestMeasurable = objects[i];
            }
        }
        return theBestMeasurable;
    }
}
