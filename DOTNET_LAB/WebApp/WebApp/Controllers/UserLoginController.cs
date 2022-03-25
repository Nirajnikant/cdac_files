using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using WebApp.Models;

namespace WebApp.Controllers
{
    public class UserLoginController : Controller
    {
        // GET: /UserLogin/

        public ActionResult Index()
        {
            return View();
        }
        [HttpPost]
        public ActionResult Index(Enroll e)
        {

            SqlConnection cn = new SqlConnection();
            string status;
            SqlDataReader sdr;
            cn.ConnectionString = @"Data Source=(localdb)\ProjectsV13;Initial Catalog=Sample;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                //cmdInsert.CommandText = "insert into Registration values(@LoginID)";
                //cmdInsert.CommandText = "update employees set name = @Name, basic = @Basic, deptno = @DeptNo where empno = @EmpNo";
                //cmdInsert.CommandText = "delete from employees where empno =@EmpNo";
                cmdInsert.CommandText = "select Email,Password from Enrollment where Email=@Email and Password=@Password";
                //select * from employees where empno =@empno


                cmdInsert.Parameters.AddWithValue("@Email", e.Email);
                cmdInsert.Parameters.AddWithValue("@Password", e.Password);

                SqlDataReader sqlDataReader = cmdInsert.ExecuteReader();
                if (sqlDataReader.Read())
                {
                    Session["Email"] = e.Email.ToString();
                    return RedirectToAction("Welcome");
                }
                else
                {
                    ViewData["Message"] = "User Login Details Failed!!";
                }
                if (e.Email.ToString() != null)
                {
                    Session["Email"] = e.Email.ToString();
                    status = "1";
                }
                else
                {
                    status = "3";
                }
                return View();
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

            //String SqlCon = ConfigurationManager.ConnectionStrings["ConnDB"].ConnectionString;
            //SqlConnection con = new SqlConnection(SqlCon);
            //string SqlQuery = "select Email,Password from Enrollment where Email=@Email and Password=@Password";
            //string status;
            //con.Open();
            //SqlCommand cmd = new SqlCommand(SqlQuery, con); ;
            //cmd.Parameters.AddWithValue("@Email", e.Email);
            //cmd.Parameters.AddWithValue("@Password", e.Password);
            //SqlDataReader sdr = cmd.ExecuteReader();
            //if (sdr.Read())
            //{
            //    Session["Email"] = e.Email.ToString();
            //    return RedirectToAction("Welcome");
            //}
            //else
            //{
            //    ViewData["Message"] = "User Login Details Failed!!";
            //}
            //if (e.Email.ToString() != null)
            //{
            //    Session["Email"] = e.Email.ToString();
            //    status = "1";
            //}
            //else
            //{
            //    status = "3";
            //}
            //con.Close();
            //return View();
            //return new JsonResult { Data = new { status = status } };
        }

        [HttpGet]
        public ActionResult Welcome()
        {
            Enroll user = new Enroll();
            DataSet ds = new DataSet();

            using (SqlConnection con = new SqlConnection(@"Data Source=(localdb)\ProjectsV13;Initial Catalog=Sample;Integrated Security=True;"))
            {
                using (SqlCommand cmd = new SqlCommand("select * from Enrollment", con))
                {
                    //cmd.Parameters.AddWithValue("@status", "Get");
                    con.Open();
                    cmd.ExecuteNonQuery();
                    SqlDataAdapter sda = new SqlDataAdapter(cmd);
                    sda.Fill(ds);
                    List<Enroll> userlist = new List<Enroll>();
                    for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                    {
                        Enroll uobj = new Enroll();
                        uobj.ID = ds.Tables[0].Rows[i]["ID"].ToString();
                        uobj.FirstName = ds.Tables[0].Rows[i]["FirstName"].ToString();
                        uobj.LastName = ds.Tables[0].Rows[i]["LastName"].ToString();
                        uobj.Password = ds.Tables[0].Rows[i]["Password"].ToString();
                        uobj.Email = ds.Tables[0].Rows[i]["Email"].ToString();
                        uobj.PhoneNumber = ds.Tables[0].Rows[i]["Phone"].ToString();
                        uobj.SecurityAnwser = ds.Tables[0].Rows[i]["SecurityAnwser"].ToString();
                        uobj.Gender = ds.Tables[0].Rows[i]["Gender"].ToString();

                        userlist.Add(uobj);

                    }
                    user.Enrollsinfo = userlist;
                }
                con.Close();

            }
            return View(user);
        }
        public ActionResult Logout()
        {
            FormsAuthentication.SignOut();
            Session.Abandon();
            return RedirectToAction("Index", "UserLogin");
        }
    }
}