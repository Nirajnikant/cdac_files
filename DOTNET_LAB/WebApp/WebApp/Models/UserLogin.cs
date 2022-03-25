using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace WebApp.Models
{
    public class UserLogin
    {
        [Required]
        public string LoginID { get; set; }

        [Required]
        public string Password { get; set; }
    }
}