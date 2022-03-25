using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HomePage.Controllers
{
    public class DefaultController : Controller
    {
        // GET: Default
        public ActionResult Index()
        {
            //ViewData["key1"] = "abc";
            //ViewData["key2"] = 10;
            //ViewBag.key3 = true;

            TempData["key4"] = "abc";
            Session["key5"] = "abc";

            return RedirectToAction("Index2");
            //return View();
        }
        public ActionResult Index2()
        {
            return View();
        }

        [ChildActionOnly]
        public ActionResult PartialView1()
        {
            return View();
        }
    }
}