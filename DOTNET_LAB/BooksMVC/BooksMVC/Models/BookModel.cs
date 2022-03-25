using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace BooksMVC.Models
{
    public class BookModel
    {
        //BookID , BookName , BookAuthor , BookPrice ) with validation
        [Required(ErrorMessage ="Please Enter Book ID")]
        public int BookID { get; set; }

        [Required(ErrorMessage = "Please Enter Book Author")]
        public string BookAuthor { get; set; }

        [Required(ErrorMessage = "Please Enter Book Name")]
        public string BookName { get; set; }

        [Required(ErrorMessage = "Please Enter Book Price")]
        public int BookPrice { get; set; }
    }
}