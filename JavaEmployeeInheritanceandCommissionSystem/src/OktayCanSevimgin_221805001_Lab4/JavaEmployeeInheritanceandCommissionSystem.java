//***************************************** OKTAY CAN SEVİMGİN 221805001 ***********************************

package JavaEmployeeInheritanceandCommissionSystem;

public class JavaEmployeeInheritanceandCommissionSystem{
    public static class InheritanceTest {
        public static void main(String[] args) {
            BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                    "Bob", "Lewis", "333-33-3333", 5000, 0.04, 300);
            
            System.out.println("Employee information obtained by getter methods and earnings:\n");
            System.out.printf("First name: %s\nLast name: %s\nSocial security number: %s\nGross sales: %.2f\nCommission rate: %.2f\nBase salary: %.2f\nEarnings: %.2f\n\n",
                    employee.getFirstName(), employee.getLastName(), employee.getSocialSecurityNumber(),
                    employee.getGrossSales(), employee.getCommissionRate(), employee.getBaseSalary(), employee.earnings());

            employee.setBaseSalary(1000);

            System.out.println("Updated employee information obtained by toString and earnings:\n");
            System.out.printf("First name: %s\nLast name: %s\nSocial security number: %s\nGross sales: %.2f\nCommission rate: %.2f\nBase salary: %.2f\nEarnings: %.2f\n",
                    employee.getFirstName(), employee.getLastName(), employee.getSocialSecurityNumber(),
                    employee.getGrossSales(), employee.getCommissionRate(), employee.getBaseSalary(), employee.earnings());
        }
    }

    static class BasePlusCommissionEmployee extends CommissionEmployee {
        private double baseSalary;

        public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                           double grossSales, double commissionRate, double baseSalary) {
            super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
            if (baseSalary < 0) {
                throw new IllegalArgumentException("Base salary must be >= 0.");
            }
            this.baseSalary = baseSalary;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public void setBaseSalary(double baseSalary) {
            if (baseSalary < 0) {
                throw new IllegalArgumentException("Base salary must be >= 0.");
            }
            this.baseSalary = baseSalary;
        }

        @Override
        public double earnings() {
            return super.earnings() + baseSalary;
        }

        @Override
        public String toString() {
            return String.format("%s\nBase Salary: %.2f\nEarnings: %.2f", super.toString(), baseSalary, earnings());
        }
    }

    static class CommissionEmployee {
        private String firstName;
        private String lastName;
        private String socialSecurityNumber;
        private double grossSales;
        private double commissionRate;

        public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
            if (grossSales < 0 || commissionRate <= 0 || commissionRate >= 1) {
                throw new IllegalArgumentException("Invalid gross sales or commission rate values.");
            }
            this.firstName = firstName;
            this.lastName = lastName;
            this.socialSecurityNumber = socialSecurityNumber;
            this.grossSales = grossSales;
            this.commissionRate = commissionRate;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getSocialSecurityNumber() {
            return socialSecurityNumber;
        }

        public double getGrossSales() {
            return grossSales;
        }

        public double getCommissionRate() {
            return commissionRate;
        }

        public void setGrossSales(double grossSales) {
            if (grossSales < 0) {
                throw new IllegalArgumentException("Gross sales must be >= 0.");
            }
            this.grossSales = grossSales;
        }

        public void setCommissionRate(double commissionRate) {
            if (commissionRate <= 0 || commissionRate >= 1) {
                throw new IllegalArgumentException("Commission rate must be > 0 and < 1.");
            }
            this.commissionRate = commissionRate;
        }

        public double earnings() {
            return grossSales * commissionRate;
        }

        @Override
        public String toString() {
            return String.format("CommissionEmployee: %s %s\nSSN: %s\nGross Sales: %.2f\nCommission Rate: %.2f",
                    firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        }
    }
}

