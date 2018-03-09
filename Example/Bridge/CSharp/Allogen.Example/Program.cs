using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using Allogen.Example.Inheritance;

namespace Allogen.Example
{
    class Program
    {
        static void Main(string[] args)
        {
            var d = new DataTypes();
            Console.WriteLine("Date is " + d.GetDate().ToString(CultureInfo.InvariantCulture));

            if (d.GetEmptyOptional() != null)
            {
                Console.WriteLine("ERROR: optional should be empty!");
            }

            if (d.GetOptionalWithValue() == null)
            {
                Console.WriteLine("ERROR: optional should NOT be empty!");
            }
            
            Console.WriteLine(d.GetString());

            var buffer = d.GetBuffer();
            Console.Write("GetBuffer: Length="+buffer.Length+", Data=[");
            foreach (var c in buffer.ToArray())
            {
                Console.Write(c + ", ");
            }
            Console.WriteLine("]");
            
//            d.SetBuffer(buffer);
            
            d.DoAsyncWithString(delegate(string result) { Console.WriteLine("Completed async: " + result); });

            // this gets called twice, once with error == 0 and once with error != 0
            d.DoAsyncWithOptional(delegate(int error, string result)
            {
                if (error != 0)
                {
                    Console.WriteLine("error = " + error);
                }
                else
                {
                    Console.WriteLine("result = " + result);
                }
            });

            d.DoAsyncWithDate((date) =>
            {
                Console.WriteLine("DoAsyncWithDate: " + date.ToString(CultureInfo.InvariantCulture));
            });
            
            d.DoAsyncWithDate(delegate(DateTime result)
            {
                Console.WriteLine("DoAsyncWithDate: " + result.ToString(CultureInfo.InvariantCulture));
            });

//            d.DoAsyncWithBuffer(delegate(MemoryStream result)
//            {
//                Console.WriteLine("DoAsyncWithBuffer: Length=" + result.Length);
//            });
            
            d.DoAsyncAndReturnString(() => "It works!");
            d.DoAsyncAndReturnDate(() => DateTime.Now);

//            List<string> list = new List<string>();
//            list.Add("Test1");
//            list.Add("Test2");
//            list.Add("Test3");
//            
//            d.SetVector(list);
//
//            foreach (var str in d.GetVector())
//            {
//                Console.WriteLine(str);
//            }

            var sc1 = new SubClass1();
            BaseClass b = sc1;
            Console.WriteLine(b.GetName());
            b.FromNonvirtualBase();
            
            Console.WriteLine(sc1.GetName());
            sc1.FromNonvirtualBase();
            sc1.DoInSubclass1();      
        }
    }
}