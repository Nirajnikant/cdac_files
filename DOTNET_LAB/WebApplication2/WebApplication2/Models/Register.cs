namespace WebApplication2.Models
{
    public class Register
    {
        [Required]  
        [EmailAddress]  
        public string Email { get; set; }  
  
        [Required]  
        [DataType(DataType.Password)]  
        public string Password { get; set; }  
  
        [Required]  
        [Display(Name ="Confirm Password")]  
        [DataType(DataType.Password)]  
        [Compare("Password",ErrorMessage ="Your password and confirm password do not match")]  
        public string ConfirmPassword { get; set; } 
    }
}
