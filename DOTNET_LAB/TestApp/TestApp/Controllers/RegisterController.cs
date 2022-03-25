using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TestApp.Models;
using System.Data;
using System.Configuration;

namespace TestApp.Controllers
{
    public class RegisterController : Controller
    {
        // GET: Register
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Index(Register e)
        {
            if(Request.HttpMethod == "POST")
            {
                Register r = new Register();
                SqlConnection cn = new SqlConnection();
                cn.ConnectionString = @"Data Source=(localdb)\ProjectsV13;Initial Catalog=Sample;Integrated Security=True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = new SqlCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = System.Data.CommandType.StoredProcedure;
                    cmdInsert.CommandText = "Register";

                    cmdInsert.Parameters.AddWithValue("@LoginID", e.LoginID);
                    cmdInsert.Parameters.AddWithValue("@Name", e.Name);
                    cmdInsert.Parameters.AddWithValue("@Password", e.Password);
                    cmdInsert.Parameters.AddWithValue("@EmailID", e.Email);
                    cmdInsert.Parameters.AddWithValue("@Phone", e.PhoneNumber);

                    //Console.WriteLine(cmdInsert.CommandText);
                    ViewData["result"] = cmdInsert.ExecuteNonQuery();
                } catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
                finally
                {
                    cn.Close();
                }
            }
            return View();
        }
    }
}