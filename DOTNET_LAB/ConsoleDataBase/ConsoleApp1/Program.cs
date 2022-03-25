using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            Employee obj = new Employee();
            obj.LoginID = 7;
            //obj.Basic = 12445;
            //obj.DeptNo = 20;
            ////obj.Name = "Mr. D'Silva";
            //obj.Name = "Nirali";
            //InsertCommand(obj);

            InsertCommandWithParameters(obj);
            //InsertCommandWithStoredProcedure(obj);
            //GetASingleValue();
            //SqlDataReaderExample();
            //SqlDataReaderExample2();
            //SqlDataReaderExample3();
            //GetOneRecord(10);
            Console.ReadLine();
        }

        static void InsertCommandWithParameters(Employee e)
        {
            SqlConnection cn = new SqlConnection();

            cn.ConnectionString = @"Data Source=(localdb)\ProjectsV13;Initial Catalog=Sample;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                cmdInsert.CommandText = "insert into Registration values(@LoginID)";
                //cmdInsert.CommandText = "update employees set name = @Name, basic = @Basic, deptno = @DeptNo where empno = @EmpNo";
                //cmdInsert.CommandText = "delete from employees where empno =@EmpNo";
                // cmdInsert.CommandText = "select * from employees";
                //select * from employees where empno =@empno


                cmdInsert.Parameters.AddWithValue("@LoginID", e.LoginID);
                //cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
                //cmdInsert.Parameters.AddWithValue("@Basic", obj.Basic);
                //cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);

                //Console.WriteLine(cmdInsert.CommandText);
                cmdInsert.ExecuteNonQuery();
                Console.WriteLine("inserted");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
    }

    public class Employee
    {

        public int LoginID { get; set; }
    }
}
