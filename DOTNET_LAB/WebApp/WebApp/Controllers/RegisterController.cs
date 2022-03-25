using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApp.Models;

namespace WebApp.Controllers
{
    public class RegisterController : Controller
    {
        // GET: Register
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Index(Register e)
        {
            SqlConnection cn = new SqlConnection();
            
            cn.ConnectionString = @"Data Source = (localdb)\ProjectsV13; Initial Catalog = Sample; Integrated Security = True";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                cmdInsert.CommandText = "insert into Registration values(@LoginID,@Password,@Name,@Email,@City,@Phone)";
                //cmdInsert.CommandText = "update employees set name = @Name, basic = @Basic, deptno = @DeptNo where empno = @EmpNo";
                //cmdInsert.CommandText = "delete from employees where empno =@EmpNo";
                // cmdInsert.CommandText = "select * from employees";
                //select * from employees where empno =@empno


                cmdInsert.Parameters.AddWithValue("@LoginID", e.LoginID);
                cmdInsert.Parameters.AddWithValue("@Password", e.Password);
                cmdInsert.Parameters.AddWithValue("@Name", e.Name);
                cmdInsert.Parameters.AddWithValue("@Email", e.Email);
                cmdInsert.Parameters.AddWithValue("@City", e.City);
                cmdInsert.Parameters.AddWithValue("@Phone", e.PhoneNumber);

                //Console.WriteLine(cmdInsert.CommandText);
                ViewData["result"] = cmdInsert.ExecuteNonQuery();
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

            return View();
        }
    }
}