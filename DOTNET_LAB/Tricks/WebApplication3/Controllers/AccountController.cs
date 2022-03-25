using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication3.Models;

namespace WebApplication3.Controllers
{
    public class AccountController : Controller
    {
        // GET: Account
        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(LoginModel model)
        {
            if (ModelState.IsValid)
            {
                return RedirectToAction("DashBoard", "Home");
            }
            return View();
        }

        //every public method is a action method ---accessebile by URL
        //if the access specifier is oter than public hten it is not accessable vai URL

        //[NonAction]  //--not accessible by URL
        //public int Add(int x, int y)
        //{
        //    return x + y;
        //}
    }
}