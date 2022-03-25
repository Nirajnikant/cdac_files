using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practice
{
    class Program
    {
        static void Main1(string[] args)
        {
            System.Console.WriteLine("Hello World");
            System.Console.ReadLine();
        }
        static void Main2(string[] args)
        {
            Console.WriteLine("Hello World");
            Console.ReadLine();
        }
        static void Main(string[] args)
        {
            //Class1 o1;
            //o1 = new Class1();
            Class1 o1 = new Class1();
            //o1.Display();
            //o1.Display("Vikram");

            Console.WriteLine(o1.Add(10, 20));
            Console.WriteLine(o1.Add(10, 20, 30));  //positional parameters
            Console.WriteLine(o1.LocalFuncExample(100))
                ;
            //o2.Add(10,20,30);

            Console.WriteLine(o1.Add3(c: 30));  //named parameters
            Console.WriteLine(o1.Add3(b: 20, c: 30));  //named parameters
            Console.WriteLine(o1.Add3(b: 20, c: 30, a: 10));  //named parameters
            Console.WriteLine(o1.Add4(1, 2, 3, 4, 5, 6, 7, 8, 9));//params
            Console.WriteLine(o1.Add4(9));//params

            Console.ReadLine();
        }
        static void Main4()
        {
            Class2 o = new Class2();
            //o.i = 100;
            //o.i = o.i + 1;
            //o.i = ++o.i +o.i++ - --o.i - o.i--;
            //o.Seti(

            //o.Seti(o.Geti() + 1);

            o.P1 = 5;  //set
            Console.WriteLine(o.P1);  //get

            //o.P1 = ++o.P1 + o.P1++ - --o.P1 - o.P1--;
            int x;
            x = o.P1;

            //o.Seti(5);
            //Console.WriteLine(o.Geti());
            Console.ReadLine();
        }
        static void Main8()
        {
            //Class2 o = new Class2();
            //Console.WriteLine(o.P3);

            Class2 o2 = new Class2(1, "x", "y");
            o2.P4 = "a";
            o2 = null;
            //GC.Collect();

            //Console.WriteLine(o2.P3);

            Class2 o3 = new Class2();
            o3.P1 = 5;
            o3.P2 = "q";
            o3.P3 = "w";

            //object initializer
            Class2 o4 = new Class2() { P1 = 5, P2 = "q", P3 = "w" };
            Class2 o5 = new Class2 { P1 = 5, P2 = "q", P3 = "w" };

            Class2 o6 = new Class2(1, "x", "y") { P4 = "a" };

            Console.ReadLine();
        }
    }
    public class Class1
    {
        #region functions
        public void Display()
        {
            Console.WriteLine("Disp");
        }
        public void Display(string s)
        {
            Console.WriteLine("Disp" + s);
        }
        //public int Add(int a, int b)
        //{
        //    return a + b;
        //}
        //public int Add(int a, int b, int c)
        //{
        //    return a + b + c;
        //}

        //optional parameters - default values
        public int Add(int a = 0, int b = 0, int c = 0)
        {
            return a + b + c;
        }
        //public int Add2(int a , int b , int c =0 )
        //{
        //    return a + b + c;
        //}
        public int Add3(int a = 0, int b = 0, int c = 0)
        {
            return a + b + c;
        }

        //params needs to be the last parameter of the func
        //params needs an array as a parameter
        public int Add4(int i ,params int[] arr)
        {
            int result = 0;
            foreach (int item in arr)
            {
                result += item;
            }
            return result;
        }

        public int LocalFuncExample(int a)
        {
            int b = 10;
            LocalFunc2();
            return LocalFunc();

            //if this code needs to called repeatedly (eg in a loop)
            //local func can not have an access specifier (implicitly private)
            //local func can only be called from the outer func ( func which contains the local func)
            //local func can access variables defined in the outer func
            int LocalFunc()
            {
                LocalFunc2();
                return a * b * 3;
            }
            void LocalFunc2()
            {
                Console.WriteLine("in localdunc2");
                Console.WriteLine(a * b * 2);
            }
        }
        #endregion
    }
    public class Class2
    {
        public int x;

        private int i;
        public void Seti(int VALUE)
        {
            if (VALUE < 10)
                i = VALUE;
            else
                Console.WriteLine("invalid value");
            //throw new Exception("invalid value");
        }
        public int Geti()
        {
            return i;
        }

        private int p1;
        public int P1
        {
            set
            {
                if (value < 10)
                    p1 = value;
                else
                    Console.WriteLine("invalid value");
            }
            get
            {
                return p1;
            }
        }

        private string p2;
        public string P2
        {
            set
            {
                p2 = value;
            }
            get
            {
                return p2;
            }
        }
        //to do  - create a read only property

        //automatic property
        //code for get, set is automatically generated by compiler
        //private  variable also genrated by the compiler
        public string P3 { get; set; }
        public string P4 { get; set; }
        //public Class2()
        //{
        //    this.P1 = 5;
        //    this.P2 = "aa";
        //    this.P3 = "bb";
        //}
        public Class2(int P1 = 5, string P2 = "aa", string P3 = "bb")
        {
            this.P1 = P1;//property set
            //this.p1 = P1;//private variable
            this.P2 = P2;
            this.P3 = P3;
        }
        //~Class2()
        //{
        //    Console.WriteLine("des code ");
        //    Console.ReadLine();
        //}
    }
}
namespace n2
{
    public class class1
    {

    }
    namespace n3
    {
        public class class1
        {

        }

    }
}
