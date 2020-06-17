package interfaces;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");

        Employee c1 = new Employee();
        c1.setName("Patryk");
        c1.setSalary(1.50);

        Employee c2 = new Employee();
        c2.setName("Bartek");
        c2.setSalary(2.0);

        Employee c3 = new Employee();
        c3.setSalary(2.5);
        c3.setName("Jola");

        Measurable p1 = new Employee("Kinga", 3.0);
        Measurable p2 = new Employee("Janek", 3.5);
        Measurable p3 = new Employee("Lucek", 4.0);

        Measurable[] obj = {p1, p2, p3};

        System.out.println(new Employee().average(obj));

        Employee nikt = (Employee) new Employee().largest(obj);
        System.out.println(nikt.getName());

        SquareSequence squares = new SquareSequence();
        double avg = average(squares, 100);
        System.out.println(avg);

        System.out.println(new DigitSequence(1729));

        IntSequence digits = new DigitSequence(1729);
        double digitsAvg = average(digits, 100);
        System.out.println(digitsAvg);

        int[] numbers = IntSequence.constant(5);
        for(int item : numbers){
            System.out.print(item +", ");
        }
        System.out.println();

        IntSequence.of(4, 6, 2, 5, 6);

        MyFunctInterface mine = (int n) ->{
            System.out.println (n +", "+ n);
            return new int[]{n,n,n,n,n};
        };

        mine.constant(6);

        Greeter greet = new Greeter(2, "Tomek");
        new Greeter(3, "Paweł");
        //greet.runTogether();
        greet.runInOrder();
    }

    public static double average(IntSequence seq, int n){
        int count = 0;
        double sum = 0;
        while(seq.hasNext() && count < n){
            count++;
            sum += seq.next();
        }
        return count == 0 ? 0 : sum / count;
    }
}
