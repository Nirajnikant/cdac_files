using BooksMVC.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data;

namespace BooksMVC.Controllers
{
    public class BookController : Controller
    {
        // GET: Book
        public ActionResult Index()
        {
            return View();
        }

        // GET: Book/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Book/Create
        public ActionResult AddBook()
        {

            return View();
        }

        // POST: Book/Create
        [HttpPost]
        public ActionResult AddBook(BookModel b)
        {
            try
            {
                // TODO: Add insert logic here
                SqlConnection cn = new SqlConnection();
                
                cn.ConnectionString = @"Data Source = (localdb)\ProjectsV13; Initial Catalog = BooksDB; Integrated Security = True;";
                try
                {
                    cn.Open();
                    SqlCommand cmdInsert = new SqlCommand();
                    cmdInsert.Connection = cn;
                    cmdInsert.CommandType = System.Data.CommandType.StoredProcedure;
                    cmdInsert.CommandText = "AddBook";
                    
                    cmdInsert.Parameters.AddWithValue("@BookID", b.BookID);
                    cmdInsert.Parameters.AddWithValue("@BookAuthor", b.BookAuthor);
                    cmdInsert.Parameters.AddWithValue("@BookName", b.BookName);
                    cmdInsert.Parameters.AddWithValue("@BookPrice", b.BookPrice);

                    cmdInsert.ExecuteNonQuery();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
                finally
                {
                    cn.Close();
                }
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Book/Edit/5
        //public ActionResult ShowBook()
        //{
        //    return View();
        //}

        // POST: Book/Edit/5
        [HttpPost]
        public ActionResult ShowBook()
        {
            String connectionString = @"Data Source = (localdb)\ProjectsV13; Initial Catalog = BooksDB; Integrated Security = True;";
            String sql = "SELECT * FROM BooksDB";
            SqlCommand cmd = new SqlCommand();

            var model = new List<BookModel>();
            using (SqlConnection conn = new SqlConnection(connectionString))
            {
                conn.Open();
                SqlDataReader rdr = cmd.ExecuteReader();
                while (rdr.Read())
                {
                    var book = new BookModel();
                    book.BookAuthor = (string)rdr["BookAuthor"];
                    book.BookID = (int)rdr["BookID"];
                    book.BookName = (string)rdr["BookName"];
                    book.BookPrice = (int)rdr["BookPrice"];
                }

            }

            return View(model);
        }

        // GET: Book/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Book/Delete/5
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
