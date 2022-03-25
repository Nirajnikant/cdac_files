using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace HomePage.Controllers
{
    public class RegistersController : Controller
    {
        // GET: Registers
        public ActionResult Index()
        {
            return View();
        }

        // GET: Registers/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Registers/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Registers/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Registers/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Registers/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Registers/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Registers/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
