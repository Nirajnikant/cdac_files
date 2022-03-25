using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace HomePage.Models
{
    public class Employee
    {
        [Key]
        public int EmpNo { get; set; }

        [DataType(DataType.Text)]
        [Required(ErrorMessage = "Please enter name")]
        [StringLength(10, ErrorMessage = "{0} cannot exceed {1} characters. ")]
        public string Name { get; set; }

        [Range(1000, 50000, ErrorMessage = "Please enter values between 1000-50000")]
        [MaxLength(6), MinLength(4)]
        [Display(Name = "Salary")]
        [DataType(DataType.Currency)]
        public decimal Basic { get; set; }
        public short DeptNo { get; set; }
        [ScaffoldColumn(false)] //this will not generate scafolding for below code in views --- not shown in view
        public string Dummy { get; set; }
 
        public string EmailId { get; set; }
    }
}