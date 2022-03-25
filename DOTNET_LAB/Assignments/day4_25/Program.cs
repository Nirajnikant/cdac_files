using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using day1_assignment;

namespace day4_25
{
    class Program
    {
        
        #region Collections
        static void Main1(string[] args)
        {
            Dictionary<int, Employee> objEmp = new Dictionary<int, Employee>();
            Console.WriteLine("Enter No. of EMployee");
            int count = Convert.ToInt32(Console.ReadLine());
            for(int i=0; i<count;i++)
            {
                Console.WriteLine("Enter Employee no");
                int eNo = Convert.ToInt32(Console.ReadLine());
                Employee e = AddEmpData(eNo);
                objEmp.Add(eNo, e);
            }
            
            foreach(KeyValuePair<int, Employee> emp in objEmp)
            {
                Console.WriteLine(emp);
            }

            Console.WriteLine("Highest Salary is : " + FindMaxSalary(objEmp));

            Console.WriteLine("Enter Employee No. to be searched : ");
            int srchEmp = Convert.ToInt32(Console.ReadLine());
            //srchEmployeee(srchEmp, objEmps);
            if (objEmp.ContainsKey(srchEmp))
            {
                Console.WriteLine(objEmp[srchEmp]);
            }
            else
                Console.WriteLine("Not Found");
        }

        static void Main2(string[] args)
        {
            Employee[] emp = new Employee[2];
            emp[0] = new Employee(1,"Niraj",156000,101);
            emp[1] = new Employee(2, "Arun", 146000, 102);

            Console.WriteLine("Array Converted to list");
            List<Employee> empList = emp.ToList();
            Console.WriteLine(String.Join("\n", empList));

            Employee[] emparrConverted = empList.ToArray();
            Console.WriteLine("\nList Converted to Array");
            foreach(Employee e in emparrConverted)
            {
                Console.WriteLine(e);
            }
        }
        #endregion

        #region Lambdas
        //Write lambdas for the following functions :
        //1. decimal SimpleInterest(decimal P, decimal N, decimal R) -> returns calculated SimpleInterest
        //2. bool IsGreater(int a, int b) -> returns true if a is > b
        //3. decimal GetBasic(Employee e) -> returns the Basic salary of the employee
        //4. bool IsEven(int num) -> returns true if the number is an even number
        //5. bool IsGreaterThan10000(Employee e) -> returns true if the Basic Salary is > 10000
        static void Main(string[] args)
        {
            Func<decimal, decimal, decimal, decimal> si = (p, n, r) => (p * n * r) / 100;
            Console.WriteLine(si(1000, 10, 5));
            
            Func<int, int, bool> isGreater = (a, b) => (a > b)?true:false;
            Console.WriteLine(isGreater(10,20));
            
            Employee emp = new Employee();
            Func<Employee, decimal> GetBasic = emp1 => emp1.Basic;
            Console.WriteLine(GetBasic(emp));

            Predicate<int> IsEven = num => num % 2 == 0;
            Console.WriteLine(IsEven(157));

            Predicate<Employee> IsGreaterThan10000 = e => e.Basic > 10000;
            Console.WriteLine(IsGreaterThan10000(emp));
        }



        #endregion
        private static Employee AddEmpData(int eNo)
        {
            Employee e = new Employee();
            Console.WriteLine("Enter Employee Name, Dept no, Basic");
            e.EmpNo = eNo;
            e.Name = Console.ReadLine();
            e.DeptNo = Convert.ToInt16(Console.ReadLine());
            e.Basic = Convert.ToDecimal(Console.ReadLine());
            return e;
        }

        private static Employee FindMaxSalary(Dictionary<int, Employee> objEmps)
        {
            decimal max = 0;
            Employee maxx = new Employee();
            foreach (KeyValuePair<int, Employee> emp in objEmps)
            {
                if (emp.Value.Basic > max)
                    maxx = emp.Value;
            }
            return maxx;
        }
    }
 }