public class Passenger {
    private int passengerNo;
    private String PassengerName;
    private int Grade;
    private int Age;

    public Passenger(int passengerNo, String passengerName, int grade, int age) {
        this.passengerNo = passengerNo;
        PassengerName = passengerName;
        Grade = grade;
        Age = age;
    }

    public int getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(int passengerNo) {
        this.passengerNo = passengerNo;
    }

    public String getPassengerName() {
        return PassengerName;
    }

    public void setPassengerName(String passengerName) {
        PassengerName = passengerName;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Passenger [\npassengerNo=" + passengerNo + "\n, PassengerName=" + PassengerName + ",\n Grade=" + Grade
                + ",\n Age=" + Age + "]\n";
    }


}
