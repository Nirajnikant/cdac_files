using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using day1_assignment;

namespace Day3_24
{
    class Program
    {
        static void Main1(string[] args)
        {
            Console.WriteLine("Enter No. of Employes : ");
            int count = Convert.ToInt32(Console.ReadLine());
            Employee[] objEmps = new Employee[count];
            for(int i = 0; i<objEmps.Length;i++)
            {
                objEmps[i] = new Employee();
                Console.WriteLine("Enter the EmpNo., Name, Dept no, Basic");
                objEmps[i].EmpNo = Convert.ToInt32(Console.ReadLine());
                objEmps[i].Name = Console.ReadLine();
                objEmps[i].DeptNo = Convert.ToInt16(Console.ReadLine());
                objEmps[i].Basic = Convert.ToDecimal(Console.ReadLine());
            }

            ListAllEmp(objEmps);

            //Max Salary
            Console.WriteLine("Highest Salary is : " + FindMaxSalary(objEmps));

            //Search
            Console.WriteLine("Enter Employee No. to be searched : ");
            int srchEmp = Convert.ToInt32(Console.ReadLine());
            srchEmployeee(srchEmp, objEmps);

           
        }

        static void Main2(string[] args)
        {
            //Jagged array
            Console.WriteLine("Enter no. of batches :");
            int batchesNum = Convert.ToInt32(Console.ReadLine());
            int[][] batches = new int[batchesNum][];

            for (int i = 0; i < batches.Length; i++)
            {
                Console.WriteLine("Enter strength in batch {0}", i + 1);
                batches[i] = new int[Convert.ToInt32(Console.ReadLine())];
            }

            Console.WriteLine("Enter Batch no to initilize student marks");
            int num = Convert.ToInt32(Console.ReadLine()) - 1;
            for (int i = 0; i < batches[num].Length; i++)
            {
                Console.WriteLine($"Enter Marks for {0} Student", i + 1);
                batches[num][i] = Convert.ToInt32(Console.ReadLine());
            }
            Console.WriteLine("Students marks");
            for (int i = 0; i < batches[num].Length; i++)
            {
                Console.WriteLine(batches[num][i]);
            }
        }

        static void Main(string[] args)
        {
            Student[] arr = new Student[1];
            for (int i = 0; i < arr.Length; i++)
            {
                Console.WriteLine("Enter the Name, Roll no, Marks");
                arr[i] = new Student(Console.ReadLine(), Convert.ToInt32(Console.ReadLine()), Convert.ToInt32(Console.ReadLine()));
            }          
        }
        private static void srchEmployeee(int srchEmp, Employee[] objEmps)
        {
            foreach (Employee e in objEmps)
            {
                if (e.EmpNo == srchEmp)
                {
                    Console.WriteLine("Employee Found " + e);
                    break;
                }
            }
        }

        private static Employee FindMaxSalary(Employee[] objEmps)
        {
            Employee max = objEmps[0];
            for (int i = 1; i < objEmps.Length; i++)
            {
                if (max.Basic < objEmps[i].Basic)
                    max = objEmps[i];
            }
            return max;
        }

        private static void ListAllEmp(Employee[] objEmps)
        {
            foreach (Employee e in objEmps)
            {
                Console.WriteLine(e);
            }
        }

        public struct Student
        {
            string name;
            int rollNo;
            decimal marks;
            public Student(string name="N/A", int rollNo=0, decimal marks=0)
            {
                this.name = name;
                this.rollNo = rollNo;
                this.marks = marks;
            }
        }
    }
}


//1.Create an array of Employee class objects
//        Accept details for all Employees
//        Display the Employee with highest Salary
//        Accept EmpNo to be searched. Display all details for that employee.



//2. CDAC has certain number of batches. each batch has certain number of students
//         accept number of batches from the user. for each batch accept number of students.
//         create an array to store mark for each student. 
//         accept the marks.
//         display the marks.

//3. Create a struct Student with the following properties. Put in appropriate validations.
//string Name
//int RollNo
//decimal Marks

//Create a parameterized constructor.

//Create an array to accept details for 5 students