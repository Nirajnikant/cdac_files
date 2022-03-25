using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace day1_assignment
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Employee e = new Employee { Name = "nirali", EmpNo = 1, Basic = 100000, DeptNo = 1 };
                //e.Name = "nirali";
                //e.EmpNo = 1;
                //e.Basic = 188000;
                //e.DeptNo = 1;
                Console.WriteLine(e.Name + " : " + e.EmpNo + " : " + e.Basic + " : " + e.DeptNo);
                Console.WriteLine(e.GetNetSalary());

                Employee o1 = new Employee(1, "Amol", 123465, 10);
                Employee o2 = new Employee(1, "Amol", 15000);
                Employee o3 = new Employee(1, "Amol");
                Employee o4 = new Employee(1);
                Employee o5 = new Employee();
                Employee o6 = new Employee(1, "Amol") { Basic = 150000 };

                Console.WriteLine(o1.ToString());
                Console.WriteLine(o2.ToString());
                Console.WriteLine(o3.ToString());
                Console.WriteLine(o4.ToString());
                Console.WriteLine(o5.ToString());
                Console.WriteLine(o6.ToString());
                Console.ReadLine();
            }
            catch (InvalidBasicException ex) //all other exceptions
            {
                //Console.WriteLine("exception was thrown");
                Console.WriteLine(ex.Message);
            }
        }
    }

    public class Employee
    {
        private string name;
        public string Name
        {
            set
            {
                if (!string.IsNullOrEmpty(value))
                    name = value;
                else
                {
                    throw new InvalidBasicException("Invalid Name");
                }
                    //Console.WriteLine("invalid value");
            }
            get
            {
                return name;
            }
        }

        private int empNo;
        public int EmpNo
        {
            set
            {
                if (value > 0)
                    empNo = value;
                else
                {
                    throw new InvalidBasicException("Invalid Emp no.");
                }
                //Console.WriteLine("invalid value");
            }
            get
            {
                return empNo;
            }
        }

        private decimal basic;
        public decimal Basic
        {
            set
            {
                if (value > 20000 && value < 300000)
                    basic = value;
                else
                {
                    throw new InvalidBasicException("Invalid Salary");
                }

                //Console.WriteLine("invlaid salary");
            }
            get
            {
                return basic;
            }
        }

        private short deptNo;
        public short DeptNo
        {
            set
            {
                if (value > 0)
                    deptNo = value;
                else
                    Console.WriteLine("invalid deptno");
            }
            get
            {
                return deptNo;
            }
        }

        public decimal GetNetSalary()
        {
            return Basic - Basic * (decimal)0.02;
        }

        public Employee(short DeptNo = 1, string Name = "N/A", decimal Basic = 20001, int EmpNo = 1)
        {
            this.DeptNo = DeptNo;
            this.Name = Name;
            this.Basic = Basic;
            this.EmpNo = EmpNo;
        }

        public override string ToString()
        {
            return this.EmpNo+" : "+this.Name+" : "+this.DeptNo+" : "+this.Basic;
        }

        


        //public Employee(short DeptNo, string Name, decimal Basic)
        //{
        //    this.DeptNo = DeptNo;
        //    this.Name = Name;
        //    this.Basic = Basic;
        //}

        //public Employee(short DeptNo, string Name)
        //{
        //    this.DeptNo = DeptNo;
        //    this.Name = Name;
        //}

        //public Employee(short DeptNo)
        //{
        //    this.DeptNo = DeptNo;
        //}

        //public Employee()
        //{
        //}
    }

    public class InvalidBasicException : ApplicationException
    {
        public InvalidBasicException(string message) : base(message)
        {
            //this.Message = message;
        }
    }
}
//Create a Class Employee with the following specifications


//Properties
//----------
//string Name -> no blank names should be allowed
//int EmpNo -> must be greater than 0
//decimal Basic -> must be between some range
//short DeptNo -> must be > 0

//Methods
//-------
//decimal GetNetSalary() -> returns calculated net salary (Use any formula to get net salary based on Basic salary)


//Create overloaded constructors to accept initial values for Employee obj
//eg
//Employee o1 = new Employee(1, "Amol", 123465, 10);
//Employee o2 = new Employee(1, "Amol", 123465);
//Employee o3 = new Employee(1, "Amol");
//Employee o4 = new Employee(1);
//Employee o5 = new Employee();
